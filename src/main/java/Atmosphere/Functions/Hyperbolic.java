package Atmosphere.Functions;

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
}
