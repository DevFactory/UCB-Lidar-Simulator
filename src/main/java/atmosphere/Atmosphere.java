package atmosphere;

import atmosphere.functions.Function;
import com.xeiam.xchart.Chart;
import com.xeiam.xchart.Series;
import com.xeiam.xchart.SeriesLineStyle;
import com.xeiam.xchart.SeriesMarker;

import java.awt.*;

/**
 * Created by Oscar on 9/7/15.
 */
public class Atmosphere extends Function {
    private Temperature temperature = new Temperature();
    private Rayleigh rayleigh = new Rayleigh();

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
        chart.setXAxisTitle("Atmosphere");
        chart.setYAxisTitle("Atmosphere");
        chart.getStyleManager().setPlotBackgroundColor(Color.WHITE);
        chart.getStyleManager().setPlotGridLinesColor(Color.GRAY);
        chart.getStyleManager().setChartBackgroundColor(Color.WHITE);
        chart.getStyleManager().setLegendBackgroundColor(Color.WHITE);
        chart.getStyleManager().setChartFontColor(Color.BLACK);
        chart.getStyleManager().setChartTitleBoxVisible(false);
        chart.getStyleManager().setPlotGridLinesVisible(true);

        Series series1, series2;

//        series1 = chart.addSeries("Beta(Alpha)", this.rayleigh.getAlfaScatering(), this.rayleigh.getBetaScatering());
//        series1.setLineColor(color);
//        series1.setMarkerColor(color);
//        series1.setMarker(SeriesMarker.CIRCLE);
//        series1.setLineStyle(SeriesLineStyle.SOLID);

        series2 = chart.addSeries("y(x)", this.temperature.getAltitudes(), this.temperature.getResults());
        series2.setLineColor(Color.BLUE);
        series2.setMarkerColor(Color.BLUE);
        series2.setMarker(SeriesMarker.CIRCLE);
        series2.setLineStyle(SeriesLineStyle.SOLID);


        return chart;
    }

    @Override
    protected void generate() {

    }

    public Atmosphere() {

    }

    public Atmosphere(Temperature temperature, Rayleigh rayleigh) {
        this.temperature = temperature;
        this.rayleigh = rayleigh;
    }

    public Rayleigh getRayleigh() {
        return rayleigh;
    }

    public void setRayleigh(Rayleigh rayleigh) {
        this.rayleigh = rayleigh;
    }

}
