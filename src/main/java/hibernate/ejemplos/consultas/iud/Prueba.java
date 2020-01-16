package hibernate.ejemplos.consultas.iud;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.ejercicio2.Profesor;


public class Prueba {

	/**
	 * consulta nativa en SQL
	 */
	public void nativoSQL(Session session) {

		System.out.println("----------- consulta nativa en SQL -----------");
		Query query = session
				.createSQLQuery("SELECT IdCiclo,nombreCiclo,Horas FROM CicloFormativo");
		List<Object[]> listDatos = query.list();

		for (Object[] datos : listDatos) {
			System.out.println(datos[0] + "-" + datos[1] + " " + datos[2]
					+ " Horas");
		}
	}

	/**
	 * Consultas peronalizadas para INSERT, UPDATE y DELETE
	 * 
	 * <sql-insert>INSERT INTO Profesor (Nombre,Ape1,Ape2) VALUES(?,?,?)</sql-insert>
		<sql-update>UPDATE Profesor SET Nombre=?,Ape1=?,Ape2=? WHERE Id=? </sql-update>
		<sql-delete>DELETE FROM Profesor WHERE Id=?</sql-delete>
	 */
	public void iudPersonalizadoSQL(Session session) {

		System.out
				.println("----------- Consultas peronalizadas para INSERT,  UPDATE y DELETE -----------");
		Profesor profesor;
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			profesor = new Profesor();
			profesor.setNombre("mario");
			profesor.setApe1("Lopez");
			profesor.setApe2("lozano");			
			session.save(profesor);
			session.getTransaction().commit();

			session.beginTransaction();
			profesor.setNombre("Juan Carlos");
			session.update(profesor);
			session.getTransaction().commit();

			session.beginTransaction();
			session.delete(profesor);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			System.out.println("Ocurrió un error");
		} finally {

			session.close();
		}
	}

	public static void main(String[] args) {

		Session session = Utilidades.getSessionFactory().openSession();
		Prueba prueba = new Prueba();
		prueba.nativoSQL(session);
		prueba.iudPersonalizadoSQL(session);

		Utilidades.getSessionFactory().close();
	}

}
