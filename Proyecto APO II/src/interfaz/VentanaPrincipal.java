package interfaz;

import javax.swing.*;

import java.awt.*;

public class VentanaPrincipal extends JFrame {

	/**
	 * Relaciones
	 */

	private PanelNuevoUsuario panelUsuario;
private int valor;
	
	
	private PanelInicial inicial;
	private VentanaIniciarSesion iniciarSesion;

	/**
	 * Constructor
	 */
	public VentanaPrincipal() {

		setTitle("Parqu�s Mundial Rusia 2018");
		setResizable(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	// esta es 
		//setSize(1580, 1024);

		setSize(800, 600);
		// Custom Cursor

		//setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
		//		new ImageIcon("./Archivos/imagenes/recursos/balon.png").getImage(), new Point(0, 0), "Ball Cursor"));

//		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
//				new ImageIcon("./Archivos/imagenes/recursos/balon.png").getImage(), new Point(0, 0), "Ball Cursor"));
//github.com/JavaCracks/proyectoFinal.git

		// Icono del programa
		Image icon = Toolkit.getDefaultToolkit().createImage("./Archivos/imagenes/recursos/logoPro.png");
		setIconImage(icon);

		panelUsuario = new PanelNuevoUsuario(this);
		inicial = new PanelInicial(this);
		iniciarSesion = new VentanaIniciarSesion(this);

		add(inicial);
        
		
	
	}

	
	public PanelNuevoUsuario getPanelNuevoUsuario() {
		
		return panelUsuario;
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
