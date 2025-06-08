package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/*prima questa classe implementava la classe Comando. Ora invece che usare un'interfaccia estende la classe AbstractComando che è una classe di tipo astratto. 
 *Così facendo non c'è più bisogno di utilizzare implementazioni vuote come quelle del metodo setParametro(). Ricordo che nelle classi astratte può essere inserito 
 *solo l'invocazione del metodo tralasciando il suo corpo che poi verrà implementato nelle classi concrete*/
public class ComandoPosa extends AbstractComando{

	private final static String NOME = "posa";

	@Override
	public void esegui(Partita partita) {
		
		Attrezzo attrezzo = partita.getGiocatore().getBorsa().getAttrezzo(this.getParametro());
		if(attrezzo == null) {
			this.getIo().mostraMessaggio("Attrezzo non presente nella borsa!");
			return;
		}
		if(partita.getStanzaCorrente().getNumeroAttrezziPossibili() > 0) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
			partita.getGiocatore().getBorsa().removeAttrezzo(this.getParametro());
		}
		else {
			this.getIo().mostraMessaggio("Non c'e' spazio nella stanza per poter inserire questo attrezzo!");
		}
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
