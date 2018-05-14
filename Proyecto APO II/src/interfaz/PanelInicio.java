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

	private VentanaPrincipal ventana;
	private JLabel labUsuario;
	private JButton butJugar;
	private JLabel labLaminas;
	private JLabel labAlbum;

	public PanelInicio() {

	setLayout(null);
	ajustarComponentes();
	addMouseListener(this);
		
	}
	

	public void ajustarComponentes() {
		
	butJugar = new JButton("JUGAR");
	butJugar.setFont(new Font("Garamond", 1, 40));
	butJugar.setBounds(530, 480, 235, 95);
	butJugar.setActionCommand(JUGAR);
	butJugar.addActionListener(this);
	add(butJugar);

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
		
		if(comando.equals(JUGAR)) {
			
			
			
		}

	}


	@Override
	public void mouseClicked(MouseEvent e) {
		
		System.out.println("x = "+e.getX()+"  y = "+ e.getY());
		
		
		// Condicion para entrar al album panini
		if((e.getX() >= 100 && e.getX() <= 310)&&(e.getY() >=185 && e.getY() <= 485)) {
			
			System.out.println("hola");
			
		}
		
		if((e.getX()>=950 && e.getX()<= 1180)&&(e.getY() >= 230 && e.getY()<= 445)) {
			
			System.out.println("bye");
			
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
