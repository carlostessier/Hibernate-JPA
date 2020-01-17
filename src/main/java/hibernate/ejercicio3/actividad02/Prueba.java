package hibernate.ejercicio3.actividad02;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import hibernate.ejemplos.autor.modelo.Libro;
import hibernate.ejemplos.autor.utilidades.Utilidades;
import hibernate.ejemplos.consultas.hql.PruebaConsultasHQL;

public class Prueba {
	static EntityManager man ;

	/**
	 * Solución a la consulta 1 de los ejercicios 3
	 */
	public void consulta1( ) {

		System.out.println("----------- Consulta 1 -----------");		

		@SuppressWarnings("unchecked")
		List<Object[]> listDatos = man.createNamedQuery("consulta1").getResultList();

		for (Object[]  datos : listDatos) {
            System.out.println("El correo " + datos[0] + " tiene de proveedor " + datos[1]);
		}
		
	
	}

	public void consulta2( ) {

		System.out.println("----------- Consulta 2 -----------");
	
		@SuppressWarnings("unchecked")
		List<Object[]> listDatos = man.createNamedQuery("consulta2").getResultList();

		for (Object[]  datos : listDatos) {
            System.out.println("El proveedor " + datos[0] + " tiene " + datos[1] + " correos");
		}
	}
	
	public void consulta3( ) {

		System.out.println("----------- Consulta 3 -----------");
	
        @SuppressWarnings("unchecked")
		List<Object[]> listDatos = man.createNamedQuery("consulta3").getResultList();

		for (Object[]  datos : listDatos) {
            System.out.println("El proveedor " + datos[0] + " tiene " + datos[1] + " correos");
		}
	}
	
	public void consulta4( ) {

		System.out.println("----------- Consulta 4 -----------");
		/*Query query = session.getNamedQuery("consulta4");
		query.setParameter("prov", "gmail");
		Object[] datos = (Object[]) query.uniqueResult();       
        System.out.println("El proveedor " + datos[0] + " tiene " + datos[1] + " correos");
        */
        @SuppressWarnings("unchecked")
		Query query = man.createNamedQuery("consulta4") ;
		query.setParameter("prov", "gmail");

		List<Object[]> listDatos = query.getResultList();

		for (Object[]  datos : listDatos) {
	        System.out.println("El proveedor " + datos[0] + " tiene " + datos[1] + " correos");
		}
	}
	
	public void consulta5( ) {

		System.out.println("----------- Consulta 5 -----------");/*
		Query query = session.getNamedQuery("consulta5");
		query.setParameter("idProfesor", 1);
		Object[] datos = (Object[]) query.uniqueResult();       
        System.out.println("El profesor con apellido " + datos[0] + " vive en la calle " + datos[1] 
        		+ " de la provincia " +datos[2] + " perteneciente al municipio de " + datos[3]);
       */
	}
	
	public void consulta6( ) {
		System.out.println("----------- Consulta 6 -----------");/*
		Query query = session.getNamedQuery("consulta6");
		List<Object> listDatos = query.list();
		for (Object datos : listDatos) {
			System.out.println("Municipio "+datos);
		}*/
	}
	
	public void consulta7( ) {

		System.out.println("----------- Consulta 7 -----------");/*
		Query query = session.getNamedQuery("consulta7");
		List<Object[]> listDatos = (List<Object[]>) query.list();
        for (Object[] datos : listDatos) {
            System.out.println("El promedio es " + datos[0] + " el mínimo es " + datos[1] +" y el máximo es "+datos[2] );
        }*/
	}
	
	public static void main(String[] args) {
		man = Utilidades.getEntityManagerFactory().createEntityManager();
		
		insertInicial();
		
		Prueba prueba = new Prueba();
		prueba.consulta1();
		prueba.consulta2();
		prueba.consulta3();
		prueba.consulta4();
		prueba.consulta5();
		prueba.consulta6();
		prueba.consulta7();
		

		man.close();
		
		// Cerramos la factoria de sesiones, sino el programa no finalizará
		Utilidades.getEntityManagerFactory().close();
	}
	
private static void insertInicial() {
		

		// abrimos una transacción
		man.getTransaction().begin();		
				
		man.createNativeQuery("insert into coberturas(oftalmologia,dental,fecundacionInVitro) values ('F','T','T');").executeUpdate();		
		man.createNativeQuery("insert into coberturas(oftalmologia,dental,fecundacionInVitro) values ('F','T','T');").executeUpdate();		
		//man.createNativeQuery("	insert into enfermedades(corazon,estomacal,rinones,alergia,nombreAlergia) values ('Y','N','Y','N',null);").executeUpdate();		
		//man.createNativeQuery("	insert into enfermedades(corazon,estomacal,rinones,alergia,nombreAlergia) values ('Y','N','Y','N',null);").executeUpdate();		
		//man.createNativeQuery("	insert into nif(nif) values('9784563J');").executeUpdate();		
		//man.createNativeQuery("	insert into seguro(id_nif,id_coberturas,id_enfermedades,nombre,ape1,ape2,edad,sexo,embarazada,casado,numHijos,fechaCreacion) values(1,1,1,'maria','garcia','lozano',39,0,true,false,5,'2015-10-30');").executeUpdate();
		//man.createNativeQuery("	insert into asistenciaMedica(id_seguro,breveDescripcion,lugar,explicacion,tipoAsistencia,fecha,hora,importe) values(1,'descripcion a','Pozuelo','explicacion a','DOMICILIARIA','2015-11-23','12:47:00',15000);").executeUpdate();
		//man.createNativeQuery("	insert into asistenciaMedica(id_seguro,breveDescripcion,lugar,explicacion,tipoAsistencia,fecha,hora,importe) values(1,'descripcion a','Alcobendas','explicacion b','HOSPITALARIA','2015-12-1','14:23:00',25000);").executeUpdate();
		
		// Commit de la transacción
		man.getTransaction().commit();
		// Cerramos el EntityManager
		
		
		
	}	
	

}
