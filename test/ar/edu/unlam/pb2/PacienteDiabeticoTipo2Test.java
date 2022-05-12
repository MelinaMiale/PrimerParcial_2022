package ar.edu.unlam.pb2;

import static org.junit.Assert.*;


import org.junit.Test;

public class PacienteDiabeticoTipo2Test {

	@Test
	public void queSeLePuedaAdministrarLaPrimerDosisDeInsulinaAlPaciente() {
		//given
		PacienteDiabeticoTipo2 pacienteDiabeticoTipo2 = new PacienteDiabeticoTipo2(4123501L, "Nombre1Apellido1");
		final Integer CANTIDAD_DE_DOSIS_ADMINISTRADAS = 1;
		
		//when
		pacienteDiabeticoTipo2.administrarDosisDeInsulina();

		//then
		assertEquals(CANTIDAD_DE_DOSIS_ADMINISTRADAS, pacienteDiabeticoTipo2.getDosisDeInsulinaAdministradas());
		assertFalse(pacienteDiabeticoTipo2.getTodasLasDosisFueronAdministradas());

	}
	
	@Test
	public void queSeLePuedaAdministrarLaPrimerYSegundaDosisDeInsulinaAlPaciente() {
		//given
		PacienteDiabeticoTipo2 pacienteDiabeticoTipo2 = new PacienteDiabeticoTipo2(4123501L, "Nombre1Apellido1");
		final Integer CANTIDAD_DE_DOSIS_ADMINISTRADAS = 2;
		
		//when
		pacienteDiabeticoTipo2.administrarDosisDeInsulina();
		pacienteDiabeticoTipo2.administrarDosisDeInsulina();
		
		//then
		assertEquals(CANTIDAD_DE_DOSIS_ADMINISTRADAS, pacienteDiabeticoTipo2.getDosisDeInsulinaAdministradas());
		assertTrue(pacienteDiabeticoTipo2.getTodasLasDosisFueronAdministradas());

	}

	@Test
	public void queNoSeLePuedaAdministrarUnaDosisDeInsulinaAlPacienteCuandoYaSeLeAdministraronTodasLasDosisNecesariasEnElDia() {
		//given
		PacienteDiabeticoTipo2 pacienteDiabeticoTipo2 = new PacienteDiabeticoTipo2(4123501L, "Nombre1Apellido1");
		final Integer CANTIDAD_DE_DOSIS_ADMINISTRADAS = 2;
		
		//when
		pacienteDiabeticoTipo2.administrarDosisDeInsulina();
		pacienteDiabeticoTipo2.administrarDosisDeInsulina();
		pacienteDiabeticoTipo2.administrarDosisDeInsulina();
		
		//then
		assertEquals(CANTIDAD_DE_DOSIS_ADMINISTRADAS, pacienteDiabeticoTipo2.getDosisDeInsulinaAdministradas());
		assertTrue(pacienteDiabeticoTipo2.getTodasLasDosisFueronAdministradas());

	}

}
