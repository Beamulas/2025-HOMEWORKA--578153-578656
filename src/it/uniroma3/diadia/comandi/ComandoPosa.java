package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.giocatore.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa implements Comando{

	private String nomeOggetto;

	@Override
	public void esegui(Partita partita) {
		// TODO Auto-generated method stub
		Borsa borsa = partita.getGiocatore().getBorsa();
		Attrezzo attrezzo = borsa.getAttrezzo(nomeOggetto); 


		if(attrezzo != null) {
			borsa.removeAttrezzo(nomeOggetto); 
			partita.getStanzaCorrente().addAttrezzo(attrezzo); 
			System.out.println("Hai posato: " + nomeOggetto);
		}else {
			System.out.println("Attrezzo non trovato nell'inventario");
		}


	}

	@Override
	public void setParametro(String parametro) {
		// TODO Auto-generated method stub
		this.nomeOggetto = parametro;

	}

	@Override
	public String getParametro() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

}
