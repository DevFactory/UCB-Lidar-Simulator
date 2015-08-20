package atmosphere;

import atmosphere.functions.Function;
import atmosphere.gui.GraphPanel;
import com.xeiam.xchart.Chart;
import com.xeiam.xchart.QuickChart;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Oscar on 6/23/15.
 */
public class Temperature extends Function {

    private double seaLevelTemperature, temperatureLapseRate;
    private ArrayList<Integer> altitudes = new ArrayList<Integer>();
    private ArrayList<Double> results = new ArrayList<Double>();


    public Temperature(double SLT, double TLR) {
        this.seaLevelTemperature = SLT;
        this.temperatureLapseRate = TLR;
        this.results = new ArrayList<Double>();
    }

    public Temperature(ArrayList<Integer> altitudes) {
        this.altitudes = altitudes;
        this.results = new ArrayList<Double>();
        //this.seaLevelTemperature = 59.0;//Fahrenheit
        //this.seaLevelTemperature = 288.15;//Kelvin
        this.seaLevelTemperature = 15.0;//Celsius
        //this.temperatureLapseRate = -0.003566; //Rankine/Foot
        this.temperatureLapseRate = -0.00002370858424;//Celsius/Meter
    }

    public Temperature() {
        //this.seaLevelTemperature = 59.0;//Fahrenheit
        //this.seaLevelTemperature = 288.15;//Kelvin
        this.seaLevelTemperature = 15.0;//Celsius
        //this.temperatureLapseRate = -0.003566; //Rankine/Foot
        this.temperatureLapseRate = -0.00002370858424;//Celsius/Meter
        this.results = new ArrayList<Double>();
    }

    @Override
    public void plot() {
        double[] xData = new double[this.altitudes.size()];
        double[] yData = new double[this.altitudes.size()];

        for (int i = 0; i < this.altitudes.size(); i++) {
            xData[i] = this.results.get(i);
            yData[i] = this.altitudes.get(i);
        }

        Chart chart = QuickChart.getChart(getName(), "Temperatura", "Altura(Km.)", "Temperatura(Altura)", xData, yData);
        new GraphPanel(chart).displayChart(getName());
    }


    public void generate() {
        for (int i = 0; i < this.altitudes.size(); i++) {
            this.results.add(getY(this.altitudes.get(i) * 1000));
        }
    }


    @Override
    public double getY(double x) {
        //return (this.seaLevelTemperature + (this.temperatureLapseRate * x));
        return this.seaLevelTemperature - (6.5 * (x / 1000));
    }

    @Override
    public String getName() {
        return "Temperatura";
    }

    @Override
    public JPanel getPanel() {
        double[] xData = new double[this.altitudes.size()];
        double[] yData = new double[this.altitudes.size()];

        for (int i = 0; i < this.altitudes.size(); i++) {
            xData[i] = this.results.get(i);
            yData[i] = this.altitudes.get(i);
        }

        Chart chart = QuickChart.getChart(getName(), "Temperatura", "Altura(Km.)", "Temperatura(Altura)", xData, yData);
        JPanel chartPanel = new GraphPanel(chart).getChartPanel();
        return chartPanel;
    }

    public double getSeaLevelTemperature() {
        return seaLevelTemperature;
    }

    public void setSeaLevelTemperature(double seaLevelTemperature) {
        this.seaLevelTemperature = seaLevelTemperature;
    }

    public double getTemperatureLapseRate() {
        return temperatureLapseRate;
    }

    public void setTemperatureLapseRate(double temperatureLapseRate) {
        this.temperatureLapseRate = temperatureLapseRate;
    }

    public ArrayList<Integer> getAltitudes() {
        return altitudes;
    }

    public void setAltitudes(ArrayList<Integer> altitudes) {
        this.altitudes = altitudes;
    }

    public ArrayList<Double> getResults() {
        return results;
    }

    public void setResults(ArrayList<Double> results) {
        this.results = results;
    }

}
