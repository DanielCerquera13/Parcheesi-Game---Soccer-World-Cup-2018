package modelo;

import java.util.ArrayList;

public class Jugador {
	
	//ATRIBUTOS
	
	/**
	 * Atributo que representa el nombre del usuario
	 */
	private String nickName;
	
	/**
	 * Atributo que representa la contrasena del usuario
	 */
	private String contrasena;
	
	/**
	 * Atributo que representa el dinero del usuario
	 */
	private int dinero;
	
	
	/**
	 * relacion con el album
	 */
	private Album album;
	//CONSTRUCTOR
	
	/**
	 * relacion con la lamina
	 */
	private ArrayList<Lamina>  laminas;
	/**
	 * Constructor de la clase Jugador.
	 */
	public Jugador(String nickName, String contrasena) {
		
		this.nickName = nickName;
		this.contrasena = contrasena;
		dinero = 0;
		album = new Album();
		laminas = new ArrayList<>();
	}
	
	// GET AND SET

	
	public void agregarLamina(Lamina lamina) {
		
		laminas.add(lamina);
	}
	
	public void setDinero(int dinero) {
		
	this.dinero = dinero;	
		
	}
	
	public int getDinero() {
		
	return dinero;	
		
	}
	
	
	/**
	 * Este metodo retorna el nombre del jugador
	 * @return String nickName.
	 */
	public String getNickName() {
		return nickName;
	}
	
	/**
	 * Este metodo modifica el nombre del jugador
	 * @param nickName nombre del jugador.
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	/**
	 * Este metodo retorna la contrasena del jugador
	 * @return String contrasena.
	 */
	public String getContrasena() {
		return contrasena;
	}
	
	/**
	 * Este metodo modifica la contrasena del jugador
	 * @param contrasena contrasena del jugador del jugador.
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public Album getAlbum() {
		
		return album;
		
	}
	
	

}
