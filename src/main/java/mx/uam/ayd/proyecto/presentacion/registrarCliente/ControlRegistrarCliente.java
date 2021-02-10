package mx.uam.ayd.proyecto.presentacion.registrarCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioCliente;
import mx.uam.ayd.proyecto.negocio.modelo.Cliente;


@Component
public class ControlRegistrarCliente {
	@Autowired
	private ServicioCliente servicioCliente;
	
	@Autowired
	private VentanaRegistrarCliente ventana;
	
	public void guardar(String nombreCliente, String correo) {
		Cliente cliente = new Cliente(nombreCliente, correo);
		servicioCliente.Guardar(cliente);
	}
	
	public void inicia() {
		
		ventana.muestra(this);
	}
	

}
