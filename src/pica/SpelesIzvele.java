package pica;

import java.awt.Component;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SpelesIzvele extends JPanel {

    public SpelesIzvele() {
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Virsraksts
        JLabel title = new JLabel("Spēļu izvēlne", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        

        // --------- 1. režīms ----------
        JButton sandboxBtn = new JButton("Brīvā gaita (Sandbox)");
        sandboxBtn.setFont(new Font("Arial", Font.BOLD, 18));
        sandboxBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel sandboxDesc = new JLabel(
            "<html><center>Pats veic pasūtījumu,<br>" +
            "pats izveido, pats pieved</center></html>"
        );
        sandboxDesc.setFont(new Font("Arial", Font.PLAIN, 14));
        sandboxDesc.setAlignmentX(Component.CENTER_ALIGNMENT);

        // --------- 2. režīms ----------
        JButton klientiBtn = new JButton("Ar klientiem");
        klientiBtn.setFont(new Font("Arial", Font.BOLD, 18));
        klientiBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel klientiDesc = new JLabel(
            "<html><center>Uzvedies kā darbinieks,<br>" +
            "izsecinot ko klients vēlas no sava teiktā,<br>" +
            "un izdari pareizo pasūtījumu</center></html>"
        );
        klientiDesc.setFont(new Font("Arial", Font.PLAIN, 14));
        klientiDesc.setAlignmentX(Component.CENTER_ALIGNMENT);

        // --------- Izvietojums ----------
     // --------- Izvietojums ----------
        add(Box.createVerticalGlue());

        add(title);
        add(Box.createVerticalStrut(40));

        add(sandboxBtn);
        add(Box.createVerticalStrut(5));
        add(sandboxDesc);

        add(Box.createVerticalStrut(30));

        add(klientiBtn);
        add(Box.createVerticalStrut(5));
        add(klientiDesc);

        add(Box.createVerticalGlue());

    }
}
