package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;


/*prima questa classe implementava la classe Comando. Ora invece che usare un'interfaccia estende la classe AbstractComando che è una classe di tipo astratto. 
 *Così facendo non c'è più bisogno di utilizzare implementazioni vuote come quelle del metodo setParametro(). Ricordo che nelle classi astratte può essere inserito 
 *solo l'invocazione del metodo tralasciando il suo corpo che poi verrà implementato nelle classi concrete*/
public class ComandoPrendi extends AbstractComando{

	private final static String NOME = "prendi";
	
	@Override	
	public void esegui(Partita partita) {
		Attrezzo attrezzo = partita.getLabirinto().getStanzaCorrente().getAttrezzo(this.getParametro());
		if(attrezzo ==null) {
			this.getIo().mostraMessaggio("Attrezzo non presente nella stanza!");
		} 
		else {
			if(partita.getGiocatore().getBorsa().getPesoRimanente(attrezzo)) {
				partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
				partita.getLabirinto().getStanzaCorrente().removeAttrezzo(attrezzo);
			} 
			else
				this.getIo().mostraMessaggio("Attrezzo troppo pesante per entrare nella borsa!");
			}
	}

	@Override
	public String getNome() {
		return NOME;
	}

}
