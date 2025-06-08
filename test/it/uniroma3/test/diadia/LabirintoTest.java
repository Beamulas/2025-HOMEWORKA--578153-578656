package it.uniroma3.test.diadia;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {

    private Labirinto labirinto;
    private Stanza stanzaIniziale;
    private Stanza stanzaVincente;

    /**
     * Per i test abbiamo bisogno di impostare un Labirinto in condizioni note.
     * In questo esempio assumiamo che il file "dummy.txt" esista (o che il
     * CaricatoreLabirinto lo tratti in maniera da non dare eccezioni durante i test).
     * In alternativa, potresti usare un framework di mocking per simulare il comportamento
     * del CaricatoreLabirinto.
     */
    @BeforeEach
    public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
        // Per il test, usiamo un file dummy; se necessario, assicurati che il file di test
        // esista oppure adatta il comportamento con un mock.
        labirinto = new Labirinto("labirinto5.txt");

        // Creiamo due stanze di test
        stanzaIniziale = new Stanza("Iniziale");
        stanzaVincente = new Stanza("Vincente");

        // Impostiamo manualmente le stanze nel labirinto
        labirinto.setStanzaCorrente(stanzaIniziale);
        labirinto.setStanzaVincente(stanzaVincente);
    }

    /**
     * Testa che il metodo getStanzaCorrente restituisca la stanza inizialmente impostata.
     */
    @Test
    public void testGetStanzaCorrente() {
        assertEquals(stanzaIniziale, labirinto.getStanzaCorrente(), 
            "La stanza corrente deve essere quella impostata in setUp");
    }

    /**
     * Testa che il metodo getStanzaVincente restituisca la stanza vincente impostata.
     */
    @Test
    public void testGetStanzaVincente() {
        assertEquals(stanzaVincente, labirinto.getStanzaVincente(), 
            "La stanza vincente deve essere quella impostata in setUp");
    }

    /**
     * Verifica che il metodo setStanzaCorrente modifichi correttamente la stanza corrente.
     */
    @Test
    public void testSetStanzaCorrente() {
        Stanza nuovaStanza = new Stanza("Nuova");
        labirinto.setStanzaCorrente(nuovaStanza);
        assertEquals(nuovaStanza, labirinto.getStanzaCorrente(), 
            "Dopo setStanzaCorrente la stanza corrente deve essere quella impostata");
    }

    /**
     * Verifica che il metodo setStanzaVincente modifichi correttamente la stanza vincente.
     */
    @Test
    public void testSetStanzaVincente() {
        Stanza nuovaStanzaVincente = new Stanza("Nuova Vincente");
        labirinto.setStanzaVincente(nuovaStanzaVincente);
        assertEquals(nuovaStanzaVincente, labirinto.getStanzaVincente(), 
            "Dopo setStanzaVincente la stanza vincente deve essere quella impostata");
    }
}
