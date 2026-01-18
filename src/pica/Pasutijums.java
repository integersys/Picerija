package pica;

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
