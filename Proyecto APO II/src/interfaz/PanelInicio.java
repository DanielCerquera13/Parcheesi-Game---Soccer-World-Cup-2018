package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelo.*;

public class PanelInicio extends JPanel implements ActionListener,MouseListener{

	public static final Image ALBUM = Toolkit.getDefaultToolkit().createImage("./Archivos/imagenes/recursos/album.png");
	public static final Image LAMINA = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/lamina.jpeg");
	public static final Image FONDO = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/fondoInicio.png");
	public static final Image LOGO = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/logoPro.png");

	public static final String JUGAR = "jugar";

	private PanelParques parques;
	private PanelIniciarSesion sesion;
	private JLabel labUsuario;
	private JButton butJugar;
	private JLabel labLaminas;
	private JLabel labAlbum;
	private JLabel labTituloAlbum;
	private JLabel labTituloLaminas;
	private PanelPanini panini; 
	private PanelTienda tienda;
    private JLabel usuario;

	public PanelInicio(PanelIniciarSesion sesion) {

	this.sesion = sesion;
	setLayout(null);
	//ajustarComponentes();
	addMouseListener(this);
	panini = new PanelPanini(this);
	tienda = new PanelTienda(this);
	parques = null;
	
	}
	

	public VentanaPrincipal getVentana() {
		
	return sesion.getVentana();	
		
	}
	
	public void ajustarComponentes() {
		
	butJugar = new JButton("JUGAR");
	butJugar.setFont(new Font("Garamond", 1, 40));
	butJugar.setBounds(530, 480, 235, 95);
	butJugar.setActionCommand(JUGAR);
	butJugar.addActionListener(this);
	add(butJugar);
	
	labTituloAlbum = new JLabel(" Completa el album! ");
	labTituloAlbum.setBounds(50, 80, 500, 80);
	labTituloAlbum.setFont(new Font(" Garamond ", 1, 35));
	labTituloAlbum.setForeground(Color.BLACK);
	add(labTituloAlbum);
	
	labTituloLaminas = new JLabel(" Consigue laminas! ");
	labTituloLaminas.setBounds(920, 80, 500, 80);
	labTituloLaminas.setFont(new Font(" Garamond ", 1, 35));
	labTituloLaminas.setForeground(Color.BLACK);
	add(labTituloLaminas);
	
	
	usuario = new JLabel("Bienvenido" + " " + sesion.getVentana().getSesionActiva().getNickName());
	usuario.setFont(new Font("Garamond", 1, 60));
	usuario.setBounds(300, 580, 800, 95);
	add(usuario);

	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(FONDO, 0, 0, null);
		g.drawImage(LOGO, 450, 10, null);
		g.drawImage(ALBUM, 95, 175, null);
		g.drawImage(LAMINA, 1000, 230, null);
		g.drawImage(LAMINA, 975, 245, null);
		g.drawImage(LAMINA, 1065, 245, null);
		g.drawImage(LAMINA, 1035, 285, null);

		repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if(comando.equals(JUGAR)) {
		
		VentanaPrincipal vent = sesion.getVentana();	
			
		sesion.getVentana().remove(this);
		
		
		// Se crean los equipos
		Equipo e1 = new Equipo("", "Colombia", 1);
		Equipo e2 = new Equipo("", "Brasil", 2);
		Equipo e3 = new Equipo("", "Alemania", 3);
		Equipo e4 = new Equipo("", "Senegal", 4);

		// Se crean los jugadores
		Jugador j2 = new Jugador("Jugador 2");
		Jugador j3 = new Jugador("Jugador 3");
		Jugador j4 = new Jugador("Jugador 4");
		
		
		// Se asignan los equipos a los jugadores
		vent.getSesionActiva().setEquipo(e1);
		j2.setEquipo(e2);
		j3.setEquipo(e3);
		j4.setEquipo(e4);
		
		Equipo[] equipos = {vent.getSesionActiva().getEquipo(), j2.getEquipo(), j3.getEquipo(), j4.getEquipo()};
				
		
		Partida laPartida = new Partida();
		
		laPartida.getParques().setEquipos(equipos);
		
		vent.getSesionActiva().setPartida(laPartida);
		
		parques = new PanelParques(this);
		
		Parques p = laPartida.getParques();
		
		p.sacarFichasDeLaCarcel(e2.getFichas());
//		p.rellenarZonas();
		parques.actualizarTablero();
		
		p.moverFichaNew(e2.getFichas()[0], 5);
		
		parques.actualizarTablero();
		
		sesion.getVentana().add(parques);
		sesion.getVentana().setSize(1920,1000);
		sesion.getVentana().refresh();
		
			
		}

	}


	@Override
	public void mouseClicked(MouseEvent e) {
		
		System.out.println("x = "+e.getX()+"  y = "+ e.getY());
		
		
		// Condicion para entrar al album panini
		if((e.getX() >= 100 && e.getX() <= 310)&&(e.getY() >=185 && e.getY() <= 485)) {
			
			System.out.println("hola");
			sesion.getVentana().remove(this);
			panini.inicializar();
			sesion.getVentana().add(panini);						
			sesion.getVentana().refresh();
			
			
			
		}
		
		if((e.getX()>=950 && e.getX()<= 1180)&&(e.getY() >= 230 && e.getY()<= 445)) {
			
			tienda.componentes();
			System.out.println("bye");
			sesion.getVentana().remove(this);
			sesion.getVentana().add(tienda);
			sesion.getVentana().refresh();
			 
			
		}
		
	}


	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

