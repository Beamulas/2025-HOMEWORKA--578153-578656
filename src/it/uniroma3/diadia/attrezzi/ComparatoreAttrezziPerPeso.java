package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

public class ComparatoreAttrezziPerPeso implements Comparator<Attrezzo>{
	
	@Override
	public int compare(Attrezzo a1, Attrezzo a2) {
		int pesoDiff = a1.getPeso() - a2.getPeso();
		if (pesoDiff != 0) {
			return pesoDiff; //ordine crescente
		}
		return a1.getNome().compareTo(a2.getNome());
	}
}
