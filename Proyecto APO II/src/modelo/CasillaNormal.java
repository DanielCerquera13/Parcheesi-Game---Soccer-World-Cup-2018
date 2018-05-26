/**
 * @author juandavidpaz, juan camilo velez, jhonatan bellaiza, daniel alejandro cerquera
 */
package modelo;

public class CasillaNormal extends Casilla {

/**
 * Constructor de la clase CasillaNormal.
 * @param tipo -  tipo de Casilla
 */
	public CasillaNormal(int tipo) {
		super(tipo);
	}
 

	/**
	 * El metodo agrega una nueva ficha a la casilla.<br>
	 *  <b> pre: </b> ficha != null <br>
	 * <b> post: </b> La ficha es agregada correctamente.
	 * @param ficha - La nueva ficha que se va a agregar.<br>
	 */
	public void agregarFicha(Ficha ficha) {
		 
		int tamanio = casilllasOcupadas();
		if(hayFichas() == false) {
			getFichas()[0]=ficha;
		}
		
		else if( hayFichas()== true) {
			
			for (int i = 0; i < getFichas().length; i++) {
				if(getFichas()[i] != null) {
				if(getFichas()[i].getTipo()== ficha.getTipo()) {
					getFichas()[tamanio+1]=ficha;
				}
				else if (getFichas()[i].getTipo()!= ficha.getTipo()) {
					getFichas()[i]=null;
					getFichas()[0]=ficha;
				}
				}
			}
		}
	}

}
