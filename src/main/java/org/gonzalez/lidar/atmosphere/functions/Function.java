package org.gonzalez.lidar.atmosphere.functions;

import com.xeiam.xchart.Chart;

import java.awt.*;

public abstract class Function {

    public abstract double getY(double x);

    protected abstract String getName();

    protected abstract Chart generateChart(Color color);

    protected abstract void generate();
}
