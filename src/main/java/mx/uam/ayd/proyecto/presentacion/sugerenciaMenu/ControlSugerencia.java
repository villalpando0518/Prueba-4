package mx.uam.ayd.proyecto.presentacion.sugerenciaMenu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioSugerencia;
import mx.uam.ayd.proyecto.negocio.modelo.Sugerencia;


@Component
public class ControlSugerencia {
	@Autowired
	private ServicioSugerencia servicioSugerencia;
	
	@Autowired
	private VentanaSugerencia ventana;
	
	@Autowired
	private VentanaVerSugerencias ventana2;
	
	@Autowired
	private ControlSugerencia controlSugerencia;
	
	
	// inicia la VentanaSugerencia para que sea mostrada
	public void inicia() {
		ventana.muestra(this, servicioSugerencia.recuperarSugerencia());
	}
	
	//inicia la VentanaVerSugerencias para que sea mostrada
	public void iniciaSug() {
		//ventana.muestra(this, servicioSugerencia.recuperarSugerencia());
		ventana2.muestraSug(this, servicioSugerencia.recuperarSugerencia());
	}
	
	//mustra un mensaje de exito o error al agregar la sugerencia 
	public void guardar(String nombre, String sugerencia) {
		try {
			servicioSugerencia.crea(nombre,sugerencia);
			ventana.muestraDialogoConMensaje("Agregado exitosamente");
		}catch(Exception ex) {
			ventana.muestraDialogoConMensaje("Error al agregar la sugerencia"+ ex.getMessage());
		}
		termina();
	}
	
	//actualiza la ventana sugerencia 
	public void actualizaVentanaSugerencia() {
		controlSugerencia.actualizaVentanaSugerencia();
	}
	
	// se cambia la propiedad de visibilidad de la ventana
	public void termina() {
		ventana.setVisible(false);
	}
	
	public void actualizaVentana() {
		ventana.actualizado(this);
	}

}
