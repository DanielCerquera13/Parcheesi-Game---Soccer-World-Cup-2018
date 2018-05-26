package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;
import modelo.Casilla;
import modelo.CasillaCasa;
import modelo.Constantes;
import modelo.Ficha;

class CasillaCasaTest  extends TestCase implements Constantes{


   private CasillaCasa casillaCasa;
   
   
   public void escenario1() {
	   
	   casillaCasa = new CasillaCasa(Constantes.CASA, 1);
	   
   }
   
   public void escenario2() {
	   
	   casillaCasa = new CasillaCasa(Constantes.CASA, 1);
	 
	   Ficha ficha1= new Ficha("colombia", 60, false, false, 1); 
	   Ficha ficha2= new Ficha("colombia", 84, false, false, 1); 
	   Ficha ficha3= new Ficha("colombia", 12, false, false, 1); 
	   Ficha ficha4= new Ficha("colombia", 36, false, false, 1); 

	   casillaCasa.agregarFicha(ficha1);
	   casillaCasa.agregarFicha(ficha2);
	   casillaCasa.agregarFicha(ficha3);
	   casillaCasa.agregarFicha(ficha4);

	   
   }
   
   /**
    * test que verifica que se pueden agregar fichas del mismo tipo a casillas casa
    */
   @Test  
   public void testAgregarFichaCorrectamente() {
	     
	   escenario1();
	   
	   Ficha ficha1= new Ficha("colombia", 60, false, false, 1); 
	   Ficha ficha2= new Ficha("colombia", 84, false, false, 1); 
	   Ficha ficha3= new Ficha("colombia", 12, false, false, 1); 
	   Ficha ficha4= new Ficha("colombia", 36, false, false, 1); 
	     
	   casillaCasa.agregarFicha(ficha1);
	  casillaCasa.agregarFicha(ficha2);
	   casillaCasa.agregarFicha(ficha3);
	   casillaCasa.agregarFicha(ficha4);
	   System.out.println(casillaCasa.casilllasOcupadas());

	   assertEquals(4, casillaCasa.casilllasOcupadas());
	   
   }
   
   
   /**
    * test que verifica que NO se pueden agregar fichas de diferente tipo a casillas casa
    */
   @Test  
   public void testAgregarFichaInCorrectamente() {
	     
	   escenario1();
	   
	   Ficha ficha1= new Ficha("colombia", 60, false, false, 1); 
	   Ficha ficha2= new Ficha("colombia", 84, false, false, 1); 
	   Ficha ficha3= new Ficha("colombia", 12, false, false, 2); 
	   Ficha ficha4= new Ficha("colombia", 36, false, false, 2); 
	     
	   casillaCasa.agregarFicha(ficha1);
	  casillaCasa.agregarFicha(ficha2);
	   casillaCasa.agregarFicha(ficha3);
	   casillaCasa.agregarFicha(ficha4);
	   System.out.println(casillaCasa.casilllasOcupadas());

	   assertNotEquals(4, casillaCasa.casilllasOcupadas());
	   
   }
    
   /**
    * verifica que el metodo hayfichas() funciona correctamente cuando si hay fichas
    */
        
   @Test
  public void hayFichasTrue() {
	     
	   escenario2();
	   
	   assertTrue(casillaCasa.hayFichas());
   } 
   
   /**
    * verifica que el metodo hayfichas() funciona correctamente cuando no hay fichas
    */
        
   @Test
  public void hayFichasFalse() {
	     
	   escenario1();
	   
	   assertFalse(casillaCasa.hayFichas());
   }
}
