package atmosphere.functions;

import atmosphere.gui.GraphPanel;
import com.xeiam.xchart.Chart;
import com.xeiam.xchart.QuickChart;

/**
 * Created by Oscar on 6/23/15.
 */
public class Parabolic extends Function {
    @Override
    public double getY(double x) {
        return Math.pow(x, 2);
    }

    @Override
    public String getName() {
        return "Parabolic";
    }

    @Override
    public void plot() {

        double[] xData = new double[20];
        double[] yData = new double[20];

        Parabolic t = new Parabolic();
        for (int i = 0; i < 20; i++) {
            yData[i] = t.getY(i);
            xData[i] = i;
        }

        // Create Chartis
        Chart chart = QuickChart.getChart(t.getName(), "X", "Y", "y(x)", xData, yData);

        // Show it
        new GraphPanel(chart).displayChart(t.getName());

    }
}
