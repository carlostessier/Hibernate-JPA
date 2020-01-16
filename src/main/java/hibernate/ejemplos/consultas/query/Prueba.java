package hibernate.ejemplos.consultas.query;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.ejercicio2.Profesor;

public class Prueba {

	/**
	 * Como ya hemos dicho el m�todo list() nos retorna una lista con todos los
	 * objetos que ha retornado la consulta. En caso de que no se encuentre
	 * ning�n resultado se retornar� una lista sin ning�n elemento.
	 */
	public void usoList(Session session) {

		System.out.println("----------- Uso de list() -----------");
		Query query = session.createQuery("FROM Profesor");
		/**
		 * Hibernate devuelve List en el m�tod query.list(). No es un error,no se puede evitar 
		 * ya que el tipo que devuelve la consulta no puede ser determinado en tiempo de compilaci�n.
		 * Esto no va a provocar un error, s�lo lo provocar�a hacer algo tan inseguro como:
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
	 * En la consulta podemos ver c�mo en vez de retornar un objeto Profesor se
	 * retorna �nicamente el c�digo del profesor y su nombre.En estos casos el
	 * m�todo list() retorna una lista con una Array de objetos con tantos
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
	 * Hay otro caso cuando hay una �nica columna en el SELECT de datos
	 * escalares. Es ese caso, como el array a retornar dentro de la lista solo
	 * tendr�a un elemento , no se retorna una lista de arrays List<Object[]>
	 * sino �nicamente una lista de elementos List<Object>.
	 */
	public void usoUnicoEscalar(Session session) {
		System.out.println("----------- Uso de list() con un �nico dato escalar -----------");
		Query query = session.createQuery("SELECT p.nombre FROM Profesor p");
		List<Object> listDatos = query.list();
		for (Object datos : listDatos) {
			System.out.println(datos);
		}
	}

	/**
	 * En muchas ocasiones una consulta �nicamente retornar� cero o un
	 * resultado. En ese caso es poco pr�ctico que nos retorne una lista con un
	 * �nico elemento. Para facilitarnos dicha tarea Hibernate dispone del
	 * m�todo uniqueResult(). Este m�todo retornar� directamente el �nico objeto
	 * que ha obtenido la consulta. En caso de que no encuentre ninguno se
	 * retornar� null.
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

		// Usando consulta de fichero de configuraci�n
		System.out.println("----------- Uso de tag <query> para consulta -----------");
		Query query = session.getNamedQuery("findAllProfesores");
		List<Profesor> profesores = query.list();
		for (Profesor profesor : profesores) {
			System.out.println(profesor.toString());
		}

		Utilidades.getSessionFactory().close();
	}

}
