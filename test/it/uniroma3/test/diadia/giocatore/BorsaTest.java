package it.uniroma3.test.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class BorsaTest {

	private final Attrezzo a = new Attrezzo("prova", 2);
	private final Borsa b = new Borsa();
	private final Attrezzo pugnale = new Attrezzo("puglane", 3);
	private final Attrezzo spada = new Attrezzo("spada", 33);
	
	
	@Test
	public void testAddAttrezzo() {
		assertTrue(b.addAttrezzo(a));
	}

	
	@Test
	public void testAddAttrezzoDiversoNull() {
		assertNotNull(b.addAttrezzo(a));
	}
	
	@Test
	public void testGetPesoMax() {
		assertFalse(b.getPesoMax()== 3);		
	}
	
	@Test
	public void testAddAttrezzoPesoMinoreDiDieci() {
		assertTrue(b.addAttrezzo(pugnale));
	}
	
	@Test
	public void testAddAttrezzoPesoMaggioreDiDieci() {
		assertFalse(b.addAttrezzo(spada));
	}


}
