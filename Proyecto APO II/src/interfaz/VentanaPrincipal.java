package interfaz;

import modelo.*;
import javax.swing.*;

import excepciones.UsuarioNoRegistradoException;
import excepciones.UsuarioYaRegistradoException;
import hilos.HiloParques;

import java.awt.*;

public class VentanaPrincipal extends JFrame {

	/**
	 * Relaciones
	 */

	private PanelInicial inicial;
	private ParquesMundial mundial;
	private HiloParques hilo;

	/**
	 * Constructor
	 */
	public VentanaPrincipal() {

		setTitle("Parques Mundial Rusia 2018");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setSize(1280, 768);
		// Custom Cursor

		try {

			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

		} catch (Exception e) {

			e.printStackTrace();

		}
		
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon("./Archivos/imagenes/recursos/balon.png").getImage(), new Point(0, 0), "Ball Cursor"));

		// Icono del programa
		Image icon = Toolkit.getDefaultToolkit().createImage("./Archivos/imagenes/recursos/logoPro.png");
		setIconImage(icon);
		mundial = new ParquesMundial();

		inicial = new PanelInicial(this);

		hilo = null;
		add(inicial);

		// asd

	}

	

	public ParquesMundial getParquesMundial() {

		return mundial;

	}

	public PanelInicial getPanelInicial() {

		return inicial;
	}

	public void agregarUsuario(Jugador usuario) throws UsuarioYaRegistradoException {

		mundial.agregarUsuario(usuario);

	}

	public Jugador buscarUsuario(String nickname) throws UsuarioNoRegistradoException {

		return mundial.buscarUsuario(nickname);

	}

	public void guardar() {

		mundial.guardar();

	}

	public void setSesionActiva(Jugador sesion) {

		mundial.setSesionActiva(sesion);

	}

	public Jugador getSesionActiva() {

		return mundial.getSesionActiva();

	}

	public void refresh() {

		invalidate();
		revalidate();
		repaint();

	}

	public Casilla[][] getZonaUno() {

		return mundial.getZonaUno();

	}

	public Casilla[][] getZonaDos() {

		return mundial.getZonaDos();

	}

	public Casilla[][] getZonaTres() {

		return mundial.getZonaTres();

	}

	public Casilla[][] getZonaCuatro() {

		return mundial.getZonaCuatro();

	}

	public void rellenarZonas() {
		
	mundial.rellenarZonas();	
		
	}
	
	public static void main(String args[]) {
		VentanaPrincipal ventana = new VentanaPrincipal();
		ventana.setVisible(true);
	}
}
