package Oggetti;

public class AnagraficaAzienda {
	private String cf;
	private int codice;
	private String nome;
	private String indirizzo;
	private String cap;
	private String citta;
	private String provincia;
	private String nome_dest;
	private String ind_dest;
	private String cap_dest;
	private String cit_dest;
	private String prov_dest;
	private String p_iva;
	private String cod_fisc;
	private String pagamento;
	private String pag_immediato;
	private String scad_gg;
	private String scad_mesi;
	private String n_rate;
	private String banca;
	private String cab;
	private String abi;
	private String telefono;
	private String email;
	private String nome_stampa;
	private String note_1;
	private String note_2;
	private String note_3;
	
	public AnagraficaAzienda() {}

	public AnagraficaAzienda(String cf, int codice, String nome, String indirizzo, String cap, String citta,
			String provincia, String nome_dest, String ind_dest, String cap_dest, String cit_dest, String prov_dest,
			String p_iva, String cod_fisc, String pagamento, String pag_immediato, String scad_gg, String scad_mesi,
			String n_rate, String banca, String cab, String abi, String telefono, String email, String nome_stampa,
			String note_1, String note_2, String note_3) {
		super();
		this.cf = cf;
		this.codice = codice;
		this.nome = nome;
		this.indirizzo = indirizzo;
		this.cap = cap;
		this.citta = citta;
		this.provincia = provincia;
		this.nome_dest = nome_dest;
		this.ind_dest = ind_dest;
		this.cap_dest = cap_dest;
		this.cit_dest = cit_dest;
		this.prov_dest = prov_dest;
		this.p_iva = p_iva;
		this.cod_fisc = cod_fisc;
		this.pagamento = pagamento;
		this.pag_immediato = pag_immediato;
		this.scad_gg = scad_gg;
		this.scad_mesi = scad_mesi;
		this.n_rate = n_rate;
		this.banca = banca;
		this.cab = cab;
		this.abi = abi;
		this.telefono = telefono;
		this.email = email;
		this.nome_stampa = nome_stampa;
		this.note_1 = note_1;
		this.note_2 = note_2;
		this.note_3 = note_3;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
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

	public String getNome_dest() {
		return nome_dest;
	}

	public void setNome_dest(String nome_dest) {
		this.nome_dest = nome_dest;
	}

	public String getInd_dest() {
		return ind_dest;
	}

	public void setInd_dest(String ind_dest) {
		this.ind_dest = ind_dest;
	}

	public String getCap_dest() {
		return cap_dest;
	}

	public void setCap_dest(String cap_dest) {
		this.cap_dest = cap_dest;
	}

	public String getCit_dest() {
		return cit_dest;
	}

	public void setCit_dest(String cit_dest) {
		this.cit_dest = cit_dest;
	}

	public String getProv_dest() {
		return prov_dest;
	}

	public void setProv_dest(String prov_dest) {
		this.prov_dest = prov_dest;
	}

	public String getP_iva() {
		return p_iva;
	}

	public void setP_iva(String p_iva) {
		this.p_iva = p_iva;
	}

	public String getCod_fisc() {
		return cod_fisc;
	}

	public void setCod_fisc(String cod_fisc) {
		this.cod_fisc = cod_fisc;
	}

	public String getPagamento() {
		return pagamento;
	}

	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}

	public String getPag_immediato() {
		return pag_immediato;
	}

	public void setPag_immediato(String pag_immediato) {
		this.pag_immediato = pag_immediato;
	}

	public String getScad_gg() {
		return scad_gg;
	}

	public void setScad_gg(String scad_gg) {
		this.scad_gg = scad_gg;
	}

	public String getScad_mesi() {
		return scad_mesi;
	}

	public void setScad_mesi(String scad_mesi) {
		this.scad_mesi = scad_mesi;
	}

	public String getN_rate() {
		return n_rate;
	}

	public void setN_rate(String n_rate) {
		this.n_rate = n_rate;
	}

	public String getBanca() {
		return banca;
	}

	public void setBanca(String banca) {
		this.banca = banca;
	}

	public String getCab() {
		return cab;
	}

	public void setCab(String cab) {
		this.cab = cab;
	}

	public String getAbi() {
		return abi;
	}

	public void setAbi(String abi) {
		this.abi = abi;
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

	public String getNome_stampa() {
		return nome_stampa;
	}

	public void setNome_stampa(String nome_stampa) {
		this.nome_stampa = nome_stampa;
	}

	public String getNote_1() {
		return note_1;
	}

	public void setNote_1(String note_1) {
		this.note_1 = note_1;
	}

	public String getNote_2() {
		return note_2;
	}

	public void setNote_2(String note_2) {
		this.note_2 = note_2;
	}

	public String getNote_3() {
		return note_3;
	}

	public void setNote_3(String note_3) {
		this.note_3 = note_3;
	}

	@Override
	public String toString() {
		return "AnagraficaAzienda [cf=" + cf + ", codice=" + codice + ", nome=" + nome + ", indirizzo=" + indirizzo
				+ ", cap=" + cap + ", citta=" + citta + ", provincia=" + provincia + ", nome_dest=" + nome_dest
				+ ", ind_dest=" + ind_dest + ", cap_dest=" + cap_dest + ", cit_dest=" + cit_dest + ", prov_dest="
				+ prov_dest + ", p_iva=" + p_iva + ", cod_fisc=" + cod_fisc + ", pagamento=" + pagamento
				+ ", pag_immediato=" + pag_immediato + ", scad_gg=" + scad_gg + ", scad_mesi=" + scad_mesi + ", n_rate="
				+ n_rate + ", banca=" + banca + ", cab=" + cab + ", abi=" + abi + ", telefono=" + telefono + ", email="
				+ email + ", nome_stampa=" + nome_stampa + ", note_1=" + note_1 + ", note_2=" + note_2 + ", note_3="
				+ note_3 + "]";
	}
	
	
	
	
}
