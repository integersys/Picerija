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
import javax.swing.JComboBox;
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
                double cena = 0;
                String defaultBilde = "";
                
                // Noteikt cenu UN default bildi atkarībā no picas veida
                switch(picasNosaukums) {
                    case "Siera":
                        cena = 3.50;
                        defaultBilde = "/PizzaSprites/siers.png";
                        break;
                    case "Pepperoni":
                        cena = 4;
                        defaultBilde = "/PizzaSprites/pepperoni.png";
                        break;
                    case "Margarita":
                        cena = 5;
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
                    
                    String piedevuTeksts = piedevas.toString();
                    if (piedevuTeksts.endsWith(", ")) {
                        piedevuTeksts = piedevuTeksts.substring(0, piedevuTeksts.length() - 2);
                    }
                    
                    
                 // ====== PICAS IZMĒRA IZVĒLE ======
                    JPanel izmPanel = new JPanel(new GridLayout(1, 3, 10, 10));

                    JPanel maza = new JPanel();
                    maza.setLayout(new BoxLayout(maza, BoxLayout.Y_AXIS));
                    maza.add(new JLabel("12 collas"));
                    maza.add(new JLabel("Standarta cena, nemainās"));
                    izmPanel.add(maza);

                    JPanel videja = new JPanel();
                    videja.setLayout(new BoxLayout(videja, BoxLayout.Y_AXIS));
                    videja.add(new JLabel("14 collas"));
                    videja.add(new JLabel("2.50€"));
                    izmPanel.add(videja);

                    JPanel liela = new JPanel();
                    liela.setLayout(new BoxLayout(liela, BoxLayout.Y_AXIS));
                    liela.add(new JLabel("16 collas"));
                    liela.add(new JLabel("5€"));
                    izmPanel.add(liela);
            
                    

                    String[] izmOpcijas = {"12 collas", "14 collas", "16 collas", "Atcelt"};

                    int izmIzvele = JOptionPane.showOptionDialog(null, izmPanel,"Izvēlies picas izmēru",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,izmOpcijas,izmOpcijas[1]
                    );
  
                    if (izmIzvele == -1) return;
                    
                    int picasIzmers = 12;

                    switch (izmIzvele) {
                        case 0:
                            break;
                        case 1:
                            picasIzmers = 14;
                            cena += 2.50;
                            break;
                        case 2:
                            picasIzmers = 16;
                            cena += 5;
                            break;
                        case 3:
                        	return;
                    }
                    
                 // ====== MĒRCES IZVĒLE ======
                    JPanel MercOpc = new JPanel(new GridLayout(1, 4, 10, 10));

                    JPanel bbq = new JPanel();
                    bbq.setLayout(new BoxLayout(bbq, BoxLayout.Y_AXIS));
                    bbq.add(new JLabel("Barbekjū mērce"));
                    bbq.add(new JLabel("1.50€"));
                    MercOpc.add(bbq);  

                    JPanel kip = new JPanel();
                    kip.setLayout(new BoxLayout(kip, BoxLayout.Y_AXIS));
                    kip.add(new JLabel("Ķiploku mērce"));
                    kip.add(new JLabel("1.50€"));
                    MercOpc.add(kip); 

                    JPanel choc = new JPanel();
                    choc.setLayout(new BoxLayout(choc, BoxLayout.Y_AXIS));
                    choc.add(new JLabel("Šokolādes mērce"));
                    choc.add(new JLabel("2.50€"));
                    MercOpc.add(choc);

                    JPanel neko = new JPanel();
                    neko.setLayout(new BoxLayout(neko, BoxLayout.Y_AXIS));
                    neko.add(new JLabel("Nevēlos"));
                    MercOpc.add(neko);  

                    String[] MercesOpc = {"Barbekjū mērce","Ķiploku mērce","Šokolādes mērce", "Nevēlos"
                    };

                    int mercuIzvele = JOptionPane.showOptionDialog(null, MercOpc, "Izvēlies mērci",JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE,null,MercesOpc, MercesOpc[3]
                    );

                    	// Pēc mērces izvēles
                    	if (mercuIzvele == -1) return;

                    	String izvMerce = "";
                    	switch (mercuIzvele) {
                    	    case 0: 
                    	        izvMerce = "Barbekjū mērce";
                    	        cena += 1.50;
                    	        break;
                    	    case 1: 
                    	        izvMerce = "Ķiploku mērce";
                    	        cena += 1.50;
                    	        break;
                    	    case 2: 
                    	        izvMerce = "Šokolādes mērce";
                    	        cena += 2.50;
                    	        break;
                    	    case 3: // Nevēlos
                    	        izvMerce = "Bez mērces";
                    	        break;
                    	}
                    	
                    	String uzkodas = "";

                    	if (!izvMerce.equals("Bez mērces")) {

                    	    String[] uzkoduOpcijas = {
                    	        "Kartupeļi (+2.00€)",
                    	        "Siera nūjiņas (+3.00€)",
                    	        "Vistas spārniņi (+4.50€)",
                    	        "Nevēlos uzkodas"
                    	    };

                    	    JComboBox<String> uzkoduBox = new JComboBox<>(uzkoduOpcijas);

                    	    int uzkoduIzvele = JOptionPane.showConfirmDialog(null,uzkoduBox,"Izvēlies uzkodu",
                    	        JOptionPane.OK_CANCEL_OPTION,
                    	        JOptionPane.PLAIN_MESSAGE
                    	    );

                    	    if (uzkoduIzvele == JOptionPane.CANCEL_OPTION) return;

                    	    String izveletaUzkoda = (String) uzkoduBox.getSelectedItem();

                    	    if (izveletaUzkoda.contains("Kartupeļi")) {
                    	        uzkodas = " Kartupeļi";
                    	        cena += 2.00;
                    	    } else if (izveletaUzkoda.contains("Siera")) {
                    	        uzkodas = " Siera nūjiņas";
                    	        cena += 3.00;
                    	    } else if (izveletaUzkoda.contains("Vistas")) {
                    	        uzkodas = " Vistas spārniņi";
                    	        cena += 4.50;
                    	    }
                    	}

                    	// ====== DZĒRIENU IZVĒLE (DROP DOWN) ======
                    	String[] dzerienuOpcijas = {
                    		    "Cola 0.5L",
                    		    "Fanta 0.5L",
                    		    "Ūdens 0.5L",
                    		    "Enerģijas dzēriens",
                    		    "Nevēlos dzērienu"
                    		};

                    		JComboBox<String> dzerienuBox = new JComboBox<>(dzerienuOpcijas);

                    		int dzerienaIzvele = JOptionPane.showConfirmDialog(
                    		    null,
                    		    dzerienuBox,
                    		    "Izvēlies dzērienu",
                    		    JOptionPane.OK_CANCEL_OPTION,
                    		    JOptionPane.PLAIN_MESSAGE
                    		);

                    		if (dzerienaIzvele == JOptionPane.CANCEL_OPTION) return;

                    		String dzeriens = (String) dzerienuBox.getSelectedItem();

                    		// Pievienot cenu
                    		switch (dzeriens) {
                    		    case "Cola 0.5L":
                    		    	cena += 2.00;
                    		    case "Fanta 0.5L":
                    		        cena += 2.00;
                    		        break;
                    		    case "Ūdens 0.5L":
                    		        cena += 1.50;
                    		        break;
                    		    case "Enerģijas dzēriens":
                    		        cena += 3.50;
                    		        break;
                    		}

          
                    	uzVietasIzvele = JOptionPane.showConfirmDialog(
                    	        null,
                    	        "Vai savākt uz vietas?",
                    	        "Piegādes veids",
                    	        JOptionPane.YES_NO_OPTION,
                    	        JOptionPane.QUESTION_MESSAGE
                    	);

    
                    	if (uzVietasIzvele == -1) {
                    	    return; 
                    	}

                    	
                    	boolean savakt = (uzVietasIzvele == JOptionPane.YES_OPTION) ? true : false;

                   
                    	String vards = virknesParbaude("Ievadi vārdu", "Jānis");

                    	String uzvards = virknesParbaude("Ievadi uzvārdu", "Bērziņš");

                    	String pilnsVards = vards.trim() + " " + uzvards.trim();

                    	String adrese;
                    	if (savakt) {
                    	    adrese = "Domino's Picērija";
                    	} else {
                    	    adrese = virknesParbaude("Ievadi adresi", "Lauku iela");
                    	}

                    	String talrunis = talrParbaude("Ievadi tālruņa nr:", "Ievadi tālruni");
                    	if (talrunis == null || talrunis.trim().isEmpty()) return;

                    	Pasutijums Pasutijums = new Pasutijums(picasNosaukums, cena, piedevuTeksts, picasIzmers, izvMerce, uzkodas, dzeriens, savakt, pilnsVards, adrese, talrunis);

                    	
                    	
                    	// Izveidot pasūtījuma tekstu
                    	String pasutijumaTeksts = Pasutijums.toString();

                    	// Pievienot sarakstam
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

            int choice = JOptionPane.showConfirmDialog(null,"Nākamais pasūtījums:\n\n" + nakamais.toString() + "\n\nVai atzīmēt kā pabeigtu?","Apkalpot pasūtījumu",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE
            );

            if (choice == JOptionPane.YES_OPTION) {
                pabeigtPasutijumu();
                JOptionPane.showMessageDialog(this, 
                    "Pasūtījums pabeigts!", 
                    "Veiksmīgi", 
                    JOptionPane.INFORMATION_MESSAGE);
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