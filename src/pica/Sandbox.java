package pica;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Sandbox extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int uzVietasIzvele;
    Queue<Pasutijums> aktiviePasutijumi = new LinkedList<>();
    ArrayList<Pasutijums> pabeigtiePasutijumi = new ArrayList<>();
 
    String iegutPicasBildi(String picasNosaukums, boolean senes, boolean ananas, boolean cili) {

        if (picasNosaukums.equals("Siera")) {
            if (senes && ananas && cili) {
                return "/PizzaSpriteCheese/CheeseMushroomsPineapplesChili.png";
            } else if (senes && ananas) {
                return "/PizzaSpriteCheese/CheeseMushroomsPineapples.png";
            } else if (senes && cili) {
                return "/PizzaSpriteCheese/CheeseMushroomsChili.png";
            } else if (ananas && cili) {
                return "/PizzaSpriteCheese/CheesePineappleChilli.png";
            } else if (senes) {
                return "/PizzaSpriteCheese/CheeseMushrooms.png";
            } else if (ananas) {
                return "/PizzaSpriteCheese/CheesePineapple.png";
            } else if (cili) {
                return "/PizzaSpriteCheese/CheeseChill.png";
            } else {
                return "/PizzaSprites/siers.png";
            }
        }
        
        
        else if (picasNosaukums.equals("Pepperoni")) {
            if (senes && ananas && cili) {
                return "/PizzaSpritePepperoni/PepperoniMushroomsPineapplesChill.png";
            } else if (senes && ananas) {
                return "/PizzaSpritePepperoni/PepperoniMushroomsPineapples.png";
            } else if (senes && cili) {
                return "/PizzaSpritePepperoni/PepperoniMushroomsChilli.png";
            } else if (ananas && cili) {
                return "/PizzaSpritePepperoni/PepperoniPineapplesChill.png";
            } else if (senes) {
                return "/PizzaSpritePepperoni/PepperoniMushroom.png";
            } else if (ananas) {
                return "/PizzaSpritePepperoni/PepperoniPineapples.png";
            } else if (cili) {
                return "/PizzaSpritePepperoni/PepperoniChill.png";
            } else {
                return "/PizzaSprites/pepperoni.png";
            }
        }
        
        else if (picasNosaukums.equals("Margarita")) {
            if (senes && ananas && cili) {
                return "/PizzaSpriteMargarita/MargaritaAnanasMushroomChili.png";
            } else if (senes && ananas) {
                return "/PizzaSpriteMargarita/MargaritaMushroomsAnanas.png";
            } else if (senes && cili) {
                return "/PizzaSpriteMargarita/MargaritaMushroomsChilli.png";
            } else if (ananas && cili) {
                return "/PizzaSpriteMargarita/MargaritaChiliAnanas.png";
            } else if (senes) {
                return "/PizzaSpriteMargarita/MargaritaMushroom.png";
            } else if (ananas) {
                return "/PizzaSpriteMargarita/MargaritaAnanas.png";
            } else if (cili) {
                return "/PizzaSpriteMargarita/MargaritaChill.png";
            } else {
                return "/PizzaSprites/margarita.png";
            }
        }
        

        return "/PizzaSprites/siers.png";
    }
    
    private void pabeigtPasutijumu() {
        Pasutijums pabeigts = aktiviePasutijumi.poll();
        
        if (pabeigts == null) return;

        pabeigtiePasutijumi.add(pabeigts);
    }
    
    public Sandbox() {
    	    setTitle("Sandbox režīms");
    	    setSize(400, 400); 
    	    setLocationRelativeTo(null);
    	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    	    setLayout(new GridLayout(8, 1, 10, 10));

    	    JButton pasutitBtn = new JButton("Izveidot pasūtījumu");
    	    JButton apkalpotBtn = new JButton("Apkalpot nākamo pasūtījumu");  
    	    JButton aktivieBtn = new JButton("Aktīvie pasūtījumi");
    	    JButton pabeigtieBtn = new JButton("Pabeigtie pasūtījumi");

    	    JButton saglabatAktivosBtn = new JButton("Saglabāt aktīvos failā");
    	    JButton saglabatPabeigtosBtn = new JButton("Saglabāt pabeigtos failā");
    	    JButton skatitAktivosFailaBtn = new JButton("Skatīt aktīvos no faila");
    	    JButton skatitPabeigtosFailaBtn = new JButton("Skatīt pabeigtos no faila");

    	    add(pasutitBtn);
    	    add(apkalpotBtn);  
    	    add(aktivieBtn);
    	    add(pabeigtieBtn);
    	    add(saglabatAktivosBtn);
    	    add(saglabatPabeigtosBtn);
    	    add(skatitAktivosFailaBtn);
    	    add(skatitPabeigtosFailaBtn);

        // -------- Pasūtīt --------
        pasutitBtn.addActionListener(_ -> {
            JPanel panel = new JPanel();
            panel.setLayout(new GridLayout(1, 3, 10, 10));
            
            // Definēt bilžu izmēru
            int bildesPlat = 150;
            int bildesAugst = 150;
            
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
                String defaultBilde = "";
                
                // Noteikt cenu UN default bildi atkarībā no picas veida
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
                
                // ====== PIEDEVU IZVĒLE ======
                JPanel piedevuPanel = new JPanel();
                piedevuPanel.setLayout(new BoxLayout(piedevuPanel, BoxLayout.Y_AXIS));
                
              
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
                
                
                ActionListener bildesMainitajs = _ -> {
                    boolean senes = senesCheck.isSelected();
                    boolean ananas = ananasCheck.isSelected();
                    boolean cili = ciliCheck.isSelected();
                    
                    String bildesNosaukums = iegutPicasBildi(picasNosaukums, senes, ananas, cili);
                    
                    ImageIcon jaunaIcon = new ImageIcon(getClass().getResource(bildesNosaukums));
                    Image jaunaImg = jaunaIcon.getImage().getScaledInstance(bildesPlat, bildesAugst, Image.SCALE_SMOOTH);
                    picaBilde.setIcon(new ImageIcon(jaunaImg));
                    picaBilde.revalidate();
                    picaBilde.repaint();
                };
                
                senesCheck.addActionListener(bildesMainitajs);
                ananasCheck.addActionListener(bildesMainitajs);
                ciliCheck.addActionListener(bildesMainitajs);
                
             
                
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
                        piedevas.append("Sēnes, ");
                    }
                    if (ananasCheck.isSelected()) {
                        piedevas.append("Ananāss, ");
                    }
                    if (ciliCheck.isSelected()) {
                        piedevas.append("Čili, ");
                    }
                    if (!senesCheck.isSelected()&& !ananasCheck.isSelected()&& !ciliCheck.isSelected()) {piedevas.append("Nav");
                }
                    
                    String piedevuTeksts = piedevas.toString();
                    if (piedevuTeksts.endsWith(", ")) {
                        piedevuTeksts = piedevuTeksts.substring(0, piedevuTeksts.length() - 2);
                    }
 
                    	int picasIzmers = Pasutijums.izveletiesIzm();
                    
                    	String izvMerce = Pasutijums.izveliesMerci();
                    	
                    	String uzkodas = Pasutijums.izveliesUzkodas();
                   
                    	String dzeriens = Pasutijums.izveliesDzerienu();

	
                    	boolean savakt = Pasutijums.izveliesPiegadi();                	


                   
                    	String vards = ParbauzuMetodes.virknesParbaude("Ievadi vārdu", "Jānis");

                    	String uzvards = ParbauzuMetodes.virknesParbaude("Ievadi uzvārdu", "Bērziņš");

                    	String pilnsVards = vards.trim() + " " + uzvards.trim();

                    	String adrese;
                    	if (savakt) {
                    	    adrese = "Domino's Picērija";
                    	} else {
                    	    adrese = ParbauzuMetodes.adresesParbaude("Ievadi adresi", "Lauku iela 23");
                    	}

                    	String talrunis = ParbauzuMetodes.talrParbaude("Ievadi tālruņa nr:", "Ievadi tālruni");
                    	if (talrunis == null || talrunis.trim().isEmpty()) return;
                    	
                    	double galaCena = Pasutijums.aprekinatCenu(picasNosaukums,piedevuTeksts,picasIzmers,izvMerce,uzkodas,dzeriens, savakt);

                    	Pasutijums Pasutijums = new Pasutijums(picasNosaukums, galaCena, piedevuTeksts, picasIzmers, izvMerce, uzkodas, dzeriens, savakt, pilnsVards, adrese, talrunis);


                    	String pasutijumaTeksts = Pasutijums.toString();

                    	aktiviePasutijumi.add(Pasutijums);

                    	JOptionPane.showMessageDialog(null, pasutijumaTeksts);
                }
            }
        });




        apkalpotBtn.addActionListener(_ -> {
            if (aktiviePasutijumi.isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                    "Nav aktīvu pasūtījumu!", 
                    "Informācija", 
                    JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            Pasutijums nakamais = aktiviePasutijumi.peek();  

            String[] jaNeOpcijas = {"Jā", "Nē"};

            int izvele = JOptionPane.showOptionDialog(null,"Nākamais pasūtījums:\n\n" + nakamais.toString() +"\n\nVai atzīmēt šo pasūtījumu kā pabeigtu?","Apkalpot pasūtījumu",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,jaNeOpcijas,jaNeOpcijas[0]
            );

            if (izvele == -1) {
            	return;
            }
            
            if (izvele == 0) { 
                pabeigtPasutijumu();
                JOptionPane.showMessageDialog(null,"Pasūtījums pabeigts!","Veiksmīgi",JOptionPane.INFORMATION_MESSAGE
                );
            }else {
            	return;
            }

        });

        // -------- Aktīvie pasūtījumi --------
        aktivieBtn.addActionListener(_ -> {
            if (aktiviePasutijumi.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nav aktīvu pasūtījumu!");
                return;
            }
            
            StringBuilder sb = new StringBuilder();
            int i = 1;
            for (Pasutijums p : aktiviePasutijumi) {
                sb.append(i++).append(". ").append(p.toString()).append("\n\n");
            }
            
            JTextArea ta = new JTextArea(sb.toString(), 20, 60);
            ta.setEditable(false);
            JScrollPane sp = new JScrollPane(ta);
            JOptionPane.showMessageDialog(this, sp, "Aktīvie pasūtījumi", JOptionPane.PLAIN_MESSAGE);
        });

        // -------- Pabeigtie pasūtījumi --------
        pabeigtieBtn.addActionListener(_ -> {
            if (pabeigtiePasutijumi.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nav pabeigtu pasūtījumu!");
                return;
            }
            
            StringBuilder sb = new StringBuilder();
            int i = 1;
            for (Pasutijums p : pabeigtiePasutijumi) {
                sb.append(i++).append(". ").append(p.toString()).append("\n\n");
            }
            
            JTextArea ta = new JTextArea(sb.toString(), 20, 60);
            ta.setEditable(false);
            JScrollPane sp = new JScrollPane(ta);
            JOptionPane.showMessageDialog(this, sp, "Pabeigtie pasūtījumi", JOptionPane.PLAIN_MESSAGE);
        });

        // -------- Saglabāt aktīvos failā --------
        saglabatAktivosBtn.addActionListener(_ -> {
            if (aktiviePasutijumi.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nav aktīvu pasūtījumu, ko saglabāt!");
                return;
            }
            
            DarbsArFailu.saglabatAktivus(aktiviePasutijumi);
            
            JOptionPane.showMessageDialog(this, 
                "Visi aktīvie pasūtījumi (" + aktiviePasutijumi.size() + ") saglabāti failā!");
        });

      
        saglabatPabeigtosBtn.addActionListener(_ -> {
            if (pabeigtiePasutijumi.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nav pabeigtu pasūtījumu, ko saglabāt!");
                return;
            }
            
            DarbsArFailu.saglabatPabeigtos(pabeigtiePasutijumi);
            
            JOptionPane.showMessageDialog(this, 
                "Visi pabeigtie pasūtījumi (" + pabeigtiePasutijumi.size() + ") saglabāti failā!");
        });

        // -------- Skatīt aktīvos no faila --------
        skatitAktivosFailaBtn.addActionListener(_ -> {
            DarbsArFailu.skatitAktivos();
        });

        // -------- Skatīt pabeigtos no faila --------
        skatitPabeigtosFailaBtn.addActionListener(_ -> {
            DarbsArFailu.skatitPabeigtos();
        });

        
        
        setVisible(true);
    }

}