package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

public class PacienteCeliaco extends Paciente {

	private Boolean noConsumeTaac;
	
	public PacienteCeliaco(Long dni, String nombreYApellido) {
		super(dni, nombreYApellido);
		this.noConsumeTaac = true;
	}

	public Boolean getNoConsumeTaac() {
		return noConsumeTaac;
	}

	public void setNoConsumeTaac(Boolean noConsumeTaac) {
		this.noConsumeTaac = noConsumeTaac;
	}
	
	@Override
	public void consumePlato(PlatoDeComida platoDeComida) {
		List<Alimento> ingredientesNoPermitidos = new ArrayList<>();
		for(Alimento alimento : platoDeComida.getAlimentos()) {
			if(alimento.getContieneTaac()) {
				ingredientesNoPermitidos.add(alimento);
			}
		}
		if(ingredientesNoPermitidos.size() == 0) {
			this.getPlatosConsumidos().add(platoDeComida);
		}
	}
}
