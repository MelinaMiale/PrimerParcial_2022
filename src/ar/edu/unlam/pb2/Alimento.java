package ar.edu.unlam.pb2;

import java.util.Objects;

public class Alimento {

	private String descripcion;
	private Boolean estaCrudo;
	private Boolean contieneAzucar;
	private Boolean contieneTaac;
	private Boolean contieneSal;

	public Alimento(String descripcion, Boolean estaCrudo, Boolean contieneAzucar, Boolean contieneTaac, Boolean contieneSal) {
		this.descripcion = descripcion;	
		this.estaCrudo = estaCrudo;
		this.contieneAzucar = contieneAzucar;
		this.contieneTaac = contieneTaac;
		this.contieneSal = contieneSal;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Boolean getEstaCrudo() {
		return estaCrudo;
	}

	public void setEstaCrudo(Boolean estaCrudo) {
		this.estaCrudo = estaCrudo;
	}

	public Boolean getContieneAzucar() {
		return contieneAzucar;
	}

	public void setContieneAzucar(Boolean contieneAzucar) {
		this.contieneAzucar = contieneAzucar;
	}

	public Boolean getContieneTaac() {
		return contieneTaac;
	}

	public void setContieneTaac(Boolean contieneTaac) {
		this.contieneTaac = contieneTaac;
	}

	public Boolean getContieneSal() {
		return contieneSal;
	}

	public void setContieneSal(Boolean contieneSal) {
		this.contieneSal = contieneSal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(descripcion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alimento other = (Alimento) obj;
		return Objects.equals(descripcion, other.descripcion);
	}
	

}
