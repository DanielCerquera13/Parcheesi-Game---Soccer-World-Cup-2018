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

	private Casilla[][] zonaUno;
	private Casilla[][] zonaDos;
	private Casilla[][] zonaTres;
	private Casilla[][] zonaCuatro;

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

		zonaUno = new Casilla[3][8];
		zonaDos = new Casilla[8][3];
		zonaTres = new Casilla[3][8];
		zonaCuatro = new Casilla[8][3];

		rellenarZonas();
	}

	public Equipo getTurnoActual() {

		Equipo actual = null;

		for (int i = 0; i < equipos.length; i++) {

			if (equipos[i].getTurno()) {

				actual = equipos[i];

			}

		}

		return actual;
	}

	public boolean verificarTresTiros() {

		Equipo e = getTurnoActual();
		boolean si = false;

		if (e.getFichas()[0].isLibre() == false) {
			if (e.getFichas()[1].isLibre() == false) {
				if (e.getFichas()[2].isLibre() == false) {
					if (e.getFichas()[3].isLibre() == false) {

						si = true;

					}

				}

			}

		}
		
		
		return si;

	}

	
	
	
	
	public void asignarTurnos() {
			
	Equipo e = getTurnoActual();
		
		
	
	
		
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

	public void rellenarZonaUno() {

		for (int i = 0, j = 83; i < zonaUno[0].length; i++, j--) {

			zonaUno[0][i] = casillas[j];

		}

		for (int i = 0, j = 84; i < zonaUno[0].length; i++, j++) {

			zonaUno[1][i] = casillas[j];

		}

		for (int i = 0, j = 92; i < zonaUno[0].length; i++, j++) {

			if (j <= 95)
				zonaUno[2][i] = casillas[j];

		}

		zonaUno[2][4] = casillas[0];
		zonaUno[2][5] = casillas[1];
		zonaUno[2][6] = casillas[2];
		zonaUno[2][7] = casillas[3];

	}

	public void rellenarZonaDos() {

		for (int i = 0, j = 4; i < zonaDos.length; i++, j++) {

			zonaDos[i][0] = casillas[j];

		}

		for (int i = 0, j = 19; i < zonaDos.length; i++, j--) {

			zonaDos[i][1] = casillas[j];

		}

		for (int i = 0, j = 27; i < zonaDos.length; i++, j--) {

			zonaDos[i][2] = casillas[j];

		}

	}

	public void rellenarZonaTres() {

		for (int i = 0, j = 51; i < zonaTres[0].length; i++, j--) {

			zonaTres[0][i] = casillas[j];

		}

		for (int i = 0, j = 43; i < zonaTres[0].length; i++, j--) {

			zonaTres[1][i] = casillas[j];

		}

		for (int i = 0, j = 28; i < zonaTres[0].length; i++, j++) {

			zonaTres[2][i] = casillas[j];

		}

	}

	public void rellenarZonaCuatro() {

		for (int i = 0, j = 68; i < zonaCuatro.length; i++, j++) {

			zonaCuatro[i][0] = casillas[j];

		}

		for (int i = 0, j = 60; i < zonaCuatro.length; i++, j++) {

			zonaCuatro[i][1] = casillas[j];

		}

		for (int i = 0, j = 59; i < zonaCuatro.length; i++, j--) {

			zonaCuatro[i][2] = casillas[j];

		}

	}

	public Casilla[][] getZonaUno() {

		return zonaUno;

	}

	public Casilla[][] getZonaDos() {

		return zonaDos;

	}

	public Casilla[][] getZonaTres() {

		return zonaTres;

	}

	public Casilla[][] getZonaCuatro() {

		return zonaCuatro;

	}

	public void rellenarZonas() {

		rellenarZonaUno();
		rellenarZonaDos();
		rellenarZonaTres();
		rellenarZonaCuatro();

	}

	public static void main(String[] args) {

		Parques p = new Parques();

		System.out.println(Arrays.deepToString(p.getZonaUno()));
		System.out.println(Arrays.deepToString(p.getZonaDos()));
		System.out.println(Arrays.deepToString(p.getZonaTres()));
		System.out.println(Arrays.deepToString(p.getZonaCuatro()));
	}

}
