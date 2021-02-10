package mx.uam.ayd.proyecto.negocio.modelo;


import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class VentasMenu {

	@Id
	private LocalDate fecha;
	private String menu;
	private int ventas;
	
}
