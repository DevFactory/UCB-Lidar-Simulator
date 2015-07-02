package atmosphere.functions;

import atmosphere.gui.GraphPanel;
import com.xeiam.xchart.Chart;
import com.xeiam.xchart.QuickChart;

/**
 * Created by Oscar on 6/23/15.
 */
public class Hyperbolic extends Function {
    @Override
    public double getY(double x) {
        return 1 / x;
    }

    @Override
    public String getName() {
        return "Hyperbolic";
    }

    @Override
    public void plot() {

        double[] xData = new double[20];
        double[] yData = new double[20];

        Hyperbolic t = new Hyperbolic();

        int j = 10;

        for (int i = 0; i < 20; i++) {
            yData[i] = t.getY(j);
            xData[i] = j;
            j++;
        }

        // Create Chartis
        Chart chart = QuickChart.getChart(t.getName(), "X", "Y", "y(x)", xData, yData);

        // Show it
        new GraphPanel(chart).displayChart(t.getName());
    }

}

