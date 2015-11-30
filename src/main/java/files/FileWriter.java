package files;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
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

            Element colors = document.createElement("Colors");

            Element temperatureColor = document.createElement("Temperature");
            temperatureColor.appendChild(document.createTextNode(String.valueOf(project.getColorsInString().get(0))));
            colors.appendChild(temperatureColor);

            Element pressureColor = document.createElement("Pressure");
            pressureColor.appendChild(document.createTextNode(String.valueOf(project.getColorsInString().get(1))));
            colors.appendChild(pressureColor);

            Element mieColor = document.createElement("Mie");
            mieColor.appendChild(document.createTextNode(String.valueOf(project.getColorsInString().get(2))));
            colors.appendChild(mieColor);

            Element alphaColor = document.createElement("Alpha");
            alphaColor.appendChild(document.createTextNode(String.valueOf(project.getColorsInString().get(3))));
            colors.appendChild(alphaColor);

            Element betaColor = document.createElement("Beta");
            betaColor.appendChild(document.createTextNode(String.valueOf(project.getColorsInString().get(4))));
            colors.appendChild(betaColor);

            Element atmosphereColor = document.createElement("AtmosphereColor");
            atmosphereColor.appendChild(document.createTextNode(String.valueOf(project.getColorsInString().get(5))));
            colors.appendChild(atmosphereColor);

            atmosphere.appendChild(colors);

            Element telescope = document.createElement("Telescope");
            rootElement.appendChild(telescope);

            Element shadeDiameter = document.createElement("ShadeDiameter");
            shadeDiameter.appendChild(document.createTextNode(String.valueOf(project.getSimpleSimulation().getTelescope().getShadeDiameter())));
            telescope.appendChild(shadeDiameter);

            Element diameter = document.createElement("Diameter");
            diameter.appendChild(document.createTextNode(String.valueOf(project.getSimpleSimulation().getTelescope().getDiameter())));
            telescope.appendChild(diameter);

            Element focalLenght = document.createElement("FocalLenght");
            focalLenght.appendChild(document.createTextNode(String.valueOf(project.getSimpleSimulation().getTelescope().getFocalLength())));
            telescope.appendChild(focalLenght);

            Element laser = document.createElement("Laser");
            rootElement.appendChild(laser);

            Element waveLength = document.createElement("WaveLength");
            waveLength.appendChild(document.createTextNode(String.valueOf(project.getSimpleSimulation().getLaser().getEmissionWavelength())));
            laser.appendChild(waveLength);

            Element divergence = document.createElement("Divergence");
            divergence.appendChild(document.createTextNode(String.valueOf(project.getSimpleSimulation().getLaser().getDivergence())));
            laser.appendChild(divergence);

            Element energy = document.createElement("Energy");
            energy.appendChild(document.createTextNode(String.valueOf(project.getSimpleSimulation().getLaser().getEnergy())));
            laser.appendChild(energy);

            Element monochromator = document.createElement("Monochromator");
            rootElement.appendChild(monochromator);

            Element type = document.createElement("Type");
            type.appendChild(document.createTextNode(project.getSimpleSimulation().getMonochromator().getApdName()));
            monochromator.appendChild(type);

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
