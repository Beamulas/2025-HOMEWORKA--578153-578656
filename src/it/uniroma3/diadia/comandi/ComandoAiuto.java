package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto implements Comando {

	private String parametro;
	
	@Override
	public void esegui(Partita partita) {
		System.out.println("I comandi sono: aiuto - posa - guarda - prendi - fine");
	}

	@Override
	public void setParametro(String parametro) {
		this.parametro = parametro;
		
	}

	@Override
	public String getParametro() {
		return this.parametro;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

}
