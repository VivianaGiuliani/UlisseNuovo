package Oggetti;

import java.util.Objects;

public class Categoria {
	private int pk;
	private String categoria;
	private int min_giac;
	
	public Categoria () {}
	
	public Categoria(int pk, String categoria, int min_giac) {
		super();
		this.pk = pk;
		this.categoria = categoria;
		this.min_giac = min_giac;
	}

	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getMin_giac() {
		return min_giac;
	}

	public void setMin_giac(int min_giac) {
		this.min_giac = min_giac;
	}

	@Override
	public int hashCode() {
		return Objects.hash(min_giac, categoria, pk);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return min_giac == other.min_giac && Objects.equals(categoria, other.categoria) && pk == other.pk;
	}

	@Override
	public String toString() {
		return "Categoria [pk=" + pk + ", categoria=" + categoria + ", min_giac=" + min_giac + "]";
	}

	
	
	
	
}
