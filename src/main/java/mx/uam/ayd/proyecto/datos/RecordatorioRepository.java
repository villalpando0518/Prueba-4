package mx.uam.ayd.proyecto.datos;
import org.springframework.data.repository.CrudRepository;


import mx.uam.ayd.proyecto.negocio.modelo.Recordatorio;

import java.util.List;


public interface RecordatorioRepository extends CrudRepository <Recordatorio, Long>{
	
	public List <Recordatorio> findAll();
	public Recordatorio findById(int id);
	
	
	
}
