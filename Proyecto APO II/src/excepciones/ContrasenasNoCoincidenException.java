package excepciones;

public class ContrasenasNoCoincidenException extends Exception{
	public ContrasenasNoCoincidenException() {
		super("Las contraseņas no coinciden");
	}

}
