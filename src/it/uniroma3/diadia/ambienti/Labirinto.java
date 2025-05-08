package it.uniroma3.diadia.ambienti;
import it.uniroma3.diadia.attrezzi.Attrezzo;

/*la classe Labirinto si occupa della creazione del labirinto vero e proprio andando a creare tutte le stanze*/
public class Labirinto {
	
    private Stanza stanzaIniziale;
    private Stanza stanzaFinale;

    //costruttore generico
    public Labirinto() {
        creaStanze();
    }

    private void creaStanze() {
        /* crea gli attrezzi */
        Attrezzo lanterna = new Attrezzo("lanterna",3);
        Attrezzo osso = new Attrezzo("osso",1);

        /* crea stanze del labirinto */
        Stanza atrio = new Stanza("Atrio");
        Stanza aulaN11 = new Stanza("Aula N11");
        Stanza aulaN10 = new Stanza("Aula N10");
        Stanza laboratorio = new Stanza("Laboratorio Campus");
        Stanza biblioteca = new Stanza("Biblioteca");

        /* collega le stanze */
        atrio.impostaStanzaAdiacente("nord", biblioteca);
        atrio.impostaStanzaAdiacente("est", aulaN11);
        atrio.impostaStanzaAdiacente("sud", aulaN10);
        aulaN11.impostaStanzaAdiacente("est", laboratorio);
        aulaN11.impostaStanzaAdiacente("ovest", atrio);
        aulaN10.impostaStanzaAdiacente("nord", atrio);
        aulaN10.impostaStanzaAdiacente("est", aulaN11);
        aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
        laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
        biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* pone gli attrezzi nelle stanze */
        aulaN10.addAttrezzo(lanterna);
        atrio.addAttrezzo(osso);

        /* imposta la stanza iniziale e finale */
        this.stanzaIniziale = atrio;
        this.stanzaFinale = biblioteca;
    }

    //metodi getter e setter
    public Stanza getStanzaIniziale() {
        return this.stanzaIniziale;
    }

    public Stanza getStanzaFinale() {
        return this.stanzaFinale;
    }
    
    public void setStanzaIniziale(Stanza stanza) {
    	this.stanzaIniziale = stanza; 
    }
    public void setStanzaFinale(Stanza stanza) {
    	this.stanzaFinale = stanza;
    }
    
}