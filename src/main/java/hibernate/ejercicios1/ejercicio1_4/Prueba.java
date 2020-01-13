package hibernate.ejercicios1.ejercicio1_4;

import java.time.LocalDate;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.ejercicios1.ejercicio1_4.Seguro.TipoSeguro;
import hibernate.ejercicios1.ejercicio1_4.Seguro.TipoSexo;

/**
 * 
 * @description Clase que proprociona métodos para borrar, insertar, actualizar y recuperar de BD seguros
 * @author Laura y Carlos
 * @date 1/1/2020
 * @version 1.2
 * @license GPLv3
 */
public class Prueba {

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
			// Borramos
			session.delete(seg);
			// Commit de la transacción
			session.getTransaction().commit();

		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Ocurrió un error:"+e.getMessage());
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
			System.out.println("Ocurrió un error:" +e.getMessage());
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
			System.out.println("Ocurrió un error"+e.getMessage());
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
		Seguro segD = new Seguro();
		Seguro segR;
		seg.setNombre("Pankaj");
		seg.setApe1("Garcia");
		seg.setApe2("Lopez");
		seg.setNif("765688143N");
		seg.setFechaCreacion(LocalDate.now());
		seg.setNumHijos(2);
		seg.setSexo(TipoSexo.HOMBRE);
		seg.setEdad(29);
		seg.setTipo(TipoSeguro.VIAJE);
		seg.setCasado(false);
		
		Prueba prueba = new Prueba();
		prueba.almacenaSeguro(seg);
		// Hibernate sincroniza el estado del objeto para que tenga el id
		// autogenerado de BD
		System.out.println("Seguro almacenado:" + seg.toString());
		segR = prueba.RecuperaSeguro(seg.getIdSeguro());
		System.out.println("Seguro recuperado:" + segR.toString());
		seg.setNombre("Pankajooo");
		// Comprobar en BD que se ha actualizado el nombre
		prueba.actualizaSeguro(seg);

		// Vamos a borrar otro objeto
		segD.setIdSeguro(6);
		//El nif no puede ser nulo
		segD.setNif("42749118F");
		prueba.borraSeguro(segD);
		//Comprobar que en BD se ha borrado

		// Cerramos la factoria de sesiones, sino el programa no finalizará
		Utilidades.getSessionFactory().close();
	}

}
