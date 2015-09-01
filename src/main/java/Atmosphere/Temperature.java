package atmosphere;

import atmosphere.functions.Function;
import com.xeiam.xchart.Chart;
import com.xeiam.xchart.QuickChart;
import com.xeiam.xchart.Series;
import java.awt.Color;

import java.util.ArrayList;
import java.util.Collection;

public class Temperature extends Function {

    private double seaLevelTemperature, temperatureLapseRate;
    private Collection<Number> altitudes, results;

    public Temperature(double SLT, double TLR) {
        this.seaLevelTemperature = SLT;
        this.temperatureLapseRate = TLR;
        this.results = new ArrayList<Number>();
    }


    public Temperature(Collection<Number> altitudes) {
        this.altitudes = altitudes;
        this.results = new ArrayList<Number>();
        //this.seaLevelTemperature = 59.0;//Fahrenheit
        //this.seaLevelTemperature = 288.15;//Kelvin
        this.seaLevelTemperature = 15.0;//Celsius
        //this.temperatureLapseRate = -0.003566; //Rankine/Foot
        this.temperatureLapseRate = -0.00002370858424;//Celsius/Meter
    }


    public Temperature() {
        //this.seaLevelTemperature = 59.0;//Fahrenheit
        //this.seaLevelTemperature = 288.15;//Kelvin
        this.seaLevelTemperature = 15.0;//Celsius
        //this.temperatureLapseRate = -0.003566; //Rankine/Foot
        this.temperatureLapseRate = -0.00002370858424;//Celsius/Meter
        this.results = new ArrayList<Number>();
    }

    public void generate() {
        for (Number altitude : altitudes) {
            this.results.add(getY(altitude.floatValue() * 1000));
        }
    }


    @Override
    public double getY(double x) {
        return this.seaLevelTemperature - (6.5 * (x / 1000));
    }

    @Override
    public String getName() {
        return "Temperatura";
    }
    
    @Override
    public Chart generateChart() {
        Chart chart = QuickChart.getChart(getName(), "Temperatura", "Altura(Km.)", "Temperatura(Altura)", this.results, this.altitudes);
//        Series series;
  //      series = chart.addSeries("Hello", this.results, this.altitudes);
    //    series.setLineColor(Color.yellow)
        return chart;
    }

    public double getSeaLevelTemperature() {
        return seaLevelTemperature;
    }

    public void setSeaLevelTemperature(double seaLevelTemperature) {
        this.seaLevelTemperature = seaLevelTemperature;
    }

    public double getTemperatureLapseRate() {
        return temperatureLapseRate;
    }

    public void setTemperatureLapseRate(double temperatureLapseRate) {
        this.temperatureLapseRate = temperatureLapseRate;
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
