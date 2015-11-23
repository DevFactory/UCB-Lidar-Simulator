package simulation;

import atmosphere.*;
import com.xeiam.xchart.Chart;
import com.xeiam.xchart.Series;
import com.xeiam.xchart.SeriesLineStyle;
import com.xeiam.xchart.SeriesMarker;
import laser.Laser;
import linkbudget.LinkBudget;
import monochromator.Monochromator;
import project.SimulationProject;
import telescope.Telescope;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Oscar on 9/14/15.
 */
public class SimpleSimulation {

    private LinkBudget linkBudget;
    private Laser laser;
    private Telescope telescope;
    private Monochromator monochromator;
    private Atmosphere atmosphere;
    private Temperature temperature;
    private Pressure pressure;
    private Mie mie;
    private Rayleigh rayleigh;
    private ArrayList<Number> altitudes;

    public SimpleSimulation() {
        this.telescope = new Telescope();

    }

    public LinkBudget getLinkBudget() {
        return linkBudget;
    }

    public void setLinkBudget(LinkBudget linkBudget) {
        this.linkBudget = linkBudget;
    }

    public Laser getLaser() {
        return laser;
    }

    public void setLaser(Laser laser) {
        this.laser = laser;
    }

    public Telescope getTelescope() {
        return telescope;
    }

    public void setTelescope(Telescope telescope) {
        this.telescope = telescope;
    }

    public Monochromator getMonochromator() {
        return monochromator;
    }

    public void setMonochromator(Monochromator monochromator) {
        this.monochromator = monochromator;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    public void setAtmosphere(Atmosphere atmosphere) {
        this.atmosphere = atmosphere;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Pressure getPressure() {
        return pressure;
    }

    public void setPressure(Pressure pressure) {
        this.pressure = pressure;
    }

    public Mie getMie() {
        return mie;
    }

    public void setMie(Mie mie) {
        this.mie = mie;
    }

    public Rayleigh getRayleigh() {
        return rayleigh;
    }

    public void setRayleigh(Rayleigh rayleigh) {
        this.rayleigh = rayleigh;
    }

    public ArrayList<Number> getAltitudes() {
        return altitudes;
    }

    public void setAltitudes(ArrayList<Number> altitudes) {
        this.altitudes = altitudes;
    }
}
