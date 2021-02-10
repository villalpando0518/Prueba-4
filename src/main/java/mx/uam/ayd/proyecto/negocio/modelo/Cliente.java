package mx.uam.ayd.proyecto.negocio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int idCliente;
	 private String nombreCliente;
	 private String correo;
	 
	 //Constructor por defecto
	 public Cliente() {
		 super();
	 }
	
	 //Constructor con parametros
	public Cliente(String nombre, String correo) {
		this.nombreCliente = nombre;
		this.correo = correo;
	}
	
	//Métodos get/set
	public int getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(int idCliente) {
		this.idCliente= idCliente;
	}
	
	public String getNombre() {
		return nombreCliente;
	}
	
	public void setNombre(String nombre) {
		this.nombreCliente = nombre;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	

}
