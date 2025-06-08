package it.uniroma3.diadia;

import java.io.IOException;
import java.util.Properties;

/*classe che mi serve per esternalizzare alcune costanti e metterle all'interno di un file*/
public class Configurazione {

	private static final String DIADIA_PROPERTIES = "diadia.properties"; //nome del file
	private static final String PESO_MAX = "pesoMax";
	private static final String CFU = "cfu";
	private static Properties prop = null;
	
	//metodo per prendere i cfu
	public static int getCFU() {
		if(prop == null)
			carica();
		return Integer.parseInt(prop.getProperty(CFU));
	}
	
	//metodo per prendere il peso massimo
	public static int getPesoMax() {
		if(prop == null)
			carica();
		return Integer.parseInt(prop.getProperty(PESO_MAX));
	}

	private static void carica() {
		prop = new Properties();
		try {
			prop.load(Configurazione.class.getClassLoader().getResourceAsStream(DIADIA_PROPERTIES));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
