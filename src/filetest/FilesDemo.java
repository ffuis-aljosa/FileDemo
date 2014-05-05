package filetest;

import java.awt.Desktop;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
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

    /**
     * Kopira tekstualnu datoteku "input.txt" u "output.txt" bajt po bajt.
     * Obje datoteke se nalaze u poddirektorijumu "files" glavnog
     * direktorijuma projekta.
     * <p>
     * Ovakav tip kopiranja je najpodobniji za "binarne" datoteke:
     * slike, audio i video zapise itd.
     */
    public static void copyTextFileByteByByte() {
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            File file = new File(".\\files\\input.txt");
            
            /*
             * Input i output streamove možemo inicijalizovati proslijeđujući
             * im ili ciljnu datoteku ili put do ciljne datoteke.
             */
            in = new FileInputStream(file);
            out = new FileOutputStream(".\\files\\output.txt");

            int data;

            /*
             * Metoda read klase FileInputStream će vratiti -1 kada ne bude imala
             * više šta da pročita, tj. kada dođe do kraja datoteke.
             */
            while ((data = in.read()) != -1) {
                out.write(data);
            }

        } catch (IOException ex) {

            JOptionPane.showMessageDialog(null, ex.toString());

        } finally {

            // Obavezno uvijek zatvoriti I/O tokove nakon korištenja
            
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

    /**
     * Kopira tekstualnu datoteku "input.txt" u "output.txt" karakter po karatker.
     * Obje datoteke se nalaze u poddirektorijumu "files" glavnog
     * direktorijuma projekta.
     * <p>
     * Ovakav tip kopiranja je najpodobniji za tekstualne datoteke.
     */
    public static void copyTextFileCharByChar() {
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

    /**
     * Učitava sadržaj tekstualne datoteke "words.txt" u listu stringova.
     * Učitavanje se vrši liniju po liniju. Zatim, proizvoljno bira jednu riječ
     * i prikazuje je.
     */
    public static void readTextFileLineByLine() {
        FileReader in = null;
        //BufferedReader dozvoljava čitanje većeg "komada" datoteke odjednom.
        BufferedReader bin = null;

        try {

            File file = new File(".\\files\\words.txt");

            in = new FileReader(file);
            // Za inicijalizaciju, BufferedReader zahtjeva otvoren FileReader tok
            bin = new BufferedReader(in);

            String data;
            ArrayList<String> rijeci = new ArrayList<>();

            /*
             * Metoda readLine klase BufferedReader učitava jedan red teksta iz
             * datoteke. Vraća null ukoliko dođe do kraja datoteke.
             */
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

    /**
     * U poddirektorijumu "files" projekta pravi XML datoteku "rezultati.xml".
     * Datoteka sadrži korjeni tag "rezultati" koji ima niz djece tagova "rezultat".
     * Svaki od njih sadrži atribute koji obezbjeđuju podatke o imenu i broju bodova
     * igrača.
     * 
     * XML dokument možete otvoriti u omiljenom Veb pregledaču radi bolje preglednosti.
     */
    public static void createSimpleXmlFile() {
        try {
            /*
             * Da bismo napravili XML dokument, treba nam DocumentBuilder, za
             * šta nam treba DocumentBuilderFactory. Tvorci ovih klasa su ovo
             * ovako organizovali. Vjerovaćemo da imaju dobar razlog za to.
             */
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.newDocument();
            
            /*
             * Mogli smo i ukratko:
             * Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
             */

            // Svaki XML dokument treba imati jedan korjeni element
            Element root = doc.createElement("rezultati");
            doc.appendChild(root);

            String[] imena = {"aljosa", "dragana", "jelenav", "jelenar", "maja"};
            int[] bodovi = {1000, 900, 800, 700, 600};

            for (int i = 0; i < 5; i++) {
                Element rez = doc.createElement("rezultat");
                root.appendChild(rez);

                rez.setAttribute("ime", imena[i]);
                rez.setAttribute("bodovi", "" + bodovi[i]);
            }

            /*
             * Za transformaciju drveta u XML datoteku koristimo Transformer.
             * Mogli smo ukratko:
             * Transformer transformer = TransformerFactory.newInstance().newTransformer();
             */
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(".\\files\\rezultati.xml"));

            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    /**
     * Učitava XML datoteku "rezultati.xml" iz poddirektorijuma "files" projekta.
     * Zatim dohvata sve "rezultat" tagove i na konzolu ispisuje njegove atribute
     * "ime" i "bodovi"
     */
    public static void readSimpleXmlFile() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            
            // Učitavamo XML drvo iz datoteke
            Document doc = db.parse(new File(".\\files\\rezultati.xml"));
            
            // Šta tačno sve normalize radi pogledati u dokumentaciji
            doc.getDocumentElement().normalize();
            
            /*
             * DOM (Document Object Model) je način predstavljanja XML drveta
             * (i drveta u bilo kom drugom markup jeziku) u vidu objekata klasa.
             * Među njima su Document i Element klase. One imaju metode pretraživanja
             * i pristupanja djeci, roditeljima, braći itd. u drvetu.
             */
            NodeList nodeList = doc.getElementsByTagName("rezultat");
            
            int d = nodeList.getLength();
            
            for (int i = 0; i < d; i++) {
                Node node = nodeList.item(i);
                
                System.out.println("Cvor: " + node.getNodeName());
                
                /*
                 * Čvor može biti raznih tipova: dokument, komentar, obični element,
                 * tekst itd. Mi, u ovom slučaju, tražimo samo obične elemente.
                 * Ovo radimo jer želimo da čvore (Node) kastujemo u klasu Element,
                 * koja sadrži metodu getAttribute.
                 */
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
    
    /**
     * U poddirektorijumu "files" projekta pravi XML datoteku "studenti.xml".
     * Datoteka sadrži kompleksnije struktuirane podatke o studentima:
     * ime, prezime, da li su redovni i spisak ocjena.
     */
    public static void createComplexXmlFile() {
        try {
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
            
            Element root = doc.createElement("studenti");
            doc.appendChild(root);
            
            String[] imena = { "Ivan", "Marija", "Boban" };
            String[] prezimena = { "Petrovic", "Fustar", "Kraljevic" };
            boolean[] daLiSuRedovni = { false, true, false };
            int[][] ocjene = {
                { 10, 9, 9 },
                { 9, 7, 10, 9 },
                { 6, 9, 8 } 
            };
            
            for (int i = 0; i < 3; i++) {
                Element student = doc.createElement("student");
                student.setAttribute("redovan", "" + daLiSuRedovni[i]);

                Element name = doc.createElement("ime");
                name.appendChild(doc.createTextNode(imena[i]));
                student.appendChild(name);
                
                Element lastName = doc.createElement("prezime");
                lastName.appendChild(doc.createTextNode(prezimena[i]));
                student.appendChild(lastName);
                
                Element ocjeneElm = doc.createElement("ocjene");
                
                for (int j = 0; j < ocjene[i].length; j++) {
                    Element ocjena = doc.createElement("ocjena");
                    ocjena.appendChild(doc.createTextNode("" + ocjene[i][j]));
                    ocjeneElm.appendChild(ocjena);
                }
                
                student.appendChild(ocjeneElm);
                
                root.appendChild(student);
            }

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(".\\files\\studenti.xml"));

            transformer.transform(source, result);

        } catch (ParserConfigurationException | TransformerException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    /**
     * Čita podatke o studentima iz datoteke "studenti.xml" podfoldera "files".
     * Pročitane podatke smješta u dvodimenzionalni niz i prikazuje u tabeli.
     */
    public static void readComplexXmlFile() {
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
           
            Document doc = db.parse(new File(".\\files\\studenti.xml"));
            doc.getDocumentElement().normalize();
            
            // Uzmemo sve studente
            NodeList nodeList = doc.getElementsByTagName("student");
            int d = nodeList.getLength();
            
            // Podatke smještamo u dvodimenzionalni niz sa d redova i 4 kolone
            Object[][] data = new Object[d][4];
            
            for (int i = 0; i < d; i++) {
                Node node = nodeList.item(i);
                
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element elm = (Element) node;
                    
                    /*
                     * Od trenutnog studenta nađemo prvi podtag (djete tag) naziva "ime"
                     * i uzmemo njegov tekstualni sadržaj. To spasimo kao prvu kolonu reda tabele.
                     * Slično uradimo i sa prezimenom.
                     */
                    data[i][0] = elm.getElementsByTagName("ime").item(0).getTextContent();
                    data[i][1] = elm.getElementsByTagName("prezime").item(0).getTextContent();
                    
                    /*
                     * Iako smo ovo mogli na razne načine da uradimo, ovaj put ćemo ovako:
                     * Od trenutnog studenta uzmemo prvo djete naziva "ocjene" i uzmemo svu
                     * njegovu djecu. Napravili smo XML datoteku da to budu ocjene.
                     * Sada pokupimo njihove vrijednosti i nadovežemo ih u jedan string.
                     */
                    NodeList ocjeneElms = elm.getElementsByTagName("ocjene").item(0).getChildNodes();
                    int l = ocjeneElms.getLength();
                    
                    String ocjene = "";
                    for (int j = 0; j < l; j++) {
                        ocjene += ocjeneElms.item(j).getTextContent();
                        if (j < l-1)
                            ocjene += ", ";
                    }
                    
                    data[i][2] = ocjene;
                    data[i][3] = elm.getAttribute("redovan");
                }
            }
            
            String[] colNames = { "Ime", "Prezime", "Ocjene", "Redovan" };
            // Napravimo JTable od prikupljenih podataka i sa nazivima kolona
            JTable table = new JTable(data, colNames);
            // Onemogućimo mjenjanje vrijednosti tabele
            table.setEnabled(false);
            
            // Tabelu prikažemo u dijalogu (da ne "prljamo" postojeći prozor)
            JDialog dialog = new JDialog();
            dialog.setTitle("Podaci o studentima");
            /*
             * Bitno je ne dodati samu tabelu, već unutar JScrollPane-a, jer mu
             * on prikaže zaglavlje i doda mogućnost skrolovanja ako tabela postane
             * predugačka.
             */
            dialog.add(new JScrollPane(table));
            dialog.pack();
            dialog.setVisible(true);
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
    
    /**
     * Otvara glavni direktorijum projekta u File Explorer-u, radi lakšeg pristupa
     * datotekama korištenim u programu.
     */
    public static void openProjectFolder() {
        try {
            File projectFolder = new File("");
            Desktop.getDesktop().open(projectFolder.getAbsoluteFile());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
}
