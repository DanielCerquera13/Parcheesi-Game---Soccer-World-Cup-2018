package pruebas;

import junit.framework.TestCase;
import modelo.Ficha;

public class FichaTest extends TestCase {
   
	
	Ficha ficha ;
	
	
	public void escenario1() {
		
		ficha = new Ficha("colombia", 1);
	}
	
	 
	/**
	 * verifica que la simulacion de salir de la carcel sea correcta
	 */
	public void testSalirCarcel() {
		 
		escenario1();
		
		ficha.salirDeLaCarcel();
		
		assertTrue(ficha.isLibre());
		
	}
	
	
	
}
