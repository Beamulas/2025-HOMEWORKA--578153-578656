package it.uniroma3.diadia;

/*classe che permette di creare un exception personalizzata*/
public class FormatoFileNonValidoException extends Exception {

	private static final long serialVersionUID = 1L;
	public FormatoFileNonValidoException(String msg) {
		super(msg);
	}
	
	
}
