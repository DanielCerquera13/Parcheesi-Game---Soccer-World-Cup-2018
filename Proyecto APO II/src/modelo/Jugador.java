/**
 * @author juandavidpaz, juan camilo velez, jhonatan bellaiza, daniel alejandro cerquera
 */
package modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

import excepciones.LaminaNoObtenidaException;

public class Jugador implements Serializable, Comparable<Jugador> {

	// ATRIBUTOS

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

	// CONSTRUCTOR

	/**
	 * relacion con la lamina
	 */
	private ArrayList<Lamina> laminas;
	/**
	 * Constructor de la clase Jugador.
	 */

	/**
	 * arreglo de laminas boolean
	 */
	private boolean[] laminasObtenidas;

	public Jugador(String nickName, String contrasena) {

		this.nickName = nickName;
		this.contrasena = contrasena;
		dinero = 500;
		album = new Album();
		laminas = new ArrayList<Lamina>();
		laminasObtenidas = new boolean[353];

		iniciarFalse();
	}

	// GET AND SET

	/**
	 * Este metodo permite actualizar las laminas obtenidas en el album, para que se
	 * puedan visualizar a color en la interfaz
	 * 
	 */
	public void actualizarLaminasObtenidas() {

		// Primera pagina del album del jugador
		Pagina actual = album.getPrimero();

		// Recorremos
		for (int i = 1; i < laminasObtenidas.length; i++) {

			if (laminasObtenidas[i] == true) {

				int mod = i % 11;
				int pag = i / 11;

				if (mod != 0) {

					pag += 1;

				}

				while (actual.getNumero() != pag) {

					actual = actual.getSiguiente();

				}

				for (int j = 0; j < actual.getLaminas().length; j++) {

					if (actual.getLaminas()[j].getNumero() == i) {

						actual.getLaminas()[j].setObtenida(true);

					}

				}

			}

		}

	}

	/**
	 * Inicializa todas las posiciones del arreglo laminasObtenidas en false. (False
	 * = Jugador no ha obtenido la lamina , True = Jugador ha obtenido la lamina)
	 */
	public void iniciarFalse() {

		for (int i = 0; i < laminasObtenidas.length; i++) {
			laminasObtenidas[i] = false;
		}
	}

	public void agregarLamina(Lamina lamina) {

		laminas.add(lamina);

		int numero = lamina.getNumero();

		laminasObtenidas[numero] = true;
		actualizarLaminasObtenidas();
		ordenarLaminasObtenidas();

	}

	public void setDinero(int dinero) {

		this.dinero = dinero;

	}

	public int getDinero() {

		return dinero;

	}

	/**
	 * Este metodo retorna el nombre del jugador
	 * 
	 * @return String nickName.
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * Este metodo modifica el nombre del jugador
	 * 
	 * @param nickName
	 *            nombre del jugador.
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * Este metodo retorna la contrasena del jugador
	 * 
	 * @return String contrasena.
	 */
	public String getContrasena() {
		return contrasena;
	}

	/**
	 * Este metodo modifica la contrasena del jugador
	 * 
	 * @param contrasena
	 *            contrasena del jugador del jugador.
	 */
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public Album getAlbum() {

		return album;

	}

	public boolean[] getLaminasObtenidas() {

		return laminasObtenidas;

	}

	public ArrayList<Lamina> getLaminas() {
		return laminas;
	}

	public void setLaminas(ArrayList<Lamina> laminas) {
		this.laminas = laminas;
	}

	public void setLaminasObtenidas(boolean[] laminasObtenidas) {
		this.laminasObtenidas = laminasObtenidas;
	}

	public void ordenarLaminasObtenidas() {

		for (int i = 0; i < laminas.size() - 1; i++) {

			Lamina menor = laminas.get(i);
			int cual = i;

			for (int j = i + 1; j < laminas.size(); j++) {

				if (laminas.get(j).compareTo(menor) < 0) {

					menor = laminas.get(j);
					cual = j;

				}

			}

			Lamina temp = laminas.get(i);
			laminas.set(i, menor);
			laminas.set(cual, temp);

		}

	}

	public Lamina buscarLamina(int num) throws LaminaNoObtenidaException {

		Lamina lam = null;
		int inicio = 0;
		int fin = laminas.size() - 1;
		while (inicio <= fin && lam == null) {

			int medio = (inicio + fin) / 2;
			if (laminas.get(medio).getNumero() == num) {

				lam = laminas.get(medio);

			} else if (laminas.get(medio).getNumero() < num) {

				inicio = medio + 1;
			} else {

				fin = medio - 1;
			}
		}

		if (lam == null) {

			throw new LaminaNoObtenidaException(num);

		}

		return lam;

	}

	@Override
	public int compareTo(Jugador jug) {

		return this.getNickName().compareToIgnoreCase(jug.getNickName());
	}

	// public static void main(String[] args) {

	// Jugador j = new Jugador("Juancho", "hola");
	//
	// Lamina lam = new Lamina("James", 10);
	// Lamina lam2 = new Lamina("Falcao", 1);
	// Lamina x = new Lamina("Bacca", 300);
	// Lamina y = new Lamina("Pogba", 119);
	// Lamina z = new Lamina("Messi", 200);
	//
	// j.agregarLamina(lam);
	// j.agregarLamina(lam2);
	// j.agregarLamina(x);
	// j.agregarLamina(y);
	// j.agregarLamina(z);
	//
	// try {
	// System.out.println(j.buscarLamina(2));
	// } catch (LaminaNoObtenidaException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }

	// int lam = 256;
	//
	// int mod = lam % 11;
	//
	// int div = lam / 11;
	//
	// if (mod != 0) {
	//
	// div += 1;
	//
	// }
	//
	// System.out.println(div);

	// }

}
