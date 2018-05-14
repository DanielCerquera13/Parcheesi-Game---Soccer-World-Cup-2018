package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPanini extends JPanel implements ActionListener{
   
	public final static Image FONDO = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/fondoPrincipal.jpg");
	
	
	public final static String ANTERIOR = "ANTERIOR";
	public final static String SIGUIENTE = "SIGUIENTE";
	public final static String SALIR = "SALIR";
	
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

	
	
	public PanelPanini() {
		 
		setLayout(null);
		componentes();
		
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
	    bandera.setBounds(30,30,100,100);
	    ImageIcon icono = new ImageIcon("Archivos/imagenes/banderasRec/AlemaniaRec.png");
	    bandera.setIcon(icono);
	    add(bandera); 
	    
	    nombre = new JLabel("Alemania");
	    nombre.setBounds(160, 45, 320, 60);
	    nombre.setFont(new Font(" Garamond ", 1, 26));
	    nombre.setForeground(Color.WHITE);
	    add(nombre);

	    
	    grupo = new JLabel("GRUPO F");
	    grupo.setBounds(1000, 45, 300, 60);
	    grupo.setFont(new Font(" Garamond ", 1, 40));
	    grupo.setForeground(Color.WHITE);
	    add(grupo);
	    
	    ImageIcon imagen1 = new ImageIcon("Archivos/imagenes/laminas/alemania/neuer.jpg");
	    laminaUno= new JLabel(imagen1);
	    laminaUno.setBounds(60, 150, 160, 220);
	    add(laminaUno);
	    
	    ImageIcon imagen2 = new ImageIcon("Archivos/imagenes/laminas/alemania/boateng.jpg");
	    laminaDos= new JLabel(imagen2);
	    laminaDos.setBounds(260, 150, 160, 220);
	    add(laminaDos);
	    
	    ImageIcon imagen3 = new ImageIcon("Archivos/imagenes/laminas/alemania/hummels.jpg");
	    laminaTres= new JLabel(imagen3);
	    laminaTres.setBounds(460, 150, 160, 220);
	    add(laminaTres);
	    
	    ImageIcon imagen4 = new ImageIcon("Archivos/imagenes/laminas/alemania/khedira.jpg");
	    laminaCuatro= new JLabel(imagen4);
	    laminaCuatro.setBounds(660, 150, 160, 220);
	    add(laminaCuatro);
	    
	    
	    ImageIcon imagen5 = new ImageIcon("Archivos/imagenes/laminas/alemania/kroos.jpg");
	    laminaCinco= new JLabel(imagen5);
	    laminaCinco.setBounds(860, 150, 160, 220);
	    add(laminaCinco);
	    
	    ImageIcon imagen6 = new ImageIcon("Archivos/imagenes/laminas/alemania/draxler.jpg");
	    laminaSeis= new JLabel(imagen6);
	    laminaSeis.setBounds(1060, 150, 160, 220);
	    add(laminaSeis);
	    
	    ImageIcon imagen7 = new ImageIcon("Archivos/imagenes/laminas/alemania/gotze.jpg");
	    laminaSiete= new JLabel(imagen7);
	    laminaSiete.setBounds(170, 390, 160, 220);
	    add(laminaSiete);
	    
	    ImageIcon imagen8 = new ImageIcon("Archivos/imagenes/laminas/alemania/muller.jpg");
	    laminaOcho= new JLabel(imagen8);
	    laminaOcho.setBounds(370, 390, 160, 220);
	    add(laminaOcho);
	    
	    
	    ImageIcon imagen9 = new ImageIcon("Archivos/imagenes/laminas/alemania/sane.jpg");
	    laminaNueve= new JLabel(imagen9);
	    laminaNueve.setBounds(570, 390, 160, 220);
	    add(laminaNueve);
	    
	    
	    ImageIcon imagen10 = new ImageIcon("Archivos/imagenes/laminas/alemania/ozil.jpg");
	    laminaDiez= new JLabel(imagen10);
	    laminaDiez.setBounds(770, 390, 160, 220);
	    add(laminaDiez);
	    
	    
	    ImageIcon imagen11 = new ImageIcon("Archivos/imagenes/laminas/alemania/werner.jpg");
	    laminaOnce= new JLabel(imagen11);
	    laminaOnce.setBounds(970, 390, 160, 220);
	    add(laminaOnce);
       }

     
       public void paintComponent(Graphics g) {
    	   
    		super.paintComponent(g);

    		g.drawImage(FONDO, 0, 0, null);

    		repaint();
       }
       
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
