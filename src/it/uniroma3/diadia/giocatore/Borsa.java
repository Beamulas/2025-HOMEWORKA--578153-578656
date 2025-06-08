package it.uniroma3.diadia.giocatore;


import java.util.*;

import it.uniroma3.diadia.Configurazione;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.attrezzi.ComparatoreAttrezziPerPeso;

public class Borsa{

    //costante
	public final static int DEFAULT_PESO_MAX_BORSA = Configurazione.getPesoMax(); //la costante la prendo dal file
    
    private Map<String, Attrezzo> attrezzi; // utilizzo di attrezzi una mappa invece di un array
    //la chiave della mappa è rappresentata dal nome dell'attrezzo mentre il valore è rappresentato dall'oggetto attrezzo stesso
    
    private int pesoMax;
    
    // Costruttore di default
    public Borsa() {
        this(DEFAULT_PESO_MAX_BORSA);
    }
    
    // Costruttore con peso massimo passato come parametro
    public Borsa(int pesoMax) {
        this.pesoMax = pesoMax;
        this.attrezzi = new HashMap<>();
    }
    
    /**
     * aggiunge un attrezzo alla borsa se non supera il peso massimo.
     * @param attrezzo L'attrezzo da aggiungere.
     * @return true se l'aggiunta è riuscita, false altrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.getPeso() + attrezzo.getPeso() > this.pesoMax) {
            return false; // supera il limite di peso
        }
        
        /*inserisco l'attrezzo nella mappa, ricordando che la chiave dell'attrezzo è 
          il nome dell'attrezzo stesso*/
        attrezzi.put(attrezzo.getNome(), attrezzo);	
        return true;
    }
    
    /**
     * restituisce il valore del peso 
     * @return valore peso dell'oggetto nella borsa 
     **/
    public int getPesoMax() {
        return pesoMax;
    }
    
    /**
     * recupera un attrezzo dalla borsa in base al nome.
     * @param nomeAttrezzo Il nome dell'attrezzo.
     * @return L'attrezzo corrispondente, o null se non presente.
     */
    public Attrezzo getAttrezzo(String nomeAttrezzo) {
        return attrezzi.get(nomeAttrezzo);
    }
    
    /**
     * Calcola il peso totale della borsa.
     * @return Il peso totale della borsa.
     */
    public int getPeso() {
        int peso = 0;
        for (Attrezzo attrezzo : attrezzi.values()) {
            peso = peso + attrezzo.getPeso();
        }
        return peso;
    }
    
    /**
     * controlla se la borsa è vuota.
     * @return true se la borsa è vuota, false altrimenti.
     */
    public boolean isEmpty() {
        return attrezzi.isEmpty();
    }
    
    /**
     * verifica se la borsa contiene un attrezzo dato il suo nome.
     * @param nomeAttrezzo Il nome dell'attrezzo.
     * @return true se l'attrezzo è presente, false altrimenti.
     */
    public boolean hasAttrezzo(String nomeAttrezzo) {
        return attrezzi.containsKey(nomeAttrezzo);
    }
    
    /**
     * rimuove un attrezzo dalla borsa.
     * @param nomeAttrezzo Il nome dell'attrezzo da rimuovere.
     * @return l'attrezzo rimosso, o null se non trovato.
     */
    public Attrezzo removeAttrezzo(String nomeAttrezzo) {
    	
    	//rimuovo l'attrezzo dalla mappa eliminando la sua chiave
        return attrezzi.remove(nomeAttrezzo);
    }
    
    /**
     * stampa il contenuto della borsa.
     * @return Stringa contenente gli attrezzi e il loro peso.
     */
    @Override
    public String toString() {
        StringBuilder stringa = new StringBuilder();
        
        if (!this.isEmpty()) {
        	stringa.append("Contenuto borsa (" + this.getPeso() + "kg/" + this.getPesoMax() + "kg): ");
            for (Attrezzo attrezzo : attrezzi.values()) {
            	stringa.append(attrezzo.toString()).append(" ");
            }
        } else {
        	stringa.append("Borsa vuota");
        }
        
        return stringa.toString();
    }
    
    
    /**
     * metodo che restituisce il contenuto della lista ordinato rispetto al peso 
     * degli attrezzi
     **/
    public List<Attrezzo> getContenutoOrdinatoPerPeso() {
		List<Attrezzo> attrezziPerPeso = new LinkedList<Attrezzo>(this.attrezzi.values());
		Collections.sort(attrezziPerPeso, new ComparatoreAttrezziPerPeso());
		return attrezziPerPeso;
	}
	
	/**
	 * restituisce l'insieme degli attrezzi ordinati per nome.
	 * Se due attrezzi hanno lo stesso nome, saranno considerati uguali e
	 * solo uno dei due sarà presente nel SortedSet.
	 *
	 * @return un SortedSet contenente gli attrezzi ordinati per nome.
	 */
    public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
		return new TreeSet<>(this.attrezzi.values());
	}
	
	/**
	 * restituisce una mappa che associa un intero (il peso)
	 * con un Set di attrezzi aventi quel peso.
	 *
	 * @return una Map<Integer, Set<Attrezzo>> in cui ogni chiave è un peso
	 *         e il valore è l'insieme degli attrezzi con quel peso.
	 */
    public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
		SortedSet<Attrezzo> attrezziPerPeso = new TreeSet<>(new ComparatoreAttrezziPerPeso());
		attrezziPerPeso.addAll(this.attrezzi.values());
		return attrezziPerPeso;
	}
    
    public Map<Integer,Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
		Map<Integer,Set<Attrezzo>> attrezzi = new HashMap<>();
		for(Attrezzo attrezzo : this.attrezzi.values()) {
			Set<Attrezzo> attrezziPeso = attrezzi.get(attrezzo.getPeso());
			if(attrezziPeso == null) {
				attrezziPeso = new HashSet<>();
				attrezzi.put(attrezzo.getPeso(), attrezziPeso);
			}
			attrezziPeso.add(attrezzo);
		}
		return attrezzi;
	}
    
    /**
     * metodo che mi permette di capire quanto spazio in peso mi rimane nella borsa
     * @param attrezzo che vorrei aggiungere
     * */
    public boolean getPesoRimanente(Attrezzo attrezzo) {
		if(attrezzo != null && this.getPesoMax()-this.getPeso() >= attrezzo.getPeso())
			return true;
		return false; 
	}
}
