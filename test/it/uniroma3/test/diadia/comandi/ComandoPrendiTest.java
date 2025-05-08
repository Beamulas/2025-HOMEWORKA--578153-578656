package it.uniroma3.test.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPrendi;

class ComandoPrendiTest {

	private ComandoPrendi comandoPrendi;
	private Partita partita;
	private Stanza stanza;
	private Attrezzo attrezzo;

	@BeforeEach
	public void setUp() {
		comandoPrendi = new ComandoPrendi();
		partita = new Partita();
		stanza = new Stanza("Stanza di Test");
		attrezzo = new Attrezzo("Chiave",10);
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		partita.setStanzaCorrente(stanza);
	}



	@Test
	public void testEseguiOggettoPresente() {
		this.comandoPrendi.setParametro("Chiave");
		this.comandoPrendi.esegui(this.partita);
		assertTrue(this.partita.getGiocatore().getBorsa().hasAttrezzo("Chiave"));
		assertFalse(this.stanza.hasAttrezzo("Chiave"));
	}

	@Test
	public void testEseguiOggettoNonPresente() {
		this.comandoPrendi.setParametro("Martello");
		this.comandoPrendi.esegui(this.partita);
		assertFalse(this.partita.getGiocatore().getBorsa().hasAttrezzo("Martello"));
		assertTrue(this.stanza.hasAttrezzo("Chiave"));
	}
}
