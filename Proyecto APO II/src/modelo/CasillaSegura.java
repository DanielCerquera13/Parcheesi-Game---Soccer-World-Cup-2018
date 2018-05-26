/**
 * @author juandavidpaz, juan camilo velez, jhonatan bellaiza, daniel alejandro cerquera
 */
package modelo;

public class CasillaSegura  extends Casilla{

	
	
	public CasillaSegura(int tipo) {
		super(tipo);
		// TODO Auto-generated constructor stub
	}
      
	
	public void agregarFicha(Ficha ficha) {
		
		int tamanio = casilllasOcupadas();
		if(hayFichas() == false) {
			getFichas()[0]=ficha;
		}
		
		else if(hayFichas() == true) {
			
			      
				getFichas()[tamanio+1] = ficha;
				
		
	}
	
	}
}
