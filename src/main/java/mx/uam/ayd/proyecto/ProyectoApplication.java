package mx.uam.ayd.proyecto;

import java.sql.Timestamp;
import java.time.LocalDate;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import mx.uam.ayd.proyecto.datos.EmpleadoRepository;
import mx.uam.ayd.proyecto.datos.OrdenRepository;
import mx.uam.ayd.proyecto.datos.ProductoRepository;
import mx.uam.ayd.proyecto.datos.*;
import mx.uam.ayd.proyecto.negocio.modelo.Menu;
import mx.uam.ayd.proyecto.negocio.modelo.Empleado;
import mx.uam.ayd.proyecto.negocio.modelo.Orden;
import mx.uam.ayd.proyecto.negocio.modelo.Producto;
import mx.uam.ayd.proyecto.negocio.modelo.*;
import mx.uam.ayd.proyecto.presentacion.principal.ControlPrincipal;
import mx.uam.ayd.proyecto.presentacion.registrarOrden.ControlRegistrarOrden;
import mx.uam.ayd.proyecto.presentacion.ventasMenu.ControlVentasMenu;

/**
 * @author Panther Zone
 *
 */
@SpringBootApplication
public class ProyectoApplication {

	@Autowired
	ControlPrincipal controlPrincipal;
	
	@Autowired
	ControlRegistrarOrden controlRegistrarPedido;
	
	@Autowired
	OrdenRepository ordenRepository;

	@Autowired 
	ProductoRepository productoRepository;
	
	@Autowired 
	RecordatorioRepository recordatorioRepository;
	
	@Autowired
	EmpleadoRepository empleadoRepository;
	
	@Autowired
	VentasMenuRepository ventasMenuRepository;
	
	@Autowired
	ControlVentasMenu control;
	
	@Autowired 
	MenuRepository menuRepository;
	
	@Autowired
	ProveedorRepository proveedorRepository;
	
	
	/**
	 * Funcion principal
	 * @param args
	 */
	public static void main(String[] args) {
		
		SpringApplicationBuilder builder = new SpringApplicationBuilder(ProyectoApplication.class);

		builder.headless(false);

		builder.run(args);
		
	}

