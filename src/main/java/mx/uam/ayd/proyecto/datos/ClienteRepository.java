package mx.uam.ayd.proyecto.datos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import mx.uam.ayd.proyecto.negocio.modelo.Cliente;


public interface ClienteRepository extends CrudRepository <Cliente, Long> {
	
	public Cliente findBynombreCliente(String nombre);

	public List <Cliente> findAll();
	
	public Cliente findByidCliente(int idCliente);

}
