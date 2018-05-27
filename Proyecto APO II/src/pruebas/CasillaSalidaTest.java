package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import modelo.CasillaSalida;
import modelo.Constantes;
import modelo.Ficha;

class CasillaSalidaTest extends TestCase implements Constantes{

	
	private CasillaSalida casillaSalida;

	
	public void escenario1() {
		
//		casillaSalida = new CasillaSalida(Constantes.SALIDA, 1);
		
		
	}
	
	public void escenario2() {
		
		
//		casillaSalida = new CasillaSalida(Constantes.SALIDA, 1);

		

		 
		   Ficha ficha1= new Ficha("colombia", 0, false, false, 1); 
		   Ficha ficha2= new Ficha("colombia", 24, false, false, 1); 
		   Ficha ficha3= new Ficha("colombia", 48, false, false, 1); 
		   Ficha ficha4= new Ficha("colombia", 72, false, false, 1); 

		   casillaSalida.agregarFicha(ficha1);
		   casillaSalida.agregarFicha(ficha2);
		   casillaSalida.agregarFicha(ficha3);
		   casillaSalida.agregarFicha(ficha4);
	}
	
	
	/**
	 * test donde se verifica que se puede agregar fichas correctamente en la casilla salida
	 */
	@Test
	public void testAgregarFichaCorrectamente() {
		
		escenario1(); 
		

		   Ficha ficha1= new Ficha("colombia", 0, false, false, 2); 
		   Ficha ficha2= new Ficha("colombia", 24, false, false, 2); 
		   Ficha ficha3= new Ficha("colombia", 48, false, false, 2); 
		   Ficha ficha4= new Ficha("colombia", 72, false, false, 2); 

		   casillaSalida.agregarFicha(ficha1);
		   casillaSalida.agregarFicha(ficha2);
		   casillaSalida.agregarFicha(ficha3);
		   casillaSalida.agregarFicha(ficha4);
		
		   assertEquals(4, casillaSalida.casilllasOcupadas());
		
	}
	
	/**
	 * test donde se verifica que no puede agregar fichas correctamente en la casilla salida
	 */
	@Test
	public void testAgregarFichaInCorrectamente() {
		
		escenario1(); 
		

		   Ficha ficha1= new Ficha("colombia", 0, false, false, 2); 
		   Ficha ficha2= new Ficha("colombia", 24, false, false, 2); 
		   Ficha ficha3= new Ficha("colombia", 48, false, false, 2); 
		   Ficha ficha4= new Ficha("colombia", 72, false, false, 1); 

		   casillaSalida.agregarFicha(ficha1);
		   casillaSalida.agregarFicha(ficha2);
		   casillaSalida.agregarFicha(ficha3);
		   casillaSalida.agregarFicha(ficha4);
		
		   System.out.println(casillaSalida.casilllasOcupadas());
		   assertEquals(1, casillaSalida.casilllasOcupadas());
		
	}
	
	/**
	 * test que verifica que si hay fichas en la casilla
	 */
	@Test
	public void hayFichasTrue() {
		
		escenario2();
		
		assertTrue(casillaSalida.hayFichas());
	}
	
	/**
	 * test que verifica que  no  hay fichas diferentes en la casilla
	 */
	@Test
	public void hayFichasFalse() {
		
		escenario1();
		
		assertFalse(casillaSalida.hayFichas());
	}
}
