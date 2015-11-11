package lidar;

import atmosphere.*;
import laser.Laser;
import linkbudget.LinkBudget;
import helpers.IntegralSolver;
import monochromator.Monochromator;
import telescope.Telescope;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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
    private Temperature temperature = new Temperature();
    private Pressure pressure = new Pressure();
    private Monochromator monochromator = new Monochromator();
    private Telescope telescope = new Telescope();
    private Laser laser = new Laser();
    private LinkBudget linkBudget = new LinkBudget();
    private double k; //System constant
    private Atmosphere atmosphere;

    public Lidar() {
        //this.k = ((this.laser.getOutputEnergyPerPulse() * this.monochromator.getOverlapFactor()) / 2) * this.telescope.getAr();
    }

    public Lidar(Collection<Number> altitudes, Rayleigh rayleigh, Mie mie, Monochromator monochromator, Telescope telescope, Laser laser) {
        this.altitudes = altitudes;
        this.rayleigh = rayleigh;
        this.mie = mie;
        this.monochromator = monochromator;
        this.telescope = telescope;
        this.laser = laser;
        //this.k = ((this.laser.getOutputEnergyPerPulse() * this.monochromator.getOverlapFactor()) / 2) * this.telescope.getAr();
        this.integralSolver.setFunction(this.mie);
    }

    public double opticalReturnPower(double altitude, double backscatterCoef) {
        double value = Math.pow(((this.k / Math.pow(altitude, 2)) * backscatterCoef), (-2 * this.integralSolver.integration(0.0, altitude
        ) * this.monochromator.getOverlapFactor()));
        return value;
    }

    public void generate() {
        double aux;
        Iterator<Number> backScatterIterator = this.rayleigh.getBetaScattering().iterator();
        Iterator<Number> altitudesIterator = this.altitudes.iterator();

        while (backScatterIterator.hasNext()) {
            float backscatter = backScatterIterator.next().floatValue();
            float altitude = altitudesIterator.next().floatValue();
            aux = opticalReturnPower(altitude, backscatter);
            this.results.add(aux);
        }

    }

    public static double getLIGHTSPEEDCONSTANT() {
        return LIGHTSPEEDCONSTANT;
    }

    public IntegralSolver getIntegralSolver() {
        return integralSolver;
    }

    public Collection<Number> getAltitudes() {
        return altitudes;
    }

    public Collection<Number> getResults() {
        return results;
    }

    public Rayleigh getRayleigh() {
        return rayleigh;
    }

    public Mie getMie() {
        return mie;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public Pressure getPressure() {
        return pressure;
    }

    public Monochromator getMonochromator() {
        return monochromator;
    }

    public Telescope getTelescope() {
        return telescope;
    }

    public Laser getLaser() {
        return laser;
    }

    public LinkBudget getLinkBudget() {
        return linkBudget;
    }

    public double getK() {
        return k;
    }

    public void setIntegralSolver(IntegralSolver integralSolver) {
        this.integralSolver = integralSolver;
    }

    public void setAltitudes(Collection<Number> altitudes) {
        this.altitudes = altitudes;
    }

    public void setResults(Collection<Number> results) {
        this.results = results;
    }

    public void setRayleigh(Rayleigh rayleigh) {
        this.rayleigh = rayleigh;
    }

    public void setMie(Mie mie) {
        this.mie = mie;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public void setPressure(Pressure pressure) {
        this.pressure = pressure;
    }

    public void setMonochromator(Monochromator monochromator) {
        this.monochromator = monochromator;
    }

    public void setTelescope(Telescope telescope) {
        this.telescope = telescope;
    }

    public void setLaser(Laser laser) {
        this.laser = laser;
    }

    public void setLinkBudget(LinkBudget linkBudget) {
        this.linkBudget = linkBudget;
    }

    public void setK(double k) {
        this.k = k;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }
}
