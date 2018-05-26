package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import modelo.Parques;

class ParquesTest extends TestCase{

	
	private Parques parques;
	
	 
	public void escenario1() {
		
		parques = new Parques();
		
	}
	
	/**
	 * test que confirman que las casillas seguras estan inicializadas correctamente
	 */
	@Test
	public void testCasillasSeguras() {
		
		escenario1();
		
		int valor = parques.SEGURO;
		assertEquals(parques.getCasillas()[7].getTipo(), valor);
		assertEquals(parques.getCasillas()[12].getTipo(), valor);
		assertEquals(parques.getCasillas()[31].getTipo(), valor);
		assertEquals(parques.getCasillas()[36].getTipo(), valor);
		assertEquals(parques.getCasillas()[55].getTipo(), valor);
		assertEquals(parques.getCasillas()[60].getTipo(), valor);
		assertEquals(parques.getCasillas()[79].getTipo(), valor);
		assertEquals(parques.getCasillas()[84].getTipo(), valor);

	}
	
	/**
	 * 	 test que confirman que las casillas salidas estan inicializadas correctamente

	 */
	@Test
	public void testCasillasSalida(){
		
		escenario1();
		
		int valor = parques.SALIDA;
		assertEquals(parques.getCasillas()[0].getTipo(), valor);
		assertEquals(parques.getCasillas()[24].getTipo(), valor);
		assertEquals(parques.getCasillas()[48].getTipo(), valor);
		assertEquals(parques.getCasillas()[72].getTipo(), valor);
		
	}
	
	/**
	 * test que confirman que las casillas normales estan correctamente inicializadas, 
	 * basado en algunos ejemplos de casillas
	 * 
	 */
 
	@Test
	public void testCasillasNormales(){
		
	
		
		escenario1();
		
		int valor = parques.NORMAL;
		assertEquals(parques.getCasillas()[2].getTipo(), valor);
		assertEquals(parques.getCasillas()[28].getTipo(), valor);
		assertEquals(parques.getCasillas()[44].getTipo(), valor);
		assertEquals(parques.getCasillas()[78].getTipo(), valor);
		

		
	}
	
	
}
