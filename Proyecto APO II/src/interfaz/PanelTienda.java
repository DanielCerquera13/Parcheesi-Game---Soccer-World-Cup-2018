package interfaz;

import javax.swing.*;

import modelo.Constantes;
import modelo.Jugador;
import modelo.Lamina;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class PanelTienda extends JPanel implements ActionListener, MouseListener,Constantes {
	
	public final static String SALIR = "SALIR";
	public final static String COMPRAR = "VOLVER A COMPRAR";

	public final static Image FONDO = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/fondoTienda.jpg");
	public final static Image MESSI_FONDO = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/messiFondo.png");
	
	private JLabel tienda;
	private JLabel laminaPrincipal;
	private JLabel dinero;
	private JButton salir;
	private JLabel flechaUno;
	private JLabel flechaDos;
	private JLabel flechaTres;
	private JLabel flechaCuatro;
	private JLabel messi;
	private JLabel flechaAbajo;
    private PanelInicio inicio;
    private JButton comprar;
    
	public PanelTienda (PanelInicio inicio) {
		 this.inicio = inicio;
		setLayout(null);
		//componentes();
		
		addMouseListener(this);
	}

	
	public void componentes () {
		   
		tienda = new JLabel("TIENDA DE LAMINAS");
		tienda.setBounds(510, 0, 320, 50);
		tienda.setFont(new Font(" Garamond ", 1, 30));
		tienda.setForeground(Color.BLACK);
		add(tienda);
		
		 int dinero1 = inicio.getVentana().getSesionActiva().getDinero();
		dinero = new JLabel(dinero1 + "$");
		dinero.setBounds(620, 500, 320, 60);
		dinero.setFont(new Font(" Garamond ", 1, 40));
		dinero.setForeground(Color.RED);
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
	    
	    
	    ImageIcon icono1 = new ImageIcon("Archivos/imagenes/recursos/flechaAbajo.png");
	    flechaAbajo = new JLabel(icono1);
	    flechaAbajo.setBounds(600, 45, 100, 150);
	    add(flechaAbajo);
//	    
//	    ImageIcon icono2 = new ImageIcon("Archivos/imagenes/recursos/flecha2.png");
//	    flechaDos = new JLabel(icono2);
//	    flechaDos.setBounds(20, 150, 480, 280);
//	    add(flechaDos);
		
	    
	    comprar = new JButton(COMPRAR);
	    comprar.addActionListener(this);
	    comprar.setActionCommand(COMPRAR);
	    comprar.setBounds(555, 580, 200, 60);
		add(comprar);
		
//		ImageIcon  iconoMessi = new ImageIcon("./Archivos/imagenes/recursos/messiFondo.png");
//		messi = new JLabel(iconoMessi);
//		messi.setBounds(860, 100, 405, 580);
//		add(messi);
	    
	} 
	//JSAHSDKAHDSJ   
	
	public void ganarLamina() {
		
		Jugador jugador = inicio.getVentana().getSesionActiva();

		Random ran = new Random();
        int numero = ran.nextInt(352);
       
        if(jugador.getDinero()>=100) {
        	int dinero = jugador.getDinero();
		Lamina laminaRandom = Constantes.lAMINAS[numero];
		jugador.agregarLamina(laminaRandom);	
	   ImageIcon icono = new ImageIcon(laminaRandom.getJugador());
		    laminaPrincipal.setIcon(icono);
		    laminaPrincipal.setBounds(580, 200, 240, 300);
		    
		    dinero = dinero - 100; 
		    jugador.setDinero(dinero);
		    
		    this.dinero.setText(jugador.getDinero() + " $");
        }
        
        else {
        	       
    	    ImageIcon icono1 = new ImageIcon("Archivos/imagenes/recursos/bancarrota.jpg");
        JLabel labeimagen = new JLabel(icono1);
    	     
        	//    JOptionPane.showMessageDialog(labeimagen, "USTED NO TIENE DINERO SUFICIENTE");
        	    JOptionPane.showMessageDialog(this, "NO TIENE DINERO SUFICIENTE", "BANCARROTA", 1, icono1);
        	    

        }
		    
		    
		
	}
	
	public void paintComponent (Graphics g) {
		super.paintComponent(g);

		
		
			
			
		g.drawImage(FONDO, 0, 0, null);

//		g.drawRect(550, 150, 280, 320);
//	
//		g.draw3DRect(550, 180, 220, 300, true);
		g.drawRoundRect(550, 220, 210, 260, 80, 80);

		repaint();
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
       String a = e.getActionCommand();
       
       if(a.equals(SALIR)) {
    	   inicio.getVentana().remove(this);
			inicio.getVentana().add(inicio);
			inicio.getVentana().refresh();
			
			
			  ImageIcon icono = new ImageIcon("Archivos/imagenes/recursos/lamina.png");
			    laminaPrincipal.setIcon(icono);
			    laminaPrincipal.setBounds(530, 200, 240, 300);
       }
       
       else if (a.equals(COMPRAR)) {
    	      
    	   ImageIcon icono = new ImageIcon("Archivos/imagenes/recursos/lamina.png");
   	    laminaPrincipal.setIcon(icono);
       }
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		
		System.out.println(e.getX());
		System.out.println(e.getY());
		if(e.getX()>530 && e.getX()<770 && e.getY()>200 && e.getY()<500) {
		System.out.println("holi");
		
		ganarLamina();
		inicio.getVentana().guardar();
		
		}
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
