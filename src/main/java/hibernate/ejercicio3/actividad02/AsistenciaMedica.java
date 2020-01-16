package hibernate.ejercicio3.actividad02;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *  @description Clase Asistencia Medica
 *	@author Laura y Carlos
 *  @date 1/1/2020
 *  @version 1.2
 *  @license GPLv3
 */
@Entity
@Table(name="ASISTENCIA_MEDICA")
public class AsistenciaMedica {
	
	enum Tipo {HOSPITALARIA,AMBULATORIA,CENTRO_SALUD,DOMICILIARIA};
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID", nullable=false, unique=true)
	private int id;
	private Tipo tipoAsistencia;
	private String lugar;
	private String breveDescripcion;
	private String explicacion;
	private Date fecha;
	private Date hora;
	private BigDecimal importe;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Tipo getTipoAsistencia() {
		return tipoAsistencia;
	}
	public void setTipoAsistencia(Tipo tipoAsistencia) {
		this.tipoAsistencia = tipoAsistencia;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public String getBreveDescripcion() {
		return breveDescripcion;
	}
	public void setBreveDescripcion(String breveDescripcion) {
		this.breveDescripcion = breveDescripcion;
	}
	public String getExplicacion() {
		return explicacion;
	}
	public void setExplicacion(String explicacion) {
		this.explicacion = explicacion;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}
	public BigDecimal getImporte() {
		return importe;
	}
	public void setImporte(BigDecimal importe) {
		this.importe = importe;
	}
	@Override
	public String toString() {
		return "AsistenciaMedica [id=" + id + ", tipoAsistencia="
				+ tipoAsistencia + ", lugar=" + lugar + ", breveDescripcion="
				+ breveDescripcion + ", explicacion=" + explicacion
				+ ", fecha=" + fecha + ", hora=" + hora + ", importe="
				+ importe + "]";
	}
	
	
	

}


