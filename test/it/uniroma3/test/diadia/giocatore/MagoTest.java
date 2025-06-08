package it.uniroma3.test.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Mago;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class MagoTest {

    private Mago mago;
    private Partita partita;
    private Stanza stanzaTest;

    // Messaggi attesi, così come definiti nella classe
    private static final String MESSAGGIO_DONO = "Sei un vero simpaticone , con una mia magica azione, trovera un oggetto nuovo per il tuo borsone!";
    private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho più nulla......";

    @BeforeEach
    public void setUp() throws Exception {
        // Creiamo una partita con un Labirinto dummy: l'uso di "dummy.txt" evita dipendenze dal file reale
        Labirinto labirinto = new Labirinto("labirinto5.txt");
        partita = new Partita(labirinto);
        stanzaTest = new Stanza("StanzaTest");
        partita.getLabirinto().setStanzaCorrente(stanzaTest);
        
        // Creiamo un Mago che possiede inizialmente un attrezzo (ad esempio, "bacchetta" con peso 4)
        Attrezzo bacchetta = new Attrezzo("bacchetta", 4);
        mago = new Mago("Merlino", "un mago molto saggio", bacchetta);
    }

    /**
     * Testa il metodo agisci() nel caso in cui il mago possegga l'attrezzo.
     * Verifica che:
     * - il messaggio restituito corrisponda a quello di dono;
     * - l'attrezzo venga aggiunto alla stanza corrente;
     * - dopo la donazione, il mago perda il riferimento all'attrezzo (quindi, una ulteriore azione produce il messaggio di scuse).
     */
    @Test
    public void testAgisciConAttrezzo() {
        String messaggio = mago.agisci(partita);
        assertEquals(MESSAGGIO_DONO, messaggio, "Il messaggio restituito non corrisponde a quello di dono.");
        
        // L'attrezzo donato ("bacchetta") deve essere presente nella stanza corrente
        Attrezzo attrezzoInStanza = partita.getStanzaCorrente().getAttrezzo("bacchetta");
        assertNotNull(attrezzoInStanza, "La stanza deve contenere l'attrezzo donato dal mago.");
        assertEquals(4, attrezzoInStanza.getPeso(), "Il peso dell'attrezzo donato non corrisponde al valore iniziale.");
        
        // Una seconda invocazione di agisci() restituisce il messaggio di scuse in quanto il mago ha già donato il suo attrezzo
        String messaggioSecondo = mago.agisci(partita);
        assertEquals(MESSAGGIO_SCUSE, messaggioSecondo, "Dopo la donazione, il mago non dovrebbe avere più l'attrezzo.");
    }

    /**
     * Testa il metodo riceviRegalo(Attrezzo, Partita):
     * - Verifica il messaggio restituito;
     * - Verifica che nella stanza venga aggiunto l'attrezzo modificato (peso dimezzato).
     */
    @Test
    public void testRiceviRegalo() {
        // Creiamo un attrezzo da regalare
        Attrezzo libro = new Attrezzo("libro", 6);
        String messaggio = mago.riceviRegalo(libro, partita);
        String messaggioAtteso = "Grazie per avermi regalato libro. Lo modificherò e lo lascerò!";
        assertEquals(messaggioAtteso, messaggio, "Il messaggio del regalo non è corretto.");
        
        // L'attrezzo modificato (con peso dimezzato: 6/2 = 3) deve essere presente nella stanza corrente
        Attrezzo attrezzoModificato = partita.getStanzaCorrente().getAttrezzo("libro");
        assertNotNull(attrezzoModificato, "La stanza deve contenere l'attrezzo modificato.");
        assertEquals(3, attrezzoModificato.getPeso(), "Il peso dell'attrezzo modificato non corrisponde al valore atteso (dimezzato).");
    }
}
