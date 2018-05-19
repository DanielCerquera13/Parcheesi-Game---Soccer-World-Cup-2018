package excepciones;

public class PaginaYaExisteException extends Exception {
      
	public PaginaYaExisteException(String nombre) 
	{
		super("la pagina de la seleccion" + " " + nombre + " " +  "ya existe");
	}
}
