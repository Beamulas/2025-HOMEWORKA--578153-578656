package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public abstract class AbstractPersonaggio{

	private String nome; 
	private String presentazione; 
	private boolean haSalutato; 
	
	//costruttore
	public AbstractPersonaggio(String nome, String presentazione) {
		this.nome = nome; 
		this.presentazione = presentazione; 
		haSalutato = false;	//inizio che non ho salutato
	}
	
	abstract public String agisci(Partita partita);
	abstract public String riceviRegalo(Attrezzo attrezzo, Partita partita);
	
	
	public String saluta() {
		
		StringBuilder risposta = new StringBuilder("Ciao, io sono ");
		risposta.append(this.getNome() + "."); 
		
		//se non mi sono già presentato mi presento
		if(!haSalutato) {
			risposta.append(this.presentazione);
		}
		else {
			risposta.append("Ci siamo già presentati!"); 
		}
		this.haSalutato = true;
		return risposta.toString();
	}
	
	
	//metodi getter e setter 
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setPresentazione(String presentazione) {
		this.presentazione = presentazione;
	}
	public void setHaSalutato(boolean haSalutato) {
		this.haSalutato = haSalutato; 
	}
	public String getNome() {
		return this.nome;
	}
	public String getPresentazione() {
		return this.presentazione;
	}
	public boolean getHaSalutato() {
		return this.haSalutato;
	}
	
	@Override
	public String toString() {
		return this.getNome();
	}
}
