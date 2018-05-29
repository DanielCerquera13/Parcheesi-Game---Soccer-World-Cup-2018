package pruebas;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import modelo.Ficha;

public class FichaTest extends TestCase {
   
	
	Ficha ficha ;
	
	
	public void escenario1() {
		
		ficha = new Ficha("colombia", 1);
	}
	

	public void escenario2() {
		
		ficha = new Ficha("colombia", 2);
		
		
	}
	
	 
	/**
	 * verifica que la simulacion de salir de la carcel sea correcta
	 */
	@Test
	public void testSalirCarcel() {
		 
		escenario1();
		
		ficha.salirDeLaCarcel();
		
		assertTrue(ficha.isLibre());
		
	}
	
	/**
	 * verifica que las fichas 2,3,4 saltan la ultima casilla.
	 */
	
	@Test 
	public void testSaltar() {
		escenario2();
		 
		boolean valor = ficha.saltarUltimaCasilla();
		
		assertTrue(valor);
		
	}
	
}
