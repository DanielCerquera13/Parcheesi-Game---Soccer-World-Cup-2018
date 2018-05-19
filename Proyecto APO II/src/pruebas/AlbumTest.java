package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import excepciones.PaginaYaExisteException;
import junit.framework.TestCase;
import modelo.Album;
import modelo.Pagina;

class AlbumTest  extends TestCase{

	/**
	 * relacion con la clase album del modelo
	 */
	private Album album;
	
	
	public void  escenario1() {
		
		album = new Album();
	
	}
	

	
	
	/**
	 * verifica que la pagina se agrega correctamente
	 */
	@Test
	public void testAgregarPaginaCorrectamente() {
		
		escenario1();
		
		Pagina italia =new Pagina("./Archivos/imagenes/banderasRec/rusiaRec.png", "Italia", 1, "Grupo H");
		Pagina chile=new Pagina("./Archivos/imagenes/banderasRec/egyptoRec.png", "Chile", 2, "Grupo H");
	
		
		try {
			album.agregarPagina(italia);
		    album.agregarPagina(chile);

		} catch (PaginaYaExisteException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		//	album.agregarPagina(egipto);
		//	album.agregarPagina(uruguay);
			
			assertEquals(34, album.getCantidad());
		
	}
      
	/**
	 * verifica que la pagina se agrega correctamente
	 */
	@Test
	public void testAgregarPaginaException() {
		
		escenario1();
		
		Pagina colombia=new Pagina("./Archivos/imagenes/banderasRec/arabiaRec.png", "Colombia", 4, "Grupo H");
		try {
			
			album.agregarPagina(colombia);			
		assertNotEquals(33, album.getCantidad());
		
		} catch (PaginaYaExisteException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()  );
	}

		
	}
	/**
	 *  verifica que la pagina ya existe, por lo tanto retorna true
	 */
	@Test
	public void testYaExisteTrue() {
		
		
		Pagina colombia=new Pagina("./Archivos/imagenes/banderasRec/arabiaRec.png", "Colombia", 4, "Grupo H");

		
		escenario1();
		
		try {
			album.agregarPagina(colombia);
			assertTrue(album.yaExiste(colombia.getSeleccion()));
		} catch (PaginaYaExisteException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	/**
	 *  verifica que la pagina no existe, por lo tanto retorna false
	 */
	@Test
	public void testYaExisteFalse() {
		
		escenario1();
		
		
		Pagina chile =new Pagina("./Archivos/imagenes/banderasRec/rusiaRec.png", "chile", 33, "Grupo H");
             
		try {
			album.agregarPagina(chile);
			System.out.println(album.yaExiste(chile.getSeleccion()));
			assertFalse(album.yaExiste(chile.getSeleccion()));
		} catch (PaginaYaExisteException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}


}
