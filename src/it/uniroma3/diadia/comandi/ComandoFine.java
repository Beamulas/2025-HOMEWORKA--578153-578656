package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

public class ComandoFine implements Comando{

	private String parametro; 
	
	@Override
	public void esegui(Partita partita) {
		System.out.println("Hai deciso di finire la partita e quindi hai scelto la MORTE!!!"); 
		partita.getGiocatore().setCfu(0);
		partita.setFinita();		
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
