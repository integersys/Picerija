package pica;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class Sandbox extends JFrame {

    ArrayList<String> aktiviePasutijumi = new ArrayList<>();
    ArrayList<String> pabeigtiePasutijumi = new ArrayList<>();
    File pabeigtieFails = new File("pabeigtie_pasutijumi.txt");
    File aktiviePas = new File("aktivie_pasutijumi.txt");

    public Sandbox() {
        setTitle("Sandbox režīms");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setLayout(new GridLayout(3, 1, 10, 10));

        JButton pasutitBtn = new JButton("Izveidot pasūtījumu");
        JButton aktivieBtn = new JButton("Aktīvie pasūtījumi");
        JButton pabeigtieBtn = new JButton("Pabeigtie pasūtījumi");

        add(pasutitBtn);
        add(aktivieBtn);
        add(pabeigtieBtn);

        // -------- Pasūtīt --------
     // -------- Pasūtīt --------
        pasutitBtn.addActionListener(e -> {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(1, 3, 10, 10));
            
            // Definēt bilžu izmēru (pielāgo pēc vajadzības)
            int bildesPlat = 150;  // platums pixels
            int bildesAugst = 150; // augstums pixels
            
            // Siera pica
            JPanel sieraPanel = new JPanel();
            sieraPanel.setLayout(new BoxLayout(sieraPanel, BoxLayout.Y_AXIS));
            ImageIcon sieraIcon = new ImageIcon(getClass().getResource("/PizzaSprites/siers.png"));
            Image sieraImg = sieraIcon.getImage().getScaledInstance(bildesPlat, bildesAugst, Image.SCALE_SMOOTH);
            JLabel sieraBilde = new JLabel(new ImageIcon(sieraImg));
            JLabel sieraTeksts = new JLabel("Siera [3.50€]");
            sieraTeksts.setAlignmentX(CENTER_ALIGNMENT);
            sieraPanel.add(sieraBilde);
            sieraPanel.add(sieraTeksts);
            
            // Pepperoni pica
            JPanel pepperoniPanel = new JPanel();
            pepperoniPanel.setLayout(new BoxLayout(pepperoniPanel, BoxLayout.Y_AXIS));
            ImageIcon pepperoniIcon = new ImageIcon(getClass().getResource("/PizzaSprites/pepperoni.png"));
            Image pepperoniImg = pepperoniIcon.getImage().getScaledInstance(bildesPlat, bildesAugst, Image.SCALE_SMOOTH);
            JLabel pepperoniBilde = new JLabel(new ImageIcon(pepperoniImg));
            JLabel pepperoniTeksts = new JLabel("Pepperoni [4€]");
            pepperoniTeksts.setAlignmentX(CENTER_ALIGNMENT);
            pepperoniPanel.add(pepperoniBilde);
            pepperoniPanel.add(pepperoniTeksts);
            
            // Margarita pica
            JPanel margaritaPanel = new JPanel();
            margaritaPanel.setLayout(new BoxLayout(margaritaPanel, BoxLayout.Y_AXIS));
            ImageIcon margaritaIcon = new ImageIcon(getClass().getResource("/PizzaSprites/margarita.png"));
            Image margaritaImg = margaritaIcon.getImage().getScaledInstance(bildesPlat, bildesAugst, Image.SCALE_SMOOTH);
            JLabel margaritaBilde = new JLabel(new ImageIcon(margaritaImg));
            JLabel margaritaTeksts = new JLabel("Margarita [5€]");
            margaritaTeksts.setAlignmentX(CENTER_ALIGNMENT);
            margaritaPanel.add(margaritaBilde);
            margaritaPanel.add(margaritaTeksts);
            
            panel.add(sieraPanel);
            panel.add(pepperoniPanel);
            panel.add(margaritaPanel);
            
            String[] opcijas = {"Siera", "Pepperoni", "Margarita", "Iziet no veikala arā"};
            int izvele = JOptionPane.showOptionDialog(null, panel,"Izvēlies picu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcijas,
                opcijas[0]
            );
            
            if (izvele >= 0 && izvele < 3) {
                String picasNosaukums = opcijas[izvele];
                double cena = 0;
                
                // Noteikt cenu atkarībā no picas veida
                switch(picasNosaukums) {
                    case "Siera":
                        cena = 3.50;
                        break;
                    case "Pepperoni":
                        cena = 4;
                        break;
                    case "Margarita":
                        cena = 5;
                        break;
                }
                
                // ====== PIEDEVU IZVĒLE ======
                JPanel piedevuPanel = new JPanel();
                piedevuPanel.setLayout(new BoxLayout(piedevuPanel, BoxLayout.Y_AXIS));
                
                // Noteikt pareizo default bildi atkarībā no izvēlētās picas
                String defaultBilde = "";
                switch(picasNosaukums) {
                    case "Siera":
                        defaultBilde = "/PizzaSprites/siers.png";
                        break;
                    case "Pepperoni":
                        defaultBilde = "/PizzaSprites/pepperoni.png";
                        break;
                    case "Margarita":
                        defaultBilde = "/PizzaSprites/margarita.png";
                        break;
                }
                
                // Bilde virs checkboxiem - ar mērogošanu
                ImageIcon defaultIcon = new ImageIcon(getClass().getResource(defaultBilde));
                Image defaultImg = defaultIcon.getImage().getScaledInstance(bildesPlat, bildesAugst, Image.SCALE_SMOOTH);
                JLabel picaBilde = new JLabel(new ImageIcon(defaultImg));
                picaBilde.setAlignmentX(CENTER_ALIGNMENT);
                piedevuPanel.add(picaBilde);
                
                // Checkboxi
                JCheckBox senesCheck = new JCheckBox("Sēnes [+2.50€]");
                JCheckBox ananasCheck = new JCheckBox("Ananāss [+0.50€]");
                JCheckBox ciliCheck = new JCheckBox("Čili pipari [+1.50€]");
                
                piedevuPanel.add(senesCheck);
                piedevuPanel.add(ananasCheck);
                piedevuPanel.add(ciliCheck);
                
                // Mainīt bildi, kad checkboxi tiek spriesti (TIKAI Margarita picai)
                if (picasNosaukums.equals("Margarita")) {
                    ActionListener bildesMainitajs = a -> {
                        boolean senes = senesCheck.isSelected();
                        boolean ananas = ananasCheck.isSelected();
                        boolean cili = ciliCheck.isSelected();
                        
                        String bildesNosaukums = "/PizzaSprites/margarita.png";
                        
                        if (senes && ananas && cili) {
                            bildesNosaukums = "/PizzaSpriteMargarita/MargaritaAnanasMushroomChili.png";
                        } else if (senes && ananas) {
                            bildesNosaukums = "/PizzaSpriteMargarita/MargaritaMushroomsAnanas.png";
                        } else if (senes && cili) {
                            bildesNosaukums = "/PizzaSpriteMargarita/MargaritaMushroomsChilli.png";
                        } else if (ananas && cili) {
                            bildesNosaukums = "/PizzaSpriteMargarita/MargaritaChiliAnanas.png";
                        } else if (senes) {
                            bildesNosaukums = "/PizzaSpriteMargarita/MargaritaMushroom.png";
                        } else if (ananas) {
                            bildesNosaukums = "/PizzaSpriteMargarita/MargaritaAnanas.png";
                        } else if (cili) {
                            bildesNosaukums = "/PizzaSpriteMargarita/MargaritaChill.png";
                        }
                        
                        // Mērogot jauno bildi
                        ImageIcon jaunaIcon = new ImageIcon(getClass().getResource(bildesNosaukums));
                        Image jaunaImg = jaunaIcon.getImage().getScaledInstance(bildesPlat, bildesAugst, Image.SCALE_SMOOTH);
                        picaBilde.setIcon(new ImageIcon(jaunaImg));
                        picaBilde.revalidate();
                        picaBilde.repaint();
                    };
                    
                    senesCheck.addActionListener(bildesMainitajs);
                    ananasCheck.addActionListener(bildesMainitajs);
                    ciliCheck.addActionListener(bildesMainitajs);
                }
                
                int piedevuIzvele = JOptionPane.showConfirmDialog(
                    null,
                    piedevuPanel,
                    "Kādas piedevas pielikt?",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.PLAIN_MESSAGE
                );
                
                if (piedevuIzvele == JOptionPane.OK_OPTION) {
                    StringBuilder piedevas = new StringBuilder();
                    
                    if (senesCheck.isSelected()) {
                        cena += 2.50;
                        piedevas.append("Sēnes, ");
                    }
                    if (ananasCheck.isSelected()) {
                        cena += 0.50;
                        piedevas.append("Ananāss, ");
                    }
                    if (ciliCheck.isSelected()) {
                        cena += 1.50;
                        piedevas.append("Čili, ");
                    }
                    
                    // Noņemt pēdējo komatu
                    if (piedevas.length() > 0) {
                        piedevas.setLength(piedevas.length() - 2);
                    }
                    
                    // Izveidot Pasutijums objektu
                    Pasutijums jaunsPasutijums = new Pasutijums(picasNosaukums, cena);
                    
                    String pasutijumaTeksts = picasNosaukums + " pica";
                    if (piedevas.length() > 0) {
                        pasutijumaTeksts += " ar " + piedevas;
                    }
                    pasutijumaTeksts += " - €" + String.format("%.2f", cena);
                    
                    // Pievienot sarakstam
                    aktiviePasutijumi.add(pasutijumaTeksts);
                    
                    JOptionPane.showMessageDialog(this, 
                        "Pasūtīts: " + pasutijumaTeksts);
                }
            }
        });




        // -------- Aktīvie --------
        aktivieBtn.addActionListener(e -> {
            if (aktiviePasutijumi.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nav aktīvu pasūtījumu.");
                return;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < aktiviePasutijumi.size(); i++) {
                sb.append(i + 1).append(". ")
                  .append(aktiviePasutijumi.get(i))
                  .append("\n");
            }

            int choice = JOptionPane.showConfirmDialog(
                this,
                sb + "\nVai atzīmēt pirmo kā pabeigtu?",
                "Aktīvie pasūtījumi",
                JOptionPane.YES_NO_OPTION
            );

            if (choice == JOptionPane.YES_OPTION) {
                pabeigtPasutijumu(0);
            }
        });

        // -------- Pabeigtie --------
        pabeigtieBtn.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                this,
                nolasitPabeigtos(),
                "Pabeigtie pasūtījumi",
                JOptionPane.INFORMATION_MESSAGE
            );
        });

        setVisible(true);
    }

    private void pabeigtPasutijumu(int index) {
        String pabeigts = aktiviePasutijumi.remove(index);

        try (FileWriter fw = new FileWriter(pabeigtieFails, true)) {
            fw.write(pabeigts + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String nolasitPabeigtos() {
        if (!pabeigtieFails.exists()) return "Nav pabeigtu pasūtījumu.";

        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(pabeigtieFails))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append("• ").append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }
}
