/**
 * @author juandavidpaz, juan camilo velez, jhonatan bellaiza, daniel alejandro cerquera
 */
package modelo;

public class CasillaSegura extends Casilla {

	/**
	 * Constructor de la clase CasillaSegura.
	 * 
	 * @param tipo
	 *            - tipo de la casilla.
	 */
	public CasillaSegura(int tipo, int posicion) {
		super(tipo, posicion);
		// TODO Auto-generated constructor stub
	}

	/**
	 * El metodo agrega una nueva ficha a la casilla.<br>
	 * <b> pre: </b> ficha != null <br>
	 * <b> post: </b> La ficha es agregada correctamente.
	 * 
	 * @param ficha
	 *            - La nueva ficha que se va a agregar.<br>
	 */
	public void agregarFicha(Ficha ficha) {

		int tamanio = casilllasOcupadas();
		if (hayFichas() == false) {
			getFichas()[0] = ficha;
		}

		else if (hayFichas() == true) {

			getFichas()[tamanio + 1] = ficha;

		}

	}
}
