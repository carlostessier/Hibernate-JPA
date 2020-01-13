package hibernate.ejercicios1.ejercicio1_4;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import hibernate.ejercicios1.ejercicio1_4.Seguro.TipoSeguro;
import hibernate.ejercicios1.ejercicio1_4.Seguro.TipoSexo;

public class TestSeguro {
	
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");
	
	public static void main(String [] args) {
		
		EntityManager man = emf.createEntityManager();	
			
		 insertInicial();		
		
		
		man.getTransaction().begin();	
		
		Seguro s = man.find(Seguro.class, 1);		
		
		man.getTransaction().commit();
		
		man.close();
		
		
		
		man = emf.createEntityManager();
		
		man.getTransaction().begin();	
		
		s = man.merge(s);
		
		s.setNombre("juan");		
		
		man.getTransaction().commit();
		
		man.close();
		
		
		imprimirTodo();
		
	}
	
	private static void insertInicial() {
		
		EntityManager man = emf.createEntityManager();		
		
		
		man.getTransaction().begin();
		
		man.persist(new Seguro("1234567", "pepe", "garcía", "fernández", 36, 2, 
				Seguro.TipoSexo.HOMBRE, Seguro.TipoSeguro.HOGAR, true,  LocalDate.of(2020,1,1)));
		man.persist(new Seguro( "17546586R", "JOAQUIM", "SORIA", "SORIA", 19, 0, 
				Seguro.TipoSexo.HOMBRE, Seguro.TipoSeguro.HOGAR, true,  LocalDate.of(2019,1,1)));
		
		man.getTransaction().commit();
		
		man.close();
		
	}

	private static void imprimirTodo() {
		
		EntityManager man = emf.createEntityManager();		

		List<Seguro>  seguros = (List<Seguro>) man.createQuery("FROM Seguro").getResultList();
		
		System.out.println("Hay "+seguros.size()+ " seguros en el sistema");
		
		for(Seguro seguro:seguros) {
			System.out.println(seguro);
		}
		
		man.close();
	}

}
