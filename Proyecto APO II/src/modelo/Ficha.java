package modelo;

public class Ficha {

	// ATRIBUTOS

	/**
	 * Atributo que representa la posicion de la ficha
	 */
	private Integer posicion;

	/**
	 * Atributo que indica si la ficha se encuentra en la carcel.
	 */
	private boolean libre;

	/**
	 * Atributo que indica si la ficha ya ha llegado a la meta.
	 */
	private boolean ganada;

	/**
	 * atributo tipo
	 */
	private int tipo;

	// CONSTRUCTOR

	/**
	 * Constructor de la clase Ficha.
	 */
	public Ficha(String equipo, int tipo) {

		posicion = null;
		libre = false;
		ganada = false;
		this.tipo = tipo;
	}

	/**
	 * Enrega el tipo de ficha que es.<br>
	 * 
	 * @return tipo de ficha.
	 */
	public int getTipo() {
		return tipo;
	}

	/**
	 * Modifica el tipo de ficha que es.<br>
	 * <b> pre: </b> tipo>0 y tipo<=4 <br>
	 * <b> post: </b> el tipo de ficha se modifica adecuadamente.
	 * 
	 * @param tipo
	 *            - nuevo tipo de ficha. <br>
	 */
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	/**
	 * Este metodo retorna la posicion de la ficha
	 * 
	 * @return int posicion.
	 */
	public Integer getPosicion() {
		return posicion;
	}

	/**
	 * Este metodo modifica la posicion de la ficha
	 * 
	 * @param posicion
	 *            Posicion a la que se desea mover.
	 */
	public void setPosicion(Integer posicion) {
		this.posicion = posicion;
	}

	/**
	 * Este metodo retorna true si la ficha no esta en la carcel.
	 * 
	 * @return boolean libre.
	 */
	public boolean isLibre() {
		return libre;
	}

	/**
	 * Este metodo modifica el valor de verdad
	 * 
	 * @param libre
	 *            Valor de verdad al que se desea cambair.
	 */
	public void setLibre(boolean libre) {
		
		this.libre = libre;
		
		if(libre == false) {
			
		setPosicion(null);	
			
		}
	}

	/**
	 * Este metodo retorna true si la ficha ya ha llegado a la meta
	 * 
	 * @return boolean ganada.
	 */
	public boolean isGanada() {
		return ganada;
	}

	/**
	 * Este metodo modifica el valor de la verdad
	 * 
	 * @param ganada
	 *            Valor de verdad al que se desea cambiar.
	 */
	public void setGanada(boolean ganada) {
		this.ganada = ganada;
	}

	public void salirDeLaCarcel() {

		if (tipo == 1) {

			this.setLibre(true);
			this.setPosicion(0);

		}

		if (tipo == 2) {

			this.setLibre(true);
			this.setPosicion(24);

		}

		if (tipo == 3) {

			this.setLibre(true);
			this.setPosicion(48);

		}

		if (tipo == 4) {

			this.setLibre(true);
			this.setPosicion(72);

		}

	}

	public void irALaCarcel() {
		
	this.posicion = null;
		
	}
	
	public void mover(int valorDado) {
			
	posicion = posicion+valorDado;		
		
	}
	
	public void capturar() {
		
		
		
	}
	
	@Override
	public String toString() {
		
	return "Hola soy "+tipo;	
		
	}
}
