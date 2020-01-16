
package hibernate.ejercicio2;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "Email", uniqueConstraints = @UniqueConstraint(columnNames = { "ID" }))
public class Email implements Serializable {
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
	

	public Email(String direccion, String proveedor) {
		this.direccion = direccion;
		this.proveedor = proveedor;
	}

	public Email() {

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

	
	


	@Override
	public String toString() {
		return "Correo [id=" + id + ", direccion=" + direccion + ", proveedor=" + proveedor + "]";
	}

}
