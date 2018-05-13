package interfaz;

import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelIniciarSesion extends JPanel implements ActionListener {

	
	public final static Image FONDO = Toolkit.getDefaultToolkit().createImage("./Archivos/imagenes/recursos/fondoDos.png");
	public final static String INICIAR = "iniciar";
	public final static String CANCELAR = "cancelar";

	private VentanaPrincipal ventana;
	private JLabel labUsuario;
	private JLabel contrasena;
	private JTextField txtUsuario;
	private JPasswordField pass;
	private JButton butIniciar;
	private JButton butCancelar;

	public PanelIniciarSesion(VentanaPrincipal window) {

		ventana = window;

		setLayout(null);
		
		ajustarComponentes();

	}

	public void ajustarComponentes() {

		Font fuente = new Font("Garamond", 1, 60);
	
		
		labUsuario = new JLabel("Usuario");
		labUsuario.setFont(fuente);
		labUsuario.setForeground(Color.WHITE);
		labUsuario.setBounds(136, 330, 400, 80);	
		
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(136, 400, 400, 80);
		txtUsuario.setFont(fuente);
		
		contrasena = new JLabel("Contraseņa");
		contrasena.setFont(fuente);
		contrasena.setForeground(Color.WHITE);
		contrasena.setBounds(136, 530, 400, 80);
		
		
		pass = new JPasswordField();
		pass.setFont(fuente);
		pass.setBounds(136, 600, 400, 80);
		
		
		butIniciar = new JButton("Iniciar");
		butIniciar.setActionCommand(INICIAR);
		butIniciar.addActionListener(this);
		butIniciar.setFont(fuente);
		butIniciar.setBounds(375, 720, 180, 80);
		
		butCancelar = new JButton("Cancelar");
		butCancelar.setFont(fuente);
		butCancelar.setActionCommand(CANCELAR);
		butCancelar.addActionListener(this);
		butIniciar.setBounds(136, 720, 180, 80);
		
		add(labUsuario);
		add(txtUsuario);
		add(contrasena);
		add(pass);
		add(butIniciar);
		add(butCancelar);
		
		
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		
		g.drawImage(FONDO, 0, 0, null);
		
		repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals(INICIAR)) {

			ventana.remove(this);
			ventana.add(ventana.getAux());
			ventana.refresh();

		}

	}
}
