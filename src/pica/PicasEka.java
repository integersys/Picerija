package pica;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

class GradientPanel extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// CardLayout priekš centra
    private CardLayout cardLayout;
    private JPanel centerPanel;

    public PicasEka() {
        setLayout(new BorderLayout());

        // ================= KREISAIS PANELIS (POGAS) =================
        GradientPanel leftPanel = new GradientPanel(
                new Color(48, 35, 174),
                new Color(83, 109, 254)
        );

        leftPanel.setLayout(new GridBagLayout());
        
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("logo.png"));
        Image scaledLogo = logoIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaledLogo));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        

        GradientButton speluOpc = new GradientButton("Spēlēt!");
        GradientButton pateicibas = new GradientButton("Pateicības");
        
        
        
        

        gbc.gridy = 0;
        leftPanel.add(logoLabel, gbc);

        gbc.gridy = 1;
        leftPanel.add(speluOpc, gbc);

        gbc.gridy = 2;
        leftPanel.add(pateicibas, gbc);
        gbc.anchor = GridBagConstraints.NORTH;
        gbc.gridy = 3;
        gbc.weighty = 1.0;
        leftPanel.add(Box.createVerticalGlue(), gbc);



        add(leftPanel, BorderLayout.WEST);


     // CENTRA PANELIS
        cardLayout = new CardLayout();
        centerPanel = new JPanel(cardLayout);

        centerPanel.add(createHomePanel(), "sākums");
        centerPanel.add(new PateicibasPanelis(), "pateicības");
        centerPanel.add(new SpelesIzvele(), "speluizvele");

        // TAGAD drīkst listenerus
        pateicibas.addActionListener(_ ->
            cardLayout.show(centerPanel, "pateicības")
        );

        speluOpc.addActionListener(_ ->
            cardLayout.show(centerPanel, "speluizvele")
        );



        
        

        GradientPanel centerBackground = new GradientPanel(
        		new Color(150, 160, 255),
        		new Color(210, 220, 255)  // ļoti gaiši zils
        );


        centerBackground.setLayout(new BorderLayout());
        centerBackground.add(centerPanel, BorderLayout.CENTER);

        add(centerBackground, BorderLayout.CENTER);
    }


    
    private JPanel createHomePanel() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Title
        JLabel titleLabel = new JLabel("Dominos picērija", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 40));
        titleLabel.setForeground(new Color(50, 50, 50));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 

        // GIF
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("SpinningPizza.gif"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(350, 150, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel gifLabel = new JLabel(scaledIcon, SwingConstants.CENTER);
        gifLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

      
        panel.add(Box.createVerticalStrut(30)); 
        panel.add(titleLabel);
        panel.add(Box.createVerticalStrut(10)); 
        panel.add(gifLabel);
        panel.add(Box.createVerticalGlue()); 

        
        
        
        
        return panel;
    }


    public static Clip audioClip;

    public static void atskanotMuziku() {
        try {
            AudioInputStream audioStream =
                    AudioSystem.getAudioInputStream(
                            PicasEka.class.getResource("/Audio/theme.wav")
                    );

            audioClip = AudioSystem.getClip();
            audioClip.open(audioStream);
            audioClip.loop(Clip.LOOP_CONTINUOUSLY);
            audioClip.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Picerija");

        ImageIcon icon = new ImageIcon(PicasEka.class.getResource("logo.png"));
        frame.setIconImage(icon.getImage());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 400);
        frame.setResizable(false);
        frame.add(new PicasEka());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
       atskanotMuziku();
    }
    }
