package interfaz;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

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
	    
	    
	    
	    String ruta1 = "Archivos/imagenes/laminas/alemania/neuer.jpg";
	    BufferedImage imagen1 =  convertidor(ruta1);
	    ImageIcon icono1 = new ImageIcon(imagen1);
	    laminaUno= new JLabel(icono1);
	    laminaUno.setBounds(60, 150, 160, 220);
	   
	    add(laminaUno);
	    
	    String ruta2 = "Archivos/imagenes/laminas/alemania/boateng.jpg";
	    BufferedImage imagen2 =  convertidor(ruta2);
	    ImageIcon icono2 = new ImageIcon(imagen2);
	    laminaDos= new JLabel(icono2);
	    laminaDos.setBounds(260, 150, 160, 220);
	    add(laminaDos);
	    
	    String ruta3 = "Archivos/imagenes/laminas/alemania/hummels.jpg";
	    BufferedImage imagen3 =  convertidor(ruta3);
	    ImageIcon icono3 = new ImageIcon(imagen3);
	    laminaTres= new JLabel(icono3);
	    laminaTres.setBounds(460, 150, 160, 220);
	    add(laminaTres);
	    
	    String ruta4 = "Archivos/imagenes/laminas/alemania/khedira.jpg";
	    BufferedImage imagen4 =  convertidor(ruta4);
	    ImageIcon icono4 = new ImageIcon(imagen4);
	    laminaCuatro= new JLabel(icono4);
	    laminaCuatro.setBounds(660, 150, 160, 220);
	    add(laminaCuatro);
	    
	    
	    String ruta5 = "Archivos/imagenes/laminas/alemania/kroos.jpg";
	    BufferedImage imagen5 =  convertidor(ruta5);
	    ImageIcon icono5 = new ImageIcon(imagen5);
	    laminaCinco= new JLabel(icono5);
	    laminaCinco.setBounds(860, 150, 160, 220);
	    add(laminaCinco);

	    String ruta6 = "Archivos/imagenes/laminas/alemania/draxler.jpg";
	    BufferedImage imagen6 =  convertidor(ruta6);
	    ImageIcon icono6 = new ImageIcon(imagen6);
	    laminaSeis= new JLabel(icono6);
	    laminaSeis.setBounds(1060, 150, 160, 220);
	    add(laminaSeis);
	    
	    String ruta7 = "Archivos/imagenes/laminas/alemania/gotze.jpg";
	    BufferedImage imagen7 =  convertidor(ruta7);
	    ImageIcon icono7 = new ImageIcon(imagen7);
	    laminaSiete= new JLabel(icono7);
	    laminaSiete.setBounds(170, 390, 160, 220);
	    add(laminaSiete);
	    
	    String ruta8 = "Archivos/imagenes/laminas/alemania/muller.jpg";
	    BufferedImage imagen8 =  convertidor(ruta8);
	    ImageIcon icono8 = new ImageIcon(imagen8);
	    laminaOcho= new JLabel(icono8);
	    laminaOcho.setBounds(370, 390, 160, 220);
	    add(laminaOcho);
	    
	    
	    String ruta9 = "Archivos/imagenes/laminas/alemania/sane.jpg";
	    BufferedImage imagen9 =  convertidor(ruta9);
	    ImageIcon icono9 = new ImageIcon(imagen9);
	    laminaNueve= new JLabel(icono9);
	    laminaNueve.setBounds(570, 390, 160, 220);
	    add(laminaNueve);
	    
	    
	    String ruta10 = "Archivos/imagenes/laminas/alemania/ozil.jpg";
	    BufferedImage imagen10 =  convertidor(ruta10);
	    ImageIcon icono10 = new ImageIcon(imagen10);
	    laminaDiez= new JLabel(icono10);
	    laminaDiez.setBounds(770, 390, 160, 220);
	    add(laminaDiez);
	    
	    
	    String ruta11 = "Archivos/imagenes/laminas/alemania/werner.jpg";
	    BufferedImage imagen11 =  convertidor(ruta11);
	    ImageIcon icono11 = new ImageIcon(imagen11);
	    laminaOnce= new JLabel(icono11);
	    laminaOnce.setBounds(970, 390, 160, 220);
	    add(laminaOnce);
	    //dsa
       }

     public BufferedImage convertidor (String ruta) {
    	     
    	 File archivo = new File(ruta);
    	 BufferedImage  imgs = null;
    	 BufferedImage grayScaleImage = null;
    	  
    	 try {
    		 imgs = ImageIO.read(archivo);
    		 
    		 
    		  grayScaleImage = new BufferedImage(imgs.getWidth(), imgs.getHeight(), BufferedImage.TYPE_INT_ARGB);
    		 
    		 for(int i =0; i<imgs.getHeight(); i++) {
    			 for(int j =0; j<imgs.getWidth(); j++) {
    			
    				 Color c = new Color(imgs.getRGB(j, i));
    				 int r = c.getRed();
    				 int g = c.getGreen();
    				 int b = c.getBlue();
    				 int a = c.getAlpha();
    				 
    				 
    				 int gr = (r+g+b)/3;
    				 
    				 Color gColor = new Color(gr, gr, gr, a);
    				 grayScaleImage.setRGB(j, i, gColor.getRGB());
    			 }
    		 }
          
    	 }    catch(IOException e) {
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
		// TODO Auto-generated method stub
		
	}
	
	
	
}
