package modelo;

public class CasillaNormal extends Casilla {


	public CasillaNormal(int tipo) {
		super(tipo);
	}
 
	
	public void agregarFicha(Ficha ficha) {
		 
		int tamanio = casilllasOcupadas();
		if(hayFichas() == false) {
			getFichas()[0]=ficha;
		}
		
		else if( hayFichas()== true) {
			
			for (int i = 0; i < getFichas().length; i++) {
				if(getFichas()[i].getTipo()== ficha.getTipo()) {
					getFichas()[tamanio+1]=ficha;
				}
				else if (getFichas()[i].getTipo()!= ficha.getTipo()) {
					getFichas()[i]=null;
					getFichas()[0]=ficha;

				}
			}
		}
	}

}
