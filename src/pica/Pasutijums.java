package pica;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Queue;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Pasutijums {

    // --------- Lauki ---------
    private String tips;
    private double cena;
    private int picasizmers;
    private String piedevas;
    private String merce;
    private String uzkodas;
    private String dzeriens;
    private boolean uzVietasIzvele;
    private String pilnvards;
    private String adrese;
    private String talr;
    
    

    // --------- Konstruktors ----------
    public Pasutijums(String tips, double cena, String piedevas, int picasizmers, String merce, String uzkodas, String dzeriens, boolean uzVietasIzvele,
    		String pilnvards, String adrese, String talr) {
        this.tips = tips; 
        this.cena = cena;
        this.piedevas = piedevas;
        this.picasizmers = picasizmers;
        this.merce = merce;
        this.uzkodas = uzkodas;
        this.dzeriens = dzeriens;
        this.uzVietasIzvele = uzVietasIzvele;
        this.pilnvards = pilnvards;
        this.adrese = adrese;
        this.talr = talr;
    }
    
    public static double aprekinatCenu(String picasNosaukums,String piedevas,int picasIzmers,String merce,String uzkodas,String dzeriens,boolean savakt
    ) {
        double cena = 0;

        if (picasNosaukums.equals("Siera")) {
            cena = 3.50;
        } else if (picasNosaukums.equals("Pepperoni")) {
            cena = 4.00;
        } else if (picasNosaukums.equals("Margarita")) {
            cena = 5.00;
        }

        if (piedevas != null) {
            if (piedevas.contains("Sēnes")) cena += 2.50;
            if (piedevas.contains("Ananāss")) cena += 0.50;
            if (piedevas.contains("Čili")) cena += 1.50;
        }

        if (picasIzmers == 14) cena += 2.50;
        if (picasIzmers == 16) cena += 5.00;

        if (merce != null) {
            if (merce.equals("Barbekjū mērce") || merce.equals("Ķiploku mērce")) {
                cena += 1.50;
            } else if (merce.equals("Šokolādes mērce")) {
                cena += 2.50;
            }
        }

        if (uzkodas != null && !uzkodas.equals("Nav")) {
            if (uzkodas.contains("Kartupeļi")) cena += 2.00;
            else if (uzkodas.contains("Siera nūjiņas")) cena += 3.00;
            else if (uzkodas.contains("Vistas spārniņi")) cena += 4.50;
        }

        if (dzeriens != null && !dzeriens.equals("Nav")) {
            if (dzeriens.equals("Cola 0.5L")) cena += 2.00;
            else if (dzeriens.equals("Fanta 0.5L")) cena += 2.00;
            else if (dzeriens.equals("Ūdens 0.5L")) cena += 1.50;
            else if (dzeriens.equals("Enerģijas dzēriens")) cena += 3.50;
        }

        if (!savakt) cena += 3.00;

        return cena;
    }
    
    public static String izveliesPiedevas(String picasNosaukums) {
        JPanel piedevuPanel = new JPanel();
        piedevuPanel.setLayout(new BoxLayout(piedevuPanel, BoxLayout.Y_AXIS));
        
        // Bildes izmērs
        int bildesPlat = 150;
        int bildesAugst = 150;
        
        // Iegūt default bildi
        String defaultBilde = iegutPicasBildi(picasNosaukums, false, false, false);
        
        ImageIcon defaultIcon = new ImageIcon(Pasutijums.class.getResource(defaultBilde));
        Image defaultImg = defaultIcon.getImage().getScaledInstance(bildesPlat, bildesAugst, Image.SCALE_SMOOTH);
        JLabel picaBilde = new JLabel(new ImageIcon(defaultImg));
        picaBilde.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        piedevuPanel.add(picaBilde);
        
        // Checkboxi
        JCheckBox senesCheck = new JCheckBox("Sēnes [+2.50€]");
        JCheckBox ananasCheck = new JCheckBox("Ananāss [+0.50€]");
        JCheckBox ciliCheck = new JCheckBox("Čili pipari [+1.50€]");
        
        piedevuPanel.add(senesCheck);
        piedevuPanel.add(ananasCheck);
        piedevuPanel.add(ciliCheck);
        
        // ActionListener bildes maiņai
        ActionListener bildesMainitajs = e -> {
            boolean senes = senesCheck.isSelected();
            boolean ananas = ananasCheck.isSelected();
            boolean cili = ciliCheck.isSelected();
            
            String bildesNosaukums = iegutPicasBildi(picasNosaukums, senes, ananas, cili);
            
            ImageIcon jaunaIcon = new ImageIcon(Pasutijums.class.getResource(bildesNosaukums));
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
        
        if (piedevuIzvele != JOptionPane.OK_OPTION) {
            return null; // Atcelts
        }
        
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
        if (!senesCheck.isSelected() && !ananasCheck.isSelected() && !ciliCheck.isSelected()) {
            piedevas.append("Nav");
        }
        
        String piedevuTeksts = piedevas.toString();
        if (piedevuTeksts.endsWith(", ")) {
            piedevuTeksts = piedevuTeksts.substring(0, piedevuTeksts.length() - 2);
        }
        
        return piedevuTeksts;
    }
    
    public static String izveliesUzkodas() {
    String uzkodas = "";

    String[] uzkoduOpcijas = {
        "Kartupeļi (+2.00€)",
        "Siera nūjiņas (+3.00€)",
        "Vistas spārniņi (+4.50€)",
        "Nevēlos uzkodas"
    };
    
    String izveletaUzkoda = (String) JOptionPane.showInputDialog(null,"Izvēlies uzkodu","Uzkodu izvēle",JOptionPane.QUESTION_MESSAGE,null,uzkoduOpcijas, uzkoduOpcijas[3]
    );
    
    if (izveletaUzkoda == null) return null;
    
    if (izveletaUzkoda.contains("Kartupeļi")) {
        uzkodas = " Kartupeļi";
    } else if (izveletaUzkoda.contains("Siera")) {
        uzkodas = " Siera nūjiņas";
    } else if (izveletaUzkoda.contains("Vistas")) {
        uzkodas = " Vistas spārniņi";
    }else {
    	uzkodas = "Nav";
    }
    return uzkodas;
    }
    
    public static String izveliesDzerienu() {
    	String[] dzerienuOpcijas = { "Cola 0.5L (+2.00€)","Fanta 0.5L (+2.00€)","Ūdens 0.5L (+1.50€)","Enerģijas dzēriens (+3.50€)","Nevēlos dzērienu"
    	};

    	String dzeriens = (String) JOptionPane.showInputDialog(null, "Izvēlies dzērienu","Dzērienu izvēle",JOptionPane.QUESTION_MESSAGE,null,dzerienuOpcijas,dzerienuOpcijas[4]
    	);

    	if (dzeriens == null) 
    		return null;

    	if (dzeriens.contains("Cola")) {
    		dzeriens = "Cola 0.5L";
    	} else if (dzeriens.contains("Fanta")) {
    		dzeriens = "Fanta 0.5L";
    	} else if (dzeriens.contains("Ūdens")) {
    		dzeriens = "Ūdens 0.5L";
    	} else if (dzeriens.contains("Enerģijas")) {
    		dzeriens = "Enerģijas dzēriens";
    	} else {
    		dzeriens = "Nav";
    	}
    	return dzeriens;
    }
    
    static public Boolean izveliesPiegadi() {
        String[] izvopcijas = {"Jā", "Nē"};

        int uzVietasIzvele = JOptionPane.showOptionDialog(
            null,
            "Vai savākt uz vietas?\nCitādāk, piegāde uz adresi maksā 3 €",
            "Piegādes veids",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            izvopcijas,
            izvopcijas[0]
        );

        if (uzVietasIzvele == -1) return null; 
        return uzVietasIzvele == 0;  
    }

    public static String izveliesMerci() {
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
    	if (mercuIzvele == -1) return null;

    	String izvMerce = "";
    	switch (mercuIzvele) {
    	    case 0: 
    	        izvMerce = "Barbekjū mērce";
    	        break;
    	    case 1: 
    	        izvMerce = "Ķiploku mērce";
    	        break;
    	    case 2: 
    	        izvMerce = "Šokolādes mērce";
    	        break;
    	    case 3: 
    	        izvMerce = "Bez mērces";
    	        break;
    	    case 4:
    	    	izvMerce = "Nav";
    	    	break;
    	}
    	return izvMerce;
    }
    
    public static int izveletiesIzm() {
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

    if (izmIzvele == -1 || izmIzvele == 3) {
    	return -1;
    }
    
    int picasIzmers = 12;

    switch (izmIzvele) {
        case 0:
            break;
        case 1:
            picasIzmers = 14;
            break;
        case 2:
            picasIzmers = 16;
            break;
    }
    return picasIzmers;
    }
    
    public static String iegutPicasBildi(String picasNosaukums, boolean senes, boolean ananas, boolean cili) {

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
    
    public static String izveliesPicasTipu() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 3, 10, 10));
        
     
        int bildesPlat = 150;
        int bildesAugst = 150;
        
        
        JPanel sieraPanel = new JPanel();
        sieraPanel.setLayout(new BoxLayout(sieraPanel, BoxLayout.Y_AXIS));
        ImageIcon sieraIcon = new ImageIcon(Pasutijums.class.getResource("/PizzaSprites/siers.png"));
        Image sieraImg = sieraIcon.getImage().getScaledInstance(bildesPlat, bildesAugst, Image.SCALE_SMOOTH);
        JLabel sieraBilde = new JLabel(new ImageIcon(sieraImg));
        JLabel sieraTeksts = new JLabel("Siera [3.50€]");
        sieraTeksts.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        sieraPanel.add(sieraBilde);
        sieraPanel.add(sieraTeksts);
        
      
        JPanel pepperoniPanel = new JPanel();
        pepperoniPanel.setLayout(new BoxLayout(pepperoniPanel, BoxLayout.Y_AXIS));
        ImageIcon pepperoniIcon = new ImageIcon(Pasutijums.class.getResource("/PizzaSprites/pepperoni.png"));
        Image pepperoniImg = pepperoniIcon.getImage().getScaledInstance(bildesPlat, bildesAugst, Image.SCALE_SMOOTH);
        JLabel pepperoniBilde = new JLabel(new ImageIcon(pepperoniImg));
        JLabel pepperoniTeksts = new JLabel("Pepperoni [4€]");
        pepperoniTeksts.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        pepperoniPanel.add(pepperoniBilde);
        pepperoniPanel.add(pepperoniTeksts);
        
      
        JPanel margaritaPanel = new JPanel();
        margaritaPanel.setLayout(new BoxLayout(margaritaPanel, BoxLayout.Y_AXIS));
        ImageIcon margaritaIcon = new ImageIcon(Pasutijums.class.getResource("/PizzaSprites/margarita.png"));
        Image margaritaImg = margaritaIcon.getImage().getScaledInstance(bildesPlat, bildesAugst, Image.SCALE_SMOOTH);
        JLabel margaritaBilde = new JLabel(new ImageIcon(margaritaImg));
        JLabel margaritaTeksts = new JLabel("Margarita [5€]");
        margaritaTeksts.setAlignmentX(JLabel.CENTER_ALIGNMENT);
        margaritaPanel.add(margaritaBilde);
        margaritaPanel.add(margaritaTeksts);
        
        panel.add(sieraPanel);
        panel.add(pepperoniPanel);
        panel.add(margaritaPanel);
        
        String[] opcijas = {"Siera", "Pepperoni", "Margarita", "Iziet no veikala arā"};
        int izvele = JOptionPane.showOptionDialog(
            null, 
            panel,
            "Izvēlies picu",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.PLAIN_MESSAGE,
            null,
            opcijas,
            opcijas[0]
        );
        

        if (izvele == -1 || izvele == 3) {
            return null;
        }
        
        return opcijas[izvele]; 
    }
    
    public static void pabeigtPasutijumu(Queue<Pasutijums> aktiviePasutijumi, ArrayList<Pasutijums> pabeigtiePasutijumi) {
        Pasutijums pabeigts = aktiviePasutijumi.poll();
        
        if (pabeigts == null) return;
        
        pabeigtiePasutijumi.add(pabeigts);
    }
    
//   @Override
    public String toString() {
        return
            "Pasūtīta pica:\n" +
            "Tips: " + tips + "\n" +
            "Cena: " + cena + " €\n" +
            "Piedevas: " + piedevas + "\n" +
            "Picas izmērs: " + picasizmers + " cm\n" +
            "Mērce: " + merce + "\n\n" +

            "Papildus:\n" +
            "Uzkodas: " + uzkodas + "\n" +
            "Dzēriens: " + dzeriens + "\n" +
            "Uz vietas savākt: " + (uzVietasIzvele ? "Jā" : "Nē") + "\n\n" +

            "Personīgie dati:\n" +
            "Vārds, uzvārds: " + pilnvards + "\n" +
            "Adrese: " + adrese + "\n" +
            "Tālrunis: " + talr;
    }
}
