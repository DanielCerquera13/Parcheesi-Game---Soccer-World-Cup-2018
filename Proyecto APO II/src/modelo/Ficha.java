package modelo;

public class Ficha {
	
	
	//ATRIBUTOS
	
	/**
	 * Atributo que representa el color de la ficha
	 */
	private String color;
	
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
	
	
	//CONSTRUCTOR
	
	/**
	 *Constructor de la clase Ficha.
	 */
	public Ficha(String color, int posicion, boolean libre, boolean ganada) {
		super();
		this.color = color;
		this.posicion = posicion;
		this.libre = libre;
		this.ganada = ganada;
	}
	
	
	//GET AND SET
	
	/**
	 * Este metodo retorna el color de la ficha
	 * @return String color.
	 */
	public String getColor() {
		return color;
	}
	
	/**
	 * Este metodo modifica el color de la ficha.
	 * @param String color de la ficha
	 */
	public void setColor(String color) {
		this.color = color;
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
