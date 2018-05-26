package modelo;

import java.util.ArrayList;

import excepciones.UsuarioYaRegistradoException;

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

	public ArrayList<Jugador> getUsuarios() {

		return usuarios;

	}
	
	public Partida getPartidaRapida() {
		
	return partidaRapida;	
		
	}

	public boolean yaExiste(String nickname) {

		boolean si = false;

		for (int i = 0; i < usuarios.size(); i++) {

			if (usuarios.get(i).getNickName().equalsIgnoreCase(nickname)) {

				si = true;

			}

		}

		return si;
	}

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
