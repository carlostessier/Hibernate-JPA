package hibernate.ejercicio2;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;


import hibernate.ejemplos.autor.utilidades.Utilidades;

/**
 * 
 * @description Clase de prueba de Hibernate. En un caso real ser�a un DAO: se
 *              puede hacer como ejercicio con los alumnos
 * @author Laura y Carlos
 * @date 01/01/2020
 * @version 1.1
 * @license GPLv3
 */
public class Prueba {
	
	static EntityManager man ;

	/**
	 * M�todo para almacenar un profesor
	 * 
	 * @param prof
	 */
	public void almacenaProfesor(Profesor prof) {
		// Conseguimos un objeto EntityManager para comunicarnos con la BD

		// abrimos una transacci�n
		man.getTransaction().begin();
		// Guardamos el objeto en la sesi�n				
		man.persist(prof);
		// Commit de la transacci�n
		man.getTransaction().commit();				

	}

	/**
	 * M�todo para recuperar un profesor
	 * 
	 * @param id
	 * @return
	 */
	public Profesor recuperaProfesor(int id) {
		// Conseguimos un objeto sesi�n para comunicarnos con la BD
		Profesor prof = new Profesor();

		// abrimos una transacci�n
		man.getTransaction().begin();
		// Recuperamos el profleado
		prof = man.find(Profesor.class, id);
		// Commit de la transacci�n
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

		// abrimos una transacci�n
		// Guardamos el objeto en la sesi�n				
		
		
		Direccion dir = new Direccion("mi calle", 5,"colmenar","Madrid"  );
		Modulo mod=new Modulo("Acceso a Datos",new Float(8.5));
		List<Correo> correos=new ArrayList<Correo>();
		correos.add(new Correo("mail@gmail.com", "gmail"));
		correos.add(new Correo("mail@microsoft.com", "microsoft"));
		

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
	
		// Cerramos la factoria de sesiones, sino el programa no finalizar�
		Utilidades.getEntityManagerFactory().close();
	}

}
