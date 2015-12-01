/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import files.FileReader;
import files.FileWriter;

import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import helpers.SimulationController;
import laser.Laser;
import monochromator.Monochromator;
import simulation.CompleteSimulation;
import simulation.SimpleSimulation;

/**
 * @author oscar_sgc
 */
public class SimulationProject {

    private SimpleSimulation simpleSimulation = new SimpleSimulation();
    private CompleteSimulation completeSimulation = new CompleteSimulation();
    private SimulationController simulationController = new SimulationController();
    FileWriter fileWriter = new FileWriter();
    FileReader fileReader = new FileReader();
    private ArrayList<Number> data;
    private ArrayList<Color> colors = new ArrayList<Color>();
    private ArrayList<String> colorsInString = new ArrayList<String>();
    private String projectName;
    private String projectLocation;
    private double initialValue;
    private double finalValue;


    private static SimulationProject simulationProject = new SimulationProject();

    private SimulationProject() {
        this.simpleSimulation = new SimpleSimulation();
        this.simpleSimulation.setLaser(new Laser());
        this.simpleSimulation.setMonochromator(new Monochromator());
        for (int i = 0; i < 10; i++) {
            this.colors.add(Color.RED);
        }
        colorsToString();
        setSimulationDefaultLaser();

        this.simulationController.setHoursQty(1);
        String str = "1:00";

        try {
            DateFormat formatter = new SimpleDateFormat("hh:mm");
            Date date = formatter.parse(str);
            this.simulationController.setStartingTime(date);
            str = "2:00";
            date = formatter.parse(str);
            this.simulationController.setEndingTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.simulationController.setSimulationsPerHour(1);
    }

    public void colorsToString() {
        this.colorsInString.clear();
        for (int i = 0; i < this.colors.size(); i++) {
            if (this.colors.get(i) == Color.RED) {
                this.colorsInString.add("RED");
            }

            if (this.colors.get(i) == Color.BLACK) {
                this.colorsInString.add("BLACK");
            }

            if (this.colors.get(i) == Color.BLUE) {
                this.colorsInString.add("BLUE");
            }

            if (this.colors.get(i) == Color.GREEN) {
                this.colorsInString.add("GREEN");
            }
        }
    }

    public void saveProject() {
        this.fileWriter.saveProject(this);
    }

    public void openProject(String fullFilePath) {
        this.fileReader.openFile(fullFilePath);
        this.data = new ArrayList<Number>();
        for (double i = this.initialValue; i < this.finalValue; i += 0.001) {
            this.data.add(i);
        }
        colorsToString();
    }

    private SimulationProject(String projectName, String projectLocation) {
        this.projectName = projectName;
        this.projectLocation = projectLocation;
    }

    public static SimulationProject getInstance() {
        if (simulationProject == null) {
            simulationProject = new SimulationProject();
        }
        return simulationProject;
    }

    public ArrayList<Number> getData() {
        return this.data;
    }

    public void setData(ArrayList<Number> data) {
        this.data = data;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectLocation() {
        return projectLocation;
    }

    public void setProjectLocation(String projectLocation) {
        this.projectLocation = projectLocation;
    }

    public ArrayList<Color> getColors() {
        return colors;
    }

    public void setColors(ArrayList<Color> colors) {
        this.colors.clear();
        this.colors = colors;
        colorsToString();
    }

    public void setSimulationDefaultLaser() {
        this.simpleSimulation.getLaser().setEmissionWavelength(532);
        this.simpleSimulation.getLaser().setEnergy(0.0035);
        this.simpleSimulation.getLaser().setDivergence(1);
    }

    public FileWriter getFileWriter() {
        return fileWriter;
    }

    public void setFileWriter(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    public FileReader getFileReader() {
        return fileReader;
    }

    public void setFileReader(FileReader fileReader) {
        this.fileReader = fileReader;
    }

    public double getInitialValue() {
        return initialValue;
    }

    public void setInitialValue(double initialValue) {
        this.initialValue = initialValue;
    }

    public double getFinalValue() {
        return finalValue;
    }

    public void setFinalValue(double finalValue) {
        this.finalValue = finalValue;
    }

    public ArrayList<String> getColorsInString() {
        return colorsInString;
    }

    public void setColorsInString(ArrayList<String> colorsInString) {
        this.colorsInString = colorsInString;
    }


    public SimpleSimulation getSimpleSimulation() {
        return simpleSimulation;
    }

    public void setSimpleSimulation(SimpleSimulation simpleSimulation) {
        this.simpleSimulation = simpleSimulation;
    }

    public CompleteSimulation getCompleteSimulation() {
        return completeSimulation;
    }

    public void setCompleteSimulation(CompleteSimulation completeSimulation) {
        this.completeSimulation = completeSimulation;
    }

    public SimulationController getSimulationController() {
        return simulationController;
    }

    public void setSimulationController(SimulationController simulationController) {
        this.simulationController = simulationController;
    }
}


