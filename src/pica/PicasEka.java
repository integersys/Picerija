package pica;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class PicasEka extends JPanel {

    public PicasEka() {
        JLabel label = new JLabel("Picerija");
        label.setFont(new Font("Arial", Font.BOLD, 30));
        label.setHorizontalAlignment(SwingConstants.CENTER);

        setLayout(new BorderLayout());
        add(label, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Picerija");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.add(new PicasEka());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
