package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelInicio extends JPanel implements ActionListener,MouseListener{

	public static final Image ALBUM = Toolkit.getDefaultToolkit().createImage("./Archivos/imagenes/recursos/album.png");
	public static final Image LAMINA = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/lamina.jpeg");
	public static final Image FONDO = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/fondoInicio.png");
	public static final Image LOGO = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/logoPro.png");

	public static final String JUGAR = "jugar";

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

