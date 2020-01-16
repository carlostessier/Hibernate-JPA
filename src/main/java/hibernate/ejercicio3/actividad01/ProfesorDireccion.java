package hibernate.ejercicio3.actividad01;


import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import hibernate.ejercicio2.Direccion;
import hibernate.ejercicio2.Email;

@Entity
@Table(name="PROFESOR_DIRECCION",uniqueConstraints=@UniqueConstraint(columnNames={"ID"} ) )
public class ProfesorDireccion implements Serializable  {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true)
    private int id;    
       
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "DIRECCION_ID",referencedColumnName = "ID") //Columna para el join	
    private Direccion direccion;
    
    @OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "NOMBRE_ID") //Columna para el join	 
    private Nombre nombre;

    @OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="PROFESOR_DIRECCION_ID",nullable=false,insertable=false, updatable =false)
	private List<Correo> correos;

    
    public ProfesorDireccion(){ 
    }

    public ProfesorDireccion( Direccion direccion, Nombre nombre) {
        this.direccion = direccion;
        this.nombre = nombre;      
    }
    
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the nombre
     */
    public Nombre getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(Nombre nombre) {
        this.nombre = nombre;
    }




    /**
     * @return the direccion
     */
    public Direccion getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

	@Override
	public String toString() {
		return "ProfesorDireccion [id=" + id + ", direccion=" + direccion + ", nombre=" + nombre + ", correos="
				+ correos + "]";
	}





	

	


    
}
