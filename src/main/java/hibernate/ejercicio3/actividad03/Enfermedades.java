package hibernate.ejercicio3.actividad03;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *  @descrition
 *	@author Laura
 *  @date 3/6/2015
 *  @version 1.0
 *  @license GPLv3
 */
@Entity
@Table(name="ENFERMEDADES")
public class Enfermedades {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true)
	private int id;
	private boolean corazon;
	private boolean estomacal;
	private boolean rinones;
	private boolean alergia;
	private String nombreAlergia;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isCorazon() {
		return corazon;
	}
	public void setCorazon(boolean corazon) {
		this.corazon = corazon;
	}
	public boolean isEstomacal() {
		return estomacal;
	}
	public void setEstomacal(boolean estomacal) {
		this.estomacal = estomacal;
	}
	public boolean isRinones() {
		return rinones;
	}
	public void setRinones(boolean rinones) {
		this.rinones = rinones;
	}
	public boolean isAlergia() {
		return alergia;
	}
	public void setAlergia(boolean alergia) {
		this.alergia = alergia;
	}
	public String getNombreAlergia() {
		return nombreAlergia;
	}
	public void setNombreAlergia(String nombreAlergia) {
		this.nombreAlergia = nombreAlergia;
	}
	@Override
	public String toString() {
		return "Enfermedades [id=" + id + ", corazon=" + corazon
				+ ", estomacal=" + estomacal + ", rinones=" + rinones
				+ ", alergia=" + alergia + ", nombreAlergia=" + nombreAlergia
				+ "]";
	}
	
	

}


