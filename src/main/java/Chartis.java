import Atmosphere.Functions.Sigmoid;
import Atmosphere.GUI.GraphPanel;
import com.xeiam.xchart.Chart;
import com.xeiam.xchart.QuickChart;

/**
 * Created by Oscar on 6/23/15.
 */
public class Chartis {

    public static void main(String[] args) throws Exception {

        double[] xData = new double[20];
        double[] yData = new double[20];
        Sigmoid t = new Sigmoid();
        for (int i = 0; i < 20; i++) {
            yData[i] = t.getY(i);
            xData[i] = i;
        }

        // Create Chartis
        Chart chart = QuickChart.getChart(t.getName(), "Temperature", "Altitude", "y(x)", xData, yData);

        // Show it
        new GraphPanel(chart).displayChart(t.getName());
    }

}
