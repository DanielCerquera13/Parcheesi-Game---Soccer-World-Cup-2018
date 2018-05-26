
/**
 * @author juandavidpaz, juan camilo velez, jhonatan bellaiza, daniel alejandro cerquera
 */
package modelo;

public class Dado {
	
	//ATRIBUTOS
	
	/**
	 * Atributo que representa el valor que puede
	 * tener el dado.
	 */
	private int valor;
	
	
	
	//CONSTRUCTOR
	
	/**
	 * Constructor de la clase Dado.
	 */
	public Dado() {
		
		
	}
	

	//GET AND SET
	
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
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	
	
	
	

}
