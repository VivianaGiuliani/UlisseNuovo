package Oggetti;

import java.sql.Date;

import javax.xml.crypto.Data;

public class Vendita {
	private int numeroVendita;
	private String data;
	private int totaleMerce;
	private double sconto;
	private double merceScontata;
	private int totaleScontato;
	private int acconto;
	private int totaleSaldo;
	private String metodoPagamento;
	
	public Vendita() {}

	public Vendita(int numeroVendita, String data, int totaleMerce, double sconto, double merceScontata,
			int totaleScontato, int acconto, int totaleSaldo, String metodoPagamento) {
		super();
		this.numeroVendita = numeroVendita;
		this.data = data;
		this.totaleMerce = totaleMerce;
		this.sconto = sconto;
		this.merceScontata = merceScontata;
		this.totaleScontato = totaleScontato;
		this.acconto = acconto;
		this.totaleSaldo = totaleSaldo;
		this.metodoPagamento = metodoPagamento;
	}

	public int getNumeroVendita() {
		return numeroVendita;
	}

	public void setNumeroVendita(int numeroVendita) {
		this.numeroVendita = numeroVendita;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public int getTotaleMerce() {
		return totaleMerce;
	}

	public void setTotaleMerce(int totaleMerce) {
		this.totaleMerce = totaleMerce;
	}

	public double getSconto() {
		return sconto;
	}

	public void setSconto(double sconto) {
		this.sconto = sconto;
	}

	public double getMerceScontata() {
		return merceScontata;
	}

	public void setMerceScontata(double merceScontata) {
		this.merceScontata = merceScontata;
	}

	public int getTotaleScontato() {
		return totaleScontato;
	}

	public void setTotaleScontato(int totaleScontato) {
		this.totaleScontato = totaleScontato;
	}

	public int getAcconto() {
		return acconto;
	}

	public void setAcconto(int acconto) {
		this.acconto = acconto;
	}

	public int getTotaleSaldo() {
		return totaleSaldo;
	}

	public void setTotaleSaldo(int totaleSaldo) {
		this.totaleSaldo = totaleSaldo;
	}

	public String getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	@Override
	public String toString() {
		return "Vendita [numeroVendita=" + numeroVendita + ", data=" + data + ", totaleMerce=" + totaleMerce
				+ ", sconto=" + sconto + ", merceScontata=" + merceScontata + ", totaleScontato=" + totaleScontato
				+ ", acconto=" + acconto + ", totaleSaldo=" + totaleSaldo + ", metodoPagamento=" + metodoPagamento
				+ "]";
	}
	
	
	
}
