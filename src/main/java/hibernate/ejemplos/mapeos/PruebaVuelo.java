package hibernate.ejemplos.mapeos;

import java.util.Date;

import javax.persistence.EntityManager;

import hibernate.ejemplos.autor.utilidades.Utilidades;
import hibernate.ejemplos.mapeos.Vuelo.TipoVuelo;

//import transparencias.mapeos.Vuelo.TipoVuelo;

public class PruebaVuelo {
	static EntityManager man ;

	/**
	 * Método para actualizar un autor
	 * 
	 * @param aut
	 */
	public void creaActualizaVuelo(Vuelo vuelo) {
		// Conseguimos un objeto EntityManager para comunicarnos con la BD
		// abrimos una transacción
		man.getTransaction().begin();
		// Actualizamos
		man.persist(vuelo);			
		// Commit de la transacción
		man.getTransaction().commit();
	

	}

	/**
	 * Método para recuperar un vuelo
	 * 
	 * @param id
	 * @return
	 */
	public Vuelo recuperaVuelo(int id) {
		// Conseguimos un objeto EntityManager para comunicarnos con la BD
		Vuelo vuelo = new Vuelo();

		// abrimos una transacción
		man.getTransaction().begin();
		// Recuperamos el seguro
		vuelo = man.find(Vuelo.class, id);
		// Commit de la transacción
		man.getTransaction().commit();
		
		man.close();

		return vuelo;
	}

	public static void main(String[] args) {
		man = Utilidades.getEntityManagerFactory().createEntityManager();

		Vuelo vue = new Vuelo();

		Vuelo vueR;

		vue.setHoraSalida(new Date());
		char[] codigo={'A','0','2','3',};
		vue.setCodigo(codigo);
		vue.setLongitud(5);
		vue.setNumero(333);
		vue.setTexto("Vuelo de prueba");
		vue.setTipo(TipoVuelo.ASIA);
		

		PruebaVuelo prueba = new PruebaVuelo();
		prueba.creaActualizaVuelo(vue);
		// Hibernate sincroniza el estado del objeto para que tenga el id
		// autogenerado de BD
		System.out.println("Vuelo almacenado:" + vue.getId());
		vueR = prueba.recuperaVuelo(vue.getId());
		System.out.println("Vuelo recuperado:" + vueR.toString());

		man.close();
		
		// Cerramos la factoria de sesiones, sino el programa no finalizará
		Utilidades.getEntityManagerFactory().close();
	}

}
