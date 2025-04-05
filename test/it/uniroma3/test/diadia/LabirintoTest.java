package it.uniroma3.test.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {

	private final Labirinto l = new Labirinto();
	private final Stanza s1 = new Stanza("Atrio");
	private final Stanza sd = new Stanza("Stanza diversa");
	private final Stanza sv = new Stanza("Biblioteca");
	
	@Test
	public void testGetStanzaIniziale() {
		assertEquals(s1.getNome(), l.getStanzaIniziale().getNome());
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals(sv.getNome(), l.getStanzaFinale().getNome());
	}
	
	@Test
	public void testStanzaInzialeDiversoAtrio() {
		assertFalse(l.getStanzaIniziale().getNome()== sd.getNome());
	}

}
