package atmosphere;

import atmosphere.functions.Function;
import com.xeiam.xchart.Chart;
import com.xeiam.xchart.Series;
import com.xeiam.xchart.SeriesLineStyle;
import com.xeiam.xchart.SeriesMarker;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Oscar on 7/2/15.
 */
public class Mie extends Function {

    private Collection<Number> results = new ArrayList<Number>();
    private Collection<Number> altitudes = new ArrayList<Number>();

    public Mie(Collection<Number> altitudes) {
        this.altitudes = altitudes;
    }

    public Mie() {
    }

    @Override
    protected String getName() {
        return "Mie";
    }

    @Override
    public double getY(double x) {
        return Math.sin(0.25 * Math.PI * Math.pow(x, 2.0)) - (0.1 * Math.cos(0.5 * Math.PI * Math.pow(x, 3.0))) + (Math.pow((0.2 * x), 3.0)) + (0.01 * x + 1);
    }

    @Override
    public Chart generateChart(Color color) {
        Chart chart = new Chart(10, 10);
        chart.setChartTitle(getName());
        chart.setXAxisTitle("Mie");
        chart.setYAxisTitle("Altitude");
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
}
