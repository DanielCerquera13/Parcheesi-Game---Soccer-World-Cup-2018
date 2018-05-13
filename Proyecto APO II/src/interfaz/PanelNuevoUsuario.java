package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelNuevoUsuario extends JPanel implements ActionListener {
   
	public final static String REGRESAR = "REGRESAR";

	public final static String COMENZAR = "COMENZAR";
	public final static Image FONDO = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/fondoDos.png");

	private JPasswordField contraseñatxt;
	private JPasswordField contraseñaConfirmartxt;
	private JLabel nombre;
	private JTextField nombretxt;
	private JLabel contraseña;
	private JLabel contraseñaConfirmar;
	private JButton botonComenzar;
	private JButton botonRegresar;
	private VentanaPrincipal ven;
	public PanelNuevoUsuario(VentanaPrincipal ven) {
		
		this.ven = ven;
		
		
	   
		setLayout(null);
		
		inicializarComponentes();
		
		
		add(nombre);
		add(nombretxt);
		add(contraseña);
		add(contraseñatxt);
		add(contraseñaConfirmar);
		add(contraseñaConfirmartxt);
		add(botonComenzar);
		add(botonRegresar);

	
	}
	
	public void inicializarComponentes() {
		
		   nombre = new JLabel("Nombre");
	        nombre.setBounds(936, 180, 400, 80);
	        nombre.setFont(new Font("Garamond", 1, 40));
	        
	        nombretxt = new JTextField();
	        nombretxt.setBounds(936, 280, 400, 80);
	        nombretxt.setFont(new Font("Garamond", 1, 40));
	        
		
		contraseña = new JLabel("Contraseña");
		contraseña.setBounds(936, 380, 400, 80);
		contraseña.setFont(new Font("Garamond", 1, 40));
		
		

        contraseñatxt = new JPasswordField();
        contraseñatxt.setBounds(936, 480, 400, 80);
        contraseñatxt.setFont(new Font("Garamond", 1, 40));
        
        
        
        
		contraseñaConfirmar = new JLabel("Confirmar contraseña");
		contraseñaConfirmar.setBounds(936, 580, 500, 80);
		contraseñaConfirmar.setFont(new Font("Garamond", 1, 40));
		
     
        
		  contraseñaConfirmartxt = new JPasswordField();
	      contraseñaConfirmartxt.setBounds(936, 680, 400, 80);
	      contraseñaConfirmartxt.setFont(new Font("Garamond", 1, 40));
	        
	        
	        
	        
        botonComenzar = new JButton(COMENZAR);
        botonComenzar.setBounds(236, 500, 400, 80);
        botonComenzar.setFont(new Font("Garamond", 1, 40));
        botonComenzar.addActionListener(this);
        botonComenzar.setActionCommand(COMENZAR);
        
        //136 330
        
        botonRegresar = new JButton(REGRESAR);
        botonRegresar.setBounds(236, 700, 400, 80);
        botonRegresar.setFont(new Font("Garamond", 1, 40));
        botonRegresar.addActionListener(this);
        botonRegresar.setActionCommand(REGRESAR);
		
	}
	
	@Override
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
