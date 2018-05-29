package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import excepciones.UsuarioNoRegistradoException;
import excepciones.UsuarioYaRegistradoException;
import junit.framework.TestCase;
import modelo.Constantes;
import modelo.Jugador;
import modelo.ParquesMundial;

class ParquesMundialTest extends TestCase implements Constantes {

    
	private ParquesMundial parquesMundial;
	
	
	public void escenario1() {
		
		
		parquesMundial = new ParquesMundial(1);
		
		
	}
	
	public void escenario2() {
		 
		parquesMundial = new ParquesMundial(1);
		
		Jugador jugador1 = new Jugador("juan", "1111");
		Jugador jugador2 = new Jugador("andres", "2222");
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
		
		int tamanioUno = parquesMundial.getUsuarios().size();
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
		System.out.println(tamanioUno);
		assertEquals(4, parquesMundial.getUsuarios().size());
 
	}
	
	
	/**
	 * se verigica que no se puede agregar correctamente un usuario cuando tienen el mismo nombre
	 */
	@Test
	public void testAgregarInCorrectamente() {
		
		escenario1();
		
		Jugador jugador1 = new Jugador("daniel", "1111");
		Jugador jugador2 = new Jugador("daniel2", "2222");
		Jugador jugador3 = new Jugador("daniel3", "3333");
		Jugador jugador4 = new Jugador("daniel", "44444");
		
		
		try {
			parquesMundial.agregarUsuario(jugador1);
			parquesMundial.agregarUsuario(jugador2);
			parquesMundial.agregarUsuario(jugador3);
			parquesMundial.agregarUsuario(jugador4);

		} catch (UsuarioYaRegistradoException e) {
			// TODO Auto-generated catch block
           System.out.println(e.getMessage());
		}
		assertNotEquals(4, parquesMundial.getUsuarios().size());
 
	}
	
	
	/**
	 * Verifica que un usuario ya existe cuando buscamos uno que si esta en la lista.
	 */
	@Test
	public void testYaExisteTrue() {
		escenario2();
		
		assertTrue(parquesMundial.yaExiste("juan"));
	}
	
	
	/**
	 * Verifica que un usuario ya existe cuando buscamos uno que si esta en la lista.
	 */
	@Test
	public void testYaExisteFalse() {
		escenario2();
		
		assertFalse(parquesMundial.yaExiste("uribehp"));
	}
	
	
	
	/**
	 * verifica si el metodo buscar funciona correctamente cuando se busca un jugador valido.
	 */
	@Test
	public  void testBuscarCorrectamente() {
		
		escenario2();
		
		try {
			Jugador prueba = parquesMundial.buscarUsuario("juan");
			assertEquals("juan", prueba.getNickName());
		} catch (UsuarioNoRegistradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	

	/**
	 * verifica si el metodo buscar funciona correctamente cuando se busca un jugador invalido.
	 */
	@Test
	public  void testBuscarInCorrectamente() {
		
		escenario2();
		
		try {
			Jugador prueba = parquesMundial.buscarUsuario("petrosky");
			assertEquals("petrosky", prueba.getNickName());
		} catch (UsuarioNoRegistradoException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		
	}
	
	
	/**
	 * verifica si los usuarios se encuentran ordenados.
	 */

	@Test
	public void testOrdenar() {
		
		escenario2();
		
		parquesMundial.ordenarUsuarios();
		System.out.println(parquesMundial.getUsuarios().get(0).getNickName());
		assertEquals("andres", parquesMundial.getUsuarios().get(0).getNickName());
		
		
	}
	
	
	
	
	
	
	
	
	
	
}
