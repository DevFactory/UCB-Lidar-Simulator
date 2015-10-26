package files;

import atmosphere.Mie;
import atmosphere.Pressure;
import atmosphere.Rayleigh;
import atmosphere.Temperature;
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

    public Element createTemperatureElement(Temperature temperature) {
        Element temperatureElement = this.document.createElement("element");
        Attr name = this.document.createAttribute("name");
        name.setValue("Temperature");
        temperatureElement.setAttributeNode(name);
        return temperatureElement;
    }

    private Element createPressureElement(Pressure pressure) {
        Element pressureElement = this.document.createElement("element");
        Attr name = this.document.createAttribute("name");
        name.setValue("Pressure");
        pressureElement.setAttributeNode(name);
        pressureElement.appendChild(this.document.createTextNode("prueba"));
        return pressureElement;
    }

    private Element createMieElement(Mie mie) {
        Element mieElement = this.document.createElement("element");
        Attr name = this.document.createAttribute("name");
        name.setValue("Mie");
        mieElement.setAttributeNode(name);
        return mieElement;
    }

    private Element createRayleighElement(Rayleigh rayleigh) {
        Element rayleighElement = this.document.createElement("element");
        Attr name = this.document.createAttribute("name");
        name.setValue("Rayleigh");
        rayleighElement.setAttributeNode(name);
        return rayleighElement;
    }

    public Element createAtmosphereComponent(Temperature temperature, Pressure pressure, Mie mie, Rayleigh rayleigh) {
        Element atmosphereComponent = this.document.createElement("component");
        Attr name = this.document.createAttribute("name");
        name.setValue("Atmosphere");
        atmosphereComponent.setAttributeNode(name);
        atmosphereComponent.appendChild(createTemperatureElement(temperature));
        atmosphereComponent.appendChild(createPressureElement(pressure));
        atmosphereComponent.appendChild(createMieElement(mie));
        atmosphereComponent.appendChild(createRayleighElement(rayleigh));
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

    public void createDocument(String projectName, Lidar lidar) {
        Element rootElement = createRootElement(projectName);
        rootElement.appendChild(createAtmosphereComponent(lidar.getTemperature(), lidar.getPressure(), lidar.getMie(), lidar.getRayleigh()));
        rootElement.appendChild(createLaserComponent(lidar.getLaser()));
        rootElement.appendChild(createTelescopeComponent(lidar.getTelescope()));
        rootElement.appendChild(createMonochromatorComponent(lidar.getMonochromator()));
        rootElement.appendChild(createLinkBudgetComponent(lidar.getLinkBudget()));
        this.document.appendChild(rootElement);//Estructura principal

    }

    public void saveProject(String projectName, String location, Lidar lidar) {
        createDocument(projectName, lidar);
        this.document.getDocumentElement().normalize();
        this.source = new DOMSource(this.document);
        StreamResult results = new StreamResult(new File(location + projectName + ".xml"));

        try {
            transformer.transform(source, results);
        } catch (TransformerException e) {
            e.printStackTrace();
        }

        System.out.println("File saved!");
    }

    public static void main(String args[]) {
        new FileWriter().saveProject("Proyecto Prueba", "/Users/oscar_sgc/Documents/", new Lidar());

    }

}