	/**
	 * Carga la BD con datos de prueba
	 */
	@PostConstruct
	public void inicia() {
		
		inicializaBD();
		controlPrincipal.inicia();
	}
	
	
	/**
	 * 
	 * Inicializa la BD con datos 
	 * 
	 * 
	 */
	@SuppressWarnings("deprecation")
	public void inicializaBD() {
		
		/*Registros de Orden*/
		int n1=1;
		String p1="Taco Azteca", p2="Sopa";
		java.util.Date utilDate = new java.util.Date();
		java.util.Date utilDate1 = new java.util.Date();
		utilDate.setMonth(1);
		utilDate.setYear(119);
		utilDate.setMinutes(1);
		utilDate1.setMonth(1);
		utilDate1.setYear(119);
		utilDate1.setMinutes(59);
		long lnMilisegundos = utilDate.getTime();
		long lnMilisegundos1 = utilDate1.getTime()+10;
		Timestamp fecha1= new Timestamp(lnMilisegundos);
		Timestamp fecha2 = new Timestamp(lnMilisegundos+9999999);
		Timestamp fecha3= new Timestamp(lnMilisegundos1);
		Timestamp fecha4 = new Timestamp(lnMilisegundos1+999999);
		Orden orden1 = new Orden(n1,p1, fecha1, fecha2, 60, 3);
		Orden orden2 = new Orden(n1,p2, fecha3, fecha4, 30, 3);
		orden1.setEstado(3);
		orden2.setEstado(3);
		ordenRepository.save(orden1);
		ordenRepository.save(orden2);
		
		/*Registros de producto*/
		Producto producto1 = new Producto();
		producto1.setFecha("2020-05-10");
		producto1.setNombreProducto("Chiles Verdes");
		producto1.setDescripcion("Bolsas de 1 kg de Chiles");
		producto1.setCantidad(15);
		producto1.setMinimo(20);
		productoRepository.save(producto1);
		
		Producto producto2 = new Producto();
		producto2.setFecha("2020-10-05");
		producto2.setNombreProducto("Papas");
		producto2.setDescripcion("Costal de 32 Kg de papas");
		producto2.setCantidad(58);
		producto2.setMinimo(10);
		productoRepository.save(producto2);
		
		Producto producto3 = new Producto();
		producto3.setFecha("2020-10-20");
		producto3.setNombreProducto("Frijoles");
		producto3.setDescripcion("Costales de 13 kg de Frijoles");
		producto3.setCantidad(2);
		producto3.setMinimo(20);
		productoRepository.save(producto3);
		
		Producto producto4 = new Producto();
		producto4.setFecha("2020-08-16");
		producto4.setNombreProducto("Sopa de fideo");
		producto4.setDescripcion("Bolsas de 500g de sopa de fideo");
		producto4.setCantidad(8);
		producto4.setMinimo(10);
		productoRepository.save(producto4);
		
		//Registro de recordatorio
		
		Recordatorio recordatorio = new Recordatorio();
		recordatorio.setId(1);
		recordatorio.setInfo("1. A partir de mañana se empezará a ofrecer los \n"
				+ "beneficios para los clientes preferenciales\n"
				+ "2. Los empleados que no se han registrado para \n"
				+ "algo algotienen hasta el 25 de Julio para \n"
				+ "registrarse.");
		recordatorioRepository.save(recordatorio);
		
		Empleado empleado1 = new Empleado();
		empleado1.setNombre("Paola");
		empleado1.setApellidos("Aguillón");
		empleado1.setEdad(24);
		empleado1.setSueldo(2120.50);
		empleado1.setOcupacion("Mesera");
		empleadoRepository.save(empleado1);
		
		Empleado empleado2 = new Empleado();
		empleado2.setNombre("Jorge");
		empleado2.setApellidos("Luna");
		empleado2.setEdad(20);
		empleado2.setSueldo(2599.50);
		empleado2.setOcupacion("Cocinero");
		empleadoRepository.save(empleado2);
		
		Empleado empleado3 = new Empleado();
		empleado3.setNombre("Mariana");
		empleado3.setApellidos("Mendoza");
		empleado3.setEdad(32);
		empleado3.setSueldo(1810.80);
		empleado3.setOcupacion("Ayudante general");
		empleadoRepository.save(empleado3);
		
		Empleado empleado4 = new Empleado();
		empleado4.setNombre("Diego");
		empleado4.setApellidos("Ayala");
		empleado4.setEdad(28);
		empleado4.setSueldo(3560.60);
		empleado4.setOcupacion("Chef");
		empleadoRepository.save(empleado4);
		//Registro Ventas de menú
		
		VentasMenu dia1 = new VentasMenu();
		dia1.setFecha(LocalDate.of(2021,02,01));
		dia1.setMenu("Tacos,Sopa de papa, Agua de limón");
		dia1.setVentas(20);
		ventasMenuRepository.save(dia1);
		
		VentasMenu dia2 = new VentasMenu();
		dia2.setFecha(LocalDate.of(2021,02,02));
		dia2.setMenu("Tortas de papa,Sopa de verdura, Agua de piña");
		dia2.setVentas(22);
		ventasMenuRepository.save(dia2);
		
		VentasMenu dia21 = new VentasMenu();
		dia21.setFecha(LocalDate.of(2021,02,03));
		dia21.setMenu("Tortas de papa,Sopa de tortilla, Agua de mango");
		dia21.setVentas(25);
		ventasMenuRepository.save(dia21);
		
		VentasMenu dia211 = new VentasMenu();
		dia211.setFecha(LocalDate.of(2021,02,04));
		dia211.setMenu("Papas a la francesa,sopa de arroz, Agua de jamaica ");
		dia211.setVentas(30);
		ventasMenuRepository.save(dia211);
		
		
		
		//Registro de menú
		
		Menu menu = new Menu();
		menu.setId(1);
		menu.setMen("Sopa \n"
				+ "Consome\n"
				+ "Arroz\n"
				+ "Pasta\n"
				+ "Chile relleno \n"
				+ "Taco Azteca \n"
				+ "Filete de Pescado empanizado"
		        + "Enchiladas\n"
		        + "Gelatina\n"
		        + "Flan\n");
		
		menuRepository.save(menu);
		
		//Registro de algunos proveedores
		
		Proveedor proveedor1 = new Proveedor();
		proveedor1.setNomProveedor("Aaron");
		proveedor1.setMarca("Alpura");
		proveedor1.setTipo("Embutidos y lacteos");
		proveedor1.setCosto(4600);
		proveedorRepository.save(proveedor1);
		
		Proveedor proveedor2 = new Proveedor();
		proveedor2.setNomProveedor("Angelica");
		proveedor2.setMarca("Coca-Cola");
		proveedor2.setTipo("Bebidas");
		proveedor2.setCosto(1810.11);
		proveedorRepository.save(proveedor2);
		
		Proveedor proveedor3 = new Proveedor();
		proveedor3.setNomProveedor("Ernesto");
		proveedor3.setMarca("Patito");
		proveedor3.setTipo("Productos de limpieza");
		proveedor3.setCosto(2455.80);
		proveedorRepository.save(proveedor3);
		
		
	}
	
}
