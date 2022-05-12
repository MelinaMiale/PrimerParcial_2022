package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

public class Paciente {
	
	private Long dni;
	private String nombreYApellido;
	private List<PlatoDeComida> platosConsumidos;
	
	public Paciente(Long dni, String nombreYApellido) {
		this.dni = dni;
		this.nombreYApellido = nombreYApellido;
		this.platosConsumidos = new ArrayList<>();
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getNombreYApellido() {
		return nombreYApellido;
	}

	public void setNombreYApellido(String nombreYApellido) {
		this.nombreYApellido = nombreYApellido;
	}

	public List<PlatoDeComida> getPlatosConsumidos() {
		return platosConsumidos;
	}

	public void setPlatosConsumidos(List<PlatoDeComida> platosConsumidos) {
		this.platosConsumidos = platosConsumidos;
	}
	
	public void consumePlato(PlatoDeComida platoDeComida) {
		this.platosConsumidos.add(platoDeComida);
	}
	
}
