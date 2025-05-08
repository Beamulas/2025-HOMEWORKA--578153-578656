package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Giocatore;

public class ComandoPrendi implements Comando{


	private String nomeOggetto;

	
	/*
	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Attrezzo attrezzo = stanzaCorrente.getAttrezzo(nomeOggetto);
		
		if (attrezzo != null) {	
			partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
			stanzaCorrente.removeAttrezzo(attrezzo);
			System.out.println("Hai preso: " + attrezzo.getNome());
		} else {
			System.out.println("Oggetto non trovato.");
			}
	}*/
	

	@Override	
	public void esegui(Partita partita) {
		if (nomeOggetto == null) {
			System.out.println("Quale attrezzo vuoi prendere?");
		}else {
			Stanza stanzaCorrente = partita.getStanzaCorrente();
			Attrezzo attrezzo = stanzaCorrente.getAttrezzo(nomeOggetto);
			if (attrezzo == null) {
				System.out.println("ERRORE: L'attrezzo che hai inserito non esiste nella stanza!");
			} else {
				if (partita.getGiocatore().prendereAttrezzo(attrezzo)) {
					stanzaCorrente.removeAttrezzo(attrezzo);
					System.out.println("Hai preso: " + nomeOggetto);
				} else {
					System.out.println("ERRORE: Non puoi prendere l'attrezzo!");
				}
			}
		}
}


	

	




	@Override
	public void setParametro(String parametro) {
		this.nomeOggetto = parametro;

	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

}
