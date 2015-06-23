package Atmosphere.Functions;

/**
 * Created by Oscar on 6/23/15.
 */
public class Sigmoid extends Function {
    @Override
    public double getY(double x) {
        return 1 / (1 + Math.exp(-x));
    }

    @Override
    public String getName() {
        return "Sigmoid";
    }
}
