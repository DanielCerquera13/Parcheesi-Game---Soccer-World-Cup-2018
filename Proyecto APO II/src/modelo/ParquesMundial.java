/**
 * @author juandavidpaz, juan camilo velez, jhonatan bellaiza, daniel alejandro cerquera
 */
package modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import excepciones.LaminaNoObtenidaException;
import excepciones.UsuarioNoRegistradoException;
import excepciones.UsuarioYaRegistradoException;

public class ParquesMundial {

	/**
	 * Arraylist de usuarios
	 */
	private ArrayList<Jugador> usuarios;

	/**
	 * Representa la sesion que se encuentra iniciada en el programa.
	 */
	private Jugador sesionActiva;

	/**
	 * Relacion con la clase partida.
	 */
	private Partida partidaRapida;

	/**
	 * Constructor de la clase ParquesMundial.
	 */
	public ParquesMundial() {

		usuarios = new ArrayList<Jugador>();
		sesionActiva = null;	
		
		recuperarData();

	}

	/**
	 * Permite modificar la sesion que se encuentra iniciada en el programa
	 * 
	 * @param sesionActiva
	 *            La sesion que se encuentra iniciada
	 * 
	 */
	public void setSesionActiva(Jugador sesionActiva) {

		this.sesionActiva = sesionActiva;

	}

	/**
	 * Entrega la sesion que se encuentra iniciada en el programa
	 * 
	 * @return La sesion iniciada.
	 */
	public Jugador getSesionActiva() {

		return sesionActiva;

	}

	/**
	 * El metodo modifica la lista de usuarios.<br>
	 * <b> pre: </b> usuarios != null <br>
	 * <b> post: </b> la lista de usuarios se modifica correctamente.
	 * 
	 * @param usuarios
	 *            - el nuevo arraylist de usuarios.<br>
	 */
	public void setUsuarios(ArrayList<Jugador> usuarios) {

		this.usuarios = usuarios;

	}

	/**
	 * Entrega la lista de usuarios.
	 * 
	 * @return arraylist de usuarios.
	 */
	public ArrayList<Jugador> getUsuarios() {

		return usuarios;

	}

	/**
	 * Entrega la relacion con la clase partida.
	 * 
	 * @return relacion con la clase partida.
	 */
	public Partida getPartidaRapida() {

		return partidaRapida;

	}

	/**
	 * Verifica si el usuario ya existe.
	 * 
	 * @param nickname
	 *            - nombre del usuario que se va a verificar.
	 * @return true si ya existe, false si no existe.
	 */
	public boolean yaExiste(String nickname) {

		boolean si = false;

		int inicio = 0;
		int fin = usuarios.size() - 1;
		while (inicio <= fin && !si) {

			int medio = (inicio + fin) / 2;
			if (usuarios.get(medio).getNickName().equalsIgnoreCase(nickname)) {

				si = true;

			} else if (usuarios.get(medio).getNickName().compareToIgnoreCase(nickname) < 0) {

				inicio = medio + 1;
			} else {

				fin = medio - 1;
			}
		}

		return si;
	}

	public Jugador buscarUsuario(String nickname) throws UsuarioNoRegistradoException {

		Jugador jug = null;
		int inicio = 0;
		int fin = usuarios.size() - 1;
		while (inicio <= fin && jug == null) {

			int medio = (inicio + fin) / 2;
			if (usuarios.get(medio).getNickName().equalsIgnoreCase(nickname)) {

				jug = usuarios.get(medio);

			} else if (usuarios.get(medio).getNickName().compareToIgnoreCase(nickname) < 0) {

				inicio = medio + 1;
			} else {

				fin = medio - 1;
			}
		}

		if (jug == null) {

			throw new UsuarioNoRegistradoException(nickname);

		}

		return jug;

	}

	/**
	 * El metodo agrega una nuevo usuario.<br>
	 * <b> pre: </b> usuario != null <br>
	 * <b> post: </b> el usuario se agrego correctamente.
	 * 
	 * @param usuario
	 *            - el nuevo usuario que se va a agregar.<br>
	 * 
	 * @throws UsuarioYaRegistradoException
	 *             - se lanza cuando el usuario ya existe
	 * 
	 */
	public void agregarUsuario(Jugador usuario) throws UsuarioYaRegistradoException {

		if (yaExiste(usuario.getNickName())) {

			throw new UsuarioYaRegistradoException();

		} else {

			usuarios.add(usuario);
			ordenarUsuarios();

		}

	}

	/**
	 * Permite serializar el programa.
	 */
	public void guardar() {

		FileOutputStream fS = null;
		ObjectOutputStream oS = null;

		try {

			fS = new FileOutputStream("./Archivos/data/dataJuego.dat");
			oS = new ObjectOutputStream(fS);

			oS.writeObject(usuarios);
		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		} finally {

			try {

				if (usuarios != null) {

					fS.close();
				}
				if (oS != null) {

					oS.close();
				}

			} catch (IOException ex) {

				System.out.println(ex.getMessage());
			}

		}

	}

	public void recuperarData() {

		FileInputStream fS = null;
		ObjectInputStream oS = null;

		ArrayList<Jugador> users = null;

		try {

			fS = new FileInputStream("./Archivos/data/dataJuego.dat");
			oS = new ObjectInputStream(fS);
			users = (ArrayList<Jugador>) oS.readObject();
			setUsuarios(users);

		} catch (Exception ex) {

			System.out.println(ex.getMessage());

		} finally {

			try {
				if (fS != null) {

					fS.close();
				}

				if (oS != null) {

					oS.close();

				}

			} catch (IOException e) {

				System.out.println(e.getMessage());
			}

		}

	}

	public void ordenarUsuarios() {

		for (int i = 0; i < usuarios.size() - 1; i++) {

			Jugador menor = usuarios.get(i);
			int cual = i;

			for (int j = i + 1; j < usuarios.size(); j++) {

				if (usuarios.get(j).compareTo(menor) < 0) {

					menor = usuarios.get(j);
					cual = j;

				}

			}

			Jugador temp = usuarios.get(i);
			usuarios.set(i, menor);
			usuarios.set(cual, temp);

		}

	}

}
