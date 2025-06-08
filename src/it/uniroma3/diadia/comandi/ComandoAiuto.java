package it.uniroma3.diadia.comandi;

import java.util.*;

import it.uniroma3.diadia.Partita;


/*prima questa classe implementava la classe Comando. Ora invece che usare un'interfaccia estende la classe AbstractComando che è una classe di tipo astratto. 
 *Così facendo non c'è più bisogno di utilizzare implementazioni vuote come quelle del metodo setParametro(). Ricordo che nelle classi astratte può essere inserito 
 *solo l'invocazione del metodo tralasciando il suo corpo che poi verrà implementato nelle classi concrete*/
public class ComandoAiuto extends AbstractComando {
	
	static final private String[] ELENCO_COMANDI = {"vai", "aiuto", "fine", "prendi", "posa", "guarda",
			"interagisci", "saluta", "regala"};
	private final static String NOME = "aiuto";

	@Override
	public void esegui(Partita partita) {
		try {
			List<String> comandiDisponibili = Arrays.asList(ELENCO_COMANDI);
			System.out.println("I comandi disponibili nel gioco sono :");
			for(String comando : comandiDisponibili) {
				System.out.println(" --> " + comando);
			}
		}catch(Exception e){
			System.out.println("Non riesco a prendere i comandi");
		}
	}


	@Override
	public String getNome() {
		return NOME;
	}

}
