
package hibernate.ejercicio3.actividad02;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity

@NamedQueries({
	@NamedQuery(name="consulta1",query="SELECT c.direccion,c.proveedor FROM CorreoElectronico c"),
	@NamedQuery(name="consulta2",query="SELECT c.proveedor, count(*) FROM CorreoElectronico c GROUP BY c.proveedor"),
	@NamedQuery(name="consulta3",query="SELECT c.proveedor, count(*) FROM CorreoElectronico c WHERE c.proveedor='gmail' or c.proveedor='yahoo' GROUP BY c.proveedor"),
	@NamedQuery(name="consulta4",query="SELECT c.proveedor, count(*) FROM CorreoElectronico c WHERE c.proveedor=:prov")

	
})
@Table(name="CORREO_ELECTRONICO", 
uniqueConstraints={@UniqueConstraint(columnNames={"ID"})})
public class CorreoElectronico implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
    private String direccion;
    private String proveedor;
    
    
    public CorreoElectronico() {
        
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
		return "Correo [id=" + id + ", direccion=" + direccion + ", proveedor="
				+ proveedor + "]";
	}



	

}
