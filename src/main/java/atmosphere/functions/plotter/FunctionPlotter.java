package atmosphere.functions.plotter;


import com.xeiam.xchart.Chart;

import javax.swing.*;

public class FunctionPlotter {

    private Chart chart;

    public FunctionPlotter() {
    }

    public FunctionPlotter(Chart chart) {
        this.chart = chart;
    }

    public JPanel getChartPanel() {
        return new GraphPanel(chart).getChartPanel();
    }

    public Chart getChart() {
        return chart;
    }

    public void setChart(Chart chart) {
        this.chart = chart;
    }
}
