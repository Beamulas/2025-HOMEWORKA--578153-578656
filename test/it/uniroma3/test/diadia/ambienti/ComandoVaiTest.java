package it.uniroma3.test.diadia.ambienti;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import funzioniDiProva.Fixture;
import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.AbstractComando;
import it.uniroma3.diadia.comandi.ComandoFine;
import it.uniroma3.diadia.comandi.ComandoVai;


public class ComandoVaiTest {
	
	private static final String NOME_STANZA_PARTENZA = "Partenza";
	private static final String NORD = "nord";
	private static final Direzione DIREZIONE_NORD = Direzione.nord;
	private Partita partita;
	private AbstractComando comandoVai;
	private Stanza partenza;

	@Before
	public void setUp() throws Exception {
		this.comandoVai = new ComandoVai();
		this.comandoVai.setIo(new IOConsole());
		Labirinto labirinto = new Labirinto("labirinto5.txt");
		this.partita = new Partita(labirinto);
		this.partenza = this.partita.getStanzaCorrente();
	}

	@Test
	public void testVaiStanzaNonPresente() {
		this.comandoVai.setParametro(NORD);
		this.comandoVai.esegui(this.partita);
		assertEquals(NOME_STANZA_PARTENZA, this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testVaiStanzaPresente() {
		Stanza destinazione = new Stanza("Destinazione");
		this.partenza.impostaStanzaAdiacente(DIREZIONE_NORD, destinazione);
		this.comandoVai.setParametro(NORD);
		this.comandoVai.esegui(partita);
		assertEquals("Destinazione", this.partita.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testVaiStanzaPresenteInDirezioneSbagliata() {
		Stanza destinazione = new Stanza("Destinazione");
		this.partenza.impostaStanzaAdiacente(Direzione.sud, destinazione);
		this.comandoVai.setParametro(NORD);
		this.comandoVai.esegui(partita);
		assertEquals(NOME_STANZA_PARTENZA, this.partita.getStanzaCorrente().getNome());
	}
	

	public void assertContains(String expected, String interaRiga) {
		assertTrue(interaRiga.contains(expected));
	}

}
