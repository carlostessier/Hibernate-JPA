package hibernate.ejemplos.asociaciones.onetoonefk_jpa;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 * Clase simple que representa un Empleado
 * 
 * @author Laura
 *
 */
@Entity
@Table(name="Empleado5",uniqueConstraints=@UniqueConstraint(columnNames={"ID"} ) )
public class Empleado5 {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true)
	private int id;
	private String nombre;
	private String rol;
	private Date fecha;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CARGO_ID") //Columna para el join, (one-to-many associations, the foreign key column is nullable by default) one-to-one, many.to-one  parece que lo toma a false 	 
	private Cargo5 cargo;
	
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
	public Cargo5 getCargo() {
		return cargo;
	}
	public void setCargo(Cargo5 cargo) {
		this.cargo = cargo;
	}
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", rol=" + rol
				+ ", fecha=" + fecha + ", cargo=" + cargo.toString() + "]";
	}
	
	
	

}
