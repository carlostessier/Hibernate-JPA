package hibernate.ejercicio3.actividad01;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="MUNICIPIO",uniqueConstraints=@UniqueConstraint(columnNames={"ID"} ) )
public class Municipio implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true)
	private int idMunicipio;
	
    @Column(name="COD_PROVINCIA")
    private String codProvincia;
    
    @Column(name="COD_MUNICIPIO")
    private String codMunicipio;
    
    @Column(name="NOMBRE")
    private String nombre;
    
    

    public Municipio(String codProvincia, String codMunicipio, String nombre) {
		super();
		this.codProvincia = codProvincia;
		this.codMunicipio = codMunicipio;
		this.nombre = nombre;
	}

	public Municipio() {
    }

      /**
     * @return the idMunicipio
     */
    public int getIdMunicipio() {
        return idMunicipio;
    }

    /**
     * @param idMunicipio the idMunicipio to set
     */
    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    /**
     * @return the codProvincia
     */
    public String getCodProvincia() {
        return codProvincia;
    }

    /**
     * @param codProvincia the codProvincia to set
     */
    public void setCodProvincia(String codProvincia) {
        this.codProvincia = codProvincia;
    }

    /**
     * @return the codMunicipio
     */
    public String getCodMunicipio() {
        return codMunicipio;
    }

    /**
     * @param codMunicipio the codMunicipio to set
     */
    public void setCodMunicipio(String codMunicipio) {
        this.codMunicipio = codMunicipio;
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

    public String toString() {
        return idMunicipio + "." + nombre;
    }
}
