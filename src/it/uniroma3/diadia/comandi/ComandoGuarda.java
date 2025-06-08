package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;


/*prima questa classe implementava la classe Comando. Ora invece che usare un'interfaccia estende la classe AbstractComando che è una classe di tipo astratto. 
 *Così facendo non c'è più bisogno di utilizzare implementazioni vuote come quelle del metodo setParametro(). Ricordo che nelle classi astratte può essere inserito 
 *solo l'invocazione del metodo tralasciando il suo corpo che poi verrà implementato nelle classi concrete*/
public class ComandoGuarda extends AbstractComando{

	private final static String NOME = "guarda";
	
	@Override
	public void esegui(Partita partita) {
		
		//se la partita non è finita
		if(!partita.isFinita()) {
			this.getIo().mostraMessaggio("Aula : " + partita.getStanzaCorrente().getDescrizione());
		}
	}

	@Override
	public String getNome() {
		return NOME;
	}
}
