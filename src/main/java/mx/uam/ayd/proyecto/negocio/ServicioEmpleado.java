package mx.uam.ayd.proyecto.negocio;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.ayd.proyecto.datos.EmpleadoRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Empleado;

@Service
public class ServicioEmpleado {
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	public List<Empleado> recuperarEmpleados() {

		List<Empleado> empleados = new ArrayList<>();
		for (Empleado empleado : empleadoRepository.findAll()) {
			empleados.add(empleado);
		}

		return empleados;
	}

	public Empleado crea(String nombreEmp, String apellidos, int edad, double sueldo, String ocupacion){
		
		Empleado empleado = empleadoRepository.findBynombreEmp(nombreEmp);
		/*if(producto!=null) {
			throw new IllegalArgumentException("Este producto ya existe");
		}*/
		empleado = new Empleado(nombreEmp, apellidos, edad, sueldo, ocupacion);
		empleadoRepository.save(empleado);
		
		return empleado;
	}

	public void editarEmpleado(String nombre, int idEmp, String apellidos, int edad, double sueldo, String ocupacion ) {
		Empleado emp = empleadoRepository.findByidEmp(idEmp);
		
		if(emp == null) {
			throw new IllegalArgumentException("Este producto no existe");
		}
		
		emp.setNombre(nombre);
		emp.setApellidos(apellidos);
		emp.setEdad(edad);
		emp.setSueldo(sueldo);
		emp.setOcupacion(ocupacion);
		
		empleadoRepository.save(emp);
	}
}