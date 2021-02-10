package mx.uam.ayd.proyecto.negocio.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Menu {
	
	@Id
	private int id;
	private String men;
	
	
}
