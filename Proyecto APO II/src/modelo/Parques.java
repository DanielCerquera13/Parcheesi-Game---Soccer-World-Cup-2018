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
				casillas[i] = new CasillaCasa(Constantes.CASA, i, Constantes.DOS);

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
	 * /**
	 * Inicializa la zona dos del parques con sus respectivas casillas.
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
	 * /**
	 * Inicializa la zona tres del parques con sus respectivas casillas.
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
	 * /**
	 * Inicializa la zona uno del parques con sus respectivas casillas.
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
	 * @return arreglo con las casillas.
	 */ 
	public Casilla[][] getZonaUno() {

		return zonaUno;

	}

	/**
	 * Entrega las casillas de la zona dos del parques.
	 * @return arreglo con las casillas.
	 */ 
	public Casilla[][] getZonaDos() {

		return zonaDos;

	}

	/**
	 * Entrega las casillas de la zona tres del parques.
	 * @return arreglo con las casillas.
	 */ 
	public Casilla[][] getZonaTres() {

		return zonaTres;

	}

	/**
	 * Entrega las casillas de la zona cuatro del parques.
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
	 * Prueba si las casillas salidas se encuentran debidamente inicializadas.
	 * @param fichaUno
	 * @param fichaDos
	 * @param fichaTres
	 */
	public void probarCasillaSalida(Ficha fichaUno, Ficha fichaDos, Ficha fichaTres) {
		
	moverFicha(fichaUno, 72);
	moverFicha(fichaDos, 48);
	moverFicha(fichaTres, 24);
	
	
	rellenarZonas();
		
	}
	
     /**
      * Metodo saca las fichas que se encuentras en la carcel.
      * @param fichas - el arreglo de fichas que se desea sacar de la carcel.
      */
	public void sacarFichasDeLaCarcel(Ficha[] fichas) {

		for (int i = 0; i < fichas.length; i++) {
			fichas[i].salirDeLaCarcel();
			casillas[fichas[i].getPosicion()].agregarFicha(fichas[i]);
		}
	}

	

    /**
     * Este metodo mete las fichas que deben ir a la carce.
     * @param fichas - el arreglo de fichas que se desea meter a la  carcel.
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
   * @param ficha - la ficha que se desea mover.
   * @param valorDado - la cantidad de casillas que se movera
   */
	public void moverFicha(Ficha ficha, int valorDado) {

		Casilla actual = null;
		Casilla destino = null;
		int posActual = ficha.getPosicion();

		if (casillas[posActual].hayFichas()) {

			for (int j = 0; j < casillas[posActual].getFichas().length; j++) {

				if (casillas[posActual].getFichas()[j] == ficha) {

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

				}

			}

		}
		// Se actualizan las zonas con el arreglo casillas de parques.
		rellenarZonas();

	}

	public static void main(String[] args) {

		// Ficha fichaUno = new Ficha("UNO", 1);
		// Ficha fichaDos = new Ficha("UNO", 1);
		//
		// Ficha[] fichas = { fichaUno, fichaDos };
		//
		// for (int i = 0; i < fichas.length; i++) {
		//
		// System.out.println(fichas[i] == fichaUno);
		//
		// }

		// System.out.println(fichaUno == fichaDos);

		Parques p = new Parques();

		Equipo e = new Equipo("", "", 1);
		Equipo e2 = new Equipo("", "", 2);
		Equipo e3 = new Equipo("", "", 3);
		Equipo e4 = new Equipo("", "", 4);

		p.sacarFichasDeLaCarcel(e2.getFichas());
		p.sacarFichasDeLaCarcel(e.getFichas());
		p.sacarFichasDeLaCarcel(e3.getFichas());			
		
		

//		p.probarCasillaSalida(e.getFichas()[0], e2.getFichas()[0], e3.getFichas()[0]);
		
		p.moverFicha(e.getFichas()[0], 72);
//		p.moverFicha(e.getFichas()[1], 72);
		p.moverFicha(e2.getFichas()[0], 48);
		p.moverFicha(e3.getFichas()[0], 24);
		
//		p.meterFichaALaCarcel(e4.getFichas()[0]);
		
		
		
		System.out.println(Arrays.deepToString(p.getZonaUno()));
		System.out.println(Arrays.deepToString(p.getZonaDos()));
		System.out.println(Arrays.deepToString(p.getZonaTres()));
		System.out.println(Arrays.deepToString(p.getZonaCuatro()));
		
		System.out.println();
		
		
		p.sacarFichasDeLaCarcel(e4.getFichas());
		
//
//		p.moverFicha(e.getFichas()[0], 26);
//
		System.out.println();
//
		System.out.println(Arrays.deepToString(p.getZonaUno()));
		System.out.println(Arrays.deepToString(p.getZonaDos()));
		System.out.println(Arrays.deepToString(p.getZonaTres()));
		System.out.println(Arrays.deepToString(p.getZonaCuatro()));
//
//		System.out.println();
//
//		p.moverFicha(e2.getFichas()[0], 2);
//
//		System.out.println(Arrays.deepToString(p.getZonaUno()));
//		System.out.println(Arrays.deepToString(p.getZonaDos()));
//		System.out.println(Arrays.deepToString(p.getZonaTres()));
//		System.out.println(Arrays.deepToString(p.getZonaCuatro()));

	}

}
