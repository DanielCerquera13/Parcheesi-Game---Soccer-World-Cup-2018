package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import modelo.CasillaNormal;
import modelo.Constantes;
import modelo.Ficha;

class CasillaNormalTest extends TestCase implements Constantes {

	
	private CasillaNormal casillaNormal;
	
	
	public void escenario1() {
		
		casillaNormal = new CasillaNormal(Constantes.NORMAL);
	}
	
	
public void escenario2() {
		
		casillaNormal = new CasillaNormal(Constantes.NORMAL);
		
		Ficha ficha1= new Ficha("colombia", 2, false, false, 1); 
		   Ficha ficha2= new Ficha("colombia", 28, false, false, 1); 
		   Ficha ficha3= new Ficha("colombia", 44, false, false, 1); 
		   Ficha ficha4= new Ficha("colombia", 78, false, false, 1); 
		   
		   casillaNormal.agregarFicha(ficha1);
		   casillaNormal.agregarFicha(ficha2);
		   casillaNormal.agregarFicha(ficha3);
		   casillaNormal.agregarFicha(ficha4);

		   
	}
	
	
	/**
	 * test que verifica que se agregar correctamente fichas del mismo tipo en una casilla
	 */
	@Test
	public void testAgregarCorrectamente() {
		
		escenario1();
		
		Ficha ficha1= new Ficha("colombia", 2, false, false, 1); 
		Ficha ficha2= new Ficha("colombia", 28, false, false, 1); 
		Ficha ficha3= new Ficha("colombia", 44, false, false, 1); 
	     Ficha ficha4= new Ficha("colombia", 78, false, false, 1); 
		 
	     casillaNormal.agregarFicha(ficha1);
		   casillaNormal.agregarFicha(ficha2);
		   casillaNormal.agregarFicha(ficha3);
		   casillaNormal.agregarFicha(ficha4);
		   

		   
		   assertEquals(4, casillaNormal.casilllasOcupadas());
		
	}
	

	/**
	 * test que verifica que NO se agregan correctamente fichas de diferente tipo en una casilla
	 */
	@Test
	public void testAgregarInCorrectamente() {
		
		escenario1();
		
		Ficha ficha1= new Ficha("colombia", 2, false, false, 1); 
		Ficha ficha2= new Ficha("colombia", 28, false, false, 1); 
		Ficha ficha3= new Ficha("colombia", 44, false, false, 1); 
	     Ficha ficha4= new Ficha("colombia", 78, false, false, 2); 
		 
	     casillaNormal.agregarFicha(ficha1);
		   casillaNormal.agregarFicha(ficha2);
		   casillaNormal.agregarFicha(ficha3);
		   casillaNormal.agregarFicha(ficha4);
		   

		   
		   assertEquals(1, casillaNormal.casilllasOcupadas());
		
	}
	
	
	/**
	    * verifica que el metodo hayfichas() funciona correctamente cuando si hay fichas
	    */
	        
	   @Test
	  public void hayFichasTrue() {
		     
		   escenario2();
		   
		   assertTrue(casillaNormal.hayFichas());
	   } 
	   
	   /**
	    * verifica que el metodo hayfichas() funciona correctamente cuando no hay fichas
	    */
	        
	   @Test
	  public void hayFichasFalse() {
		     
		   escenario1();
		   
		   assertFalse(casillaNormal.hayFichas());
	   }
}
