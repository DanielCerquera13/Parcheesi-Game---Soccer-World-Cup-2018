package interfaz;

import modelo.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import modelo.Pagina;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PanelPanini extends JPanel implements ActionListener {

	public final static Image FONDO = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/fondoPrincipal.jpg");

	public final static String ANTERIOR = "ANTERIOR";
	public final static String SIGUIENTE = "SIGUIENTE";
	public final static String SALIR = "SALIR";

	private PanelInicio inicio;
	private JButton salir;
	private JButton anterior;
	private JButton siguiente;
	private JLabel bandera;
	private JLabel nombre;
	private JLabel grupo;
	private JLabel laminaUno;
	private JLabel laminaDos;
	private JLabel laminaTres;
	private JLabel laminaCuatro;
	private JLabel laminaCinco;
	private JLabel laminaSeis;
	private JLabel laminaSiete;
	private JLabel laminaOcho;
	private JLabel laminaNueve;
	private JLabel laminaDiez;
	private JLabel laminaOnce;

	public PanelPanini(PanelInicio inicio) {

		this.inicio = inicio;
		setLayout(null);
		componentes();

		inicializar();

	}

	public void componentes() {

		salir = new JButton(SALIR);
		salir.addActionListener(this);
		salir.setActionCommand(SALIR);
		salir.setBounds(500, 700, 330, 40);
		salir.setFont(new Font(" Garamond ", 1, 30));
		add(salir);

		anterior = new JButton(ANTERIOR);
		anterior.addActionListener(this);
		anterior.setActionCommand(ANTERIOR);
		anterior.setBounds(80, 700, 330, 40);
		anterior.setFont(new Font(" Garamond ", 1, 30));
		add(anterior);

		siguiente = new JButton(SIGUIENTE);
		siguiente.addActionListener(this);
		siguiente.setActionCommand(SIGUIENTE);
		siguiente.setBounds(900, 700, 330, 40);
		siguiente.setFont(new Font(" Garamond ", 1, 30));
		add(siguiente);

		bandera = new JLabel();
		bandera.setBounds(30, 30, 100, 100);
		add(bandera);

		nombre = new JLabel("");
		nombre.setBounds(160, 45, 320, 60);
		nombre.setFont(new Font(" Garamond ", 1, 26));
		nombre.setForeground(Color.WHITE);
		add(nombre);

		grupo = new JLabel();
		grupo.setBounds(1000, 45, 300, 60);
		grupo.setFont(new Font(" Garamond ", 1, 40));
		grupo.setForeground(Color.WHITE);

		add(grupo);

		laminaUno = new JLabel();
		laminaUno.setBounds(60, 150, 160, 220);

		add(laminaUno);

		laminaDos = new JLabel();
		laminaDos.setBounds(260, 150, 160, 220);
		add(laminaDos);

		laminaTres = new JLabel();
		laminaTres.setBounds(460, 150, 160, 220);
		add(laminaTres);

		laminaCuatro = new JLabel();
		laminaCuatro.setBounds(660, 150, 160, 220);
		add(laminaCuatro);

		laminaCinco = new JLabel();
		laminaCinco.setBounds(860, 150, 160, 220);
		add(laminaCinco);

		laminaSeis = new JLabel();
		laminaSeis.setBounds(1060, 150, 160, 220);
		add(laminaSeis);

		laminaSiete = new JLabel();
		laminaSiete.setBounds(170, 390, 160, 220);
		add(laminaSiete);

		laminaOcho = new JLabel();
		laminaOcho.setBounds(370, 390, 160, 220);
		add(laminaOcho);

		laminaNueve = new JLabel();
		laminaNueve.setBounds(570, 390, 160, 220);
		add(laminaNueve);

		laminaDiez = new JLabel();
		laminaDiez.setBounds(770, 390, 160, 220);
		add(laminaDiez);

		laminaOnce = new JLabel();
		laminaOnce.setBounds(970, 390, 160, 220);
		add(laminaOnce);
		// dsa

		inicializar();
	}

	public void inicializar() {

		Album album = inicio.getVentana().getParquesMundial().getUsuarios().get(0).getAlbum();

		Pagina pagina = album.getPrimero();
		album.setActual(pagina);

		ImageIcon iconoBandera = new ImageIcon(album.getPrimero().getRutaBandera());
		bandera.setIcon(iconoBandera);

		nombre.setText(pagina.getSeleccion());

		grupo.setText(pagina.getGrupo());

		String ruta1 = pagina.getLaminas()[0].getJugador();
		BufferedImage imagen1 = convertidor(ruta1);
		ImageIcon icono1 = new ImageIcon(imagen1);
		laminaUno.setIcon(icono1);

		String ruta2 = pagina.getLaminas()[1].getJugador();
		BufferedImage imagen2 = convertidor(ruta2);
		ImageIcon icono2 = new ImageIcon(imagen2);
		laminaDos.setIcon(icono2);

		String ruta3 = pagina.getLaminas()[2].getJugador();
		BufferedImage imagen3 = convertidor(ruta3);
		ImageIcon icono3 = new ImageIcon(imagen3);
		laminaTres.setIcon(icono3);

		String ruta4 = pagina.getLaminas()[3].getJugador();
		BufferedImage imagen4 = convertidor(ruta4);
		ImageIcon icono4 = new ImageIcon(imagen4);
		laminaCuatro.setIcon(icono4);

		String ruta5 = pagina.getLaminas()[4].getJugador();
		BufferedImage imagen5 = convertidor(ruta5);
		ImageIcon icono5 = new ImageIcon(imagen5);
		laminaCinco.setIcon(icono5);

		String ruta6 = pagina.getLaminas()[5].getJugador();
		BufferedImage imagen6 = convertidor(ruta6);
		ImageIcon icono6 = new ImageIcon(imagen6);
		laminaSeis.setIcon(icono6);

		String ruta7 = pagina.getLaminas()[6].getJugador();
		BufferedImage imagen7 = convertidor(ruta7);
		ImageIcon icono7 = new ImageIcon(imagen7);
		laminaSiete.setIcon(icono7);

		String ruta8 = pagina.getLaminas()[7].getJugador();
		BufferedImage imagen8 = convertidor(ruta8);
		ImageIcon icono8 = new ImageIcon(imagen8);
		laminaOcho.setIcon(icono8);

		String ruta9 = pagina.getLaminas()[8].getJugador();
		BufferedImage imagen9 = convertidor(ruta9);
		ImageIcon icono9 = new ImageIcon(imagen9);
		laminaNueve.setIcon(icono9);

		String ruta10 = pagina.getLaminas()[9].getJugador();
		BufferedImage imagen10 = convertidor(ruta10);
		ImageIcon icono10 = new ImageIcon(imagen10);
		laminaDiez.setIcon(icono10);

		String ruta11 = pagina.getLaminas()[10].getJugador();
		BufferedImage imagen11 = convertidor(ruta11);
		ImageIcon icono11 = new ImageIcon(imagen11);
		laminaOnce.setIcon(icono11);

	}

	public void actualizarPanini(Pagina pagina) {

		ImageIcon iconoBandera = new ImageIcon(pagina.getRutaBandera());
		bandera.setIcon(iconoBandera);

		nombre.setText(pagina.getSeleccion());

		grupo.setText(pagina.getGrupo());

		String ruta1 = pagina.getLaminas()[0].getJugador();
		BufferedImage imagen1 = convertidor(ruta1);
		ImageIcon icono1 = new ImageIcon(imagen1);
		laminaUno = new JLabel(icono1);

		String ruta2 = pagina.getLaminas()[1].getJugador();
		BufferedImage imagen2 = convertidor(ruta2);
		ImageIcon icono2 = new ImageIcon(imagen2);
		laminaDos = new JLabel(icono2);

		String ruta3 = pagina.getLaminas()[20].getJugador();
		BufferedImage imagen3 = convertidor(ruta3);
		ImageIcon icono3 = new ImageIcon(imagen3);
		laminaTres = new JLabel(icono3);

		String ruta4 = pagina.getLaminas()[3].getJugador();
		BufferedImage imagen4 = convertidor(ruta4);
		ImageIcon icono4 = new ImageIcon(imagen4);
		laminaCuatro = new JLabel(icono4);

		String ruta5 = pagina.getLaminas()[4].getJugador();
		BufferedImage imagen5 = convertidor(ruta5);
		ImageIcon icono5 = new ImageIcon(imagen5);
		laminaCinco = new JLabel(icono5);

		String ruta6 = pagina.getLaminas()[5].getJugador();
		BufferedImage imagen6 = convertidor(ruta6);
		ImageIcon icono6 = new ImageIcon(imagen6);
		laminaSeis = new JLabel(icono6);

		String ruta7 = pagina.getLaminas()[6].getJugador();
		BufferedImage imagen7 = convertidor(ruta7);
		ImageIcon icono7 = new ImageIcon(imagen7);
		laminaSiete = new JLabel(icono7);

		String ruta8 = pagina.getLaminas()[7].getJugador();
		BufferedImage imagen8 = convertidor(ruta8);
		ImageIcon icono8 = new ImageIcon(imagen8);
		laminaOcho = new JLabel(icono8);

		String ruta9 = pagina.getLaminas()[8].getJugador();
		BufferedImage imagen9 = convertidor(ruta9);
		ImageIcon icono9 = new ImageIcon(imagen9);
		laminaNueve = new JLabel(icono9);

		String ruta10 = pagina.getLaminas()[9].getJugador();
		BufferedImage imagen10 = convertidor(ruta10);
		ImageIcon icono10 = new ImageIcon(imagen10);
		laminaDiez = new JLabel(icono10);

		String ruta11 = pagina.getLaminas()[10].getJugador();
		BufferedImage imagen11 = convertidor(ruta11);
		ImageIcon icono11 = new ImageIcon(imagen11);
		laminaOnce = new JLabel(icono11);

	}

	public BufferedImage convertidor(String ruta) {

		File archivo = new File(ruta);
		BufferedImage imgs = null;
		BufferedImage grayScaleImage = null;

		try {
			imgs = ImageIO.read(archivo);

			grayScaleImage = new BufferedImage(imgs.getWidth(), imgs.getHeight(), BufferedImage.TYPE_INT_ARGB);

			for (int i = 0; i < imgs.getHeight(); i++) {
				for (int j = 0; j < imgs.getWidth(); j++) {

					Color c = new Color(imgs.getRGB(j, i));
					int r = c.getRed();
					int g = c.getGreen();
					int b = c.getBlue();
					int a = c.getAlpha();

					int gr = (r + g + b) / 3;

					Color gColor = new Color(gr, gr, gr, a);
					grayScaleImage.setRGB(j, i, gColor.getRGB());
				}
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		return grayScaleImage;
	}

	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(FONDO, 0, 0, null);

		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String a = e.getActionCommand();

		if (a.equals(ANTERIOR)) {
		
			Album album = inicio.getVentana().getParquesMundial().getUsuarios().get(0).getAlbum();
			Pagina actual = album.getActual();
			Pagina laAnterior = actual.getAnterior();
			album.setActual(laAnterior);
			
		}

		if (a.equals(SIGUIENTE)) {

			Album album = inicio.getVentana().getParquesMundial().getUsuarios().get(0).getAlbum();
			Pagina actual = album.getActual();
			Pagina laAnterior = actual.getAnterior();
			album.setActual(laAnterior);
			
		}
	}

}
