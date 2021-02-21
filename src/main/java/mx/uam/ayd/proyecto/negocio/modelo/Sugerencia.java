package mx.uam.ayd.proyecto.negocio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sugerencia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int idSugerencia;
	 private String nombreCliente;
     private String Sugerencia;
	 
	 //Constructor por defecto
	 public Sugerencia() {
		 super();
	 }
	
	 //Constructor con parametros
	public Sugerencia(String nombre, String sugerencia) {
		this.nombreCliente = nombre;
		this.Sugerencia = sugerencia;
	}
	
	//Métodos get/set
	public int getIdSugerencia() {
		return idSugerencia;
	}
	
	public void setIdSugeregncia(int idSugerencia) {
		this.idSugerencia= idSugerencia;
	}
	
	public String getNombre() {
		return nombreCliente;
	}
	
	public void setNombre(String nombre) {
		this.nombreCliente = nombre;
	}
	
	public String getSugerencia() {
		return Sugerencia;
	}
	
	public void setSugerencia(String sugerencia) {
		this.Sugerencia = sugerencia;
	}

}
