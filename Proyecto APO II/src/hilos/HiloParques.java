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

				int k = 0;
				// Tiene todas las fichas en la carcel ? LAS 4 !!!
				if (parques.verificarTresTiros() && k != 3) {

					// Lanza los dados
					JOptionPane.showOptionDialog(null, "Presiona para lanzar los dados", "Dados",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, ops, ops[0]);

					// Lanza los dados
					equipos[0].lanzarDados();

					// Si es par
					if (equipos[0].getDadoUno().getValor() == equipos[0].getDadoDos().getValor()) {

						JOptionPane.showMessageDialog(null,
								"Valor Dado uno: " + equipos[0].getDadoUno().getValor() + " - Valor Dado Dos: "
										+ equipos[0].getDadoDos().getValor() + "\n " + "Bien! Has salido de la carcel",
								"Salir de la carcel", JOptionPane.INFORMATION_MESSAGE);

						parques.sacarFichasDeLaCarcel(equipos[0].getFichas());

						panelParques.actualizarFichas();

					} else {

						JOptionPane.showMessageDialog(null,
								"Valor Dado uno: " + equipos[0].getDadoUno().getValor() + " - Valor Dado Dos: "
										+ equipos[0].getDadoDos().getValor(),
								"Valores de los dados", JOptionPane.INFORMATION_MESSAGE);
						k++;
					}

				} else {

					if (k == 3) {
						equipos[0].setTurno(false);
						equipos[1].setTurno(true);
						k = 0;
					}

					if (equipos[0].getDadoUno().getValor() == equipos[0].getDadoDos().getValor()) {

						equipos[0].lanzarDados();

						// Que ficha se desea mover
						int x = JOptionPane.showOptionDialog(null,
								"Valor Dado uno: " + equipos[0].getDadoUno().getValor() + " - Valor Dado Dos: "
										+ equipos[0].getDadoDos().getValor() + "\nQue ficha desea mover?",
								"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
								fichas[0]);

						// Variable que suma la cantidad de ambos dados
						int ambosDados = equipos[0].getDadoUno().getValor() + equipos[0].getDadoDos().getValor();

						// Arreglo de String para opciones del usuario
						String[] valoresDados = { "Valor Uno :" + equipos[0].getDadoUno().getValor(),
								" Valor Dos:" + equipos[0].getDadoDos().getValor(), "Ambos: " + ambosDados };

						// Cantidad a mover !
						int y = JOptionPane.showOptionDialog(null,
								"Que cantidad desea mover? \n" + "Valor Dado uno: " + equipos[0].getDadoUno().getValor()
										+ " - Valor Dado Dos:" + +equipos[0].getDadoDos().getValor(),
								"Cantidad a mover", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
								valoresDados, valoresDados[0]);

						int valorCorrer = 0;

						switch (y) {

						case 0:
							valorCorrer = equipos[0].getDadoUno().getValor();

							break;

						case 1:
							valorCorrer = equipos[0].getDadoDos().getValor();

							break;

						case 2:
							valorCorrer = ambosDados;

						}

						switch (x) {

						case 0:
							parques.moverFichaNew(equipos[0].getFichas()[0], valorCorrer);
							panelParques.actualizarFichas();
							equipos[0].setTurno(false);
							equipos[1].setTurno(true);
							break;

						case 1:
							parques.moverFichaNew(equipos[0].getFichas()[1], valorCorrer);
							panelParques.actualizarFichas();
							equipos[0].setTurno(false);
							equipos[1].setTurno(true);
							break;

						case 2:
							parques.moverFichaNew(equipos[0].getFichas()[2], valorCorrer);
							panelParques.actualizarFichas();
							equipos[0].setTurno(false);
							equipos[1].setTurno(true);
							break;

						case 3:
							parques.moverFichaNew(equipos[0].getFichas()[3], valorCorrer);
							panelParques.actualizarFichas();
							equipos[0].setTurno(false);
							equipos[1].setTurno(true);
							break;

						}

					} else {

						// Que ficha se desea mover
						int x = JOptionPane.showOptionDialog(null,
								"Valor Dado uno: " + equipos[0].getDadoUno().getValor() + " - Valor Dado Dos: "
										+ equipos[0].getDadoDos().getValor() + "\nQue ficha desea mover?",
								"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
								fichas[0]);

						// Variable que suma la cantidad de ambos dados
						int ambosDados = equipos[0].getDadoUno().getValor() + equipos[0].getDadoDos().getValor();

						// Arreglo de String para opciones del usuario
						String[] valoresDados = { "Valor Uno :" + equipos[0].getDadoUno().getValor(),
								" Valor Dos:" + equipos[0].getDadoDos().getValor(), "Ambos: " + ambosDados };

						// Cantidad a mover !
						int y = JOptionPane.showOptionDialog(null,
								"Que cantidad desea mover? \n" + "Valor Dado uno: " + equipos[0].getDadoUno().getValor()
										+ " - Valor Dado Dos:" + +equipos[0].getDadoDos().getValor(),
								"Cantidad a mover", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
								valoresDados, valoresDados[0]);

						int valorCorrer = 0;

						switch (y) {

						case 0:
							valorCorrer = equipos[0].getDadoUno().getValor();

							break;

						case 1:
							valorCorrer = equipos[0].getDadoDos().getValor();

							break;

						case 2:
							valorCorrer = ambosDados;

						}

						switch (x) {

						case 0:
							parques.moverFichaNew(equipos[0].getFichas()[0], valorCorrer);
							panelParques.actualizarFichas();
							equipos[0].setTurno(false);
							equipos[1].setTurno(true);
							break;

						case 1:
							parques.moverFichaNew(equipos[0].getFichas()[1], valorCorrer);
							panelParques.actualizarFichas();
							equipos[0].setTurno(false);
							equipos[1].setTurno(true);
							break;

						case 2:
							parques.moverFichaNew(equipos[0].getFichas()[2], valorCorrer);
							panelParques.actualizarFichas();
							equipos[0].setTurno(false);
							equipos[1].setTurno(true);
							break;

						case 3:
							parques.moverFichaNew(equipos[0].getFichas()[3], valorCorrer);
							panelParques.actualizarFichas();
							equipos[0].setTurno(false);
							equipos[1].setTurno(true);
							break;

						}

					}

				}

			} else if (equipos[1].getTurno()) {

				int k = 0;
				// Tiene todas las fichas en la carcel ? LAS 4 !!!
				if (parques.verificarTresTiros() && k != 3) {

					// Lanza los dados
					JOptionPane.showOptionDialog(null, "Presiona para lanzar los dados", "Dados",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, ops, ops[0]);

					// Lanza los dados
					equipos[1].lanzarDados();

					// Si es par
					if (equipos[1].getDadoUno().getValor() == equipos[1].getDadoDos().getValor()) {

						JOptionPane.showMessageDialog(null,
								"Valor Dado uno: " + equipos[1].getDadoUno().getValor() + " - Valor Dado Dos: "
										+ equipos[1].getDadoDos().getValor() + "\n " + "Bien! Has salido de la carcel",
								"Salir de la carcel", JOptionPane.INFORMATION_MESSAGE);

						parques.sacarFichasDeLaCarcel(equipos[1].getFichas());

						panelParques.actualizarFichas();

					} else {

						JOptionPane.showMessageDialog(null,
								"Valor Dado uno: " + equipos[1].getDadoUno().getValor() + " - Valor Dado Dos: "
										+ equipos[1].getDadoDos().getValor(),
								"Valores de los dados", JOptionPane.INFORMATION_MESSAGE);
						k++;
					}

				} else {

					if (k == 3) {
						equipos[1].setTurno(false);
						equipos[2].setTurno(true);
						k = 0;
					}

					if (equipos[1].getDadoUno().getValor() == equipos[1].getDadoDos().getValor()) {

						equipos[1].lanzarDados();

						// Que ficha se desea mover
						int x = JOptionPane.showOptionDialog(null,
								"Valor Dado uno: " + equipos[1].getDadoUno().getValor() + " - Valor Dado Dos: "
										+ equipos[1].getDadoDos().getValor() + "\nQue ficha desea mover?",
								"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
								fichas[0]);

						// Variable que suma la cantidad de ambos dados
						int ambosDados = equipos[1].getDadoUno().getValor() + equipos[1].getDadoDos().getValor();

						// Arreglo de String para opciones del usuario
						String[] valoresDados = { "Valor Uno :" + equipos[1].getDadoUno().getValor(),
								" Valor Dos:" + equipos[1].getDadoDos().getValor(), "Ambos: " + ambosDados };

						// Cantidad a mover !
						int y = JOptionPane.showOptionDialog(null,
								"Que cantidad desea mover? \n" + "Valor Dado uno: " + equipos[1].getDadoUno().getValor()
										+ " - Valor Dado Dos:" + +equipos[1].getDadoDos().getValor(),
								"Cantidad a mover", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
								valoresDados, valoresDados[0]);

						int valorCorrer = 0;

						switch (y) {

						case 0:
							valorCorrer = equipos[1].getDadoUno().getValor();
						
							break;

						case 1:
							valorCorrer = equipos[1].getDadoDos().getValor();

							break;

						case 2:
							valorCorrer = ambosDados;

						}

						switch (x) {

						case 0:
							parques.moverFichaNew(equipos[1].getFichas()[0], valorCorrer);
							panelParques.actualizarFichas();
							equipos[1].setTurno(false);
							equipos[2].setTurno(true);
							break;

						case 1:
							parques.moverFichaNew(equipos[1].getFichas()[1], valorCorrer);
							panelParques.actualizarFichas();
							equipos[1].setTurno(false);
							equipos[2].setTurno(true);
							break;

						case 2:
							parques.moverFichaNew(equipos[1].getFichas()[2], valorCorrer);
							panelParques.actualizarFichas();
							equipos[1].setTurno(false);
							equipos[2].setTurno(true);
							break;

						case 3:
							parques.moverFichaNew(equipos[1].getFichas()[3], valorCorrer);
							panelParques.actualizarFichas();
							equipos[1].setTurno(false);
							equipos[2].setTurno(true);
							break;

						}
						
						if(y==0) {
							
							int w = JOptionPane.showOptionDialog(null,
									"Valor Dado uno: " + equipos[1].getDadoUno().getValor() + " - Valor Dado Dos: "
											+ equipos[1].getDadoDos().getValor() + "\nQue ficha desea mover?",
									"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
									fichas[0]);
							
							// Arreglo de String para opciones del usuario
							String[] valoresDado = {" Valor Dos:" + equipos[1].getDadoDos().getValor()};

							// Cantidad a mover !
							int z = JOptionPane.showOptionDialog(null,
									"Que cantidad desea mover? \n" + "Valor Dado uno: " + equipos[1].getDadoUno().getValor()
											+ " - Valor Dado Dos:" + +equipos[1].getDadoDos().getValor(),
									"Cantidad a mover", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
									valoresDado, valoresDado[0]);

						switch(z) {
						
						case 0: valorCorrer = equipos[1].getDadoDos().getValor();
						
						}
						
						switch(w) {
						
						case 0:
							parques.moverFichaNew(equipos[1].getFichas()[0], valorCorrer);
							panelParques.actualizarFichas();
							equipos[1].setTurno(false);
							equipos[2].setTurno(true);
							break;

						case 1:
							parques.moverFichaNew(equipos[1].getFichas()[1], valorCorrer);
							panelParques.actualizarFichas();
							equipos[1].setTurno(false);
							equipos[2].setTurno(true);
							break;

						case 2:
							parques.moverFichaNew(equipos[1].getFichas()[2], valorCorrer);
							panelParques.actualizarFichas();
							equipos[1].setTurno(false);
							equipos[2].setTurno(true);
							break;

						case 3:
							parques.moverFichaNew(equipos[1].getFichas()[3], valorCorrer);
							panelParques.actualizarFichas();
							equipos[1].setTurno(false);
							equipos[2].setTurno(true);
							break;
						
						
						
						}
							
							
						}
						

					} else {

						// Que ficha se desea mover
						int x = JOptionPane.showOptionDialog(null,
								"Valor Dado uno: " + equipos[1].getDadoUno().getValor() + " - Valor Dado Dos: "
										+ equipos[1].getDadoDos().getValor() + "\nQue ficha desea mover?",
								"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
								fichas[0]);

						// Variable que suma la cantidad de ambos dados
						int ambosDados = equipos[1].getDadoUno().getValor() + equipos[1].getDadoDos().getValor();

						// Arreglo de String para opciones del usuario
						String[] valoresDados = { "Valor Uno :" + equipos[1].getDadoUno().getValor(),
								" Valor Dos:" + equipos[1].getDadoDos().getValor(), "Ambos: " + ambosDados };

						// Cantidad a mover !
						int y = JOptionPane.showOptionDialog(null,
								"Que cantidad desea mover? \n" + "Valor Dado uno: " + equipos[1].getDadoUno().getValor()
										+ " - Valor Dado Dos:" + +equipos[1].getDadoDos().getValor(),
								"Cantidad a mover", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
								valoresDados, valoresDados[0]);

						int valorCorrer = 0;

						switch (y) {

						case 0:
							valorCorrer = equipos[1].getDadoUno().getValor();

							break;

						case 1:
							valorCorrer = equipos[1].getDadoDos().getValor();

							break;

						case 2:
							valorCorrer = ambosDados;

						}

						switch (x) {

						case 0:
							parques.moverFichaNew(equipos[1].getFichas()[0], valorCorrer);
							panelParques.actualizarFichas();
							equipos[1].setTurno(false);
							equipos[2].setTurno(true);
							break;

						case 1:
							parques.moverFichaNew(equipos[1].getFichas()[1], valorCorrer);
							panelParques.actualizarFichas();
							equipos[1].setTurno(false);
							equipos[2].setTurno(true);
							break;

						case 2:
							parques.moverFichaNew(equipos[1].getFichas()[2], valorCorrer);
							panelParques.actualizarFichas();
							equipos[1].setTurno(false);
							equipos[2].setTurno(true);
							break;

						case 3:
							parques.moverFichaNew(equipos[1].getFichas()[3], valorCorrer);
							panelParques.actualizarFichas();
							equipos[1].setTurno(false);
							equipos[2].setTurno(true);
							break;

						}

					}

				}

			}
		}

	}

}
