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
