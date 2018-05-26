/**
 * @author juandavidpaz, juan camilo velez, jhonatan bellaiza, daniel alejandro cerquera
 */
package modelo;

import java.util.Arrays;

public class Parques implements Constantes {

	
	private Casilla[] casillas;
	private Equipo[] equipos;
	
	
	public Parques() {
		
	casillas = new Casilla[96];
	equipos = new Equipo[4];
	situarCasillas();
	
	
	}
	
	public void setEquipos(Equipo[] equipos) {
		
	this.equipos = equipos;	
		
	}
	
	public Equipo[] getEquipos() {
		
	return equipos;	
		
	}
	
	
	public Casilla[] getCasillas() {
		
	return casillas;	
		
	}
	
	
	public void situarCasillas() {
		
	// Se situan las salidas
	
	
	for(int i = 0; i<casillas.length; i++) {
		
	switch(i) {
	
	
	// Casillas Salidas
	case 0: 
		casillas[i] = new CasillaSalida(Constantes.SALIDA, Constantes.UNO);
	break;

	case 24: 
		casillas[i] = new CasillaSalida(Constantes.SALIDA, Constantes.DOS);
	break;
	
	case 48:
		casillas[i] = new CasillaSalida(Constantes.SALIDA, Constantes.TRES);
	break;
	
	case 72:
		casillas[i] = new CasillaSalida(Constantes.SALIDA, Constantes.CUATRO);
	break;
	
	// Fin Casillas Salidas
	
	//Casillas Seguro
	
	case 7: 
		casillas[i] = new CasillaSegura(Constantes.SEGURO);
	break;
	
	case 12: 
		casillas[i] = new CasillaSegura(Constantes.SEGURO);
	break;
	
	case 31: 
		casillas[i] = new CasillaSegura(Constantes.SEGURO);
	break;
	
	case 36: 
		casillas[i] = new CasillaSegura(Constantes.SEGURO);
	break;
	
	case 55: 
		casillas[i] = new CasillaSegura(Constantes.SEGURO);
	break;
	
	case 60: 
		casillas[i] = new CasillaSegura(Constantes.SEGURO);
	break;
	
	case 79: 
		casillas[i] = new CasillaSegura(Constantes.SEGURO);
	break;
	
	case 84: 
		casillas[i] = new CasillaSegura(Constantes.SEGURO);
	break;
	
	// Fin Casillas Seguro
	
	
	default: 
		casillas[i] = new CasillaNormal(Constantes.NORMAL);
	
	}
	
	
	if(i>=85 && i<=91)
		casillas[i] = new CasillaCasa(Constantes.CASA, Constantes.UNO);
	
	if(i>=13 && i<=19)
		casillas[i] = new CasillaCasa(Constantes.CASA, Constantes.DOS);
	
	if(i>=37 && i<=43)
		casillas[i] = new CasillaCasa(Constantes.CASA, Constantes.TRES);
	
	if(i>=61 && i<=67)
		casillas[i] = new CasillaCasa(Constantes.CASA, Constantes.DOS);	
	
	
	
	
	}
}
	
	
	public static void main(String[] args) {
		
	Parques p = new Parques();
	
	System.out.println(Arrays.toString(p.getCasillas()));
		
	}
	
}
		
		
	

	

