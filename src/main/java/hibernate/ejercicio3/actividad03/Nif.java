package hibernate.ejercicio3.actividad03;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *  @description Clase NIF
 *	@author Laura y Carlos
 *  @date 1/1/2020
 *  @version 1.2
 *  @license GPLv3
 */

@Entity
@Table(name="NIF",uniqueConstraints=@UniqueConstraint(columnNames={"ID", "NIF"} ) )
public class Nif {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true)
	private int id;
	private String nif;
	
	public Nif( ) {
		
	}
	
	public Nif(String nif) {
		this.nif = nif;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	
	
	@Override
	public String toString() {
		return "Nif [id=" + id + ", nif=" + nif + "]";
	}
	

}


