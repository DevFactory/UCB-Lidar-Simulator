package atmosphere.functions.plotter;

import com.xeiam.xchart.Chart;
import java.util.ArrayList;

import javax.swing.*;

public class FunctionPlotter {

    private Chart chart;
    private ArrayList<Chart> charts;

    public FunctionPlotter() {
    }

    public FunctionPlotter(ArrayList<Chart> charts) {
        this.charts = charts;
    }

    public FunctionPlotter(Chart chart) {
        this.chart = chart;
    }

    public JPanel getChartPanel() {
        return new GraphPanel(chart).getChartPanel();
    }

    public JPanel getChartMatrix() {
        return new GraphPanel(this.charts).getChartMatrix();
    }

    public Chart getChart() {
        return chart;
    }

    public void setChart(Chart chart) {
        this.chart = chart;
    }

    public void setCharts(ArrayList<Chart> charts) {
        this.charts = charts;
    }
}
