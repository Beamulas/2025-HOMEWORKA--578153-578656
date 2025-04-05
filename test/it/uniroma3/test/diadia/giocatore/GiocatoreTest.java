package it.uniroma3.test.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.giocatore.Giocatore;

public class GiocatoreTest {
	
	 Giocatore g = new Giocatore();

	@Test
	void testGetCfu() {
		assertEquals(20, g.getCfu());	
		assertNotEquals(30, g.getCfu());
		assertNotNull(g.getCfu());
		
	}
	
	@Test
	void testGetBorsa() {
		assertNotNull(g.getBorsa());
		g.setBorsa(null);
		assertNull(g.getBorsa());
		assertNotEquals(20, g.getBorsa());
	}

	@Test
	void testSetCfu() {
		g.setCfu(3);
		assertEquals(3, g.getCfu());
		
		for(int i=0; i<5; i++) {
			g.setCfu(i); 
			assertEquals(i,g.getCfu());
		}
		
		if(g.getCfu()<0) {
			fail("non puoi iniziare il gioco");
		}
		
	}
}
