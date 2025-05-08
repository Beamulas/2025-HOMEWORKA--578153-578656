package it.uniroma3.test.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {

	StanzaBuia stanzaBuia = new StanzaBuia("Stanza Oscura","lanterna");

	Attrezzo lanterna = new Attrezzo("lanterna", 1);
	Attrezzo libro = new Attrezzo("libro", 2);
	



	@Test
	void test() {
		
		libro = new Attrezzo("libro",2);
		stanzaBuia.addAttrezzo(libro);
		System.out.println("Descrizione senza lanterna: " + stanzaBuia.getDescrizione());

		assertTrue(stanzaBuia.hasAttrezzo("libro"));
		
		// Aggiungi l'attrezzo necessario
		stanzaBuia.addAttrezzo(lanterna);

		// Test con l'attrezzo necessario
		System.out.println("Descrizione con lanterna: " + stanzaBuia.getDescrizione());

	}

}
