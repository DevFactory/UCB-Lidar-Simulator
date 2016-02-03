package org.gonzalez.lidar.ui;

import org.gonzalez.lidar.helpers.Content;
import org.gonzalez.lidar.helpers.SimulationController;
import org.gonzalez.lidar.project.SimulationProject;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
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
        calculateGraphicThickness(this.simulationController.getSimulationsQty());
        drawAxis(g);
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
            g.drawString(String.valueOf(i), 32, y);
            y = y - range;
        }

        Graphics2D g2 = (Graphics2D) g;
        AffineTransform orig = g2.getTransform();
        AffineTransform at = AffineTransform.getQuadrantRotateInstance(3);
        g2.setTransform(at);
        g2.drawString("Altitudes (Km.)", -(this.getHeight() / 2), 25);
        g2.setTransform(orig);
    }

    private void drawXAxis(Graphics g) {
        g.drawLine(50, getHeight() - 50, getWidth() - 100, getHeight() - 50);
        drawXAxisLegend(g);
    }

    private void drawXAxisLegend(Graphics g) {
        int initialHour = this.simulationController.getStartingTime().getHours();
        int endindgHour = this.simulationController.getEndingTime().getHours();
        ArrayList<String> times = new ArrayList<String>();
        for (int i = initialHour; i <= endindgHour; i++) {
            times.add(String.valueOf(i) + ":" + String.valueOf(this.simulationController.getStartingTime().getMinutes()));
        }
        int x = 50;
        int y = this.getHeight() - 30;
        for (int j = 0; j < times.size(); j++) {
            g.drawString(times.get(j), x, y);
            x = x + (this.thickness * this.simulationController.getSimulationsPerHour());
        }

        g.drawString("Time (Hours)", (this.getWidth() - 150) / 2, this.getHeight() - 15);
    }


    private void drawColorBar(Graphics g) {
        int minimum, maximum, height;

        minimum = 100;
        maximum = 500;
        height = 1;
        int finalI = 0;
        for (int i = 0; i < (maximum - minimum); i++) {
            float f = 0.75f * i / (float) (maximum - minimum);
            g.setColor(Color.getHSBColor(0.75f - f, 1.0f, 1.0f));
            g.fillRect(getWidth() - 40, height * i + 50, 20, height);
            finalI = i;
        }

        g.setColor(Color.BLACK);
        g.drawString(String.valueOf(this.simulationController.getMaxValue()), getWidth() - 60, 48); //Max Value
        g.drawString(String.valueOf(this.simulationController.getMinValue()), getWidth() - 60, finalI + 63);// Min Value

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
                previousCounter = counter;
                x = x + this.thickness;
                y = this.getHeight() - 53;
            }
            drawPoint(g, this.simulationController.getContainer().get(i).getValue(), x, y);
            y--;
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
