package atmosphere;

import atmosphere.functions.Function;
import com.xeiam.xchart.Chart;
import com.xeiam.xchart.Series;
import com.xeiam.xchart.SeriesLineStyle;
import com.xeiam.xchart.SeriesMarker;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Oscar on 6/24/15.
 */
public class Rayleigh extends Function {

    private final double NA = 6.0221367e23;//Avogadro's Number
    private final double R = 8.314116;//Gas molar Constant [J/(mol*K)
    private final double PI = Math.PI;
    private Collection<Number> altitudes = new ArrayList<Number>();//r
    private double T0;// Floor level temperature Celsius
    private double P0;//Floor level pressure P0-HPa
    private double lambda = 300.0;//Wavelength-nm

    private Collection<Number> P = new ArrayList<Number>();//
    private Collection<Number> T = new ArrayList<Number>();//
    private Collection<Number> Ns = new ArrayList<Number>();//
    private Collection<Number> refractiveIndex = new ArrayList<Number>();//
    private Collection<Number> sigma = new ArrayList<Number>();//
    private Collection<Number> alphaScattering = new ArrayList<Number>();//
    private Collection<Number> betaScattering = new ArrayList<Number>();//
    private double kingFactor;//
    private double lab;

    public Rayleigh(double T0, double P0, Collection<Number> altitudes, double lambda) {
        this.T0 = T0;
        this.P0 = P0;
        this.altitudes = altitudes;
        this.lambda = lambda;
    }

    public Rayleigh() {
        this.T0 = 15.0;
        this.P0 = 1013.25;
    }

    public Rayleigh(Collection<Number> altitudes) {
        this.altitudes = altitudes;
        this.T0 = 15.0;
        this.P0 = 1013.25;
    }

    public void generate() {
        this.T0 = this.T0 + 273.15;
        generateTemperatureAndPressure();
        computeNs();
        computeRayleighExtinction();
        computeRefractiveIndex();
        computeKingFactor();
        computeSigma();
        computeAlphaScattering();
        computeBetaScattering();
    }

    public void generateTemperatureAndPressure() {
        double t;//US Standard atmosphere temperature profile
        double p;//US Standard atmosphere pressure profile

        for (Number altitude : altitudes) {
            t = this.T0 - 6.5 * altitude.floatValue();
            this.T.add(t);

            p = this.P0 * (Math.pow((t / this.T0), 5.256));
            this.P.add(p);
            t = 0;
            p = 0;
        }
    }

    public double getNS(double pressure, double temperature) {
        double ns;
        ns = this.NA / 22.4141 * 273.15 / 1013.25 * 1e3 * (pressure / temperature);
        return ns;
    }

    public void computeNs() {
        double aux;

        Iterator<Number> temperatureIterator = this.T.iterator();
        Iterator<Number> pressureIterator = this.P.iterator();

        while (temperatureIterator.hasNext()) {
            float temperature = temperatureIterator.next().floatValue();
            float pressure = pressureIterator.next().floatValue();
            aux = getNS(pressure, temperature);
            Ns.add(aux);
        }
    }

    public void computeRayleighExtinction() {
        this.lab = this.lambda * 1e-3;
    }

    public double getN(double pressure, double temperature) {
        double n;
        n = 1 + pressure / 1013.25 * 288.15 / temperature * 1e-8 * (8060.77 + 2481070 / (132.274 - Math.pow(this.lab, -2.0)) + 17456.3 / (39.32957 - Math.pow(this.lab, -2.0)));
        return n;
    }

    public void computeRefractiveIndex() {
        double aux;
        Iterator<Number> temperatureIterator = this.T.iterator();
        Iterator<Number> pressureIterator = this.P.iterator();

        while (temperatureIterator.hasNext()) {
            float temperature = temperatureIterator.next().floatValue();
            float pressure = pressureIterator.next().floatValue();
            aux = getN(pressure, temperature);
            this.refractiveIndex.add(aux);
        }
    }

    public void computeKingFactor() {
        this.kingFactor = (78.084 * (1.034 + 3.17e-4 / Math.pow(this.lab, 2.0)) + 20.946 * (1.096 + 1.385e-3 / Math.pow(this.lab, 2.0) + 1.448e-4 / Math.pow(this.lab, 4.0)) + 0.934 * 1.00 + 0.036 * 1.15) / (78.084 + 20.946 + 0.934 + 0.036);
    }

