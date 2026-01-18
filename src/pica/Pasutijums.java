package pica;

public class Pasutijums {

    // --------- Lauki ---------
    private String tips;
    private double cena;
    private int picasizmers;
    private String merce;
    private String uzkodas;
    private String dzeriens;
    private boolean uzVietasIzvele;
    private String pilnvards;
    private String adrese;
    private String talr;
    

    // --------- Konstruktors ----------
    public Pasutijums(String tips, double cena, int picasizmers, String merce, String uzkodas, String dzeriens, boolean uzVietasIzvele,
    		String pilnvards, String adrese, String talr) {
        this.tips = tips; 
        this.cena = cena;
        this.picasizmers = picasizmers;
        this.merce = merce;
        this.uzkodas = uzkodas;
        this.uzVietasIzvele = uzVietasIzvele;
        this.pilnvards = pilnvards;
        this.adrese = adrese;
        this.talr = talr;
    }

//    // --------- toString (ērti debugam) ----------
//    @Override
//    public String toString() {
//        return "
//               "\nVārds un uzvārds" + 
//               "\nAdrese: " + adrese +
//               "\nTalrunis: " + talrunis +
//               "\nPica: " + picasNosaukums +
//               "\nIzmērs: " + picasizmers +
//               "\nCena: €" + String.format("%.2f", cena) +
//               "\nMērce: " + merce;
//    }
}