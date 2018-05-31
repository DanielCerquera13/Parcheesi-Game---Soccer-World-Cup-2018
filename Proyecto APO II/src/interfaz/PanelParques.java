package interfaz;

import javax.swing.*;

import hilos.HiloParques;

import java.awt.*;
import modelo.*;

public class PanelParques extends JPanel {

	private PanelInicio inicio;


	// Componentes para pintar el parques
	private JPanel carcelUno;
	private JPanel carcelDos;
	private JPanel carcelTres;
	private JPanel carcelCuatro;

	private JPanel elCentro;

	private JPanel zonaUno;
	private JPanel zonaDos;
	private JPanel zonaTres;
	private JPanel zonaCuatro;

	private JButton[][] zonaUnoBut;
	private JButton[][] zonaDosBut;
	private JButton[][] zonaTresBut;
	private JButton[][] zonaCuatroBut;

	public PanelParques(PanelInicio inicio) {

		this.inicio = inicio;

		setLayout(new GridLayout(3, 3));

		inicializarTablero();
		refresh();

		add(carcelCuatro);
		add(zonaCuatro);
		add(carcelTres);
		add(zonaUno);
		add(elCentro);
		add(zonaTres);
		add(carcelUno);
		add(zonaDos);
		add(carcelDos);

	}


	
	
	public void inicializarTablero() {

		carcelUno = new JPanel();
		carcelDos = new JPanel();
		carcelTres = new JPanel();
		carcelCuatro = new JPanel();

		zonaUno = new JPanel();
		zonaUno.setLayout(new GridLayout(3, 8));

		zonaDos = new JPanel();
		zonaDos.setLayout(new GridLayout(8, 3));

		zonaTres = new JPanel();
		zonaTres.setLayout(new GridLayout(3, 8));

		zonaCuatro = new JPanel();
		zonaCuatro.setLayout(new GridLayout(8, 3));

		elCentro = new JPanel();

		zonaUnoBut = new JButton[3][8];
		zonaDosBut = new JButton[8][3];
		zonaTresBut = new JButton[3][8];
		zonaCuatroBut = new JButton[8][3];

		rellenarTablero();

	}

	public void rellenarTablero() {

		Casilla[][] zonaUnoC = inicio.getVentana().getZonaUno();
		Casilla[][] zonaDosC = inicio.getVentana().getZonaDos();
		Casilla[][] zonaTresC = inicio.getVentana().getZonaTres();
		Casilla[][] zonaCuatroC = inicio.getVentana().getZonaCuatro();

		// Rellena la zona Uno
		for (int i = 0; i < zonaUnoBut.length; i++) {
			for (int j = 0; j < zonaUnoBut[0].length; j++) {

				zonaUnoBut[i][j] = new JButton(zonaUnoC[i][j].toString());
				zonaUnoBut[i][j].setLayout(new GridLayout(4, 2));

				for (int k = 0; k < 8; k++) {

					zonaUnoBut[i][j].add(new JButton());

				}
				zonaUnoBut[i][j].setOpaque(true);

				zonaTresBut[i][j] = new JButton(zonaTresC[i][j].toString());
				zonaTresBut[i][j].setLayout(new GridLayout(4, 2));
				for (int k = 0; k < 8; k++) {

					zonaTresBut[i][j].add(new JButton());

				}
				zonaTresBut[i][j].setOpaque(true);

				zonaUno.add(zonaUnoBut[i][j]);
				zonaTres.add(zonaTresBut[i][j]);

			}

		}

		for (int i = 0; i < zonaDosBut.length; i++) {

			for (int j = 0; j < zonaDosBut[0].length; j++) {

				zonaDosBut[i][j] = new JButton(zonaDosC[i][j].toString());
				zonaDosBut[i][j].setLayout(new GridLayout(2, 4));
				for (int k = 0; k < 8; k++) {

					zonaDosBut[i][j].add(new JButton());

				}
				zonaDosBut[i][j].setOpaque(true);

				zonaCuatroBut[i][j] = new JButton(zonaCuatroC[i][j].toString());
				zonaCuatroBut[i][j].setLayout(new GridLayout(2, 4));
				for (int k = 0; k < 8; k++) {

					zonaCuatroBut[i][j].add(new JButton());

				}
				zonaCuatroBut[i][j].setOpaque(true);

				zonaDos.add(zonaDosBut[i][j]);
				zonaCuatro.add(zonaCuatroBut[i][j]);

			}

		}
	}

