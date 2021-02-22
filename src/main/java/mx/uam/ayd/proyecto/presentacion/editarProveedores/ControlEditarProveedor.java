package mx.uam.ayd.proyecto.presentacion.editarProveedores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioProveedor;
import mx.uam.ayd.proyecto.negocio.modelo.Proveedor;
import mx.uam.ayd.proyecto.presentacion.informeInventario.VentanaInformeInventario;


@Component
public class ControlEditarProveedor {

	@Autowired
	private VentanaEditarProveedor ventanaEditarProveedor;
	
	@Autowired
	private ServicioProveedor servicioProveedor;
	
	/**
	 * Muestra la ventana donde se editan los registros de los proveedores. 
	 *
	 */
	public void muestra() {
		List <Proveedor> proveedores = servicioProveedor.recuperarProveedores();
		ventanaEditarProveedor.muestra(this, proveedores);
	}
	
	/**
	 * Muestra la ventana donde se editan los proveedores. 
	 * @param nomProveedor Nombre del proveedor.
	 * @param idProv Número del id del proveedor.
	 * @param marca Nombre de la marca.
	 * @param tipo Tipo de producto.
	 * @param costo Costo manejable.
	 */
	
	public void editarProveedor(String nomProveedor, int idProv, String marca, String tipo,
			double costo) {
	try{
			servicioProveedor.editarProveedor(nomProveedor, idProv, marca, tipo, costo);
			ventanaEditarProveedor.muestraDialogoConMensaje("Proveedor modificado exitosamente");
		}catch(Exception ex) {
			ventanaEditarProveedor.muestraDialogoConMensaje("Error al editar proveedor: " + ex.getMessage());
		}
		termina();
}
	/**
	 * Cambia la propiedad de Visibilidad {@link VentanaEditarProveedor#setVisible(boolean)} de la Ventana para cerrarla
	 */
	public void termina() {
		ventanaEditarProveedor.setVisible(false);
	}
		
}
