package hibernate.ejemplos.asociaciones.onetomanyind_jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 * Clase simple que representa un Empleado
 * 
 * @author Laura
 *
 */
@Entity
@Table(name="Empleado2",uniqueConstraints=@UniqueConstraint(columnNames={"EMPLEADO_ID"} ) )
public class Empleado2 {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EMPLEADO_ID", nullable=false, unique=true)
	private int id;
	private String nombre;
	private String rol;
	private Date fecha;
	
		
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="EMPLEADO_ID",nullable=false)
	@OrderColumn(name="cargos_index")
	private List<Cargo2> cargos;
	
	
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

	public List<Cargo2> getCargos() {
		return cargos;
	}
	public void setCargos(List<Cargo2> cargos) {
		this.cargos = cargos;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", rol=" + rol
				+ ", fecha=" + fecha + ", cargos=" + cargos + "]";
	}
	
	
	
	

}