	public void actualizarTablero() {

		Casilla[][] zonaUnoC = inicio.getVentana().getZonaUno();
		Casilla[][] zonaDosC = inicio.getVentana().getZonaDos();
		Casilla[][] zonaTresC = inicio.getVentana().getZonaTres();
		Casilla[][] zonaCuatroC = inicio.getVentana().getZonaCuatro();

		// Rellena la zona Uno
		for (int i = 0; i < zonaUnoBut.length; i++) {
			for (int j = 0; j < zonaUnoBut[0].length; j++) {

				zonaUnoBut[i][j].setText(zonaUnoC[i][j].toString());
				zonaUnoBut[i][j].setOpaque(true);

				zonaTresBut[i][j].setText(zonaTresC[i][j].toString());
				zonaTresBut[i][j].setOpaque(true);

			}

		}

		for (int i = 0; i < zonaDosBut.length; i++) {

			for (int j = 0; j < zonaDosBut[0].length; j++) {

				zonaDosBut[i][j].setText(zonaDosC[i][j].toString());
				zonaDosBut[i][j].setOpaque(true);

				zonaCuatroBut[i][j].setText(zonaCuatroC[i][j].toString());
				zonaCuatroBut[i][j].setOpaque(true);

				zonaDos.add(zonaDosBut[i][j]);
				zonaCuatro.add(zonaCuatroBut[i][j]);

			}

		}

	}

	public void refresh() {

		invalidate();
		revalidate();
		repaint();

	}

	/**
	 * @return the inicio
	 */
	public PanelInicio getInicio() {
		return inicio;
	}

	/**
	 * @param inicio
	 *            the inicio to set
	 */
	public void setInicio(PanelInicio inicio) {
		this.inicio = inicio;
	}

	/**
	 * @return the carcelUno
	 */
	public JPanel getCarcelUno() {
		return carcelUno;
	}

	/**
	 * @param carcelUno
	 *            the carcelUno to set
	 */
	public void setCarcelUno(JPanel carcelUno) {
		this.carcelUno = carcelUno;
	}

	/**
	 * @return the carcelDos
	 */
	public JPanel getCarcelDos() {
		return carcelDos;
	}

	/**
	 * @param carcelDos
	 *            the carcelDos to set
	 */
	public void setCarcelDos(JPanel carcelDos) {
		this.carcelDos = carcelDos;
	}

	/**
	 * @return the carcelTres
	 */
	public JPanel getCarcelTres() {
		return carcelTres;
	}

	/**
	 * @param carcelTres
	 *            the carcelTres to set
	 */
	public void setCarcelTres(JPanel carcelTres) {
		this.carcelTres = carcelTres;
	}

	/**
	 * @return the carcelCuatro
	 */
	public JPanel getCarcelCuatro() {
		return carcelCuatro;
	}

	/**
	 * @param carcelCuatro
	 *            the carcelCuatro to set
	 */
	public void setCarcelCuatro(JPanel carcelCuatro) {
		this.carcelCuatro = carcelCuatro;
	}

	/**
	 * @return the elCentro
	 */
	public JPanel getElCentro() {
		return elCentro;
	}

	/**
	 * @param elCentro
	 *            the elCentro to set
	 */
	public void setElCentro(JPanel elCentro) {
		this.elCentro = elCentro;
	}

	/**
	 * @return the zonaUno
	 */
	public JPanel getZonaUno() {
		return zonaUno;
	}

	/**
	 * @param zonaUno
	 *            the zonaUno to set
	 */
	public void setZonaUno(JPanel zonaUno) {
		this.zonaUno = zonaUno;
	}

	/**
	 * @return the zonaDos
	 */
	public JPanel getZonaDos() {
		return zonaDos;
	}

	/**
	 * @param zonaDos
	 *            the zonaDos to set
	 */
	public void setZonaDos(JPanel zonaDos) {
		this.zonaDos = zonaDos;
	}

	/**
	 * @return the zonaTres
	 */
	public JPanel getZonaTres() {
		return zonaTres;
	}

