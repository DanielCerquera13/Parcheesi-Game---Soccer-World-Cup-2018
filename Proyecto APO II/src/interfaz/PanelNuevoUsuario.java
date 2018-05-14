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

	private JPasswordField contrasenatxt;
	private JPasswordField contrasenaConfirmartxt;
	private JLabel nombre;
	private JTextField nombretxt;
	private JLabel contrasena;
	private JLabel contrasenaConfirmar;
	private JButton botonComenzar;
	private JButton botonRegresar;
	private VentanaPrincipal ven;

	public PanelNuevoUsuario(VentanaPrincipal ven) {

		this.ven = ven;
		setPreferredSize(new Dimension(1280,768));
		setLayout(null);

		inicializarComponentes();

		add(nombre);
		add(nombretxt);
		add(contrasena);
		add(contrasenatxt);
		add(contrasenaConfirmar);
		add(contrasenaConfirmartxt);
		add(botonComenzar);
		add(botonRegresar);

	}

	public void inicializarComponentes() {

		nombre = new JLabel(" Nombre ");
		nombre.setBounds(700, 100, 400, 80);
		nombre.setFont(new Font(" Garamond ", 1, 40));
		nombre.setForeground(Color.WHITE);

		nombretxt = new JTextField();
		nombretxt.setBounds(700, 200, 400, 80);
		nombretxt.setFont(new Font(" Garamond ", 1, 40));

		contrasena = new JLabel(" Contrase�a ");
		contrasena.setBounds(700, 300, 400, 80);
		contrasena.setFont(new Font(" Garamond ", 1, 40));
		contrasena.setForeground(Color.WHITE);

		contrasenatxt = new JPasswordField();
		contrasenatxt.setBounds(700, 400, 400, 80);
		contrasenatxt.setFont(new Font(" Garamond ", 1, 40));

		contrasenaConfirmar = new JLabel(" Confirmar contrase�a ");
		contrasenaConfirmar.setBounds(700, 500, 500, 80);
		contrasenaConfirmar.setFont(new Font(" Garamond ", 1, 40));
		contrasenaConfirmar.setForeground(Color.WHITE);

		contrasenaConfirmartxt = new JPasswordField();
		contrasenaConfirmartxt.setBounds(700, 600, 400, 80);
		contrasenaConfirmartxt.setFont(new Font(" Garamond ", 1, 40));

		botonComenzar = new JButton(COMENZAR);
		botonComenzar.setBounds(100, 350, 350, 50);
		botonComenzar.setFont(new Font(" Garamond ", 1, 40));
		botonComenzar.addActionListener(this);
		botonComenzar.setActionCommand(COMENZAR);

		// 136 330

		botonRegresar = new JButton(REGRESAR);
		botonRegresar.setBounds(100, 450, 350, 50);
		botonRegresar.setFont(new Font(" Garamond ", 1, 40));
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
		String comando = e.getActionCommand();

		if (comando.equals(REGRESAR)) {

			ven.remove(this);
			ven.add(ven.getPanelInicial());
			ven.refresh();
			// pruebaaaa
			// prueba
		}
	}
}
