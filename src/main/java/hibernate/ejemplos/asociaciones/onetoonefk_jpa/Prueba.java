package hibernate.ejemplos.asociaciones.onetoonefk_jpa;

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
	public void borraEmpleado(Empleado5 emp) {
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
	public void actualizaEmpleado(Empleado5 emp) {
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
	public void almacenaEmpleado(Empleado5 emp) {
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
	public Empleado5 RecuperaEmpleado(int id) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		Empleado5 emp = new Empleado5();

		// abrimos una transacción
		session.beginTransaction();
		// Recuperamos el empleado
		emp = (Empleado5) session.load(Empleado5.class, id);
		// Commit de la transacción
		session.getTransaction().commit();

		return emp;
	}

	public static void main(String[] args) {
		
		//¿Que pasaría si intento crear otro empleado con el mismo cargo? Nada, funciona correctamente
		//Porque al ser unidireccional con clave foránea sólo el objeto empleado es consciente de la 
		//existencia del objeto Cargo. Si quiero garantizar uno a uno: o cmpartiendo con clave primaria o 
		//bidireccional (que aqui no la vemos) o garantizando unique en BD ALTER TABLE empleado ADD UNIQUE(cargo_id)
		Empleado5 emp = new Empleado5();
		Empleado5 empR;
		emp.setNombre("Pankaj");
		emp.setRol("CEO");
		emp.setFecha(new Date());
		Cargo5 cargo=new Cargo5();
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
		
		
		/* Descomentar este código y comentar el anterior para ver que ocurre si intento
		 * asociar el mismo cargo con 2 empleados, luego ejecutar ALTER TABLE empleado ADD UNIQUE(cargo_id)
		 * y volver a probar
		Empleado emp = new Empleado();
		Empleado emp1 = new Empleado();
		Empleado empR;
		emp.setNombre("Pankaj");
		emp.setRol("CEO");
		emp.setFecha(new Date());
		emp1.setNombre("Maria");
		emp1.setRol("Programador");
		emp1.setFecha(new Date());
		Cargo cargo=new Cargo();
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
		System.out.println("Empleado recuperado:" + empR.toString());*/
		
		
		// Cerramos la factoria de sesiones, sino el programa no finalizará
		Utilidades.getSessionFactory().close();
		
		
		
	}

}
