package org.gonzalez.lidar.helpers;

import org.gonzalez.lidar.atmosphere.functions.Function;

/**
 * Created by Oscar on 9/14/15.
 */
public class IntegralSolver {

    public static final int DEFAULTINTEGRATIONPRESICION = 10000;
    private Function function;

    public IntegralSolver() {
    }

    public IntegralSolver(Function function) {
        this.function = function;
    }

    public double integration(double a, double b) {
        double sum = 0;
        for (int k = 0; k < this.DEFAULTINTEGRATIONPRESICION; k++) {
            sum += this.function.getY(a + k * (b - a) / this.DEFAULTINTEGRATIONPRESICION);
        }
        sum += (this.function.getY(a) + this.function.getY(b) / 2);
        return sum * (b - a) / this.DEFAULTINTEGRATIONPRESICION;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }
}
