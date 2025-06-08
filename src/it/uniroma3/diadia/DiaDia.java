package it.uniroma3.diadia;


import java.util.Scanner;

import it.uniroma3.diadia.ambienti.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandiRiflessiva;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */
public class DiaDia {
	
	//messaggio iniziale che mi spiega il gioco
	public static final String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";

	//costante
	static final private String[] elencoComandi = {"vai", "aiuto", "fine"};

	private Partita partita;
	private IO io;
	
	//costruttore
	public DiaDia(IO io, Labirinto labirinto) {
		this.io = io;
		this.partita = new Partita(labirinto);
	}

	public void gioca() throws Exception {
		String istruzione; 
		Scanner scannerDiLinee;	//per leggere da tastiera

		System.out.println(MESSAGGIO_BENVENUTO);	//appena inizia il gioco stampo il messaggio iniziale
		scannerDiLinee = new Scanner(System.in);		
		do
			istruzione = scannerDiLinee.nextLine();
		while (!processaIstruzione(istruzione));

		scannerDiLinee.close();
	}   


	
	/**
	 * Processa una istruzione 
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 * @throws Exception 
	 */
	private boolean processaIstruzione(String istruzione) throws Exception {
		Comando comandoDaEseguire;
		FabbricaDiComandiRiflessiva factory = new FabbricaDiComandiRiflessiva(this.io);
		try {
			comandoDaEseguire = factory.costruisciComando(istruzione);
		} catch (ClassNotFoundException cne) {
			comandoDaEseguire = factory.costruisciComando("NonValido");
		} catch (NullPointerException npe) {
			comandoDaEseguire = factory.costruisciComando("NonValido");
		}
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())
			io.mostraMessaggio("Congratulazione hai VINTO!");
		if (!this.partita.giocatoreIsVivo())
			io.mostraMessaggio("Hai esaurito i CFU...");
		return this.partita.isFinita();
	}

		/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			System.out.print(elencoComandi[i]+" ");
		System.out.println();
	}

	private void posa(String nomeAttrezzo) {
		if (nomeAttrezzo == null)
			io.mostraMessaggio("Quale attrezzo vuoi posare?");
		else {
			Attrezzo attrezzo = this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
			if (attrezzo == null)
				io.mostraMessaggio("ERRORE: L'attrezzo che hai inserito non esiste nella borsa!");
			else {
				this.partita.getGiocatore().posareAttrezzo(nomeAttrezzo);
				this.partita.getStanzaCorrente().addAttrezzo(attrezzo);
				io.mostraMessaggio("Hai posato: " + nomeAttrezzo);
			}
		}
	}

	
	public static void main(String[] argc) throws Exception {
		
		Scanner scannerDiLinee = new Scanner(System.in);
		IO ioConsole = new IOConsole(scannerDiLinee);
		
		Labirinto labirinto = Labirinto.newBuilder("labirinto4.txt").getLabirinto();
		DiaDia gioco = new DiaDia(ioConsole, labirinto);
		
		gioco.gioca();

		// Lo scanner viene chiuso automaticamente dal try-with-resources senza chiudere System.in prima del tempo.
	}
}