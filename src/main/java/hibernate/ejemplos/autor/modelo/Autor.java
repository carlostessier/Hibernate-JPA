package hibernate.ejemplos.autor.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @descrition Clase Autor con anotaciones JPA
 * @author Laura y Carlos
 * @date 1/1/2020
 * @version 1.2
 * @license GPLv3
 */
@Entity
@Table(name="AUTOR", 
       uniqueConstraints={@UniqueConstraint(columnNames={"ID"})})


public class Autor  implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID", nullable=false, unique=true, length=11)
	private int id;
	@Column(name="NOMBRE", length=20, nullable=true)
	private String nombre;
	@Column(name="APELLIDOS", length=20, nullable=true)
	private String apellidos;
	@Column(name="FECHA", nullable=true)
	private LocalDate fecha;
	@Column(name="PUBLICACION", nullable=false)
	private boolean publicacion;
	
	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
	@OrderBy("titulo asc")
	private List<Libro> libros = new ArrayList<Libro>();
	
	public Autor() {
		
	}
	
	public Autor(String nombre, String apellidos, LocalDate fecha, boolean publicacion) {	
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha = fecha;
		this.publicacion = publicacion;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public boolean isPublicacion() {
		return publicacion;
	}
	public void setPublicacion(boolean publicacion) {
		this.publicacion = publicacion;
	}
	
	@OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)	
	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		return "Autor [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fecha=" + fecha
				+ ", publicacion=" + publicacion + "]";
	}
	

}
