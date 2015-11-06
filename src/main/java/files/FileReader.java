package files;

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

/**
 * Created by oscar_sgc on 10/14/15.
 */
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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String argv[]) {

        FileReader fr = new FileReader();
        fr.openFile("/Users/oscar_sgc/Desktop/Prueba.xml");
    }
}
