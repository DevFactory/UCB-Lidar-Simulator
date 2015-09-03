package atmosphere;

import atmosphere.functions.Function;
import com.xeiam.xchart.Chart;
import com.xeiam.xchart.QuickChart;
import com.xeiam.xchart.Series;
import com.xeiam.xchart.SeriesLineStyle;
import com.xeiam.xchart.SeriesMarker;
import java.awt.Color;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Oscar on 6/24/15.
 */
public class Rayleigh extends Function {

    private final double AVOGADRO = 6.0221367e23;
    private final double GASMOLARCONSTANT = 8.314116;
    private final double PI = Math.PI;
    private double floorLevelTemperature = 15.0;// T0-Celsius
    private double floorLevelPressure = 1013.25;//P0-HPa
    private Collection<Number> altitudes = new ArrayList<Number>();//r
    private Collection<Number> pressures = new ArrayList<Number>();//
    private Collection<Number> temperatures = new ArrayList<Number>();//
    private Collection<Number> ns = new ArrayList<Number>();//
    private Collection<Number> refractiveIndex = new ArrayList<Number>();//
    private Collection<Number> sigma = new ArrayList<Number>();//
    private Collection<Number> alphaScatering = new ArrayList<Number>();//
    private Collection<Number> betaScatering = new ArrayList<Number>();//
    private double kingFactor;//
    private double wavelength = 300.0;//Lambda-nm
    private double t;//US Standard atmosphere temperature profile
    private double p;//US Standard atmosphere pressure profile
    private double rayleighExtinction;

    public Rayleigh(double floorLevelTemperature, double floorLevelPressure, Collection<Number> altitudes, double wavelength) {
        this.floorLevelTemperature = floorLevelTemperature;
        this.floorLevelPressure = floorLevelPressure;
        this.altitudes = altitudes;
        this.wavelength = wavelength;
    }

    public Rayleigh() {
    }

    public Rayleigh(Collection<Number> altitudes) {
        this.altitudes = altitudes;
    }

    public void generate() {
        this.floorLevelTemperature = this.floorLevelTemperature + 273.15;
        generateTemperatureAndPressure();
        computeNs();
        computeRayleighExtinction();
        computeRefractiveIndex();
        computeKingFactor();
        computeSigma();
        computeAlfaScatering();
        computeBetaScatering();
    }

    public void generateTemperatureAndPressure() {

        for (Number altitude : altitudes) {
            this.t = this.floorLevelTemperature - (6.5 * altitude.floatValue());
            this.temperatures.add(this.t);
            this.p = this.floorLevelPressure * (Math.pow((this.t / this.floorLevelTemperature), 5.256));
            this.pressures.add(this.p);
        }
    }

    public void computeNs() {
        double aux;

        Iterator<Number> temperatureIterator = this.temperatures.iterator();
        Iterator<Number> pressureIterator = this.pressures.iterator();

        while (temperatureIterator.hasNext()) {
            float temperature = temperatureIterator.next().floatValue();
            float pressure = pressureIterator.next().floatValue();
            aux = AVOGADRO / (22.4141 * 273.15 / 1013.25 * 1e3 * (pressure / temperature));
            ns.add(aux);
        }
    }

