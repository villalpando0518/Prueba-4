package mx.uam.ayd.proyecto.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.ayd.proyecto.datos.ProveedorRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Proveedor;

/**
 * @author Panther Zone
 *
 */

@Service
public class ServicioProveedor {
	
	@Autowired
	private ProveedorRepository proveedorRepository;
	
/**	Función que regresa una lista de los proveedores ya registrados */
	
	public List<Proveedor> recuperarProveedores() {

		List<Proveedor> proveedores = new ArrayList<>();
		for (Proveedor proveedor : proveedorRepository.findAll()) {
			proveedores.add(proveedor);
		}

		return proveedores;
	}
	
	/**	Función que recibe un nombre de proveedor, una marca, un tipo
	 * y un costo, y regresa un registro (un proveedor nuevo) 
	*/
	public Proveedor crea(String nomProveedor, String marca, String tipo, double costo){
		
		Proveedor proveedor = proveedorRepository.findBynomProveedor(nomProveedor);
		/*if(producto!=null) {
			throw new IllegalArgumentException("Este producto ya existe");
		}*/
		proveedor = new Proveedor(nomProveedor, marca, tipo, costo);
		proveedorRepository.save(proveedor);
		
		return proveedor;
	}
	
	/**	Función que recibe un nombre de proveedor, una id, una marca, un tipo
	 * y actualiza el repository
	*/
	public void editarProveedor(String nomProveedor, int idProv, String marca, String tipo, double costo ) {
		Proveedor prov = proveedorRepository.findByidProv(idProv);
		
		if(prov == null) {
			throw new IllegalArgumentException("Este producto no existe");
		}
		
		prov.setNomProveedor(nomProveedor);
		prov.setMarca(marca);
		prov.setTipo(tipo);
		prov.setCosto(costo);
		
		proveedorRepository.save(prov);
	}
}