package pica;
public class pasutitajs {

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

    // --------- Konstruktors ----------
    public pasutitajs(int picasIzmers, int pasutijumaID, double cena, boolean uzVietas,
                      String vards, String adrese, String talrunis,
                      String piedeva, String picasNosaukums) {

        this.picasIzmers = picasIzmers;
        this.pasutijumaID = pasutijumaID;
        this.cena = cena;
        this.uzVietas = uzVietas;
        this.vards = vards;
        this.adrese = adrese;
        this.talrunis = talrunis;
        this.piedeva = piedzeva;
        this.picasNosaukums = picasNosaukums;
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