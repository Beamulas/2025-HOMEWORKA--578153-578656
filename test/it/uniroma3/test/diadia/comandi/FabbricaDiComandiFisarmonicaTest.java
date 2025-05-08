package it.uniroma3.test.diadia.comandi;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;

/*bisogna finire di implementarlo*/
class FabbricaDiComandiFisarmonicaTest {

	private String nomeComando = null; 
	private FabbricaDiComandiFisarmonica f = new FabbricaDiComandiFisarmonica();
	private Comando c;
	
	@Test
	void verificaVai() {
		String ciao = f.costruisciComando("vai vai").getParametro();
		nomeComando = "vai"; 

		assertEquals(nomeComando,f.costruisciComando("fine fine").getNome());
		assertNotEquals(nomeComando, "ciao");
	}
	
	@Test
	void verificaNull() {
		assertEquals(nomeComando, null);
		assertNotEquals(nomeComando, "ciccio");
	}
	
	@Test
	void verificaComandoNonValido() {
		nomeComando = "ciao"; 
		assertNotEquals(nomeComando, "via"); 
		assertNotEquals(nomeComando, "guarda"); 
		assertNotEquals(nomeComando, "fine"); 
		assertNotEquals(nomeComando, "posa"); 
		assertNotEquals(nomeComando, "prendi"); 
		assertNotEquals(nomeComando, "aiuto"); 
	}

	@Test 
	void verificaAiuto() {
		nomeComando = "aiuto"; 
		assertEquals(nomeComando, "aiuto"); 
	}
	
}
