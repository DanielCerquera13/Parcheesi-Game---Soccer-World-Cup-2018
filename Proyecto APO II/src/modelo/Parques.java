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

	/**
	 * Entega que equipo de los cuatro tiene el turno.
	 * 
	 * @return el equipo con el turno actual.
	 */
	public Equipo getTurnoActual() {

		Equipo actual = null;

		for (int i = 0; i < equipos.length; i++) {

			if (equipos[i].getTurno()) {

				actual = equipos[i];

			}

		}

		return actual;
	}

	/**
	 * Verifica si se sacan tres pares durante el juego.
	 * 
	 * @return true si saco tres pares, false si no es asi.
	 */
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

	/**
	 * Asigna el turno a un equipo en especifico.
	 */
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
				casillas[i] = new CasillaCasa(Constantes.CASA, i, Constantes.CUATRO);

		}
	}

	/**
	 * Inicializa la zona uno del parques con sus respectivas casillas.
	 */
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

	/**
	 * /** Inicializa la zona dos del parques con sus respectivas casillas.
	 */
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

	/**
	 * /** Inicializa la zona tres del parques con sus respectivas casillas.
	 */
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

	/**
	 * /** Inicializa la zona uno del parques con sus respectivas casillas.
	 */
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

	/**
	 * Entrega las casillas de la zona uno del parques.
	 * 
	 * @return arreglo con las casillas.
	 */
	public Casilla[][] getZonaUno() {

		return zonaUno;

	}

	/**
	 * Entrega las casillas de la zona dos del parques.
	 * 
	 * @return arreglo con las casillas.
	 */
	public Casilla[][] getZonaDos() {

		return zonaDos;

	}

	/**
	 * Entrega las casillas de la zona tres del parques.
	 * 
	 * @return arreglo con las casillas.
	 */
	public Casilla[][] getZonaTres() {

		return zonaTres;

	}

	/**
	 * Entrega las casillas de la zona cuatro del parques.
	 * 
	 * @return arreglo con las casillas.
	 */
	public Casilla[][] getZonaCuatro() {

		return zonaCuatro;

	}

	/**
	 * rellena en su totalidad y en conjuntos las casillas del parques.
	 */
	public void rellenarZonas() {

		rellenarZonaUno();
		rellenarZonaDos();
		rellenarZonaTres();
		rellenarZonaCuatro();

	}

	/**
	 * Metodo saca las fichas que se encuentras en la carcel.
	 * 
	 * @param fichas
	 *            - el arreglo de fichas que se desea sacar de la carcel.
	 */
	public void sacarFichasDeLaCarcel(Ficha[] fichas) {

		for (int i = 0; i < fichas.length; i++) {
			fichas[i].salirDeLaCarcel();
			casillas[fichas[i].getPosicion()].agregarFicha(fichas[i]);
		}
		
		rellenarZonas();
	}

	/**
	 * Este metodo mete las fichas que deben ir a la carce.
	 * 
	 * @param fichas
	 *            - el arreglo de fichas que se desea meter a la carcel.
	 */
	public void meterFichaALaCarcel(Ficha ficha) {

		Casilla actual = null;
		int posActual = ficha.getPosicion();

		for (int i = 0; i < casillas[ficha.getPosicion()].getFichas().length; i++) {

			if (casillas[ficha.getPosicion()].getFichas()[i] == ficha) {

				casillas[ficha.getPosicion()].getFichas()[i] = null;
				ficha.irALaCarcel();
			}
		}
	}

	/**
	 * Simula el movimiento de una ficha en el parques.
	 * 
	 * @param ficha
	 *            - la ficha que se desea mover.
	 * @param valorDado
	 *            - la cantidad de casillas que se movera
	 */
	public void moverFichaNew(Ficha ficha, int valorDado) {

		Casilla actual = null;
		Casilla destino = null;
		int posActual = ficha.getPosicion();
		boolean pasoPorCasaAjena = false;

		// Definir si pasa por casa ajena
		for (int k = posActual + 1; k <= posActual + valorDado && !pasoPorCasaAjena; k++) {

			int auxK = 0;
			
			if(k>95) {
				
			auxK = k-96;	
				
			}else {
				
			auxK = k;	
				
			}
			
			if (casillas[auxK].getTipo() == Constantes.CASA) {
				if (ficha.getTipo() != casillas[auxK].getTipoFicha()) {

					pasoPorCasaAjena = true;

				}
			}
		}
		System.out.println(pasoPorCasaAjena);

		// Fin pasa por casa ajena recorrido

		if (casillas[posActual].hayFichas()) {

			// Si suman mas de 95 entonces
			if (posActual + valorDado > 95) {

				// si las fichas son tipo 2 o 3 o 4
				if (ficha.saltarUltimaCasilla()) {

					// Quitar la ficha de la posicion actual
					for (int i = 0; i < casillas[posActual].getFichas().length; i++) {

						// No paso por casa ajena ?
						if (casillas[posActual].getFichas()[i] == ficha && !pasoPorCasaAjena) {

							// Ecuacion para seguir despues del 95 a 0 en adelante
							destino = casillas[-96 + posActual + valorDado];

							actual = casillas[posActual];

							actual.getFichas()[i] = null;

							// Se modifica la posicion de la ficha "moviendola"

							ficha.mover(-96 + valorDado);
							// Se agrega la ficha en la casilla destino
							destino.agregarFicha(ficha);

							// Pasa por casa ajena ??
						} else if (casillas[posActual].getFichas()[i] == ficha && pasoPorCasaAjena) {

							destino = casillas[-96 + posActual + 7 + valorDado];

							actual = casillas[posActual];

							actual.getFichas()[i] = null;

							ficha.mover(-96 + valorDado + 7);

							destino.agregarFicha(ficha);

						}

					}

				}
				// Es menor a 95 posActual + valorDado ?
			} else {

				for (int j = 0; j < casillas[posActual].getFichas().length; j++) {

					// No pasa por casa ajena ?
					if (casillas[posActual].getFichas()[j] == ficha && !pasoPorCasaAjena) {

						// Casilla en la que se encuentra la ficha que llega por parametro
						actual = casillas[posActual];
						// Casilla destino
						destino = casillas[posActual + valorDado];

						// En la casilla que se encontraba la ficha ya no lo estara
						actual.getFichas()[j] = null;

						// Se modifica la posicion de la ficha "moviendola"
						ficha.mover(valorDado);

						// Se agrega la ficha en la casilla destino
						destino.agregarFicha(ficha);

						// Si pasa por casa Ajena ?
					} else if (casillas[posActual].getFichas()[j] == ficha && pasoPorCasaAjena) {

						if (posActual + 7 + valorDado > 95) {

							destino = casillas[-96 + posActual + 7 + valorDado];

							actual = casillas[posActual];

							actual.getFichas()[j] = null;

							ficha.mover(-96 +valorDado + 7);

							destino.agregarFicha(ficha);

						} else {

							actual = casillas[posActual];

							destino = casillas[posActual + 7 + valorDado];

							actual.getFichas()[j] = null;

							ficha.mover(valorDado + 7);

							destino.agregarFicha(ficha);

						}

					}

				}

			}
		}
		// Se actualizan las zonas con el arreglo casillas de parques.
		rellenarZonas();

	}


}
