package atmosphere;

import atmosphere.functions.Function;
import atmosphere.functions.plotter.GraphPanel;
import com.xeiam.xchart.Chart;
import com.xeiam.xchart.QuickChart;
import com.xeiam.xchart.Series;
import com.xeiam.xchart.SeriesLineStyle;
import com.xeiam.xchart.SeriesMarker;
import java.awt.Color;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Oscar on 6/23/15.
 */
public class Pressure extends Function {

    private Collection<Number> altitudes = new ArrayList<Number>();
    private Collection<Number> pressures = new ArrayList<Number>();
    private double seaLevelPressure, temperatureLapseRate, seaLevelTemperature;
    private double constant = 5.2561;

    public Pressure(ArrayList<Number> altitudes, double seaLevelPressure, double temperatureLapseRate, double seaLevelTemperature) {
        this.altitudes = altitudes;
        this.seaLevelPressure = seaLevelPressure;
        this.temperatureLapseRate = temperatureLapseRate;

        this.seaLevelTemperature = seaLevelTemperature;
    }

    public Pressure() {
        //this.seaLevelPressure = 2116.2; //lb/SquareFoot
        this.seaLevelPressure = 1013.25; //hPa
        //this.temperatureLapseRate = -0.003566; //Rankine/Foot
        this.temperatureLapseRate = -0.00002370858424;//Celsius/Meter
        //this.seaLevelTemperature = 59.0;//Fahrenheit
        //this.seaLevelTemperature = 15.0;//Celsius
        this.seaLevelTemperature = 288.15;//Kelvin
    }

    public Pressure(Collection<Number> altitudes) {
        this.altitudes = altitudes;
        //this.seaLevelPressure = 2116.2; //lb/SquareFoot
        this.seaLevelPressure = 1013.25; //hPa
        //this.temperatureLapseRate = -0.003566; //Rankine/Foot
        this.temperatureLapseRate = -0.00002370858424;//Celsius/Meter
        //this.seaLevelTemperature = 59.0;//Fahrenheit
        //this.seaLevelTemperature = 15.0;//Celsius
        this.seaLevelTemperature = 288.15;//Kelvin
    }

    @Override
    public double getY(double x) {
        return (this.seaLevelPressure * Math.pow((1 - (0.0065 * (x / this.seaLevelTemperature))), this.constant));
    }

    @Override
    public String getName() {
        return "Pressure";
    }

    @Override
    public Chart generateChart(Color color) {
        
        Chart chart = new Chart(10, 10);
        chart.setChartTitle(getName());
        chart.setXAxisTitle("Altitude");
        chart.setYAxisTitle("Pressure");
        chart.getStyleManager().setPlotBackgroundColor(Color.WHITE);
        chart.getStyleManager().setPlotGridLinesColor(Color.GRAY);
        chart.getStyleManager().setChartBackgroundColor(Color.WHITE);
        chart.getStyleManager().setLegendBackgroundColor(Color.WHITE);
        chart.getStyleManager().setChartFontColor(Color.BLACK);
        chart.getStyleManager().setChartTitleBoxVisible(false);
        chart.getStyleManager().setPlotGridLinesVisible(true);
 
        Series series;
        series = chart.addSeries("Pressure(Temperature)", this.altitudes, this.pressures);
        series.setLineColor(color);
        series.setMarkerColor(color);
        series.setMarker(SeriesMarker.NONE);
        series.setLineStyle(SeriesLineStyle.SOLID);
        return chart;
    }


    public void generate() {
        for (Number altitude : altitudes) {
            this.pressures.add(getY(altitude.doubleValue()*1000));
        }
    }

    public Collection<Number> getTemperatures() {
        return altitudes;
    }

    public void setTemperatures(Collection<Number> temperatures) {
        this.altitudes = temperatures;
    }

    public Collection<Number> getPressures() {
        return pressures;
    }

    public void setPressures(Collection<Number> pressures) {
        this.pressures = pressures;
    }

    public double getSeaLevelPressure() {
        return seaLevelPressure;
    }

    public void setSeaLevelPressure(double seaLevelPressure) {
        this.seaLevelPressure = seaLevelPressure;
    }

    public double getTemperatureLapseRate() {
        return temperatureLapseRate;
    }

    public void setTemperatureLapseRate(double temperatureLapseRate) {
        this.temperatureLapseRate = temperatureLapseRate;
    }

    public double getSeaLevelTemperature() {
        return seaLevelTemperature;
    }

    public void setSeaLevelTemperature(double seaLevelTemperature) {
        this.seaLevelTemperature = seaLevelTemperature;
    }

    public double getConstant() {
        return constant;
    }

    public void setConstant(double constant) {
        this.constant = constant;
    }
}
