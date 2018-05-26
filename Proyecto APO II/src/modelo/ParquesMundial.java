/**
 * @author juandavidpaz, juan camilo velez, jhonatan bellaiza, daniel alejandro cerquera
 */
package modelo;

import java.util.ArrayList;

import excepciones.UsuarioYaRegistradoException;

public class ParquesMundial {

	/**
	 * Arraylist de usuarios
	 */
	private ArrayList<Jugador> usuarios;
	
	/**
	 * Relacion con la clase partida.
	 */
	private Partida partidaRapida;

	
	/**
	 * Constructor de la clase ParquesMundial.
	 */
	public ParquesMundial() {

		usuarios = new ArrayList<Jugador>();
		jugadorDePrueba();

	}

	/**
	 * El metodo modifica la lista de usuarios.<br>
	 * @param usuarios - el nuevo arraylist de usuarios.<br>
	 * <b> pre: </b> usuarios != null <br>
	 * <b> post: </b> la lista de usuarios se modifica correctamente.
	 */
	public void setUsuarios(ArrayList<Jugador> usuarios) {

		this.usuarios = usuarios;

	}
     
	/**
	 * Entrega la lista de usuarios.
	 * @return arraylist de usuarios.
	 */
	public ArrayList<Jugador> getUsuarios() {

		return usuarios;

	}
	
	/**
	 * Entrega la relacion con la clase partida.
	 * @return relacion con la clase partida.
	 */
	public Partida getPartidaRapida() {
		
	return partidaRapida;	
		
	}
     
	/**
	 * Verifica si el usuario ya existe.
	 * @param nickname - nombre del usuario que se va a verificar.
	 * @return true si ya existe, false si no existe.
	 */
	public boolean yaExiste(String nickname) {

		boolean si = false;

		for (int i = 0; i < usuarios.size(); i++) {

			if (usuarios.get(i).getNickName().equalsIgnoreCase(nickname)) {

				si = true;

			}

		}

		return si;
	}

	/**
	 * El metodo agrega una nuevo usuario.<br>
	 * @param usuario - el nuevo usuario que se va a agregar.<br>
	 * <b> pre: </b> usuario != null <br>
	 * <b> post: </b> el usuario se agrego correctamente.
	 * 	@throws UsuarioYaRegistradoException - se lanza cuando el usuario ya existe

	 */
	
	public void agregarUsuario(Jugador usuario) throws UsuarioYaRegistradoException {

		if (yaExiste(usuario.getNickName())) {

			throw new UsuarioYaRegistradoException();

		} else {

			usuarios.add(usuario);

		}

	}
	
	public void jugadorDePrueba() {

		Jugador player = new Jugador("Juancho", "123456");
		usuarios.add(player);

		Lamina james = new Lamina("James", 341);
		Lamina x = new Lamina("James", 134);
		Lamina y = new Lamina("James", 185);
		Lamina z = new Lamina("James", 227);
		Lamina w = new Lamina("James", 96);

		usuarios.get(0).agregarLamina(james);
		usuarios.get(0).agregarLamina(x);
		usuarios.get(0).agregarLamina(y);
		usuarios.get(0).agregarLamina(z);
		usuarios.get(0).agregarLamina(w);

	}

}
