package hibernate.ejercicio3.actividad03;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import hibernate.ejemplos.autor.utilidades.Utilidades;
import hibernate.ejercicio1.SeguroMedico;

public class PruebaConsultas {
	
	static EntityManager man ;


	public void consulta1( ) {

		System.out.println("----------- Consulta 1 -----------");	
		
		@SuppressWarnings("unchecked")
		List<Seguro> seguros = man.createNamedQuery("consultaSeguro1").getResultList();

		for (Seguro  seguro : seguros) {
			System.out.println(seguro);
		}
	}

	public void consulta2( ) {

		System.out.println("----------- Consulta 2 -----------");	
		@SuppressWarnings("unchecked")
		List<Object[]> listDatos = man.createNamedQuery("consultaSeguro2").getResultList();

		for (Object[]  datos : listDatos) {
			System.out.println("El nombre es " + datos[0] + " y el nif "+ datos[1]);
		}
	}

	public void consulta3( ) {

		System.out.println("----------- Consulta 3 -----------");/*
		Query query = session.getNamedQuery("consulta3");
		query.setParameter("nom", "Maria");
		query.setParameter("ap1", "Garcia");
		query.setParameter("ap2", "Lozano");
		Object datos = (Object) query.uniqueResult();
		System.out.println("El nif es " + datos);*/
		@SuppressWarnings("unchecked")
		Query query = man.createNamedQuery("consultaSeguro3") ;
		query.setParameter("nom", "Maria");
		query.setParameter("ap1", "Garcia");
		query.setParameter("ap2", "Lozano");
		List<Object> listDatos = query.getResultList();
		for (Object  datos : listDatos) {
			System.out.println("El nif es " + datos);
		}

		

	}

	/**
	 * Solución a la consulta 4 de los ejercicios 3
	 */
	public void consulta4( ) {

		System.out.println("----------- Consulta 4 -----------");/*
		Query query = session.getNamedQuery("consulta4");
		List<Object[]> listDatos = (List<Object[]>) query.list();
		for (Object[] datos : listDatos) {
			System.out.println("Asistencia  " + datos[0] + " con importe "
					+ datos[1]);
		}*/
		@SuppressWarnings("unchecked")
		List<Object[]> listDatos = man.createNamedQuery("consultaSeguro4").getResultList();

		for (Object[]  datos : listDatos) {
			System.out.println("Asistencia  " + datos[0] + " con importe "
					+ datos[1]);
		}
	}

	public void consulta5( ) {

		System.out.println("----------- Consulta 5-----------");/*
		Query query = session.getNamedQuery("consulta5");
		query.setParameter("imp1", new BigDecimal(8000));
		query.setParameter("imp2", new BigDecimal(15000));
		List<Object[]> listDatos = (List<Object[]>) query.list();
		for (Object[] datos : listDatos) {
			System.out.println("Asistencia  " + datos[0] + " con importe "
					+ datos[1]);
		}*/
		@SuppressWarnings("unchecked")
		Query query = man.createNamedQuery("consultaSeguro5") ;
		
		query.setParameter("imp1", new BigDecimal(8000));
		query.setParameter("imp2", new BigDecimal(16000));
		List<Object[]> listDatos = query.getResultList();
		for (Object[]  datos : listDatos) {
			System.out.println("Asistencia  " + datos[0] + " con importe "
					+ datos[1]);
		}

	}

	public void consulta6( ) {

		System.out.println("----------- Consulta 6 -----------");/*
		Query query = session.getNamedQuery("consulta6");
		Object datos = (Object) query.uniqueResult();
		System.out.println("La suma de importes es " + datos);*/
		@SuppressWarnings("unchecked")
		List<Object> listDatos = man.createNamedQuery("consultaSeguro6").getResultList();

		for (Object  datos : listDatos) {
			System.out.println("La suma de importes es " + datos);
		}
	}

	public void consulta7( ) {

		System.out.println("----------- Consulta 7 -----------");/*
		Query query = session.getNamedQuery("consulta7");
		Object datos = (Object) query.uniqueResult();
		System.out.println("El promedio de importes es " + datos);*/
		@SuppressWarnings("unchecked")
		List<Object> listDatos = man.createNamedQuery("consultaSeguro7").getResultList();

		for (Object  datos : listDatos) {
			System.out.println("El promedio de importes es " + datos);
		}
	}

	public void consulta8( ) {

		System.out.println("----------- Consulta 8 -----------");/*
		Query query = session.getNamedQuery("consulta8");
		Object datos = (Object) query.uniqueResult();
		System.out.println("El número de seguros es " + datos);*/
		@SuppressWarnings("unchecked")
		List<Object> listDatos = man.createNamedQuery("consultaSeguro8").getResultList();

		for (Object  datos : listDatos) {
			System.out.println("El número de seguros es " + datos);
		}
		
	}

