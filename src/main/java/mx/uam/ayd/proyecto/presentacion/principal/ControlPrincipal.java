package mx.uam.ayd.proyecto.presentacion.principal;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import mx.uam.ayd.proyecto.presentacion.caja.ControlCorteCaja;
import mx.uam.ayd.proyecto.presentacion.cocina.ControlCocina;
import mx.uam.ayd.proyecto.presentacion.empleados.ControlEmpleados;
import mx.uam.ayd.proyecto.presentacion.informeInventario.ControlInformeInventario;
import mx.uam.ayd.proyecto.presentacion.inventarioCocina.ControlInventarioCocina;
import mx.uam.ayd.proyecto.presentacion.mesas.ControlMesas;
import mx.uam.ayd.proyecto.presentacion.realizarPedido.ControlRealizarPedido;
import mx.uam.ayd.proyecto.presentacion.recordatorios.ControlRecordatorio;
import mx.uam.ayd.proyecto.presentacion.registrarEmpleado.ControlRegistrarEmpleado;

/**
 * @author Anonymux Corporation
 *
 */
@Component
public class ControlPrincipal {
	
	@Autowired
	private VentanaPrincipal ventana;
	
	@Autowired
	private ControlMesas controlMesas;
	
	@Autowired
	private ControlCocina controlCocina;
	
	@Autowired
	private ControlRealizarPedido controlRealizarPedido;
	
	@Autowired
	private ControlInformeInventario controlInformeInventario;
	
	@Autowired
	private ControlCorteCaja controlCorteCaja;
	
	@Autowired
	private ControlInventarioCocina controlInventarioCocina;
	
	//yo e.e
	@Autowired
	private ControlRecordatorio controlRecordatorios;
	
	@Autowired
	private ControlEmpleados controlEmpleados;

	/**
	 * Lleva el flujo de control hacia la ventana principal
	 * 
	 */
	public void inicia() {

		ventana.muestra(this);
		
		//yo
		
		controlRecordatorios.inicia();
		
	}
	
	/**
	 * Inicia el flujo de controlMesa
	 */
	public void mesas() {
		controlMesas.inicia();
	}
	
	/**
	 * Inicia el flujo de controlCocina
	 */
	public void cocina() {
		controlCocina.inicia();
	}
	
	/**
	 * Inicia el flujo de controlCorteCaja
	 */
	public void caja() {
		controlCorteCaja.inicia();
	}
	
	/**
	 * Inicia el flujo de realizarPedido
	 */
	public void realizarPedido() {
		controlRealizarPedido.inicia();
	}
	
	/**
	 * Inicia el flujo de informeInventario
	 */
	public void informeInventario() {
		controlInformeInventario.inicia();
	}
	
	/**
	 * Inicia el flujo de controlInventario
	 */
	public void inventarioCocina() {
		controlInventarioCocina.inicia();
		
	}
	
	public void Empleados() {
		controlEmpleados.inicia();
	}
	
	public void agregarRecordatorio() {
		controlRecordatorios.iniciaNuevo();
	}
}
