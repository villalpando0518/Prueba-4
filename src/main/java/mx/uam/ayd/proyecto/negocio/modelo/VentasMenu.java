package mx.uam.ayd.proyecto.negocio.modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class VentasMenu {

	@Id
	private Date fecha;
	private String menu;
	private int ventas;
	
}
