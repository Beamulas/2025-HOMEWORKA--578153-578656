package it.uniroma3.diadia.giocatore;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/*classe che si occupa di gestire le informazioni relative al giocatore come i CFU che rappresentano le vite*/
public class Giocatore {
	
	//costante
	static final private int CFU_INIZIALI = 20;
	
	private int cfu;
	private Borsa borsa;
	
	/*serve per inizializzare i cfu iniziali (le vite) e la borsa del giocatore (l'inventario)*/
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
		
	}

	/**
	 *@param l'oggetto attrezzo 
	 *@return true se sono riuscito a prendere l'attrezzo, false altrimenti*/
	public boolean prendereAttrezzo(Attrezzo attrezzo) {
        return this.borsa.addAttrezzo(attrezzo);
    }

	/**
	 *@param l'oggetto attrezzo
	 *@return true se sono riuscito a posarlo, false altrimenti*/
    public Attrezzo posareAttrezzo(String nomeAttrezzo) {
        return this.borsa.removeAttrezzo(nomeAttrezzo);
    }
	

	//metodi getter e setter del giocatore
	public int getCfu() {
		return cfu;
	}

	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	//metodi getter e setter della borsa
	public Borsa getBorsa() {
		return borsa;
	}

	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}

    
  
}
