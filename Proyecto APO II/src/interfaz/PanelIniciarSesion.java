package interfaz;

import javax.swing.*;

import excepciones.ContrasenaIncorrectaException;
import excepciones.UsuarioNoRegistradoException;
import modelo.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelIniciarSesion extends JPanel implements ActionListener {

	public final static Image FONDO = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/fondoDos.png");
	public final static Image COPA = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/copaMundo.png");
	public final static String INICIAR = "iniciar";
	public final static String CANCELAR = "cancelar";

	private PanelInicial inicial;
	private PanelInicio inicio;
	private JLabel labUsuario;
	private JLabel contrasena;
	private JTextField txtUsuario;
	private JPasswordField pass;
	private JButton butIniciar;
	private JButton butCancelar;

	public PanelIniciarSesion(PanelInicial inicial) {

		this.inicial = inicial;

		inicio = new PanelInicio(this);

		setLayout(null);

		ajustarComponentes();

	}

	public void ajustarComponentes() {

		Font fuente = new Font("Garamond", 1, 30);
		Font fuenteBoton = new Font("Garamond", 1, 24);

		labUsuario = new JLabel("Usuario");
		labUsuario.setFont(fuente);
		labUsuario.setForeground(Color.WHITE);
		labUsuario.setBounds(125, 265, 400, 40);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(125, 300, 400, 40);
		txtUsuario.setFont(fuente);

		contrasena = new JLabel("Contraseña");
		contrasena.setFont(fuente);
		contrasena.setForeground(Color.WHITE);
		contrasena.setBounds(125, 365, 400, 40);

		pass = new JPasswordField();
		pass.setFont(fuente);
		pass.setBounds(125, 400, 400, 40);

		butIniciar = new JButton("Iniciar");
		butIniciar.setActionCommand(INICIAR);
		butIniciar.addActionListener(this);
		butIniciar.setFont(fuenteBoton);
		butIniciar.setBounds(125, 480, 180, 40);

		butCancelar = new JButton("Cancelar");
		butCancelar.setFont(fuenteBoton);
		butCancelar.setActionCommand(CANCELAR);
		butCancelar.addActionListener(this);
		butCancelar.setBounds(340, 480, 180, 40);

		add(labUsuario);
		add(txtUsuario);
		add(contrasena);
		add(pass);
		add(butIniciar);
		add(butCancelar);

	}

	public VentanaPrincipal getVentana() {

		return inicial.getVentana();

	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		g.drawImage(FONDO, 0, 0, null);
		g.drawImage(COPA, 800, 35, null);

		repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals(CANCELAR)) {

			inicial.getVentana().remove(this);
			inicial.getVentana().add(inicial);
			inicial.getVentana().refresh();

		}

		if (comando.equals(INICIAR)) {

			
			
			if (inicial.getVentana().getParquesMundial().yaExiste(txtUsuario.getText())) {

				Jugador actual = null;

				try {
					actual = inicial.getVentana().buscarUsuario(txtUsuario.getText());
					String contra = String.valueOf(pass.getPassword());

					if (actual.getContrasena().equalsIgnoreCase(contra)) {

						inicial.getVentana().remove(this);
						inicial.getVentana().add(inicio);
						inicial.getVentana().refresh();
						inicial.getVentana().setSesionActiva(actual);

						txtUsuario.setText("");
						pass.setText("");

					} else {

						try {
							throw new ContrasenaIncorrectaException();
						} catch (ContrasenaIncorrectaException ex) {

							JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}

					}

				} catch (UsuarioNoRegistradoException ex) {

					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				}

			}else {
				
			try {
				throw new UsuarioNoRegistradoException(txtUsuario.getText());
			} catch (UsuarioNoRegistradoException ex) {
				
				JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}	
				
				
			}

		}

	}
}
