package mx.uam.ayd.proyecto.presentacion.registrarEmpleado;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import mx.uam.ayd.proyecto.negocio.ServicioEmpleado;
import mx.uam.ayd.proyecto.negocio.modelo.Empleado;
import mx.uam.ayd.proyecto.presentacion.empleados.ControlEmpleados;



@Component
public class ControlRegistrarEmpleado {
	
	@Autowired
	private ControlEmpleados controlEmpleados;
	
	@Autowired
	private ServicioEmpleado servicioEmpleado;
	
	@Autowired
	private VentanaRegistrarEmpleado ventanaRegistrarEmpleado;
	
	public void inicia() {
		ventanaRegistrarEmpleado.muestra(this, servicioEmpleado.recuperarEmpleados());
	}
	
	public void registrarEmpleado(String nombre, String apellidos, int edad, double sueldo, String ocupacion) {
		try {
			servicioEmpleado.crea(nombre, apellidos, edad, sueldo, ocupacion);
			ventanaRegistrarEmpleado.muestraDialogoConMensaje("Agregado exitosamente");
		}catch(Exception ex) {
			ventanaRegistrarEmpleado.muestraDialogoConMensaje("Error al agregar empleado"+ ex.getMessage());
		}
		termina();
	}
	
	public void actualizaVentanaEmpleados() {
		controlEmpleados.actualizaVentanaEmpleados();
	}
	
	public void termina() {
		ventanaRegistrarEmpleado.setVisible(false);
	}
	
	public void actualizaVentana() {
		ventanaRegistrarEmpleado.actualizado(this);
	}
	
}
