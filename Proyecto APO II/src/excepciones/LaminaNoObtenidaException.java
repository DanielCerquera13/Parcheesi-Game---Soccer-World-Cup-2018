package excepciones;

public class LaminaNoObtenidaException extends Exception {

	
	public LaminaNoObtenidaException(int num) {
		
	super("La lamina # "+num+" no est� en tu inventario. Juega m�s para conseguirla o adquiere laminas al azar en la tienda");	
		
	}
	
	
}
