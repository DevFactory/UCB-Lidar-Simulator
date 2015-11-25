package ui;

import helpers.Content;
import helpers.SimulationController;
import project.SimulationProject;
import simulation.CompleteSimulation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PlotPanel extends JPanel {
    private SimulationController simulationController;
    SimulationProject simulationProject = SimulationProject.getInstance();
    private int xPlotRange;
    private int thickness;

    public PlotPanel() {
        this.xPlotRange = this.getWidth() - 100;
    }

    @Override
    public void paint(Graphics g) {
        this.simulationController = this.simulationProject.getSimulationController();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        drawColorBar(g);
        drawAxes(g);
        calculateGraphicThickness(this.simulationController.getSimulationsQty());
        //showCompleteArray();
        drawCompleteArray(g);
    }

    private void showCompleteArray() {
        for (int i = 0; i < this.simulationController.getContainer().size(); i++) {
            System.out.println(this.simulationController.getContainer().get(i).getValue());
        }
    }

    private void drawAxes(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawLine(50, 20, 50, getHeight() - 50);
        g.drawLine(50, getHeight() - 50, getWidth() - 100, getHeight() - 50);
    }

    private void drawColorBar(Graphics g) {
        int minimum, maximum, height;

        minimum = 100;
        maximum = 500;
        height = 1;

        for (int i = 0; i < (maximum - minimum); i++) {
            float f = 0.75f * i / (float) (maximum - minimum);
            g.setColor(Color.getHSBColor(0.75f - f, 1.0f, 1.0f));
            g.fillRect(getWidth() - 40, height * i + 50, 20, height);
        }
    }

    public float colorForValue(double value) {
        return (float) (((0.75 - 0.0) * (value - this.simulationController.getMinValue())) / (this.simulationController.getMaxValue() - this.simulationController.getMinValue())) + 0;
    }

    public void drawPoint(Graphics g, double value, int x, int y) {
        g.setColor(Color.getHSBColor(colorForValue(value), 1.0f, 1.0f));
        g.fillRect(x, y, this.thickness, 1);
    }

    public void drawArray(Graphics g, int x, ArrayList<Content> contents) {
        int y = getHeight() - 53;
        for (Content content : contents) {
            drawPoint(g, content.getValue(), x, y);
            y--;
        }
    }

    public void calculateGraphicThickness(int value) {
        this.thickness = (this.getWidth() - 150) / value;
    }

    public void drawCompleteArray(Graphics g) {
        int y = getHeight() - 53;
        int x = 51;
        int previousCounter = this.simulationController.getContainer().get(0).getBelongingRange();
        int counter;
        for (int i = 0; i < this.simulationController.getContainer().size(); i++) {
            drawPoint(g, this.simulationController.getContainer().get(i).getValue(), x, y);
            y--;
            counter = this.simulationController.getContainer().get(i).getBelongingRange();
            //System.out.println("Counter: " + counter);
            if (counter != previousCounter) {
                previousCounter = counter;
                x = x + this.thickness;
                y = getHeight() - 53;
            }
        }
    }

    public int getxPlotRange() {
        return xPlotRange;
    }

    public void setxPlotRange(int xPlotRange) {
        this.xPlotRange = xPlotRange;
    }

    public int getThickness() {
        return thickness;
    }

    public void setThickness(int thickness) {
        this.thickness = thickness;
    }
}
