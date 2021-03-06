package org.gonzalez.lidar.ui;

import org.gonzalez.lidar.helpers.Content;
import org.gonzalez.lidar.helpers.OpticalReturnPowerController;
import org.gonzalez.lidar.project.SimulationProject;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;


public class OpticalReturnPowerPlotPanel extends JPanel {
    private OpticalReturnPowerController opticalReturnPowerController;
    SimulationProject simulationProject = SimulationProject.getInstance();
    private int xPlotRange;
    private int thickness;

    public OpticalReturnPowerPlotPanel() {
        this.xPlotRange = this.getWidth() - 100;
    }

    @Override
    public void paint(Graphics g) {
        this.opticalReturnPowerController = this.simulationProject.getOpticalReturnPowerController();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        drawColorBar(g);
        calculateGraphicThickness(this.opticalReturnPowerController.getSimulationsQty());
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
        int initialHour = this.opticalReturnPowerController.getStartingTime().getHours();
        int endindgHour = this.opticalReturnPowerController.getEndingTime().getHours();
        ArrayList<String> times = new ArrayList<String>();
        for (int i = initialHour; i <= endindgHour; i++) {
            times.add(String.valueOf(i) + ":" + String.valueOf(this.opticalReturnPowerController.getStartingTime().getMinutes()));
        }
        int x = 50;
        int y = this.getHeight() - 30;
        for (int j = 0; j < times.size(); j++) {
            g.drawString(times.get(j), x, y);
            x = x + (this.thickness * this.opticalReturnPowerController.getSimulationsPerHour());
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
        g.drawString(String.valueOf(this.opticalReturnPowerController.getMaxValue()), getWidth() - 60, 48); //Max Value
        g.drawString(String.valueOf(this.opticalReturnPowerController.getMinValue()), getWidth() - 60, finalI + 63);// Min Value

    }

    public float colorForValue(double value) {
        return (float) ((0.75 * (value - this.opticalReturnPowerController.getMinValue())) / (this.opticalReturnPowerController.getMaxValue() - this.opticalReturnPowerController.getMinValue()));
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
        int previousCounter = this.opticalReturnPowerController.getContainer().get(0).getBelongingRange();
        int counter;
        for (int i = 0; i < this.opticalReturnPowerController.getContainer().size(); i++) {
            counter = this.opticalReturnPowerController.getContainer().get(i).getBelongingRange();
            if (counter != previousCounter) {
                previousCounter = counter;
                x = x + this.thickness;
                y = this.getHeight() - 53;
            }
            drawPoint(g, this.opticalReturnPowerController.getContainer().get(i).getValue(), x, y);
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
