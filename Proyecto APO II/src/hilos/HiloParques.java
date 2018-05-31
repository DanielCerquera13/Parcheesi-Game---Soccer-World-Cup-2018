package hilos;

import javax.swing.JOptionPane;

import interfaz.PanelParques;
import modelo.Equipo;
import modelo.Parques;

public class HiloParques extends Thread {

	private Parques parques;
	private PanelParques panelParques;
	int k = 0; // Variable para controlar tres tiros si se tienen todas las fichas en la carcel
	int f = 0;
	int g = 0;
	public HiloParques(Parques parques, PanelParques panelParques) {

		this.parques = parques;
		this.panelParques = panelParques;
	}

	public void turnoUno() {

		Equipo[] equipos = parques.getEquipos();

		String[] ops = { "LANZAR DADOS" };
		String[] salir = { "SALIR DE LA CARCEL" };
		String[] decision = { "MOVER", "SALIR DE LA CARCEL" };
		String[] fichas = { "1", "2", "3", "4" };

		if (k == 3 && equipos[0].getDadoUno().getValor() != equipos[0].getDadoDos().getValor()) {
			equipos[0].setTurno(false);
			equipos[1].setTurno(true);
			k = 0;
		} // Tiene todas las fichas en la carcel ? LAS 4 !!!
		else if (parques.verificarTresTiros() && k != 3) {

			// Lanza los dados
			JOptionPane.showOptionDialog(null, "Presiona para lanzar los dados \nJugador Uno", "Dados",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, ops, ops[0]);

			// Lanza los dados
			equipos[0].lanzarDados();
			k++;

			// Si es par
			if (equipos[0].getDadoUno().getValor() == equipos[0].getDadoDos().getValor()) {

				JOptionPane.showMessageDialog(null,
						"Valor Dado uno: " + equipos[0].getDadoUno().getValor() + " - Valor Dado Dos: "
								+ equipos[0].getDadoDos().getValor() + "\n " + "Bien! Has salido de la carcel",
						"Salir de la carcel", JOptionPane.INFORMATION_MESSAGE);

				parques.sacarFichasDeLaCarcel(equipos[0].getFichas());

				panelParques.actualizarFichas();

				k = 0; // Por si sale de la carcel dejar listo la variable para el otro jugador

			} else {

				JOptionPane.showMessageDialog(null,
						"Valor Dado uno: " + equipos[0].getDadoUno().getValor() + " - Valor Dado Dos: "
								+ equipos[0].getDadoDos().getValor(),
						"Valores de los dados", JOptionPane.INFORMATION_MESSAGE);

				System.out.println(k);
			}

			// Si ya no tiene todas las fichas en la carcel!!!
		} else {
			equipos[0].lanzarDados();
			// Si saca par
			if (equipos[0].getDadoUno().getValor() == equipos[0].getDadoDos().getValor()) {

				equipos[0].lanzarDados();
				// Que ficha se desea mover
				int x = JOptionPane.showOptionDialog(null,
						"Jugador Uno \nValor Dado uno: " + equipos[0].getDadoUno().getValor() + " - Valor Dado Dos: "
								+ equipos[0].getDadoDos().getValor() + "\nQue ficha desea mover?",
						"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas, fichas[0]);

				// Variable que suma la cantidad de ambos dados
				int ambosDados = equipos[0].getDadoUno().getValor() + equipos[0].getDadoDos().getValor();

				// Arreglo de String para opciones del usuario
				String[] valoresDados = { "Valor Uno :" + equipos[0].getDadoUno().getValor(),
						" Valor Dos:" + equipos[0].getDadoDos().getValor(), "Ambos: " + ambosDados };

				// Cantidad a mover !
				int y = JOptionPane.showOptionDialog(null,
						"Jugador Uno \nQue cantidad desea mover? \n" + "Valor Dado uno: "
								+ equipos[0].getDadoUno().getValor() + " - Valor Dado Dos:"
								+ +equipos[0].getDadoDos().getValor(),
						"Cantidad a mover", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
						valoresDados, valoresDados[0]);

				int valorCorrer = 0;

				// Que cantida desea mover?
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

				// Con que ficha?
				switch (x) {

				case 0:
					parques.moverFichaNew(equipos[0].getFichas()[0], valorCorrer);
					panelParques.actualizarFichas();

					// Con que dado se corrio antes?
					switch (y) {

					// Si se corrio con el 1 
					case 0:
						valorCorrer = equipos[0].getDadoDos().getValor();

						 f = JOptionPane.showOptionDialog(null,
								"Jugador Uno \nValor Dado uno: " + equipos[0].getDadoUno().getValor()
										+ " - Valor Dado Dos: " + equipos[0].getDadoDos().getValor()
										+ "\nQue ficha desea mover?",
								"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
								fichas[0]);

						switch (f) {

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
						break;
						
					// Si se corrio con el dos
					case 1: 
						valorCorrer = equipos[0].getDadoUno().getValor();	
					 g = JOptionPane.showOptionDialog(null,
							"Jugador Uno \nValor Dado uno: " + equipos[0].getDadoUno().getValor()
									+ " - Valor Dado Dos: " + equipos[0].getDadoDos().getValor()
									+ "\nQue ficha desea mover?",
							"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
							fichas[0]);

					switch (g) {

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
					break;
					}

					equipos[0].setTurno(false);
					equipos[1].setTurno(true);
					break;

				case 1:
					parques.moverFichaNew(equipos[0].getFichas()[1], valorCorrer);
					panelParques.actualizarFichas();

					// Con que dado se corrio antes?
					switch (y) {

					// Si se corrio con el 1 
					case 0:
						valorCorrer = equipos[0].getDadoDos().getValor();

						 f = JOptionPane.showOptionDialog(null,
								"Jugador Uno \nValor Dado uno: " + equipos[0].getDadoUno().getValor()
										+ " - Valor Dado Dos: " + equipos[0].getDadoDos().getValor()
										+ "\nQue ficha desea mover?",
								"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
								fichas[0]);

						switch (f) {

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
						break;
						
					// Si se corrio con el dos
					case 1: 
						valorCorrer = equipos[0].getDadoUno().getValor();	
					 g = JOptionPane.showOptionDialog(null,
							"Jugador Uno \nValor Dado uno: " + equipos[0].getDadoUno().getValor()
									+ " - Valor Dado Dos: " + equipos[0].getDadoDos().getValor()
									+ "\nQue ficha desea mover?",
							"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
							fichas[0]);

					switch (g) {

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
					break;
					}
					
					
					equipos[0].setTurno(false);
					equipos[1].setTurno(true);

					break;

				case 2:
					parques.moverFichaNew(equipos[0].getFichas()[2], valorCorrer);
					panelParques.actualizarFichas();

					// Con que dado se corrio antes?
					switch (y) {

					// Si se corrio con el 1 
					case 0:
						valorCorrer = equipos[0].getDadoDos().getValor();

						 f = JOptionPane.showOptionDialog(null,
								"Jugador Uno \nValor Dado uno: " + equipos[0].getDadoUno().getValor()
										+ " - Valor Dado Dos: " + equipos[0].getDadoDos().getValor()
										+ "\nQue ficha desea mover?",
								"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
								fichas[0]);

						switch (f) {

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
						break;
						
					// Si se corrio con el dos
					case 1: 
						valorCorrer = equipos[0].getDadoUno().getValor();	
					 g = JOptionPane.showOptionDialog(null,
							"Jugador Uno \nValor Dado uno: " + equipos[0].getDadoUno().getValor()
									+ " - Valor Dado Dos: " + equipos[0].getDadoDos().getValor()
									+ "\nQue ficha desea mover?",
							"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
							fichas[0]);

					switch (g) {

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
					break;
					}
					
					
					equipos[0].setTurno(false);
					equipos[1].setTurno(true);
					break;

				case 3:
					parques.moverFichaNew(equipos[0].getFichas()[3], valorCorrer);
					panelParques.actualizarFichas();

					// Con que dado se corrio antes?
					switch (y) {

					// Si se corrio con el 1 
					case 0:
						valorCorrer = equipos[0].getDadoDos().getValor();

						 f = JOptionPane.showOptionDialog(null,
								"Jugador Uno \nValor Dado uno: " + equipos[0].getDadoUno().getValor()
										+ " - Valor Dado Dos: " + equipos[0].getDadoDos().getValor()
										+ "\nQue ficha desea mover?",
								"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
								fichas[0]);

						switch (f) {

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
						break;
						
					// Si se corrio con el dos
					case 1: 
						valorCorrer = equipos[0].getDadoUno().getValor();	
					 g = JOptionPane.showOptionDialog(null,
							"Jugador Uno \nValor Dado uno: " + equipos[0].getDadoUno().getValor()
									+ " - Valor Dado Dos: " + equipos[0].getDadoDos().getValor()
									+ "\nQue ficha desea mover?",
							"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
							fichas[0]);

					switch (g) {

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
					break;
					}
					
					
					
					equipos[0].setTurno(false);
					equipos[1].setTurno(true);
					break;

				}

			} else if (equipos[0].getDadoUno().getValor() != equipos[0].getDadoDos().getValor()) {

				equipos[0].lanzarDados();
				// Que ficha se desea mover
				int x = JOptionPane.showOptionDialog(null,
						"Jugador Uno \nValor Dado uno: " + equipos[0].getDadoUno().getValor() + " - Valor Dado Dos: "
								+ equipos[0].getDadoDos().getValor() + "\nQue ficha desea mover?",
						"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas, fichas[0]);

				// Variable que suma la cantidad de ambos dados
				int ambosDados = equipos[0].getDadoUno().getValor() + equipos[0].getDadoDos().getValor();

				// Arreglo de String para opciones del usuario
				String[] valoresDados = { "Valor Uno :" + equipos[0].getDadoUno().getValor(),
						" Valor Dos:" + equipos[0].getDadoDos().getValor(), "Ambos: " + ambosDados };

				// Cantidad a mover !
				int y = JOptionPane.showOptionDialog(null,
						"Jugador Uno\nQue cantidad desea mover? \n" + "Valor Dado uno: "
								+ equipos[0].getDadoUno().getValor() + " - Valor Dado Dos:"
								+ +equipos[0].getDadoDos().getValor(),
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
	}

	public void turnoDos() {

		Equipo[] equipos = parques.getEquipos();

		String[] ops = { "LANZAR DADOS" };
		String[] salir = { "SALIR DE LA CARCEL" };
		String[] decision = { "MOVER", "SALIR DE LA CARCEL" };
		String[] fichas = { "1", "2", "3", "4" };

		if (k == 3 && equipos[1].getDadoUno().getValor() != equipos[1].getDadoDos().getValor()) {
			equipos[1].setTurno(false);
			equipos[2].setTurno(true);
			k = 0;
		} // Tiene todas las fichas en la carcel ? LAS 4 !!!
		else if (parques.verificarTresTiros() && k != 3) {

			// Lanza los dados
			JOptionPane.showOptionDialog(null, "Presiona para lanzar los dados \njugador dos", "Dados",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, ops, ops[0]);

			// Lanza los dados
			equipos[1].lanzarDados();
			k++;

			// Si es par
			if (equipos[1].getDadoUno().getValor() == equipos[1].getDadoDos().getValor()) {

				JOptionPane.showMessageDialog(null,
						"Valor Dado uno: " + equipos[1].getDadoUno().getValor() + " - Valor Dado Dos: "
								+ equipos[1].getDadoDos().getValor() + "\n " + "Bien! Has salido de la carcel",
						"Salir de la carcel", JOptionPane.INFORMATION_MESSAGE);

				parques.sacarFichasDeLaCarcel(equipos[1].getFichas());

				panelParques.actualizarFichas();

				k = 0; // Por si sale de la carcel dejar listo la variable para el otro jugador

			} else {

				JOptionPane.showMessageDialog(null,
						"Valor Dado uno: " + equipos[1].getDadoUno().getValor() + " - Valor Dado Dos: "
								+ equipos[1].getDadoDos().getValor(),
						"Valores de los dados", JOptionPane.INFORMATION_MESSAGE);

				System.out.println(k);
			}

			// Si ya no tiene todas las fichas en la carcel!!!
		} else {

			equipos[1].lanzarDados();
			// Si saca par
			if (equipos[1].getDadoUno().getValor() == equipos[1].getDadoDos().getValor()) {

					// Que ficha se desea mover
				int x = JOptionPane.showOptionDialog(null,
						"jugador dos \nValor Dado uno: " + equipos[1].getDadoUno().getValor() + " - Valor Dado Dos: "
								+ equipos[1].getDadoDos().getValor() + "\nQue ficha desea mover?",
						"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas, fichas[0]);

				// Variable que suma la cantidad de ambos dados
				int ambosDados = equipos[1].getDadoUno().getValor() + equipos[1].getDadoDos().getValor();

				// Arreglo de String para opciones del usuario
				String[] valoresDados = { "Valor Uno :" + equipos[1].getDadoUno().getValor(),
						" Valor Dos:" + equipos[1].getDadoDos().getValor(), "Ambos: " + ambosDados };

				// Cantidad a mover !
				int y = JOptionPane.showOptionDialog(null,
						"jugador dos \nQue cantidad desea mover? \n" + "Valor Dado uno: "
								+ equipos[1].getDadoUno().getValor() + " - Valor Dado Dos:"
								+ +equipos[1].getDadoDos().getValor(),
						"Cantidad a mover", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
						valoresDados, valoresDados[0]);

				int valorCorrer = 0;

				// Que cantida desea mover?
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

				// Con que ficha?
				switch (x) {

				case 0:
					parques.moverFichaNew(equipos[1].getFichas()[0], valorCorrer);
					panelParques.actualizarFichas();

					// Con que dado se corrio antes?
					switch (y) {

					// Si se corrio con el 1 
					case 0:
						valorCorrer = equipos[1].getDadoDos().getValor();

						 f = JOptionPane.showOptionDialog(null,
								"jugador dos \nValor Dado uno: " + equipos[1].getDadoUno().getValor()
										+ " - Valor Dado Dos: " + equipos[1].getDadoDos().getValor()
										+ "\nQue ficha desea mover?",
								"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
								fichas[0]);

						switch (f) {

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
						break;
						
					// Si se corrio con el dos
					case 1: 
						valorCorrer = equipos[1].getDadoUno().getValor();	
					 g = JOptionPane.showOptionDialog(null,
							"jugador dos \nValor Dado uno: " + equipos[1].getDadoUno().getValor()
									+ " - Valor Dado Dos: " + equipos[1].getDadoDos().getValor()
									+ "\nQue ficha desea mover?",
							"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
							fichas[0]);

					switch (g) {

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
					break;
					}

					equipos[1].setTurno(false);
					equipos[2].setTurno(true);
					break;

				case 1:
					parques.moverFichaNew(equipos[1].getFichas()[1], valorCorrer);
					panelParques.actualizarFichas();

					// Con que dado se corrio antes?
					switch (y) {

					// Si se corrio con el 1 
					case 0:
						valorCorrer = equipos[1].getDadoDos().getValor();

						 f = JOptionPane.showOptionDialog(null,
								"jugador dos \nValor Dado uno: " + equipos[1].getDadoUno().getValor()
										+ " - Valor Dado Dos: " + equipos[1].getDadoDos().getValor()
										+ "\nQue ficha desea mover?",
								"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
								fichas[0]);

						switch (f) {

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
						break;
						
					// Si se corrio con el dos
					case 1: 
						valorCorrer = equipos[1].getDadoUno().getValor();	
					 g = JOptionPane.showOptionDialog(null,
							"jugador dos \nValor Dado uno: " + equipos[1].getDadoUno().getValor()
									+ " - Valor Dado Dos: " + equipos[1].getDadoDos().getValor()
									+ "\nQue ficha desea mover?",
							"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
							fichas[0]);

					switch (g) {

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
					break;
					}
					
					
					equipos[1].setTurno(false);
					equipos[2].setTurno(true);

					break;

				case 2:
					parques.moverFichaNew(equipos[1].getFichas()[2], valorCorrer);
					panelParques.actualizarFichas();

					// Con que dado se corrio antes?
					switch (y) {

					// Si se corrio con el 1 
					case 0:
						valorCorrer = equipos[1].getDadoDos().getValor();

						 f = JOptionPane.showOptionDialog(null,
								"jugador dos \nValor Dado uno: " + equipos[1].getDadoUno().getValor()
										+ " - Valor Dado Dos: " + equipos[1].getDadoDos().getValor()
										+ "\nQue ficha desea mover?",
								"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
								fichas[0]);

						switch (f) {

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
						break;
						
					// Si se corrio con el dos
					case 1: 
						valorCorrer = equipos[1].getDadoUno().getValor();	
					 g = JOptionPane.showOptionDialog(null,
							"jugador dos \nValor Dado uno: " + equipos[1].getDadoUno().getValor()
									+ " - Valor Dado Dos: " + equipos[1].getDadoDos().getValor()
									+ "\nQue ficha desea mover?",
							"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
							fichas[0]);

					switch (g) {

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
					break;
					}
					
					
					equipos[1].setTurno(false);
					equipos[2].setTurno(true);
					break;

				case 3:
					parques.moverFichaNew(equipos[1].getFichas()[3], valorCorrer);
					panelParques.actualizarFichas();

					// Con que dado se corrio antes?
					switch (y) {

					// Si se corrio con el 1 
					case 0:
						valorCorrer = equipos[1].getDadoDos().getValor();

						 f = JOptionPane.showOptionDialog(null,
								"jugador dos \nValor Dado uno: " + equipos[1].getDadoUno().getValor()
										+ " - Valor Dado Dos: " + equipos[1].getDadoDos().getValor()
										+ "\nQue ficha desea mover?",
								"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
								fichas[0]);

						switch (f) {

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
						break;
						
					// Si se corrio con el dos
					case 1: 
						valorCorrer = equipos[1].getDadoUno().getValor();	
					 g = JOptionPane.showOptionDialog(null,
							"jugador dos \nValor Dado uno: " + equipos[1].getDadoUno().getValor()
									+ " - Valor Dado Dos: " + equipos[1].getDadoDos().getValor()
									+ "\nQue ficha desea mover?",
							"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
							fichas[0]);

					switch (g) {

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
					break;
					}
					
					
					
					equipos[1].setTurno(false);
					equipos[2].setTurno(true);
					break;

				}

			} else if (equipos[1].getDadoUno().getValor() != equipos[1].getDadoDos().getValor()) {

				equipos[1].lanzarDados();
				// Que ficha se desea mover
				int x = JOptionPane.showOptionDialog(null,
						"jugador dos \nValor Dado uno: " + equipos[1].getDadoUno().getValor() + " - Valor Dado Dos: "
								+ equipos[1].getDadoDos().getValor() + "\nQue ficha desea mover?",
						"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas, fichas[0]);

				// Variable que suma la cantidad de ambos dados
				int ambosDados = equipos[1].getDadoUno().getValor() + equipos[1].getDadoDos().getValor();

				// Arreglo de String para opciones del usuario
				String[] valoresDados = { "Valor Uno :" + equipos[1].getDadoUno().getValor(),
						" Valor Dos:" + equipos[1].getDadoDos().getValor(), "Ambos: " + ambosDados };

				// Cantidad a mover !
				int y = JOptionPane.showOptionDialog(null,
						"jugador dos\nQue cantidad desea mover? \n" + "Valor Dado uno: "
								+ equipos[1].getDadoUno().getValor() + " - Valor Dado Dos:"
								+ +equipos[1].getDadoDos().getValor(),
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

	public void turnoTres() {

		Equipo[] equipos = parques.getEquipos();

		String[] ops = { "LANZAR DADOS" };
		String[] salir = { "SALIR DE LA CARCEL" };
		String[] decision = { "MOVER", "SALIR DE LA CARCEL" };
		String[] fichas = { "1", "2", "3", "4" };

		if (k == 3 && equipos[2].getDadoUno().getValor() != equipos[2].getDadoDos().getValor()) {
			equipos[2].setTurno(false);
			equipos[3].setTurno(true);
			k = 0;
		} // Tiene todas las fichas en la carcel ? LAS 4 !!!
		else if (parques.verificarTresTiros() && k != 3) {

			// Lanza los dados
			JOptionPane.showOptionDialog(null, "Presiona para lanzar los dados \njugador tres", "Dados",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, ops, ops[0]);

			// Lanza los dados
			equipos[2].lanzarDados();
			k++;

			// Si es par
			if (equipos[2].getDadoUno().getValor() == equipos[2].getDadoDos().getValor()) {

				JOptionPane.showMessageDialog(null,
						"Valor Dado uno: " + equipos[2].getDadoUno().getValor() + " - Valor Dado Dos: "
								+ equipos[2].getDadoDos().getValor() + "\n " + "Bien! Has salido de la carcel",
						"Salir de la carcel", JOptionPane.INFORMATION_MESSAGE);

				parques.sacarFichasDeLaCarcel(equipos[2].getFichas());

				panelParques.actualizarFichas();

				k = 0; // Por si sale de la carcel dejar listo la variable para el otro jugador

			} else {

				JOptionPane.showMessageDialog(null,
						"Valor Dado uno: " + equipos[2].getDadoUno().getValor() + " - Valor Dado Dos: "
								+ equipos[2].getDadoDos().getValor(),
						"Valores de los dados", JOptionPane.INFORMATION_MESSAGE);

				System.out.println(k);
			}

			// Si ya no tiene todas las fichas en la carcel!!!
		} else {
			equipos[2].lanzarDados();

			// Si saca par
			if (equipos[2].getDadoUno().getValor() == equipos[2].getDadoDos().getValor()) {

			
			// Que ficha se desea mover
				int x = JOptionPane.showOptionDialog(null,
						"jugador tres \nValor Dado uno: " + equipos[2].getDadoUno().getValor() + " - Valor Dado Dos: "
								+ equipos[2].getDadoDos().getValor() + "\nQue ficha desea mover?",
						"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas, fichas[0]);

				// Variable que suma la cantidad de ambos dados
				int ambosDados = equipos[2].getDadoUno().getValor() + equipos[2].getDadoDos().getValor();

				// Arreglo de String para opciones del usuario
				String[] valoresDados = { "Valor Uno :" + equipos[2].getDadoUno().getValor(),
						" Valor Dos:" + equipos[2].getDadoDos().getValor(), "Ambos: " + ambosDados };

				// Cantidad a mover !
				int y = JOptionPane.showOptionDialog(null,
						"jugador tres \nQue cantidad desea mover? \n" + "Valor Dado uno: "
								+ equipos[2].getDadoUno().getValor() + " - Valor Dado Dos:"
								+ +equipos[2].getDadoDos().getValor(),
						"Cantidad a mover", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
						valoresDados, valoresDados[0]);

				int valorCorrer = 0;

				// Que cantida desea mover?
				switch (y) {

				case 0:
					valorCorrer = equipos[2].getDadoUno().getValor();

					break;

				case 1:
					valorCorrer = equipos[2].getDadoDos().getValor();

					break;

				case 2:
					valorCorrer = ambosDados;

				}

				// Con que ficha?
				switch (x) {

				case 0:
					parques.moverFichaNew(equipos[2].getFichas()[0], valorCorrer);
					panelParques.actualizarFichas();

					// Con que dado se corrio antes?
					switch (y) {

					// Si se corrio con el 1 
					case 0:
						valorCorrer = equipos[2].getDadoDos().getValor();

						 f = JOptionPane.showOptionDialog(null,
								"jugador tres \nValor Dado uno: " + equipos[2].getDadoUno().getValor()
										+ " - Valor Dado Dos: " + equipos[2].getDadoDos().getValor()
										+ "\nQue ficha desea mover?",
								"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
								fichas[0]);

						switch (f) {

						case 0:
							parques.moverFichaNew(equipos[2].getFichas()[0], valorCorrer);
							panelParques.actualizarFichas();
							equipos[2].setTurno(false);
							equipos[3].setTurno(true);
							break;

						case 1:
							parques.moverFichaNew(equipos[2].getFichas()[1], valorCorrer);
							panelParques.actualizarFichas();
							equipos[2].setTurno(false);
							equipos[3].setTurno(true);
							break;

						case 2:
							parques.moverFichaNew(equipos[2].getFichas()[2], valorCorrer);
							panelParques.actualizarFichas();
							equipos[2].setTurno(false);
							equipos[3].setTurno(true);
							break;

						case 3:
							parques.moverFichaNew(equipos[2].getFichas()[3], valorCorrer);
							panelParques.actualizarFichas();
							equipos[2].setTurno(false);
							equipos[3].setTurno(true);
							break;

						}
						break;
						
					// Si se corrio con el dos
					case 1: 
						valorCorrer = equipos[2].getDadoUno().getValor();	
					 g = JOptionPane.showOptionDialog(null,
							"jugador tres \nValor Dado uno: " + equipos[2].getDadoUno().getValor()
									+ " - Valor Dado Dos: " + equipos[2].getDadoDos().getValor()
									+ "\nQue ficha desea mover?",
							"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
							fichas[0]);

					switch (g) {

					case 0:
						parques.moverFichaNew(equipos[2].getFichas()[0], valorCorrer);
						panelParques.actualizarFichas();
						equipos[2].setTurno(false);
						equipos[3].setTurno(true);
						break;

					case 1:
						parques.moverFichaNew(equipos[2].getFichas()[1], valorCorrer);
						panelParques.actualizarFichas();
						equipos[2].setTurno(false);
						equipos[3].setTurno(true);
						break;

					case 2:
						parques.moverFichaNew(equipos[2].getFichas()[2], valorCorrer);
						panelParques.actualizarFichas();
						equipos[2].setTurno(false);
						equipos[3].setTurno(true);
						break;

					case 3:
						parques.moverFichaNew(equipos[2].getFichas()[3], valorCorrer);
						panelParques.actualizarFichas();
						equipos[2].setTurno(false);
						equipos[3].setTurno(true);
						break;

					}
					break;
					}

					equipos[2].setTurno(false);
					equipos[3].setTurno(true);
					break;

				case 1:
					parques.moverFichaNew(equipos[2].getFichas()[1], valorCorrer);
					panelParques.actualizarFichas();

					// Con que dado se corrio antes?
					switch (y) {

					// Si se corrio con el 1 
					case 0:
						valorCorrer = equipos[2].getDadoDos().getValor();

						 f = JOptionPane.showOptionDialog(null,
								"jugador tres \nValor Dado uno: " + equipos[2].getDadoUno().getValor()
										+ " - Valor Dado Dos: " + equipos[2].getDadoDos().getValor()
										+ "\nQue ficha desea mover?",
								"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
								fichas[0]);

						switch (f) {

						case 0:
							parques.moverFichaNew(equipos[2].getFichas()[0], valorCorrer);
							panelParques.actualizarFichas();
							equipos[2].setTurno(false);
							equipos[3].setTurno(true);
							break;

						case 1:
							parques.moverFichaNew(equipos[2].getFichas()[1], valorCorrer);
							panelParques.actualizarFichas();
							equipos[2].setTurno(false);
							equipos[3].setTurno(true);
							break;

						case 2:
							parques.moverFichaNew(equipos[2].getFichas()[2], valorCorrer);
							panelParques.actualizarFichas();
							equipos[2].setTurno(false);
							equipos[3].setTurno(true);
							break;

						case 3:
							parques.moverFichaNew(equipos[2].getFichas()[3], valorCorrer);
							panelParques.actualizarFichas();
							equipos[2].setTurno(false);
							equipos[3].setTurno(true);
							break;

						}
						break;
						
					// Si se corrio con el dos
					case 1: 
						valorCorrer = equipos[2].getDadoUno().getValor();	
					 g = JOptionPane.showOptionDialog(null,
							"jugador tres \nValor Dado uno: " + equipos[2].getDadoUno().getValor()
									+ " - Valor Dado Dos: " + equipos[2].getDadoDos().getValor()
									+ "\nQue ficha desea mover?",
							"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
							fichas[0]);

					switch (g) {

					case 0:
						parques.moverFichaNew(equipos[2].getFichas()[0], valorCorrer);
						panelParques.actualizarFichas();
						equipos[2].setTurno(false);
						equipos[3].setTurno(true);
						break;

					case 1:
						parques.moverFichaNew(equipos[2].getFichas()[1], valorCorrer);
						panelParques.actualizarFichas();
						equipos[2].setTurno(false);
						equipos[3].setTurno(true);
						break;

					case 2:
						parques.moverFichaNew(equipos[2].getFichas()[2], valorCorrer);
						panelParques.actualizarFichas();
						equipos[2].setTurno(false);
						equipos[3].setTurno(true);
						break;

					case 3:
						parques.moverFichaNew(equipos[2].getFichas()[3], valorCorrer);
						panelParques.actualizarFichas();
						equipos[2].setTurno(false);
						equipos[3].setTurno(true);
						break;

					}
					break;
					}
					
					
					equipos[2].setTurno(false);
					equipos[3].setTurno(true);

					break;

				case 2:
					parques.moverFichaNew(equipos[2].getFichas()[2], valorCorrer);
					panelParques.actualizarFichas();

					// Con que dado se corrio antes?
					switch (y) {

					// Si se corrio con el 1 
					case 0:
						valorCorrer = equipos[2].getDadoDos().getValor();

						 f = JOptionPane.showOptionDialog(null,
								"jugador tres \nValor Dado uno: " + equipos[2].getDadoUno().getValor()
										+ " - Valor Dado Dos: " + equipos[2].getDadoDos().getValor()
										+ "\nQue ficha desea mover?",
								"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
								fichas[0]);

						switch (f) {

						case 0:
							parques.moverFichaNew(equipos[2].getFichas()[0], valorCorrer);
							panelParques.actualizarFichas();
							equipos[2].setTurno(false);
							equipos[3].setTurno(true);
							break;

						case 1:
							parques.moverFichaNew(equipos[2].getFichas()[1], valorCorrer);
							panelParques.actualizarFichas();
							equipos[2].setTurno(false);
							equipos[3].setTurno(true);
							break;

						case 2:
							parques.moverFichaNew(equipos[2].getFichas()[2], valorCorrer);
							panelParques.actualizarFichas();
							equipos[2].setTurno(false);
							equipos[3].setTurno(true);
							break;

						case 3:
							parques.moverFichaNew(equipos[2].getFichas()[3], valorCorrer);
							panelParques.actualizarFichas();
							equipos[2].setTurno(false);
							equipos[3].setTurno(true);
							break;

						}
						break;
						
					// Si se corrio con el dos
					case 1: 
						valorCorrer = equipos[2].getDadoUno().getValor();	
					 g = JOptionPane.showOptionDialog(null,
							"jugador tres \nValor Dado uno: " + equipos[2].getDadoUno().getValor()
									+ " - Valor Dado Dos: " + equipos[2].getDadoDos().getValor()
									+ "\nQue ficha desea mover?",
							"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
							fichas[0]);

					switch (g) {

					case 0:
						parques.moverFichaNew(equipos[2].getFichas()[0], valorCorrer);
						panelParques.actualizarFichas();
						equipos[2].setTurno(false);
						equipos[3].setTurno(true);
						break;

					case 1:
						parques.moverFichaNew(equipos[2].getFichas()[1], valorCorrer);
						panelParques.actualizarFichas();
						equipos[2].setTurno(false);
						equipos[3].setTurno(true);
						break;

					case 2:
						parques.moverFichaNew(equipos[2].getFichas()[2], valorCorrer);
						panelParques.actualizarFichas();
						equipos[2].setTurno(false);
						equipos[3].setTurno(true);
						break;

					case 3:
						parques.moverFichaNew(equipos[2].getFichas()[3], valorCorrer);
						panelParques.actualizarFichas();
						equipos[2].setTurno(false);
						equipos[3].setTurno(true);
						break;

					}
					break;
					}
					
					
					equipos[2].setTurno(false);
					equipos[3].setTurno(true);
					break;

				case 3:
					parques.moverFichaNew(equipos[2].getFichas()[3], valorCorrer);
					panelParques.actualizarFichas();

					// Con que dado se corrio antes?
					switch (y) {

					// Si se corrio con el 1 
					case 0:
						valorCorrer = equipos[2].getDadoDos().getValor();

						 f = JOptionPane.showOptionDialog(null,
								"jugador tres \nValor Dado uno: " + equipos[2].getDadoUno().getValor()
										+ " - Valor Dado Dos: " + equipos[2].getDadoDos().getValor()
										+ "\nQue ficha desea mover?",
								"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
								fichas[0]);

						switch (f) {

						case 0:
							parques.moverFichaNew(equipos[2].getFichas()[0], valorCorrer);
							panelParques.actualizarFichas();
							equipos[2].setTurno(false);
							equipos[3].setTurno(true);
							break;

						case 1:
							parques.moverFichaNew(equipos[2].getFichas()[1], valorCorrer);
							panelParques.actualizarFichas();
							equipos[2].setTurno(false);
							equipos[3].setTurno(true);
							break;

						case 2:
							parques.moverFichaNew(equipos[2].getFichas()[2], valorCorrer);
							panelParques.actualizarFichas();
							equipos[2].setTurno(false);
							equipos[3].setTurno(true);
							break;

						case 3:
							parques.moverFichaNew(equipos[2].getFichas()[3], valorCorrer);
							panelParques.actualizarFichas();
							equipos[2].setTurno(false);
							equipos[3].setTurno(true);
							break;

						}
						break;
						
					// Si se corrio con el dos
					case 1: 
						valorCorrer = equipos[2].getDadoUno().getValor();	
					 g = JOptionPane.showOptionDialog(null,
							"jugador tres \nValor Dado uno: " + equipos[2].getDadoUno().getValor()
									+ " - Valor Dado Dos: " + equipos[2].getDadoDos().getValor()
									+ "\nQue ficha desea mover?",
							"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
							fichas[0]);

					switch (g) {

					case 0:
						parques.moverFichaNew(equipos[2].getFichas()[0], valorCorrer);
						panelParques.actualizarFichas();
						equipos[2].setTurno(false);
						equipos[3].setTurno(true);
						break;

					case 1:
						parques.moverFichaNew(equipos[2].getFichas()[1], valorCorrer);
						panelParques.actualizarFichas();
						equipos[2].setTurno(false);
						equipos[3].setTurno(true);
						break;

					case 2:
						parques.moverFichaNew(equipos[2].getFichas()[2], valorCorrer);
						panelParques.actualizarFichas();
						equipos[2].setTurno(false);
						equipos[3].setTurno(true);
						break;

					case 3:
						parques.moverFichaNew(equipos[2].getFichas()[3], valorCorrer);
						panelParques.actualizarFichas();
						equipos[2].setTurno(false);
						equipos[3].setTurno(true);
						break;

					}
					break;
					}
					
					
					
					equipos[2].setTurno(false);
					equipos[3].setTurno(true);
					break;

				}

			} else if (equipos[2].getDadoUno().getValor() != equipos[2].getDadoDos().getValor()) {
					// Que ficha se desea mover
				int x = JOptionPane.showOptionDialog(null,
						"jugador tres \nValor Dado uno: " + equipos[2].getDadoUno().getValor() + " - Valor Dado Dos: "
								+ equipos[2].getDadoDos().getValor() + "\nQue ficha desea mover?",
						"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas, fichas[0]);

				// Variable que suma la cantidad de ambos dados
				int ambosDados = equipos[2].getDadoUno().getValor() + equipos[2].getDadoDos().getValor();

				// Arreglo de String para opciones del usuario
				String[] valoresDados = { "Valor Uno :" + equipos[2].getDadoUno().getValor(),
						" Valor Dos:" + equipos[2].getDadoDos().getValor(), "Ambos: " + ambosDados };

				// Cantidad a mover !
				int y = JOptionPane.showOptionDialog(null,
						"jugador tres\nQue cantidad desea mover? \n" + "Valor Dado uno: "
								+ equipos[2].getDadoUno().getValor() + " - Valor Dado Dos:"
								+ +equipos[2].getDadoDos().getValor(),
						"Cantidad a mover", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
						valoresDados, valoresDados[0]);

				int valorCorrer = 0;

				switch (y) {

				case 0:
					valorCorrer = equipos[2].getDadoUno().getValor();

					break;

				case 1:
					valorCorrer = equipos[2].getDadoDos().getValor();

					break;

				case 2:
					valorCorrer = ambosDados;

				}

				switch (x) {

				case 0:
					parques.moverFichaNew(equipos[2].getFichas()[0], valorCorrer);
					panelParques.actualizarFichas();
					equipos[2].setTurno(false);
					equipos[3].setTurno(true);
					break;

				case 1:
					parques.moverFichaNew(equipos[2].getFichas()[1], valorCorrer);
					panelParques.actualizarFichas();
					equipos[2].setTurno(false);
					equipos[3].setTurno(true);
					break;

				case 2:
					parques.moverFichaNew(equipos[2].getFichas()[2], valorCorrer);
					panelParques.actualizarFichas();
					equipos[2].setTurno(false);
					equipos[3].setTurno(true);
					break;

				case 3:
					parques.moverFichaNew(equipos[2].getFichas()[3], valorCorrer);
					panelParques.actualizarFichas();
					equipos[2].setTurno(false);
					equipos[3].setTurno(true);
					break;

				}

			}

		}

	}

	public void turnoCuatro() {

		Equipo[] equipos = parques.getEquipos();

		String[] ops = { "LANZAR DADOS" };
		String[] salir = { "SALIR DE LA CARCEL" };
		String[] decision = { "MOVER", "SALIR DE LA CARCEL" };
		String[] fichas = { "1", "2", "3", "4" };

		if (k == 3 && equipos[3].getDadoUno().getValor() != equipos[3].getDadoDos().getValor()) {
			equipos[3].setTurno(false);
			equipos[0].setTurno(true);
			k = 0;
		} // Tiene todas las fichas en la carcel ? LAS 4 !!!
		else if (parques.verificarTresTiros() && k != 3) {

			// Lanza los dados
			JOptionPane.showOptionDialog(null, "Presiona para lanzar los dados \njugador cuatro", "Dados",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, ops, ops[0]);

			// Lanza los dados
			equipos[3].lanzarDados();
			k++;

			// Si es par
			if (equipos[3].getDadoUno().getValor() == equipos[3].getDadoDos().getValor()) {

				JOptionPane.showMessageDialog(null,
						"Valor Dado uno: " + equipos[3].getDadoUno().getValor() + " - Valor Dado Dos: "
								+ equipos[3].getDadoDos().getValor() + "\n " + "Bien! Has salido de la carcel",
						"Salir de la carcel", JOptionPane.INFORMATION_MESSAGE);

				parques.sacarFichasDeLaCarcel(equipos[3].getFichas());

				panelParques.actualizarFichas();

				k = 0; // Por si sale de la carcel dejar listo la variable para el otro jugador

			} else {

				JOptionPane.showMessageDialog(null,
						"Valor Dado uno: " + equipos[3].getDadoUno().getValor() + " - Valor Dado Dos: "
								+ equipos[3].getDadoDos().getValor(),
						"Valores de los dados", JOptionPane.INFORMATION_MESSAGE);

				System.out.println(k);
			}

			// Si ya no tiene todas las fichas en la carcel!!!
		} else {

			equipos[3].lanzarDados();
			// Si saca par
			if (equipos[3].getDadoUno().getValor() == equipos[3].getDadoDos().getValor()) {

				

				// Que ficha se desea mover
				int x = JOptionPane.showOptionDialog(null,
						"jugador cuatro \nValor Dado uno: " + equipos[3].getDadoUno().getValor() + " - Valor Dado Dos: "
								+ equipos[3].getDadoDos().getValor() + "\nQue ficha desea mover?",
						"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas, fichas[0]);

				// Variable que suma la cantidad de ambos dados
				int ambosDados = equipos[3].getDadoUno().getValor() + equipos[3].getDadoDos().getValor();

				// Arreglo de String para opciones del usuario
				String[] valoresDados = { "Valor Uno :" + equipos[3].getDadoUno().getValor(),
						" Valor Dos:" + equipos[3].getDadoDos().getValor(), "Ambos: " + ambosDados };

				// Cantidad a mover !
				int y = JOptionPane.showOptionDialog(null,
						"jugador cuatro \nQue cantidad desea mover? \n" + "Valor Dado uno: "
								+ equipos[3].getDadoUno().getValor() + " - Valor Dado Dos:"
								+ +equipos[3].getDadoDos().getValor(),
						"Cantidad a mover", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
						valoresDados, valoresDados[0]);

				int valorCorrer = 0;

				// Que cantida desea mover?
				switch (y) {

				case 0:
					valorCorrer = equipos[3].getDadoUno().getValor();

					break;

				case 1:
					valorCorrer = equipos[3].getDadoDos().getValor();

					break;

				case 2:
					valorCorrer = ambosDados;

				}

				// Con que ficha?
				switch (x) {

				case 0:
					parques.moverFichaNew(equipos[3].getFichas()[0], valorCorrer);
					panelParques.actualizarFichas();

					// Con que dado se corrio antes?
					switch (y) {

					// Si se corrio con el 1 
					case 0:
						valorCorrer = equipos[3].getDadoDos().getValor();

						 f = JOptionPane.showOptionDialog(null,
								"jugador cuatro \nValor Dado uno: " + equipos[3].getDadoUno().getValor()
										+ " - Valor Dado Dos: " + equipos[3].getDadoDos().getValor()
										+ "\nQue ficha desea mover?",
								"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
								fichas[0]);

						switch (f) {

						case 0:
							parques.moverFichaNew(equipos[3].getFichas()[0], valorCorrer);
							panelParques.actualizarFichas();
							equipos[3].setTurno(false);
							equipos[0].setTurno(true);
							break;

						case 1:
							parques.moverFichaNew(equipos[3].getFichas()[1], valorCorrer);
							panelParques.actualizarFichas();
							equipos[3].setTurno(false);
							equipos[0].setTurno(true);
							break;

						case 2:
							parques.moverFichaNew(equipos[3].getFichas()[2], valorCorrer);
							panelParques.actualizarFichas();
							equipos[3].setTurno(false);
							equipos[0].setTurno(true);
							break;

						case 3:
							parques.moverFichaNew(equipos[3].getFichas()[3], valorCorrer);
							panelParques.actualizarFichas();
							equipos[3].setTurno(false);
							equipos[0].setTurno(true);
							break;

						}
						break;
						
					// Si se corrio con el dos
					case 1: 
						valorCorrer = equipos[3].getDadoUno().getValor();	
					 g = JOptionPane.showOptionDialog(null,
							"jugador cuatro \nValor Dado uno: " + equipos[3].getDadoUno().getValor()
									+ " - Valor Dado Dos: " + equipos[3].getDadoDos().getValor()
									+ "\nQue ficha desea mover?",
							"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
							fichas[0]);

					switch (g) {

					case 0:
						parques.moverFichaNew(equipos[3].getFichas()[0], valorCorrer);
						panelParques.actualizarFichas();
						equipos[3].setTurno(false);
						equipos[0].setTurno(true);
						break;

					case 1:
						parques.moverFichaNew(equipos[3].getFichas()[1], valorCorrer);
						panelParques.actualizarFichas();
						equipos[3].setTurno(false);
						equipos[0].setTurno(true);
						break;

					case 2:
						parques.moverFichaNew(equipos[3].getFichas()[2], valorCorrer);
						panelParques.actualizarFichas();
						equipos[3].setTurno(false);
						equipos[0].setTurno(true);
						break;

					case 3:
						parques.moverFichaNew(equipos[3].getFichas()[3], valorCorrer);
						panelParques.actualizarFichas();
						equipos[3].setTurno(false);
						equipos[0].setTurno(true);
						break;

					}
					break;
					}

					equipos[3].setTurno(false);
					equipos[0].setTurno(true);
					break;

				case 1:
					parques.moverFichaNew(equipos[3].getFichas()[1], valorCorrer);
					panelParques.actualizarFichas();

					// Con que dado se corrio antes?
					switch (y) {

					// Si se corrio con el 1 
					case 0:
						valorCorrer = equipos[3].getDadoDos().getValor();

						 f = JOptionPane.showOptionDialog(null,
								"jugador cuatro \nValor Dado uno: " + equipos[3].getDadoUno().getValor()
										+ " - Valor Dado Dos: " + equipos[3].getDadoDos().getValor()
										+ "\nQue ficha desea mover?",
								"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
								fichas[0]);

						switch (f) {

						case 0:
							parques.moverFichaNew(equipos[3].getFichas()[0], valorCorrer);
							panelParques.actualizarFichas();
							equipos[3].setTurno(false);
							equipos[0].setTurno(true);
							break;

						case 1:
							parques.moverFichaNew(equipos[3].getFichas()[1], valorCorrer);
							panelParques.actualizarFichas();
							equipos[3].setTurno(false);
							equipos[0].setTurno(true);
							break;

						case 2:
							parques.moverFichaNew(equipos[3].getFichas()[2], valorCorrer);
							panelParques.actualizarFichas();
							equipos[3].setTurno(false);
							equipos[0].setTurno(true);
							break;

						case 3:
							parques.moverFichaNew(equipos[3].getFichas()[3], valorCorrer);
							panelParques.actualizarFichas();
							equipos[3].setTurno(false);
							equipos[0].setTurno(true);
							break;

						}
						break;
						
					// Si se corrio con el dos
					case 1: 
						valorCorrer = equipos[3].getDadoUno().getValor();	
					 g = JOptionPane.showOptionDialog(null,
							"jugador cuatro \nValor Dado uno: " + equipos[3].getDadoUno().getValor()
									+ " - Valor Dado Dos: " + equipos[3].getDadoDos().getValor()
									+ "\nQue ficha desea mover?",
							"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
							fichas[0]);

					switch (g) {

					case 0:
						parques.moverFichaNew(equipos[3].getFichas()[0], valorCorrer);
						panelParques.actualizarFichas();
						equipos[3].setTurno(false);
						equipos[0].setTurno(true);
						break;

					case 1:
						parques.moverFichaNew(equipos[3].getFichas()[1], valorCorrer);
						panelParques.actualizarFichas();
						equipos[3].setTurno(false);
						equipos[0].setTurno(true);
						break;

					case 2:
						parques.moverFichaNew(equipos[3].getFichas()[2], valorCorrer);
						panelParques.actualizarFichas();
						equipos[3].setTurno(false);
						equipos[0].setTurno(true);
						break;

					case 3:
						parques.moverFichaNew(equipos[3].getFichas()[3], valorCorrer);
						panelParques.actualizarFichas();
						equipos[3].setTurno(false);
						equipos[0].setTurno(true);
						break;

					}
					break;
					}
					
					
					equipos[3].setTurno(false);
					equipos[0].setTurno(true);

					break;

				case 2:
					parques.moverFichaNew(equipos[3].getFichas()[2], valorCorrer);
					panelParques.actualizarFichas();

					// Con que dado se corrio antes?
					switch (y) {

					// Si se corrio con el 1 
					case 0:
						valorCorrer = equipos[3].getDadoDos().getValor();

						 f = JOptionPane.showOptionDialog(null,
								"jugador cuatro \nValor Dado uno: " + equipos[3].getDadoUno().getValor()
										+ " - Valor Dado Dos: " + equipos[3].getDadoDos().getValor()
										+ "\nQue ficha desea mover?",
								"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
								fichas[0]);

						switch (f) {

						case 0:
							parques.moverFichaNew(equipos[3].getFichas()[0], valorCorrer);
							panelParques.actualizarFichas();
							equipos[3].setTurno(false);
							equipos[0].setTurno(true);
							break;

						case 1:
							parques.moverFichaNew(equipos[3].getFichas()[1], valorCorrer);
							panelParques.actualizarFichas();
							equipos[3].setTurno(false);
							equipos[0].setTurno(true);
							break;

						case 2:
							parques.moverFichaNew(equipos[3].getFichas()[2], valorCorrer);
							panelParques.actualizarFichas();
							equipos[3].setTurno(false);
							equipos[0].setTurno(true);
							break;

						case 3:
							parques.moverFichaNew(equipos[3].getFichas()[3], valorCorrer);
							panelParques.actualizarFichas();
							equipos[3].setTurno(false);
							equipos[0].setTurno(true);
							break;

						}
						break;
						
					// Si se corrio con el dos
					case 1: 
						valorCorrer = equipos[3].getDadoUno().getValor();	
					 g = JOptionPane.showOptionDialog(null,
							"jugador cuatro \nValor Dado uno: " + equipos[3].getDadoUno().getValor()
									+ " - Valor Dado Dos: " + equipos[3].getDadoDos().getValor()
									+ "\nQue ficha desea mover?",
							"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
							fichas[0]);

					switch (g) {

					case 0:
						parques.moverFichaNew(equipos[3].getFichas()[0], valorCorrer);
						panelParques.actualizarFichas();
						equipos[3].setTurno(false);
						equipos[0].setTurno(true);
						break;

					case 1:
						parques.moverFichaNew(equipos[3].getFichas()[1], valorCorrer);
						panelParques.actualizarFichas();
						equipos[3].setTurno(false);
						equipos[0].setTurno(true);
						break;

					case 2:
						parques.moverFichaNew(equipos[3].getFichas()[2], valorCorrer);
						panelParques.actualizarFichas();
						equipos[3].setTurno(false);
						equipos[0].setTurno(true);
						break;

					case 3:
						parques.moverFichaNew(equipos[3].getFichas()[3], valorCorrer);
						panelParques.actualizarFichas();
						equipos[3].setTurno(false);
						equipos[0].setTurno(true);
						break;

					}
					break;
					}
					
					
					equipos[3].setTurno(false);
					equipos[0].setTurno(true);
					break;

				case 3:
					parques.moverFichaNew(equipos[3].getFichas()[3], valorCorrer);
					panelParques.actualizarFichas();

					// Con que dado se corrio antes?
					switch (y) {

					// Si se corrio con el 1 
					case 0:
						valorCorrer = equipos[3].getDadoDos().getValor();

						 f = JOptionPane.showOptionDialog(null,
								"jugador cuatro \nValor Dado uno: " + equipos[3].getDadoUno().getValor()
										+ " - Valor Dado Dos: " + equipos[3].getDadoDos().getValor()
										+ "\nQue ficha desea mover?",
								"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
								fichas[0]);

						switch (f) {

						case 0:
							parques.moverFichaNew(equipos[3].getFichas()[0], valorCorrer);
							panelParques.actualizarFichas();
							equipos[3].setTurno(false);
							equipos[0].setTurno(true);
							break;

						case 1:
							parques.moverFichaNew(equipos[3].getFichas()[1], valorCorrer);
							panelParques.actualizarFichas();
							equipos[3].setTurno(false);
							equipos[0].setTurno(true);
							break;

						case 2:
							parques.moverFichaNew(equipos[3].getFichas()[2], valorCorrer);
							panelParques.actualizarFichas();
							equipos[3].setTurno(false);
							equipos[0].setTurno(true);
							break;

						case 3:
							parques.moverFichaNew(equipos[3].getFichas()[3], valorCorrer);
							panelParques.actualizarFichas();
							equipos[3].setTurno(false);
							equipos[0].setTurno(true);
							break;

						}
						break;
						
					// Si se corrio con el dos
					case 1: 
						valorCorrer = equipos[3].getDadoUno().getValor();	
					 g = JOptionPane.showOptionDialog(null,
							"jugador cuatro \nValor Dado uno: " + equipos[3].getDadoUno().getValor()
									+ " - Valor Dado Dos: " + equipos[3].getDadoDos().getValor()
									+ "\nQue ficha desea mover?",
							"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas,
							fichas[0]);

					switch (g) {

					case 0:
						parques.moverFichaNew(equipos[3].getFichas()[0], valorCorrer);
						panelParques.actualizarFichas();
						equipos[3].setTurno(false);
						equipos[0].setTurno(true);
						break;

					case 1:
						parques.moverFichaNew(equipos[3].getFichas()[1], valorCorrer);
						panelParques.actualizarFichas();
						equipos[3].setTurno(false);
						equipos[0].setTurno(true);
						break;

					case 2:
						parques.moverFichaNew(equipos[3].getFichas()[2], valorCorrer);
						panelParques.actualizarFichas();
						equipos[3].setTurno(false);
						equipos[0].setTurno(true);
						break;

					case 3:
						parques.moverFichaNew(equipos[3].getFichas()[3], valorCorrer);
						panelParques.actualizarFichas();
						equipos[3].setTurno(false);
						equipos[0].setTurno(true);
						break;

					}
					break;
					}
					
					
					
					equipos[3].setTurno(false);
					equipos[0].setTurno(true);
					break;

				}

			} else if (equipos[3].getDadoUno().getValor() != equipos[3].getDadoDos().getValor()) {

				
				// Que ficha se desea mover
				int x = JOptionPane.showOptionDialog(null,
						"jugador cuatro \nValor Dado uno: " + equipos[3].getDadoUno().getValor() + " - Valor Dado Dos: "
								+ equipos[3].getDadoDos().getValor() + "\nQue ficha desea mover?",
						"Dados", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, fichas, fichas[0]);

				// Variable que suma la cantidad de ambos dados
				int ambosDados = equipos[3].getDadoUno().getValor() + equipos[3].getDadoDos().getValor();

				// Arreglo de String para opciones del usuario
				String[] valoresDados = { "Valor Uno :" + equipos[3].getDadoUno().getValor(),
						" Valor Dos:" + equipos[3].getDadoDos().getValor(), "Ambos: " + ambosDados };

				// Cantidad a mover !
				int y = JOptionPane.showOptionDialog(null,
						"jugador cuatro\nQue cantidad desea mover? \n" + "Valor Dado uno: "
								+ equipos[3].getDadoUno().getValor() + " - Valor Dado Dos:"
								+ +equipos[3].getDadoDos().getValor(),
						"Cantidad a mover", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
						valoresDados, valoresDados[0]);

				int valorCorrer = 0;

				switch (y) {

				case 0:
					valorCorrer = equipos[3].getDadoUno().getValor();

					break;

				case 1:
					valorCorrer = equipos[3].getDadoDos().getValor();

					break;

				case 2:
					valorCorrer = ambosDados;

				}

				switch (x) {

				case 0:
					parques.moverFichaNew(equipos[3].getFichas()[0], valorCorrer);
					panelParques.actualizarFichas();
					equipos[3].setTurno(false);
					equipos[0].setTurno(true);
					break;

				case 1:
					parques.moverFichaNew(equipos[3].getFichas()[1], valorCorrer);
					panelParques.actualizarFichas();
					equipos[3].setTurno(false);
					equipos[0].setTurno(true);
					break;

				case 2:
					parques.moverFichaNew(equipos[3].getFichas()[2], valorCorrer);
					panelParques.actualizarFichas();
					equipos[3].setTurno(false);
					equipos[0].setTurno(true);
					break;

				case 3:
					parques.moverFichaNew(equipos[3].getFichas()[3], valorCorrer);
					panelParques.actualizarFichas();
					equipos[3].setTurno(false);
					equipos[0].setTurno(true);
					break;

				}

			}

		}

	}

	@Override
	public void run() {

		boolean terminado = false;

		Equipo[] equipos = parques.getEquipos();
		equipos[0].setTurno(true);

		// Alguien ha ganado ?
		while (!terminado) {

			// El turno es del equipo 1 ?

			if (equipos[0].getTurno()) {

				turnoUno();

			} else if (equipos[1].getTurno()) {

				turnoDos();

			} else if (equipos[2].getTurno()) {

				turnoTres();

			} else if (equipos[3].getTurno()) {

				turnoCuatro();

			}

		}

	}
}
