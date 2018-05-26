
/**
 * @author juandavidpaz, juan camilo velez, jhonatan bellaiza, daniel alejandro cerquera
 */
package modelo;

public class Pagina {
	
	
	/**
	 * Relacion la pagina anterior. 
	 */
	private Pagina anterior;
	
	/**
	 * Relacion con la pagina siguiente.
	 */
	private Pagina siguiente;
	/**
	 * Arreglo de laminas de la pagina.
	 */
	private Lamina[] laminas;
	
	/**
	 * Nombre de la seleccion.
	 */
	private String seleccion;
	
	/**
	 * Ruta de la bandera de la seleccion.
	 */
	private String rutaBandera;
	
	/**
	 * Numero de pagina.
	 */
	private int numero;
	
	/**
	 * Grupo al que pertenece la seleccion.
	 */
	private String grupo;

	
	
	/**
	 *  Constructor de la clase Pagina.
	 * @param rutaBandera - ruta de la bandera de la seleccion
	 * @param seleccion - nombre de la seleccion
	 * @param numero - numero de la seleccion
	 * @param grupo - grupo al que pertenece la seleccion
	 */
	public Pagina(String rutaBandera, String seleccion,int numero, String grupo) {
	
	laminas = new Lamina[11];
	this.rutaBandera = rutaBandera;
	this.seleccion = seleccion;	
	this.numero = numero;
	this.grupo = grupo;
	
		
	}
	
	
	/**
	 * Modifica la ruta de la bandera de la seleccion
	 * @param rutaBandera - nueva ruta
	 */
	public void setRutaBandera(String rutaBandera) {
		
	this.rutaBandera = rutaBandera;	
		
	}
	
	/**
	 * Entrega la ruta de la bandera.
	 * @return ruta de la bandera.
	 */
	public String getRutaBandera() {
		
	return rutaBandera;	
		
	}
	
	/**
	 * Modifica el arreglo de laminas por uno nuevo.
	 * @param laminas - el nuevo arreglo
	 */
	public void setLaminas(Lamina[] laminas) {
		
	this.laminas = laminas;	
		
	}
	
	/**
	 * Entrega el arreglo de laminas.
	 * @return arreglo de laminas
	 */
	public Lamina[] getLaminas() {
		
	return laminas;	
		
	}
	
	/**
	 * Modifica el nombre de la seleccion.
	 * @param seleccion - nuevo nombre de la seleccion
	 */
	public void setSeleccion(String seleccion) {
		
	this.seleccion = seleccion;	
		
	}
	
	/**
	 * Entrega el nombre de la seleccion.
	 * @return nombre de la seleccion.
	 */
	public String getSeleccion() {
			
	return seleccion;
		
	}
	
	/**
	 * Modifica el numero de la pagina por uno nuevo.
	 * @param numero nuevo numero de la pagina.
	 */
	public void setNumero(int numero) {
		
	this.numero = numero;	
		
	}
	
	/**
	 * Entrega el nuevo numero de la pagina.
	 * @return numero de la pagina.
	 */
	public int getNumero() {
		
	return numero;	
		
	}
	
	/**
	 * Modifica el grupo de la selecion por uno nuevo.
	 * @param grupo - nuevo grupo de la seleccion
	 */
	public void setGrupo(String grupo) {
		
	this.grupo = grupo;	
		
	}
	
	/**
	 * Entregar grupo de la seleccion
	 * @return 
	 */
	public String getGrupo() {
		
	return grupo;	
		
	}
	
	/**
	 * Modifica la pagina anterior por una nueva.
	 * @param anterior - la nueva pagina.
	 */
	public void setAnterior(Pagina anterior) {
		
	this.anterior = anterior;	
		
	}
	
	/**
	 * Modifica la pagina siguiente por una nueva.
	 * @param siguiente- la nueva pagina siguiente.
	 */
	public void setSiguiente(Pagina siguiente) {
		
	this.siguiente = siguiente;	
		
	}
	
	/**
	 * Entrega la pagina anterior.
	 * @return - la pagina anterior.
	 */
	public Pagina getAnterior() {
		
	return anterior;	
		
	}
	
	/**
	 *  Entrega la pagina anterior.
	 * @return la pagina siguiente.
	 */
	public Pagina getSiguiente() {
		
	return siguiente;	
		
	}
	
	
	

}
