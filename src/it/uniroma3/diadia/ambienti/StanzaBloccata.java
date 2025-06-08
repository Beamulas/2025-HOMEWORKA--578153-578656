package it.uniroma3.diadia.ambienti;

/**classe che verifica se nella stanza è presente un determinato oggetto altrimeti
 * non possiamo utilizzare una delle direzioni della stanza
 * @author Matteo
 * @version base
 **/
public class StanzaBloccata extends Stanza{
	
	private Direzione direzioneBloccata;
	private String nomeAttrezzoNecessario;
	
	/*quando creo una classa che ne estende un'altra devo ridefinire il costruttore per la nuova classse per
	 *assicurarmi che tutti gli attributi della classe base siano inizializzati correttamente*/
	public StanzaBloccata(String nome, Direzione direzioneBloccata, String nomeAttrezzoNecessario) {
		super(nome); //il nome della stanza lo eredito dal genitore
		this.direzioneBloccata = direzioneBloccata;
		this.nomeAttrezzoNecessario = nomeAttrezzoNecessario;
	}
	
	
	@Override 
	public Stanza getStanzaAdiacente(Direzione direzione) {
		if(!this.hasAttrezzo(nomeAttrezzoNecessario) && direzione.equals(direzioneBloccata)) {
			return this;	//mi rimane la stessa stanza stanza se la direzione è bloccata
		}
		else {
			return super.getStanzaAdiacente(direzione);//ritorna la stanza adiacete del genitore
			//faccio così perché altrimenti la funzione risulta ricorsiva e io non voglio questo
		}
	}
	
	@Override
	public String getDescrizione() {
		String descrizione = super.getDescrizione();
		if(!this.hasAttrezzo(nomeAttrezzoNecessario)) {
			descrizione += "\nLa direzione " + direzioneBloccata + " è bloccata";
			return descrizione;
		}
		return super.getDescrizione();	
	}	
}
