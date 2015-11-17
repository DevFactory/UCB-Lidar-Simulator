package atmosphere.functions;

import com.xeiam.xchart.Chart;

import java.awt.*;

public class TestFunction extends Function {

    @Override
    public double getY(double x) {
        return (1 / (Math.pow((x - 1), 3)));
    }

    @Override
    protected String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Chart generateChart(Color color) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void generate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
