package hibernate.ejemplos.asociaciones.onetomanyord_jpa;

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
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 * Clase simple que representa un Empleado
 * 
 * @author Laura
 *
 */
@Entity
@Table(name="Empleado3",uniqueConstraints=@UniqueConstraint(columnNames={"EMPLEADO_ID"} ) )
public class Empleado3 {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="EMPLEADO_ID", nullable=false, unique=true)
	private int id;
	private String nombre;
	private String rol;
	private Date fecha;
	
		
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="EMPLEADO_ID",nullable=false)
	@OrderBy("nombre asc") //Opcional: si queremos ordenar en memoria la lista por un atributo
	private List<Cargo3> cargos;
	
	
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

	public List<Cargo3> getCargos() {
		return cargos;
	}
	public void setCargos(List<Cargo3> cargos) {
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
