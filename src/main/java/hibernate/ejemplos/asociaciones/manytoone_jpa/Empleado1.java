package hibernate.ejemplos.asociaciones.manytoone_jpa;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 * Clase simple que representa un Empleado
 * 
 * @author Laura
 *
 */
@Entity
@Table(name="Empleado1",uniqueConstraints=@UniqueConstraint(columnNames={"ID"} ) )
public class Empleado1 {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true)
	private int id;
	private String nombre;
	private String rol;
	private Date fecha;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CARGO_ID") //Columna para el join	 
	private Cargo1 cargo;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Cargo1 getCargo() {
		return cargo;
	}
	public void setCargo(Cargo1 cargo) {
		this.cargo = cargo;
	}
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", rol=" + rol
				+ ", fecha=" + fecha + ", cargo=" + cargo.toString() + "]";
	}
	
	
	

}
