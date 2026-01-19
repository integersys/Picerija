package pica;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
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
    
    if (izveletaUzkoda == null) return "";
    
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
    		return "Nav";

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
      // return;
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
