package Oggetti;

public class Ordine {
	private int n_ordine;
	private String codice_fornitore;
	private String data;
	private int quantita;
	private String barcode;
	private String descrizione;
	private double gcad;
	private double tot_peso;
	private int pr_unit;
	private int tot_riga;
	public Ordine() {}
	public Ordine(int n_ordine, String codice_fornitore, String data, int quantita, String barcode, String descrizione,
			double gcad, double tot_peso, int pr_unit, int tot_riga) {
		super();
		this.n_ordine = n_ordine;
		this.codice_fornitore = codice_fornitore;
		this.data = data;
		this.quantita = quantita;
		this.barcode = barcode;
		this.descrizione = descrizione;
		this.gcad = gcad;
		this.tot_peso = tot_peso;
		this.pr_unit = pr_unit;
		this.tot_riga = tot_riga;
	}

	public int getN_ordine() {
		return n_ordine;
	}

	public void setN_ordine(int n_ordine) {
		this.n_ordine = n_ordine;
	}

	public String getCodice_fornitore() {
		return codice_fornitore;
	}

	public void setCodice_fornitore(String codice_fornitore) {
		this.codice_fornitore = codice_fornitore;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getGcad() {
		return gcad;
	}

	public void setGcad(double gcad) {
		this.gcad = gcad;
	}

	public double getTot_peso() {
		return tot_peso;
	}

	public void setTot_peso(double tot_peso) {
		this.tot_peso = tot_peso;
	}

	public int getPr_unit() {
		return pr_unit;
	}

	public void setPr_unit(int pr_unit) {
		this.pr_unit = pr_unit;
	}

	public int getTot_riga() {
		return tot_riga;
	}

	public void setTot_riga(int tot_riga) {
		this.tot_riga = tot_riga;
	}

	@Override
	public String toString() {
		return "Ordine [n_ordine=" + n_ordine + ", codice_fornitore=" + codice_fornitore + ", data=" + data
				+ ", quantita=" + quantita + ", barcode=" + barcode + ", descrizione=" + descrizione + ", gcad=" + gcad
				+ ", tot_peso=" + tot_peso + ", pr_unit=" + pr_unit + ", tot_riga=" + tot_riga + "]";
	}
	
	
}
