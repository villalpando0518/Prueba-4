package mx.uam.ayd.proyecto.datos;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Recordatorio;
import mx.uam.ayd.proyecto.negocio.modelo.VentasMenu;

public interface VentasMenuRepository extends CrudRepository <VentasMenu, Long>{

}
