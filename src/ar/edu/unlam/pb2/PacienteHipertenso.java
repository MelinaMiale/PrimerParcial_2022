package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

public class PacienteHipertenso extends Paciente {

	private Boolean noConsumeSal;
	
	public PacienteHipertenso(Long dni, String nombreYApellido) {
		super(dni, nombreYApellido);
		this.noConsumeSal = true;
	}

	public Boolean getNoConsumeSal() {
		return noConsumeSal;
	}

	@Override
	public void consumePlato(PlatoDeComida platoDeComida) {
		List<Alimento> ingredientesNoPermitidos = new ArrayList<>();
		for(Alimento alimento : platoDeComida.getAlimentos()) {
			if(alimento.getContieneSal()) {
				ingredientesNoPermitidos.add(alimento);
			}
		}
		if(ingredientesNoPermitidos.size() == 0) {
			this.getPlatosConsumidos().add(platoDeComida);
		}
	}
	
	
}
