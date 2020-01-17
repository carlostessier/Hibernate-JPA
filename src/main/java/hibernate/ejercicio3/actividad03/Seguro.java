package hibernate.ejercicio3.actividad03;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import hibernate.ejemplos.autor.modelo.Libro;


/**
 *  @description Clase que representa un seguro
 *	@author Laura y Carlos
 *  @date 1/1/2020
 *  @version 1.2
 *  @license GPLv3
 */

@Entity
@NamedQueries({
	@NamedQuery(name="consultaSeguro1",query="from Seguro"),
	@NamedQuery(name="consultaSeguro2",query="SELECT s.nombre, s.nif.nif from Seguro s"),
	@NamedQuery(name="consultaSeguro3",query="SELECT s.nif.nif from Seguro s WHERE s.nombre=:nom AND s.ape1=:ap1 AND s.ape2=:ap2"),
	@NamedQuery(name="consultaSeguro8",query="SELECT COUNT(*) from Seguro"),
	@NamedQuery(name="consultaSeguro9",query="SELECT s.nombre, s.nif.nif, SIZE(s.asistencias) from Seguro s GROUP BY s.idSeguro"),
	@NamedQuery(name="consultaSeguro10",query="SELECT s.idSeguro, s.enfermedades.nombreAlergia from Seguro s")

})
@Table(name="SEGURO")
public class Seguro  implements Serializable  {
	
	private static final long serialVersionUID = 3855840249891406328L;

	
	enum Sexo {HOMBRE,MUJER};
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true)
	private int idSeguro;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_NIF",referencedColumnName = "ID") //Columna para el join	
	private Nif nif;
	
	private String nombre;
	
	private String ape1;
	
	private String ape2;
	
	private int edad;
	
	private int numHijos;	
	
	private Sexo sexo;
	
	private boolean casado;
	
	private boolean embarazada;
	
	@Column(name="FECHACREACION")
	private Date fechaCreacion;
	
	@OneToMany(mappedBy = "seguro",cascade = CascadeType.ALL)
	//@JoinColumn(name="ASISTENCIA_ID")
	private List<AsistenciaMedica> asistencias = new ArrayList<AsistenciaMedica>();
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "COBERTURAS_ID") //Columna para el join	
	private Coberturas coberturas;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ENFERMEDADES_ID") //Columna para el join	
	private Enfermedades enfermedades;
	
	public Seguro() {
		
	}
	
	public Seguro(Nif nif, String nombre, String ape1, String ape2, int edad, int numHijos, Sexo sexo, boolean casado,
			boolean embarazada, Date fechaCreacion, List<AsistenciaMedica> asistencias, Coberturas coberturas,
			Enfermedades enfermedades) {
		this.nif = nif;
		this.nombre = nombre;
		this.ape1 = ape1;
		this.ape2 = ape2;
		this.edad = edad;
		this.numHijos = numHijos;
		this.sexo = sexo;
		this.casado = casado;
		this.embarazada = embarazada;
		this.fechaCreacion = fechaCreacion;
		this.asistencias = asistencias;
		this.coberturas = coberturas;
		this.enfermedades = enfermedades;
	}
	public int getIdSeguro() {
		return idSeguro;
	}
	public void setIdSeguro(int idSeguro) {
		this.idSeguro = idSeguro;
	}
	public Nif getNif() {
		return nif;
	}
	public void setNif(Nif nif) {
		this.nif = nif;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApe1() {
		return ape1;
	}
	public void setApe1(String ape1) {
		this.ape1 = ape1;
	}
	public String getApe2() {
		return ape2;
	}
	public void setApe2(String ape2) {
		this.ape2 = ape2;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getNumHijos() {
		return numHijos;
	}
	public void setNumHijos(int numHijos) {
		this.numHijos = numHijos;
	}
	public Sexo getSexo() {
		return sexo;
	}
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	public boolean isCasado() {
		return casado;
	}
	public void setCasado(boolean casado) {
		this.casado = casado;
	}
	public boolean isEmbarazada() {
		return embarazada;
	}
	public void setEmbarazada(boolean embarazada) {
		this.embarazada = embarazada;
	}
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public List<AsistenciaMedica> getAsistencias() {
		return asistencias;
	}
	public void setAsistencias(List<AsistenciaMedica> asistencias) {
		this.asistencias = asistencias;
	}
	public Coberturas getCoberturas() {
		return coberturas;
	}
	public void setCoberturas(Coberturas coberturas) {
		this.coberturas = coberturas;
	}
	public Enfermedades getEnfermedades() {
		return enfermedades;
	}
	public void setEnfermedades(Enfermedades enfermedades) {
		this.enfermedades = enfermedades;
	}
	@Override
	public String toString() {
		return "Seguro [idSeguro=" + idSeguro + ", nif=" + nif + ", nombre="
				+ nombre + ", ape1=" + ape1 + ", ape2=" + ape2 + ", edad="
				+ edad + ", numHijos=" + numHijos + ", sexo=" + sexo
				+ ", casado=" + casado + ", embarazada=" + embarazada
				+ ", fechaCreacion=" + fechaCreacion + ", asistencias="
				+ asistencias + ", coberturas=" + coberturas
				+ ", enfermedades=" + enfermedades + "]";
	}
	
	
	
	
	
	
	
	

}


