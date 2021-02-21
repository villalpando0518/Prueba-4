package mx.uam.ayd.proyecto.negocio;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uam.ayd.proyecto.datos.SugerenciaRepository;
import mx.uam.ayd.proyecto.negocio.modelo.Sugerencia;


@Service
public class ServicioSugerencia {
	
	@Autowired
	private SugerenciaRepository sugerenciaRepository;
	
	//regresa una lista con las sugerencias 
	
	public List<Sugerencia> recuperarSugerencia() {

		List<Sugerencia> sugerencias = new ArrayList<>();
		for (Sugerencia sugerencia : sugerenciaRepository.findAll()) {
			sugerencias.add(sugerencia);
		}

		return sugerencias;
	}

	// recibe una nueva sugerencia y lo regresa como una sugerencia
	public Sugerencia crea(String nombreCliente, String sugerenciamenu){
		
		Sugerencia sugerencia = sugerenciaRepository.findBynombreCliente(nombreCliente);
		
		sugerencia = new Sugerencia(nombreCliente, sugerenciamenu);
		sugerenciaRepository.save(sugerencia);
		
		return sugerencia;
	}

// Guarda la sugerencia que recibe 	
	public void Guardar(Sugerencia sugerencia) {
		sugerenciaRepository.save(sugerencia);
 }

}
