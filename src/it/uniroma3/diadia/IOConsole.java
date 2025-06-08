package it.uniroma3.diadia;

import java.util.Scanner;

/*classe che estende l'interfaccia IO e che viene usata al posto di System.out.println per visualizzare le informazioni*/
public class IOConsole implements IO {
	
	// Lo scanner viene ricevuto dal costruttore.
    private final Scanner scanner;

    //costruttore, viene passata la stringa digitata dall'utente
    public IOConsole(Scanner scanner) {
        this.scanner = scanner;
    }
    
    //costruttore generico
    public IOConsole() {
		this.scanner = new Scanner(System.in);
	}

    @Override
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
  
    /**
     * Utilizza lo scanner passato dal main.
     * Non viene usato try-with-resources qui per evitare la chiusura di System.in.
     */
    @Override
    public String leggiRiga() {
        return scanner.nextLine();
    }
}
