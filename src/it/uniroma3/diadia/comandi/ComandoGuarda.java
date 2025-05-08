package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;


/*classe che implementa l'interfaccia Comando. Quando l'utente seleziona il comando "guarda" permette di vedere il contenuto
 *della stanza corrente*/
public class ComandoGuarda implements Comando {

	private String parametro;
	private String nome;
	
	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}
	
	/**
	 * @author matteo 
	 * @version base
	 * @return metodo che stampa le informazioni relative alla stanza passata come parametro
	 **/
	@Override
	public void esegui(Partita partita) {

		if(!partita.isFinita()) {
			//System.out.println("Stai guardando : " + partita.getStanzaCorrente().getNome());
			System.out.println("Aula : " + partita.getStanzaCorrente().getDescrizione());
		}
	}

	

	@Override
	public String getParametro() {
		return this.parametro;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return this.nome;
	}



}
