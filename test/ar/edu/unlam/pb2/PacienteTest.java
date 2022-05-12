package ar.edu.unlam.pb2;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;

import org.junit.Test;

public class PacienteTest {

	@Test
	public void queUnPacienteDiabeticoPuedaConsumirUnPlatoDeComida() {
		//given
		PacienteDiabetico pDiabetico = new PacienteDiabetico(4123501L, "Nombre1Apellido1");
		Alimento pollo = new Alimento("pollo", false, false, false, false);
		Alimento agua = new Alimento("agua", false, false, false, false);
		Alimento verduras = new Alimento("verduras", false, false, false, false);		
		
		PlatoDeComida sopaDePollo = new PlatoDeComida("Sopa de Pollo", new HashSet<Alimento>(List.of(pollo, agua, verduras)));
		
		//when
		pDiabetico.consumePlato(sopaDePollo);
		
		//then
		assertTrue(pDiabetico.getPlatosConsumidos().contains(sopaDePollo));
	}
	
	@Test
	public void queUnPacienteOncologicoNoPuedaConsumirUnPlatoDeComidaSiEstaEnTratamiento() {
		//given
		Boolean estaEnTratamiento = true;
		PacienteOncologico oncologico = new PacienteOncologico(4123501L, "Nombre1Apellido1", estaEnTratamiento);
		Alimento papa = new Alimento("papa", false, false, false, false);
		Alimento huevo = new Alimento("huevo", false, false, false, false);
		Alimento zanahoriaRallada = new Alimento("zanahoriaRallada", true, false, false, false);	
		
		final int CANTIDAD_DE_PLATOS_CONSUMIDOS_POR_EL_PACIENTE = 0;
		
		PlatoDeComida ensaladaDePapaHuevoYZanahoria = new PlatoDeComida("Sopa de Pollo", 
				new HashSet<Alimento>(List.of(papa, huevo, zanahoriaRallada)));
		
		//when
		oncologico.consumePlato(ensaladaDePapaHuevoYZanahoria);
		
		//then
		assertEquals(CANTIDAD_DE_PLATOS_CONSUMIDOS_POR_EL_PACIENTE, oncologico.getPlatosConsumidos().size());
	}
	
	@Test
	public void queUnPacienteOncologicoPuedaConsumirUnPlatoDeComidaSiNoEstaEnTratamiento() {
		//given
		Boolean estaEnTratamiento = false;
		PacienteOncologico oncologico = new PacienteOncologico(4123501L, "Nombre1Apellido1", estaEnTratamiento);
		Alimento papa = new Alimento("papa", false, false, false, false);
		Alimento huevo = new Alimento("huevo", false, false, false, false);
		Alimento mayonesa = new Alimento("mayonesa", false, true, false, true);
		
		
		final int CANTIDAD_DE_PLATOS_CONSUMIDOS_POR_EL_PACIENTE = 1;
		
		PlatoDeComida ensaladaDePapaHuevo = new PlatoDeComida("ensaladaDePapaHuevo", 
				new HashSet<Alimento>(List.of(papa, huevo, mayonesa)));
		
		//when
		oncologico.consumePlato(ensaladaDePapaHuevo);
		
		//then
		assertTrue(oncologico.getPlatosConsumidos().contains(ensaladaDePapaHuevo));
		assertEquals(CANTIDAD_DE_PLATOS_CONSUMIDOS_POR_EL_PACIENTE, oncologico.getPlatosConsumidos().size());
	}
	
