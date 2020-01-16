package hibernate.ejercicio1;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import hibernate.ejercicio1.SeguroMedico;
import hibernate.ejercicio1.SeguroMedico.TipoSeguro;
import hibernate.ejercicio1.SeguroMedico.TipoSexo;


public class TestSeguroJPA {
	
	
	public static String INSERT_INICIAL = 	
			"INSERT INTO `seguro`"	+ 
	       " (`idSeguro`, `nif`, `nombre`, `ape1`, `ape2`, `edad`, `sexo`, `casado`, `numHijos`, `fechaCreacion`,`tipoSeguro`) VALUES"+
			"(1, '17546586R', 'JOAQUIM', 'SORIA', 'SORIA', 19, 1, 'Y', 0, '2013-04-22 19:05:11', 'HOGAR'),"+
			"(2, '22737883Z', 'FELIX EDUARDO', 'EVA EUGENIA', 'IVORRA', 40, 1, 'Y', 3,'2013-04-22 19:05:12', 'HOGAR'),"+
			"(3, '41179582Z', 'MARIA INES', 'MARCO', 'LIBEROS', 26, 1, 'Y', 2,'2013-04-22 19:05:12', 'COCHE'),"+
			"(4, '55386997F', 'NURIA', 'PUERTO', 'VILLANOVA', 46, 1, 'Y', 2, '2013-04-22 19:05:12', 'HOGAR'),"+
			"(5, '66738365R', 'JOAQUIN', 'SAYAS', 'SENABRE', 25, 0, 'N', 1,'2013-04-22 19:05:12', 'MOTO'),"+
			"(6, '42749118F', 'JOSEF BENANTZIO', 'SAVALL', 'RABASCO', 40, 1, 'N', 2,'2013-04-22 19:05:12', 'MOTO'),"+
			"(7, '78172651K', 'CRISTINA', 'PEREZ', 'HARILLO', 56, 0,'Y', 1,'2013-04-22 19:05:12', 'HOGAR'),"+
			"(8, '51256964S', 'MARIA SANDRA', 'CASES', 'ROIG', 58, 1, 'N', 3,'2013-04-22 19:05:12', 'VIAJE')";

	/*
	public static String INSERT_INICIAL = 	"INSERT INTO `seguro`"	+ 
    " (`idSeguro`, `nif`, `nombre`, `ape1`, `ape2`, `edad`, `sexo`, `casado`, `numHijos`, `fechaCreacion`,`tipoSeguro`) VALUES"+
		"(1, '17546586R', 'JOAQUIM', 'SORIA', 'SORIA', 19, 1, 'Y', 0, '2011-07-01 16:19:18', 'HOGAR')";
		*/

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
		seg.setFechaCreacion(new Date());
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
		// Fijarse como la formula de esmayorEdad s�lo se aplica al recuperar,
		// modo lectura
		System.out.println("Seguro recuperado:" + segR.toString());
		seg.setNombre("Pankajooo");
		// Comprobar en BD que se ha actualizado el nombre
		actualizaSeguro(seg);
*/
		
		insertInicial();
		
		imprimirTodo();
		

	}

	private static void insertInicial() {
		
		EntityManager man = emf.createEntityManager();

		// abrimos una transacci�n
		man.getTransaction().begin();		
				
		man.createNativeQuery(INSERT_INICIAL).executeUpdate();
		
		/*almacenaSeguro(new Seguro("1234567", "pepe", "garc�a", "fern�ndez", 36, 2, Seguro.TipoSexo.HOMBRE,
				Seguro.TipoSeguro.HOGAR, true, new GregorianCalendar(2020, 1, 1).getTime() ));
		*/
		// Commit de la transacci�n
		man.getTransaction().commit();
		// Cerramos el EntityManager
		man.close();
		
		
		
	}	


	private static void imprimirTodo() {

		EntityManager man = emf.createEntityManager();

		@SuppressWarnings("unchecked")
		List<SeguroMedico> seguros = man.createQuery("FROM Seguro").getResultList();

		System.out.println("Hay " + seguros.size() + " seguros en el sistema");

		for (SeguroMedico seguro : seguros) {
			System.out.println(seguro);
		}

		man.close();
	}

	/**
	 * M�todo para borrar un seguro
	 * 
	 * @param seg
	 */
	public static void borraSeguro(SeguroMedico seg) {
		SeguroMedico segBorrar = seg;
		// Conseguimos un objeto EntityManager para comunicarnos con la BD
		EntityManager man = emf.createEntityManager();

		// abrimos una transacci�n
		man.getTransaction().begin();
		// Borramos
		if (!man.contains(seg)) // comprobamos si es detached hacemos 
				segBorrar = man.merge(seg);		
		man.remove(segBorrar);
		// Commit de la transacci�n
		man.getTransaction().commit();
		// Cerramos el EntityManager
		man.close();

	}

	/**
	 * M�todo para actualizar un seguro
	 * 
	 * @param seg
	 */
	public static void actualizaSeguro(SeguroMedico seg) {
		// Conseguimos un objeto EntityManager para comunicarnos con la BD
		EntityManager man = emf.createEntityManager();
		// abrimos una transacci�n
		man.getTransaction().begin();
		// Actualizamos
		if (!man.contains(seg)) // comprobamos si es detached hacemos 
			man.merge(seg);			
		// Commit de la transacci�n
		man.getTransaction().commit();
		// Cerramos el EntityManager
		man.close();

	}
	
	/**
	 * M�todo para almacenar un seguro
	 * 
	 * @param seg
	 */
	public static void almacenaSeguro(SeguroMedico seg) {
		// Conseguimos un objeto EntityManager para comunicarnos con la BD
		EntityManager man = emf.createEntityManager();
		// abrimos una transacci�n
		man.getTransaction().begin();
		// Borramos
		man.persist(seg);
		// Commit de la transacci�n
		man.getTransaction().commit();
		// Cerramos el EntityManager
		man.close();

	}
	
	/**
	 * M�todo para recuperar un seguro
	 * 
	 * @param id
	 * @return
	 */
	public static SeguroMedico RecuperaSeguro(int id) {
		// Conseguimos un objeto EntityManager para comunicarnos con la BD
		EntityManager man = emf.createEntityManager();
		SeguroMedico seg = new SeguroMedico();

		// abrimos una transacci�n
		man.getTransaction().begin();
		// Recuperamos el seguro
		seg = man.find(SeguroMedico.class, id);
		// Commit de la transacci�n
		man.getTransaction().commit();
		
		man.close();

		return seg;
	}

}
