package org.gonzalez.lidar.atmosphere.functions;

import com.xeiam.xchart.Chart;
import com.xeiam.xchart.QuickChart;
import java.awt.Color;

import java.util.ArrayList;
import java.util.Collection;

public class Hyperbolic extends Function {

    private Collection<Number> xData = new ArrayList<Number>();
    private Collection<Number> yData = new ArrayList<Number>();

    @Override
    public double getY(double x) {
        return 1 / x;
    }

    @Override
    public String getName() {
        return "Hyperbolic";
    }

    @Override
    protected Chart generateChart(Color color) {
        return QuickChart.getChart(getName(), "X", "Y", "y(x)", this.xData, this.yData);
    }

    @Override
    public void generate() {
        int j = 10;
        for (int i = 0; i < 20; i++) {
            yData.add(getY(j));
            xData.add(j);
            j++;
        }
    }

    public Collection<Number> getxData() {
        return xData;
    }

    public void setxData(Collection<Number> xData) {
        this.xData = xData;
    }

    public Collection<Number> getyData() {
        return yData;
    }

    public void setyData(Collection<Number> yData) {
        this.yData = yData;
    }
}

