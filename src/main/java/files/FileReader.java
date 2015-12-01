package files;

import monochromator.Monochromator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import project.SimulationProject;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;

public class FileReader {


    private File file;
    private DocumentBuilderFactory documentBuilderFactory;
    private DocumentBuilder documentBuilder;
    private Document document;


    public FileReader() {

    }

    public boolean validFile(String fullFilePath) {
        this.file = new File(fullFilePath);
        this.documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            this.documentBuilder = this.documentBuilderFactory.newDocumentBuilder();
            this.document = this.documentBuilder.parse(this.file);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (this.document.getDocumentElement().getNodeName() == "Project") {
            return true;
        } else {
            return false;
        }
    }

    private void setFirstAPD(int wavelength) {
        SimulationProject simulationProject = SimulationProject.getInstance();
        double idb, rioAux = 0;
        switch (wavelength) {
            case 0:

                rioAux = 30e-3;
                break;
            case 1:

                rioAux = 55e-3;
                break;
        }
        idb = 0.01e-9 / 7e5;
        Monochromator monochromator = new Monochromator(7e5, 1.3, 0, rioAux, 0.01e-9, idb, 50, "R7400U-03");
        simulationProject.getSimpleSimulation().setMonochromator(monochromator);
    }

    private void setSecondAPD(int wavelength) {
        SimulationProject simulationProject = SimulationProject.getInstance();
        double idb, rioAux = 0;
        switch (wavelength) {
            case 0:
                rioAux = 30e-3;
                break;
            case 1:
                rioAux = 55e-3;
                break;
        }
        idb = 0.08e-9 / 1e6;
        Monochromator monochromator = new Monochromator(1e6, 1.3, 0, rioAux, 0.08e-9, idb, 50, "R7400P-03");
        simulationProject.getSimpleSimulation().setMonochromator(monochromator);
    }

    private void setThirdAPD() {
        SimulationProject simulationProject = SimulationProject.getInstance();
        Monochromator monochromator = new Monochromator(100, 4, 7.73e-8, 340e-3, 1.19e-10, 10e6, 7.2e-12, 11e3, "C30956E");
        simulationProject.getSimpleSimulation().setMonochromator(monochromator);
    }

    private void setFourthAPD() {
        SimulationProject simulationProject = SimulationProject.getInstance();
        Monochromator monochromator = new Monochromator(150, 4.5, 7.64e-8, 240e-3, 3.10e-10, 0, 5e-12, 5750 * 20.3, "oldAPD");
        simulationProject.getSimpleSimulation().setMonochromator(monochromator);
    }


    public void openFile(String fullFilePath) {
        SimulationProject simulationProject = SimulationProject.getInstance();
        try {
            this.file = new File(fullFilePath);
            this.documentBuilderFactory = DocumentBuilderFactory.newInstance();
            this.documentBuilder = this.documentBuilderFactory.newDocumentBuilder();
            this.document = this.documentBuilder.parse(this.file);
            this.document.getDocumentElement().normalize();

            String absolutePath = file.getAbsolutePath();
            String filePath = absolutePath.substring(0, absolutePath.lastIndexOf(File.separator));
            String name = this.document.getElementsByTagName("Project").item(0).getAttributes().item(0).getNodeValue();

            simulationProject.setProjectLocation(filePath + "/");
            simulationProject.setProjectName(name);

            NodeList nList = this.document.getElementsByTagName("Atmosphere");
            Node nNode = nList.item(0);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element currentElement = (Element) nNode;
                simulationProject.setInitialValue(Double.parseDouble(currentElement.getElementsByTagName("InitialValue").item(0).getTextContent()));
                simulationProject.setFinalValue(Double.parseDouble(currentElement.getElementsByTagName("FinalValue").item(0).getTextContent()));
                NodeList colorsList = ((Element) nNode).getElementsByTagName("Colors");
                Node auxNode = colorsList.item(0);
                if (auxNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element currentElementAux = (Element) nNode;
                    simulationProject.getColors().clear();
                    Color color;
                    try {
                        Field field = Class.forName("java.awt.Color").getField(currentElementAux.getElementsByTagName("Temperature").item(0).getTextContent());
                        color = (Color) field.get(null);
                        simulationProject.getColors().add(0, color);
                        field = Class.forName("java.awt.Color").getField(currentElementAux.getElementsByTagName("Pressure").item(0).getTextContent());
                        color = (Color) field.get(null);
                        simulationProject.getColors().add(1, color);
                        field = Class.forName("java.awt.Color").getField(currentElementAux.getElementsByTagName("Mie").item(0).getTextContent());
                        color = (Color) field.get(null);
                        simulationProject.getColors().add(2, color);
                        field = Class.forName("java.awt.Color").getField(currentElementAux.getElementsByTagName("Alpha").item(0).getTextContent());
                        color = (Color) field.get(null);
                        simulationProject.getColors().add(3, color);
                        field = Class.forName("java.awt.Color").getField(currentElementAux.getElementsByTagName("Beta").item(0).getTextContent());
                        color = (Color) field.get(null);
                        simulationProject.getColors().add(4, color);
                        field = Class.forName("java.awt.Color").getField(currentElementAux.getElementsByTagName("AtmosphereColor").item(0).getTextContent());
                        color = (Color) field.get(null);
                        simulationProject.getColors().add(5, color);
                    } catch (Exception e) {
                        color = null;
                    }
                }
            }


            NodeList laserList = this.document.getElementsByTagName("Laser");
            nNode = laserList.item(0);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element current = (Element) nNode;
                simulationProject.getSimpleSimulation().getLaser().setEmissionWavelength(Double.parseDouble(current.getElementsByTagName("WaveLength").item(0).getTextContent()));
                simulationProject.getSimpleSimulation().getLaser().setDivergence(Double.parseDouble(current.getElementsByTagName("Divergence").item(0).getTextContent()));
                simulationProject.getSimpleSimulation().getLaser().setEnergy(Double.parseDouble(current.getElementsByTagName("Energy").item(0).getTextContent()));
            }

            NodeList monochromatorList = this.document.getElementsByTagName("Monochromator");
            nNode = monochromatorList.item(0);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element current = (Element) nNode;
                simulationProject.getSimpleSimulation().getMonochromator().setApdName(current.getElementsByTagName("Type").item(0).getTextContent());
            }

            switch (simulationProject.getSimpleSimulation().getMonochromator().getApdName()) {
                case "R7400U-03":
                    setFirstAPD((int) simulationProject.getSimpleSimulation().getLaser().getEmissionWavelength());
                    break;
                case "R7400P-03":
                    setSecondAPD((int) simulationProject.getSimpleSimulation().getLaser().getEmissionWavelength());
                    break;
                case "C30956E":
                    setThirdAPD();
                    break;
                case "oldAPD":
                    setFourthAPD();
                    break;
            }
        } catch (
                Exception e
                )

        {
            e.printStackTrace();
        }
    }
}
