package atmosphere;

import atmosphere.functions.Function;
import atmosphere.gui.GraphPanel;
import com.xeiam.xchart.Chart;
import com.xeiam.xchart.QuickChart;

/**
 * Created by Oscar on 7/2/15.
 */
public class Mie extends Function {
    @Override
    protected double getY(double x) {
        return 10 + Math.sin(x);
    }

    @Override
    public void plot() {

        double[] xData = new double[100];
        double[] yData = new double[100];

        for (int i = 0; i < 100; i++) {
            yData[i] = getY(i);
            xData[i] = i;
        }

        // Create Chartis
        Chart chart = QuickChart.getChart(getName(), "X", "Y", "y(x)", xData, yData);

        // Show it
        new GraphPanel(chart).displayChart(getName());

    }

    @Override
    protected String getName() {
        return "Mie";
    }
}
