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

    private final double NA = 6.0221367e23;//avogadro's number
    private final double R = 8.314116;//Gas molar Constant
    private final double PI = Math.PI;
    private double seaLevelTemperature = 15.0;// T0-Celsius
    private double seaLevelPressure = 1013.25;//P0-HPa
    private Collection<Number> altitudes = new ArrayList<Number>();//r
    private Collection<Number> pressures = new ArrayList<Number>();//
    private Collection<Number> temperatures = new ArrayList<Number>();//
    private Collection<Number> ns = new ArrayList<Number>();//
    private Collection<Number> refractiveIndex = new ArrayList<Number>();//
    private Collection<Number> sigma = new ArrayList<Number>();//
    private Collection<Number> alphaScattering = new ArrayList<Number>();//
    private Collection<Number> betaScattering = new ArrayList<Number>();//
    private double kingFactor;//
    private double wavelength = 300.0;//Lambda-nm
    private double t;//US Standard atmosphere temperature profile
    private double p;//US Standard atmosphere pressure profile
    private double rayleighExtinction;

    public Rayleigh(double seaLevelTemperature, double seaLevelPressure, Collection<Number> altitudes, double wavelength) {
        this.seaLevelTemperature = seaLevelTemperature;
        this.seaLevelPressure = seaLevelPressure;
        this.altitudes = altitudes;
        this.wavelength = wavelength;
    }

    public Rayleigh() {
    }

    public Rayleigh(Collection<Number> altitudes) {
        this.altitudes = altitudes;
    }

    public void generate() {
        this.seaLevelTemperature = this.seaLevelTemperature + 273.15;
        generateTemperatureAndPressure();
        computeNs();
        computeRayleighExtinction();
        computeRefractiveIndex();
        computeKingFactor();
        computeSigma();
        computeAlfaScattering();
        computeBetaScattering();
    }

    public void generateTemperatureAndPressure() {

        for (Number altitude : altitudes) {
            this.t = this.seaLevelTemperature - (6.5 * altitude.floatValue());
            this.temperatures.add(this.t);
            this.p = this.seaLevelPressure * (Math.pow((this.t / this.seaLevelTemperature), 5.2561));
            this.pressures.add(this.p);
        }
    }

    public void computeNs() {
        Iterator<Number> temperatureIterator = this.temperatures.iterator();
        Iterator<Number> pressureIterator = this.pressures.iterator();
        while (temperatureIterator.hasNext()) {
            float temperature = temperatureIterator.next().floatValue();
            float pressure = pressureIterator.next().floatValue();
            ns.add(obtainNS(pressure, temperature));
        }
    }

    public double obtainNS(double pressure, double temperature) {
        return (this.NA / 22.4141) * (273.15 / 1013.25) * 1e3 * (pressure / temperature);
    }

    public void computeRayleighExtinction() {
        this.rayleighExtinction = this.wavelength * 1e-3;

    }

    public void computeRefractiveIndex() {
        double aux;

        Iterator<Number> temperatureIterator = this.temperatures.iterator();
        Iterator<Number> pressureIterator = this.pressures.iterator();

        while (temperatureIterator.hasNext()) {
            float temperature = temperatureIterator.next().floatValue();
            float pressure = pressureIterator.next().floatValue();
            aux = 1 + pressure / 1013.25 * 288.15 / temperature * 1e-8 * (8060.77 + 2481070 / (132.274 - Math.pow(this.rayleighExtinction, -2.0)) + 17456.3 / (39.32957 - Math.pow(this.rayleighExtinction, -2.0)));
            this.refractiveIndex.add(aux);
        }
    }

    public void computeKingFactor() {
        this.kingFactor = (78.084 * (1.034 + 3.17e-4 / Math.pow(this.rayleighExtinction, 4.0)) + 20.946 * (1.096 + 1.385e-3 / Math.pow(this.rayleighExtinction, 2.0) + 1.448e-4 / Math.pow(this.rayleighExtinction, 4.0)) + 0.934 * 1.00 + 0.036 * 1.15) / (78.084 + 20.946 + 0.934 + 0.036);
    }

    public void computeSigma() {
        double aux;
        Iterator<Number> refractiveIndexIterator = this.refractiveIndex.iterator();
        Iterator<Number> nsIterator = this.ns.iterator();

        while (nsIterator.hasNext()) {
            float refractiveIndex = refractiveIndexIterator.next().floatValue();
            float ns = nsIterator.next().floatValue();

            aux = (8 * Math.pow(this.PI, 3.0) * Math.pow((Math.pow(refractiveIndex, 2.0) - 1), 2)) / (Math.pow(Math.pow(3 * (this.wavelength * 1e-9), 4.0) * ns, 2.0) * this.kingFactor);
            this.sigma.add(aux);
        }
    }

    public void computeAlfaScattering() {
        double aux;
        Iterator<Number> sigmaIterator = this.sigma.iterator();
        Iterator<Number> nsIterator = this.ns.iterator();

        while (sigmaIterator.hasNext()) {
            float sigma = sigmaIterator.next().floatValue();
            float ns = nsIterator.next().floatValue();
            aux = sigma * ns * 1e3;
            this.alphaScattering.add(aux);
        }
    }

    public void computeBetaScattering() {
        double aux;

        for (Number number : this.alphaScattering) {
            aux = number.floatValue() / 8.37758041;
            this.betaScattering.add(aux);
        }

    }

    public Chart getAlfaScatteringChart(Color color) {
        //return QuickChart.getChart(getName(), "Sigma", "Alfa Scattering", "Alfa(sigma)", this.sigma, this.alphaScattering);
        Chart chart = new Chart(10, 10);
        chart.setChartTitle(getName());
        chart.setXAxisTitle("Altitude");
        chart.setYAxisTitle("Alpha Scattering");
        chart.getStyleManager().setPlotBackgroundColor(Color.WHITE);
        chart.getStyleManager().setPlotGridLinesColor(Color.GRAY);
        chart.getStyleManager().setChartBackgroundColor(Color.WHITE);
        chart.getStyleManager().setLegendBackgroundColor(Color.WHITE);
        chart.getStyleManager().setChartFontColor(Color.BLACK);
        chart.getStyleManager().setChartTitleBoxVisible(false);
        chart.getStyleManager().setPlotGridLinesVisible(true);

        Series series;
        series = chart.addSeries("Alpha(Altitude)", this.altitudes, this.alphaScattering);
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
        chart.setXAxisTitle("Altitude");
        chart.setYAxisTitle("Beta Scattering");
        chart.getStyleManager().setPlotBackgroundColor(Color.WHITE);
        chart.getStyleManager().setPlotGridLinesColor(Color.GRAY);
        chart.getStyleManager().setChartBackgroundColor(Color.WHITE);
        chart.getStyleManager().setLegendBackgroundColor(Color.WHITE);
        chart.getStyleManager().setChartFontColor(Color.BLACK);
        chart.getStyleManager().setChartTitleBoxVisible(false);
        chart.getStyleManager().setPlotGridLinesVisible(true);

        Series series;
        series = chart.addSeries("Beta(Altitude)", this.altitudes, this.betaScattering);
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

    public double getNA() {
        return NA;
    }

    public double getR() {
        return R;
    }

    public double getPI() {
        return PI;
    }

    public double getSeaLevelTemperature() {
        return seaLevelTemperature;
    }

    public void setSeaLevelTemperature(double seaLevelTemperature) {
        this.seaLevelTemperature = seaLevelTemperature;
    }

    public double getSeaLevelPressure() {
        return seaLevelPressure;
    }

    public void setSeaLevelPressure(double seaLevelPressure) {
        this.seaLevelPressure = seaLevelPressure;
    }

    public Collection<Number> getAltitudes() {
        return altitudes;
    }

    public void setAltitudes(Collection<Number> altitudes) {
        this.altitudes = altitudes;
    }

    public Collection<Number> getPressures() {
        return pressures;
    }

    public void setPressures(Collection<Number> pressures) {
        this.pressures = pressures;
    }

    public Collection<Number> getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(Collection<Number> temperatures) {
        this.temperatures = temperatures;
    }

    public Collection<Number> getNs() {
        return ns;
    }

    public void setNs(Collection<Number> ns) {
        this.ns = ns;
    }

    public Collection<Number> getRefractiveIndex() {
        return refractiveIndex;
    }

    public void setRefractiveIndex(Collection<Number> refractiveIndex) {
        this.refractiveIndex = refractiveIndex;
    }

    public Collection<Number> getSigma() {
        return sigma;
    }

    public void setSigma(Collection<Number> sigma) {
        this.sigma = sigma;
    }

    public Collection<Number> getAlfaScatering() {
        return alphaScattering;
    }

    public void setAlfaScatering(Collection<Number> alfaScatering) {
        this.alphaScattering = alfaScatering;
    }

    public Collection<Number> getBetaScattering() {
        return betaScattering;
    }

    public void setBetaScattering(Collection<Number> betaScattering) {
        this.betaScattering = betaScattering;
    }

    public double getKingFactor() {
        return kingFactor;
    }

    public void setKingFactor(double kingFactor) {
        this.kingFactor = kingFactor;
    }

    public double getWavelength() {
        return wavelength;
    }

    public void setWavelength(double wavelength) {
        this.wavelength = wavelength;
    }

    public double getT() {
        return t;
    }

    public void setT(double t) {
        this.t = t;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public double getRayleighExtinction() {
        return rayleighExtinction;
    }

    public void setRayleighExtinction(double rayleighExtinction) {
        this.rayleighExtinction = rayleighExtinction;
    }
}
