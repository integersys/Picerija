package pica;

import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class SpelesIzvele extends JPanel {

    public SpelesIzvele() {
        setOpaque(false);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.insets = new Insets(5, 0, 5, 0);

        // Virsraksts
        JLabel title = new JLabel("Spēļu izvēlne", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 36));
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 40, 0);
        add(title, gbc);

        // --------- 1. režīms ----------
        JButton sandboxBtn = new JButton("Brīvā gaita (Sandbox)");
        sandboxBtn.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 5, 0);
        add(sandboxBtn, gbc);

        JLabel sandboxDesc = new JLabel(
            "<html><center>Pats veic pasūtījumu,<br>" +
            "pats izveido, pats pieved</center></html>"
        );
        sandboxDesc.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 30, 0);
        add(sandboxDesc, gbc);

        // --------- 2. režīms ----------
        JButton klientiBtn = new JButton("Ar klientiem");
        klientiBtn.setFont(new Font("Arial", Font.BOLD, 18));
        gbc.gridy = 3;
        gbc.insets = new Insets(0, 0, 5, 0);
        add(klientiBtn, gbc);

        JLabel klientiDesc = new JLabel(
            "<html><center>Uzvedies kā darbinieks,<br>" +
            "izsecinot ko klients vēlas no sava teiktā,<br>" +
            "un izdari pareizo pasūtījumu</center></html>"
        );
        klientiDesc.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridy = 4;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(klientiDesc, gbc);
    }
}