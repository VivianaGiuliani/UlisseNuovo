package Oggetti;

public class Etichetta {
	private String barcode;
	private String descrizione;
	private double peso;
	private double caratura;
	private double prezzo;
	
	public Etichetta() {}
	
	public Etichetta(String barcode, String descrizione, double peso, double caratura, double prezzo) {
		super();
		this.barcode = barcode;
		this.descrizione = descrizione;
		this.peso = peso;
		this.caratura = caratura;
		this.prezzo = prezzo;
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

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "Etichetta [barcode=" + barcode + ", descrizione=" + descrizione + ", peso=" + peso + ", caratura="
				+ caratura + ", prezzo=" + prezzo + "]";
	}
	
	
}
