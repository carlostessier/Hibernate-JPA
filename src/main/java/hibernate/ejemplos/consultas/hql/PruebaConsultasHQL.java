package hibernate.ejemplos.consultas.hql;

import java.util.List;

import javax.persistence.EntityManager;


import hibernate.ejemplos.autor.utilidades.Utilidades;
import hibernate.ejercicio2.Ciclo;

import hibernate.ejercicio2.Profesor;

public class PruebaConsultasHQL {
	
	static EntityManager man ;

	/*

	/**
	 * Simple consulta con HQL
	 */
	public void consultaSimple() {

		System.out.println("----------- Simple consulta con HQL -----------");

		@SuppressWarnings("unchecked")
		List<Ciclo> ciclos = man.createQuery("SELECT c FROM Ciclo c ORDER BY nombre").getResultList();

		for (Ciclo ciclo : ciclos) {
			System.out.println(ciclo);
		}
	}

	/**
	 * Uso de AND y OR
	 */
	public void logicos( ) {

		System.out.println("----------- Uso de AND y OR -----------");

		@SuppressWarnings("unchecked")
		List<Profesor> profesores = 	man.createQuery("SELECT p FROM Profesor p WHERE ape1='Garcia' AND (nombre='Juan' OR ape2='Moreno')").getResultList();

		for (Profesor profesor : profesores) {
			System.out.println(profesor);
		}
	}

	/**
	 * Funciones de agregación
	 */
	public void agregacion( ) {
		System.out.println("----------- Funciones de agregación -----------");

		@SuppressWarnings("unchecked")
		List<Object[]> datos =   man.createQuery("SELECT AVG(c.horas),SUM(c.horas),MIN(c.horas),MAX(c.horas),COUNT(*) FROM Ciclo c").getResultList();
		for (Object[]  dato : datos) {
			System.out.println("AVG(c.horas)=" + dato[0]);
			System.out.println("SUM(c.horas)=" + dato[1]);
			System.out.println("MIN(c.horas)=" + dato[2]);
			System.out.println("MAX(c.horas)=" + dato[3]);
			System.out.println("COUNT(*)=" + dato[4]);
			
		}
	
		
		
	}

	/**
	 * Concatenar Strings
	 */
	public void escalares( ) {
		System.out.println("----------- Concatenar Strings -----------");

		@SuppressWarnings("unchecked")
		List<Object> listDatos = man.createQuery("SELECT p.nombre || ' ' || p.ape1 || ' ' || p.ape2 FROM Profesor p WHERE Id=1").getResultList();

		for (Object  dato : listDatos) {
			System.out.println(dato);
		}
		
	}

	/**
	 * GROUP BY y HAVING
	 */
	public void agrupacion( ) {
		System.out.println("----------- GROUP BY y HAVING -----------");/*
	
		
		
		Query query = session
				.createQuery("SELECT ape1,count(ape1) FROM Profesor p GROUP BY ape1 HAVING count(ape1)>1 ORDER BY count(ape1)");
		List<Object[]> listDatos = (List<Object[]>) query.list();
		for (Object[] datos : listDatos) {
			System.out.println("El nombre \"" + datos[0] + "\" se repite  "
					+ datos[1] + " veces");
		}*/
		
		@SuppressWarnings("unchecked")
		List<Object[]> listDatos = man.createQuery("SELECT ape1,count(ape1) FROM Profesor p GROUP BY ape1 HAVING count(ape1)>1 ORDER BY count(ape1)").getResultList();

		for (Object[]  datos : listDatos) {
			System.out.println("El nombre \"" + datos[0] + "\" se repite  "
					+ datos[1] + " veces");
		}
	}

	/**
	 * GROUP BY y HAVING
	 */
	public void subconsulta( ) {
		System.out.println("----------- Subconsultas -----------");

		@SuppressWarnings("unchecked")
		List<Object[]> listDatos = man.createQuery("SELECT c.nombre,c.horas FROM Ciclo c WHERE c.horas >  (SELECT  AVG(c2.horas) FROM Ciclo c2)").getResultList();

		for (Object[]  datos : listDatos) {
			System.out
			.println("El ciclo \""
					+ datos[0]
					+ "\" es de "
					+ datos[1]
					+ " horas, siendo mayor que la media de horas de todos los ciclos");
		}
	}

	public static void main(String[] args) {
		
		
		man = Utilidades.getEntityManagerFactory().createEntityManager();
		
		PruebaConsultasHQL prueba = new PruebaConsultasHQL();
		
		prueba.insertInicial();
		prueba.consultaSimple();
		prueba.logicos();
		prueba.agregacion();
		prueba.escalares();
		prueba.agrupacion();
		prueba.subconsulta();
		
		man.close();
		
		// Cerramos la factoria de sesiones, sino el programa no finalizará
		Utilidades.getEntityManagerFactory().close();
	}


	private void insertInicial() {
		man.getTransaction().begin();
		man.persist(new Ciclo("daw",150))  ;
		man.persist(new Ciclo("dam",170))  ;
		man.persist(new Ciclo("asir",220))  ;
		
		man.persist((new Profesor("Juan", "Garcia","Lopez", null, null , null )));
		man.persist((new Profesor("Maria", "Rodriguez","Casado", null, null , null )));
		man.persist((new Profesor("Pepe", "Garcia","Moreno", null, null , null )));				
		
		man.getTransaction().commit();			
	}

}
