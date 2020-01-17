package hibernate.ejemplos.autor.main;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import hibernate.ejemplos.autor.modelo.Autor;
import hibernate.ejemplos.autor.modelo.Libro;
import hibernate.ejemplos.autor.utilidades.Utilidades;

public class PruebaAutor {
	
	public static void main(String[] args) {
		
		Autor autor = new Autor("juan", "Humanes Lopez", LocalDate.of(2000, 1, 20), false);
		Libro libro1 = new Libro("Aprendiendo Java", autor);
		Libro libro2 = new Libro("Aprendiendo Hibernate", autor);

		
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
		man.persist(libro1);
		man.persist(libro2);
		// Commit de la transacción
		man.getTransaction().commit();
		System.out.println(autor);
		
		for(Libro l:autor.getLibros())
			System.out.println(l);
		
		man.close();
		imprimirLibrosAutor(1);
		// Cerramos la factoria de EntityManager, sino el programa no finalizará
		Utilidades.getEntityManagerFactory().close();
		
	}
	
	private static void imprimirLibrosAutor(int id) {
		
		EntityManager man   = Utilidades.getEntityManagerFactory().createEntityManager();
		
		//Query query = man.createQuery( "SELECT l FROM Libro l WHERE l.autor.id = :id_autor");		 
	
		Query query = man.createNamedQuery("buscarLibrosAutor", Libro.class) ;

		
		query.setParameter("id_autor", id);
		 
		@SuppressWarnings("unchecked")
		List<Libro> libros =
				query.getResultList();

		System.out.println("Tiene " + libros.size());

		for (Libro libro : libros) {
			System.out.println(libro);
		}

		man.close();
	}
	


}
