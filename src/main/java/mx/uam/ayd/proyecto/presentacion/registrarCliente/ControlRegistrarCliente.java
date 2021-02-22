package mx.uam.ayd.proyecto.presentacion.registrarCliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioCliente;
import mx.uam.ayd.proyecto.negocio.modelo.Cliente;
import mx.uam.ayd.proyecto.presentacion.clientes.ControlClientes;


@Component
public class ControlRegistrarCliente {
	
	@Autowired
	private ControlClientes controlClientes;
	
	@Autowired
	private ServicioCliente servicioCliente;
	
	@Autowired
	private VentanaRegistrarCliente ventanaRegistrarCliente;
	
	public void inicia() {
		ventanaRegistrarCliente.muestra(this, servicioCliente.recuperarCliente());
	}
	
	
	public void registrarCliente(String nombre, String correo, String promocion) {
		try { 
			servicioCliente.crea(nombre, correo, promocion);
			ventanaRegistrarCliente.muestraDialogoConMensaje("Agregado exitosamente");
		}catch(Exception ex) {
			ventanaRegistrarCliente.muestraDialogoConMensaje("Error al agregar empleado"+ ex.getMessage());
		}
		termina();
		}
	
	public void termina() {
		ventanaRegistrarCliente.setVisible(false);
	}
}
