package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

/*classe che fa quello che faceva la StanzaMAgica ma questa volta i metodi dell'estensione sono protetti e non privati*/
public class StanzaMagicaProtected extends StanzaProtected{

	//valore di defaoult per la soglia
	static final int SOGLIA_MAGICA_DEFAULT = 5;
	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	
	public StanzaMagicaProtected(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}
	
	/**prendo sia il nome che la soglia*/
	public StanzaMagicaProtected(String nome, int soglia) {
		super(nome); //il nome è quello della super classe Stanza
		this.contatoreAttrezziPosati = 0; 
		this.sogliaMagica = soglia;
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
	
	
	/*visto che ho cambiato le istanze di Stanza da private a protected posso riscrivere il metodo addAttrezzo nel seguente modo
	 *è possibile accedere ad un membro protected da tutte le classi estese, e da tutte le classi dello stesso package.*/
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		
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
	}
	
	
	//metodi getter e setter
	public void setContatoreAttrezziPosati(int numero) {
		this.contatoreAttrezziPosati = numero; 
	}
	public void setSogliaMagica(int sogliaMagica) {
		this.sogliaMagica = sogliaMagica; 
	}
	
	public int getContatoreAttrezziPosati() {
		return this.contatoreAttrezziPosati;
	}
	public int getSogliaMagica() {
		return this.sogliaMagica;
	}
	
	
	
	
}
