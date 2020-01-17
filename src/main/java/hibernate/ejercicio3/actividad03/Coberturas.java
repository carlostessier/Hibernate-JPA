package hibernate.ejercicio3.actividad03;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *  @description clase Coberturas
 *	@author Laura y Carlos
 *  @date 1/1/2020
 *  @version 1.2
 *  @license GPLv3
 */

@Entity
@Table(name="COBERTURAS")
public class Coberturas {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true)
	private int id;
	private boolean oftalmologia;
	private boolean dental;
	private boolean fecundacionInVitro;
	public boolean isOftalmologia() {
		return oftalmologia;
	}
	public void setOftalmologia(boolean oftalmologia) {
		this.oftalmologia = oftalmologia;
	}
	public boolean isDental() {
		return dental;
	}
	public void setDental(boolean dental) {
		this.dental = dental;
	}
	public boolean isFecundacionInVitro() {
		return fecundacionInVitro;
	}
	public void setFecundacionInVitro(boolean fecundacionInVitro) {
		this.fecundacionInVitro = fecundacionInVitro;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Coberturas [id=" + id + ", oftalmologia=" + oftalmologia
				+ ", dental=" + dental + ", fecundacionInVitro="
				+ fecundacionInVitro + "]";
	}
	
	
}


