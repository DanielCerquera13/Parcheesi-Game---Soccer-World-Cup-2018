package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import modelo.Album;
import modelo.Constantes;
import modelo.Jugador;
import modelo.Lamina;
import modelo.Pagina;

class JugadorTest extends TestCase implements Constantes{
        
	
	private Jugador jugador;
	
	Album album;
	public void escenario1() {
		jugador = new Jugador("juan", "1234");
				
				album = jugador.getAlbum();
	
	}
	
	/**
	 * verifica que se agregan correctamente los false al arreglo
	 */
	@Test
	public void testiniciarFalse() {
		
		escenario1();
		
		for (int i = 0; i < jugador.getJugadoresPintar().length; i++) {
			   assertFalse(jugador.getJugadoresPintar()[i]);
		}
	}
	
	/**
	 * verifica que se agregan laminas correctamente
	 */
	@Test
	public void testAgregarLamina() {
		
		escenario1();
		
		Lamina lamina1 = new Lamina("messi", 1);
		Lamina lamina2 = new Lamina("james", 2);
		Lamina lamina3 = new Lamina("falcao", 3);
		Lamina lamina4 = new Lamina("salah", 4);

		jugador.agregarLamina(lamina1);
		jugador.agregarLamina(lamina2);
		jugador.agregarLamina(lamina3);
		jugador.agregarLamina(lamina4);
		
		
		assertEquals(4, jugador.getLaminas().size());
		
	}
	
	/**
	 * verifica que se actualizar correctamente el valor booleano del arreglo
	 */
	@Test
	public void testVerificarTrue() {
		
		
		
		escenario1();
		
		Lamina lamina1 = new Lamina("messi", 1);
		Lamina lamina2 = new Lamina("james", 2);
		Lamina lamina3 = new Lamina("falcao", 3);
		Lamina lamina4 = new Lamina("salah", 4);

		jugador.agregarLamina(lamina1);
		jugador.agregarLamina(lamina2);
		jugador.agregarLamina(lamina3);
		jugador.agregarLamina(lamina4);
		
		
		assertTrue(jugador.getJugadoresPintar()[1]);
		assertTrue(jugador.getJugadoresPintar()[2]);
		assertTrue(jugador.getJugadoresPintar()[3]);
		assertTrue(jugador.getJugadoresPintar()[4]);

		
		
	}
	
	/**
	 *  verifica que se actualiza la informacion de las laminas para poder ser pintadas correctamente en el album
	 */
	@Test
	public void testActualizarLaminasObtenidas() {
		
		escenario1();
		
		
		Lamina lamina1 = new Lamina("messi", 1);
		Lamina lamina2 = new Lamina("james", 2);
		Lamina lamina3 = new Lamina("falcao", 3);
		Lamina lamina4 = new Lamina("salah", 4);
         
		jugador.agregarLamina(lamina1);
		jugador.agregarLamina(lamina2);
		jugador.agregarLamina(lamina3);
		jugador.agregarLamina(lamina4);
		
      
		 
		assertTrue(album.getPrimero().getLaminas()[1].estaObtenida());
		assertTrue(album.getPrimero().getLaminas()[2].estaObtenida());
		assertTrue(album.getPrimero().getLaminas()[3].estaObtenida());
		assertTrue(album.getPrimero().getLaminas()[4].estaObtenida());

		//fgd

		
	}
	

}
