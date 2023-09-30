package Oggetti;

public class Fornitore {
	private String codiceFornitore;
	private String nomeFornitore;
	
	public Fornitore() {}
	
	public Fornitore(String codiceFornitore, String nomeFornitore) {
		super();
		this.codiceFornitore = codiceFornitore;
		this.nomeFornitore = nomeFornitore;
	}

	public String getCodiceFornitore() {
		return codiceFornitore;
	}

	public void setCodiceFornitore(String codiceFornitore) {
		this.codiceFornitore = codiceFornitore;
	}

	public String getNomeFornitore() {
		return nomeFornitore;
	}

	public void setNomeFornitore(String nomeFornitore) {
		this.nomeFornitore = nomeFornitore;
	}

	@Override
	public String toString() {
		return "Fornitore [codiceFornitore=" + codiceFornitore + ", nomeFornitore=" + nomeFornitore + "]";
	}
	
	
}
