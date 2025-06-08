package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;


/*prima questa classe implementava la classe Comando. Ora invece che usare un'interfaccia estende la classe AbstractComando che è una classe di tipo astratto. 
 *Così facendo non c'è più bisogno di utilizzare implementazioni vuote come quelle del metodo setParametro(). Ricordo che nelle classi astratte può essere inserito 
 *solo l'invocazione del metodo tralasciando il suo corpo che poi verrà implementato nelle classi concrete*/
public class ComandoFine extends AbstractComando{
	
	public final static String MESSAGGIO = "Hai deciso di finire la partita e quindi hai scelto la MORTE!!!";
	public final static String NOME = "fine";

	@Override
	public void esegui(Partita partita) {
		System.out.println(MESSAGGIO); 
		partita.getGiocatore().setCfu(0);
		partita.setFinita();		
	}

	@Override
	public String getNome() {
		return NOME;
	}
}
