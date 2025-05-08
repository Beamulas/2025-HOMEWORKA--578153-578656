package it.uniroma3.diadia;

import java.util.ArrayList;
import java.util.List;

public class IOSimulator implements IO {


	private List<String> messaggiStampati; 
	private List<String> righeDaLeggere; 
	private int indice;	//mi deve indicare la lettura



	//costruttore 
	public IOSimulator(List<String> righeDaLeggere) {
		this.messaggiStampati = new ArrayList<>(); 
		this.righeDaLeggere = new ArrayList<>(righeDaLeggere);
		this.indice = 0;
	}




	@Override
	public void mostraMessaggio(String messaggio) {
		System.out.println(messaggio); 
		this.messaggiStampati.add(messaggio);
	}

	@Override
	public String leggiRiga() {
		
		if(indice < righeDaLeggere.size()) {
			String riga = righeDaLeggere.get(indice); 
			indice++;
			return riga;
		}
		else {
			return null; //potrei anche gestire il caso in cui non ci sono più righe da leggere
		}
	}


	public List<String> getMessaggiStampati() {
		return new ArrayList<>(messaggiStampati);
	}


}
