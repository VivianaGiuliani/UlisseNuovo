package Oggetti;

import java.util.*;

public class Articolo {

	private String barcode;
	private String cfor;
	private String cod_for;
	private int giacenza;
	private String descrizione;
	private double peso;
	private double caratura;
	private double pr_unit;
	private int tot_giac;
	private int sconto1;
	private int sconto2;
	private double costo;
	private String fv;
	private int cod_categoria;
	
	public Articolo() {
	}
	
	public Articolo(String barcode, String cfor, String cod_for, int giacenza, String descrizione, double peso,
			double caratura, int pr_unit, int tot_giac, int sconto1, int sconto2, double costo, String fv, int cod_categoria) {
		super();
		this.barcode = barcode;
		this.cfor = cfor;
		this.cod_for = cod_for;
		this.giacenza = giacenza;
		this.descrizione = descrizione;
		this.peso = peso;
		this.caratura = caratura;
		this.pr_unit = pr_unit;
		this.tot_giac = tot_giac;
		this.sconto1 = sconto1;
		this.sconto2 = sconto2;
		this.costo = costo;
		this.fv = fv;
		this.cod_categoria = cod_categoria;
	}


	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getCfor() {
		return cfor;
	}

	public void setCfor(String cfor) {
		this.cfor = cfor;
	}

	public String getCod_for() {
		return cod_for;
	}

	public void setCod_for(String cod_for) {
		this.cod_for = cod_for;
	}

	public int getGiacenza() {
		return giacenza;
	}

	public void setGiacenza(int giacenza) {
		this.giacenza = giacenza;
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

	public double getPr_unit() {
		return pr_unit;
	}

	public void setPr_unit(double pr_unit) {
		this.pr_unit = pr_unit;
	}

	public int getTot_giac() {
		return tot_giac;
	}

	public void setTot_giac(int tot_giac) {
		this.tot_giac = tot_giac;
	}

	public int getSconto1() {
		return sconto1;
	}

	public void setSconto1(int sconto1) {
		this.sconto1 = sconto1;
	}

	public int getSconto2() {
		return sconto2;
	}

	public void setSconto2(int sconto2) {
		this.sconto2 = sconto2;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getFv() {
		return fv;
	}

	public void setFv(String fv) {
		this.fv = fv;
	}

	public int getCod_categoria() {
		return cod_categoria;
	}

	public void setCod_categoria(int cod_categoria) {
		this.cod_categoria = cod_categoria;
	}

	

	@Override
	public String toString() {
		return "Articolo [barcode=" + barcode + ", cfor=" + cfor + ", cod_for=" + cod_for + ", giacenza="
				+ giacenza + ", descrizione=" + descrizione + ", peso=" + peso + ", caratura=" + caratura + ", pr_unit="
				+ pr_unit + ", tot_giac=" + tot_giac + ", sconto1=" + sconto1 + ", sconto2=" + sconto2 + ", costo="
				+ costo + ", fv=" + fv + ", cod_categoria=" + cod_categoria + "]";
	}

	
	
	
	
}
