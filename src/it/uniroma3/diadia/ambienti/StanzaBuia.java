package it.uniroma3.diadia.ambienti;

/*questa classe deve verificare se nella stanza non è presente l'attrezzo lanterna*/
public class StanzaBuia extends Stanza{
	
	private String nomeAttrezzoCercato;
	
	//costuttore del sottotipo
	public StanzaBuia(String nome, String nomeAttrezzoCercato) {
		super(nome); //il nome lo prendo dal supertipo
		this.nomeAttrezzoCercato = nomeAttrezzoCercato;
	}

	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(nomeAttrezzoCercato)) {
			return super.getDescrizione();
		}
		else {
			return "qui c'è buoio pesto";
		}
	}	
}
