package mx.uam.ayd.proyecto.presentacion.menus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioMenu;
import mx.uam.ayd.proyecto.negocio.modelo.Menu;

@Component
public class ControlMenu {
	
	@Autowired
	private ServicioMenu servicio;
	
	@Autowired
	private VentanaMenus ventana;
	
	@Autowired
	private VentanaAgregarMenu ventanaNuevo;
	
	public void inicia() {
		Menu m = servicio.recupera();
		ventana.muestra(this,m);
	}
	
	public void iniciaNuevo() {
		
		Menu m = servicio.recupera();
		ventanaNuevo.muestra(this,m);
	}
	
	public void actualizarMenus(String m) {
		
		servicio.borrar();
		servicio.crea(m);
	}

}

