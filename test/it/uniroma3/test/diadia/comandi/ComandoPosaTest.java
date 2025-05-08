package it.uniroma3.test.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.ComandoPosa;

public class ComandoPosaTest {
    private ComandoPosa comandoPosa;
    private Partita partita;
    private Stanza stanza;
    private Attrezzo attrezzo;

    @BeforeEach
    public void setUp() {
        comandoPosa = new ComandoPosa();
        partita = new Partita();
        stanza = new Stanza("Stanza di Test");
        attrezzo = new Attrezzo("Chiave",10);
        partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
        partita.setStanzaCorrente(stanza);
    }

    @Test
    public void testEseguiOggettoPresente() {
        comandoPosa.setParametro("Chiave");
        comandoPosa.esegui(partita);
       
        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("Chiave"));
        assertNotNull(stanza.getAttrezzo("Chiave"));
    }

    @Test
    public void testEseguiOggettoNonPresente() {
        comandoPosa.setParametro("Libro");
        comandoPosa.esegui(partita);
        assertFalse(partita.getStanzaCorrente().hasAttrezzo("Libro"));
    }
}
