package hibernate.ejemplos.consultas.parametros;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.ejercicio2.Profesor;

public class Prueba {

	/**
	 * Consulta con Concatenación de Strings
	 */
	public void consultaSinParametros(Session session) {

		System.out.println("----------- Concatenación de Strings -----------");
		String nombre = "JUAN";
		String ape1 = "GARCIA";
		String ape2 = "LOPEZ";

		Query query = session
				.createQuery("SELECT p FROM Profesor p where nombre='" + nombre
						+ "' AND  ape1='" + ape1 + "' AND  ape2='" + ape2
						+ "' ");
		List<Profesor> profesores = query.list();
		for (Profesor profesor : profesores) {
			System.out.println(profesor.toString());
		}
	}


	/**
	 * Consulta con Parámetro con nombre
	 */
	public void parametroNombre(Session session) {
		System.out.println("----------- Parámetro con nombre -----------");
		String nombre = "JUAN";
		String ape1 = "GARCIA";
		String ape2 = "LOPEZ";

		Query query = session
				.createQuery("SELECT p FROM Profesor p where nombre=:nombre AND ape1=:ape1 AND ape2=:ape2");
		query.setString("nombre", nombre);
		query.setString("ape1", ape1);
		query.setString("ape2", ape2);

		List<Profesor> profesores = query.list();
		for (Profesor profesor : profesores) {
			System.out.println(profesor.toString());
		}
	}

	/**
	 * Consulta con Parametros encadenados
	 */
	public void parametrosEncadenados(Session session) {
		System.out.println("----------- Parametros encadenados -----------");
		String nombre = "JUAN";
		String ape1 = "GARCIA";
		String ape2 = "LOPEZ";

		Query query = session
				.createQuery(
						"SELECT p FROM Profesor p where nombre=:nombre AND ape1=:ape1 AND ape2=:ape2")
				.setParameter("nombre", nombre).setParameter("ape1", ape1)
				.setParameter("ape2", ape2);

		List<Profesor> profesores = query.list();
		for (Profesor profesor : profesores) {
			System.out.println(profesor.toString());
		}
	}

	public static void main(String[] args) {

		Session session = Utilidades.getSessionFactory().openSession();
		Prueba prueba = new Prueba();
		prueba.consultaSinParametros(session);
		prueba.parametroNombre(session);
		prueba.parametrosEncadenados(session);

		Utilidades.getSessionFactory().close();
	}

}
