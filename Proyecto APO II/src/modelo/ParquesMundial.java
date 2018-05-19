package modelo;

import java.util.ArrayList;

public class ParquesMundial {

	
	private ArrayList<Jugador> usuarios;
	private Partida partidaRapida;
	
	public ParquesMundial() {
		
	usuarios = new ArrayList<Jugador>();	
	jugadorDePrueba();
		
	}
	
	public void setUsuarios(ArrayList<Jugador> usuarios) {
		
	this.usuarios = usuarios;	
		
	}
	
	public ArrayList<Jugador> getUsuarios(){
		
	return usuarios;	
		
	}
	
	public void jugadorDePrueba() {
		
	Jugador player = new Jugador("Juancho", "123456");
	usuarios.add(player);
		
	}
	
	
}
