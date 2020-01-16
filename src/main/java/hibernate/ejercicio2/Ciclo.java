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
@Table(name = "CICLO", uniqueConstraints = @UniqueConstraint(columnNames = { "ID" }))
public class Ciclo implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true)
	private int idCiclo;
	@Column(name="NOMBRE", nullable=false)
    private String nombre;
	@Column(name="HORAS", nullable=false)
    private int horas;

    public Ciclo() {
    }

    public Ciclo( String nombre, int horas) {
        this.nombre = nombre;
        this.horas = horas;
    }

    /**
     * @return the idCiclo
     */
    public int getIdCiclo() {
        return idCiclo;
    }

    /**
     * @param idCiclo the idCiclo to set
     */
    public void setIdCiclo(int idCiclo) {
        this.idCiclo = idCiclo;
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

    /**
     * @return the horas
     */
    public int getHoras() {
        return horas;
    }

    /**
     * @param horas the horas to set
     */
    public void setHoras(int horas) {
        this.horas = horas;
    }


    @Override
    public String toString() {
        return idCiclo+ "-"+nombre;
    }
    
}
