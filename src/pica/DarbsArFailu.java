package pica;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Queue;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class DarbsArFailu {
    static String aktivieFailaNosaukums = "aktivie_pasutijumi.txt";
    static String pabeigtieFailaNosaukums = "pabeigtie_pasutijumi.txt";
    
    // Saglabāt VISUS aktīvos pasūtījumus (pārraksta failu)
    static void saglabatAktivus(Queue<Pasutijums> aktiviePasutijumi) {
        try {
            // false nozīmē, ka pārrakstām failu (nevis append)
            FileWriter fw = new FileWriter(aktivieFailaNosaukums, false);
            PrintWriter pw = new PrintWriter(fw);
            
            for (Pasutijums p : aktiviePasutijumi) {
                pw.println(p.toString());
                pw.println("═══════════════════════════════════════════════════════");
                pw.println(); // Tukša rinda
            }
            
            pw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Kļūda ierakstot failā aktivie_pasutijumi.txt!", "Kļūda", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Saglabāt VISUS pabeigtos pasūtījumus (pārraksta failu)
    static void saglabatPabeigtos(ArrayList<Pasutijums> pabeigtiePasutijumi) {
        try {
            // false nozīmē, ka pārrakstām failu (nevis append)
            FileWriter fw = new FileWriter(pabeigtieFailaNosaukums, false);
            PrintWriter pw = new PrintWriter(fw);
            
            for (Pasutijums p : pabeigtiePasutijumi) {
                pw.println(p.toString());
                pw.println("═══════════════════════════════════════════════════════");
                pw.println(); // Tukša rinda
            }
            
            pw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Kļūda ierakstot failā pabeigtie_pasutijumi.txt!", "Kļūda", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Skatīt aktīvos pasūtījumus
    static void skatitAktivos() {
        String teksts, str = "";
        try {
            FileReader fr = new FileReader(aktivieFailaNosaukums);
            BufferedReader br = new BufferedReader(fr);
            while ((teksts = br.readLine()) != null) {
                str += teksts + "\n";
            }
            br.close();
            
            if (str.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nav aktīvu pasūtījumu failā!");
                return;
            }
            
            JTextArea ta = new JTextArea(str, 20, 60);
            ta.setEditable(false);
            JScrollPane sp = new JScrollPane(ta);
            sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            JOptionPane.showMessageDialog(null, sp, "Aktīvie pasūtījumi (no faila)", JOptionPane.PLAIN_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Kļūda nolasot failu aktivie_pasutijumi.txt!\nIespējams fails neeksistē.", "Kļūda", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    // Skatīt pabeigtos pasūtījumus
    static void skatitPabeigtos() {
        String teksts, str = "";
        try {
            FileReader fr = new FileReader(pabeigtieFailaNosaukums);
            BufferedReader br = new BufferedReader(fr);
            while ((teksts = br.readLine()) != null) {
                str += teksts + "\n";
            }
            br.close();
            
            if (str.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nav pabeigtu pasūtījumu failā!");
                return;
            }
            
            JTextArea ta = new JTextArea(str, 20, 60);
            ta.setEditable(false);
            JScrollPane sp = new JScrollPane(ta);
            sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            JOptionPane.showMessageDialog(null, sp, "Pabeigtie pasūtījumi (no faila)", JOptionPane.PLAIN_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Kļūda nolasot failu pabeigtie_pasutijumi.txt!\nIespējams fails neeksistē.", "Kļūda", JOptionPane.ERROR_MESSAGE);
        }
    }
}