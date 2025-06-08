package it.uniroma3.test.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.AbstractPersonaggio;

public class AbstractPersonaggioTest {

    /**
     * Classe dummy per testare AbstractPersonaggio.
     * Implementa i metodi astratti agisci() e riceviRegalo() con
     * implementazioni banali per poter istanziare un oggetto.
     */
    private class DummyPersonaggio extends AbstractPersonaggio {

        public DummyPersonaggio(String nome, String presentazione) {
            super(nome, presentazione);
        }

        @Override
        public String agisci(Partita partita) {
            return "Azione dummy";
        }

        @Override
        public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
            return "Regalo dummy";
        }
    }

    private DummyPersonaggio personaggio;

    @BeforeEach
    public void setUp() {
        // Inizialmente il personaggio si chiama "Marco" e si presenta con una stringa di presentazione
        personaggio = new DummyPersonaggio("Marco", " Sono un valoroso eroe.");
    }

    /**
     * Testa il comportamento del metodo saluta() alla prima chiamata:
     * - Deve stampare il saluto con la presentazione, perché non è stato ancora salutato.
     * - Dopo il primo saluto, il flag 'haSalutato' deve risultare true.
     */
    @Test
    public void testSalutaPrimaVolta() {
        // Verifica che inizialmente il personaggio non abbia salutato
        assertFalse(personaggio.getHaSalutato(), "Il personaggio non deve aver salutato inizialmente.");
        
        String saluto = personaggio.saluta();
        String expected = "Ciao, io sono Marco." + " Sono un valoroso eroe.";
        assertEquals(expected, saluto, "Il saluto deve contenere il nome e la presentazione.");
        
        // Dopo il saluto, il flag deve essere true
        assertTrue(personaggio.getHaSalutato(), "Il personaggio deve aver salutato dopo la prima chiamata.");
    }

    /**
     * Testa il comportamento del metodo saluta() a chiamate successive:
     * - Alla seconda chiamata il personaggio deve riconoscere che si è già presentato.
     */
    @Test
    public void testSalutaSuccessiveChiamate() {
        // Prima chiamata per "spedire" il saluto iniziale
        personaggio.saluta();
        // Seconda chiamata deve ritornare il messaggio di saluto già effettuato
        String saluto = personaggio.saluta();
        String expected = "Ciao, io sono Marco." + "Ci siamo già presentati!";
        assertEquals(expected, saluto, "Alla seconda chiamata il messaggio deve indicare che ci siamo già presentati.");
    }

    /**
     * Verifica che i metodi getter e setter funzionino correttamente.
     */
    @Test
    public void testGetterSetter() {
        // Test del setter e getter per il nome
        personaggio.setNome("Luigi");
        assertEquals("Luigi", personaggio.getNome(), "Il nome deve essere aggiornato a 'Luigi'.");
        
        // Test del setter e getter per la presentazione
        personaggio.setPresentazione(" Sono un nuovo personaggio.");
        assertEquals(" Sono un nuovo personaggio.", personaggio.getPresentazione(),
                     "La presentazione deve essere aggiornata correttamente.");
        
        // Test del setter e getter per il flag haSalutato
        personaggio.setHaSalutato(false);
        assertFalse(personaggio.getHaSalutato(), "Il flag 'haSalutato' deve essere false dopo l'impostazione.");
    }

    /**
     * Verifica che il metodo toString() restituisca il nome del personaggio.
     */
    @Test
    public void testToString() {
        assertEquals(personaggio.getNome(), personaggio.toString(),
                     "Il metodo toString() deve restituire il nome del personaggio.");
    }
}
