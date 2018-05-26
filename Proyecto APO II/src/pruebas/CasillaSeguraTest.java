package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import modelo.CasillaSegura;
import modelo.Constantes;
import modelo.Ficha;

class CasillaSeguraTest  extends TestCase implements Constantes{

     
	private CasillaSegura casillaSegura;
	
	
	public void escenario1() {
		
		casillaSegura = new CasillaSegura(Constantes.SEGURO);
			
		}
	
	
	 public void escenario2() {
		 
			casillaSegura = new CasillaSegura(Constantes.SEGURO);
			
			  Ficha ficha1= new Ficha("colombia", 7, false, false, 1); 
			   Ficha ficha2= new Ficha("colombia", 12, false, false, 1); 
			   Ficha ficha3= new Ficha("colombia", 31, false, false, 2); 
			   Ficha ficha4= new Ficha("colombia", 36, false, false, 4); 
			   Ficha ficha5= new Ficha("colombia", 55, false, false, 2); 
			   Ficha ficha6= new Ficha("colombia", 60, false, false, 3); 
			   Ficha ficha7= new Ficha("colombia", 79, false, false, 1); 
			   Ficha ficha8= new Ficha("colombia",  84, false, false, 2); 

			     
			   casillaSegura.agregarFicha(ficha1);
			  casillaSegura.agregarFicha(ficha2);
			   casillaSegura.agregarFicha(ficha3);
			   casillaSegura.agregarFicha(ficha4);
			   casillaSegura.agregarFicha(ficha5);
			   casillaSegura.agregarFicha(ficha6);
			   casillaSegura.agregarFicha(ficha7);
			   casillaSegura.agregarFicha(ficha8);


	 } 
	 /**
	  * test que verifica que se agregan en la casilla segura cualquier tipo de fichas
	  */
	 @Test
	 public void testAgregarFichaCorrectamente() {
		 
		  escenario1();
		  
		  Ficha ficha1= new Ficha("colombia", 7, false, false, 1); 
		   Ficha ficha2= new Ficha("colombia", 12, false, false, 1); 
		   Ficha ficha3= new Ficha("colombia", 31, false, false, 2); 
		   Ficha ficha4= new Ficha("colombia", 36, false, false, 4); 
		   Ficha ficha5= new Ficha("colombia", 55, false, false, 2); 
		   Ficha ficha6= new Ficha("colombia", 60, false, false, 3); 
		   Ficha ficha7= new Ficha("colombia", 79, false, false, 1); 
		   Ficha ficha8= new Ficha("colombia",  84, false, false, 2); 

		     
		   casillaSegura.agregarFicha(ficha1);
		  casillaSegura.agregarFicha(ficha2);
		   casillaSegura.agregarFicha(ficha3);
		   casillaSegura.agregarFicha(ficha4);
		   casillaSegura.agregarFicha(ficha5);
		   casillaSegura.agregarFicha(ficha6);
		   casillaSegura.agregarFicha(ficha7);
		   casillaSegura.agregarFicha(ficha8);
		   
		   assertEquals(8, casillaSegura.casilllasOcupadas());
	 }
	 
	 /**
	  * test que verifica que si hay fichas
	  */ 
	 @Test
	 public void testHayFichasTrue() {
		 
		 escenario2();
		 
		 assertTrue(casillaSegura.hayFichas());
	 }
	 
	 
	 /**
	  * test que verifica que no hay fichas
	  */
	 @Test
	 public void testHayFichasFalse() {
		 
		 escenario1();
		 
		 assertFalse(casillaSegura.hayFichas());
	 }
	 
	}


