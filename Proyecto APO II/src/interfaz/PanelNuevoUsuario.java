package interfaz;

import javax.swing.*;

import excepciones.ContrasenasNoCoincidenException;
import excepciones.UsuarioYaRegistradoException;
import modelo.Jugador;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelNuevoUsuario extends JPanel implements ActionListener {

	public final static String REGRESAR = "REGRESAR";

	public final static String CREAR = "CREAR";
	public final static Image FONDO = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/fondoDos.png");

	private PanelInicial inicial;
	private JPasswordField contrasenatxt;
	private JPasswordField contrasenaConfirmartxt;
	private JLabel nombre;
	private JTextField nombretxt;
	private JLabel contrasena;
	private JLabel contrasenaConfirmar;
	private JButton botonCrear;
	private JButton botonRegresar;

	public PanelNuevoUsuario(PanelInicial inicial) {

		this.inicial = inicial;
		setPreferredSize(new Dimension(1100, 690));
		setLayout(null);

		inicializarComponentes();

		add(nombre);
		add(nombretxt);
		add(contrasena);
		add(contrasenatxt);
		add(contrasenaConfirmar);
		add(contrasenaConfirmartxt);
		add(botonCrear);
		add(botonRegresar);

	}

	public void inicializarComponentes() {

		nombre = new JLabel(" Nombre ");
		nombre.setBounds(700, 140, 320, 60);
		nombre.setFont(new Font(" Garamond ", 1, 26));
		nombre.setForeground(Color.WHITE);

		nombretxt = new JTextField();
		nombretxt.setBounds(700, 210, 320, 40);
		nombretxt.setFont(new Font(" Garamond ", 1, 26));

		contrasena = new JLabel(" Contraseña ");
		contrasena.setBounds(700, 330, 320, 60);
		contrasena.setFont(new Font(" Garamond ", 1, 26));
		contrasena.setForeground(Color.WHITE);

		contrasenatxt = new JPasswordField();
		contrasenatxt.setBounds(700, 390, 320, 40);
		contrasenatxt.setFont(new Font(" Garamond ", 1, 26));

		contrasenaConfirmar = new JLabel(" Confirmar contraseña ");
		contrasenaConfirmar.setBounds(700, 510, 320, 60);
		contrasenaConfirmar.setFont(new Font(" Garamond ", 1, 26));
		contrasenaConfirmar.setForeground(Color.WHITE);

		contrasenaConfirmartxt = new JPasswordField();
		contrasenaConfirmartxt.setBounds(700, 570, 320, 40);
		contrasenaConfirmartxt.setFont(new Font(" Garamond ", 1, 26));

		botonCrear = new JButton(CREAR);
		botonCrear.setBounds(100, 350, 330, 40);
		botonCrear.setFont(new Font(" Garamond ", 1, 30));
		botonCrear.addActionListener(this);
		botonCrear.setActionCommand(CREAR);

		botonRegresar = new JButton(REGRESAR);
		botonRegresar.setBounds(100, 450, 330, 40);
		botonRegresar.setFont(new Font(" Garamond ", 1, 30));
		botonRegresar.addActionListener(this);
		botonRegresar.setActionCommand(REGRESAR);

	}

	public JTextField getNombreTxt() {

		return nombretxt;

	}

	public String getContrasenatxt() {
		return String.valueOf(contrasenatxt.getPassword());
	}

	public String getContrasenaConfirmarTxt() {

		return String.valueOf(contrasenaConfirmartxt.getPassword());

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

			inicial.getVentana().remove(this);
			inicial.getVentana().add(inicial);
			inicial.getVentana().refresh();

			nombretxt.setText("");
			contrasenatxt.setText("");
			contrasenaConfirmartxt.setText("");

		}

		if (comando.equals(CREAR)) {

			if (nombretxt.getText() == null || nombretxt.getText().equals("")) {

				JOptionPane.showMessageDialog(null, "El nickname debe contener al menos un caracter");

			} else {
				if ((getContrasenatxt() == null || getContrasenatxt().equals(""))
						&& (getContrasenaConfirmarTxt() == null || getContrasenaConfirmarTxt().equals(""))) {

					JOptionPane.showMessageDialog(null, "La contraseña debe contener al menos un caracter");

				} else {

					if (getContrasenatxt().equalsIgnoreCase(getContrasenaConfirmarTxt())) {

						Jugador nuevo = new Jugador(getNombreTxt().getText(), getContrasenatxt());

						try {
							inicial.getVentana().agregarUsuario(nuevo);

							nombretxt.setText("");
							contrasenatxt.setText("");
							contrasenaConfirmartxt.setText("");

							inicial.getVentana().remove(this);
							inicial.getVentana().add(inicial);
							inicial.getVentana().refresh();

						} catch (UsuarioYaRegistradoException ex) {

							JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}

					} else {

						contrasenatxt.setText("");
						contrasenaConfirmartxt.setText("");

						try {
							throw new ContrasenasNoCoincidenException();
						} catch (ContrasenasNoCoincidenException ex) {

							JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

						}

					}

				}
			}
		}
	}
}
