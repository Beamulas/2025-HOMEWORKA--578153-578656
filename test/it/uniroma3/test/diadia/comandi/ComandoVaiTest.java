package it.uniroma3.test.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.comandi.ComandoVai;

class ComandoVaiTest {

	private ComandoVai comandoVai;
	
	@Test
	void test() {
		
		comandoVai = new ComandoVai();
		assertSame("vai",comandoVai);
	}

}
