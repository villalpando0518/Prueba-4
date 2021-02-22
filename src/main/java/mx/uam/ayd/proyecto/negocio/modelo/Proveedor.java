package mx.uam.ayd.proyecto.negocio.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Panther Zone
 *
 */

@Entity
public class Proveedor {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int idProv;
	 private String nomProveedor;
	 private String marca;
	 private String tipo;
	 private double costo;
	 
	 //Constructor por defecto
	 public Proveedor() {
		 super();
	 }
	
	 //Constructor con parametros
	public Proveedor(String nomProveedor, String marca, String tipo, double costo) {
		this.nomProveedor = nomProveedor;
		this.marca = marca;
		this.tipo = tipo;
		this.costo = costo;
	}
	
	//Métodos get/set
	public int getIdProv() {
		return idProv;
	}
	
	public void setIdProv(int idProv) {
		this.idProv= idProv;
	}
	
	public String getNomProveedor() {
		return nomProveedor;
	}
	
	public void setNomProveedor(String nomProveedor) {
		this.nomProveedor = nomProveedor;
	}
	
	public String getMarca() {
		return marca;
	}
	
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public double getCosto() {
		return costo;
	}
	
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
}
