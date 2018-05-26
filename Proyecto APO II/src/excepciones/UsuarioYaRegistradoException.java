package excepciones;

public class UsuarioYaRegistradoException extends Exception {
	
	public UsuarioYaRegistradoException(){
		super("El usuario ya se encuentra registrado");
	}
	

}
