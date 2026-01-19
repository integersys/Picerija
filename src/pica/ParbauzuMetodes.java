package pica;

import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class ParbauzuMetodes {
	static String virknesParbaude(String zinojums, String noklusejums){
        String virkne;
        
        do {
            virkne = JOptionPane.showInputDialog(zinojums, noklusejums);
            
            if(virkne == null)
                return null;
            
            virkne = virkne.trim();
        }while(!Pattern.matches("^[\\p{L} .]+$", virkne));
        
        return virkne;
    }
    
    static String adresesParbaude(String zinojums, String noklusejums) {
        String virkne;

        do {
            virkne = JOptionPane.showInputDialog(zinojums, noklusejums);

            if (virkne == null)
                return null;

            virkne = virkne.trim();
        } while (!Pattern.matches("^(?=.*\\p{L})(?=.*\\d)[\\p{L}\\d .,-]+$", virkne));

        return virkne;
    }

    
    
    static String talrParbaude(String zinojums, String noklusejums) {
        String talrunis;

        do {
            talrunis = JOptionPane.showInputDialog(null, zinojums, noklusejums, JOptionPane.PLAIN_MESSAGE);

            if (talrunis == null)
                return null; 

            talrunis = talrunis.trim();
        } while (!talrunis.matches("\\d+"));

        return talrunis;
    }
}
