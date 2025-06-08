package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;
import java.util.*;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Cane;
import it.uniroma3.diadia.giocatore.Mago;
import it.uniroma3.diadia.giocatore.Strega;

public class LabirintoBuilder {

	private Labirinto labirinto;
	private Stanza ultimaAggiunta;
	private Map<String,Stanza> nome2stanza;
	
	public LabirintoBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
		this.labirinto = new Labirinto(labirinto);
		this.nome2stanza = new HashMap<>();
	}
	
	public Map<String, Stanza> getNome2stanza() {
		return nome2stanza;
	}

	public Labirinto getLabirinto() {
		return this.labirinto;
	}

	public LabirintoBuilder addStanzaIniziale(String stanzaIniziale) {
		Stanza stanza = new Stanza(stanzaIniziale);
		this.labirinto.setStanzaCorrente(stanza);
		this.UltimaStanzaAggiuntaEAggiorna(stanza);
		return this;
	}

	public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
		Stanza stanza = new Stanza(stanzaVincente);
		this.labirinto.setStanzaVincente(stanza);
		this.UltimaStanzaAggiuntaEAggiorna(stanza);
		return this;
	}

	public LabirintoBuilder addStanza(String stanza) {
		Stanza s = new Stanza(stanza);
		this.UltimaStanzaAggiuntaEAggiorna(s);
		return this;
	}	

	public LabirintoBuilder  addMago(String nome, String presentazione, Attrezzo attrezzo) {
		Mago mago = new Mago(nome, presentazione, attrezzo);
		if(this.ultimaAggiunta == null) {
			return this;
		}
		this.ultimaAggiunta.setPersonaggio(mago);
		return this;
	}

	public LabirintoBuilder  addCane(String nome, String presentazione) {
		Cane cane = new Cane(nome, presentazione);
		if(this.ultimaAggiunta == null) {
			return this;
		}
		this.ultimaAggiunta.setPersonaggio(cane);
		return this;
	}

	public LabirintoBuilder  addStrega(String nome, String presentazione) {
		Strega strega = new Strega(nome, presentazione);
		if(this.ultimaAggiunta == null) {
			return this;
		}
		this.ultimaAggiunta.setPersonaggio(strega);
		return this;
	}

	public LabirintoBuilder addAttrezzo(String attrezzo, int peso) {
		Attrezzo attrezzo1 = new Attrezzo(attrezzo, peso);
		if(this.ultimaAggiunta == null) {
			return this;
		}
		this.ultimaAggiunta.addAttrezzo(attrezzo1);
		return this;
	}

	public LabirintoBuilder addAdiacenza(String stanzaCorrente, String stanzaAdiecente, Direzione direzione) {
		Stanza c = this.nome2stanza.get(stanzaCorrente);
		Stanza a = this.nome2stanza.get(stanzaAdiecente);
		c.impostaStanzaAdiacente(direzione, a);
		return this;
	}

	public LabirintoBuilder addStanzaMagica(String nome) {
		Stanza stanza = new StanzaMagica(nome);
		this.UltimaStanzaAggiuntaEAggiorna(stanza);
		return this;
	}

	public LabirintoBuilder addStanzaBuia(String nome, String attrezzoPerVedere) {
		Stanza stanza = new StanzaBuia(nome,attrezzoPerVedere);
		this.UltimaStanzaAggiuntaEAggiorna(stanza);
		return this;
	}

	public LabirintoBuilder addStanzaBloccata(String nome, String attrezzoSbloccante, String direzioneBloccata) {
		Stanza stanza = new StanzaBloccata(nome, Direzione.valueOf(direzioneBloccata), attrezzoSbloccante);
		this.UltimaStanzaAggiuntaEAggiorna(stanza);
		return this;
	}

	public void UltimaStanzaAggiuntaEAggiorna(Stanza stanza) {
		this.ultimaAggiunta = stanza;
		this.nome2stanza.put(stanza.getNome(), stanza);
	}

	
}
