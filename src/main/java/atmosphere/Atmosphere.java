package atmosphere;

import atmosphere.functions.Function;
import com.xeiam.xchart.Chart;
import com.xeiam.xchart.Series;
import com.xeiam.xchart.SeriesLineStyle;
import com.xeiam.xchart.SeriesMarker;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Oscar on 9/7/15.
 */
public class Atmosphere extends Function {
    private Mie mie = new Mie();
    private Rayleigh rayleigh = new Rayleigh();
    private ArrayList<Number> results = new ArrayList<Number>();

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
        chart.setXAxisTitle("Altitude");
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

//        Chart chart = new Chart(10, 10);
//        chart.setChartTitle(getName());
//        chart.setXAxisTitle("");
//        chart.setYAxisTitle("");
//        chart.getStyleManager().setPlotBackgroundColor(Color.WHITE);
//        chart.getStyleManager().setPlotGridLinesColor(Color.GRAY);
//        chart.getStyleManager().setChartBackgroundColor(Color.WHITE);
//        chart.getStyleManager().setLegendBackgroundColor(Color.WHITE);
//        chart.getStyleManager().setChartFontColor(Color.BLACK);
//        chart.getStyleManager().setChartTitleBoxVisible(false);
//        chart.getStyleManager().setPlotGridLinesVisible(true);
//
//        Series series1, series2;
//
//        series1 = chart.addSeries("Beta(Alpha)", this.rayleigh.getAltitudes(), this.rayleigh.getBetaScattering());
//        series1.setLineColor(color);
//        series1.setMarkerColor(color);
//        series1.setMarker(SeriesMarker.NONE);
//        series1.setLineStyle(SeriesLineStyle.SOLID);
//
//        series2 = chart.addSeries("y(x)", this.rayleigh.getAltitudes(), this.mie.getResults());
//        series2.setLineColor(Color.BLUE);
//        series2.setMarkerColor(Color.BLUE);
//        series2.setMarker(SeriesMarker.NONE);
//        series2.setLineStyle(SeriesLineStyle.SOLID);
//
//
//        return chart;
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

}
