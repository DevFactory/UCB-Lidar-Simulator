/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmosphere.functions;

import com.xeiam.xchart.Chart;

import java.awt.*;

/**
 * @author Internet
 */
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
