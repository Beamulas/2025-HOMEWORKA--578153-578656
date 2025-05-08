package it.uniroma3.test.diadia.ambienti;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class testStanza {

	private Stanza s = new Stanza("10");
	private Attrezzo t = new Attrezzo("osso",3);
	private Attrezzo t2 = new Attrezzo("martello",4);
	
   
	@Test
	void testAddAttrezzo() {
			
		assertTrue(s.addAttrezzo(t));
		assertNotNull(s.addAttrezzo(t));
	
		s.addAttrezzo(t);
		s.addAttrezzo(t);
		s.addAttrezzo(t);
		s.addAttrezzo(t);
		s.addAttrezzo(t);
		s.addAttrezzo(t);
		s.addAttrezzo(t);
		s.addAttrezzo(t);
		s.addAttrezzo(t);
		s.addAttrezzo(t);
		
		assertFalse(s.addAttrezzo(t));
		
	}
	
	@Test
	void testHasAttrezzo() {
		
		s.addAttrezzo(t);
		s.addAttrezzo(t);
		s.addAttrezzo(t);
		s.addAttrezzo(t);
		s.addAttrezzo(t);
		s.addAttrezzo(t);
		s.addAttrezzo(t);
		s.addAttrezzo(t);
		s.addAttrezzo(t);
		s.addAttrezzo(t);
		
		assertTrue(s.hasAttrezzo("osso")); 
		assertFalse(s.hasAttrezzo("cane"));
	}
		
	@Test
	void testGetAttrezzo() {
			
		assertEquals("osso", t.getNome());
		assertNotEquals(2, t.getPeso());
		assertNotNull(t);
		
		//voglio verificare se torna l'oggetto vuoto
		t2 = null;
		assertNull(t2);
	}
	
	@Test
	void testRemoveAttrezzo() {
		
		assertFalse(this.s.removeAttrezzo(t));
		
		s.addAttrezzo(t);
		assertTrue(this.s.removeAttrezzo(t));
		
	}
	
	
	

}
