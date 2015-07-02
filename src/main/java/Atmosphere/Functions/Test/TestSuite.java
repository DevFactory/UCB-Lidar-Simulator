package atmosphere.functions.test;

import atmosphere.functions.Hyperbolic;
import atmosphere.functions.Parabolic;
import atmosphere.functions.Sigmoid;

/**
 * Created by Oscar on 7/1/15.
 */
public class TestSuite {
    public static void main(String[] args) {
        Parabolic p = new Parabolic();
        Hyperbolic h = new Hyperbolic();
        Sigmoid s = new Sigmoid();
        //p.plot();
        h.plot();
        //s.plot();
    }
}
