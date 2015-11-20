package helpers;

import atmosphere.*;
import atmosphere.functions.plotter.FunctionPlotter;
import laser.Laser;
import linkbudget.LinkBudget;
import monochromator.Monochromator;
import project.SimulationProject;
import telescope.Telescope;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by oscar_sgc on 11/2/15.
 */
public class GraphicsController {

    SimulationProject simulationProject = SimulationProject.getInstance();
    private FunctionPlotter functionPlotter;
    private ArrayList<JPanel> chartPanels = new ArrayList<JPanel>();

    public GraphicsController() {
        generateComponents();
    }

    private void generateComponents() {
        prepairTemperatureChartPanel();
        prepairPressureChartPanel();
        prepairMieChartPanel();
        prepairRayleighPanels();
        prepairAtmospherePanels();
        prepairSNRPanels();
    }

    private void prepairTemperatureChartPanel() {
        Temperature temperature = new Temperature(this.simulationProject.getData());
        temperature.generate();
        this.simulationProject.getSimulation().setAltitudes((ArrayList<Number>) temperature.getAltitudes());
        this.simulationProject.getSimulation().setTemperature(temperature);
        this.functionPlotter = new FunctionPlotter((temperature.generateChart(this.simulationProject.getColors().get(0))));
        this.chartPanels.add(this.functionPlotter.getChartPanel());
    }

    private void prepairPressureChartPanel() {
        Pressure pressure = new Pressure(this.simulationProject.getData());
        pressure.generate();
        this.simulationProject.getSimulation().setPressure(pressure);
        this.functionPlotter.setChart(pressure.generateChart(this.simulationProject.getColors().get(1)));
        this.chartPanels.add(this.functionPlotter.getChartPanel());
    }

    private void prepairMieChartPanel() {
        Mie mie = new Mie(this.simulationProject.getData());
        mie.generate();
        this.simulationProject.getSimulation().setMie(mie);
        this.functionPlotter.setChart(mie.generateChart(this.simulationProject.getColors().get(2)));
        this.chartPanels.add(this.functionPlotter.getChartPanel());
    }

    private void prepairRayleighPanels() {
        Rayleigh rayleigh = new Rayleigh(this.simulationProject.getData());
        rayleigh.generate();
        this.simulationProject.getSimulation().setRayleigh(rayleigh);
        this.functionPlotter.setChart(rayleigh.getAlfaScatteringChart(this.simulationProject.getColors().get(3)));
        this.chartPanels.add(this.functionPlotter.getChartPanel());
        this.functionPlotter.setChart(rayleigh.getBetaScatteringChart(this.simulationProject.getColors().get(4)));
        this.chartPanels.add(this.functionPlotter.getChartPanel());
    }

    private void prepairAtmospherePanels() {
        Mie mie = new Mie(this.simulationProject.getData());
        mie.generate();
        Rayleigh rayleigh = new Rayleigh(this.simulationProject.getData());
        rayleigh.generate();
        Atmosphere atmosphere = new Atmosphere(mie, rayleigh);
        atmosphere.generate();
        this.simulationProject.getSimulation().setAtmosphere(atmosphere);
        this.functionPlotter.setChart(atmosphere.generateChart(this.simulationProject.getColors().get(5)));
        this.chartPanels.add(this.functionPlotter.getChartPanel());
    }

    private void prepairSNRPanels() {
        Laser laser = this.simulationProject.getSimulation().getLaser();
        Monochromator monochromator = this.simulationProject.getSimulation().getMonochromator();
        Telescope telescope = this.simulationProject.getSimulation().getTelescope();
        Atmosphere atmosphere = this.simulationProject.getSimulation().getAtmosphere();
        ArrayList<Number> altitudes = this.simulationProject.getSimulation().getAltitudes();
        LinkBudget linkBudget = new LinkBudget(laser, monochromator, telescope, atmosphere, altitudes);
        linkBudget.generate();
        this.simulationProject.getSimulation().setLinkBudget(linkBudget);
        this.functionPlotter.setChart(linkBudget.generateChart(Color.RED));
        this.chartPanels.add(this.functionPlotter.getChartPanel());
    }

    public SimulationProject getSimulationProject() {
        return simulationProject;
    }

    public void setSimulationProject(SimulationProject simulationProject) {
        this.simulationProject = simulationProject;
    }

    public FunctionPlotter getFunctionPlotter() {
        return functionPlotter;
    }

    public void setFunctionPlotter(FunctionPlotter functionPlotter) {
        this.functionPlotter = functionPlotter;
    }

    public ArrayList<JPanel> getChartPanels() {
        return chartPanels;
    }

    public void setChartPanels(ArrayList chartPanels) {
        this.chartPanels = chartPanels;
    }
}
