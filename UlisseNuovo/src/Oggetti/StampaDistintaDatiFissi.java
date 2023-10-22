package Oggetti;

public class StampaDistintaDatiFissi {
	private double totale_merce;
	private double sconto;
	private double merce_scontata;
	private double valore_buono;
	private double totale_scontato;
	private int punti_precedenti;
	private int punti_guadagnati;
	private int punti_totali;
	private int punti_usati;
	private int punti_disponibili;
	private String da_titolo_cliente;
	private String titolo_cliente;
	private String nome_cliente;
	private String codice_carta_cliente;
	private String email_cliente;
	
	public StampaDistintaDatiFissi() {}

	public StampaDistintaDatiFissi(double totale_merce, double sconto, double merce_scontata, double valore_buono,
			double totale_scontato, int punti_precedenti, int punti_guadagnati, int punti_totali, int punti_usati,
			int punti_disponibili, String da_titolo_cliente, String titolo_cliente, String nome_cliente,
			String codice_carta_cliente, String email_cliente) {
		super();
		this.totale_merce = totale_merce;
		this.sconto = sconto;
		this.merce_scontata = merce_scontata;
		this.valore_buono = valore_buono;
		this.totale_scontato = totale_scontato;
		this.punti_precedenti = punti_precedenti;
		this.punti_guadagnati = punti_guadagnati;
		this.punti_totali = punti_totali;
		this.punti_usati = punti_usati;
		this.punti_disponibili = punti_disponibili;
		this.da_titolo_cliente = da_titolo_cliente;
		this.titolo_cliente = titolo_cliente;
		this.nome_cliente = nome_cliente;
		this.codice_carta_cliente = codice_carta_cliente;
		this.email_cliente = email_cliente;
	}

	public double getTotale_merce() {
		return totale_merce;
	}

	public void setTotale_merce(double totale_merce) {
		this.totale_merce = totale_merce;
	}

	public double getSconto() {
		return sconto;
	}

	public void setSconto(double sconto) {
		this.sconto = sconto;
	}

	public double getMerce_scontata() {
		return merce_scontata;
	}

	public void setMerce_scontata(double merce_scontata) {
		this.merce_scontata = merce_scontata;
	}

	public double getValore_buono() {
		return valore_buono;
	}

	public void setValore_buono(double valore_buono) {
		this.valore_buono = valore_buono;
	}

	public double getTotale_scontato() {
		return totale_scontato;
	}

	public void setTotale_scontato(double totale_scontato) {
		this.totale_scontato = totale_scontato;
	}

	public int getPunti_precedenti() {
		return punti_precedenti;
	}

	public void setPunti_precedenti(int punti_precedenti) {
		this.punti_precedenti = punti_precedenti;
	}

	public int getPunti_guadagnati() {
		return punti_guadagnati;
	}

	public void setPunti_guadagnati(int punti_guadagnati) {
		this.punti_guadagnati = punti_guadagnati;
	}

	public int getPunti_totali() {
		return punti_totali;
	}

	public void setPunti_totali(int punti_totali) {
		this.punti_totali = punti_totali;
	}

	public int getPunti_usati() {
		return punti_usati;
	}

	public void setPunti_usati(int punti_usati) {
		this.punti_usati = punti_usati;
	}

	public int getPunti_disponibili() {
		return punti_disponibili;
	}

	public void setPunti_disponibili(int punti_disponibili) {
		this.punti_disponibili = punti_disponibili;
	}

	public String getDa_titolo_cliente() {
		return da_titolo_cliente;
	}

	public void setDa_titolo_cliente(String da_titolo_cliente) {
		this.da_titolo_cliente = da_titolo_cliente;
	}

	public String getTitolo_cliente() {
		return titolo_cliente;
	}

	public void setTitolo_cliente(String titolo_cliente) {
		this.titolo_cliente = titolo_cliente;
	}

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_cliente) {
		this.nome_cliente = nome_cliente;
	}

	public String getCodice_carta_cliente() {
		return codice_carta_cliente;
	}

	public void setCodice_carta_cliente(String codice_carta_cliente) {
		this.codice_carta_cliente = codice_carta_cliente;
	}

	public String getEmail_cliente() {
		return email_cliente;
	}

	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}

	@Override
	public String toString() {
		return "StampaDistintaDatiFissi [totale_merce=" + totale_merce + ", sconto=" + sconto + ", merce_scontata="
				+ merce_scontata + ", valore_buono=" + valore_buono + ", totale_scontato=" + totale_scontato
				+ ", punti_precedenti=" + punti_precedenti + ", punti_guadagnati=" + punti_guadagnati
				+ ", punti_totali=" + punti_totali + ", punti_usati=" + punti_usati + ", punti_disponibili="
				+ punti_disponibili + ", da_titolo_cliente=" + da_titolo_cliente + ", titolo_cliente=" + titolo_cliente
				+ ", nome_cliente=" + nome_cliente + ", codice_cliente=" + codice_carta_cliente + ", email_cliente="
				+ email_cliente + "]";
	}
	
	
	
}
