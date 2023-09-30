package Oggetti;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Cliente {
	private String titolo;
	private String nome;
	private String indirizzo;
	private String cap;
	private String citta;
	private String provincia;
	private String telefono;
	private String email;
	private String note;
	private String codiceBarre;
	private int punti;
	private Date ultimo_acquisto;
	private String possesso_email;
	
	public Cliente() {}

	public Cliente(String titolo, String nome, String indirizzo, String cap, String citta, String provincia,
			String telefono, String email, String note, String codiceBarre, int punti,
			Date dataUltimoAcquisto, String possesso_email) {
		super();
		this.titolo = titolo;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.cap = cap;
		this.citta = citta;
		this.provincia = provincia;
		this.telefono = telefono;
		this.email = email;
		this.note = note;
		this.codiceBarre = codiceBarre;
		this.punti = punti;
		this.ultimo_acquisto = dataUltimoAcquisto;
		this.possesso_email = possesso_email;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getCodiceBarre() {
		return codiceBarre;
	}

	public void setCodiceBarre(String codiceBarre) {
		this.codiceBarre = codiceBarre;
	}

	public int getPunti() {
		return punti;
	}

	public void setPunti(int punti) {
		this.punti = punti;
	}

	public Date getUltimo_acquisto() {
		return ultimo_acquisto;
	}

	public void setUltimo_acquisto(Date ultimo_acquisto) {
		this.ultimo_acquisto = ultimo_acquisto;
	}


	public String getPossesso_email() {
		return possesso_email;
	}

	public void setPossesso_email(String possesso_email) {
		this.possesso_email = possesso_email;
	}

	@Override
	public String toString() {
		return "Cliente [titolo=" + titolo + ", nome=" + nome + ", indirizzo=" + indirizzo + ", cap=" + cap + ", citta="
				+ citta + ", provincia=" + provincia + ", telefono=" + telefono + ", email=" + email + ", note=" + note
				+ ", codiceBarre=" + codiceBarre +  ", punti=" + punti
				+ ", ultimo_acquisto=" + ultimo_acquisto + ", possesso_email=" + possesso_email + "]";
	}
	
	
	
	
}
