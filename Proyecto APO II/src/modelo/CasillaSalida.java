package modelo;

public class CasillaSalida extends Casilla {

	private int equipo;
	private int  tipoFicha;
	
	public CasillaSalida(int tipo, int tipoFicha) {
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
				if(getFichas()[i] != null) {
				if(getFichas()[i].getTipo()== ficha.getTipo()) {
					getFichas()[tamanio+1]=ficha;
				}
				else if (getFichas()[i].getTipo()!= ficha.getTipo()) {
					if(tipoFicha== ficha.getTipo()) {
					getFichas()[i]=null;
					getFichas()[0]=ficha;
					}
				}
				}
		}
	}
	
	}

}
