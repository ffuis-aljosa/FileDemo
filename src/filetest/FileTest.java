/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filetest;

/**
 *
 * @author Korisnik
 */
public class FileTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        FilesDemoFrame frame = new FilesDemoFrame();
        frame.setVisible(true);
        
        /*
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
            Logger.getLogger(FileTest.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        
        
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            
            Document doc = db.newDocument();
            
            Element root = doc.createElement("rezultati");
            doc.appendChild(root);
            
            String[] imena = { "aljosa", "dragana", "jelenav", "jelenar", "maja" };
            int[] bodovi = { 1000, 900, 800, 700, 600 };
            
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
            
        } catch (ParserConfigurationException ex) {
            System.out.println(ex.toString());
        } catch (TransformerConfigurationException ex) {
            System.out.println(ex.toString());
        } catch (TransformerException ex) {
            System.out.println(ex.toString());
        }
        */
    }
}
