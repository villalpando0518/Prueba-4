package mx.uam.ayd.proyecto.presentacion.registrarProveedor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioProveedor;
import mx.uam.ayd.proyecto.presentacion.proveedores.ControlProveedores;



@Component
public class ControlRegistrarProveedor {
	@Autowired
	private ControlProveedores controlProveedores;
	
	@Autowired
	private ServicioProveedor servicioProveedor;
	
	@Autowired
	private VentanaRegistrarProveedor ventanaRegistrarProveedor;
	
	/**
	 * Muestra la ventana donde se registran los proveedores.
	 * @param no tiene ningún parametro de entrada
	 */
	public void inicia() {
		ventanaRegistrarProveedor.muestra(this, servicioProveedor.recuperarProveedores());
	}
	
	/**
	 * Registra un nuevo proveedor, al momento de llenar cada requerimiento.
	 * * @param nomProveedor Nombre del proveedor.
	 * @param idProv Número del id del proveedor.
	 * @param marca Nombre de la marca.
	 * @param tipo Tipo de producto.
	 * @param costo Costo manejable.
	 * servicioProveedor.crea(nomProveedor, marca, tipo,costo) Llama a ServicioProveedor para guardar los proveedores en persistencia.
	 */
	public void registrarProveedor(String nomProveedor, String marca, String tipo, double costo) {
		try {
			servicioProveedor.crea(nomProveedor, marca, tipo,costo);
			ventanaRegistrarProveedor.muestraDialogoConMensaje("Agregado exitosamente");
		}catch(Exception ex) {
			ventanaRegistrarProveedor.muestraDialogoConMensaje("Error al agregar proveedor"+ ex.getMessage());
		}
		termina();
	}
	
	public void actualizaVentanaEmpleados() {
		controlProveedores.actualizaVentanaProveedores();
	}
	
	public void termina() {
		ventanaRegistrarProveedor.setVisible(false);
	}
	
	public void actualizaVentana() {
		ventanaRegistrarProveedor.actualizado(this);
	}
	
}
