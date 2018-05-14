package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPanini extends JPanel implements ActionListener{
   
	
	public final static String ANTERIOR = "ANTERIOR";
	public final static String SIGUIENTE = "SIGUIENTE";
	public final static String SALIR = "SALIR";
	
	private JButton salir;
	private JButton anterior;
	private JButton siguiente;
	private JLabel bandera;
	private JLabel nombre;
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
    	   salir.setBounds(80, 700, 330, 40);
   	   salir.setFont(new Font(" Garamond ", 1, 30));
   	   add(salir);
   	   
   	   anterior = new JButton(ANTERIOR);
   	   anterior.addActionListener(this);
   	   anterior.setActionCommand(ANTERIOR);
      	anterior.setBounds(80, 600, 330, 40);
	    anterior.setFont(new Font(" Garamond ", 1, 30));
	    add(anterior);
	    
	    siguiente = new JButton(SIGUIENTE);
	    siguiente.addActionListener(this);
	    siguiente.setActionCommand(SIGUIENTE);
		siguiente.setBounds(900, 600, 330, 40);
	    siguiente.setFont(new Font(" Garamond ", 1, 30));
<<<<<<< HEAD
   	     
	    bandera = new JLabel();
=======
   	   add(siguiente);
>>>>>>> branch 'master' of https://github.com/JavaCracks/proyectoFinal.git
	    
       }


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
