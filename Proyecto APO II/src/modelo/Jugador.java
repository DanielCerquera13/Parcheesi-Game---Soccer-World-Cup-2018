package modelo;

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
	
	
	
	//CONSTRUCTOR
	
	public Jugador(String nickName, String contrasena) {
		
		this.nickName = nickName;
		this.contrasena = contrasena;
	}
	

	// GET AND SET

	/**
	 * Este metodo retorna el nombre del jugador
	 * @return String nickName.
	 */
	public String getNickName() {
		return nickName;
	}
	
	/**
	 * Este modifica el nombre del jugador
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
	 * Este modifica la contrasena del jugador
	 * @param contrasena contrasena del jugador del jugador.
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	

}
