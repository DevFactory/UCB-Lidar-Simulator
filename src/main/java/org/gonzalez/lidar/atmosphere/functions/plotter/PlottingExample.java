package org.gonzalez.lidar.atmosphere.functions.plotter;

import org.gonzalez.lidar.atmosphere.functions.Hyperbolic;
import org.gonzalez.lidar.atmosphere.functions.Parabolic;
import org.gonzalez.lidar.atmosphere.functions.Sigmoid;
import com.xeiam.xchart.*;

import java.util.ArrayList;

/**
 * Created by oscar_sgc on 12/17/15.
 */
public class PlottingExample {
    private Hyperbolic hyperbolic = new Hyperbolic();
    private Parabolic parabolic = new Parabolic();
    private Sigmoid sigmoid = new Sigmoid();
    private ArrayList<Chart> charts = new ArrayList<Chart>();

    public PlottingExample() {
        generate();
        prepairCharts();
        plot();
    }

    public void generate() {
        this.hyperbolic.generate();
        this.parabolic.generate();
        this.sigmoid.generate();
    }

    public void prepairCharts() {
        Chart hyperbolicChart = new ChartBuilder().xAxisTitle("X").yAxisTitle("Y").width(600).height(400).build();
        Series hyperbolicSerie = hyperbolicChart.addSeries("Hyperbolic x", null, this.getHyperbolic().getyData());
        hyperbolicSerie.setMarker(SeriesMarker.NONE);
        this.charts.add(hyperbolicChart);

        Chart sigmoidChart = new ChartBuilder().xAxisTitle("X").yAxisTitle("Y").width(600).height(400).build();
        Series sigmoidSerie = sigmoidChart.addSeries("Sigmoid x", null, this.getSigmoid().getyData());
        sigmoidSerie.setMarker(SeriesMarker.NONE);
        this.charts.add(sigmoidChart);

        Chart parabolicChart = new ChartBuilder().xAxisTitle("X").yAxisTitle("Y").width(600).height(400).build();
        Series parabolicSerie = parabolicChart.addSeries("Parabolic x", null, this.getParabolic().getyData());
        parabolicSerie.setMarker(SeriesMarker.NONE);
        this.charts.add(parabolicChart);

        Chart emptyChart = new ChartBuilder().xAxisTitle("X").yAxisTitle("Y").width(600).height(400).build();
        Series emptySerie = emptyChart.addSeries("Nula", null, getRandomWalk(200));
        emptySerie.setMarker(SeriesMarker.NONE);
        this.charts.add(emptyChart);
    }

    private static double[] getRandomWalk(int numPoints) {

        double[] y = new double[numPoints];
        y[0] = 0;
        for (int i = 1; i < y.length; i++) {
            y[i] = y[i - 1] + Math.random() - .5;
        }
        return y;
    }

    public void plot() {
        new SwingWrapper(this.charts).displayChartMatrix();
    }

    public Hyperbolic getHyperbolic() {
        return hyperbolic;
    }

    public void setHyperbolic(Hyperbolic hyperbolic) {
        this.hyperbolic = hyperbolic;
    }

    public Parabolic getParabolic() {
        return parabolic;
    }

    public void setParabolic(Parabolic parabolic) {
        this.parabolic = parabolic;
    }

    public Sigmoid getSigmoid() {
        return sigmoid;
    }

    public void setSigmoid(Sigmoid sigmoid) {
        this.sigmoid = sigmoid;
    }

}
