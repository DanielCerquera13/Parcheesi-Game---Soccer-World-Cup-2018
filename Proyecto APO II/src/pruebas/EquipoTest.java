package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import modelo.Constantes;
import modelo.Equipo;

class EquipoTest extends TestCase implements Constantes{

	
	
	private Equipo equipo;
	
	public void escenario1() {
		
		equipo = new Equipo("bandera", "colombia", 1);
	}
	
	/**
	 * Verifica que las fichas se inicializan correctamente
	 */
	@Test
	public void testRellenarFichas() {
		
		escenario1();
		
		assertEquals(1, equipo.getFichas()[0].getTipo());
		assertEquals(1, equipo.getFichas()[1].getTipo());
		assertEquals(1, equipo.getFichas()[2].getTipo());
		assertEquals(1, equipo.getFichas()[3].getTipo());

		
	}
	
	/**
	 * Verifica que se simula el lanzamiento de dados.
	 */
	@Test
	public void testLanzarDados() {
		
		escenario1();
		equipo.lanzarDados();
		
		System.out.println(equipo.getDadoDos().getValor());
		assertTrue(equipo.getDadoUno().getValor()>0);
		assertTrue(equipo.getDadoUno().getValor()<7);
		assertTrue(equipo.getDadoDos().getValor()>0);
		assertTrue(equipo.getDadoDos().getValor()<7);

	}
	
	/**
	 * Verifica que se realizo un lanzamiento par.
	 */
        @Test
        public void testLanzamientoPar() 
        {
        	escenario1();
        	
        	
        }
}
