
/**
 * @author juandavidpaz, juan camilo velez, jhonatan bellaiza, daniel alejandro cerquera
 */
package modelo;

import java.util.Random;

public class Equipo {

	private String rutaBandera;
	private String seleccion;
	private Dado dadoUno;
	private Dado dadoDos;
	private Ficha[] fichas;

	public Equipo(String rutaBandera, String seleccion) {

		this.rutaBandera = rutaBandera;
		this.seleccion = seleccion;
		dadoUno = new Dado();
		dadoDos = new Dado();
		fichas = new Ficha[4];

	}

	public Ficha[] getFichas() {

		return fichas;

	}

	public void setRutaBandera(String rutaBandera) {

		this.rutaBandera = rutaBandera;

	}

	public String getRutaBandera() {

		return rutaBandera;

	}

	public void setSeleccion(String seleccion) {

		this.seleccion = seleccion;

	}

	public String getSeleccion() {

		return seleccion;

	}

	public Dado getDadoUno() {

		return dadoUno;

	}

	public Dado getDadoDos() {

		return dadoDos;

	}

	public void lanzarDados() {

		Random ran = new Random();

		dadoUno.setValor(ran.nextInt(7 - 1) + 1);
		dadoDos.setValor(ran.nextInt(7 - 1) + 1);

	}

}