    public double getSigma(double n, double ns) {
        double sigma;
        sigma = (((8 * (Math.pow(this.PI, 3.0))) * (Math.pow((Math.pow(n, 2.0) - 1), 2.0))) / (3 * (Math.pow((this.lambda * 1e-9), 4.0)) * Math.pow(ns, 2.0))) * this.kingFactor;
        //sigma = (8 * Math.pow(this.PI, 3.0) * Math.pow((Math.pow(n, 2.0) - 1), 2)) / (Math.pow(Math.pow(3 * (this.lambda * 1e-9), 4.0) * ns, 2.0) * this.kingFactor);
        return sigma;
    }

    public void computeSigma() {
        double aux;
        Iterator<Number> refractiveIndexIterator = this.refractiveIndex.iterator();
        Iterator<Number> nsIterator = this.Ns.iterator();

        while (nsIterator.hasNext()) {
            float n = refractiveIndexIterator.next().floatValue();
            float ns = nsIterator.next().floatValue();
            aux = getSigma(n, ns);
            this.sigma.add(aux);
        }
    }

    public void computeAlphaScattering() {
        double aux;
        Iterator<Number> sigmaIterator = this.sigma.iterator();
        Iterator<Number> nsIterator = this.Ns.iterator();

        while (sigmaIterator.hasNext()) {
            float sigma = sigmaIterator.next().floatValue();
            float ns = nsIterator.next().floatValue();
            aux = sigma * ns * 1e3;
            this.alphaScattering.add(aux);
        }
    }

    public void computeBetaScattering() {
        double aux;
        for (Number alfasca : this.alphaScattering) {
            aux = alfasca.floatValue() / 8.37758041;
            this.betaScattering.add(aux);
        }


    }

    public Chart getAlfaScatteringChart(Color color) {
        //return QuickChart.getChart(getName(), "Sigma", "Alfa Scattering", "Alfa(sigma)", this.sigma, this.alphaScattering);
        Chart chart = new Chart(10, 10);
        chart.setChartTitle(getName());
        chart.setXAxisTitle("Sigma");
        chart.setYAxisTitle("Alpha Scattering");
        chart.getStyleManager().setPlotBackgroundColor(Color.WHITE);
        chart.getStyleManager().setPlotGridLinesColor(Color.GRAY);
        chart.getStyleManager().setChartBackgroundColor(Color.WHITE);
        chart.getStyleManager().setLegendBackgroundColor(Color.WHITE);
        chart.getStyleManager().setChartFontColor(Color.BLACK);
        chart.getStyleManager().setChartTitleBoxVisible(false);
        chart.getStyleManager().setPlotGridLinesVisible(true);

        Series series;
        series = chart.addSeries("Alpha(sigma)", this.sigma, this.alphaScattering);
        series.setLineColor(color);
        series.setMarkerColor(color);
        series.setMarker(SeriesMarker.NONE);
        series.setLineStyle(SeriesLineStyle.SOLID);
        return chart;

    }

    public Chart getBetaScatteringChart(Color color) {
        //return QuickChart.getChart(getName(), "Alfa", "Beta Scattering", "Beta(Alfa)", this.alphaScattering, this.betaScattering);
        Chart chart = new Chart(10, 10);
        chart.setChartTitle(getName());
        chart.setXAxisTitle("Alpha");
        chart.setYAxisTitle("Beta Scattering");
        chart.getStyleManager().setPlotBackgroundColor(Color.WHITE);
        chart.getStyleManager().setPlotGridLinesColor(Color.GRAY);
        chart.getStyleManager().setChartBackgroundColor(Color.WHITE);
        chart.getStyleManager().setLegendBackgroundColor(Color.WHITE);
        chart.getStyleManager().setChartFontColor(Color.BLACK);
        chart.getStyleManager().setChartTitleBoxVisible(false);
        chart.getStyleManager().setPlotGridLinesVisible(true);

        Series series;
        series = chart.addSeries("Beta(Alpha)", this.alphaScattering, this.betaScattering);
        series.setLineColor(color);
        series.setMarkerColor(color);
        series.setMarker(SeriesMarker.NONE);
        series.setLineStyle(SeriesLineStyle.SOLID);
        return chart;
    }

    @Override
    public double getY(double x) {
        return 0;
    }

    @Override
    protected String getName() {
        return "Rayleigh";
    }

    @Override
    protected Chart generateChart(Color color) {
        return null;
    }

    public Collection<Number> getAlphaScattering() {
        return alphaScattering;
    }

    public void setAlphaScattering(Collection<Number> alphaScattering) {
        this.alphaScattering = alphaScattering;
    }

    public Collection<Number> getBetaScattering() {
        return betaScattering;
    }

    public void setBetaScattering(Collection<Number> betaScattering) {
        this.betaScattering = betaScattering;
    }
}

