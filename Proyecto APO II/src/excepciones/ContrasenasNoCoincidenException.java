package excepciones;

public class ContrasenasNoCoincidenException extends Exception{
	public ContrasenasNoCoincidenException() {
		super("Las contrase�as no coinciden");
	}

}
