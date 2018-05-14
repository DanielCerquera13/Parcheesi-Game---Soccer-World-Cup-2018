package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelInicio extends JPanel implements ActionListener {

	public static final Image ALBUM = Toolkit.getDefaultToolkit().createImage("./Archivos/imagenes/recursos/album.png");
	public static final Image LAMINA = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/lamina.jpeg");
	public static final Image FONDO = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/fondoInicio.png");
	public static final Image LOGO = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/logoPro.png");

	public static final String JUGAR = "jugar";

	private VentanaPrincipal ventana;
	private JLabel labUsuario;
	private JButton butJugar;
	private JLabel labLaminas;
	private JLabel labAlbum;

	public PanelInicio() {

	}

	public void ajustarComponentes() {

	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(FONDO, 0, 0, null);
		g.drawImage(LOGO, 450, 10, null);
		g.drawImage(ALBUM, 95, 175, null);
		g.drawImage(LAMINA, 1000, 250, null);
		g.drawImage(LAMINA, 975, 285, null);
		g.drawImage(LAMINA, 1065, 285, null);
		g.drawImage(LAMINA, 1035, 315, null);

		repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

	}

}
