package modelo;

public class Casilla {

	/**
	 * Constantes para diferenciar el tipo de casillas.
	 */
	public static final int NORMAL = 1;
	public static final int SALIDA = 2;
	public static final int SEGURO = 3;

	/**
	 * Arreglo de fichas que contiene cada casilla
	 */
	private Ficha[] fichas;

	/**
	 * Indica que tipo de casilla es
	 */
	private int tipo;

	/**
	 * Constructor
	 */
	public Casilla(int tipo) {

		fichas = new Ficha[10];
		this.tipo = tipo;

	}

	/**
	 * Retorna que tipo de casilla es. 1 = NORMAL 2 = SALIDA 3 = SEGURO
	 * 
	 * @return tipo El tipo de casilla
	 */
	public int getTipo() {

		return tipo;

	}

	/**
	 * Retorna el arreglo de fichas de una casilla
	 * 
	 * @return fichas El arreglo de fichas.
	 */
	public Ficha[] getFichas() {

		return fichas;

	}

	/**
	 * Indica si la casilla tiene o no fichas.
	 * 
	 * @return
	 */
	public boolean hayFichas() {

		boolean yes = false;

		for (int i = 0; i < fichas.length; i++) {

			if (fichas[i] != null) {

				yes = true;

			}

		}

		return yes;

	}

	
	
}
