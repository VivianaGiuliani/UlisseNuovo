package Oggetti;

public class StampaDistintaDatiTabella {
	private int quantita;
	private String barcode;
	private String descrizione;
	private double peso;
	private double caratura;
	private double totale_riga;
	private int sc_1;
	private int sc_2;
	private double scontato;
	public StampaDistintaDatiTabella(int quantita, String barcode, String descrizione, double peso, double caratura,
			double totale_riga, int sc_1, int sc_2, double scontato) {
		super();
		this.quantita = quantita;
		this.barcode = barcode;
		this.descrizione = descrizione;
		this.peso = peso;
		this.caratura = caratura;
		this.totale_riga = totale_riga;
		this.sc_1 = sc_1;
		this.sc_2 = sc_2;
		this.scontato = scontato;
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
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getCaratura() {
		return caratura;
	}
	public void setCaratura(double caratura) {
		this.caratura = caratura;
	}
	public double getTotale_riga() {
		return totale_riga;
	}
	public void setTotale_riga(double totale_riga) {
		this.totale_riga = totale_riga;
	}
	public int getSc_1() {
		return sc_1;
	}
	public void setSc_1(int sc_1) {
		this.sc_1 = sc_1;
	}
	public int getSc_2() {
		return sc_2;
	}
	public void setSc_2(int sc_2) {
		this.sc_2 = sc_2;
	}
	public double getScontato() {
		return scontato;
	}
	public void setScontato(double scontato) {
		this.scontato = scontato;
	}
	@Override
	public String toString() {
		return "StampaDistintaDatiTabella [quantita=" + quantita + ", barcode=" + barcode + ", descrizione="
				+ descrizione + ", peso=" + peso + ", caratura=" + caratura + ", totale_riga=" + totale_riga + ", sc_1="
				+ sc_1 + ", sc_2=" + sc_2 + ", scontato=" + scontato + "]";
	}
	
	
}
