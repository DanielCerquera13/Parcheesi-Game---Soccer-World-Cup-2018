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
        	  
        	equipo.getDadoUno().setValor(1);
        	equipo.getDadoDos().setValor(1);
        	
    boolean valor =    	equipo.lanzamientoPar();
    
    assertTrue(valor);
        	
        }
        
        
        /**
         * verifica que el usuario puede hacer tres tiros
         */
        @Test
        public void testTresLanzamientos() {
        	 
        	escenario1();
        	
        	   equipo.getFichas()[0].setLibre(false);
        	   equipo.getFichas()[1].setLibre(false);
        	   equipo.getFichas()[2].setLibre(false);
        	   equipo.getFichas()[3].setLibre(false);

        	  boolean valor = equipo.verificarTresTiros();
        	  assertTrue(valor);
        }
        
        /**
         * verifica que las fichas se encuentras en la carcel
         */
        @Test
        public void testFichasEnCarcel() 
        {
        	 escenario1(); 
        	 
        	     equipo.getFichas()[0].setLibre(false);
        	     equipo.getFichas()[1].setLibre(false);
        	     equipo.getFichas()[2].setLibre(false);
        	     equipo.getFichas()[3].setLibre(false);
        	     
        	     
        	     boolean valor = equipo.fichasEnLaCarcel();

        	assertTrue(valor);
        }
        
        
        
        
        
        
        
}











