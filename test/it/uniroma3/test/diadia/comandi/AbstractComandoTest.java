package it.uniroma3.test.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.AbstractComando;

class AbstractComandoTest {

    /**
     * Classe dummy per testare AbstractComando.
     * Implementa semplicemente getNome() e esegui() per poter essere istanziata.
     */
    private class DummyComando extends AbstractComando {
        @Override
        public void esegui(Partita partita) {
            // Implementazione vuota per il test
        }

        @Override
        public String getNome() {
            return "dummy";
        }
    }

    /**
     * Verifica che inizialmente il parametro sia null e 
     * che dopo averlo impostato venga correttamente restituito.
     */
    @Test
    public void testSetAndGetParametro() {
        DummyComando dummy = new DummyComando();
        // Inizialmente il parametro dovrebbe essere null
        assertNull(dummy.getParametro(), "Il parametro deve essere inizialmente null");

        // Impostiamo il parametro e verifichiamo che venga restituito correttamente
        String parametroTest = "testParam";
        dummy.setParametro(parametroTest);
        assertEquals(parametroTest, dummy.getParametro(), "Il parametro restituito deve corrispondere a quello impostato");
    }

    /**
     * Verifica che il metodo getNome restituisca il valore definito nell'implementazione.
     */
    @Test
    public void testGetNome() {
        DummyComando dummy = new DummyComando();
        assertEquals("dummy", dummy.getNome(), "Il nome del comando deve essere 'dummy'");
    }

    /**
     * Verifica che il metodo esegui() non lanci eccezioni.
     * Poiché l'implementazione dummy di esegui() non fa nulla, basta che non sollevi eccezioni.
     */
    @Test
    public void testEseguiNonLanciaEccezioni() {
        DummyComando dummy = new DummyComando();
        try {
            dummy.esegui(null); // Passiamo null per semplificare il test
        } catch (Exception e) {
            fail("Il metodo esegui() non dovrebbe lanciare eccezioni, ma ha lanciato: " + e.getMessage());
        }
    }
}
