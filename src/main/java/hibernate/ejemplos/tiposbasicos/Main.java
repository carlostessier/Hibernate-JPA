package hibernate.ejemplos.tiposbasicos;



import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import hibernate.ejemplos.autor.utilidades.Utilidades;


/**
 *
 * @author Lorenzo
 */
public class Main {
	static EntityManager man ;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

 
        Date date=new Date();
        byte array[]={(byte)0x45,(byte)0xF5,(byte)0x3A,(byte)0x67,(byte)0xFF};
               
        TiposBasicosMin tiposBasicos1=new TiposBasicosMin();
        tiposBasicos1.setInte(3);
        tiposBasicos1.setLong1(12);
        tiposBasicos1.setShort1((short)13);
        tiposBasicos1.setFloat1(14.1F);
        tiposBasicos1.setDouble1(15.2);
        tiposBasicos1.setCharacter1('W');
        tiposBasicos1.setByte1((byte)16);
        tiposBasicos1.setBoolean1(true);
        tiposBasicos1.setYesno1(true);
        tiposBasicos1.setTruefalse1(true);
        tiposBasicos1.setStri("Hola mundo");
        tiposBasicos1.setDateDate(date);
        tiposBasicos1.setDateTime(date);
        tiposBasicos1.setDateTimestamp(date);        
        tiposBasicos1.setTexto("texto muyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy largo");
        tiposBasicos1.setBinario(array);
        tiposBasicos1.setBigDecimal(new BigDecimal("0.3"));
        tiposBasicos1.setBigInteger(new BigInteger("5345345324532"));
        
        TiposBasicosMin tiposBasicos2=new TiposBasicosMin();       
        tiposBasicos2.setInte(4);
        tiposBasicos2.setLong1(12);
        tiposBasicos2.setShort1((short)13);
        tiposBasicos2.setFloat1(14.1F);
        tiposBasicos2.setDouble1(15.2);
        tiposBasicos2.setCharacter1('W');
        tiposBasicos2.setByte1((byte)16);
        tiposBasicos2.setBoolean1(false);   //<<--- Cambiado a false
        tiposBasicos2.setYesno1(false);     //<<--- Cambiado a false
        tiposBasicos2.setTruefalse1(false); //<<--- Cambiado a false
        tiposBasicos2.setStri("Hola mundo");
        tiposBasicos2.setDateDate(date);
        tiposBasicos2.setDateTime(date);
        tiposBasicos2.setDateTimestamp(date);        
        tiposBasicos2.setTexto("texto muyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy largo");
        tiposBasicos2.setBinario(array);
        tiposBasicos2.setBigDecimal(new BigDecimal("0.3"));
        tiposBasicos2.setBigInteger(new BigInteger("5345345324532"));
                
		man = Utilidades.getEntityManagerFactory().createEntityManager();
		man.getTransaction().begin();
        
        man.persist(tiposBasicos1);
        man.persist(tiposBasicos2);

		man.getTransaction().commit();
        
		man.getTransaction().begin();
        TiposBasicosMin tiposRecuperados=man.find(TiposBasicosMin.class, tiposBasicos1.getInte());
        System.out.println(tiposRecuperados.toString());
    	man.getTransaction().commit();
		man.close();
		
		// Cerramos la factoria de sesiones, sino el programa no finalizará
		Utilidades.getEntityManagerFactory().close();


    }
}

