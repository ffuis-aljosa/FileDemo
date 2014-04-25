/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package filetest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Korisnik
 */
public class FileTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        FileReader in = null;
        FileWriter out = null;
        
        BufferedReader bin = null;
        
        try {
            in = new FileReader(".\\files\\input.txt");
            
            bin = new BufferedReader(in);
            
            String data;
            ArrayList<String> rezultati = new ArrayList<>();
            
            while ((data = bin.readLine()) != null) {
                rezultati.add(data);
            }
            
            for (String rez : rezultati) {
                int index = rez.lastIndexOf(' ');
                
                String ime = rez.substring(0, index);
                int bodovi = Integer.parseInt(rez.substring(index + 1));
                
                System.out.println("Ime: " + ime);
                System.out.println("Bodovi: " + bodovi);
            }
            
            
            /*
            out = new FileWriter(".\\files\\output.txt");
            
            bin = new BufferedReader(in);
            
            String data;
            ArrayList<String> rijeci = new ArrayList<>();
            while ((data = bin.readLine()) != null) {
                rijeci.add(data);
            }
            
            int d = rijeci.size();
            
            Random r = new Random();
            
            int randomIndex = r.nextInt(d);
            
            System.out.println(rijeci.get(randomIndex));
            */
            
        } catch (IOException ex) {
            Logger.getLogger(FileTest.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (bin != null) {
                try {
                    bin.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ex) {
                    Logger.getLogger(FileTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
