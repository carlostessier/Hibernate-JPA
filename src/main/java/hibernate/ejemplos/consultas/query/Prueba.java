package hibernate.ejemplos.consultas.query;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.ejercicio2.Profesor;

public class Prueba {

	/**
	 * Como ya hemos dicho el método list() nos retorna una lista con todos los
	 * objetos que ha retornado la consulta. En caso de que no se encuentre
	 * ningún resultado se retornará una lista sin ningún elemento.
	 */
	public void usoList(Session session) {

		System.out.println("----------- Uso de list() -----------");
		Query query = session.createQuery("FROM Profesor");
		/**
		 * Hibernate devuelve List en el métod query.list(). No es un error,no se puede evitar 
		 * ya que el tipo que devuelve la consulta no puede ser determinado en tiempo de compilación.
		 * Esto no va a provocar un error, sólo lo provocaría hacer algo tan inseguro como:
		 * final List<MyObject> list = new LinkedList<>();
			for(final Object o : query.list()) {
    		list.add((MyObject)o);
			}
		 * 
		 */
		List<Profesor> profesores = query.list();
		for (Profesor profesor : profesores) {
			System.out.println(profesor.toString());
		}
	}

	/**
	 * En la consulta podemos ver cómo en vez de retornar un objeto Profesor se
	 * retorna únicamente el código del profesor y su nombre.En estos casos el
	 * método list() retorna una lista con una Array de objetos con tantos
	 * elementos como propiedades hayamos puesto en la SELECT.
	 */
	public void usoEscalares(Session session) {

		System.out
				.println("----------- Uso de list() con datos escalares -----------");
		Query query = session
				.createQuery("SELECT p.id,p.nombre FROM Profesor p");
		List<Object[]> listDatos = query.list();
		for (Object[] datos : listDatos) {
			System.out.println(datos[0] + "--" + datos[1]);
		}
	}

	/**
	 * Hay otro caso cuando hay una única columna en el SELECT de datos
	 * escalares. Es ese caso, como el array a retornar dentro de la lista solo
	 * tendría un elemento , no se retorna una lista de arrays List<Object[]>
	 * sino únicamente una lista de elementos List<Object>.
	 */
	public void usoUnicoEscalar(Session session) {
		System.out.println("----------- Uso de list() con un único dato escalar -----------");
		Query query = session.createQuery("SELECT p.nombre FROM Profesor p");
		List<Object> listDatos = query.list();
		for (Object datos : listDatos) {
			System.out.println(datos);
		}
	}

	/**
	 * En muchas ocasiones una consulta únicamente retornará cero o un
	 * resultado. En ese caso es poco práctico que nos retorne una lista con un
	 * único elemento. Para facilitarnos dicha tarea Hibernate dispone del
	 * método uniqueResult(). Este método retornará directamente el único objeto
	 * que ha obtenido la consulta. En caso de que no encuentre ninguno se
	 * retornará null.
	 */
	public void usoUniqueResult(Session session) {
		System.out.println("----------- Uso de uniqueResult -----------");
		//Verificar que el id que se ponga existe en BD
		Profesor profesor = (Profesor) session.createQuery(
				"SELECT p FROM Profesor p WHERE id=6").uniqueResult();
		System.out.println("Profesor con Id 6=" + profesor.getNombre());
	}
	
	/*
	 * <query name="findAllProfesores"><![CDATA[SELECT p FROM Profesor p]]></query>

	 * */

	public static void main(String[] args) {

		Session session = Utilidades.getSessionFactory().openSession();
		Prueba prueba = new Prueba();
		prueba.usoList(session);
		prueba.usoEscalares(session);
		prueba.usoUnicoEscalar(session);
		prueba.usoUniqueResult(session);

		// Usando consulta de fichero de configuración
		System.out.println("----------- Uso de tag <query> para consulta -----------");
		Query query = session.getNamedQuery("findAllProfesores");
		List<Profesor> profesores = query.list();
		for (Profesor profesor : profesores) {
			System.out.println(profesor.toString());
		}

		Utilidades.getSessionFactory().close();
	}

}
