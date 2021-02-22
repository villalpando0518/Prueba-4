package mx.uam.ayd.proyecto.presentacion.clientes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioCliente;
import mx.uam.ayd.proyecto.negocio.modelo.Cliente;
import mx.uam.ayd.proyecto.presentacion.registrarCliente.ControlRegistrarCliente;

/**
 * 
 * Controla las funciones de la ventana de clientes,
 * contiene métodos que permiten abrir y cerrar otras
 * ventanas correctamente.
 * @author Panther Zone
 */
@Component
public class ControlClientes {
	
	@Autowired
	private ServicioCliente servicioCliente;
	
	@Autowired
	private VentanaClientes ventanaClientes;

	
	@Autowired
	private ControlRegistrarCliente controlRegistrarCliente;
	
	/**
	 * inicia:Permite abrir la ventana de la tabla de clientes registrados
	 */
	public void inicia() {
		List <Cliente> clientes = servicioCliente.recuperarCliente();
		ventanaClientes.muestra(this, clientes);
		
	}
	/**
	 * registrar: Permite visualizar la ventana de registrar cliente
	 */
	public void registrar() {
		controlRegistrarCliente.inicia();
	}
	/**
	 * registrarCliente: Permite abrir la ventana para agregar a un nuevo cliente
	 */
	public void registrarCliente() {
		controlRegistrarCliente.inicia();
	}
	/**
	 * termina: Permite cerrar la ventana de los clientes
	 */
	public void termina() {
		ventanaClientes.setVisible(false);
	}
	

}
