package modelo;

public class CasillaCasa  extends Casilla {

	private int tipoFicha;
	public CasillaCasa(int tipo, int tipoFicha) {
		super(tipo);
		this.tipoFicha = tipoFicha;
	}

	
	
	
	
public void agregarFicha(Ficha ficha) {
		
		int tamanio = casilllasOcupadas();
		if(hayFichas() == false) {
			getFichas()[0]=ficha;
		}
		
		else if(hayFichas() == true) {
			
			for (int i = 0; i < getFichas().length; i++) {
			  if(tipoFicha == ficha.getTipo())    
				
					getFichas()[tamanio+1]=ficha;
				}
				
		}
	
	
	}
}
