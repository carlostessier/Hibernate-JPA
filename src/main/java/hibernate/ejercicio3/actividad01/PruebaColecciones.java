package hibernate.ejercicio3.actividad01;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import hibernate.ejemplos.autor.utilidades.Utilidades;


public class PruebaColecciones {
	
	static EntityManager man ;

	
	public static String INSERT_NOMBRE = 	
	"INSERT INTO Nombre (nombre,ape1,ape2) VALUES " +
	"('juan','garcia','lopez'), "+
	"('ramon','fernandez','lopez'), "+
	"('maria','rodriguez','casado'), "+
	"('pepe','garcia','moreno');";
	
	public static String INSERT_MUNICIPIO = "insert into Municipio (nombre,cod_Provincia,cod_Municipio) values "+
	 "('Alcobendas',1,1), "+
	"('Colmenar',1,2), "+
	"('Pozuelo',2,1), "+
	"('Las Rozas',2,2)";
	
	public static String INSERT_DIRECCION = "insert into Direccion (municipio_id,calle,numero,provincia) values "
			+ "(1,'calle 1',2,'Madrid'), "+
	"(2,'calle 2',3,'Madrid'), "+
	"(3,'calle 3',4,'Madrid'), "+
	"(4,'calle 4',5,'Madrid'); ";
	
	public static String INSERT_PROFESOR_DIRECCION = "insert into Profesor_Direccion (direccion_id,nombre_id) values "
			+ "(1,1), "+
	"(2,2), "+
	"(3,3), "+
	"(4,4);";
	
	public static String INSERT_CORREO ="insert into Correo(profesor_direccion_id,direccion,proveedor) values"
			+ "(1,'mail@gmail.com','gmail'), "+
	"(1,'mail@yahoo.com','yahoo'), "+
	" (2,'mail2@yahoo.com','yahoo'), "+
	"(3,'mail3@gmail.com','gmail'), "+
	"(3,'mail3@yahoo.com','yahoo');";


	/**
	 * Navegar por una propiedad
	 */
	public void navegarPropiedad(Session session) {
/*
		System.out.println("----------- Navegar por una propiedad -----------");
		Query query = session.getNamedQuery("findApeProfesor");
        String ape1 = (String) query.uniqueResult();
        System.out.println("Ape1="+ape1);*/
	}

	/**
	 * Navegar por varias propiedades enlazadas
	 */
	public void navegarPropiedadesEnlazadas(Session session) {
/*
		System.out.println("----------- Navegar por varias propiedades enlazadas-----------");
		Query query = session.getNamedQuery("findApeMunicipio");
        List<Object[]> listDatos = (List<Object[]>) query.list();
        for (Object[] datos : listDatos) {
            System.out.println("El profesor " + datos[0] + " vive en " + datos[1]);
        }*/
	}

	/**
	 * Función SIZE en colecciones
	 */
	public void sizeColeccion(Session session) {
		/* System.out.println("----------- Función SIZE en colecciones -----------");
		 Query query = session.getNamedQuery("findApeNumCorreos");
         List<Object[]> listDatos = (List<Object[]>) query.list();
         for (Object[] datos : listDatos) {
             System.out.println("El profesor " + datos[0] + " tiene  " + datos[1]+ " direcciones de correo electrónico");
         }*/
	}

	/**
	 * Función IS EMPTY en colecciones
	 */
	public void isEmptyColecciones(Session session) {
		/*  System.out.println("----------- Función IS EMPTY en colecciones -----------");
		  Query query = session.getNamedQuery("findProfSinCorreos");
          List<Object> listDatos = (List<Object>) query.list();
          for (Object datos : listDatos) {
              System.out.println("El profesor " + datos + " no tiene  direcciones de correo electrónico");
          }*/
	}

	
	private static void insertInicial() {
		

		// abrimos una transacción
		man.getTransaction().begin();		
				
		man.createNativeQuery(INSERT_NOMBRE).executeUpdate();		
		man.createNativeQuery(INSERT_MUNICIPIO).executeUpdate();		
		man.createNativeQuery(INSERT_DIRECCION).executeUpdate();		
		man.createNativeQuery(INSERT_PROFESOR_DIRECCION).executeUpdate();		
		man.createNativeQuery(INSERT_CORREO).executeUpdate();		

		
		// Commit de la transacción
		man.getTransaction().commit();
		// Cerramos el EntityManager
		
		
		
	}	

	private static void Consulta(String HQL) {

		man = Utilidades.getEntityManagerFactory().createEntityManager();

		@SuppressWarnings("unchecked")
		List<Object> objetos = man.createQuery(HQL).getResultList();

		for (Object obj : objetos) {
			System.out.println(obj);
		}

		man.close();
	}
	public static void main(String[] args) {
		man = Utilidades.getEntityManagerFactory().createEntityManager();

		insertInicial();
		Consulta("From Nombre");
		
		man.close();
		
		// Cerramos la factoria de sesiones, sino el programa no finalizará
		Utilidades.getEntityManagerFactory().close();
	}

}
