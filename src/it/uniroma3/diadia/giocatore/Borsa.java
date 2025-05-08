package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Borsa {

	//costante
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	
	//costruttore di default
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	//costruttore quando gli passo il peso massimo della borsa
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}
	
	/**
	 * @param l'oggetto attrezzo passato
	 * @return true se sono riuscito ad aggiungere l'attrezzo*/
	public boolean addAttrezzo(Attrezzo attrezzo) {
		
		//verifico se ho raggiunto il peso massimo trasportabile nella borsa
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax()) {
			return false;
		}
			
		//verifico se ho raggiunto il limite massimo di attrezzi nella borsa
		if (this.numeroAttrezzi == 10) {
			return false;
		}
			
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
	
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
				a = attrezzi[i];

		return a;
	}
	
	/**metodo per sapere quanto pesa in totale la borsa del giocatore 
	 *@return il peso totale della borsa*/
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++)
			peso += this.attrezzi[i].getPeso();

		return peso;
	}
	
	/**
	 * @return dimensione dell'array a 0 visto che ho svuotato la borsa dagli attrezzi*/
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	
	/**@return true se esiste l'attrezzo nella borsa, false altrimenti*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	
	
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		return a;
	}
	
	
	//per stampare la borsa
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}

}
