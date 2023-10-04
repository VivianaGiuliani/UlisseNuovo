package Oggetti;

import java.util.Date;

public class Scadenza {
	private int id;
	private String categoria;
	private String nome;
	private String doc_num;
	private String data_doc;
	private double imponibile;
	private double iva;
	private double totale;
	private String cod_banca;
	private String data_scad;
	private String n_rata;
	public Scadenza() {}
	public Scadenza(int id, String categoria, String nome, String doc_num, String data_doc, double imponibile, double iva,
			double totale, String cod_banca, String data_scad, String n_rata) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.nome = nome;
		this.doc_num = doc_num;
		this.data_doc = data_doc;
		this.imponibile = imponibile;
		this.iva = iva;
		this.totale = totale;
		this.cod_banca = cod_banca;
		this.data_scad = data_scad;
		this.n_rata = n_rata;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDoc_num() {
		return doc_num;
	}
	public void setDoc_num(String doc_num) {
		this.doc_num = doc_num;
	}
	public String getData_doc() {
		return data_doc;
	}
	public void setData_doc(String data_doc) {
		this.data_doc = data_doc;
	}
	public double getImponibile() {
		return imponibile;
	}
	public void setImponibile(double imponibile) {
		this.imponibile = imponibile;
	}
	public double getIva() {
		return iva;
	}
	public void setIva(double iva) {
		this.iva = iva;
	}
	public double getTotale() {
		return totale;
	}
	public void setTotale(double totale) {
		this.totale = totale;
	}
	public String getCod_banca() {
		return cod_banca;
	}
	public void setCod_banca(String cod_banca) {
		this.cod_banca = cod_banca;
	}
	public String getData_scad() {
		return data_scad;
	}
	public void setData_scad(String data_scad) {
		this.data_scad = data_scad;
	}
	public String getN_rata() {
		return n_rata;
	}
	public void setN_rata(String n_rata) {
		this.n_rata = n_rata;
	}
	@Override
	public String toString() {
		return "Scadenza [id=" + id + ", categoria=" + categoria + ", nome=" + nome + ", doc_num=" + doc_num
				+ ", data_doc=" + data_doc + ", imponibile=" + imponibile + ", iva=" + iva + ", totale=" + totale
				+ ", cod_banca=" + cod_banca + ", data_scad=" + data_scad + ", n_rata=" + n_rata + "]";
	}
	
	
	
}
