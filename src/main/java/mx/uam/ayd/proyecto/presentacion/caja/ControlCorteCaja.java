package mx.uam.ayd.proyecto.presentacion.caja;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.negocio.ServicioCorteCaja;
import mx.uam.ayd.proyecto.negocio.ServicioEmpleado;
import mx.uam.ayd.proyecto.negocio.ServicioOrden;


/**
 * @author Anonimux Corporation
 *
 */
@Component
public class ControlCorteCaja {
	
	@Autowired
	private VentanaCorteCaja ventanaCorteCaja;
	
	@Autowired
	private VentanaCorteCaja2 ventanaCorteCaja2;
	
	@Autowired
	private ServicioOrden servicioOrden;
	
	@Autowired
	private ServicioCorteCaja servicioCorteCaja;
	
	@Autowired
	private ServicioEmpleado servicioEmpleado;
	
	/**
	 * Muestra la ventanaCorteCaja e inicializa sus atributos de clase con los parámetros dados.
	 */
	public void inicia() {
		
		ventanaCorteCaja.muestra(this, servicioOrden.datosTablaCorteCaja());
		
	}
	
	/**
	 * Muestra la ventanaCorteCaja2 e inicializa sus atributos de clase con los parámetros dados.
	 * @param fechaHoy La fecha de hoy que se muestra en la ventana.
	 * @param montoTotal El monto total de corte de caja generado por el sistema de acuerdo a la suma de todos los montos unitarios de las órdenes vendidas en la fecha del sistema con el estado = 3 (PAGADO) del OrdenRepository.
	 */
	public void continuar(String fechaHoy, double montoTotal) {
		
		ventanaCorteCaja2.muestra(this, fechaHoy, montoTotal, servicioEmpleado.recuperarEmpleados());
	}

	/**
	 * Deja de mostrar la ventanaCorteCaja.
	 */
	public void apagaCorte() {
		ventanaCorteCaja.apagar();
		
	}
	
	/**
	 * Manda a guardar la información en la base de datos como un corte de caja
	 * @param corteSistema Corte calculado por el sistema
	 * @param corteReal Corte introducido en la ventana
	 * @param observaciones Guarda notas sobre el corte
	 * @param empleado Nombre del empleado que atendió
	 * @param com Número de comensales 
	 */
	public void creaCorteCaja(double corteSistema, double corteReal, String observaciones, String empleado, int com) {
		servicioCorteCaja.creaCorteCaja(corteSistema, corteReal, observaciones,empleado,com);
		
	}

}
