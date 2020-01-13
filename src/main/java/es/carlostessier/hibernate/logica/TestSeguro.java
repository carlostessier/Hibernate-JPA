package es.carlostessier.hibernate.logica;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import es.carlostessier.hibernate.modelo.Seguro;
import es.carlostessier.hibernate.modelo.Seguro.TipoSeguro;
import es.carlostessier.hibernate.modelo.Seguro.TipoSexo;

public class TestSeguro {
	
	private static EntityManager manager;
	
	private static EntityManagerFactory emf;
	
	public static void main(String [] args) {
		
		emf = Persistence.createEntityManagerFactory("Persistencia");
		
		manager = emf.createEntityManager();
		

		
		Seguro s  = new Seguro("1234567", "pepe", "garcía", "fernández", 36, 2, 
				Seguro.TipoSexo.HOMBRE, Seguro.TipoSeguro.HOGAR, true, new GregorianCalendar(2020,1,1).getTime());
		
		Seguro s2  = new Seguro( "17546586R", "JOAQUIM", "SORIA", "SORIA", 19, 0, 
				Seguro.TipoSexo.HOMBRE, Seguro.TipoSeguro.HOGAR, true, new GregorianCalendar(2019,1,1).getTime());
		
		
		manager.getTransaction().begin();
		
		manager.persist(s);
		manager.persist(s2);
		
		manager.getTransaction().commit();
		
		imprimirTodo();
		
	}

	private static void imprimirTodo() {

		List<Seguro>  seguros = (List<Seguro>) manager.createQuery("FROM Seguro").getResultList();
		
		System.out.println("Hay "+seguros.size()+ " seguros en el sistema");
		
		for(Seguro seguro:seguros) {
			System.out.println(seguro);
		}
	}

}
