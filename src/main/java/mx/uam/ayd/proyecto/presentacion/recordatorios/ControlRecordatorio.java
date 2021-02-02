package mx.uam.ayd.proyecto.presentacion.recordatorios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioRecordatorio;
import mx.uam.ayd.proyecto.negocio.modelo.Recordatorio;

@Component
public class ControlRecordatorio {
	
	@Autowired
	private ServicioRecordatorio servicio;
	
	@Autowired
	private VentanaRecordatorios ventana;
	
	@Autowired
	private VentanaAgregarRecordatorio ventanaNuevo;
	
	public void inicia() {
		Recordatorio r = servicio.recupera();
		ventana.muestra(this,r);
	}
	
	public void iniciaNuevo() {
		
		Recordatorio r = servicio.recupera();
		ventanaNuevo.muestra(this,r);
	}
	
	public void actualizarRecordatorios(String r) {
		
		servicio.borrar();
		servicio.crea(r);
	}

}
