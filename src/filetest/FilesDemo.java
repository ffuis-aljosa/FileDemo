package filetest;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Sljuka
 */
public class FilesDemo {

    static void copyTextFileByteByByte() {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {

            File file = new File(".\\files\\input.txt");

            in = new FileInputStream(file);
            out = new FileOutputStream(".\\files\\output.txt");

            int data;

            while ((data = in.read()) != -1) {
                out.write(data);
            }

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(null, ex.toString());

        } finally {

            JOptionPane.showMessageDialog(null, "Kopiranje gotovo");

            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }

            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        }
    }

    static void copyTextFileCharByChar() {
        FileReader in = null;
        FileWriter out = null;

        try {

            File file = new File(".\\files\\input.txt");

            in = new FileReader(file);
            out = new FileWriter(".\\files\\output.txt");

            int data;

            while ((data = in.read()) != -1) {
                out.write(data);
            }

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(null, ex.toString());

        } finally {

            JOptionPane.showMessageDialog(null, "Kopiranje gotovo");

            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }

            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        }
    }

    static void readTextFileLineByLine() {
        FileReader in = null;
        BufferedReader bin = null;

        try {

            File file = new File(".\\files\\words.txt");

            in = new FileReader(file);
            bin = new BufferedReader(in);

            String data;
            ArrayList<String> rijeci = new ArrayList<>();

            while ((data = bin.readLine()) != null) {
                rijeci.add(data);
            }

            int d = rijeci.size();

            Random r = new Random();
            int randomIndex = r.nextInt(d);

            JOptionPane.showMessageDialog(null, rijeci.get(randomIndex));

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        } finally {
            if (bin != null) {
                try {
                    bin.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }

            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, ex.toString());
                }
            }
        }
    }

    static void createXmlFile() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.newDocument();

            Element root = doc.createElement("rezultati");
            doc.appendChild(root);

            String[] imena = {"aljosa", "dragana", "jelenav", "jelenar", "maja"};
            int[] bodovi = {1000, 900, 800, 700, 600};

            for (int i = 0; i < 5; i++) {
                Element rez = doc.createElement("rezultat");
                root.appendChild(rez);

                rez.setAttribute("ime", imena[i]);
                rez.setAttribute("bodovi", "" + bodovi[i]);

                Element ime = doc.createElement("ime");
                ime.appendChild(doc.createTextNode(imena[i]));
                rez.appendChild(ime);

                Element bod = doc.createElement("bodovi");
                bod.appendChild(doc.createTextNode("" + bodovi[i]));
                rez.appendChild(bod);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(".\\files\\rezultati.xml"));

            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    static void readFromXmlFile() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            
            Document doc = db.parse(new File(".\\files\\rezultati.xml"));
            
            doc.getDocumentElement().normalize();
            
            NodeList nodeList = doc.getElementsByTagName("rezultat");
            
            int d = nodeList.getLength();
            
            for (int i = 0; i < d; i++) {
                Node node = nodeList.item(i);
                
                System.out.println("Cvor: " + node.getNodeName());
                
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elm = (Element) node;
                    
                    System.out.println("Ime: " + elm.getAttribute("ime"));
                    System.out.println("Bodovi: " + elm.getAttribute("bodovi"));
                }
            }
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    static void openProjectFolder() {
        try {
            File projectFolder = new File("");
            Desktop.getDesktop().open(projectFolder.getAbsoluteFile());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
}
