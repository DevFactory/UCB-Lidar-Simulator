/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import atmosphere.Atmosphere;
import files.FileReader;
import files.FileWriter;

import java.awt.*;
import java.util.ArrayList;

import lidar.Lidar;

/**
 * @author oscar_sgc
 */
public class SimulationProject {

    private Lidar lidar = new Lidar();
    FileWriter fileWriter = new FileWriter();
    FileReader fileReader = new FileReader();
    private ArrayList<Number> data;
    private ArrayList<Color> colors;
    private String projectName;
    private String projectLocation;
    private double initialValue;
    private double finalValue;

    private static SimulationProject simulationProject = new SimulationProject();

    private SimulationProject() {

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
    }

    private SimulationProject(String projectName, String projectLocation) {
        this.projectName = projectName;
        this.projectLocation = projectLocation;
    }

    private SimulationProject(Lidar lidar) {
        this.lidar = lidar;
    }

    public static SimulationProject getInstance() {
        if (simulationProject == null) {
            simulationProject = new SimulationProject();
        }
        return simulationProject;
    }

    public Lidar getLidar() {
        return this.lidar;
    }

    public void setLidar(Lidar lidar) {
        this.lidar = lidar;
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
        this.colors = colors;
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
}
