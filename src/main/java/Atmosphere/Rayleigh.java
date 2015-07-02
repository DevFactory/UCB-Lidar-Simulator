package atmosphere;

import atmosphere.functions.Function;
import atmosphere.gui.GraphPanel;
import com.xeiam.xchart.Chart;
import com.xeiam.xchart.QuickChart;

import java.util.ArrayList;

/**
 * Created by Oscar on 6/24/15.
 */
public class Rayleigh extends Function {
    private final double AVOGADRO = 6.0221367e23;
    private final double GASMOLARCONSTANT = 8.314116;
    private final double PI = Math.PI;
    private double floorLevelTemperature = 15.0;// T0-Celsius
    private double floorLevelPressure = 1013.25;//P0-HPa
    private ArrayList<Integer> altitudes = new ArrayList<Integer>();//r
    private ArrayList<Double> pressures = new ArrayList<Double>();//
    private ArrayList<Double> temperatures = new ArrayList<Double>();//
    private ArrayList<Double> ns = new ArrayList<Double>();//
    private ArrayList<Double> refractiveIndex = new ArrayList<Double>();//
    private ArrayList<Double> sigma = new ArrayList<Double>();//
    private ArrayList<Double> alfaScatering = new ArrayList<Double>();//
    private ArrayList<Double> betaScatering = new ArrayList<Double>();//
    private double kingFactor;//
    private double wavelength = 300.0;//Lambda-nm
    private double t;//US Standard atmosphere temperature profile
    private double p;//US Standard atmosphere pressure profile
    private double rayleighExtinction;

    public Rayleigh(double floorLevelTemperature, double floorLevelPressure, ArrayList<Integer> altitudes, double wavelength) {
        this.floorLevelTemperature = floorLevelTemperature;
        this.floorLevelPressure = floorLevelPressure;
        this.altitudes = altitudes;
        this.wavelength = wavelength;
    }

    public Rayleigh() {
    }

    public Rayleigh(ArrayList<Integer> altitudes) {
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
        for (int i = 0; i < this.altitudes.size(); i++) {
            this.t = this.floorLevelTemperature - (6.5 * altitudes.get(i));
            this.temperatures.add(this.t);
            this.p = this.floorLevelPressure * (Math.pow((this.t / this.floorLevelTemperature), 5.256));
            this.pressures.add(this.p);
        }
    }

    public void computeNs() {
        double aux;
        for (int i = 0; i < this.temperatures.size(); i++) {
            aux = AVOGADRO / (22.4141 * 273.15 / 1013.25 * 1e3 * (this.pressures.get(i) / this.temperatures.get(i)));
            ns.add(i, aux);
        }
    }

    public void computeRayleighExtinction() {
        this.rayleighExtinction = this.wavelength * 1e-3;
        System.out.println("Lam" + this.rayleighExtinction);
    }

    public void computeRefractiveIndex() {
        double aux;
        for (int i = 0; i < this.temperatures.size(); i++) {
            aux = 1 + this.pressures.get(i) / 1013.25 * 288.15 / this.temperatures.get(i) * 1e-8 * (8060.77 + 2481070 / (132.274 - Math.pow(this.rayleighExtinction, -2.0)) + 17456.3 / (39.32957 - Math.pow(this.rayleighExtinction, -2.0)));
            this.refractiveIndex.add(i, aux);
        }
    }

    public void computeKingFactor() {
        double kingfa, kingfb, kingfc, kingfd;

        kingfa = (78.084 * (1.034 + 3.17e-4 / Math.pow(this.rayleighExtinction, 2.0)));
        System.out.println("Kingfa " + kingfa);
        this.kingFactor = (78.084 * (1.034 + 3.17e-4 / Math.pow(this.rayleighExtinction, 4.0)) + 20.946 * (1.096 + 1.385e-3 / Math.pow(this.rayleighExtinction, 2.0) + 1.448e-4 / Math.pow(this.rayleighExtinction, 4.0)) + 0.934 * 1.00 + 0.036 * 1.15) / (78.084 + 20.946 + 0.934 + 0.036);

        System.out.println("King Factor " + this.kingFactor);
    }

    public void computeSigma() {
        double aux;
        for (int i = 0; i < this.refractiveIndex.size(); i++) {
            aux = (8 * Math.pow(this.PI, 3.0) * Math.pow((Math.pow(this.refractiveIndex.get(i), 2.0) - 1), 2)) / (Math.pow(Math.pow(3 * (this.wavelength * 1e-9), 4.0) * this.ns.get(i), 2.0) * this.kingFactor);
            this.sigma.add(aux);
        }
        for (int i = 0; i < this.sigma.size(); i++) {
            System.out.println("Sigma" + this.sigma.get(i));
        }
    }

    public void computeAlfaScatering() {
        double aux;
        for (int i = 0; i < this.sigma.size(); i++) {
            aux = this.sigma.get(i) * this.ns.get(i) * 1e3;
            this.alfaScatering.add(i, aux);
        }
    }

    public void computeBetaScatering() {
        double aux;
        for (int i = 0; i < alfaScatering.size(); i++) {
            aux = alfaScatering.get(i) / 8.37758041;
            betaScatering.add(i, aux);
        }
    }

    public void plotAlfaScattering() {

        double[] xData = new double[this.sigma.size()];
        double[] yData = new double[this.alfaScatering.size()];
        for (int i = 0; i < this.sigma.size(); i++) {
            xData[i] = this.sigma.get(i);
        }

        for (int i = 0; i < this.alfaScatering.size(); i++) {
            yData[i] = this.alfaScatering.get(i);
        }

        Chart chart = QuickChart.getChart(getName(), "Sigma", "Alfa Scattering", "Alfa(sigma)", xData, yData);
        new GraphPanel(chart).displayChart(getName());
    }

    public void plotBetaScattering() {

        double[] xData = new double[this.alfaScatering.size()];
        double[] yData = new double[this.betaScatering.size()];

        for (int i = 0; i < this.alfaScatering.size(); i++) {
            xData[i] = this.alfaScatering.get(i);
        }

        for (int i = 0; i < this.betaScatering.size(); i++) {
            yData[i] = this.betaScatering.get(i);
        }
        Chart chart = QuickChart.getChart(getName(), "Alfa", "Beta Scattering", "Beta(Alfa)", xData, yData);
        new GraphPanel(chart).displayChart(getName());
    }

    @Override
    protected double getY(double x) {
        return 0;
    }

    @Override
    protected String getName() {
        return "Rayleigh";
    }

    @Override
    public void plot() {

    }

    public double getAVOGADRO() {
        return AVOGADRO;
    }

    public double getGASMOLARCONSTANT() {
        return GASMOLARCONSTANT;
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

    public ArrayList<Integer> getAltitudes() {
        return altitudes;
    }

    public void setAltitudes(ArrayList<Integer> altitudes) {
        this.altitudes = altitudes;
    }

    public double getWavelength() {
        return wavelength;
    }

    public void setWavelength(double wavelength) {
        this.wavelength = wavelength;
    }
}
