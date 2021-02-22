package mx.uam.ayd.proyecto.datos;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Sugerencia;

// repositorio para agregar una sugerencia para el menú

public interface SugerenciaRepository extends CrudRepository <Sugerencia, Long> {
	
    public Sugerencia findBynombreCliente(String nombre);
	
	
	public Sugerencia findByidSugerencia(int idSugerencia);

}
