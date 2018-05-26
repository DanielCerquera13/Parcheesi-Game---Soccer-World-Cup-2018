
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
	
	public void setRutaBandera(String rutaBandera) {
		
	this.rutaBandera = rutaBandera;	
		
	}
	
	public String getRutaBandera() {
		
	return rutaBandera;	
		
	}
	
	public void setLaminas(Lamina[] laminas) {
		
	this.laminas = laminas;	
		
	}
	
	public Lamina[] getLaminas() {
		
	return laminas;	
		
	}
	
	public void setSeleccion(String seleccion) {
		
	this.seleccion = seleccion;	
		
	}
	
	public String getSeleccion() {
			
	return seleccion;
		
	}
	
	public void setNumero(int numero) {
		
	this.numero = numero;	
		
	}
	
	public int getNumero() {
		
	return numero;	
		
	}
	
	
	public void setGrupo(String grupo) {
		
	this.grupo = grupo;	
		
	}
	
	public String getGrupo() {
		
	return grupo;	
		
	}
	
	
	public void setAnterior(Pagina anterior) {
		
	this.anterior = anterior;	
		
	}
	
	public void setSiguiente(Pagina siguiente) {
		
	this.siguiente = siguiente;	
		
	}
	
	public Pagina getAnterior() {
		
	return anterior;	
		
	}
	
	public Pagina getSiguiente() {
		
	return siguiente;	
		
	}
	
	
	

}
