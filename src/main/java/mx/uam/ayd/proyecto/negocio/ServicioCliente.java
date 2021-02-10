package mx.uam.ayd.proyecto.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.ayd.proyecto.datos.ClienteRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Cliente;


@Service
public class ServicioCliente {

	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> recuperarCliente() {

		List<Cliente> clientes = new ArrayList<>();
		for (Cliente cliente : clienteRepository.findAll()) {
			clientes.add(cliente);
		}

		return clientes;
	}

	public Cliente crea(String nombreCliente, String correo){
		
		Cliente cliente = clienteRepository.findBynombreCliente(nombreCliente);
		
		cliente = new Cliente(nombreCliente, correo);
		clienteRepository.save(cliente);
		
		return cliente;
	}

	public void Guardar(Cliente cliente) {
		clienteRepository.save(cliente);
 }
}