	/**
	 * @param zonaTres
	 *            the zonaTres to set
	 */
	public void setZonaTres(JPanel zonaTres) {
		this.zonaTres = zonaTres;
	}

	/**
	 * @return the zonaCuatro
	 */
	public JPanel getZonaCuatro() {
		return zonaCuatro;
	}

	/**
	 * @param zonaCuatro
	 *            the zonaCuatro to set
	 */
	public void setZonaCuatro(JPanel zonaCuatro) {
		this.zonaCuatro = zonaCuatro;
	}

	/**
	 * @return the zonaUnoBut
	 */
	public JButton[][] getZonaUnoBut() {
		return zonaUnoBut;
	}

	/**
	 * @param zonaUnoBut
	 *            the zonaUnoBut to set
	 */
	public void setZonaUnoBut(JButton[][] zonaUnoBut) {
		this.zonaUnoBut = zonaUnoBut;
	}

	/**
	 * @return the zonaDosBut
	 */
	public JButton[][] getZonaDosBut() {
		return zonaDosBut;
	}

	/**
	 * @param zonaDosBut
	 *            the zonaDosBut to set
	 */
	public void setZonaDosBut(JButton[][] zonaDosBut) {
		this.zonaDosBut = zonaDosBut;
	}

	/**
	 * @return the zonaTresBut
	 */
	public JButton[][] getZonaTresBut() {
		return zonaTresBut;
	}

	/**
	 * @param zonaTresBut
	 *            the zonaTresBut to set
	 */
	public void setZonaTresBut(JButton[][] zonaTresBut) {
		this.zonaTresBut = zonaTresBut;
	}

	/**
	 * @return the zonaCuatroBut
	 */
	public JButton[][] getZonaCuatroBut() {
		return zonaCuatroBut;
	}

	/**
	 * @param zonaCuatroBut
	 *            the zonaCuatroBut to set
	 */
	public void setZonaCuatroBut(JButton[][] zonaCuatroBut) {
		this.zonaCuatroBut = zonaCuatroBut;
	}

