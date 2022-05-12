package ar.edu.unlam.pb2;

import java.util.Set;

public class PlatoDeComida {
	
	private Set<Alimento> alimentos;
	private String nombre;
	private ProcesoElaboracion procesoElaboracion;
	
	public PlatoDeComida(String nombre, Set<Alimento> alimentos) {
		this.nombre = nombre;
		this.alimentos = alimentos;
	}

	public Set<Alimento> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(Set<Alimento> alimentos) {
		this.alimentos = alimentos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ProcesoElaboracion getProcesoElaboracion() {
		return procesoElaboracion;
	}

	public void setProcesoElaboracion(ProcesoElaboracion procesoElaboracion) {
		this.procesoElaboracion = procesoElaboracion;
	}
	
	
	
}
