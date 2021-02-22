package mx.uam.ayd.proyecto.presentacion.proveedores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import mx.uam.ayd.proyecto.negocio.ServicioProveedor;
import mx.uam.ayd.proyecto.negocio.modelo.Proveedor;
import mx.uam.ayd.proyecto.presentacion.editarProveedores.ControlEditarProveedor;
import mx.uam.ayd.proyecto.presentacion.registrarProveedor.ControlRegistrarProveedor;


//Holis

@Component
public class ControlProveedores {
	
	@Autowired
	private ServicioProveedor servicioProveedor;
	
	@Autowired
	private VentanaProveedores ventanaProveedores;
	
	@Autowired
	private ControlRegistrarProveedor controlRegistrarProveedor;
	
	@Autowired
	private ControlEditarProveedor controlEditarProveedor;
	
	public void inicia() {
		List <Proveedor> proveedores = servicioProveedor.recuperarProveedores();
		ventanaProveedores.muestra(this, proveedores);
	}
	
	public void registrar() {
		controlRegistrarProveedor.inicia();
	}
	
	public void registrarProveedor() {
		controlRegistrarProveedor.inicia();
	}
	
	public void editarProveedor() {
		controlEditarProveedor.muestra();
	}
	
	public void termina() {
		ventanaProveedores.setVisible(false);
	}
	
	public void actualizaVentanaProveedores() {
		List <Proveedor> proveedores = servicioProveedor.recuperarProveedores();
		ventanaProveedores.actualizaProveedores(this, proveedores);
		}
	
	
}