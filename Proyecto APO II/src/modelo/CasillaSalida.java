package modelo;

public class CasillaSalida extends Casilla {

	/**
	 * numero de tipo de ficha que se va a agregar. 
	 */
	private int  tipoFicha;
	
	
	/**
	 * Constructor de la clase CasillaSalida.
	 * @param tipo - tipo de Casilla
	 * @param tipoFicha - tipo de Ficha
	 */
	public CasillaSalida(int tipo,int posicion, int tipoFicha) {
		super(tipo,posicion);
		this.tipoFicha = tipoFicha;
	}
	
	

	/**
	 * El metodo agrega una nueva ficha a la casilla.<br>
	 * <b> pre: </b> ficha != null <br>
	 * <b> post: </b> La ficha es agregada correctamente.
	 * @param ficha - La nueva ficha que se va a agregar.<br>
	 */
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
