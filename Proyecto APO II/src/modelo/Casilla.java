
/**
 * @author juandavidpaz, juan camilo velez, jhonatan bellaiza, daniel alejandro cerquera
 */
package modelo;

public class Casilla {

	/**
	 * Arreglo de fichas que contiene cada casilla
	 */
	private Ficha[] fichas;

	/**
	 * Indica que tipo de casilla es
	 */
	private int tipo;
	
	private int posicion;

	/**
	 * Constructor
	 */
	public Casilla(int tipo, int posicion) {

		fichas = new Ficha[10];
		this.tipo = tipo;
		this.posicion = posicion;
	}

	
	public void setPosicion(int posicion) {
		
	this.posicion = posicion;	
	}
	
	public int getPosicion() {
		
	return posicion;	
		
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

	/**
	 * encuentra cuantas paginas del arreglo se encuentran ocupadas<br>
	 * 
	 * @return cantidad de casillasOcupadas
	 */
	public int casilllasOcupadas() {

		int valor = 0;

		for (int i = 0; i < getFichas().length; i++) {
			if (getFichas()[i] != null) {
				valor++;
			}
		}

		return valor;
	}

	@Override

	public String toString() {

		return "" + posicion;

	}

}
