
/**
 * @author juandavidpaz, juan camilo velez, jhonatan bellaiza, daniel alejandro cerquera
 */
package modelo;

import java.util.Random;

public class Equipo {

	
	/**
	 *  Ruta de la imagen de la bandera
	 */
	private String rutaBandera;
	
	/**
	 * Nombre de la seleccion
	 */
	private String seleccion;
	
	/**
	 *  Relacion con el dado uno
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
	 * Constructor de la clase Equipo
	 * @param rutaBandera ruta de la imagen de la bandera.
	 * @param seleccion nombre de la seleccion
	 */
	public Equipo(String rutaBandera, String seleccion) {

		this.rutaBandera = rutaBandera;
		this.seleccion = seleccion;
		dadoUno = new Dado();
		dadoDos = new Dado();
		fichas = new Ficha[4];

	}

	/**
	 * Metodo que entrega el arreglo de fichas.
	 * @return arreglo de fichas
	 */
	public Ficha[] getFichas() {

		return fichas;

	}
      

	/**
	 * Metodo que modifica la ruta de la bandera. <br> 
	 *  <b> pre: </b> rutaBandera != null . <br> 
	 * <b> post: </b> se modifica la ruta de la bandera 
	 * @param rutaBandera nueva ruta de la bandera. <br> 
	 */
	public void setRutaBandera(String rutaBandera) {

		this.rutaBandera = rutaBandera;

	}
    
	/**
	 * entrega la ruta de la bandera. <br> 
	 * @return ruta de la bandera. <br> 
	 */
	public String getRutaBandera() {

		return rutaBandera;

	}
     
	/**
	 * Metodo que modifica el nomnbre de la seleccion.<br> 
	 *   <b> pre: </b> nombre != null y nombre!= "" . <br> 
	 * <b> post: </b> se modifica el nombre. <b> 
	 * @param seleccion - nuevo nombre de la seleccion.<br> 
	 */
	public void setSeleccion(String seleccion) {

		this.seleccion = seleccion;

	}
    /**
     * Entrega el nombre de la seleccion <br> 
     * @return  nombre de la seleccion <br> 
     */
	public String getSeleccion() {

		return seleccion;

	}
    
	/**
	 * Retorna la relacion con el dado uno. <br> 
	 * @return  relacion con el dado uno.
	 */
	public Dado getDadoUno() {

		return dadoUno;

	}
	/**
	 * Retorna la relacion con el dado dos. <br> 
	 * @return  relacion con el dado dos.
	 */
	public Dado getDadoDos() {

		return dadoDos;

	}
    
	/**
	 * Simula el movimiento de los dados del parques, modificando el valor que cada dado tendra<br>
	 */
	public void lanzarDados() {

		Random ran = new Random();

		dadoUno.setValor(ran.nextInt(7 - 1) + 1);
		dadoDos.setValor(ran.nextInt(7 - 1) + 1);

	}

}
