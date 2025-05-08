package it.uniroma3.test.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	
	Stanza s1; 
	Stanza s2; 
	StanzaBloccata stanzaBloccata;
	Attrezzo attrezzo; 
	
	@BeforeEach
	void setUp() {
		this.attrezzo = new Attrezzo("Piede di porco",2); 
		this.s1 = new Stanza("Stanza A"); 
		this.s2 = new Stanza("Stanza B");
		this.stanzaBloccata = new StanzaBloccata("Stanza A bloccata","sud","Piede di porco" );
		stanzaBloccata.impostaStanzaAdiacente("sud", s1);
		stanzaBloccata.addAttrezzo(attrezzo);
	}

	@Test
	void testGetStanzaAdiacenteBloccata() {
		assertEquals(stanzaBloccata, stanzaBloccata.getStanzaAdiacente("sud"));
	}
	
	@Test
	void testgetStanzaAdiacenteNonBloccata() {
	
		assertNotEquals(s2.getNome(),stanzaBloccata.getStanzaAdiacente("sud").getNome());
	}
	@Test
	void testgetStanzaAdiacenteNull() {
		
		assertNull(stanzaBloccata.getStanzaAdiacente("nord"));
	}
	
	//Test metodo getDescrizione
	@Test
	void testgetDescrizione() {
		stanzaBloccata.addAttrezzo(attrezzo);	
		assertEquals(stanzaBloccata.toString(),stanzaBloccata.getDescrizione());
	}
	@Test
	void testgetDescrizioneNotEquals() {
		assertNotEquals(stanzaBloccata.toString(),stanzaBloccata.getDescrizione());
	}
	@Test
	void testgetDescrizioneNotNull() {
		assertNotNull(stanzaBloccata.getDescrizione());
	}


}
