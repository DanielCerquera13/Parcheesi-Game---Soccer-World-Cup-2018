package interfaz;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.tools.Tool;

public class PanelInicial extends JPanel implements ActionListener {

	/**
	 * Constantes
	 */

	public final static Image DADOS = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/dadoRojoPro.gif");
	public final static Image LOGO = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/logoPro.png");
	public final static Image FICHA = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/ficha.png");
	public final static Image FONDO = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/fondoPrincipal.jpg");

	public final static String INICIAR = "iniciar";
	public final static String CREAR = "crear";
	public final static String RAPIDA = "rapida";

	/**
	 * Relaciones y atributos
	 */
	private VentanaPrincipal ventana;
	private PanelIniciarSesion iniciar;
	private PanelNuevoUsuario nuevo;
	private PanelEscogerTipoDeJuego pEscogerJugabilidad;
	private JButton butIniciarSesion;
	private JButton butCrearUsuario;
	private JButton butPartidaRapida;

	/**
	 * Constructor
	 * 
	 * @param window
	 */
	public PanelInicial(VentanaPrincipal window) {

		ventana = window;
		
		iniciar = new PanelIniciarSesion(this);
		nuevo = new PanelNuevoUsuario(this);
		pEscogerJugabilidad = new PanelEscogerTipoDeJuego(this);
		setLayout(null);

		ajustarBotones();



	}

	/**
	 * Este metodo se encarga de inicializar y modificar los botones del panel.
	 */
	public void ajustarBotones() {

		butIniciarSesion = new JButton("Iniciar Sesion");
		butIniciarSesion.setActionCommand(INICIAR);
		butIniciarSesion.addActionListener(this);
		butIniciarSesion.setBounds(450, 480, 400, 40);
		butIniciarSesion.setFont(new Font("Garamond", 1, 25));
		butIniciarSesion.setToolTipText("¡Ingresa con tu usuario y contraseña para seguir con tu proceso!");

		butCrearUsuario = new JButton("Crear Nuevo Usuario");
		butCrearUsuario.setActionCommand(CREAR);
		butCrearUsuario.addActionListener(this);
		butCrearUsuario.setBounds(450, 540, 400, 40);
		butCrearUsuario.setFont(new Font("Garamond", 1, 25));
		butCrearUsuario.setToolTipText("¡Crea un nuevo usuario para completar el álbum y mucho más!");

		butPartidaRapida = new JButton("Partida Rapida");
		butPartidaRapida.setActionCommand(RAPIDA);
		butPartidaRapida.addActionListener(this);
		butPartidaRapida.setBounds(450, 600, 400, 40);
		butPartidaRapida.setFont(new Font("Garamond", 1, 25));
		butPartidaRapida.setToolTipText("¡Juega sin la necesidad de iniciar sesión o crear un usuario!");

		add(butIniciarSesion);
		add(butCrearUsuario);
		add(butPartidaRapida);
		
	}
	
	
	

	public VentanaPrincipal getVentana() {
		return ventana;
	}

	public void setVentana(VentanaPrincipal ventana) {
		this.ventana = ventana;
	}

	/**
	 * Este metodo se encarga de pintar las imagenes y gifs en el panel.
	 */
	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Font parques = new Font("Broadway", 4, 40);

		g.drawImage(FONDO, 0, 0, null);
		g.drawImage(DADOS, 0, 0, null);	
		g.drawImage(DADOS, 195, 220, null);
		g.drawImage(DADOS, 1050, 0, null);
		g.drawImage(DADOS, 860, 220, null);
		g.drawImage(LOGO, 450, 10, null);
		g.drawImage(FICHA, 50, 430, null);
		g.drawImage(FICHA, 980, 430, null);
		g.setFont(parques);
		g.setColor(Color.WHITE);
		g.drawString("Parques Mundial Rusia 2018", 350, 700);

		repaint();

	}

	/**
	 * Este metodo se encarga de colocarle las acciones a los botones frente a un
	 * evento.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		String comando = e.getActionCommand();

		if (comando.equals(CREAR)) {
            
			ventana.remove(this);
			ventana.add(nuevo);
			ventana.refresh();
		}

		if (comando.equals(INICIAR)) {

			ventana.remove(this);
			ventana.add(iniciar);
			ventana.refresh();

		}

		if (comando.equals(RAPIDA)) {
			ventana.remove(this);
			ventana.add(pEscogerJugabilidad);
			ventana.refresh();

		}

	}

}
