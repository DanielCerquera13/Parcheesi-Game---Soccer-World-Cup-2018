package modelo;

public class Ficha {
	
	

	
	//ATRIBUTOS
	
	/**
	 * Atributo que representa el Equipo de la ficha
	 */
	private String equipo;
	
	/**
	 * Atributo que representa la posicion de la ficha
	 */
	private int posicion;
	
	/**
	 * Atributo que indica si la ficha se encuentra en
	 * la carcel.
	 */
	private boolean libre;
	
	/**
	 * Atributo que indica si la ficha ya ha llegado
	 * a la meta.
	 */
	private boolean ganada;
	
	/**
	 * atributo tipo
	 */
	private int tipo;
	
	//CONSTRUCTOR
	
	/**
	 *Constructor de la clase Ficha.
	 */
	public Ficha(String equipo, int posicion, boolean libre, boolean ganada, int tipo) {
		super();
		this.equipo = equipo;
		this.posicion = posicion;
		this.libre = libre;
		this.ganada = ganada;
		this.tipo = tipo;
	}
	
	
	
	
	
	/**
	 * Enrega el tipo de ficha que es.<br>
	 * @return  tipo de ficha.
	 */
	public int getTipo() {
		return tipo;
	}



   /**
    * Modifica el tipo de ficha que es.<br>
    * @param tipo - nuevo tipo de ficha. <br>
    *  <b> pre: </b> tipo>0  y tipo<=4 <br>
	 * <b> post: </b> el tipo de ficha se modifica adecuadamente.
    */
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}




	/**
	 * Este metodo retorna el Equipo de la ficha
	 * @return String Equipo.
	 */
	public String getEquipo() {
		return equipo;
	}
	
	/**
	 * Este metodo modifica el Equipo de la ficha.
	 * @param String Equipo de la ficha
	 */
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	
	/**
	 * Este metodo retorna la posicion de la ficha
	 * @return int posicion.
	 */
	public int getPosicion() {
		return posicion;
	}
	
	/**
	 * Este metodo modifica la posicion de la ficha
	 * @param posicion Posicion a la que se desea mover.
	 */
	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}
	
	/**
	 * Este metodo retorna true si la ficha no esta 
	 * en la carcel.
	 * @return boolean libre.
	 */
	public boolean isLibre() {
		return libre;
	}
	
	/**
	 * Este metodo modifica el valor de verdad
	 * @param libre Valor de verdad al que se desea cambair.
	 */
	public void setLibre(boolean libre) {
		this.libre = libre;
	}
	
	/**
	 * Este metodo retorna true si la ficha ya ha
	 * llegado a la meta
	 * @return boolean ganada.
	 */
	public boolean isGanada() {
		return ganada;
	}
	
	/**
	 * Este metodo modifica el valor de la verdad
	 * @param ganada Valor de verdad al que se desea cambiar.
	 */
	public void setGanada(boolean ganada) {
		this.ganada = ganada;
	}
	
	

}
