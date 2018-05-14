package interfaz;

import javax.swing.*;

import java.awt.*;

public class VentanaPrincipal extends JFrame {

	/**
	 * Relaciones
	 */

	private PanelNuevoUsuario panelUsuario;

	private PanelInicial inicial;
	private PanelIniciarSesion iniciarSesion;

	/**
	 * Constructor
	 */
	public VentanaPrincipal() {

		setTitle("Parques Mundial Rusia 2018");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setSize(1280, 768);
		// Custom Cursor

		// setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
		// new ImageIcon("./Archivos/imagenes/recursos/balon.png").getImage(), new
		// Point(0, 0), "Ball Cursor"));

		// Icono del programa
		Image icon = Toolkit.getDefaultToolkit().createImage("./Archivos/imagenes/recursos/logoPro.png");
		setIconImage(icon);

		panelUsuario = new PanelNuevoUsuario(this);
		inicial = new PanelInicial(this);
		iniciarSesion = new PanelIniciarSesion(this);

		add(inicial);

		// asd

	}

	public PanelInicial getPanelInicial() {

		return inicial;
	}

	public PanelNuevoUsuario getPanelNuevoUsuario() {

		return panelUsuario;
	}

	public PanelIniciarSesion getIniciarSesion() {

		return iniciarSesion;

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
