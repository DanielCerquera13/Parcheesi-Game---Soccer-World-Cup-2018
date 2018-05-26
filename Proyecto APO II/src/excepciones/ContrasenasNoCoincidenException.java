package excepciones;

public class ContrasenasNoCoincidenException extends Exception{
	public ContrasenasNoCoincidenException() {
		super("Las contraseñas no coinciden");
	}

}
