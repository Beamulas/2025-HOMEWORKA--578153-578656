package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;

import it.uniroma3.diadia.CaricatoreLabirinto;
import it.uniroma3.diadia.FormatoFileNonValidoException;

/*la classe Labirinto si occupa della creazione del labirinto vero e proprio andando a creare tutte le stanze*/
public class Labirinto {
	
    private Stanza stanzaIniziale; //la stanza da dove inizio a giocare
    private Stanza stanzaVincente;	//la stanza finale

    //costruttore, viene passato il nome del file ed è per questo che ci sono le exception
    public Labirinto(String nomeFile) throws FileNotFoundException, FormatoFileNonValidoException {
		CaricatoreLabirinto caricatore = new CaricatoreLabirinto(nomeFile);
		caricatore.carica();
		this.stanzaIniziale = caricatore.getStanzaIniziale();
		this.stanzaVincente = caricatore.getStanzaVincente();
	}
    
    public static LabirintoBuilder newBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
		return new LabirintoBuilder(labirinto);
	}

    /**
     * metodo che ritorna la stanza vincente 
     **/
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaIniziale = stanzaCorrente;
	}

	/**
	 * metodo che ritorna la stanza corrente 
	 **/
	public Stanza getStanzaCorrente() {
		return this.stanzaIniziale;
	}
}
