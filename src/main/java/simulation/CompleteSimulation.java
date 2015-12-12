package simulation;

import atmosphere.Atmosphere;
import helpers.Content;
import laser.Laser;
import linkbudget.LinkBudget;
import monochromator.Monochromator;
import project.SimulationProject;
import telescope.Telescope;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class CompleteSimulation {


    private Date startingTime;
    private Date endingTime;
    private int simulationsPerHour;
    private int hoursQty;
    private int pixelsQty;


    public CompleteSimulation() {

    }

    public Date getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Date startingTime) {
        this.startingTime = startingTime;
    }

    public Date getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(Date endingTime) {
        this.endingTime = endingTime;
    }

    public int getSimulationsPerHour() {
        return simulationsPerHour;
    }

    public void setSimulationsPerHour(int simulationsPerHour) {
        this.simulationsPerHour = simulationsPerHour;
    }

    public int getHoursQty() {
        return hoursQty;
    }

    public void setHoursQty(int hoursQty) {
        this.hoursQty = hoursQty;
    }

    public int getPixelsQty() {
        return pixelsQty;
    }

    public void setPixelsQty(int pixelsQty) {
        this.pixelsQty = pixelsQty;
    }

}
