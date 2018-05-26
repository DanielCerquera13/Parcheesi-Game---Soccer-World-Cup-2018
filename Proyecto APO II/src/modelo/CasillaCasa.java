package modelo;

public class CasillaCasa extends Casilla {

	private int tipoFicha;

	public CasillaCasa(int tipo, int tipoFicha) {
		super(tipo);
		this.tipoFicha = tipoFicha;
	}

	public void agregarFicha(Ficha ficha) {

		int tamanio = casilllasOcupadas();

		if (tipoFicha == ficha.getTipo()) {
			if (hayFichas() == false) {
				getFichas()[0] = ficha;
			}

			else if (hayFichas() == true) {

				getFichas()[tamanio + 1] = ficha;

			}
		}

	}
}
