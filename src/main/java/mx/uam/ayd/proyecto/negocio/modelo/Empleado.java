package mx.uam.ayd.proyecto.negocio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Empleado {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int idEmp;
	 private String nombreEmp;
	 private String apellidos;
	 private int edad;
	 private double sueldo;
	 private String ocupacion;
	 
	 //Constructor por defecto
	 public Empleado() {
		 super();
	 }
	
	 //Constructor con parametros
	public Empleado(String nombre, String apellidos, int edad, double sueldo, String ocupacion) {
		this.nombreEmp = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
		this.sueldo = sueldo;
		this.ocupacion = ocupacion;
	}
	
	//Métodos get/set
	public int getIdEmp() {
		return idEmp;
	}
	
	public void setIdEmp(int idEmp) {
		this.idEmp= idEmp;
	}
	
	public String getNombre() {
		return nombreEmp;
	}
	
	public void setNombre(String nombre) {
		this.nombreEmp = nombre;
	}
	
	public String getApellidos() {
		return apellidos;
	}
	
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public double getSueldo() {
		return sueldo;
	}
	
	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}
	
	public String getOcupacion() {
		return ocupacion;
	}
	
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

}
