package ui;

import helpers.Content;
import helpers.SimulationController;
import project.SimulationProject;

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
        drawAxis(g);
        calculateGraphicThickness(this.simulationController.getSimulationsQty());
        drawCompleteArray(g);
    }

    private void drawAxis(Graphics g) {
        g.setColor(Color.BLACK);
        drawXAxis(g);
        drawYAxis(g);


    }

    private void drawYAxis(Graphics g) {
        g.drawLine(50, 20, 50, getHeight() - 50);
        int range;
        int res = (int) (this.simulationProject.getFinalValue() - this.simulationProject.getInitialValue());

        range = (this.getHeight() - 80) / res;
        int y = this.getHeight() - 51;

        for (int i = (int) this.simulationProject.getInitialValue(); i <= (int) this.simulationProject.getFinalValue(); i++) {
            g.drawString(String.valueOf(i), 37, y);
            y = y - range;
        }
    }

    private void drawXAxis(Graphics g) {
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
        return (float) ((0.75 * (value - this.simulationController.getMinValue())) / (this.simulationController.getMaxValue() - this.simulationController.getMinValue()));
    }

    public void drawPoint(Graphics g, double value, int x, int y) {
        g.setColor(Color.getHSBColor(0.75f - colorForValue(value), 1.0f, 1.0f));
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
        this.thickness = (this.getWidth() - 250) / value;
    }

    public void drawCompleteArray(Graphics g) {
        int y = this.getHeight() - 53;
        int x = 51;
        int previousCounter = this.simulationController.getContainer().get(0).getBelongingRange();
        int counter;
        for (int i = 0; i < this.simulationController.getContainer().size(); i++) {
            counter = this.simulationController.getContainer().get(i).getBelongingRange();
            if (counter != previousCounter) {
                System.out.println(previousCounter + "-> Change -> " + counter);
                previousCounter = counter;
                x = x + this.thickness;
                y = this.getHeight() - 53;
            }
            drawPoint(g, this.simulationController.getContainer().get(i).getValue(), x, y);
            y--;
        }
        System.out.println("Finished Draw");
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
