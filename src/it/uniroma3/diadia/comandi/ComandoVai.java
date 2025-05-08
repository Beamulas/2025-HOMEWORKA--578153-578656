package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

/**
 * @author matteo
 * @versio base*/
public class ComandoVai implements Comando {


	private String direzione; 
	private String parametro;

	//costruttore
	public ComandoVai(String direzione) {
		this.direzione = direzione; 
	}
	//costruttorre
	public ComandoVai() {
		this.direzione = null;
	}

	@Override
	public void esegui(Partita partita) {

		//devo metterci il codice per cambiare stanza
		Stanza stanzaCorrente = partita.getStanzaCorrente(); 
		Stanza prossimaStanza = null;	//non setto la stanza successiva 

		//verifico se ho impostato la direzione 
		if(direzione == null) {
			System.out.println("Dove vuoi andare? Devi specificare una direzione"); 
			return;
		}

		//inizializzo la stanza successiva 
		prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione); 
		//la stanza successiva è quella adiacente alla stanza corrente rispetto alla direzione data


		if(prossimaStanza == null) {
			System.out.println("Questa direzione non estiste"); 
			return; 
		}

		//la stanza successiva diventa la corrente percè ho cambiato stanza
		partita.setStanzaCorrente(prossimaStanza);
		System.out.println(partita.getStanzaCorrente().getNome()); //prendo il nome della nuova stanza corrente

		//vado a togliere una vita togliendo un Cfu
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-1);


	}

	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	//metodi getter e setter 
	public void setDirezione(String direzione) {
		this.direzione = direzione; 
	}
	public String getDirezione() {
		return this.direzione; 
	}
	@Override
	public String getParametro() {
		return this.parametro;
	}
	@Override
	public String getNome() {
		
		return this.direzione;
	}

}