	public void consulta9( ) {

		System.out.println("----------- Consulta 9 -----------");/*
		Query query = session.getNamedQuery("consulta9");
		List<Object[]> listDatos = (List<Object[]>) query.list();
		for (Object[] datos : listDatos) {
			System.out.println("El seguro de " + datos[0] + " con nif "
					+ datos[1] + " tiene " + datos[2] +" asistencias médicas");
		}*/
		@SuppressWarnings("unchecked")
		List<Object[]> listDatos = man.createNamedQuery("consultaSeguro9").getResultList();

		for (Object[]  datos : listDatos) {
			System.out.println("El seguro de " + datos[0] + " con nif "
					+ datos[1] + " tiene " + datos[2] +" asistencias médicas");
		}
	}

	public void consulta10( ) {

		System.out.println("----------- Consulta 10-----------");/*
		Query query = session.getNamedQuery("consulta10");
		List<Object[]> listDatos = (List<Object[]>) query.list();
		for (Object[] datos : listDatos) {
			System.out.println("El seguro de " + datos[0] + " tiene alergia "
					+ datos[1]);
		}*/
		@SuppressWarnings("unchecked")
		List<Object[]> listDatos = man.createNamedQuery("consultaSeguro10").getResultList();

		for (Object[]  datos : listDatos) {
			System.out.println("El seguro de " + datos[0] + " tiene alergia "
					+ datos[1]);
		}

	}

	public void consulta11( ) {

		System.out.println("----------- Consulta 11 -----------");/*
		Query query = session.getNamedQuery("consulta1");
		List<Seguro> seguros = query.list();
		for (Seguro seguro : seguros) {
			System.out.println("Seguro "+seguro.getIdSeguro());
			List<AsistenciaMedica> asistencias=seguro.getAsistencias();
			for (int i=0;i<asistencias.size();i++){
				System.out.println("Asistencia "+asistencias.get(i).getId());
			}
		}*/
		@SuppressWarnings("unchecked")
		List<Seguro> seguros = man.createQuery("from Seguro").getResultList();

		for (Seguro seguro : seguros) {
			System.out.println(seguro);
			List<AsistenciaMedica> asistencias=seguro.getAsistencias();
			for (int i=0;i<asistencias.size();i++){
				System.out.println("Asistencia "+asistencias.get(i).getId());
			}
		}
	}
	
	public static void main(String[] args) {

		man = Utilidades.getEntityManagerFactory().createEntityManager();
		PruebaConsultas prueba = new PruebaConsultas();
		
		insertInicial()	;
		prueba.consulta1();
		prueba.consulta2();
		prueba.consulta3();
		prueba.consulta4();
		prueba.consulta5();
		prueba.consulta6();
		prueba.consulta7();
		prueba.consulta8();
		prueba.consulta9();
		prueba.consulta10();
		prueba.consulta11();
		
		man.close();
		
		// Cerramos la factoria de sesiones, sino el programa no finalizará
		Utilidades.getEntityManagerFactory().close();	}
	
private static void insertInicial() {
		

		// abrimos una transacción
		man.getTransaction().begin();		
				
		man.createNativeQuery("insert into coberturas(oftalmologia,dental,fecundacionInVitro) values ('F','T','T');").executeUpdate();		
		man.createNativeQuery("insert into coberturas(oftalmologia,dental,fecundacionInVitro) values ('F','T','T');").executeUpdate();		
		man.createNativeQuery("	insert into enfermedades(corazon,estomacal,rinones,alergia,nombreAlergia) values ('Y','N','Y','N',null);").executeUpdate();		
		man.createNativeQuery("	insert into enfermedades(corazon,estomacal,rinones,alergia,nombreAlergia) values ('Y','N','Y','N',null);").executeUpdate();		
		man.createNativeQuery("	insert into nif(nif) values('9784563J');").executeUpdate();		
		
		man.createNativeQuery("	insert into seguro(id_nif,coberturas_id,enfermedades_id,nombre,ape1,ape2,edad,sexo,embarazada,casado,numHijos,fechaCreacion) values(1,1,1,'Maria','Garcia','Lozano',39,0,true,false,5,'2015-10-30');").executeUpdate();
	
		man.createNativeQuery("	insert into asistencia_Medica(seguro_id,breveDescripcion,lugar,explicacion,tipoAsistencia,fecha,hora,importe) values(1,'descripcion a','Pozuelo','explicacion a','DOMICILIARIA','2015-11-23','12:47:00',15000);").executeUpdate();
		man.createNativeQuery("	insert into asistencia_Medica(seguro_id,breveDescripcion,lugar,explicacion,tipoAsistencia,fecha,hora,importe) values(1,'descripcion a','Alcobendas','explicacion b','HOSPITALARIA','2015-12-1','14:23:00',25000);").executeUpdate();
		
		// Commit de la transacción
		man.getTransaction().commit();
		// Cerramos el EntityManager
		
		
		
	}	

}
