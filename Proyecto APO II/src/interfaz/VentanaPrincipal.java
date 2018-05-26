package interfaz;

import modelo.*;
import javax.swing.*;

import java.awt.*;

public class VentanaPrincipal extends JFrame {

	/**
	 * Relaciones
	 */
	
	private PanelInicial inicial;
	private ParquesMundial mundial;

	/**
	 * Constructor
	 */
	public VentanaPrincipal() {

		setTitle("Parques Mundial Rusia 2018");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setSize(1280, 768);
		// Custom Cursor

		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("./Archivos/imagenes/recursos/balon.png").getImage(), new Point(0, 0), "Ball Cursor"));

		// Icono del programa
		Image icon = Toolkit.getDefaultToolkit().createImage("./Archivos/imagenes/recursos/logoPro.png");
		setIconImage(icon);
		mundial = new ParquesMundial();

		inicial = new PanelInicial(this);

		add(inicial);

		// asd

	}
	
	public ParquesMundial getParquesMundial() {
		
	return mundial;	
		
	}

	public PanelInicial getPanelInicial() {

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
