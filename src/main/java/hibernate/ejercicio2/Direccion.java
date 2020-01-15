package hibernate.ejercicio2;


import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="DIRECCION",uniqueConstraints=@UniqueConstraint(columnNames={"ID"} ) )
public class Direccion implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true)
    private int id;
    
    @Column(name="CALLE")
    private String calle;
    
    @Column(name="NUMERO")
    private int numero;
    
    @Column(name="POBLACION")
    private String poblacion;
    
    @Column(name="PROVINCIA")
    private String provincia;
    
    
    public Direccion(){ 
    }

    public Direccion(String calle, int numero, String poblacion, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.poblacion = poblacion;
        this.provincia = provincia;
    }

    public Direccion(int id, String calle, int numero, String poblacion, String provincia) {
        this.id = id;
    	this.calle = calle;
        this.numero = numero;
        this.poblacion = poblacion;
        this.provincia = provincia;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * @param calle the calle to set
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * @return the poblacion
     */
    public String getPoblacion() {
        return poblacion;
    }

    /**
     * @param poblacion the poblacion to set
     */
    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    /**
     * @return the provincia
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * @param provincia the provincia to set
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
    
    


	@Override
	public String toString() {
		return "Direccion [id=" + id + ", calle=" + calle + ", numero="
				+ numero + ", poblacion=" + poblacion + ", provincia="
				+ provincia + "]";
	}

    
}
