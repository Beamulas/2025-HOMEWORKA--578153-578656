package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.giocatore.AbstractPersonaggio;

public class ComandoInteragisci extends AbstractComando{

	//istanze 
	private static final String MESSAGGIO_CON_CHI = "Con chi devo interagire?....";
	private String messaggio; 
	private IO io; 
	
	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio; 
		personaggio = partita.getStanzaCorrente().getPersonaggio();
		
		//se esiste il personaggio
		if(personaggio != null) {
			this.messaggio = personaggio.agisci(partita);
			io.mostraMessaggio(this.messaggio);
		}
		else {
			io.mostraMessaggio(MESSAGGIO_CON_CHI);
		}
	}

	@Override
	public String getNome() {
		return "interagisci";
	}
	
	@Override
	public void setIo(IO io) {
		this.io = io;
	}

}
