package hibernate.ejemplos.consultas.hql;

 
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
 
/**
 * Responsable de crear un objeto sesión (gestiona la conexión a BD de forma transparente
 * @author Laura y Carlos
 *
 */
public class Utilidades {
	
	 
	    //Factoria de sesión para crear objeto sesión a partir de XML
	    private static SessionFactory sessionFactory;
	    
		private static EntityManagerFactory emf;
		
		private static EntityManagerFactory buildEntityManagerFactory(){
			
			emf = Persistence.createEntityManagerFactory("Persistencia");
			
			return emf;
		}
	     
	    private static SessionFactory buildSessionFactory() {
	        try {
	            // Creamos una factoría de sesiones con los datos de hibernate.cfg.xml
	            Configuration configuration = new Configuration();
	            configuration.configure("hibernate.cfg.xml");
	            System.out.println("Configuración de Hibernate Cargada");
	             
	            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
	            System.out.println("Servicio de registro de Hibernate Realizado");
	             
	            SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	             
	            return sessionFactory;
	        }
	        catch (Throwable ex) {
	            // En un caso real se registra en un log
	            System.err.println("Falló la creación de la factoría de sesiones inicial." + ex);
	            throw new ExceptionInInitializerError(ex);
	        }
	    }
	    
	    /*
	     * Método estático (Fachada) para crear la factoría de sesiones
	     */
	    public static SessionFactory getSessionFactory() {
	        if(sessionFactory == null) sessionFactory = buildSessionFactory();
	        return sessionFactory;
	    }
	    
	    /*
	     * Método estático (Fachada) para crear la factoría de Entidades
	     */
	    public static EntityManagerFactory getEntityManagerFactory() {
	        if(emf == null) emf = buildEntityManagerFactory();
	        return emf;
	    }

}
