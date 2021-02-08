package mx.uam.ayd.proyecto.presentacion.ventasMenu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioVentasMenu;
import mx.uam.ayd.proyecto.negocio.modelo.VentasMenu;

@Component
public class ControlVentasMenu {
	
	@Autowired
	private ServicioVentasMenu servicio;
	
	@Autowired
	private VentanaVentasMenu ventana;
	
	public void inicia() {
		ventana.muestra(this);
	}
	
	public List<VentasMenu> recuperarVentas() {
		return servicio.recuperaVentas();
	}
	
	public void actualizaVentas() {
		
	}

}
