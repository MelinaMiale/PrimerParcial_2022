package ar.edu.unlam.pb2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PacienteDiabeticoTipo2 extends PacienteDiabetico{
	
	private static final Integer dosisDeInsulinaPorDia = 2;

	private Integer dosisDeInsulinaAAdministrarEnElDia;
	private Integer dosisDeInsulinaAdministradas;
	private Boolean todasLasDosisFueronAdministradas;
	private List<LocalDate> fechasConLasDosDosisAdministradas;

	public PacienteDiabeticoTipo2(Long dni, String nombreYApellido) {
		super(dni, nombreYApellido);
		this.dosisDeInsulinaAAdministrarEnElDia = 2;
		this.dosisDeInsulinaAdministradas = 0;
		this.todasLasDosisFueronAdministradas = false;
		this.fechasConLasDosDosisAdministradas = new ArrayList<LocalDate>();
	}

	public Integer getDosisDeInsulina() {
		return this.dosisDeInsulinaAAdministrarEnElDia;
	}

	public Boolean getTodasLasDosisFueronAdministradas() {
		return this.todasLasDosisFueronAdministradas;
	}

	public List<LocalDate> getFechasConLasDosDosisAdministradas() {
		return this.fechasConLasDosDosisAdministradas;
	}

	public Integer getDosisDeInsulinaAdministradas() {
		return dosisDeInsulinaAdministradas;
	}

	public void administrarDosisDeInsulina() {
			if(!this.todasLasDosisFueronAdministradas && 
					this.saberCantasDosisSeAdministraronEnUnaFecha(LocalDate.now()) < dosisDeInsulinaPorDia) {
				this.dosisDeInsulinaAAdministrarEnElDia--;
				this.dosisDeInsulinaAdministradas++;
				this.fechasConLasDosDosisAdministradas.add(LocalDate.now());
			}
			if(this.dosisDeInsulinaAAdministrarEnElDia == 0 && this.dosisDeInsulinaAdministradas == 2) {
				this.todasLasDosisFueronAdministradas = true;
			}
	}
	
	public Integer saberCantasDosisSeAdministraronEnUnaFecha (LocalDate fechaAConsultar) {
		Integer cantidadDeDosisEnLaFechaDada = 0;
		for(LocalDate fecha : this.fechasConLasDosDosisAdministradas) {
			if(fecha.equals(fechaAConsultar)) {
				cantidadDeDosisEnLaFechaDada++;
			}
		}
		
		return cantidadDeDosisEnLaFechaDada;
	}



}
