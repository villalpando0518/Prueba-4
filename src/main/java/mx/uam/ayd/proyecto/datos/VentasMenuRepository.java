package mx.uam.ayd.proyecto.datos;




import java.time.LocalDate;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.VentasMenu;

public interface VentasMenuRepository extends CrudRepository <VentasMenu, LocalDate>{

	public VentasMenu findByFecha(LocalDate fecha);
}
