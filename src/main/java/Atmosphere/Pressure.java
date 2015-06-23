package Atmosphere;

import Atmosphere.Functions.Function;

import java.util.ArrayList;

/**
 * Created by Oscar on 6/23/15.
 */
public class Pressure extends Function {
    private ArrayList<Double> temperatures = new ArrayList<Double>();
    private double seaLevelPressure, temperatureLapseRate, seaLevelTemperature, altittude;
    private double constant = 5.2561;

    public Pressure(ArrayList<Double> temperatures, double seaLevelPressure, double temperatureLapseRate, double altittude, double seaLevelTemperature) {
        this.temperatures = temperatures;
        this.seaLevelPressure = seaLevelPressure;
        this.temperatureLapseRate = temperatureLapseRate;
        this.altittude = altittude;
        this.seaLevelTemperature = seaLevelTemperature;
    }

    public Pressure() {
        this.seaLevelPressure = 2116.2; //lb/SquareFoot
        //this.temperatureLapseRate = -0.003566; //Rankine/Foot
        this.temperatureLapseRate = -0.00002370858424;//Celsius/Meter
        //this.seaLevelTemperature = 59.0;//Fahrenheit
        this.seaLevelTemperature = 15.0;//Celsius

    }

    public Pressure(ArrayList<Double> temperatures) {
        this.temperatures = temperatures;
    }

    @Override
    public double getY(double x) {
        return (this.seaLevelPressure) * Math.pow((1 + ((this.temperatureLapseRate * x) / this.seaLevelTemperature)), this.constant);
    }

    @Override
    public String getName() {
        return "Pressure";
    }

    public ArrayList<Double> getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(ArrayList<Double> temperatures) {
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
