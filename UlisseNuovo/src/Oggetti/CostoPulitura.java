package Oggetti;

public class CostoPulitura {
	private String codice;
	private String descrizione;
	private double pulitura;
	private double trattamento;
	
	public CostoPulitura() {}

	public CostoPulitura(String codice, String descrizione, double pulitura, double trattamento) {
		super();
		this.codice = codice;
		this.descrizione = descrizione;
		this.pulitura = pulitura;
		this.trattamento = trattamento;
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

	public double getPulitura() {
		return pulitura;
	}

	public void setPulitura(double pulitura) {
		this.pulitura = pulitura;
	}

	public double getTrattamento() {
		return trattamento;
	}

	public void setTrattamento(double trattamento) {
		this.trattamento = trattamento;
	}

	@Override
	public String toString() {
		return "CostoPulitura [codice=" + codice + ", descrizione=" + descrizione + ", pulitura=" + pulitura
				+ ", trattamento=" + trattamento + "]";
	}
	
	
}
