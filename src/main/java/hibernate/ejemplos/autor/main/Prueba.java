package hibernate.ejemplos.autor.main;

import java.time.LocalDate;

import javax.persistence.EntityManager;


import hibernate.ejemplos.autor.modelo.Autor;
import hibernate.ejemplos.autor.utilidades.Utilidades;

public class Prueba {
	
	public static void main(String[] args) {
		
		Autor autor = new Autor("juan", "Humanes Lopez", LocalDate.of(2000, 1, 20), false);
	
		
		/*

		// Conseguimos un objeto sesión para comunicarnos con la BD
		Session session = Utilidades.getSessionFactory().openSession();
		// abrimos una transacción
		session.beginTransaction();
		// Guardamos el objeto en la sesión
		session.save(autor);
		// Commit de la transacción
		session.getTransaction().commit();
		System.out.println("Autor=" + autor.getId());

		// Cerramos la factoria de sesiones, sino el programa no finalizará
		Utilidades.getSessionFactory().close();
		
		*/
		// Conseguimos un objeto EntityManager para comunicarnos con la BD
		EntityManager man   = Utilidades.getEntityManagerFactory().createEntityManager();
		// abrimos una transacción
		man.getTransaction().begin();
		// Guardamos el objeto en la sesión
		man.persist(autor);
		// Commit de la transacción
		man.getTransaction().commit();
		System.out.println(autor);
		
		man.close();
		
		// Cerramos la factoria de EntityManager, sino el programa no finalizará
		Utilidades.getEntityManagerFactory().close();
		
	}

}
