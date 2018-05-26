
/**
 * @author juandavidpaz, juan camilo velez, jhonatan bellaiza, daniel alejandro cerquera
 */
package modelo;

public class Lamina implements Comparable<Lamina>{
	
	//ATRIBUTOS
	
	/**
	 * Este atributo representa la imagen del jugador
	 */
	private String jugador;
	
	/**
	 * Este atributo representa el numero que se le asigna 
	 * a cada jugador en el album.
	 */
	private int numero;
	
	/**
	 * Este atributo representa si esta lamina ya ha sido obtenida o no por el Jugador.
	 */
	private boolean obtenida;
	
	
	//CONSTRUCTOR
	
	/**
	 * 
	 * @param jugador
	 * @param numero
	 */
	public Lamina(String jugador, int numero) {
		
		this.jugador = jugador;
		this.numero = numero;
		obtenida = false;
		
	}
	
	
	
	
	
	//GET AND SET
	
	/**
	 * Este metodo retorna la imagen del jugador
	 * @return String jugador.
	 */
	public String getJugador() {
		return jugador;
	}
	
	/**
	 * Este metodo modifica la imagen del jugador
	 * @param jugador imagen del jugador.
	 */
	public void setJugador(String jugador) {
		this.jugador = jugador;
	}
	
	
	/**
	 * 
	 * @param obtenida
	 */
	public void setObtenida(boolean obtenida) {
		
	this.obtenida = obtenida;	
		
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean estaObtenida() {
		
	return obtenida;	
		
	}
	
	/**
	 * Este metodo retorna el numero del jugador
	 * @return int numero..
	 */
	public int getNumero() {
		return numero;
	}
	
	/**
	 * Este metodo modifica el numero del jugador
	 * @param numero Numero que representa al jugador.
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	@Override
	public int compareTo(Lamina lam) {
		
		return this.getNumero()-lam.getNumero();
	}
	
	@Override
	public String toString() {
		
	return "Jugador: "+jugador+" - Lamina # : "+numero;	
		
	}

}
