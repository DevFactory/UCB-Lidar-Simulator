package org.gonzalez.lidar.atmosphere.functions;

import com.xeiam.xchart.Chart;
import com.xeiam.xchart.QuickChart;
import java.awt.Color;

import java.util.ArrayList;
import java.util.Collection;

public class Sigmoid extends Function {

    private Collection<Number> xData = new ArrayList<Number>();
    private Collection<Number> yData = new ArrayList<Number>();


    @Override
    public double getY(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    @Override
    public String getName() {
        return "Sigmoid";
    }

    @Override
    protected Chart generateChart(Color color) {
        return QuickChart.getChart(getName(), "X", "Y", "y(x)", xData, yData);
    }

    @Override
    public void generate() {

        int j = 10;

        for (int i = 0; i < 20; i++) {
            this.yData.add(getY(j));
            this.xData.add(j);
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
