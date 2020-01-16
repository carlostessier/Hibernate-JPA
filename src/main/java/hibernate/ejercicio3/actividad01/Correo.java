
package hibernate.ejercicio3.actividad01;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import hibernate.ejercicio3.actividad01.ProfesorDireccion;

@Entity
@Table(name = "Correo", uniqueConstraints = @UniqueConstraint(columnNames = { "ID" }))
public class Correo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private int id;
	
	private String direccion;
	
	private String proveedor;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "PROFESOR_DIRECCION_ID") //Columna para el join	 
  	@OrderBy("direccion asc") //Opcional: si queremos ordenar en memoria la lista por un atributo
	private ProfesorDireccion profesor;

	public Correo(ProfesorDireccion profesor, String direccion, String proveedor) {
		this.direccion = direccion;
		this.proveedor = proveedor;
		this.profesor = profesor;
	}

	public Correo() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getProveedor() {
		return proveedor;
	}

	public void setProveedor(String proveedor) {
		this.proveedor = proveedor;
	}

	
	
	public ProfesorDireccion getProfesor() {
		return profesor;
	}

	public void setProfesor(ProfesorDireccion profesor) {
		this.profesor = profesor;
	}

	@Override
	public String toString() {
		return "Correo [id=" + id + ", direccion=" + direccion + ", proveedor=" + proveedor + "]";
	}

}