	// Actualiza los botones de cada Boton Casilla 
	public void actualizarFichas() {

		// Recorrido para actualizar zona uno
		for (int k = 0; k < inicio.getParques().getZonaUno().length; k++) {
			for (int h = 0; h < inicio.getParques().getZonaUno()[0].length; h++) {
				for (int j = 0; j < inicio.getParques().getZonaUno()[k][h].getFichas().length; j++) {

					if (inicio.getParques().getZonaUno()[k][h].getFichas()[j] != null
							&& inicio.getParques().getZonaUno()[k][h].getFichas()[j].getTipo() == 1) {

						getZonaUnoBut()[k][h].getComponent(j).setBackground(new Color(128, 128, 0));

					}

					if (inicio.getParques().getZonaUno()[k][h].getFichas()[j] != null
							&& inicio.getParques().getZonaUno()[k][h].getFichas()[j].getTipo() == 2) {

						getZonaUnoBut()[k][h].getComponent(j).setBackground(new Color(0, 128, 0));

					}

					if (inicio.getParques().getZonaUno()[k][h].getFichas()[j] != null
							&& inicio.getParques().getZonaUno()[k][h].getFichas()[j].getTipo() == 3) {

						getZonaUnoBut()[k][h].getComponent(j).setBackground(Color.BLUE);

					}

					if (inicio.getParques().getZonaUno()[k][h].getFichas()[j] != null
							&& inicio.getParques().getZonaUno()[k][h].getFichas()[j].getTipo() == 4) {

						getZonaUnoBut()[k][h].getComponent(j).setBackground(new Color(128, 0, 0));

					}

				}

			}

		}

		// Recorrido para actualizar zona dos
		for (int k = 0; k < inicio.getParques().getZonaDos().length; k++) {
			for (int h = 0; h < inicio.getParques().getZonaDos()[0].length; h++) {
				for (int j = 0; j < inicio.getParques().getZonaDos()[k][h].getFichas().length; j++) {

					if (inicio.getParques().getZonaDos()[k][h].getFichas()[j] != null
							&& inicio.getParques().getZonaDos()[k][h].getFichas()[j].getTipo() == 1) {

						getZonaDosBut()[k][h].getComponent(j).setBackground(new Color(128, 128, 0));

					}

					if (inicio.getParques().getZonaDos()[k][h].getFichas()[j] != null
							&& inicio.getParques().getZonaDos()[k][h].getFichas()[j].getTipo() == 2) {

						getZonaDosBut()[k][h].getComponent(j).setBackground(new Color(0, 128, 0));

					}

					if (inicio.getParques().getZonaDos()[k][h].getFichas()[j] != null
							&& inicio.getParques().getZonaDos()[k][h].getFichas()[j].getTipo() == 3) {

						getZonaDosBut()[k][h].getComponent(j).setBackground(Color.BLUE);

					}

					if (inicio.getParques().getZonaDos()[k][h].getFichas()[j] != null
							&& inicio.getParques().getZonaDos()[k][h].getFichas()[j].getTipo() == 4) {

						getZonaDosBut()[k][h].getComponent(j).setBackground(new Color(128, 0, 0));

					}

				}

			}

		}

		// Recorrido para actualizar zona cuatro
		for (int k = 0; k < inicio.getParques().getZonaTres().length; k++) {
			for (int h = 0; h < inicio.getParques().getZonaTres()[0].length; h++) {
				for (int j = 0; j < inicio.getParques().getZonaTres()[k][h].getFichas().length; j++) {

					if (inicio.getParques().getZonaTres()[k][h].getFichas()[j] != null
							&& inicio.getParques().getZonaTres()[k][h].getFichas()[j].getTipo() == 1) {

						getZonaTresBut()[k][h].getComponent(j).setBackground(new Color(128, 128, 0));

					}

					if (inicio.getParques().getZonaTres()[k][h].getFichas()[j] != null
							&& inicio.getParques().getZonaTres()[k][h].getFichas()[j].getTipo() == 2) {

						getZonaTresBut()[k][h].getComponent(j).setBackground(new Color(0, 128, 0));

					}

					if (inicio.getParques().getZonaTres()[k][h].getFichas()[j] != null
							&& inicio.getParques().getZonaTres()[k][h].getFichas()[j].getTipo() == 3) {

						getZonaTresBut()[k][h].getComponent(j).setBackground(Color.BLUE);

					}

					if (inicio.getParques().getZonaTres()[k][h].getFichas()[j] != null
							&& inicio.getParques().getZonaTres()[k][h].getFichas()[j].getTipo() == 4) {

						getZonaTresBut()[k][h].getComponent(j).setBackground(new Color(128, 0, 0));

					}

				}

			}

		}

		// Recorrido para actualizar zona cuatro
		for (int k = 0; k < inicio.getParques().getZonaCuatro().length; k++) {
			for (int h = 0; h < inicio.getParques().getZonaCuatro()[0].length; h++) {
				for (int j = 0; j < inicio.getParques().getZonaCuatro()[k][h].getFichas().length; j++) {

					if (inicio.getParques().getZonaCuatro()[k][h].getFichas()[j] != null
							&& inicio.getParques().getZonaCuatro()[k][h].getFichas()[j].getTipo() == 1) {

						getZonaCuatroBut()[k][h].getComponent(j).setBackground(new Color(128, 128, 0));

					}

					if (inicio.getParques().getZonaCuatro()[k][h].getFichas()[j] != null
							&& inicio.getParques().getZonaCuatro()[k][h].getFichas()[j].getTipo() == 2) {

						getZonaCuatroBut()[k][h].getComponent(j).setBackground(new Color(0, 128, 0));

					}

					if (inicio.getParques().getZonaCuatro()[k][h].getFichas()[j] != null
							&& inicio.getParques().getZonaCuatro()[k][h].getFichas()[j].getTipo() == 3) {

						getZonaCuatroBut()[k][h].getComponent(j).setBackground(Color.BLUE);

					}

					if (inicio.getParques().getZonaCuatro()[k][h].getFichas()[j] != null
							&& inicio.getParques().getZonaCuatro()[k][h].getFichas()[j].getTipo() == 4) {

						getZonaCuatroBut()[k][h].getComponent(j).setBackground(new Color(128, 0, 0));

					}

				}

			}

		}

	}


	
	


}
