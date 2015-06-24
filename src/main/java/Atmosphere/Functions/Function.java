package Atmosphere.Functions;

import Atmosphere.Plotting.Plotter;

/**
 * Created by Oscar on 6/23/15.
 */
public abstract class Function extends Plotter {

    protected abstract double getY(double x);

    protected abstract String getName();

}
