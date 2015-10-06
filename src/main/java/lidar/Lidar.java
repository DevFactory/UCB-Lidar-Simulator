package lidar;

import atmosphere.Mie;
import atmosphere.Rayleigh;
import laser.Laser;
import linkbudget.LinkBudget;
import math.IntegralSolver;
import monochromator.Monochromator;
import telescope.Telescope;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Oscar on 9/14/15.
 */
public class Lidar {

    private static final double LIGHTSPEEDCONSTANT = 299792458;
    private IntegralSolver integralSolver = new IntegralSolver();
    private Collection<Number> altitudes = new ArrayList<Number>();
    private Collection<Number> results = new ArrayList<Number>();
    private Rayleigh rayleigh = new Rayleigh();
    private Mie mie = new Mie();
    private Monochromator monochromator = new Monochromator();
    private Telescope telescope = new Telescope();
    private Laser laser = new Laser();
    private LinkBudget linkBudget = new LinkBudget();
    private double k; //System constant

    public Lidar() {
        this.k = ((this.laser.getOutputEnergyPerPulse() * this.monochromator.getOverlapFactor()) / 2) * this.telescope.getAr();
    }

    public Lidar(Collection<Number> altitudes, Rayleigh rayleigh, Mie mie, Monochromator monochromator, Telescope telescope, Laser laser) {
        this.altitudes = altitudes;
        this.rayleigh = rayleigh;
        this.mie = mie;
        this.monochromator = monochromator;
        this.telescope = telescope;
        this.laser = laser;
        this.k = ((this.laser.getOutputEnergyPerPulse() * this.monochromator.getOverlapFactor()) / 2) * this.telescope.getAr();
        this.integralSolver.setFunction(this.mie);
    }

    public double opticalReturnPower(double altitude, double backscatterCoef, double extinctionCoef) {
        double value = Math.pow(((this.k / Math.pow(altitude, 2)) * backscatterCoef), (-2 * this.integralSolver.integration(0.0, altitude
        ) * this.monochromator.getOverlapFactor()));
        return value;
    }

    public void equation() {

    }
}
