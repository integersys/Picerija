package pica;
public class Pasutijums {

    // --------- Lauki ----------
    private int picasIzmers;
    private int pasutijumaID; 
    private double cena;
    private boolean uzVietas;

    private String vards;
    private String adrese;
    private String talrunis;
    private String piedeva;
    private String picasNosaukums;
    String tips;

    // --------- Konstruktors ----------
    public Pasutijums(String tips, double cena) {
        this.tips = tips;
        this.cena = cena;
    }

    // --------- Getter metodes ----------
    public int getPicasIzmers() {
        return picasIzmers;
    }

    public int getPasutijumaID() {
        return pasutijumaID;
    }

    public double getCena() {
        return cena;
    }

    public boolean isUzVietas() {
        return uzVietas;
    }

    public String getVards() {
        return vards;
    }

    public String getAdrese() {
        return adrese;
    }

    public String getTalrunis() {
        return talrunis;
    }

    public String getPiedeva() {
        return piedeva;
    }

    public String getPicasNosaukums() {
        return picasNosaukums;
    }

    // --------- toString (ērti debugam) ----------
    @Override
    public String toString() {
        return "Pasūtījums #" + pasutijumaID +
               "\nVārds: " + vards +
               "\nAdrese: " + adrese +
               "\nTalrunis: " + talrunis +
               "\nPica: " + picasNosaukums +
               "\nIzmērs: " + picasIzmers;
}
}