package hibernate.ejemplos.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="TBL_ADDRESS",uniqueConstraints=@UniqueConstraint(columnNames={"ID"} ) )

public class Address implements Serializable{
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true)
	private Long id;
	
	@Column(name = "DIRECCION")
	private String direccion;
	
	@Column(name = "LOCALIDAD")
	private String localidad;
	
	@Column(name = "PROVINCIA")
	private String provincia;
	
	@Column(name = "PAIS")
	private String pais;
	
	/* mapeo bidireccional*/
	@OneToOne(mappedBy = "direccion", fetch = FetchType.LAZY)	
	private Empleado empleado;
	
	
	public Address() {
		
	}

	public Address(String direccion, String localidad, String provincia, String pais) {
	
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	
	
	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", direccion=" + direccion + ", localidad=" + localidad + ", provincia="
				+ provincia + ", pais=" + pais + ", empleado=" + empleado.getCodigo() +  "]";
	}
	
	
	

}
