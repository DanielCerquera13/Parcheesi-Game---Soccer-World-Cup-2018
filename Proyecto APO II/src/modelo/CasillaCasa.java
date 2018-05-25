package modelo;

public class CasillaCasa  extends Casilla {

	public CasillaCasa(int tipo) {
		super(tipo);
		// TODO Auto-generated constructor stub
	}

	
	
	
	
public void agregarFicha(Ficha ficha) {
		
		int tamanio = casilllasOcupadas();
		if(hayFichas() == false) {
			getFichas()[0]=ficha;
		}
		
		else if(hayFichas() == true) {
			
			for (int i = 0; i < getFichas().length; i++) {
			      
			if(getFichas()[i].getTipo()== ficha.getTipo()) {
					getFichas()[tamanio+1]=ficha;
				}
				
		}
	}
	
	}
}
