package it.uniroma3.test.diadia;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Importa le classi necessarie dall'ambiente di gioco
import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;


public class PartitaTest {

    private Partita partita;
    private Labirinto labirinto;

    /**
     * Impostiamo lo scenario di test con una versione "fake" del Labirinto.
     * @throws FormatoFileNonValidoException 
     * @throws FileNotFoundException 
     */
    @BeforeEach
    public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
        labirinto = new Labirinto("labirinto5.txt");
        partita = new Partita(labirinto);
    }

    /**
     * Testa il metodo giocatoreIsVivo() verificando che restituisca true se il CFU
     * del giocatore è maggiore di 0 e false altrimenti.
     */
    @Test
    public void testGiocatoreIsVivo() {
        // Inizialmente, supponendo che il giocatore abbia CFU > 0
        assertTrue(partita.giocatoreIsVivo(), "Il giocatore dovrebbe risultare vivo all'inizio della partita");

        // Supponiamo di poter modificare i CFU (ad es. tramite il metodo setCfu)
        partita.getGiocatore().setCfu(0);
        assertFalse(partita.giocatoreIsVivo(), "Il giocatore non dovrebbe essere vivo se i CFU sono 0");
    }

    /**
     * Testa il metodo vinta(), che restituisce true se la stanza corrente coincide con la stanza vincente.
     */
    @Test
    public void testVinta() {
        // Inizialmente non si è nella stanza vincente
        assertFalse(partita.vinta(), "La partita non è vinta se la stanza corrente non è la stanza vincente");

        // Impostiamo la stanza corrente come vincente
        labirinto.setStanzaCorrente(labirinto.getStanzaVincente());
        assertTrue(partita.vinta(), "La partita è vinta se la stanza corrente è la stanza vincente");
    }

    /**
     * Testa il metodo isFinita() secondo le condizioni:
     * - se la partita è stata impostata come finita manualmente;
     * - se la partita è vinta;
     * - se il giocatore ha 0 CFU.
     * @throws FormatoFileNonValidoException 
     * @throws FileNotFoundException 
     */
    @Test
    public void testIsFinita() throws FileNotFoundException, FormatoFileNonValidoException {
        // Condizione iniziale: finita flag = false, partita non vinta, giocatore con CFU > 0
        assertFalse(partita.isFinita(), "La partita non dovrebbe risultare finita all'inizio");

        // Caso 1: Imposto manualmente il flag di fine partita
        partita.setFinita();
        assertTrue(partita.isFinita(), "La partita dovrebbe risultare finita se il flag 'finita' è settato");

        // Reset: nuova partita con labirinto e giocatore ripristinati
        setUp();
        // Caso 2: Partita vinta (stanza corrente = stanza vincente)
        labirinto.setStanzaCorrente(labirinto.getStanzaVincente());
        assertTrue(partita.isFinita(), "La partita dovrebbe risultare finita se la partita è vinta");

        // Reset: nuova partita
        setUp();
        // Caso 3: Giocatore con 0 CFU
        partita.getGiocatore().setCfu(0);
        assertTrue(partita.isFinita(), "La partita dovrebbe risultare finita se il giocatore ha 0 CFU");
    }

  
}
