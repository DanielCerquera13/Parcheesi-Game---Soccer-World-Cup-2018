package excepciones;

public class LaminaNoObtenidaException extends Exception {

	
	public LaminaNoObtenidaException(int num) {
		
	super("La lamina # "+num+" no está en tu inventario. Juega más para conseguirla o adquiere laminas al azar en la tienda");	
		
	}
	
	
}
