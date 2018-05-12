package interfaz;

import javax.swing.*;

import java.awt.*;

public class VentanaPrincipal extends JFrame {

	private VentanaIniciarSesion ventanaSesion;
	private VentanaNuevoUsuario ventanaUsuario;

	public VentanaPrincipal() {

		setTitle("Parqués Mundial Rusia 2018");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setSize(1280, 1024);

		ventanaSesion = new VentanaIniciarSesion();
		ventanaUsuario = new VentanaNuevoUsuario();

	}

	public static void main(String args[]) {
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setVisible(true);
	}
}
