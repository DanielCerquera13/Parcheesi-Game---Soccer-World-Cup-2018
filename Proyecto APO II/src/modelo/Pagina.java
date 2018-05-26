
/**
 * @author juandavidpaz, juan camilo velez, jhonatan bellaiza, daniel alejandro cerquera
 */
package modelo;

public class Pagina {
	
	
	private Pagina anterior;
	private Pagina siguiente;
	private Lamina[] laminas;
	private String seleccion;
	private String rutaBandera;
	private int numero;
	private String grupo;

	
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
