package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza{

	//valore di defaoult per la soglia
	static final int SOGLIA_MAGICA_DEFAULT = 5;
	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	
	/*memorizza il numero di attrezzi da posare prima che si attivi il comportamento "magico" della stanza*/
	public int sogliaMagica() {
		
		return 0;
	}
	
	/**prendo solo il nome e imposto la soglia di default*/
	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}
	
	/**prendo sia il nome che la soglia*/
	public StanzaMagica(String nome, int soglia) {
		super(nome); //il nome è quello della super classe Stanza
		this.contatoreAttrezziPosati = 0; 
		this.sogliaMagica = soglia;
	}
	
	
	
	/**@return numero di attrezzi nella stanza*/
	public int contatoreAttezziPosati() {
		int numero = 0;
		
		return numero;
	}
	
	
	/**il metodo prende il nome dell'attrezzo e lo inverte,
	 * @param l'attrezzo che sia vuole modificare
	 * @return un attrezzo a partire dall'attrezzo passato come parametro*/
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		
		StringBuilder nomeInvertito; 
		int pesoX2 = attrezzo.getPeso()*2;	//raddoppio il peso dell'attrezzo
		nomeInvertito = new StringBuilder(attrezzo.getNome()); 
		nomeInvertito = nomeInvertito.reverse(); 
		
		attrezzo = new Attrezzo(nomeInvertito.toString(),pesoX2);
		
		return attrezzo;
	}
	
	/*vado a sovrascrivere il metodo della classe principale*/
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		
		this.contatoreAttrezziPosati++; 
		if(this.contatoreAttrezziPosati > this.sogliaMagica) {
			attrezzo = this.modificaAttrezzo(attrezzo);
		}
		
		return super.addAttrezzo(attrezzo);	//gli sto dicendo che voglio usare il metodo della super classe
		//altrimento ritornerebbe se stesso e non vogliamo che questo metodo sia ricorsivo
	}
	
	
	/*visto che ho cambiato le istanze di Stanza da private a protected posso riscrivere il metodo addAttrezzo nel seguente modo
	 *è possibile accedere ad un membro protected da tutte le classi estese, e da tutte le classi dello stesso package.*/
	/*
	public boolean addAttrezzo2(Attrezzo attrezzo) {
		
		this.contatoreAttrezziPosati++; 
		
		//verifico se ho più attrezzi che valore della soglia magica
		if(this.contatoreAttrezziPosati > this.sogliaMagica) {
			attrezzo = this.modificaAttrezzo(attrezzo);
		}
		if(this.numeroAttrezzi < this.attrezzi.length) {
			this.attrezzi[this.numeroAttrezzi] = attrezzo;
			this.numeroAttrezzi++;
			return true;
		}
		else {
			return false;
		}	
	}*/
	/*per ora la lascio come addAttrezzo2 perchè non ho capito se è questa quella corretta o solo una variante proposta dal professore per 
	 *imparare ad usare le istanze protected*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//metodi getter e setter
	public void setSogliaMagica(int sogliaMagica) {
		this.sogliaMagica = sogliaMagica;
	}
	public int getSogliaMagica() {
		return this.sogliaMagica;
	}
	
	public void setContatoreAttrezziPosati(int contatore) {
		this.contatoreAttrezziPosati = contatore;
	}
	
}
