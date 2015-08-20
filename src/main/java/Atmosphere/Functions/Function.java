package atmosphere.functions;

import javax.swing.*;

/**
 * Created by Oscar on 6/23/15.
 */
public abstract class Function {

    protected abstract double getY(double x);

    protected abstract void plot();

    protected abstract String getName();

    protected abstract JPanel getPanel();

}
