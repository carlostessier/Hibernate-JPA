package hibernate.ejemplos.asociaciones.manytoone_jpa;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * 
 * @description Clase de prueba de Hibernate. En un caso real sería un DAO: se
 *              puede hacer como ejercicio con los alumnos
 * @author Laura
 * @date 26/3/2015
 * @version 1.0
 * @license GPLv3
 */
public class Prueba {

	/**
	 * Método para actualizar un empleado
	 * 
	 * @param emp
	 */
	public void borraEmpleado(Empleado1 emp) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacción
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesión
			session.delete(emp);
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
	 * Método para actualizar un empleado
	 * 
	 * @param emp
	 */
	public void actualizaEmpleado(Empleado1 emp) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacción
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesión
			session.update(emp);
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
	 * Método para almacenar un empleado
	 * 
	 * @param emp
	 */
	public void almacenaEmpleado(Empleado1 emp) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Transaction tx = null;
		try {

			// abrimos una transacción
			tx = session.beginTransaction();
			// Guardamos el objeto en la sesión
			session.save(emp);
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
	 * Método para recuperar un empleado
	 * 
	 * @param id
	 * @return
	 */
	public Empleado1 RecuperaEmpleado(int id) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Empleado1 emp = new Empleado1();

		// abrimos una transacción
		session.beginTransaction();
		// Recuperamos el empleado
		emp = (Empleado1) session.load(Empleado1.class, id);
		// Commit de la transacción
		session.getTransaction().commit();

		return emp;
	}

	public static void main(String[] args) {
		Empleado1 emp = new Empleado1();
		Empleado1 emp1 = new Empleado1();
		Empleado1 empR;
		emp.setNombre("Pankaj");
		emp.setRol("CEO");
		emp.setFecha(new Date());
		emp1.setNombre("Maria");
		emp1.setRol("Programador");
		emp1.setFecha(new Date());
		Cargo1 cargo=new Cargo1();
		cargo.setNombre("jefe");
		cargo.setSueldo(10000);
		emp.setCargo(cargo);
		emp1.setCargo(cargo);

		Prueba prueba = new Prueba();
		prueba.almacenaEmpleado(emp);
		// Hibernate sincroniza el estado del objeto para que tenga el id
		// autogenerado de BD
		System.out.println("Empleado almacenado:" + emp.toString());
		empR = prueba.RecuperaEmpleado(emp.getId());
		System.out.println("Empleado recuperado:" + empR.toString());
		
		prueba.almacenaEmpleado(emp1);
		// Hibernate sincroniza el estado del objeto para que tenga el id
		// autogenerado de BD
		System.out.println("Empleado almacenado:" + emp1.toString());
		empR = prueba.RecuperaEmpleado(emp1.getId());
		System.out.println("Empleado recuperado:" + empR.toString());
		
		// Cerramos la factoria de sesiones, sino el programa no finalizará
		Utilidades.getSessionFactory().close();
	}

}
