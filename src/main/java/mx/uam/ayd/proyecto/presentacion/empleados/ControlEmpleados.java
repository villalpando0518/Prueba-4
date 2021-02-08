package mx.uam.ayd.proyecto.presentacion.empleados;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.modelo.*;
import mx.uam.ayd.proyecto.negocio.ServicioEmpleado;
import mx.uam.ayd.proyecto.presentacion.editarEmpleado.ControlEditarEmpleado;
import mx.uam.ayd.proyecto.presentacion.registrarEmpleado.ControlRegistrarEmpleado;

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
	
	public void inicia() {
		List <Empleado> empleados = servicioEmpleado.recuperarEmpleados();
		ventanaEmpleados.muestra(this, empleados);
	}
	
	public void registrar() {
		controlRegistrarEmpleado.inicia();
	}
	
	public void registrarEmpleado() {
		controlRegistrarEmpleado.inicia();
	}
	
	public void editarEmpleado() {
		controlEditarEmpleado.muestra();
	}
	
	public void termina() {
		ventanaEmpleados.setVisible(false);
	}
	
	public void actualizaVentanaEmpleados() {
		List <Empleado> empleados = servicioEmpleado.recuperarEmpleados();
		ventanaEmpleados.actualizaEmpleados(this, empleados);
		
	}
	
	

}
