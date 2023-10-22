package Oggetti;

public class Oralux {
	private String barcode;
	private String cod_art;
	private String nome;
	private double vendita;
	private int quantita;
	
	public Oralux() {}
	
	public Oralux(String barcode, String cod_art, String nome, double vendita, int quantita) {
		super();
		this.barcode = barcode;
		this.cod_art = cod_art;
		this.nome = nome;
		this.vendita = vendita;
		this.quantita = quantita;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getCod_art() {
		return cod_art;
	}

	public void setCod_art(String cod_art) {
		this.cod_art = cod_art;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getVendita() {
		return vendita;
	}

	public void setVendita(double vendita) {
		this.vendita = vendita;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	@Override
	public String toString() {
		return "Oralux [barcode=" + barcode + ", cod_art=" + cod_art + ", nome=" + nome + ", vendita=" + vendita
				+ ", quantita=" + quantita + "]";
	}
	
	
}
