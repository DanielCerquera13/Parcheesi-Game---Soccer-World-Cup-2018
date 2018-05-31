package hilos;

import javax.swing.JOptionPane;

import interfaz.PanelParques;
import modelo.Equipo;
import modelo.Parques;

public class HiloParques extends Thread {

	private Parques parques;
	private PanelParques panelParques;

	public HiloParques(Parques parques, PanelParques panelParques) {

		this.parques = parques;
		this.panelParques = panelParques;
	}

	@Override
	public void run() {

		boolean terminado = false;

		Equipo[] equipos = parques.getEquipos();
		equipos[0].setTurno(true);

		String[] ops = { "LANZAR DADOS" };
		String[] salir = { "SALIR DE LA CARCEL" };
		String[] decision = { "MOVER", "SALIR DE LA CARCEL" };
		String[] fichas = { "1", "2", "3", "4" };

		// Alguien ha ganado ?
		while (!terminado) {

			// El turno es del equipo 1 ?

			if (equipos[0].getTurno()) {

				
				int i = 0;
				// Tiene todas las fichas en la carcel ? LAS 4 !!!
				if (parques.verificarTresTiros()) {

					// Lanza los dados
					 JOptionPane.showOptionDialog(null, "Presiona para lanzar los dados", "Dados",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, ops, ops[0]);

					// Lanza los dados
					equipos[0].lanzarDados();

					if (equipos[0].getDadoUno().getValor() == equipos[0].getDadoDos().getValor()) {

						parques.sacarFichasDeLaCarcel(equipos[0].getFichas());

						panelParques.actualizarFichas();
						
						JOptionPane.showMessageDialog(null, "Valor Dado uno: " + equipos[0].getDadoUno().getValor() + " - Valor Dado Dos: "
								+ equipos[0].getDadoDos().getValor()+
						"\n "+"Bien! Has salido de la carcel", "Salir de la carcel",
								JOptionPane.INFORMATION_MESSAGE);

					} else {

						JOptionPane.showMessageDialog(null,
								"Valor Dado uno: " + equipos[0].getDadoUno().getValor() + " - Valor Dado Dos: "
										+ equipos[0].getDadoDos().getValor(),
								"Valores de los dados", JOptionPane.INFORMATION_MESSAGE);

					}

				}else {
					
					if (equipos[0].getDadoUno().getValor() == equipos[0].getDadoDos().getValor()) {
					
						
						
					}
					
				}

			}
		}

	}

}
