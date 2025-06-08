package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/*classe copiata dalle slide, non so se è utile. Nel dubbio la lascio*/
public class FakePersonaggio extends AbstractPersonaggio{

	//costruttore
	public FakePersonaggio(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		return "done";
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		// TODO Auto-generated method stub
		return null;
	}

}
