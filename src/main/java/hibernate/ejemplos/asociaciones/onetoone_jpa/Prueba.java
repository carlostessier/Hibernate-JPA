package hibernate.ejemplos.asociaciones.onetoone_jpa;

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
	public void borraEmpleado(Empleado4 emp) {
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
	public void actualizaEmpleado(Empleado4 emp) {
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
	public void almacenaEmpleado(Empleado4 emp) {
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
	public Empleado4 RecuperaEmpleado(int id) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Empleado4 emp = new Empleado4();

		// abrimos una transacción
		session.beginTransaction();
		// Recuperamos el empleado
		emp = (Empleado4) session.load(Empleado4.class, id);
		// Commit de la transacción
		session.getTransaction().commit();

		return emp;
	}

	public static void main(String[] args) {
		
		//¿Que pasaría si intento crear otro empleado con el mismo cargo? Que al recuperarlo me va a dar error, 
		//porque intenta encontrar una fila Cargo con el mismo id y esto no existe
		//Cuidado si hacemos esta prueba: después reiniciar los indices de clave primaria
		//de ambas tablas al mismo valor, sino dará error siempre después de hacer la prueba
		//Para Ello:
		//ALTER table Empleados.Empleado AUTO_INCREMENT=10;
		//ALTER table Empleados.Cargo AUTO_INCREMENT=10;
		
		/*Empleado emp = new Empleado();
		Empleado empR;
		emp.setNombre("Pankaj");
		emp.setRol("CEO");
		emp.setFecha(new Date());
		Cargo cargo=new Cargo();
		cargo.setNombre("jefe");
		cargo.setSueldo(10000);
		emp.setCargo(cargo);

		Prueba prueba = new Prueba();
		prueba.almacenaEmpleado(emp);
		// Hibernate sincroniza el estado del objeto para que tenga el id
		// autogenerado de BD
		System.out.println("Empleado almacenado:" + emp.toString());
		empR = prueba.RecuperaEmpleado(emp.getId());
		System.out.println("Empleado recuperado:" + empR.toString());
		*/
		
		Empleado4 emp = new Empleado4();
		Empleado4 emp1 = new Empleado4();
		Empleado4 empR;
		emp.setNombre("Pankaj");
		emp.setRol("CEO");
		emp.setFecha(new Date());
		emp1.setNombre("Maria");
		emp1.setRol("Programador");
		emp1.setFecha(new Date());
		Cargo4 cargo=new Cargo4();
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
