package interfaz;

import java.awt.*;
import javax.swing.*;
import javax.tools.Tool;

public class PanelAuxiliarPrincipal extends JPanel {

	public final static Image DADOS = Toolkit.getDefaultToolkit().createImage("./Archivos/imagenes/recursos/dadoRojoPro.gif");
	public final static Image LOGO = Toolkit.getDefaultToolkit().createImage("./Archivos/imagenes/recursos/logoPro.png");
	public final static Image FICHA = Toolkit.getDefaultToolkit().createImage("./Archivos/imagenes/recursos/fichaInicio.png");
	public final static Image FONDO = Toolkit.getDefaultToolkit().createImage("./Archivos/imagenes/recursos/fondoPrincipal.jpg");
	
	
	private VentanaPrincipal ventana;
	private JButton butIniciarSesion;
	private JButton butCrearUsuario;
	private JButton butPartidaRapida;

	public PanelAuxiliarPrincipal(VentanaPrincipal window) {
		
		ventana = window;
		setLayout(null);

		ajustarBotones();

		add(butIniciarSesion);
		add(butCrearUsuario);
		add(butPartidaRapida);

	}

	public void ajustarBotones() {
		
		butIniciarSesion = new JButton("Iniciar Sesión");
		butIniciarSesion.setBounds(620, 590, 400, 80);
		butIniciarSesion.setFont(new Font("Garamond", 1 , 40));
		
		butCrearUsuario = new JButton("Crear Nuevo Usuario");
		butCrearUsuario.setBounds(620, 690, 400, 80);
		butCrearUsuario.setFont(new Font("Garamond", 1 , 40));
		
		butPartidaRapida = new JButton("Partida Rápida");
		butPartidaRapida.setBounds(620, 790, 400, 80);
		butPartidaRapida.setFont(new Font("Garamond", 1 , 40));
		
		
		
	}
	
	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		Font parques = new Font("Broadway", 4, 45);
		
		
		g.drawImage(FONDO, 0, 0, null);
		g.drawImage(DADOS, 80, 40, null);
		g.drawImage(DADOS, 280, 220, null);
		g.drawImage(DADOS, 1300, 40, null);
		g.drawImage(DADOS, 1100, 220, null);
		g.drawImage(LOGO, 560, -10, null);
		g.drawImage(FICHA, -15, 500, null);
		g.drawImage(FICHA, 1100, 500, null);
		g.setFont(parques);
		g.setColor(Color.WHITE);
		g.drawString("Parqués Mundial Rusia 2018", 460, 935);

		repaint();

	}

}
