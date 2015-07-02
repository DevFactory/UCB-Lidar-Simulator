import atmosphere.gui.GraphPanel;
import atmosphere.Temperature;
import com.xeiam.xchart.Chart;
import com.xeiam.xchart.QuickChart;

/**
 * Created by Oscar on 6/23/15.
 */
public class Chartis {

    public static void main(String[] args){

        double[] xData = new double[20];
        double[] yData = new double[20];
        Temperature t = new Temperature();
        for (int i = 0; i < 20; i++) {
            xData[i] = t.getY(i);
            yData[i] = i;
        }

        // Create Chartis
        Chart chart = QuickChart.getChart(t.getName(), t.getName(), "Altitude", "y(x)", xData, yData);

        // Show it
        new GraphPanel(chart).displayChart(t.getName());
    }

}
