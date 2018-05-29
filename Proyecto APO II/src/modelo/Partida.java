/**
 * @author juandavidpaz, juan camilo velez, jhonatan bellaiza, daniel alejandro cerquera
 */
package modelo;

public class Partida {

	/**
	 * relacion con la clase parques. 
	 */
	private Parques parques;
	private Jugador[] jugadores;
	
	/**
	 * Constructor de la clase partida.
	 */
	public Partida() {
		
	parques = new Parques();
	jugadores = new Jugador[4];
		
	}
	
	
	public void setJugadores(Jugador[] jugadores) {
		
	this.jugadores = jugadores;	
		
	}
	
	public Jugador[] getJugadores() {
		
	return jugadores;	
		
	}
	
	public void setParques(Parques parques) {
		
	this.parques = parques;	
		
	}
	
	
	public Parques getParques() {
		
	return parques;
		
	}
	
	
	
}
