package org.gonzalez.lidar.atmosphere;

import org.gonzalez.lidar.atmosphere.functions.Function;
import com.xeiam.xchart.Chart;
import com.xeiam.xchart.Series;
import com.xeiam.xchart.SeriesLineStyle;
import com.xeiam.xchart.SeriesMarker;
import org.gonzalez.lidar.project.SimulationProject;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Atmosphere extends Function {
    private Mie mie = new Mie();
    private Rayleigh rayleigh = new Rayleigh();
    private ArrayList<Number> results = new ArrayList<Number>();
    SimulationProject simulationProject = SimulationProject.getInstance();

    public Atmosphere() {

    }

    public Atmosphere(Mie mie, Rayleigh rayleigh) {
        this.mie = mie;
        this.rayleigh = rayleigh;
    }

    @Override
    public double getY(double x) {
        return 0;
    }

    @Override
    protected String getName() {
        return "Atmosphere";
    }

    @Override
    public Chart generateChart(Color color) {
        Chart chart = new Chart(10, 10);
        chart.setChartTitle(getName());
        chart.setXAxisTitle("Altitude (Km.)");
        chart.setYAxisTitle("Atmosphere");
        chart.getStyleManager().setPlotBackgroundColor(Color.WHITE);
        chart.getStyleManager().setPlotGridLinesColor(Color.GRAY);
        chart.getStyleManager().setChartBackgroundColor(Color.WHITE);
        chart.getStyleManager().setLegendBackgroundColor(Color.WHITE);
        chart.getStyleManager().setChartFontColor(Color.BLACK);
        chart.getStyleManager().setChartTitleBoxVisible(false);
        chart.getStyleManager().setPlotGridLinesVisible(true);

        Series series;
        series = chart.addSeries("Atmosphere(Altitude)", this.rayleigh.getAltitudes(), this.results);
        series.setLineColor(color);
        series.setMarkerColor(color);
        series.setMarker(SeriesMarker.NONE);
        series.setLineStyle(SeriesLineStyle.SOLID);
        return chart;
    }

    @Override
    public void generate() {
        Iterator<Number> betaScatteringIterator = this.rayleigh.getBetaScattering().iterator();
        Iterator<Number> mieIterator = this.mie.getResults().iterator();
        while (betaScatteringIterator.hasNext()) {
            double var = betaScatteringIterator.next().doubleValue() + mieIterator.next().doubleValue();
            this.results.add(var);
        }
    }

    public Rayleigh getRayleigh() {
        return rayleigh;
    }

    public void setRayleigh(Rayleigh rayleigh) {
        this.rayleigh = rayleigh;
    }

    public Mie getMie() {
        return mie;
    }

    public void setMie(Mie mie) {
        this.mie = mie;
    }
}
