package hibernate.ejercicio2;

import java.io.Serializable;

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

import hibernate.ejercicio3.actividad01.Municipio;

@Entity
@Table(name="DIRECCION",uniqueConstraints=@UniqueConstraint(columnNames={"ID"} ) )
public class Direccion implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true)
	private int id;
	
    @Column(name="CALLE")
	private String calle;
    
    @Column(name="NUMERO")
	private int numero;
    
    @Column(name="PROVINCIA")
    
	private String provincia;
    @ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "MUNICIPIO_ID") //Columna para el join	
	private Municipio municipio;

    public Direccion( String calle, int numero, String provincia ) {
		this(calle, numero, provincia, null);
	}

    
	public Direccion( String calle, int numero, String provincia, Municipio municipio) {
		this.calle = calle;
		this.numero = numero;
		this.provincia = provincia;
		this.municipio = municipio;
	}


	public Direccion() {
	}

	
	public Municipio getMunicipio() {
		return municipio;
	}


	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
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
	 * @param calle
	 *            the calle to set
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
	 * @param numero
	 *            the numero to set
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}

	/**
	 * @return the provincia
	 */
	public String getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia
	 *            the provincia to set
	 */
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	@Override
	public String toString() {
		return "Direccion [id=" + id + ", calle=" + calle + ", numero="
				+ numero + ", provincia=" + provincia + ", municipio="
				+ municipio + "]";
	}

	

}
