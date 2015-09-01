package atmosphere;

import atmosphere.functions.Function;
import com.xeiam.xchart.Chart;
import com.xeiam.xchart.QuickChart;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Oscar on 7/2/15.
 */
public class Mie extends Function {

    private Collection<Number> xData = new ArrayList<Number>();
    private Collection<Number> yData = new ArrayList<Number>();


    @Override
    protected String getName() {
        return "Mie";
    }

    @Override
    protected double getY(double x) {
        return 10 + Math.sin(x);
    }

    @Override
    public Chart generateChart() {
        Chart chart = QuickChart.getChart(getName(), "X", "Y", "y(x)", this.xData, this.yData);
        
        return chart;
    }

    @Override
    public void generate() {
        for (int i = 0; i < 100; i++) {
            this.yData.add(getY(i));
            this.xData.add(i);
        }
    }
}
