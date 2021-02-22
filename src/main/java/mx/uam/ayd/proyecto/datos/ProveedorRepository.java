package mx.uam.ayd.proyecto.datos;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Proveedor;

/**
 * @author Panther Zone
 *
 */

public interface ProveedorRepository extends CrudRepository <Proveedor, Long> {

	public List <Proveedor> findAll();
	
	public Proveedor findBynomProveedor(String nomProveedor);
	
	
	public Proveedor findByidProv(int idProv);
}
