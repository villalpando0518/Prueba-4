package mx.uam.ayd.proyecto.datos;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Empleado;

public interface EmpleadoRepository extends CrudRepository <Empleado, Long> {

	public List <Empleado> findAll();
	
	public Empleado findBynombreEmp(String nombre);
	
	
	public Empleado findByidEmp(int idEmp);
}
