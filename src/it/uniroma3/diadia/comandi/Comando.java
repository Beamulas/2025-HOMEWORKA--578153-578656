package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;

/**
 * @author matteo 
 * @version base
 **/
public interface Comando {

	/*esecuzione del comando*/
	public void esegui(Partita partita);
	
	/*set parametro del comando*/
	public void setParametro(String parametro);
	
	/*get parametro del comando*/
	public String getParametro();
	
	/*get nome della stanza*/
	public String getNome();

	/*per la stampa*/
	void setIo(IO io);
	
}
