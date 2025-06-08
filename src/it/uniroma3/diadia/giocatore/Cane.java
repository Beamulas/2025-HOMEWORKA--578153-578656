package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/*morde! Ogni morso diminuisce i CFU del
protagonista*/
public class Cane extends AbstractPersonaggio{
	
	private static String MESSAGGIO_CANE = "Bau bau, ti ho tolto un CFU!, bau bau";
	private static String CIBO_PREFERITO= "osso";
	
	//costruttore
	public Cane(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String agisci(Partita partita) {
		String messaggio = MESSAGGIO_CANE;
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		return messaggio;
	}

	/*un cane riceve un regalo: accetta il suo cibo preferito, e butta a terra un attrezzo; 
	 *ma morde e toglie un CFU per tutto il resto*/
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
			
		StringBuilder messaggio = new StringBuilder("Bau grazie per avermi regalato ");
		if(attrezzo.getNome().equals(CIBO_PREFERITO)) {
			messaggio.append("il mio cibo preferito.");
			partita.getStanzaCorrente().addAttrezzo(new Attrezzo("collare", 2));
		} else {
			messaggio.append(attrezzo.getNome()+",ma non e' il mio cibo preferit, bau!");
			partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);
		}
		
		return messaggio.toString();
	}
}
