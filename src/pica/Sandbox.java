package pica;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Sandbox extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Queue<Pasutijums> aktiviePasutijumi = new LinkedList<>();
    ArrayList<Pasutijums> pabeigtiePasutijumi = new ArrayList<>();
 

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
    	    String picasNosaukums = Pasutijums.izveliesPicasTipu();
    	    if (picasNosaukums == null) {
    	        return; 
    	    }
                
                String piedevuTeksts = Pasutijums.izveliesPiedevas(picasNosaukums);
                if (piedevuTeksts == null) {
                    return; 
                }

 
                    	int picasIzmers = Pasutijums.izveletiesIzm();
                    	if (picasIzmers == -1) {
                    	    return; 
                    	}
                    
                    	String izvMerce = Pasutijums.izveliesMerci();
                    	if(izvMerce == null) {
                    		return;
                    	}
                    	
                    	String uzkodas = Pasutijums.izveliesUzkodas();
                    	if(uzkodas == null) {
                    		return;
                    	}
                   
                    	String dzeriens = Pasutijums.izveliesDzerienu();
                    	if(dzeriens == null) {
                    		return;
                    	}

                    	Boolean savakt = Pasutijums.izveliesPiegadi();    
                    	if(savakt == null) {
                    		return;
                    	}

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

            int izvele = JOptionPane.showOptionDialog(null,"Nākamais pasūtījums:\n\n" + nakamais.toString() +"\n\nVai atzīmēt šo pasūtījumu kā pabeigtu?","Apkalpot pasūtījumu",JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,jaNeOpcijas,jaNeOpcijas[0]);

            if (izvele == -1) {
                return;
            }
            
            if (izvele == 0) { 
                Pasutijums.pabeigtPasutijumu(aktiviePasutijumi, pabeigtiePasutijumi);
                JOptionPane.showMessageDialog(null,"Pasūtījums pabeigts!","Veiksmīgi",JOptionPane.INFORMATION_MESSAGE);
            } else {
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