package helpers;

import atmosphere.Atmosphere;
import laser.Laser;
import linkbudget.LinkBudget;
import monochromator.Monochromator;
import project.SimulationProject;
import simulation.SimpleSimulation;
import telescope.Telescope;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by oscar_sgc on 11/23/15.
 */
public class SimulationController {

    SimulationProject simulationProject = SimulationProject.getInstance();

    public SimulationController() {

    }

    public void prepairSimulation() {
        SimpleSimulation helper;
        Laser laser = this.simulationProject.getSimpleSimulation().getLaser();
        Monochromator monochromator = this.simulationProject.getSimpleSimulation().getMonochromator();
        Telescope telescope = this.simulationProject.getSimpleSimulation().getTelescope();
        Atmosphere atmosphere = this.simulationProject.getSimpleSimulation().getAtmosphere();
        ArrayList<Number> altitudes = this.simulationProject.getSimpleSimulation().getAltitudes();
        LinkBudget linkBudget = new LinkBudget(laser, monochromator, telescope, atmosphere, altitudes);
        linkBudget.generate();
        this.simulationProject.getSimpleSimulation().setLinkBudget(linkBudget);
        helper = this.simulationProject.getSimpleSimulation();
        this.simulationProject.getCompleteSimulation().getSimpleSimulations().add(helper);
        this.simulationProject.getCompleteSimulation().getSimpleSimulations().add(helper);
        this.simulationProject.getCompleteSimulation().getSimpleSimulations().add(helper);
        this.simulationProject.getCompleteSimulation().getSimpleSimulations().add(helper);
        this.simulationProject.getCompleteSimulation().getSimpleSimulations().add(helper);
        //this.simulationPlotter.setChart()
    }
}
