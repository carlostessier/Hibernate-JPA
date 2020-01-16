package hibernate.ejercicio2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;


import hibernate.ejemplos.autor.utilidades.Utilidades;
import hibernate.ejercicio3.actividad01.Municipio;

/**
 * 
 * @description Clase de prueba de Hibernate. En un caso real sería un DAO: se
 *              puede hacer como ejercicio con los alumnos
 * @author Laura y Carlos
 * @date 01/01/2020
 * @version 1.1
 * @license GPLv3
 */
public class Prueba {
	
	static EntityManager man ;

	/**
	 * Método para almacenar un profesor
	 * 
	 * @param prof
	 */
	public void almacenaProfesor(Profesor prof) {
		// Conseguimos un objeto EntityManager para comunicarnos con la BD

		// abrimos una transacción
		man.getTransaction().begin();
		// Guardamos el objeto en la sesión				
		man.persist(prof);
		// Commit de la transacción
		man.getTransaction().commit();				

	}

	/**
	 * Método para recuperar un profesor
	 * 
	 * @param id
	 * @return
	 */
	public Profesor recuperaProfesor(int id) {
		// Conseguimos un objeto sesión para comunicarnos con la BD
		Profesor prof = new Profesor();

		// abrimos una transacción
		man.getTransaction().begin();
		// Recuperamos el profleado
		prof = man.find(Profesor.class, id);
		// Commit de la transacción
		man.getTransaction().commit();

		return prof;
		


	}
	
	private void imprimirTodo() {

		@SuppressWarnings("unchecked")
		List<Object> profes = man.createQuery("FROM Profesor").getResultList();

		System.out.println("Hay " + profes.size() + " en el sistema");

		for (Object prof : profes) {
			System.out.println(prof);
		}

	}

	public static void main(String[] args) {
		man = Utilidades.getEntityManagerFactory().createEntityManager();

		// abrimos una transacción
		// Guardamos el objeto en la sesión				
		

		Direccion dir = new Direccion("mi calle", 5,"colmenar", new Municipio("1","1", "Alcobendas") );
		Modulo mod=new Modulo("Acceso a Datos",new Float(8.5));
		List<Email> correos=new ArrayList<Email>();
		correos.add(new Email("mail@gmail.com", "gmail"));
		correos.add(new Email("mail@microsoft.com", "microsoft"));
		

		Profesor prof = new Profesor("Pankaj", "garcia","lopez", dir, mod , correos );
		
		Profesor profR;		

		Prueba prueba = new Prueba();
		
		prueba.almacenaProfesor(prof);
		
		System.out.println("Profesor almacenado:" + prof);
		System.out.println("Direccion almacenada:" + prof.getDireccion());

		// Hibernate sincroniza el estado del objeto para que tenga el id
		// autogenerado de BD
		profR = prueba.recuperaProfesor(prof.getId());
		System.out.println("Profesor recuperado:" + profR);


		prof = new Profesor("Pepe", "fernandez","suarez", dir, 	mod  );
		
		prueba.almacenaProfesor(prof);
		prueba.imprimirTodo();
		
		
		man.close();
	
		// Cerramos la factoria de sesiones, sino el programa no finalizará
		Utilidades.getEntityManagerFactory().close();
	}

}
