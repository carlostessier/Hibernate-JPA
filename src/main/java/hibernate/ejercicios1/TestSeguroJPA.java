package hibernate.ejercicios1;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import hibernate.ejercicios1.Seguro;
import hibernate.ejercicios1.Seguro.TipoSeguro;
import hibernate.ejercicios1.Seguro.TipoSexo;

public class TestSeguroJPA {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");

	public static void main(String[] args) {
		
		/* Ejercicio 1 - 4 */
		/*
		Seguro seg = new Seguro();
		Seguro segD = new Seguro();
		Seguro segR;
		seg.setNombre("Pankaj");
		seg.setApe1("Garcia");
		seg.setApe2("Lopez");
		seg.setNif("765688143N");
		seg.setFechaCreacion(LocalDate.now());
		seg.setNumHijos(2);
		seg.setSexo(TipoSexo.HOMBRE);
		seg.setEdad(29);
		seg.setTipo(TipoSeguro.VIAJE);
		seg.setCasado(false);
		
		almacenaSeguro(seg);
		// Hibernate sincroniza el estado del objeto para que tenga el id
		// autogenerado de BD
		System.out.println("Seguro almacenado:" + seg);
		segR = RecuperaSeguro(seg.getIdSeguro());
		System.out.println("Seguro recuperado:" + segR);
		seg.setNombre("Pankajooo");
		// Comprobar en BD que se ha actualizado el nombre
		actualizaSeguro(seg);

		// Vamos a borrar otro objeto
		segD.setIdSeguro(6);
		//El nif no puede ser nulo
		segD.setNif("42749118F");
		borraSeguro(segD);
		//Comprobar que en BD se ha borrado
		*/
		/* Ejercicio 5 - 8 */
		
		Seguro seg = new Seguro();
		Seguro segD = new Seguro();
		Seguro segR;
		seg.setNombre("Pankaj");
		seg.setApe1("Garcia");
		seg.setApe2("Lopez");
		seg.setNif("765688143N");
		seg.setFechaCreacion(LocalDate.now());
		seg.setNumHijos(2);
		seg.setSexo(TipoSexo.HOMBRE);
		seg.setEdad(29);
		seg.setTipo(TipoSeguro.VIAJE);
		seg.setCasado(false);
		seg.setFechaNacimiento(new Date());
		
		
		seg.setHoraContacto(new Date());
		seg.setComentarios("sdafsdfsdfsdfasdf");
		char[] claves = { 'A', '0', '2', '3', };
		seg.setClaves(claves);
		
		almacenaSeguro(seg);
		// Hibernate sincroniza el estado del objeto para que tenga el id
		// autogenerado de BD
		System.out.println("Seguro almacenado:" + seg.toString());
		segR = RecuperaSeguro(seg.getIdSeguro());
		// Fijarse como la formula de esmayorEdad sólo se aplica al recuperar,
		// modo lectura
		System.out.println("Seguro recuperado:" + segR.toString());
		seg.setNombre("Pankajooo");
		// Comprobar en BD que se ha actualizado el nombre
		actualizaSeguro(seg);

		imprimirTodo();
		

	}

	private static void insertInicial() {
		
		almacenaSeguro(new Seguro("1234567", "pepe", "garcía", "fernández", 36, 2, Seguro.TipoSexo.HOMBRE,
				Seguro.TipoSeguro.HOGAR, true, LocalDate.of(2020, 1, 1)));
		
		almacenaSeguro(new Seguro("17546586R", "JOAQUIM", "SORIA", "SORIA", 19, 0, Seguro.TipoSexo.HOMBRE,
				Seguro.TipoSeguro.HOGAR, true, LocalDate.of(2019, 1, 1)));	
	}	


	private static void imprimirTodo() {

		EntityManager man = emf.createEntityManager();

		List<Seguro> seguros = man.createQuery("FROM Seguro").getResultList();

		System.out.println("Hay " + seguros.size() + " seguros en el sistema");

		for (Seguro seguro : seguros) {
			System.out.println(seguro);
		}

		man.close();
	}

	/**
	 * Método para borrar un seguro
	 * 
	 * @param seg
	 */
	public static void borraSeguro(Seguro seg) {
		Seguro segBorrar = seg;
		// Conseguimos un objeto EntityManager para comunicarnos con la BD
		EntityManager man = emf.createEntityManager();

		// abrimos una transacción
		man.getTransaction().begin();
		// Borramos
		if (!man.contains(seg)) // comprobamos si es detached hacemos 
				segBorrar = man.merge(seg);		
		man.remove(segBorrar);
		// Commit de la transacción
		man.getTransaction().commit();
		// Cerramos el EntityManager
		man.close();

	}

	/**
	 * Método para actualizar un seguro
	 * 
	 * @param seg
	 */
	public static void actualizaSeguro(Seguro seg) {
		// Conseguimos un objeto EntityManager para comunicarnos con la BD
		EntityManager man = emf.createEntityManager();
		// abrimos una transacción
		man.getTransaction().begin();
		// Actualizamos
		if (!man.contains(seg)) // comprobamos si es detached hacemos 
			man.merge(seg);			
		// Commit de la transacción
		man.getTransaction().commit();
		// Cerramos el EntityManager
		man.close();

	}
	
	/**
	 * Método para almacenar un seguro
	 * 
	 * @param seg
	 */
	public static void almacenaSeguro(Seguro seg) {
		// Conseguimos un objeto EntityManager para comunicarnos con la BD
		EntityManager man = emf.createEntityManager();
		// abrimos una transacción
		man.getTransaction().begin();
		// Borramos
		man.persist(seg);
		// Commit de la transacción
		man.getTransaction().commit();
		// Cerramos el EntityManager
		man.close();

	}
	
	/**
	 * Método para recuperar un seguro
	 * 
	 * @param id
	 * @return
	 */
	public static Seguro RecuperaSeguro(int id) {
		// Conseguimos un objeto EntityManager para comunicarnos con la BD
		EntityManager man = emf.createEntityManager();
		Seguro seg = new Seguro();

		// abrimos una transacción
		man.getTransaction().begin();
		// Recuperamos el seguro
		seg = man.find(Seguro.class, id);
		// Commit de la transacción
		man.getTransaction().commit();

		return seg;
	}

}
