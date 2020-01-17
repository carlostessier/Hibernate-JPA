package hibernate.ejercicio3.actividad03;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.ejercicio3.actividad03.AsistenciaMedica.Tipo;
import hibernate.ejercicio3.actividad03.Seguro.Sexo;


/**
 * 
 * @description Clase que proprociona métodos para borrar, insertar, actualizar
 *              y recuperar de BD seguros
 *	@author Laura y Carlos
 *  @date 1/1/2020
 *  @version 1.2
 *  @license GPLv3
 */
public class PruebaCorrecto {

	/**
	 * Método para actualizar un seguro
	 * 
	 * @param seg
	 */
	public void borraSeguro(Seguro seg) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacción
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesión
			session.delete(seg);
			// Commit de la transacción
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Ocurrió un error");
		} finally {
			/*
			 * Cuidado que al hacer close, los objetos pasan a estado detached,
			 * si hago close y luego fuera del try un return del objeto no
			 * tendré acceso al valor de sus propiedades, únicamente la clave
			 * primaria. Nos daría una excepción como esta: Exception in thread
			 * "main" org.hibernate.ObjectNotFoundException: No row with the
			 * given identifier exists: [transparencias.mapeos.Vuelo#0] at
			 * org.hibernate
			 * .internal.SessionFactoryImpl$1$1.handleEntityNotFound
			 * (SessionFactoryImpl.java:253) at
			 * org.hibernate.proxy.AbstractLazyInitializer
			 * .checkTargetState(AbstractLazyInitializer.java:262) at
			 * org.hibernate
			 * .proxy.AbstractLazyInitializer.initialize(AbstractLazyInitializer
			 * .java:176) at
			 * org.hibernate.proxy.AbstractLazyInitializer.getImplementation
			 * (AbstractLazyInitializer.java:286) at
			 * org.hibernate.proxy.pojo.javassist
			 * .JavassistLazyInitializer.invoke
			 * (JavassistLazyInitializer.java:185) at
			 * transparencias.mapeos.Vuelo_$$_jvstb20_0
			 * .toString(Vuelo_$$_jvstb20_0.java) at
			 * transparencias.mapeos.Prueba.main(Prueba.java:87)
			 */
			session.close();
		}

	}

	/**
	 * Método para actualizar un seguro
	 * 
	 * @param seg
	 */
	public void actualizaSeguro(Seguro seg) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacción
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesión
			session.update(seg);
			// Commit de la transacción
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Ocurrió un error");
		} finally {
			session.close();
		}

	}

	/**
	 * Método para almacenar un seguro
	 * 
	 * @param seg
	 */
	public void almacenaSeguro(Seguro seg) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacción
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesión
			session.save(seg);
			// Commit de la transacción
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Ocurrió un error");
		} finally {
			session.close();
		}

	}

	/**
	 * Método para recuperar un seguro
	 * 
	 * @param id
	 * @return
	 */
	public Seguro RecuperaSeguro(int id) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Seguro seg = new Seguro();

		// abrimos una transacción
		session.beginTransaction();
		// Recuperamos el seguro
		seg = (Seguro) session.load(Seguro.class, id);
		// Commit de la transacción
		session.getTransaction().commit();

		return seg;
	}

	public static void main(String[] args) {
		Seguro seg = new Seguro();
		Seguro segR;
		
		List<AsistenciaMedica> lista=new ArrayList<AsistenciaMedica>();
		AsistenciaMedica asis1=new AsistenciaMedica();
		
		asis1.setBreveDescripcion("descripcion1");
		asis1.setExplicacion("Explicacion 1");
		asis1.setFecha(new Date());
		asis1.setHora(new Date());
		asis1.setImporte(new BigDecimal(10504));
		asis1.setLugar("Alcobendas");
		asis1.setTipoAsistencia(Tipo.AMBULATORIA);
		AsistenciaMedica asis2=new AsistenciaMedica();
		asis2.setBreveDescripcion("descripcion2");
		asis2.setExplicacion("Explicacion 2");
		asis2.setFecha(new Date());
		asis2.setHora(new Date());
		asis2.setImporte(new BigDecimal(8367));
		asis2.setLugar("Fuenlabrada");
		asis2.setTipoAsistencia(Tipo.DOMICILIARIA);
		
		lista.add(asis1);
		lista.add(asis2);
		
		Nif nif=new Nif();
		nif.setNif("78912345N");
		Coberturas cob=new Coberturas();
		cob.setDental(true);
		cob.setFecundacionInVitro(false);
		cob.setOftalmologia(true);
		Enfermedades enf=new Enfermedades();
		enf.setNombreAlergia("Polen");
		enf.setAlergia(true);
		enf.setCorazon(false);
		enf.setEstomacal(false);
		enf.setRinones(true);		
		seg.setNombre("Pankaj");
		seg.setApe1("Garcia");
		seg.setApe2("Lopez");
		seg.setNif(nif);
		seg.setFechaCreacion(new Date());
		seg.setNumHijos(2);
		seg.setSexo(Sexo.HOMBRE);
		seg.setEdad(29);		
		seg.setCasado(true);
		seg.setCoberturas(cob);
		seg.setEnfermedades(enf);
		seg.setEmbarazada(true);
		seg.setAsistencias(lista);


		PruebaCorrecto prueba = new PruebaCorrecto();
		prueba.almacenaSeguro(seg);
		// Hibernate sincroniza el estado del objeto para que tenga el id
		// autogenerado de BD
		System.out.println("Seguro almacenado:" + seg.toString());
		segR = prueba.RecuperaSeguro(seg.getIdSeguro());
		// Fijarse como la formula de esmayorEdad sólo se aplica al recuperar,
		// modo lectura
		System.out.println("Seguro recuperado:" + segR.toString());
		seg.setNombre("Pankajooo");
		// Comprobar en BD que se ha actualizado el nombre
		prueba.actualizaSeguro(seg);

		// Cerramos la factoria de sesiones, sino el programa no finalizará
		Utilidades.getSessionFactory().close();
	}

}
