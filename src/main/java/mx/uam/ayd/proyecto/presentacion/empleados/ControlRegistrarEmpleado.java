package mx.uam.ayd.proyecto.presentacion.empleados;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import mx.uam.ayd.proyecto.negocio.ServicioEmpleado;
import mx.uam.ayd.proyecto.negocio.modelo.Empleado;



@Component
public class ControlRegistrarEmpleado {
	
	@Autowired
	private ServicioEmpleado servicioEmpleado;
	
	@Autowired
	private VentanaRegistrarEmpleado ventana;
	
	public void guardar(String nombreEmp, String apellidos, int edad, double sueldo, String ocupacion) {
		Empleado empleado = new Empleado(nombreEmp, apellidos, edad, sueldo, ocupacion);
		servicioEmpleado.Guardar(empleado);
	}
	
	public void inicia() {
		
		ventana.muestra(this);
	}
	
	
}