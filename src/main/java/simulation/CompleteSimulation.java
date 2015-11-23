package simulation;

import java.util.ArrayList;
import java.util.Date;

public class CompleteSimulation {
    private ArrayList<SimpleSimulation> simpleSimulations;
    private Date startingTime;
    private Date endingTime;
    private int samplesPerHour;
    private int hoursQty;

    public CompleteSimulation() {
    }

    public ArrayList<SimpleSimulation> getSimpleSimulations() {
        return simpleSimulations;
    }

    public void setSimpleSimulations(ArrayList<SimpleSimulation> simpleSimulations) {
        this.simpleSimulations = simpleSimulations;
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

    public int getSamplesPerHour() {
        return samplesPerHour;
    }

    public void setSamplesPerHour(int samplesPerHour) {
        this.samplesPerHour = samplesPerHour;
    }

    public int getHoursQty() {
        return hoursQty;
    }

    public void setHoursQty(int hoursQty) {
        this.hoursQty = hoursQty;
    }
}
