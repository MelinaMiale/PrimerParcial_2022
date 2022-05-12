package ar.edu.unlam.pb2;

import java.util.ArrayList;
import java.util.List;

public class PacienteOncologico extends Paciente {

	private Boolean estaEnTratamiento;
	private Integer dosisDeInsulina; //deben ser dos al final del dia
	
	public PacienteOncologico(Long dni, String nombreYApellido, Boolean estaEnTratamiento) {
		super(dni, nombreYApellido);
		this.estaEnTratamiento = estaEnTratamiento;
		this.dosisDeInsulina = 0;
	}

	public Boolean getEstaEnTratamiento() {
		return estaEnTratamiento;
	}

	public void setEstaEnTratamiento(Boolean estaEnTratamiento) {
		this.estaEnTratamiento = estaEnTratamiento;
	}
	
	public Integer getDosisDeInsulina (){
		return this.dosisDeInsulina;
	}
	
	@Override
	public void consumePlato(PlatoDeComida platoDeComida) {
		List<Alimento> ingredientesNoPermitidos = new ArrayList<>();
		for(Alimento alimento : platoDeComida.getAlimentos()) {
			if(this.estaEnTratamiento && alimento.getEstaCrudo()) {
				ingredientesNoPermitidos.add(alimento);
			}
		}
		if(ingredientesNoPermitidos.size() == 0) {
			this.getPlatosConsumidos().add(platoDeComida);
		}
	}
	
	public void administrarUnaDosisDeInsulina() {
		if(this.dosisDeInsulina < 2) {
			this.dosisDeInsulina++;
		}
	}
}
