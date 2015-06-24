package Atmosphere.Functions;

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


    }
}
