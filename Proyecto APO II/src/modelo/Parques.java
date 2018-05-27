/**
 * @author juandavidpaz, juan camilo velez, jhonatan bellaiza, daniel alejandro cerquera
 */
package modelo;

import java.util.Arrays;

public class Parques implements Constantes {

	/**
	 * Arreglo de casillas
	 */
	private Casilla[] casillas;

	/**
	 * Arreglo de equipos
	 */
	private Equipo[] equipos;

	/**
	 * Constructor de la clase parques.
	 */

	public Parques() {

		casillas = new Casilla[96];
		equipos = new Equipo[4];
		situarCasillas();

	}

	/**
	 * Modifica el arreglo de equipos por uno nuevo.
	 * 
	 * @param equipos
	 *            - el nuevo arreglo de equipo
	 */
	public void setEquipos(Equipo[] equipos) {

		this.equipos = equipos;

	}

	/**
	 * Entrega el arreglo de equipos
	 * 
	 * @return arreglo de equipos
	 */
	public Equipo[] getEquipos() {

		return equipos;

	}

	/**
	 * Entrega el arreglo de casillas
	 * 
	 * @return arreglo de casillas
	 */
	public Casilla[] getCasillas() {

		return casillas;

	}

	/**
	 * Inicializa el parques con sus respectivas casillas y posiciones
	 */
	public void situarCasillas() {

		// Se situan las salidas

		for (int i = 0; i < casillas.length; i++) {

			switch (i) {

			// Casillas Salidas
			case 0:
				casillas[i] = new CasillaSalida(Constantes.SALIDA, i, Constantes.UNO);
				break;

			case 24:
				casillas[i] = new CasillaSalida(Constantes.SALIDA, i, Constantes.DOS);
				break;

			case 48:
				casillas[i] = new CasillaSalida(Constantes.SALIDA, i, Constantes.TRES);
				break;

			case 72:
				casillas[i] = new CasillaSalida(Constantes.SALIDA, i, Constantes.CUATRO);
				break;

			// Fin Casillas Salidas

			// Casillas Seguro

			case 7:
				casillas[i] = new CasillaSegura(Constantes.SEGURO, i);
				break;

			case 12:
				casillas[i] = new CasillaSegura(Constantes.SEGURO, i);
				break;

			case 31:
				casillas[i] = new CasillaSegura(Constantes.SEGURO, i);
				break;

			case 36:
				casillas[i] = new CasillaSegura(Constantes.SEGURO, i);
				break;

			case 55:
				casillas[i] = new CasillaSegura(Constantes.SEGURO, i);
				break;

			case 60:
				casillas[i] = new CasillaSegura(Constantes.SEGURO, i);
				break;

			case 79:
				casillas[i] = new CasillaSegura(Constantes.SEGURO, i);
				break;

			case 84:
				casillas[i] = new CasillaSegura(Constantes.SEGURO, i);
				break;

			// Fin Casillas Seguro

			default:
				casillas[i] = new CasillaNormal(Constantes.NORMAL, i);

			}

			if (i >= 85 && i <= 91)
				casillas[i] = new CasillaCasa(Constantes.CASA, i, Constantes.UNO);

			if (i >= 13 && i <= 19)
				casillas[i] = new CasillaCasa(Constantes.CASA, i, Constantes.DOS);

			if (i >= 37 && i <= 43)
				casillas[i] = new CasillaCasa(Constantes.CASA, i, Constantes.TRES);

			if (i >= 61 && i <= 67)
				casillas[i] = new CasillaCasa(Constantes.CASA, i, Constantes.DOS);

		}
	}

	public static void main(String[] args) {

		Parques p = new Parques();

		System.out.println(Arrays.toString(p.getCasillas()));

	}

}
