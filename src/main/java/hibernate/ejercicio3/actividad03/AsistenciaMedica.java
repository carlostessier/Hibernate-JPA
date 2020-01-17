package hibernate.ejercicio3.actividad03;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @description Clase Asistencia Medica
 * @author Laura y Carlos
 * @date 1/1/2020
 * @version 1.2
 * @license GPLv3
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "consultaSeguro4", query = "SELECT a.id,a.importe from AsistenciaMedica a WHERE a.importe>10000"),
		@NamedQuery(name = "consultaSeguro5", query = "SELECT a.id,a.importe from AsistenciaMedica a WHERE a.importe>:imp1 AND a.importe<:imp2"),
		@NamedQuery(name = "consultaSeguro6", query = "SELECT SUM(a.importe) from AsistenciaMedica a"),
		@NamedQuery(name = "consultaSeguro7", query = "SELECT AVG(a.importe) from AsistenciaMedica a")

})
@Table(name = "ASISTENCIA_MEDICA")
public class AsistenciaMedica {

	enum Tipo {
		HOSPITALARIA, AMBULATORIA, CENTRO_SALUD, DOMICILIARIA
	};

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, unique = true)	
	private int id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipoAsistencia")
	private Tipo tipoAsistencia;
	private String lugar;
	private String breveDescripcion;
	private String explicacion;
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha")
	private Date fecha;
	@Temporal(TemporalType.TIME)
	@Column(name = "hora")
	private Date hora;
	private BigDecimal importe;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "SEGURO_ID", referencedColumnName = "ID") // Columna para el join
	private Seguro seguro;

	public AsistenciaMedica() {
		
	}
	
	public AsistenciaMedica(Tipo tipoAsistencia, String lugar, String breveDescripcion, String explicacion, Date fecha,
			Date hora, BigDecimal importe, Seguro seguro) {
		this.tipoAsistencia = tipoAsistencia;
		this.lugar = lugar;
		this.breveDescripcion = breveDescripcion;
		this.explicacion = explicacion;
		this.fecha = fecha;
		this.hora = hora;
		this.importe = importe;
		this.seguro = seguro;
	}

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
	
	

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}

	@Override
	public String toString() {
		return "AsistenciaMedica [id=" + id + ", tipoAsistencia=" + tipoAsistencia + ", lugar=" + lugar
				+ ", breveDescripcion=" + breveDescripcion + ", explicacion=" + explicacion + ", fecha=" + fecha
				+ ", hora=" + hora + ", importe=" + importe + "]";
	}

}
