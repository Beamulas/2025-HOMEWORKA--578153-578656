package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.giocatore.Giocatore;
import it.uniroma3.diadia.Partita;

/**
 * @author matteo
 * @versio base*/

/*prima questa classe implementava la classe Comando. Ora invece che usare un'interfaccia estende la classe AbstractComando che è una classe di tipo astratto. 
 *Così facendo non c'è più bisogno di utilizzare implementazioni vuote come quelle del metodo setParametro(). Ricordo che nelle classi astratte può essere inserito 
 *solo l'invocazione del metodo tralasciando il suo corpo che poi verrà implementato nelle classi concrete*/
public class ComandoVai extends AbstractComando {

private final static String NOME = "vai";
	
	@Override
	public void esegui(Partita partita) {
		Stanza stanzaCorrente = partita.getStanzaCorrente();
		Stanza prossimaStanza = null;
		if (this.getParametro() == null) {
			this.getIo().mostraMessaggio("Dove vuoi andare? Devi specificare una direzione");
		}
		if(this.getParametro()!=null )// && (Direzione.valueOf(this.getParametro()).getClass() != Direzione.class))
			try {
			prossimaStanza = stanzaCorrente.getStanzaAdiacente(Direzione.valueOf(this.getParametro()));
			} catch(IllegalArgumentException e) {
				this.getIo().mostraMessaggio("Direzione inesistente");
				return;
			}
			
			if (prossimaStanza == null) {
			this.getIo().mostraMessaggio("Direzione inesistente");
			return;
		}

		partita.setStanzaCorrente(prossimaStanza);
		this.getIo().mostraMessaggio(partita.getStanzaCorrente().getNome());
		Giocatore giocatore = partita.getGiocatore();
		giocatore.setCfu(giocatore.getCfu() - 1);
	}
	
	@Override
	public String getNome() {
		return NOME;
	}
}
