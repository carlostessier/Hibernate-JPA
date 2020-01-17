package hibernate.ejemplos.asociaciones.onetomanyord_jpa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	public void borraEmpleado(Empleado3 emp) {
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
	public void actualizaEmpleado(Empleado3 emp) {
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
	public void almacenaEmpleado(Empleado3 emp) {
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
	public Empleado3 RecuperaEmpleado(int id) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Empleado3 emp = new Empleado3();

		// abrimos una transacción
		session.beginTransaction();
		// Recuperamos el empleado
		emp = (Empleado3) session.load(Empleado3.class, id);
		// Commit de la transacción
		session.getTransaction().commit();

		return emp;
	}

	public static void main(String[] args) {
		Empleado3 emp = new Empleado3();
		Empleado3 empR;
		emp.setNombre("Pankaj");
		emp.setRol("CEO");
		emp.setFecha(new Date());
		Cargo3 cargo=new Cargo3();
		cargo.setNombre("jefe");
		cargo.setSueldo(10000);
		Cargo3 cargo1=new Cargo3();
		cargo1.setNombre("coordinador");
		cargo1.setSueldo(20000);
		List<Cargo3> cargos=new ArrayList<Cargo3>();
		cargos.add(cargo);
		cargos.add(cargo1);
		emp.setCargos(cargos);

		Prueba prueba = new Prueba();
		prueba.almacenaEmpleado(emp);
		// Hibernate sincroniza el estado del objeto para que tenga el id
		// autogenerado de BD
		System.out.println("Empleado almacenado:" + emp.toString());
		empR = prueba.RecuperaEmpleado(emp.getId());
		System.out.println("Empleado recuperado:" + empR.toString());
		
		// Cerramos la factoria de sesiones, sino el programa no finalizará
		Utilidades.getSessionFactory().close();
	}

}
