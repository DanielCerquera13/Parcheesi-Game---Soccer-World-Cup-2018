package interfaz;

import javax.swing.*;

import java.awt.*;

public class VentanaPrincipal extends JFrame {

	/**
	 * Relaciones
	 */

	private VentanaNuevoUsuario ventanaUsuario;
	private PanelInicial inicial;
	private VentanaIniciarSesion iniciarSesion;

	/**
	 * Constructor
	 */
	public VentanaPrincipal() {

		setTitle("Parqués Mundial Rusia 2018");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1580, 1024);

		// Custom Cursor
//		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
//				new ImageIcon("./Archivos/imagenes/recursos/balon.png").getImage(), new Point(0, 0), "Ball Cursor"));

		// Icono del programa
		Image icon = Toolkit.getDefaultToolkit().createImage("./Archivos/imagenes/recursos/logoPro.png");
		setIconImage(icon);

		ventanaUsuario = new VentanaNuevoUsuario();
		inicial = new PanelInicial(this);
		iniciarSesion = new VentanaIniciarSesion(this);

		add(inicial);

	}

	public VentanaIniciarSesion getIniciarSesion() {

		return iniciarSesion;

	}

	public PanelInicial getAux() {

		return inicial;

	}

	public void refresh() {

		invalidate();
		revalidate();
		repaint();

	}

	public static void main(String args[]) {
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setVisible(true);
	}
}
