package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaIniciarSesion extends JPanel implements ActionListener{
    
	public final static String PRUEBA = "prueba";
	
	private VentanaPrincipal ventana;
	
	public VentanaIniciarSesion(VentanaPrincipal window) {
		
	ventana = window;	
		
	setLayout(new GridLayout());
	
	JButton prueba = new JButton("PRUEBA");
	
	prueba.setActionCommand(PRUEBA);
	prueba.addActionListener(this);
	
	add(prueba);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();
		
		if(comando.equals(PRUEBA)) {
			
		ventana.remove(this);
		ventana.add(ventana.getAux());
		ventana.refresh();
			
		}
		
	}
}
