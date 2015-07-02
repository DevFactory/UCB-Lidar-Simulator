package atmosphere;

import atmosphere.functions.Function;
import atmosphere.gui.GraphPanel;
import com.xeiam.xchart.Chart;
import com.xeiam.xchart.QuickChart;

import java.util.ArrayList;

/**
 * Created by Oscar on 6/23/15.
 */
public class Pressure extends Function {
    private ArrayList<Integer> temperatures = new ArrayList<Integer>();
    private ArrayList<Double> results = new ArrayList<Double>();
    private double seaLevelPressure, temperatureLapseRate, seaLevelTemperature, altittude;
    private double constant = 5.2561;

    public Pressure(ArrayList<Integer> temperatures, double seaLevelPressure, double temperatureLapseRate, double altittude, double seaLevelTemperature) {
        this.temperatures = temperatures;
        this.seaLevelPressure = seaLevelPressure;
        this.temperatureLapseRate = temperatureLapseRate;
        this.altittude = altittude;
        this.seaLevelTemperature = seaLevelTemperature;
    }

    public Pressure() {
        //this.seaLevelPressure = 2116.2; //lb/SquareFoot
        this.seaLevelPressure = 1013.25; //hPa
        //this.temperatureLapseRate = -0.003566; //Rankine/Foot
        this.temperatureLapseRate = -0.00002370858424;//Celsius/Meter
        //this.seaLevelTemperature = 59.0;//Fahrenheit
        //this.seaLevelTemperature = 15.0;//Celsius
        this.seaLevelTemperature = 288.15;//Kelvin
    }

    public Pressure(ArrayList<Integer> temperatures) {
        this.temperatures = temperatures;
        //this.seaLevelPressure = 2116.2; //lb/SquareFoot
        this.seaLevelPressure = 1013.25; //hPa
        //this.temperatureLapseRate = -0.003566; //Rankine/Foot
        this.temperatureLapseRate = -0.00002370858424;//Celsius/Meter
        //this.seaLevelTemperature = 59.0;//Fahrenheit
        //this.seaLevelTemperature = 15.0;//Celsius
        this.seaLevelTemperature = 288.15;//Kelvin
    }

    @Override
    public void plot() {

        double[] xData = new double[this.temperatures.size()];
        double[] yData = new double[this.temperatures.size()];

        for (int i = 0; i < this.temperatures.size(); i++) {
            xData[i] = this.results.get(i);
            yData[i] = this.temperatures.get(i);
        }

        Chart chart = QuickChart.getChart(getName(), "Presion", "Altura(Km.)", "Presion(Altura)", xData, yData);
        new GraphPanel(chart).displayChart(getName());

    }

    public void generate() {
        for (int i = 0; i < this.temperatures.size(); i++) {
            this.results.add(getY(this.temperatures.get(i) * 1000));
        }
    }

    @Override
    public double getY(double x) {
        //return (this.seaLevelPressure) * Math.pow((1 + ((this.temperatureLapseRate * x) / this.seaLevelTemperature)), this.constant);
        return (this.seaLevelPressure * Math.pow((1 - (0.0065 * (x / this.seaLevelTemperature))), this.constant));
    }

    @Override
    public String getName() {
        return "Pressure";
    }

    public ArrayList<Integer> getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(ArrayList<Integer> temperatures) {
        this.temperatures = temperatures;
    }

    public double getSeaLevelPressure() {
        return seaLevelPressure;
    }

    public void setSeaLevelPressure(double seaLevelPressure) {
        this.seaLevelPressure = seaLevelPressure;
    }

    public double getTemperatureLapseRate() {
        return temperatureLapseRate;
    }

    public void setTemperatureLapseRate(double temperatureLapseRate) {
        this.temperatureLapseRate = temperatureLapseRate;
    }

    public double getAltittude() {
        return altittude;
    }

    public void setAltittude(double altittude) {
        this.altittude = altittude;
    }

    public double getSeaLevelTemperature() {
        return seaLevelTemperature;
    }

    public void setSeaLevelTemperature(double seaLevelTemperature) {
        this.seaLevelTemperature = seaLevelTemperature;
    }

}
