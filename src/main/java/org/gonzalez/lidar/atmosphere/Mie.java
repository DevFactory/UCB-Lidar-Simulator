package org.gonzalez.lidar.atmosphere;

import org.gonzalez.lidar.atmosphere.functions.Function;
import com.xeiam.xchart.Chart;
import com.xeiam.xchart.Series;
import com.xeiam.xchart.SeriesLineStyle;
import com.xeiam.xchart.SeriesMarker;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

public class Mie extends Function {

    private int w;
    private double x;
    private double y;
    private int z;
    private Collection<Number> results = new ArrayList<Number>();
    private Collection<Number> altitudes = new ArrayList<Number>();

    public Mie(Collection<Number> altitudes) {
        this.altitudes = altitudes;
        this.w = 18;
        this.x = 2.0;
        this.y = 0.01;
        this.z = 1500;
    }

    public Mie() {
        this.w = 18;
        this.x = 2.0;
        this.y = 0.01;
        this.z = 1500;
    }

    @Override
    protected String getName() {
        return "Mie";
    }

    @Override
    public double getY(double x) {
        return (this.w + (Math.sin(0.25 * Math.PI * Math.pow(x, this.x)) + (0.1 * Math.cos(0.5 * Math.PI * Math.pow(x, 3.0))) - (Math.pow((0.2 * x), 3.0)) - (this.y * x + 1))) / this.z;
    }

    @Override
    public Chart generateChart(Color color) {
        Chart chart = new Chart(10, 10);
        chart.setChartTitle(getName());
        chart.setXAxisTitle("Altitude (Km.)");
        chart.setYAxisTitle("Mie");
        chart.getStyleManager().setPlotBackgroundColor(Color.WHITE);
        chart.getStyleManager().setPlotGridLinesColor(Color.GRAY);
        chart.getStyleManager().setChartBackgroundColor(Color.WHITE);
        chart.getStyleManager().setLegendBackgroundColor(Color.WHITE);
        chart.getStyleManager().setChartFontColor(Color.BLACK);
        chart.getStyleManager().setChartTitleBoxVisible(false);
        chart.getStyleManager().setPlotGridLinesVisible(true);

        Series series;
        series = chart.addSeries("Mie(Altitude)", this.altitudes, this.results);
        series.setLineColor(color);
        series.setMarkerColor(color);
        series.setMarker(SeriesMarker.NONE);
        series.setLineStyle(SeriesLineStyle.SOLID);
        return chart;
    }

    @Override
    public void generate() {
        for (Number altitude : altitudes) {
            this.results.add(getY(altitude.floatValue()));
        }
    }

    public Collection<Number> getResults() {
        return results;
    }

    public void setResults(Collection<Number> results) {
        this.results = results;
    }

    public Collection<Number> getAltitudes() {
        return altitudes;
    }

    public void setAltitudes(Collection<Number> altitudes) {
        this.altitudes = altitudes;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }
}
