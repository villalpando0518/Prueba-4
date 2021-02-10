package mx.uam.ayd.proyecto.presentacion.editarEmpleado;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import mx.uam.ayd.proyecto.negocio.ServicioEmpleado;
import mx.uam.ayd.proyecto.negocio.modelo.Empleado;

@Component
public class ControlEditarEmpleado {

	@Autowired
	private VentanaEditarEmpleado ventanaEditarEmpleado;
	
	@Autowired
	private ServicioEmpleado servicioEmpleado;
	
	public void muestra() {
		List <Empleado> empleados = servicioEmpleado.recuperarEmpleados();
		ventanaEditarEmpleado.muestra(this, empleados);
	}
	
	public void editarEmpleado(String nombreEmp, int idEmp, String apellidos, int edad,
			double sueldo, String ocupacion) {
	try{
			servicioEmpleado.editarEmpleado(nombreEmp, idEmp, apellidos, edad, sueldo, ocupacion);
			ventanaEditarEmpleado.muestraDialogoConMensaje("Empleado modificado exitosamente");
		}catch(Exception ex) {
			ventanaEditarEmpleado.muestraDialogoConMensaje("Error al editar empleado: " + ex.getMessage());
		}
		termina();
}
	
	public void termina() {
		ventanaEditarEmpleado.setVisible(false);
	}
		
}
