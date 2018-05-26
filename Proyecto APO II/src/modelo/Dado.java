
/**
 * @author juandavidpaz, juan camilo velez, jhonatan bellaiza, daniel alejandro cerquera
 */
package modelo;

public class Dado {
	
	
	/**
	 * Atributo que representa el valor que puede
	 * tener el dado.
	 */
	private int valor;
	
	
	
	
	/**
	 * Constructor de la clase Dado.
	 */
	public Dado() {
		
		
	}
	

	
	/**
	 * Metodo que retorna el valor del dado.
	 * @return int valor.
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * Metodo que modifica el valor del dado
	 * @param valor valor que representa el numero del dado.
	 * <b> post: </b> el valor se modifica .
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	
	
	
	

}
