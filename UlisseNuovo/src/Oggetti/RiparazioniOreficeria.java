package Oggetti;

public class RiparazioniOreficeria {
	private String codice;
	private String descrizione;
	private double prezzo;
	
	public RiparazioniOreficeria() {}
	
	public RiparazioniOreficeria(String codice, String descrizione, double prezzo) {
		super();
		this.codice = codice;
		this.descrizione = descrizione;
		this.prezzo = prezzo;
	}
	public String getCodice() {
		return codice;
	}
	public void setCodice(String codice) {
		this.codice = codice;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public double getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}
	@Override
	public String toString() {
		return "RiparazioniOreficeria [codice=" + codice + ", descrizione=" + descrizione + ", prezzo=" + prezzo + "]";
	}
	
	
}
