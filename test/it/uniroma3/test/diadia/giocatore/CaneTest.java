package it.uniroma3.test.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Cane;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class CaneTest {

    private Cane cane;
    private Partita partita;
    private final static String MESSAGGIO_CANE = "Bau bau, ti ho tolto un CFU!";
    
    @BeforeEach
    public void setUp() throws Exception {
        // Istanziamo un cane con nome e presentazione
        cane = new Cane("Fido", "Il cane fedele");
        
        // Creazione di una partita con un Labirinto dummy (assicurarsi che il file dummy.txt funzioni o utilizzare mocking)
        Labirinto labirinto = new Labirinto("labirinto5.txt");
        partita = new Partita(labirinto);
        
        // Impostiamo manualmente la stanza corrente a una stanza di test, in quanto il metodo riceviRegalo() vi aggiunge attrezzi
        Stanza stanzaTest = new Stanza("StanzaTest");
        partita.getLabirinto().setStanzaCorrente(stanzaTest);
        
        // Impostiamo un CFU iniziale al giocatore (per esempio 10)
        partita.getGiocatore().setCfu(10);
    }

    /**
     * Testa il metodo agisci():
     * - Verifica che il messaggio restituito sia quello atteso.
     * - Verifica che il numero di CFU del giocatore diminuisca di 1.
     */
    @Test
    public void testAgisci() {
        int cfuIniziali = partita.getGiocatore().getCfu();
        String messaggio = cane.agisci(partita);
        assertEquals(MESSAGGIO_CANE, messaggio, "Il messaggio restituito non è corretto.");
        assertEquals(cfuIniziali - 1, partita.getGiocatore().getCfu(),
                     "I CFU del giocatore devono diminuire di 1 dopo l'azione del cane.");
    }

    /**
     * Testa il metodo riceviRegalo() passando l'attrezzo preferito ("osso"):
     * - Verifica che il messaggio restituito sia quello atteso.
     * - Verifica che nella stanza venga aggiunto l'attrezzo "collare".
     */
    @Test
    public void testRiceviRegaloCiboPreferito() {
        Attrezzo osso = new Attrezzo("osso", 1);
        String messaggio = cane.riceviRegalo(osso, partita);
        String messaggioAtteso = "Bau grazie per avermi regalato il mio cibo preferito.";
        assertEquals(messaggioAtteso, messaggio, "Il messaggio restituito per il cibo preferito non è corretto.");
        assertNotNull(partita.getStanzaCorrente().getAttrezzo("collare"),
                      "La stanza deve contenere l'attrezzo 'collare' dopo il regalo preferito.");
    }

    /**
     * Testa il metodo riceviRegalo() passando un attrezzo diverso dal cibo preferito:
     * - Verifica che il messaggio restituito sia quello atteso.
     * - Verifica che il giocatore perda 1 CFU.
     */
    @Test
    public void testRiceviRegaloAttrezzoNonPreferito() {
        int cfuIniziali = partita.getGiocatore().getCfu();
        Attrezzo pesce = new Attrezzo("pesce", 2);
        String messaggio = cane.riceviRegalo(pesce, partita);
        String messaggioAtteso = "Bau grazie per avermi regalato pesce,ma non e' il mio cibo preferit, bau!";
        assertEquals(messaggioAtteso, messaggio, "Il messaggio restituito per un attrezzo non preferito non è corretto.");
        // Verifica che il giocatore perda 1 CFU dopo aver ricevuto un regalo non preferito.
        assertEquals(cfuIniziali - 1, partita.getGiocatore().getCfu(),
                     "Il giocatore deve perdere 1 CFU se il regalo non è il cibo preferito.");
        // La stanza non deve aggiungere il "collare" in questo caso.
        assertNull(partita.getStanzaCorrente().getAttrezzo("collare"),
                   "La stanza non deve contenere l'attrezzo 'collare' se il regalo non è il cibo preferito.");
    }
}
