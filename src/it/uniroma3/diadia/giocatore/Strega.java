package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

import java.util.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/*se interagiamo con una strega questa ci trasferisce in una stanza tra quelle adiacenti. Siccome è permalosa:
	- se non l’abbiamo ancora salutata, ci «trasferisce» nella stanza adiacente che contiene meno attrezzi
	- altrimenti in quella che contiene più attrezzi*/
public class Strega extends AbstractPersonaggio {
	
	private static final String MESSAGGIO_SALUTATA = "Solo perche' mi hai salutato non ti caccio!!";
	private static final String MESSAGGIO_NON_SALUTATA = "Sei proprio una brutta persona, vai nella stanza con meno attrezzi!";

	//costruttore
	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String agisci(Partita partita) {
		String messaggio;
		List<Stanza> stanzeAdiacenti = partita.getStanzaCorrente().getStanzeAdiacenti();

		Stanza maxAtrezzi = stanzeAdiacenti.get(0);
		Stanza minAtrezzi = stanzeAdiacenti.get(0);

		for(Stanza stanza : stanzeAdiacenti) {
			if(stanza != null) {
				if(stanza.getNumeroAttrezzi() > maxAtrezzi.getNumeroAttrezzi())
					maxAtrezzi = stanza;
				if(stanza.getNumeroAttrezzi() < minAtrezzi.getNumeroAttrezzi())
					minAtrezzi = stanza;
			}
		}

		if(this.getHaSalutato()) {
			partita.setStanzaCorrente(maxAtrezzi);
			messaggio = MESSAGGIO_SALUTATA;
		} else {
			partita.setStanzaCorrente(minAtrezzi);
			messaggio = MESSAGGIO_NON_SALUTATA;
		}

		return messaggio;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		return "AHAHAHAHAHAHHA";
	}



}
