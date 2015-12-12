
package helpers;

import simulation.SimpleSimulation;

import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class SimulationController {

    private ArrayList<SimpleSimulation> simpleSimulations = new ArrayList<SimpleSimulation>();
    private ArrayList<Content> container = new ArrayList<Content>();
    private double maxValue;
    private double minValue;
    private int simulationsQty;
    private int pixelsQty;
    private Date startingTime;
    private Date endingTime;
    private int hoursQty;
    private int simulationsPerHour;
    private ArrayList<Content> correctValues = new ArrayList<Content>();

    public SimulationController() {
    }

    public void setContentArrayForSimulationPlotting() {
        for (int j = 0; j < this.correctValues.size(); j++) {
            this.container.add(this.correctValues.get(j));
        }
    }

    public void setCorrectValuesArray() {
        for (int i = 0; i < this.simpleSimulations.size(); i++) {
            for (int j = 0; j < this.simpleSimulations.get(i).getLinkBudget().getSNR0().size(); j = j + (this.simpleSimulations.get(i).getLinkBudget().getSNR0().size() / this.pixelsQty)) {
                this.correctValues.add(new Content(this.simpleSimulations.get(i).getLinkBudget().getSNR0().get(j), this.simpleSimulations.get(i).getRangeValue()));
            }
        }
    }

    public void generate() {
        emptyArrays();
        setCorrectPixelsQty();
        obtainSimulationsQty();
        setCorrectValuesArray();
        setContentArrayForSimulationPlotting();
        getMaximumValueFromContainer();
        getMinimumValueFromContainer();
    }

    private void emptyArrays() {
        this.container.clear();
        this.correctValues.clear();
    }

    private void setCorrectPixelsQty() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.pixelsQty = screenSize.height - 250;
    }

    public void getMaximumValueFromContainer() {
        ArrayList<Double> aux = new ArrayList<Double>();
        for (int j = 0; j < this.correctValues.size(); j++) {
            aux.add(this.correctValues.get(j).getValue());
        }
        this.maxValue = Collections.max(aux);
    }

    public void getMinimumValueFromContainer() {
        ArrayList<Double> aux = new ArrayList<Double>();
        for (int j = 0; j < this.correctValues.size(); j++) {
            aux.add(this.correctValues.get(j).getValue());
        }
        this.minValue = Collections.min(aux);
    }

    public ArrayList<SimpleSimulation> getSimpleSimulations() {
        return simpleSimulations;
    }

    public void setSimpleSimulations(ArrayList<SimpleSimulation> simpleSimulations) {
        this.simpleSimulations = simpleSimulations;
    }

    public ArrayList<Content> getContainer() {
        return container;
    }

    public void setContainer(ArrayList<Content> container) {
        this.container = container;
    }

    public double getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
    }

    public double getMinValue() {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    public int getSimulationsQty() {
        return simulationsQty;
    }

    public void setSimulationsQty(int simulationsQty) {
        this.simulationsQty = simulationsQty;
    }

    public void obtainSimulationsQty() {
        this.simulationsQty = this.hoursQty * this.simulationsPerHour;
    }

    public int getPixelsQty() {
        return pixelsQty;
    }

    public void setPixelsQty(int pixelsQty) {
        this.pixelsQty = pixelsQty;
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

    public int getHoursQty() {
        return hoursQty;
    }

    public void setHoursQty(int hoursQty) {
        this.hoursQty = hoursQty;
    }

    public int getSimulationsPerHour() {
        return simulationsPerHour;
    }

    public void setSimulationsPerHour(int simulationsPerHour) {
        this.simulationsPerHour = simulationsPerHour;
    }
}
