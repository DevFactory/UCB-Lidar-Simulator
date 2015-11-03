package files;

import atmosphere.Mie;
import atmosphere.Pressure;
import atmosphere.Rayleigh;
import laser.Laser;
import lidar.Lidar;
import linkbudget.LinkBudget;
import monochromator.Monochromator;
import org.w3c.dom.*;

import telescope.Telescope;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

import project.SimulationProject;

public class FileWriter {

    private Document document;
    private DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
    private DocumentBuilder builder;
    private TransformerFactory transformerFactory = TransformerFactory.newInstance();
    private Transformer transformer;
    private DOMSource source = new DOMSource();
    private StreamResult result;

    public FileWriter() {

    }

    public void saveProject(SimulationProject project) {

        try {

            this.builderFactory = DocumentBuilderFactory.newInstance();
            this.builder = builderFactory.newDocumentBuilder();

            this.document = builder.newDocument();

            Element rootElement = document.createElement("Project");
            rootElement.setAttribute("name", project.getProjectName());
            document.appendChild(rootElement);

            Element atmosphere = document.createElement("Atmosphere");
            rootElement.appendChild(atmosphere);

            double initialValue;
            double finalValue;

            if (project.getData() != null) {
                initialValue = project.getData().get(0).doubleValue();
                finalValue = project.getData().get(project.getData().size() - 1).doubleValue();
            } else {
                initialValue = 0.0;
                finalValue = 0.0;
            }

            Element initialValueElement = document.createElement("InitialValue");
            initialValueElement.appendChild(document.createTextNode(String.valueOf(initialValue)));
            atmosphere.appendChild(initialValueElement);

            Element finalValueElement = document.createElement("FinalValue");
            finalValueElement.appendChild(document.createTextNode(String.valueOf(finalValue)));
            atmosphere.appendChild(finalValueElement);

            Element telescope = document.createElement("Telescope");
            rootElement.appendChild(telescope);

            Element laser = document.createElement("Laser");
            rootElement.appendChild(laser);

            Element monochromator = document.createElement("Monochromator");
            rootElement.appendChild(monochromator);

            Element linkBudget = document.createElement("LinkBudget");
            rootElement.appendChild(linkBudget);
            this.document.getDocumentElement().normalize();

            this.transformerFactory = TransformerFactory.newInstance();
            this.transformer = transformerFactory.newTransformer();
            this.source = new DOMSource(document);
            this.result = new StreamResult(new File(project.getProjectLocation() + project.getProjectName() + ".xml"));

            transformer.transform(source, result);

            System.out.println("File saved!");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }

    }


    public static void main(String args[]) {
        SimulationProject test = SimulationProject.getInstance();
        test.setProjectName("Proyecto Prueba");
        test.setProjectLocation("/Users/oscar_sgc/Desktop/");
        new FileWriter().saveProject(test);

    }
}

