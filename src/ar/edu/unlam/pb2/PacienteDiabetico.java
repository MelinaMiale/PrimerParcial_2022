package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

public class PacienteDiabetico extends Paciente {
	
	private Boolean noConsumeAzucar;

	public PacienteDiabetico(Long dni, String nombreYApellido) {
		super(dni, nombreYApellido);
		this.noConsumeAzucar = true;
	}

	public Boolean getNoConsumeAzucar() {
		return this.noConsumeAzucar;
	}

	@Override
	public void consumePlato(PlatoDeComida platoDeComida) {
		List<Alimento> ingredientesNoPermitidos = new ArrayList<>();
		for(Alimento alimento : platoDeComida.getAlimentos()) {
			if(alimento.getContieneAzucar()) {
				ingredientesNoPermitidos.add(alimento);
			}
		}
		if(ingredientesNoPermitidos.size() == 0) {
			this.getPlatosConsumidos().add(platoDeComida);
		}
	}
}
