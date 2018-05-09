package modelo;

public class Lamina {
	
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
	
	
	//CONSTRUCTOR
	
	/**
	 * Constructor de la clase Lamina.
	 */
	public Lamina(String jugador, int numero) {
		super();
		this.jugador = jugador;
		this.numero = numero;
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
	
	

}
