package hibernate.ejemplos.empleados.test;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import hibernate.ejemplos.empleados.modelo.Address;
import hibernate.ejemplos.empleados.modelo.Empleado;

public class TestEmpleados {
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");


	public static void main(String[] args) {
		
		//insertInicial();
		EntityManager man = emf.createEntityManager();
		
		man.getTransaction().begin();
		
		Address direccion = new Address("Calle de la piruleta", "Madrid", "Madrid", "Espa�a");
		Empleado empleado = new Empleado(10L,"P�rez", "Pepito", LocalDate.of(1979,6,6),direccion);
		
		//man.persist(direccion);

		man.persist(empleado);
	
		man.getTransaction().commit();
		
		man.close();
		
		imprimirTodo();

	}

	
	private static void insertInicial() {
		
		EntityManager man = emf.createEntityManager();
		
		man.getTransaction().begin();
		
		Empleado e = new Empleado(10L,"P�rez", "Pepito", LocalDate.of(1979,6,6),null);
		Empleado e2 = new Empleado(25L,"Martinez", "Jos�", LocalDate.of(1979,6,6),null);

		man.persist(e);
		man.persist(e2);
		
		man.getTransaction().commit();
		
		man.close();
		
	
	}	


	private static void imprimirTodo() {

		EntityManager man = emf.createEntityManager();

		List<Empleado> empleados = man.createQuery("FROM Empleado").getResultList();

		System.out.println("Hay " + empleados.size() + " empleados en el sistema");

		for (Empleado empleado : empleados) {
			System.out.println(empleado);
		}

		man.close();
	}

}
