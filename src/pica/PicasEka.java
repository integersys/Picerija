package pica;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

class GradientPanel extends JPanel {
    private Color c1;
    private Color c2;

    public GradientPanel(Color c1, Color c2) {
        this.c1 = c1;
        this.c2 = c2;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

        GradientPaint gp = new GradientPaint(
                0, 0, c1,
                0, getHeight(), c2
        );

        g2.setPaint(gp);
        g2.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
}

class GradientButton extends JButton {

    public GradientButton(String text) {
        super(text);
        setFocusPainted(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setForeground(Color.WHITE);
        setFont(new Font("Segoe UI", Font.BOLD, 14));
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setPreferredSize(new Dimension(160, 45));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);

        Color start = new Color(128, 90, 213);
        Color end   = new Color(70, 130, 255);

        if (getModel().isRollover()) {
            start = start.brighter();
            end = end.brighter();
        }

        GradientPaint gp = new GradientPaint(0, 0, start, getWidth(), getHeight(), end);
        g2.setPaint(gp);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);

        super.paintComponent(g);
    }
}


public class PicasEka extends JPanel {
	
	

    // CardLayout priekš centra
    private CardLayout cardLayout;
    private JPanel centerPanel;

    // Datu glabāšana
    private ArrayList<pasutitajs> pasutijumi = new ArrayList<>();

    public PicasEka() {
        setLayout(new BorderLayout());

        // ================= KREISAIS PANELIS (POGAS) =================
        GradientPanel leftPanel = new GradientPanel(
                new Color(48, 35, 174),
                new Color(83, 109, 254)
        );

        leftPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;

        GradientButton viena1 = new GradientButton("Izveidot picu");
        GradientButton future = new GradientButton("Nākotnē");

        gbc.gridy = 0;
        leftPanel.add(viena1, gbc);

        gbc.gridy = 1;
        leftPanel.add(future, gbc);

        add(leftPanel, BorderLayout.WEST);



        // ================= CENTRA PANELIS =================
        cardLayout = new CardLayout();
        centerPanel = new JPanel(cardLayout);

        // Sākuma panelis
        centerPanel.add(createHomePanel(), "HOME");



        GradientPanel centerBackground = new GradientPanel(
                new Color(99, 102, 241),
                new Color(59, 130, 246)
        );

        centerBackground.setLayout(new BorderLayout());
        centerBackground.add(centerPanel, BorderLayout.CENTER);

        add(centerBackground, BorderLayout.CENTER);



        // ================= ACTION LISTENERS =================
        viena1.addActionListener(e -> cardLayout.show(centerPanel, "PIZZA"));
    }

    // ================= SĀKUMA SKATS =================
    private JPanel createHomePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Picerija", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 30));
        
        panel.setOpaque(false);
        label.setForeground(Color.WHITE);

        
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }
        
        

        // ================= POGA =================
       

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
    
    class GradientPanel extends JPanel {
        private Color c1;
        private Color c2;

        public GradientPanel(Color c1, Color c2) {
            this.c1 = c1;
            this.c2 = c2;
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON);

            GradientPaint gp = new GradientPaint(
                    0, 0, c1,
                    0, getHeight(), c2
            );

            g2.setPaint(gp);
            g2.fillRect(0, 0, getWidth(), getHeight());
            super.paintComponent(g);
        }
    }
    
}
