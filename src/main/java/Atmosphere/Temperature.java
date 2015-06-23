package Atmosphere;

import Atmosphere.Functions.Function;

/**
 * Created by Oscar on 6/23/15.
 */
public class Temperature extends Function {

    private double seaLevelTemperature, temperatureLapseRate;

    public Temperature(double SLT, double TLR) {
        this.seaLevelTemperature = SLT;
        this.temperatureLapseRate = TLR;
    }

    public Temperature() {
        //this.seaLevelTemperature = 59.0;//Fahrenheit
        this.seaLevelTemperature = 15.0;//Celsius
        //this.temperatureLapseRate = -0.003566; //Rankine/Foot
        this.temperatureLapseRate = -0.00002370858424;//Celsius/Meter
    }

    @Override
    public double getY(double x) {
        return (this.seaLevelTemperature + (this.temperatureLapseRate * x));
    }

    @Override
    public String getName() {
        return "Temperature";
    }
}
