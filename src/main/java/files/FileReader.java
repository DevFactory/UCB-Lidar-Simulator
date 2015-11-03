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
import java.io.File;
import java.io.IOException;

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

            NodeList nList = this.document.getElementsByTagName("Atmosphere");
            Node nNode = nList.item(0);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element currentElement = (Element) nNode;
                simulationProject.setInitialValue(Double.parseDouble(currentElement.getElementsByTagName("InitialValue").item(0).getTextContent()));
                simulationProject.setFinalValue(Double.parseDouble(currentElement.getElementsByTagName("FinalValue").item(0).getTextContent()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String argv[]) {


    }
}
