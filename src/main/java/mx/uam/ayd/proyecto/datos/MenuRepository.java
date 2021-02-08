package mx.uam.ayd.proyecto.datos;
import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Menu;
import java.util.List;


public interface MenuRepository extends CrudRepository <Menu, Long>{
	
	public List <Menu> findAll();
	public Menu findById(int id);
	
	
	
}