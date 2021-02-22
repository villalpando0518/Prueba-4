package mx.uam.ayd.proyecto.presentacion.empleados;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import mx.uam.ayd.proyecto.negocio.ServicioEmpleado;
import mx.uam.ayd.proyecto.negocio.modelo.Empleado;
import mx.uam.ayd.proyecto.presentacion.editarEmpleado.ControlEditarEmpleado;
import mx.uam.ayd.proyecto.presentacion.registrarEmpleado.ControlRegistrarEmpleado;
import mx.uam.ayd.proyecto.presentacion.registrarEmpleado.VentanaRegistrarEmpleado;

/**
 * Panther Zone
 * Controla las funciones de la ventana de empleados,
 * contiene métodos que permiten abrir y cerrar otras
 * ventanas correctamente.
 * @author Paola Aguillón
 */
@Component
public class ControlEmpleados {
	
	@Autowired
	private ServicioEmpleado servicioEmpleado;
	
	@Autowired
	private VentanaEmpleados ventanaEmpleados;
	
	@Autowired
	private ControlRegistrarEmpleado controlRegistrarEmpleado;
	
	@Autowired
	private ControlEditarEmpleado controlEditarEmpleado;
	
	/**
	 * inicia: Permite abrir la ventana con la tabla de los empleados registrados
	 */
	public void inicia() {
		List <Empleado> empleados = servicioEmpleado.recuperarEmpleados();
		ventanaEmpleados.muestra(this, empleados);
	}
	/**
	 * registrar: Permite visualizar la ventana de registrar empleado
	 */
	public void registrar() {
		controlRegistrarEmpleado.inicia();
	}
	/**
	 * registrarEmpleado: Permite abrir la ventana para agregar a un empleado
	 */
	public void registrarEmpleado() {
		controlRegistrarEmpleado.inicia();
	}
	/**
	 * editarEmpleado: Permite abrir la ventana para editar la información de algun empleado
	 */
	public void editarEmpleado() {
		controlEditarEmpleado.muestra();
	}
	/**
	 * termina: Permite cerrar la ventana de los empleados
	 */
	public void termina() {
		ventanaEmpleados.setVisible(false);
	}
	/**
	 * actualizaVentanaEmpleados: Actualiza la información del empleado modificado en la lista de empleados
	 */
	public void actualizaVentanaEmpleados() {
		List <Empleado> empleados = servicioEmpleado.recuperarEmpleados();
		ventanaEmpleados.actualizaEmpleados(this, empleados);
		}
	
	
}