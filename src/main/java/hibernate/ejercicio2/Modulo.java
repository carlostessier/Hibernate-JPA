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
@Table(name = "Modulo", uniqueConstraints = @UniqueConstraint(columnNames = { "ID" }))
public class Modulo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)
	private int id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "creditos")
	private float creditos;

	public Modulo() {

	}

	public Modulo(int id, String nombre, float creditos) {
		this.id = id;
		this.nombre = nombre;
		this.creditos = creditos;
	}

	
	public Modulo(String nombre, float creditos) {
		this.nombre = nombre;
		this.creditos = creditos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getCreditos() {
		return creditos;
	}

	public void setCreditos(float creditos) {
		this.creditos = creditos;
	}

	@Override
	public String toString() {
		return "Modulo [idModulo=" + id + ", nombre=" + nombre + ", creditos=" + creditos + "]";
	}

}
