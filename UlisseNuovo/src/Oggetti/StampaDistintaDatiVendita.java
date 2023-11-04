package Oggetti;

public class StampaDistintaDatiVendita {
	private int numero_vendita;
	private int quantita;
	private String barcode;
	private String descrizione;
	private double peso;
	private double caratura;
	private double totale_riga;
	private int sc_1;
	private int sc_2;
	private double scontato;
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
	private double acconto;
	
	public StampaDistintaDatiVendita() {}

	public StampaDistintaDatiVendita(int numero_vendita, int quantita, String barcode, String descrizione, double peso,
			double caratura, double totale_riga, int sc_1, int sc_2, double scontato, double totale_merce,
			double sconto, double merce_scontata, double valore_buono, double totale_scontato, int punti_precedenti,
			int punti_guadagnati, int punti_totali, int punti_usati, int punti_disponibili, String da_titolo_cliente,
			String titolo_cliente, String nome_cliente, String codice_carta_cliente, String email_cliente,
			double acconto) {
		super();
		this.numero_vendita = numero_vendita;
		this.quantita = quantita;
		this.barcode = barcode;
		this.descrizione = descrizione;
		this.peso = peso;
		this.caratura = caratura;
		this.totale_riga = totale_riga;
		this.sc_1 = sc_1;
		this.sc_2 = sc_2;
		this.scontato = scontato;
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
		this.acconto = acconto;
	}

	public int getNumero_vendita() {
		return numero_vendita;
	}

	public void setNumero_vendita(int numero_vendita) {
		this.numero_vendita = numero_vendita;
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

	public double getAcconto() {
		return acconto;
	}

	public void setAcconto(double acconto) {
		this.acconto = acconto;
	}

	@Override
	public String toString() {
		return "StampaDistintaDatiVendita [numero_vendita=" + numero_vendita + ", quantita=" + quantita + ", barcode="
				+ barcode + ", descrizione=" + descrizione + ", peso=" + peso + ", caratura=" + caratura
				+ ", totale_riga=" + totale_riga + ", sc_1=" + sc_1 + ", sc_2=" + sc_2 + ", scontato=" + scontato
				+ ", totale_merce=" + totale_merce + ", sconto=" + sconto + ", merce_scontata=" + merce_scontata
				+ ", valore_buono=" + valore_buono + ", totale_scontato=" + totale_scontato + ", punti_precedenti="
				+ punti_precedenti + ", punti_guadagnati=" + punti_guadagnati + ", punti_totali=" + punti_totali
				+ ", punti_usati=" + punti_usati + ", punti_disponibili=" + punti_disponibili + ", da_titolo_cliente="
				+ da_titolo_cliente + ", titolo_cliente=" + titolo_cliente + ", nome_cliente=" + nome_cliente
				+ ", codice_carta_cliente=" + codice_carta_cliente + ", email_cliente=" + email_cliente + ", acconto="
				+ acconto + "]";
	}

	

}