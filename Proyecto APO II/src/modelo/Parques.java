package modelo;

public class Parques {


	
	private Casilla[] casillas;
	private Equipo[] equipos;
	
	
	public Parques() {
		
	casillas = new Casilla[96];
	equipos = new Equipo[4];
	
	
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
	
	
//	public void situarCasillas() {
//		
//	// Se situan las salidas
//	for(int i =0 ; i<96; i+=24) {
//	casillas[i] = new CasillaSalida(2);	
//	}
//	
//	for(int i = 0; i<casillas.length; i++) {
//		
//	if(i==0 || i==24 || i==48 || i==72) {
//		
//	casillas[i] = new CasillaSalida(2);	
//		
//	}else if(i==7 || i==12 || i==31 || i==36 || i == 55 || i == 60 || i == 79 || i == 84) {
//		
//	casillas[i] = new CasillaSegura(3); 	
//		
//	}

//	}
	
	
	
		
	
		
		
		
	

	
	
}
