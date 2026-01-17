package pica;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PateicibasPanelis extends JPanel {

    public PateicibasPanelis() {
        setOpaque(false);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Pateicības", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 36));
        title.setForeground(new Color(40, 40, 40));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel text = new JLabel(
            "<html><center>" +
            "Autors: Intars Voitkevičs 2PT<br><br>" +
            "Iespaids ņemts no ChatGPT<br>" +
            "Jebkādas sakritības ar reālām personām ir PILNĪGI nejaušas<br><br>" +
            "Domino’s® ir Domino’s Pizza, Inc. reģistrēta preču zīme.\r\n"
            + "Visas tiesības uz logotipu un zīmolu pieder Domino’s Pizza, Inc.\r\n"
            + "Šis projekts nav saistīts ar Domino’s un nav viņu apstiprināts.\r\n"
            + "" +
            "</center></html>",
            SwingConstants.CENTER
        );
        text.setFont(new Font("Arial", Font.PLAIN, 18));
        text.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(Box.createVerticalStrut(40));
        add(title);
        add(Box.createVerticalStrut(30));
        add(text);
    }
}
