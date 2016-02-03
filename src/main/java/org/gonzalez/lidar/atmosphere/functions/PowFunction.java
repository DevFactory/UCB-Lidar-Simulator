package org.gonzalez.lidar.atmosphere.functions;

import com.xeiam.xchart.Chart;

import java.awt.*;

public class PowFunction extends Function {
    @Override
    public double getY(double x) {
        return Math.pow(x, 2);
    }

    @Override
    protected String getName() {
        return null;
    }

    @Override
    protected Chart generateChart(Color color) {
        return null;
    }

    @Override
    protected void generate() {

    }
}
