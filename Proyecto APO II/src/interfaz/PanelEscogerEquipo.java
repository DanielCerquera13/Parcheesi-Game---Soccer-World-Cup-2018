package interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelEscogerEquipo extends JPanel implements ActionListener, MouseListener{
	
	public final static String REGRESAR = "Regresar";
	public static final Image FONDO = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/fondoDos.png");
	
	
	private JButton btRegresar;

	private PanelInicial panelInicial;
	private JLabel lbtitulo;
	
	
	
	
	
	public  PanelEscogerEquipo(PanelInicial p) {
		
		panelInicial =p;
		setPreferredSize(new Dimension(300,400));
		setLayout(null);
		inicializarComponentes();
		
	}
	
	public void inicializarComponentes() {
		
		lbtitulo= new JLabel(" �Escoge tu selecci�n favorita! ");
		lbtitulo.setBounds(385, 100, 550, 80);
		lbtitulo.setFont(new Font(" Garamond ", 1, 35));
		lbtitulo.setForeground(Color.WHITE);
		add(lbtitulo);
		
		btRegresar = new JButton(REGRESAR);
		btRegresar.setBounds(1050, 650, 150, 40);
		btRegresar.setFont(new Font(" Garamond ", 1, 25));
		btRegresar.addActionListener(this);
		btRegresar.setActionCommand(REGRESAR);
		add(btRegresar);
	}
	
	
	public void paintComponent(Graphics g) {
		
		paintBackGround(g);

		
		//Fila 1
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/alemaniaRec.png").getImage(), 250,280,70,70,this);
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/arabia sauditaRec.png").getImage(), 350,280,70,70,this);
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/argentinaRec.png").getImage(), 450,280,70,70,this);
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/australiaRec.png").getImage(), 550,280,70,70,this);
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/belgicaRec.png").getImage(), 650,280,70,70,this);
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/brasilRec.png").getImage(), 750,280,70,70,this);
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/colombiaRec.png").getImage(), 850,280,70,70,this);
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/coreaRec.png").getImage(), 950,280,70,70,this);

		//fila 2
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/costa ricaRec.png").getImage(), 250,380,70,70,this);
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/croaciaRec.png").getImage(), 350,380,70,70,this);
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/dinamarcaRec.png").getImage(), 450,380,70,70,this);
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/egiptoRec.png").getImage(), 550,380,70,70,this);
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/espanaRec.png").getImage(), 650,380,70,70,this);
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/franciaRec.png").getImage(), 750,380,70,70,this);
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/inglaterraRec.png").getImage(), 850,380,70,70,this);
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/iranRec.png").getImage(), 950,380,70,70,this);

		//fila 3
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/islandiaRec.png").getImage(), 250,480,70,70,this);
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/japonRec.png").getImage(), 350,480,70,70,this);
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/marruecosRec.png").getImage(), 450,480,70,70,this);
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/mexicoRec.png").getImage(), 550,480,70,70,this);
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/nigeriaRec.png").getImage(), 650,480,70,70,this);
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/panamaRec.png").getImage(), 750,480,70,70,this);
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/peruRec.png").getImage(), 850,480,70,70,this);
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/poloniaRec.png").getImage(), 950,480,70,70,this);
		
		//fila 4
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/portugalRec.png").getImage(), 250,580,70,70,this);
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/rusiaRec.png").getImage(), 350,580,70,70,this);
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/senegalRec.png").getImage(), 450,580,70,70,this);
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/serbiaRec.png").getImage(), 550,580,70,70,this);
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/sueciaRec.png").getImage(), 650,580,70,70,this);
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/suizaRec.png").getImage(), 750,580,70,70,this);
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/tunezRec.png").getImage(), 850,580,70,70,this);
		g.drawImage(new ImageIcon("Archivos/imagenes/banderasRec/uruguayRec.png").getImage(), 950,580,70,70,this);



	}
	
	public void paintBackGround(Graphics g) {
		
		g.drawImage(FONDO,0,0, this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent comando) {
		if (comando.equals(REGRESAR)) {
			
			panelInicial.getVentana().remove(this);
			panelInicial.getVentana().add(panelInicial);
			panelInicial.getVentana().refresh();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		
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
