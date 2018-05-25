package modelo;

public class CasillaSegura  extends Casilla{

	
	
	public CasillaSegura(int tipo) {
		super(tipo);
		// TODO Auto-generated constructor stub
	}
      
	
	public void agregarFicha(Ficha ficha) {
		
		
		if(hayFichas() == false) {
			getFichas()[0]=ficha;
		}
	}
	
	
}
