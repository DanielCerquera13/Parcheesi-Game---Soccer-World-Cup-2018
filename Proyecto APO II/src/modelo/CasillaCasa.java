

/**
 * @author juandavidpaz, juan camilo velez, jhonatan bellaiza, daniel alejandro cerquera
 */

package modelo;

import excepciones.PaginaYaExisteException;

public class CasillaCasa extends Casilla {

	/**
	 * numero de tipo de Ficha.
	 */
	private int tipoFicha;

	/**
	 * constructor de la clase CasillaCasa
	 * @param tipo - numero de tipo de casilla
	 * @param tipoFicha  numero de tipo de Ficha
	 */
	public CasillaCasa(int tipo,int posicion, int tipoFicha) {
		super(tipo,posicion);
		this.tipoFicha = tipoFicha;
	}


	/**
	 * El metodo agrega una nueva ficha a la casilla.<br>
	 *  <b> pre: </b> ficha != null <br>
	 * <b> post: </b> La ficha es agregada correctamente.
	 * @param ficha - La nueva ficha que se va a agregar.<br>
	 */
	public void agregarFicha(Ficha ficha) {

		int tamanio = casilllasOcupadas();

		if (tipoFicha == ficha.getTipo()) {
			
			if (hayFichas() == false) {
				getFichas()[0] = ficha;
			}

			else if (hayFichas() == true) {

				getFichas()[tamanio + 1] = ficha;

			}
		}

	}
}
