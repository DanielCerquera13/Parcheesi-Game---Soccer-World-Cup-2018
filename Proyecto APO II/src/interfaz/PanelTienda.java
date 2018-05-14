package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelTienda extends JPanel implements ActionListener, MouseListener {
	
	public final static String SALIR = "SALIR";
	public final static Image FONDO = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/fondoPrincipal.jpg");
	
	private JLabel tienda;
	private JLabel laminaPrincipal;
	private JLabel dinero;
	private JButton salir;
	private JLabel flechaUno;
	private JLabel flechaDos;
	private JLabel flechaTres;
	private JLabel flechaCuatro;
  
	public PanelTienda () {
		 
		setLayout(null);
		componentes();
	}

	
	public void componentes () {
		   
		tienda = new JLabel("TIENDA DE LAMINAS");
		tienda.setBounds(60, 30, 320, 60);
		tienda.setFont(new Font(" Garamond ", 1, 26));
		tienda.setForeground(Color.WHITE);
		add(tienda);
		
		dinero = new JLabel(" $ 1000 ");
		dinero.setBounds(980, 30, 320, 60);
		dinero.setFont(new Font(" Garamond ", 1, 40));
		dinero.setForeground(Color.WHITE);
		add(dinero); 
		
		salir = new JButton(SALIR);
		salir.addActionListener(this);
		salir.setActionCommand(SALIR);
		salir.setBounds(30, 600, 200, 60);
		add(salir);
		
		laminaPrincipal = new JLabel();
	    ImageIcon icono = new ImageIcon("Archivos/imagenes/recursos/lamina.png");
	    laminaPrincipal.setIcon(icono);
	    laminaPrincipal.setBounds(530, 200, 240, 300);
	    add(laminaPrincipal);
	    
	    
	    ImageIcon icono1 = new ImageIcon("Archivos/imagenes/recursos/flecha.png");
	    flechaUno = new JLabel(icono1);
	    flechaUno.setBounds(800, 150, 480, 280);
	    add(flechaUno);
	    
	    ImageIcon icono2 = new ImageIcon("Archivos/imagenes/recursos/flecha2.png");
	    flechaDos = new JLabel(icono2);
	    flechaDos.setBounds(20, 150, 480, 280);
	    add(flechaDos);
		
	} 
	   
	public void paintComponent (Graphics g) {
		super.paintComponent(g);

		
		
			
			
		g.drawImage(FONDO, 0, 0, null);

		
	


		repaint();
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
