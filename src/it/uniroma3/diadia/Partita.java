package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;


/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO
 * @see Stanza
 * @version base
 * 
 */

public class Partita {

	//inizializzazione constante
	static final private int CFU_INIZIALI = 20;	//sono le vite iniziali

	private Stanza stanzaCorrente;
	//private Stanza stanzaFinale; 
	private boolean finita;	//mi aiuta a verificare se la partita è finita overro quando Cfu = 0
	private int cfu;
	private Labirinto lab;
	private Giocatore giocatore;
	
	public Partita(){
		
		//creaStanze();
		this.lab = new Labirinto();
        this.stanzaCorrente = lab.getStanzaIniziale();
       //this.stanzaFinale = lab.getStanzaFinale();
		this.finita = false;
		this.cfu = CFU_INIZIALI;
		this.giocatore = new Giocatore();
		this.giocatore.setCfu(CFU_INIZIALI);
		
	}

 

	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaCorrente = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaCorrente;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
        return this.getStanzaCorrente() == this.lab.getStanzaFinale();
    }

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (cfu == 0);
	}

	/**
	 * Imposta la partita come finita
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	//metodo getter per il giocatore
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	
	
	/**@return true se il giocatore è vivo, false altrimenti*/
	public boolean giocatoreIsVivo() {
		
		if(giocatore.getCfu() <= 0) {
			return false;
		}
		return true;
	}
}
