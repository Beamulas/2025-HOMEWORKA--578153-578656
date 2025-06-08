package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Mago extends AbstractPersonaggio {
	
	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " +
			"con una mia magica azione, troverai un nuovo oggetto " +
			"per il tuo borsone!";
	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla...";
	private Attrezzo attrezzo;
	
	//costruttore
	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo = attrezzo;
	}
	
	@Override
	public String agisci(Partita partita) {
		String messaggio;
		
		//se ho l'attrezzo
		if (this.attrezzo!=null) {
			partita.getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.attrezzo = null;
			messaggio = MESSAGGIO_DONO;
		}
		else {
			messaggio = MESSAGGIO_SCUSE;
		}
		return messaggio;
	}
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		StringBuilder messaggio = new StringBuilder("Grazie per avermi regalato ");
		messaggio.append(attrezzo.getNome()+".");
		messaggio.append(" Lo modificherò e lo lascerò!");
		
		//modifico il peso dell'attrezzo
		Attrezzo attrezzoModificato = new Attrezzo(attrezzo.getNome(), attrezzo.getPeso()/2);
		partita.getStanzaCorrente().addAttrezzo(attrezzoModificato);
		return messaggio.toString();
	}
}
