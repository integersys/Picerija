package pica;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class PicasEka extends JPanel {

    // CardLayout priekš centra
    private CardLayout cardLayout;
    private JPanel centerPanel;

    // Datu glabāšana
    private ArrayList<pasutitajs> pasutijumi = new ArrayList<>();

    public PicasEka() {
        setLayout(new BorderLayout());

        // ================= KREISAIS PANELIS (POGAS) =================
        JPanel leftPanel = new JPanel(new GridLayout(2, 1, 5, 5));

        JButton viena1 = new JButton("viena1");
        JButton future = new JButton("thiswilldosomethinginthefuture");

        leftPanel.add(viena1);
        leftPanel.add(future);

        add(leftPanel, BorderLayout.WEST);

        // ================= CENTRA PANELIS =================
        cardLayout = new CardLayout();
        centerPanel = new JPanel(cardLayout);

        // Sākuma panelis
        centerPanel.add(createHomePanel(), "HOME");

        // Picas veidošanas panelis
        centerPanel.add(createPizzaPanel(), "PIZZA");

        add(centerPanel, BorderLayout.CENTER);

        // ================= ACTION LISTENERS =================
        viena1.addActionListener(e -> cardLayout.show(centerPanel, "PIZZA"));
    }

    // ================= SĀKUMA SKATS =================
    private JPanel createHomePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Picerija", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    // ================= PICAS VEIDOŠANA =================
    private JPanel createPizzaPanel() {
        JPanel panel = new JPanel(new GridLayout(7, 2, 5, 5));

        JTextField vards = new JTextField();
        JTextField adrese = new JTextField();
        JTextField talrunis = new JTextField();

        JComboBox<Integer> izmers = new JComboBox<>(new Integer[]{10, 15, 20});
        JComboBox<String> piedeva = new JComboBox<>(new String[]{"Sēnes", "Pepperoni", "Ananāss"});

        JCheckBox uzVietas = new JCheckBox("Uz vietas");

        JButton izveidot = new JButton("Izveidot pasūtījumu");

        panel.add(new JLabel("Vārds:"));
        panel.add(vards);

        panel.add(new JLabel("Adrese:"));
        panel.add(adrese);

        panel.add(new JLabel("Talrunis:"));
        panel.add(talrunis);

        panel.add(new JLabel("Picas izmērs:"));
        panel.add(izmers);

        panel.add(new JLabel("Piedevas:"));
        panel.add(piedeva);

        panel.add(uzVietas);
        panel.add(new JLabel());

        panel.add(izveidot);

        // ================= POGA =================
        izveidot.addActionListener(e -> {
            int picasIzmers = (int) izmers.getSelectedItem();
            String picasPiedeva = (String) piedeva.getSelectedItem();
            boolean uzVietasBool = uzVietas.isSelected();

            double cena = picasCena(picasIzmers, uzVietasBool, picasPiedeva);
            int id = pasutijumi.size() + 1;

            pasutitajs p = new pasutitajs(
                    picasIzmers,
                    id,
                    cena,
                    uzVietasBool,
                    vards.getText(),
                    adrese.getText(),
                    talrunis.getText(),
                    picasPiedeva,
                    picasPiedeva + " Pica (" + picasIzmers + ")"
            );

            pasutijumi.add(p);

            JOptionPane.showMessageDialog(this,
                    "Pasūtījums izveidots!\n\n" + p,
                    "OK",
                    JOptionPane.INFORMATION_MESSAGE);
        });

        return panel;
    }

    // ================= CENAS APRĒĶINS =================
    private double picasCena(int izmers, boolean uzVietas, String piedeva) {
        double cena = 0;

        if (izmers == 10) cena += 3.5;
        if (izmers == 15) cena += 5.5;
        if (izmers == 20) cena += 7.0;

        if (piedeva.equals("Sēnes")) cena += 1.8;
        if (piedeva.equals("Pepperoni")) cena += 2.5;
        if (piedeva.equals("Ananāss")) cena += 2.0;

        if (!uzVietas) cena += 3.2;

        return cena;
    }

    // ================= MAIN =================
    public static void main(String[] args) {
        JFrame frame = new JFrame("Picerija");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 400);
        frame.add(new PicasEka());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
