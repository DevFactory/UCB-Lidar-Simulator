package atmosphere.functions;

import com.xeiam.xchart.Chart;
import java.awt.Color;

import java.util.Collection;

public abstract class Function {

    protected abstract double getY(double x);

    protected abstract String getName();

    protected abstract Chart generateChart(Color color);

    protected abstract void generate();
}
