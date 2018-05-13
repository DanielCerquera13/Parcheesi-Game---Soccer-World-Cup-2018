package interfaz;

import javax.swing.*;

import java.awt.*;

public class VentanaPrincipal extends JFrame {

	private VentanaIniciarSesion ventanaSesion;
	private VentanaNuevoUsuario ventanaUsuario;
	private PanelAuxiliarPrincipal aux;

	public VentanaPrincipal() {

		setTitle("Parqués Mundial Rusia 2018");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1580, 1024);

		// Custom Cursor
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("./Archivos/imagenes/recursos/balon.png").getImage(), new Point(0, 0), "Ball Cursor"));

		// Icono del programa
		Image icon = Toolkit.getDefaultToolkit().createImage("./Archivos/imagenes/recursos/logoPro.png");
		setIconImage(icon);

		ventanaSesion = new VentanaIniciarSesion();
		ventanaUsuario = new VentanaNuevoUsuario();
		aux = new PanelAuxiliarPrincipal(this);

		add(aux);

	}

	public static void main(String args[]) {
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setVisible(true);
	}
}
