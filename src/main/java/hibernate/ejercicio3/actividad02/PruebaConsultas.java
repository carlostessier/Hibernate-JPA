package hibernate.ejercicio3.actividad02;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernate.ejercicio1.SeguroMedico;

public class PruebaConsultas {

	public void consulta1(Session session) {

		System.out.println("----------- Consulta 1 -----------");
		Query query = session.getNamedQuery("consulta1");

		List<SeguroMedico> seguros = query.list();
		for (SeguroMedico seguro : seguros) {
			System.out.println(seguro.toString());
		}
	}

	public void consulta2(Session session) {

		System.out.println("----------- Consulta 2 -----------");
		Query query = session.getNamedQuery("consulta2");
		List<Object[]> listDatos = (List<Object[]>) query.list();
		for (Object[] datos : listDatos) {
			System.out.println("El nombre es " + datos[0] + " y el nif "
					+ datos[1]);
		}
	}

	public void consulta3(Session session) {

		System.out.println("----------- Consulta 3 -----------");
		Query query = session.getNamedQuery("consulta3");
		query.setParameter("nom", "Maria");
		query.setParameter("ap1", "Garcia");
		query.setParameter("ap2", "Lozano");
		Object datos = (Object) query.uniqueResult();
		System.out.println("El nif es " + datos);

	}

	/**
	 * Solución a la consulta 4 de los ejercicios 3
	 */
	public void consulta4(Session session) {

		System.out.println("----------- Consulta 4 -----------");
		Query query = session.getNamedQuery("consulta4");
		List<Object[]> listDatos = (List<Object[]>) query.list();
		for (Object[] datos : listDatos) {
			System.out.println("Asistencia  " + datos[0] + " con importe "
					+ datos[1]);
		}
	}

	public void consulta5(Session session) {

		System.out.println("----------- Consulta 5-----------");
		Query query = session.getNamedQuery("consulta5");
		query.setParameter("imp1", new BigDecimal(8000));
		query.setParameter("imp2", new BigDecimal(15000));
		List<Object[]> listDatos = (List<Object[]>) query.list();
		for (Object[] datos : listDatos) {
			System.out.println("Asistencia  " + datos[0] + " con importe "
					+ datos[1]);
		}

	}

	public void consulta6(Session session) {

		System.out.println("----------- Consulta 6 -----------");
		Query query = session.getNamedQuery("consulta6");
		Object datos = (Object) query.uniqueResult();
		System.out.println("La suma de importes es " + datos);

	}

	public void consulta7(Session session) {

		System.out.println("----------- Consulta 7 -----------");
		Query query = session.getNamedQuery("consulta7");
		Object datos = (Object) query.uniqueResult();
		System.out.println("El promedio de importes es " + datos);

	}

	public void consulta8(Session session) {

		System.out.println("----------- Consulta 8 -----------");
		Query query = session.getNamedQuery("consulta8");
		Object datos = (Object) query.uniqueResult();
		System.out.println("El número de seguros es " + datos);

	}

	public void consulta9(Session session) {

		System.out.println("----------- Consulta 9 -----------");
		Query query = session.getNamedQuery("consulta9");
		List<Object[]> listDatos = (List<Object[]>) query.list();
		for (Object[] datos : listDatos) {
			System.out.println("El seguro de " + datos[0] + " con nif "
					+ datos[1] + " tiene " + datos[2] +" asistencias médicas");
		}
	}

	public void consulta10(Session session) {

		System.out.println("----------- Consulta 10-----------");
		Query query = session.getNamedQuery("consulta10");
		List<Object[]> listDatos = (List<Object[]>) query.list();
		for (Object[] datos : listDatos) {
			System.out.println("El seguro de " + datos[0] + " tiene alergia "
					+ datos[1]);
		}

	}

	public void consulta11(Session session) {

		System.out.println("----------- Consulta 11 -----------");
		Query query = session.getNamedQuery("consulta1");
		List<Seguro> seguros = query.list();
		for (Seguro seguro : seguros) {
			System.out.println("Seguro "+seguro.getIdSeguro());
			List<AsistenciaMedica> asistencias=seguro.getAsistencias();
			for (int i=0;i<asistencias.size();i++){
				System.out.println("Asistencia "+asistencias.get(i).getId());
			}
		}
	}
	
	public static void main(String[] args) {

		Session session = Utilidades.getSessionFactory().openSession();
		PruebaConsultas prueba = new PruebaConsultas();
		prueba.consulta1(session);
		prueba.consulta2(session);
		prueba.consulta3(session);
		prueba.consulta4(session);
		prueba.consulta5(session);
		prueba.consulta6(session);
		prueba.consulta7(session);
		prueba.consulta8(session);
		prueba.consulta9(session);
		prueba.consulta10(session);
		prueba.consulta11(session);
		Utilidades.getSessionFactory().close();
	}

}
