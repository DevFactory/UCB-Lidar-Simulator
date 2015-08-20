package atmosphere.functions;

import atmosphere.gui.GraphPanel;
import com.xeiam.xchart.Chart;
import com.xeiam.xchart.QuickChart;

import javax.swing.*;

/**
 * Created by Oscar on 6/23/15.
 */
public class Sigmoid extends Function {
    @Override
    public double getY(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    @Override
    public String getName() {
        return "Sigmoid";
    }

    @Override
    public void plot() {

        double[] xData = new double[20];
        double[] yData = new double[20];

        Sigmoid t = new Sigmoid();
        for (int i = 0; i < 20; i++) {
            yData[i] = t.getY(i);
            xData[i] = i;
        }

        // Create Chartis
        Chart chart = QuickChart.getChart(t.getName(), "X", "Y", "y(x)", xData, yData);

        // Show it
        new GraphPanel(chart).displayChart(t.getName());

    }

    @Override
    protected JPanel getPanel() {
        double[] xData = new double[20];
        double[] yData = new double[20];

        Sigmoid t = new Sigmoid();

        int j = 10;

        for (int i = 0; i < 20; i++) {
            yData[i] = t.getY(j);
            xData[i] = j;
            j++;
        }

        // Create Chartis
        Chart chart = QuickChart.getChart(t.getName(), "X", "Y", "y(x)", xData, yData);
        JPanel chartPanel = new GraphPanel(chart).getChartPanel();
        return chartPanel;
    }
}
