package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import excepciones.UsuarioYaRegistradoException;
import junit.framework.TestCase;
import modelo.Constantes;
import modelo.Jugador;
import modelo.ParquesMundial;

class ParquesMundialTest extends TestCase implements Constantes {

    
	private ParquesMundial parquesMundial;
	
	
	public void escenario1() {
		
		
		parquesMundial = new ParquesMundial();
		
		
	}
	
	public void escenario2() {
		 
		parquesMundial = new ParquesMundial();
		
		Jugador jugador1 = new Jugador("juan", "1111");
		Jugador jugador2 = new Jugador("david", "2222");
		Jugador jugador3 = new Jugador("daniel", "3333");
		Jugador jugador4 = new Jugador("ju", "44444");
		
		
		try {
			parquesMundial.agregarUsuario(jugador1);
			parquesMundial.agregarUsuario(jugador2);
			parquesMundial.agregarUsuario(jugador3);
			parquesMundial.agregarUsuario(jugador4);

		} catch (UsuarioYaRegistradoException e) {
			// TODO Auto-generated catch block
           System.out.println(e.getMessage());
		}
		

		
	}
	
	/**
	 * se verigica que se puede agregar correctamente un usuario
	 */
	@Test
	public void testAgregarCorrectamente() {
		
		escenario1();
		
		Jugador jugador1 = new Jugador("juan", "1111");
		Jugador jugador2 = new Jugador("david", "2222");
		Jugador jugador3 = new Jugador("daniel", "3333");
		Jugador jugador4 = new Jugador("ju", "44444");
		
		
		try {
			parquesMundial.agregarUsuario(jugador1);
			parquesMundial.agregarUsuario(jugador2);
			parquesMundial.agregarUsuario(jugador3);
			parquesMundial.agregarUsuario(jugador4);

		} catch (UsuarioYaRegistradoException e) {
			// TODO Auto-generated catch block
           System.out.println(e.getMessage());
		}
		      
		System.out.println(parquesMundial.getUsuarios().size());
		assertEquals(5, parquesMundial.getUsuarios().size());
 
	}
	
	
	/**
	 * se verigica que no se puede agregar correctamente un usuario cuando tienen el mismo nombre
	 */
	@Test
	public void testAgregarInCorrectamente() {
		
		escenario1();
		
		Jugador jugador1 = new Jugador("juan", "1111");
		Jugador jugador2 = new Jugador("david", "2222");
		Jugador jugador3 = new Jugador("daniel", "3333");
		Jugador jugador4 = new Jugador("juan", "44444");
		
		
		try {
			parquesMundial.agregarUsuario(jugador1);
			parquesMundial.agregarUsuario(jugador2);
			parquesMundial.agregarUsuario(jugador3);
			parquesMundial.agregarUsuario(jugador4);

		} catch (UsuarioYaRegistradoException e) {
			// TODO Auto-generated catch block
           System.out.println(e.getMessage());
		}
		      
		assertEquals(4, parquesMundial.getUsuarios().size());
 
	}
}
