package it.uniroma3.test.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import funzioniDiProva.Fixture;
import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzione;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoFine;
import it.uniroma3.diadia.comandi.ComandoVai;


public class ComandoVaiTest {

	private Stanza s1;
	private Stanza s2;
	private Comando vai;
	private Partita p;
	List<String> righeDaLeggere;
	List<String> righeDaLeggere2;
	Labirinto labirinto;
	Labirinto labirinto2;
	private IO io;

	@Before
	public void setUp() throws Exception {
		io = new IOConsole(new Scanner(System.in));
		s1 = new Stanza("aula 1");
		s2 = new Stanza("aula 2");
		vai = new ComandoVai();
		 labirinto = Labirinto.newBuilder("labirinto2.txt").getLabirinto();
		p = new Partita(labirinto);
		vai.setIo(io);
		righeDaLeggere = new ArrayList<>();
		righeDaLeggere2 = new ArrayList<>();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testVaiNull() {
		p.setStanzaCorrente(s1);
		vai.esegui(p);
		assertEquals(s1, p.getStanzaCorrente());
	}

	@Test
	public void testVaiDirezioneEsistente() {
		p.setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente(Direzione.sud, s2);
		vai.setParametro("sud");
		vai.esegui(p);
		assertEquals(s2, p.getStanzaCorrente());
	}

	@Test
	public void testVaiDirezioneInesistente() {
		p.setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente(Direzione.sud, s2);
		vai.setParametro("nord");
		vai.esegui(p);
		assertNotEquals(s2, p.getStanzaCorrente());
	}

	@Test
	public void testPartitaConComandoVai() throws Exception {
		righeDaLeggere.add("vai nord");

		IOSimulator io = Fixture.creaSimulazionePartitaEGioca(righeDaLeggere);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("Biblioteca", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("Hai vinto!", io.nextMessaggio());
		
	}
	
	@Test
	public void testPartitaConComandoVaiOvest() throws Exception {
		righeDaLeggere2.add("vai ovest");
		righeDaLeggere2.add("fine");

		IOSimulator io = Fixture.creaSimulazionePartitaEGiocaHard(righeDaLeggere2);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("Studio", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(ComandoFine.MESSAGGIO, io.nextMessaggio());
	}
	
	@Test
	public void testPartitaConComandoVaiOvestEst() throws Exception {
		righeDaLeggere2.add("vai ovest");
		righeDaLeggere2.add("vai est");
		righeDaLeggere2.add("fine");

		IOSimulator io = Fixture.creaSimulazionePartitaEGiocaHard(righeDaLeggere2);
		assertTrue(io.hasNextMessaggio());
		assertEquals(DiaDia.MESSAGGIO_BENVENUTO, io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("Studio", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals("Atrio", io.nextMessaggio());
		assertTrue(io.hasNextMessaggio());
		assertEquals(ComandoFine.MESSAGGIO, io.nextMessaggio());
	}
	
}


