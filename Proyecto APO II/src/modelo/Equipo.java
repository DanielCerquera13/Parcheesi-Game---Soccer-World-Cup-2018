
/**
 * @author juandavidpaz, juan camilo velez, jhonatan bellaiza, daniel alejandro cerquera
 */
package modelo;

import java.util.Random;

import javax.swing.JOptionPane;

public class Equipo {

	/**
	 * Ruta de la imagen de la bandera
	 */
	private String rutaBandera;

	/**
	 * Nombre de la seleccion
	 */
	private String seleccion;

	/**
	 * Relacion con el dado uno
	 */
	private Dado dadoUno;

	/**
	 * Relacion con el dado dos
	 */
	private Dado dadoDos;

	/**
	 * Arreglo con la cantidad de fichas
	 */
	private Ficha[] fichas;

	/**
	 * El turno del jugador. True = Tiene el turno, False = No es el turno
	 */
	private boolean turno;

	private int numero;

	/**
	 * Constructor de la clase Equipo
	 * 
	 * @param rutaBandera
	 *            ruta de la imagen de la bandera.
	 * @param seleccion
	 *            nombre de la seleccion
	 */
	public Equipo(String rutaBandera, String seleccion, int numero) {

		this.rutaBandera = rutaBandera;
		this.seleccion = seleccion;
		this.numero = numero;
		dadoUno = new Dado();
		dadoDos = new Dado();
		fichas = new Ficha[4];
		turno = false;

		rellenarFichas();

	}

	public void setTurno(boolean turno) {

		this.turno = turno;

	}

	public boolean getTurno() {

		return turno;

	}

	public void setNumero(int numero) {

		this.numero = numero;

	}

	public int getNumero() {

		return numero;

	}

	public void rellenarFichas() {

		for (int i = 0; i < fichas.length; i++) {

			fichas[i] = new Ficha(seleccion, numero);

		}

	}

	/**
	 * Metodo que entrega el arreglo de fichas.
	 * 
	 * @return arreglo de fichas
	 */
	public Ficha[] getFichas() {

		return fichas;

	}

	/**
	 * Metodo que modifica la ruta de la bandera. <br>
	 * <b> pre: </b> rutaBandera != null . <br>
	 * <b> post: </b> se modifica la ruta de la bandera
	 * 
	 * @param rutaBandera
	 *            nueva ruta de la bandera. <br>
	 */
	public void setRutaBandera(String rutaBandera) {

		this.rutaBandera = rutaBandera;

	}

	/**
	 * entrega la ruta de la bandera. <br>
	 * 
	 * @return ruta de la bandera. <br>
	 */
	public String getRutaBandera() {

		return rutaBandera;

	}

	/**
	 * Metodo que modifica el nomnbre de la seleccion.<br>
	 * <b> pre: </b> nombre != null y nombre!= "" . <br>
	 * <b> post: </b> se modifica el nombre. <b>
	 * 
	 * @param seleccion
	 *            - nuevo nombre de la seleccion.<br>
	 */
	public void setSeleccion(String seleccion) {

		this.seleccion = seleccion;

	}

	/**
	 * Entrega el nombre de la seleccion <br>
	 * 
	 * @return nombre de la seleccion <br>
	 */
	public String getSeleccion() {

		return seleccion;

	}

	/**
	 * Retorna la relacion con el dado uno. <br>
	 * 
	 * @return relacion con el dado uno.
	 */
	public Dado getDadoUno() {

		return dadoUno;

	}

	/**
	 * Retorna la relacion con el dado dos. <br>
	 * 
	 * @return relacion con el dado dos.
	 */
	public Dado getDadoDos() {

		return dadoDos;

	}

	/**
	 * Simula el movimiento de los dados del parques, modificando el valor que cada
	 * dado tendra<br>
	 */
	public void lanzarDados() {

		Random ran = new Random();

		dadoUno.setValor(ran.nextInt(7 - 1) + 1);
		dadoDos.setValor(ran.nextInt(7 - 1) + 1);

	}
 
	/**
	 * Verifica si el lanzamiento de los dados es par o no.
	 * @return true si es par, false si no lo es.
	 */
	public boolean lanzamientoPar() {

		boolean par = false;

		if (dadoUno.getValor() == dadoDos.getValor()) {

			par = true;
		}

		return par;

	}
    
	/**
	 * Verifica si el jugador logra sacar las fichas de la carcel.
	 * @return True si realizo sus tres tiros, False si no fue asi.
	 */
	public boolean verificarTresTiros() {

		boolean si = false;

		if (fichas[0].isLibre() == false) {

			if (fichas[1].isLibre() == false) {

				if (fichas[2].isLibre() == false) {

					if (fichas[3].isLibre() == false) {

						si = true;

					}

				}

			}

		}

		return si;

	}

	/**
	 * Verifica si una ficha se encuentra en la carcel.
	 * @return True si esta en la carcel. False si no lo esta.
	 */
	public boolean fichasEnLaCarcel() {

		boolean si = false;

		for (int i = 0; i < fichas.length; i++) {

			if (fichas[i].isLibre() == false) {

				si = true;

			}

		}

		return si;

	}

	 /**
	  * Realiza un movimiento basado en la decision del jugador. sacar sus fichas de la carcel o mover el par. 
	  * @param ficha - la ficha que se desea mover. <br>
	  * @param decision - la decision de mover o sacar de la carcel. <br>
	  * @param valorDado - valor de cantidad de movimientos que proporciona el dado. 
	  */
	public void decidirPar(Ficha ficha,int decision, int valorDado) {

		if (fichasEnLaCarcel()) {

			if (decision == 0) {

			moverFicha(ficha, valorDado);	

			}

			if (decision == 1) {

				for (int i = 0; i < fichas.length; i++) {

					if (fichas[i].getPosicion() == null) {

						fichas[i].salirDeLaCarcel();

					}

				}

			}

		}
	}
    /**
     * Este metodo simula el movimiento de una ficha.
     * @param ficha la ficha que se va a mover. <br>
     * @param valorDado la cantidad de casillas que se va a mover.
     */
	public void moverFicha(Ficha ficha, int valorDado) {
		
	ficha.mover(valorDado);	
		
	}
	
	
	
	
	
	public static void main(String[] args) {

		Equipo e = new Equipo("", "Colombia", 4);

		e.getFichas()[2].setLibre(false);
		// e.getFichas()[3].setLibre(true);

		e.lanzarDados();

		System.out.println(e.getDadoUno().getValor() + " - " + e.getDadoDos().getValor());

		System.out.println(e.lanzamientoPar());

		String[] ops = { "Correr ficha", "Salir de la carcel" };
		int i = JOptionPane.showOptionDialog(null, "Que desea hacer?", "Opcion Par", JOptionPane.DEFAULT_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, ops, ops[0]);

//		e.decidirPar(i);

		System.out.println(e.getFichas()[2].isLibre());
		System.out.println(e.getFichas()[2].getPosicion());

		// System.out.println(e.fichaEnLaCarcel());

	}

}
