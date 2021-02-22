package mx.uam.ayd.proyecto.presentación.Caja;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import mx.uam.ayd.proyecto.presentacion.caja.ControlCorteCaja;
import mx.uam.ayd.proyecto.presentacion.caja.VentanaCorteCaja;
import mx.uam.ayd.proyecto.presentacion.caja.VentanaCorteCaja2;

class CorteCaja {

	private ControlCorteCaja control = new ControlCorteCaja();
	private VentanaCorteCaja2 ventana = new VentanaCorteCaja2();
	
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void desplegar() {
		
		/*
		assertTimeout(, control.continuar("", 10)); 
		assertDoesNotThrow(control.continuar("", 10));
		assertDoesNotThrow(control.continuar("", 10));
		*/
	}
	
	@Test
	public void mostrar() {
		
		//assertTrue(ventana.setVisible(true));
		ventana.setVisible(true);
		
	}
	
	@Test
	public void esEntero() {
		
		assertTrue(ventana.isInt("001"));
		assertFalse(ventana.isInt(""));
	}

}
