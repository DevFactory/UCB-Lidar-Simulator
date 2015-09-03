package atmosphere;

import atmosphere.functions.Function;
import com.xeiam.xchart.Chart;
import com.xeiam.xchart.Series;
import com.xeiam.xchart.SeriesLineStyle;
import com.xeiam.xchart.SeriesMarker;
import java.awt.Color;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Oscar on 7/2/15.
 */
public class Mie extends Function {

    private Collection<Number> xData = new ArrayList<Number>();
    private Collection<Number> yData = new ArrayList<Number>();


    @Override
    protected String getName() {
        return "Mie";
    }

    @Override
    protected double getY(double x) {
        return 10 + Math.sin(x);
    }

    @Override
    public Chart generateChart(Color color) {
        //Chart chart = QuickChart.getChart(getName(), "X", "Y", "y(x)", this.xData, this.yData);
        //return chart;
         Chart chart = new Chart(10, 10);
        chart.setChartTitle(getName());
        chart.setXAxisTitle("X");
        chart.setYAxisTitle("Y");
        chart.getStyleManager().setPlotBackgroundColor(Color.WHITE);
        chart.getStyleManager().setPlotGridLinesColor(Color.GRAY);
        chart.getStyleManager().setChartBackgroundColor(Color.WHITE);
        chart.getStyleManager().setLegendBackgroundColor(Color.WHITE);
        chart.getStyleManager().setChartFontColor(Color.BLACK);
        chart.getStyleManager().setChartTitleBoxVisible(false);
        chart.getStyleManager().setPlotGridLinesVisible(true);
 
        Series series;
        series = chart.addSeries("y(x)", this.xData, this.yData);
        series.setLineColor(color);
        series.setMarkerColor(color);
        series.setMarker(SeriesMarker.CIRCLE);
        series.setLineStyle(SeriesLineStyle.SOLID);
        return chart;
    }

    @Override
    public void generate() {
        for (int i = 0; i < 100; i++) {
            this.yData.add(getY(i));
            this.xData.add(i);
        }
    }
}
