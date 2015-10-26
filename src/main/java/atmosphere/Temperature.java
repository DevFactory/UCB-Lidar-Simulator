package atmosphere;

import atmosphere.functions.Function;
import com.xeiam.xchart.Chart;
import com.xeiam.xchart.Series;
import com.xeiam.xchart.SeriesLineStyle;
import com.xeiam.xchart.SeriesMarker;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

public class Temperature extends Function {

    private double seaLevelTemperature;
    private Collection<Number> altitudes, results;

    public Temperature(double SLT) {
        this.seaLevelTemperature = SLT;
        this.results = new ArrayList<Number>();
    }


    public Temperature(Collection<Number> altitudes) {
        this.altitudes = altitudes;
        this.results = new ArrayList<Number>();
        this.seaLevelTemperature = 15.0;//Celsius
        //this.seaLevelTemperature = 59.0;//Fahrenheit
        //this.seaLevelTemperature = 288.15;//Kelvin
    }


    public Temperature() {
        //this.seaLevelTemperature = 59.0;//Fahrenheit
        //this.seaLevelTemperature = 288.15;//Kelvin
        this.seaLevelTemperature = 15.0;//Celsius
        this.results = new ArrayList<Number>();
    }

    public void generate() {
        for (Number altitude : altitudes) {
            this.results.add(getY(altitude.floatValue()));
        }
    }

    @Override
    public double getY(double x) {
        return this.seaLevelTemperature - (6.5 * ((x*1000) / 1000));
    }

    @Override
    public String getName() {
        return "Temperature";
    }

    @Override
    public Chart generateChart(Color color) {
        Chart chart = new Chart(10, 10);
        chart.setChartTitle(getName());
        chart.setYAxisTitle("Temperature (ºC)");
        chart.setXAxisTitle("Altitude (Km.)");
        chart.getStyleManager().setPlotBackgroundColor(Color.WHITE);
        chart.getStyleManager().setPlotGridLinesColor(Color.GRAY);
        chart.getStyleManager().setChartBackgroundColor(Color.WHITE);
        chart.getStyleManager().setLegendBackgroundColor(Color.WHITE);
        chart.getStyleManager().setChartFontColor(Color.BLACK);
        chart.getStyleManager().setChartTitleBoxVisible(false);
        chart.getStyleManager().setPlotGridLinesVisible(true);

        Series series;
        series = chart.addSeries("Temperature(Altitude)", this.altitudes, this.results);
        series.setLineColor(color);
        series.setMarkerColor(color);
        series.setMarker(SeriesMarker.NONE);
        series.setLineStyle(SeriesLineStyle.SOLID);
        return chart;
    }

    public double getSeaLevelTemperature() {
        return seaLevelTemperature;
    }

    public void setSeaLevelTemperature(double seaLevelTemperature) {
        this.seaLevelTemperature = seaLevelTemperature;
    }

    public Collection<Number> getAltitudes() {
        return altitudes;
    }

    public void setAltitudes(Collection<Number> altitudes) {
        this.altitudes = altitudes;
    }

    public Collection<Number> getResults() {
        return results;
    }

    public void setResults(Collection<Number> results) {
        this.results = results;
    }

}