	@Test
	public void queUnPacienteCeliacoPuedaConsumirUnPlatoDeComida() {
		//given
		PacienteCeliaco pacienteCeliaco = new PacienteCeliaco(4123501L, "Nombre1Apellido1");
		
		Alimento papa = new Alimento("papa", false, false, false, false);
		Alimento huevo = new Alimento("huevo", false, false, false, false);
		Alimento zanahoriaRallada = new Alimento("zanahoriaRallada", true, false, false, false);	
		
		Alimento masaDeTarta = new Alimento("masaDeTarta", false, true, true, false);
		Alimento atun = new Alimento("atun", false, false, false, false);
		Alimento verduras = new Alimento("verduras", true, false, false, false);
		
		
		final int CANTIDAD_DE_PLATOS_CONSUMIDOS_POR_EL_PACIENTE = 1;
		
		PlatoDeComida ensaladaDePapaHuevoYZanahoria = new PlatoDeComida("ensaladaDePapaHuevoYZanahoria", 
				new HashSet<Alimento>(List.of(papa, huevo, zanahoriaRallada)));
		PlatoDeComida tartaAtun = new PlatoDeComida("tartaAtun",  
				new HashSet<Alimento> (List.of(masaDeTarta, atun, verduras)));
		
		//when
		pacienteCeliaco.consumePlato(ensaladaDePapaHuevoYZanahoria);
		pacienteCeliaco.consumePlato(tartaAtun);
		
		//then
		assertEquals(CANTIDAD_DE_PLATOS_CONSUMIDOS_POR_EL_PACIENTE, pacienteCeliaco.getPlatosConsumidos().size());
		assertTrue(pacienteCeliaco.getPlatosConsumidos().contains(ensaladaDePapaHuevoYZanahoria));
		assertFalse(pacienteCeliaco.getPlatosConsumidos().contains(tartaAtun));
	}
	
	@Test
	public void queUnPacienteHipertensoPuedaConsumirUnPlatoDeComida() {
		//given
		PacienteHipertenso pacienteHipertenso = new PacienteHipertenso(4123501L, "Nombre1Apellido1");
		
		Alimento papa = new Alimento("papa", false, false, false, false);
		Alimento huevo = new Alimento("huevo", false, false, false, false);
		Alimento mayonesa = new Alimento("mayonesa", false, false, true, true);	
		
		final int CANTIDAD_DE_PLATOS_CONSUMIDOS_POR_EL_PACIENTE = 0;
		
		PlatoDeComida ensaladaDePapaHuevo = new PlatoDeComida("ensaladaDePapaHuevo", 
				new HashSet<Alimento>(List.of(papa, huevo, mayonesa)));
		//when
		pacienteHipertenso.consumePlato(ensaladaDePapaHuevo);
		
		//then
		assertEquals(CANTIDAD_DE_PLATOS_CONSUMIDOS_POR_EL_PACIENTE, pacienteHipertenso.getPlatosConsumidos().size());
		assertTrue(!pacienteHipertenso.getPlatosConsumidos().contains(ensaladaDePapaHuevo));
	}
	
	@Test
	public void queUnPacienteGeneralPuedaConsumirUnPlatoDeComidaConSalTaccAzucar() {
		//given
		Paciente pacienteGeneral = new Paciente(4123501L, "Nombre1Apellido1");
		
		Alimento papa = new Alimento("papa", false, false, false, false);
		Alimento huevo = new Alimento("huevo", false, false, false, false);
		Alimento pan = new Alimento("pan", false, true, true, true);
		Alimento mayonesa = new Alimento("mayonesa", false, false, true, true);	
		
		final int CANTIDAD_DE_PLATOS_CONSUMIDOS_POR_EL_PACIENTE = 1;
		
		PlatoDeComida ensaladaDePapaHuevoConPan = new PlatoDeComida("ensaladaDePapaHuevoConPan", 
				new HashSet<Alimento>(List.of(papa, huevo, mayonesa, pan)));
		//when
		pacienteGeneral.consumePlato(ensaladaDePapaHuevoConPan);
		
		//then
		assertEquals(CANTIDAD_DE_PLATOS_CONSUMIDOS_POR_EL_PACIENTE, pacienteGeneral.getPlatosConsumidos().size());
		assertTrue(pacienteGeneral.getPlatosConsumidos().contains(ensaladaDePapaHuevoConPan));
	}

	
	
	
	
}
