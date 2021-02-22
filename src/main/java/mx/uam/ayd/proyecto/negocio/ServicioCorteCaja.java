package mx.uam.ayd.proyecto.negocio;


import java.sql.Timestamp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.ayd.proyecto.datos.CorteCajaRepository;

import mx.uam.ayd.proyecto.negocio.modelo.CorteCaja;

/**
 * Servicio de los corte de cajas
 * @author Zock
 *
 */
@Service
public class ServicioCorteCaja {
	
	@Autowired 
	private CorteCajaRepository corteCajaRepository;
	
	/**
	 * Crea un nuevo objeto corte de caja y lo guarda en la base de datos
	 * @param corteSistema
	 * @param corteReal
	 * @param observaciones
	 * @param empleado
	 * @param comensales
	 */
	public void creaCorteCaja(double corteSistema, double corteReal, String observaciones, String empleado, int comensales){
		CorteCaja corteCaja = new CorteCaja(corteSistema, corteReal, fechaHoy(), observaciones);
		corteCaja.setEmpleado(empleado);
		corteCaja.setComensales(comensales);
		corteCajaRepository.save(corteCaja);
	}
	
	public Timestamp fechaHoy() {
		java.util.Date utilDate = new java.util.Date();
		long lnMilisegundos = utilDate.getTime();
		Timestamp fechaHoy = new Timestamp(lnMilisegundos);
		return fechaHoy;
	}
	
}
