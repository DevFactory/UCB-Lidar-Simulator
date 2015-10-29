/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import files.FileWriter;
import java.util.ArrayList;
import lidar.Lidar;

/**
 *
 * @author oscar_sgc
 */
public class SimulationProject {

    private Lidar lidar = new Lidar();
    FileWriter fileWriter = new FileWriter();
    private ArrayList<Number> data;
    private String projectName;
    private String projectLocation;
    private static SimulationProject simulationProject = new SimulationProject();
    
    private SimulationProject(){
        
    }   
    
    public void saveProject(){
        fileWriter.saveProject(this);
    }
    
    private SimulationProject(String projectName, String projectLocation) {
        this.projectName = projectName;
        this.projectLocation = projectLocation;
    }

    private SimulationProject(Lidar lidar) {
        this.lidar = lidar;
    }
    
    public static SimulationProject getInstance(){
        if(simulationProject == null){
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
}
