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
        initializeComponents();
    }

    public void initializeComponents() {
        try {
            this.builder = this.builderFactory.newDocumentBuilder();
            this.transformer = this.transformerFactory.newTransformer();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        this.document = this.builder.newDocument();
    }

    public Element createRootElement(String projectName) {
        Element rootElement = this.document.createElement("Project");
        Attr name = this.document.createAttribute("name");
        name.setValue(projectName);
        rootElement.setAttributeNode(name);
        return rootElement;
    }

    public Element createInitialValueElement(double initialValue) {
        Element initialValueElement = this.document.createElement("element");
        Attr name = this.document.createAttribute("name");
        name.setValue("Initial Value");
        initialValueElement.setAttributeNode(name);
        initialValueElement.appendChild(this.document.createTextNode(String.valueOf(initialValue)));
        return initialValueElement;
    }

    private Element createFinalValueElement(double finalValue) {
        Element finalValueElement = this.document.createElement("element");
        Attr name = this.document.createAttribute("name");
        name.setValue("Final Value");
        finalValueElement.setAttributeNode(name);
        finalValueElement.appendChild(this.document.createTextNode(String.valueOf(finalValue)));
        return finalValueElement;
    }

    public Element createAtmosphereComponent(double initialValue, double finalValue) {
        Element atmosphereComponent = this.document.createElement("component");
        Attr name = this.document.createAttribute("name");
        name.setValue("Atmosphere");
        atmosphereComponent.setAttributeNode(name);
        atmosphereComponent.appendChild(createInitialValueElement(initialValue));
        atmosphereComponent.appendChild(createFinalValueElement(finalValue));
        return atmosphereComponent;
    }

    public Element createTelescopeComponent(Telescope telescope) {
        Element telescopeComponent = this.document.createElement("component");
        Attr name = this.document.createAttribute("name");
        name.setValue("Telescope");
        telescopeComponent.setAttributeNode(name);
        return telescopeComponent;
    }

    public Element createLaserComponent(Laser laser) {
        Element laserComponent = this.document.createElement("component");
        Attr name = this.document.createAttribute("name");
        name.setValue("Laser");
        laserComponent.setAttributeNode(name);
        return laserComponent;
    }

    public Element createMonochromatorComponent(Monochromator monochromator) {
        Element monochromatorComponent = this.document.createElement("component");
        Attr name = this.document.createAttribute("name");
        name.setValue("Monochromator");
        monochromatorComponent.setAttributeNode(name);
        return monochromatorComponent;
    }

    public Element createLinkBudgetComponent(LinkBudget linkBudget) {
        Element linkBudgetComponent = this.document.createElement("component");
        Attr name = this.document.createAttribute("name");
        name.setValue("LinkBudget");
        linkBudgetComponent.setAttributeNode(name);
        return linkBudgetComponent;
    }

    public void createDocument(String projectName, SimulationProject project) {
        Element rootElement = createRootElement(projectName);
        if (project.getData() != null) {
            rootElement.appendChild(createAtmosphereComponent(project.getData().get(0).doubleValue(), project.getData().get(project.getData().size() - 1).doubleValue() + 1));
        } else {
            rootElement.appendChild(createAtmosphereComponent(0, 0));
        }
        rootElement.appendChild(createLaserComponent(project.getLidar().getLaser()));
        rootElement.appendChild(createTelescopeComponent(project.getLidar().getTelescope()));
        rootElement.appendChild(createMonochromatorComponent(project.getLidar().getMonochromator()));
        rootElement.appendChild(createLinkBudgetComponent(project.getLidar().getLinkBudget()));
        this.document.appendChild(rootElement);//Estructura principal

    }

    public void saveProject(SimulationProject project) {
        createDocument(project.getProjectName(), project);
        this.document.getDocumentElement().normalize();
        this.source = new DOMSource(this.document);
        StreamResult results = new StreamResult(new File(project.getProjectLocation() + project.getProjectName() + ".xml"));

        try {
            transformer.transform(source, results);
        } catch (TransformerException e) {
            e.printStackTrace();
        }

        System.out.println("File saved!");
    }

    public static void main(String args[]) {
        SimulationProject test = SimulationProject.getInstance();
        test.setProjectName("Proyecto Prueba");
        test.setProjectLocation("/Users/oscar_sgc/Documents/");
        new FileWriter().saveProject(test);
    }

}