    public void computeRayleighExtinction() {
        this.rayleighExtinction = this.wavelength * 1e-3;
        System.out.println("Lam" + this.rayleighExtinction);
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
        double kingfa, kingfb, kingfc, kingfd;

        kingfa = (78.084 * (1.034 + 3.17e-4 / Math.pow(this.rayleighExtinction, 2.0)));
        System.out.println("Kingfa " + kingfa);
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

    public void computeAlfaScatering() {
        double aux;
        Iterator<Number> sigmaIterator = this.sigma.iterator();
        Iterator<Number> nsIterator = this.ns.iterator();

        while (sigmaIterator.hasNext()) {
            float sigma = sigmaIterator.next().floatValue();
            float ns = nsIterator.next().floatValue();
            aux = sigma * ns * 1e3;
            this.alphaScatering.add(aux);
        }
    }

    public void computeBetaScatering() {
        double aux;

        for (Number number : this.alphaScatering) {
            aux = number.floatValue() / 8.37758041;
            this.betaScatering.add(aux);
        }

    }

    public Chart getAlfaScatteringChart(Color color) {
        //return QuickChart.getChart(getName(), "Sigma", "Alfa Scattering", "Alfa(sigma)", this.sigma, this.alphaScatering);
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
        series = chart.addSeries("Alpha(sigma)", this.sigma, this.alphaScatering);
        series.setLineColor(color);
        series.setMarkerColor(color);
        series.setMarker(SeriesMarker.CIRCLE);
        series.setLineStyle(SeriesLineStyle.SOLID);
        return chart;
        
    }

    public Chart getBetaScatteringChart(Color color) {
        //return QuickChart.getChart(getName(), "Alfa", "Beta Scattering", "Beta(Alfa)", this.alphaScatering, this.betaScatering);
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
        series = chart.addSeries("Beta(Alpha)", this.alphaScatering, this.betaScatering);
        series.setLineColor(color);
        series.setMarkerColor(color);
        series.setMarker(SeriesMarker.CIRCLE);
        series.setLineStyle(SeriesLineStyle.SOLID);
        return chart;
    }

//    @Override
//    public JPanel getPanel() {
//        double[] xDataA = new double[this.alphaScatering.size()];
//        double[] yDataA = new double[this.betaScatering.size()];
//
//        for (int i = 0; i < this.alphaScatering.size(); i++) {
//            xDataA[i] = this.alphaScatering.get(i);
//        }
//
//        for (int i = 0; i < this.betaScatering.size(); i++) {
//            yDataA[i] = this.betaScatering.get(i);
//        }
//
//        Chart chartA = QuickChart.getChart(getName(), "Alfa", "Beta Scattering", "Beta(Alfa)", xDataA, yDataA);
//
//        double[] xDataB = new double[this.sigma.size()];
//        double[] yDataB = new double[this.alphaScatering.size()];
//        for (int i = 0; i < this.sigma.size(); i++) {
//            xDataB[i] = this.sigma.get(i);
//        }
//
//        for (int i = 0; i < this.alphaScatering.size(); i++) {
//            yDataB[i] = this.alphaScatering.get(i);
//        }
//
//        Chart chartB = QuickChart.getChart(getName(), "Sigma", "Alfa Scattering", "Alfa(sigma)", xDataB, yDataB);
//
//
//        ArrayList<Chart> charts = new ArrayList<Chart>();
//        charts.add(chartA);
//        charts.add(chartB);
//        JPanel chartsPanel = new GraphPanel(charts).getChartMatrix();
//        return chartsPanel;
//    }

    @Override
    protected double getY(double x) {
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

    public double getAVOGADRO() {
        return AVOGADRO;
    }

    public double getGASMOLARCONSTANT() {
        return GASMOLARCONSTANT;
    }

    public double getPI() {
        return PI;
    }

    public double getFloorLevelTemperature() {
        return floorLevelTemperature;
    }

    public void setFloorLevelTemperature(double floorLevelTemperature) {
        this.floorLevelTemperature = floorLevelTemperature;
    }

    public double getFloorLevelPressure() {
        return floorLevelPressure;
    }

    public void setFloorLevelPressure(double floorLevelPressure) {
        this.floorLevelPressure = floorLevelPressure;
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
        return alphaScatering;
    }

    public void setAlfaScatering(Collection<Number> alfaScatering) {
        this.alphaScatering = alfaScatering;
    }

    public Collection<Number> getBetaScatering() {
        return betaScatering;
    }

    public void setBetaScatering(Collection<Number> betaScatering) {
        this.betaScatering = betaScatering;
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

