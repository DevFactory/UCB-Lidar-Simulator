package Atmosphere;

import Atmosphere.Functions.Function;

import java.util.ArrayList;

/**
 * Created by Oscar on 6/23/15.
 */
public class Pressure extends Function {
    private ArrayList<Double> temperatures = new ArrayList<Double>();
    private double seaLevelDensity, temperatureLapseRate, altittude, seaLevelTemperature;

    public Pressure(ArrayList<Double> temperatures, double seaLevelDensity, double temperatureLapseRate, double altittude, double seaLevelTemperature) {
        this.temperatures = temperatures;
        this.seaLevelDensity = seaLevelDensity;
        this.temperatureLapseRate = temperatureLapseRate;
        this.altittude = altittude;
        this.seaLevelTemperature = seaLevelTemperature;
    }

    public Pressure() {
    }

    public Pressure(ArrayList<Double> temperatures) {
        this.temperatures = temperatures;
    }

    @Override
    public double getY(double x) {
        return 0;
    }

    @Override
    public String getName() {
        return "Pressure";
    }
}
