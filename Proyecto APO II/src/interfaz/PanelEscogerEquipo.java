package interfaz;

import javax.swing.*;

import modelo.Equipo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PanelEscogerEquipo extends JPanel implements ActionListener, MouseListener{
	
	public final static String REGRESAR= "Regresar";
	public static final Image FONDO = Toolkit.getDefaultToolkit()
			.createImage("./Archivos/imagenes/recursos/fondoDos.png");
	
	
	private JButton btRegresar;
	private PanelInicial panelInicial;
	private JLabel lbtitulo;
	private PanelEscogerTipoDeJuego panelEscogerJuego;
	
	
	
	
	
	public  PanelEscogerEquipo(PanelInicial p) {
		
		panelInicial =p;
		setPreferredSize(new Dimension(280,400));
		setLayout(null);
		panelEscogerJuego=new PanelEscogerTipoDeJuego(panelInicial);
		
		inicializarComponentes();
		addMouseListener(this);
		
	}
	
	public void inicializarComponentes() {
		
		lbtitulo= new JLabel(" ¡Escoge tu selección favorita! ");
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
	public void actionPerformed(ActionEvent e) {
		String comando=e.getActionCommand();
		if (comando.equals(REGRESAR)) {
			
			panelInicial.getVentana().remove(this);
			panelInicial.getVentana().add(panelEscogerJuego);
			panelInicial.getVentana().refresh();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
		if((e.getX()>=250 && e.getX()<=320)&&(e.getY()>=280 && e.getY()<=350)) {
			String ruta="Archivos/imagenes/banderasRec/alemaniaRec.png";
			String seleccion="ALEMANIA";
			Equipo alemania=null;
		}
		
		if((e.getX()>=350 && e.getX()<=420)&&(e.getY()>=280 && e.getY()<=350)) {
			String ruta="Archivos/imagenes/banderasRec/arabia sauditaRec.png";
			String seleccion="ARABIA SAUDITA";
			Equipo arabia=null;
		}
		
		if((e.getX()>=450 && e.getX()<=520)&&(e.getY()>=280 && e.getY()<=350)) {
			String ruta="Archivos/imagenes/banderasRec/argentinaRec.png";
			String seleccion="ARGENTINA";
			Equipo argentina=null;
			
		}
		
		if((e.getX()>=550 && e.getX()<=620)&&(e.getY()>=280 && e.getY()<=350)) {
			String ruta="Archivos/imagenes/banderasRec/australiaRec.png";
			String seleccion="AUSTRALIA";
			Equipo australia=null;
			
		}
		
		if((e.getX()>=650 && e.getX()<=720)&&(e.getY()>=280 && e.getY()<=350)) {
			String ruta="Archivos/imagenes/banderasRec/belgicaRec.png";
			String seleccion="BELGICA";
			Equipo belgica=null;
		}
		
		if((e.getX()>=750 && e.getX()<=820)&&(e.getY()>=280 && e.getY()<=350)) {
			String ruta="Archivos/imagenes/banderasRec/brasilRec.png";
			String seleccion="BRASIL";
			Equipo brasil=null;
			
		}
		
		if((e.getX()>=850 && e.getX()<=920)&&(e.getY()>=280 && e.getY()<=350)) {
			String ruta="Archivos/imagenes/banderasRec/colombiaRec.png";
			String seleccion="COLOMBIA";
			Equipo colombia=null;
		
		}
		
		if((e.getX()>=950 && e.getX()<=1020)&&(e.getY()>=280 && e.getY()<=350)) {
			String ruta="Archivos/imagenes/banderasRec/coreaRec.png";
			String seleccion="COREA DEL SUR";
			Equipo corea=null;
			
		}
		
		if((e.getX()>=250 && e.getX()<=320)&&(e.getY()>=380 && e.getY()<=450)) {
			String ruta="Archivos/imagenes/banderasRec/costa ricaRec.png";
			String seleccion="COSTA RICA";
			Equipo costa=null;
			
		}
		
		if((e.getX()>=350 && e.getX()<=420)&&(e.getY()>=380 && e.getY()<=450)) {
			String ruta="Archivos/imagenes/banderasRec/croaciaRec.png";
			String seleccion="CROACIA";
			Equipo croacia=null;
			
		}
		
		if((e.getX()>=450 && e.getX()<=520)&&(e.getY()>=380 && e.getY()<=450)) {
			String ruta="Archivos/imagenes/banderasRec/dinamarcaRec.png";
			String seleccion="DINAMARCA";
			Equipo dinamarca=null;
			
		}
		
		if((e.getX()>=550 && e.getX()<=620)&&(e.getY()>=380 && e.getY()<=450)) {
			String ruta="Archivos/imagenes/banderasRec/egiptoRec.png";
			String seleccion="EGIPTO";
			Equipo egipto=null;
			
		}
		
		if((e.getX()>=650 && e.getX()<=720)&&(e.getY()>=380 && e.getY()<=450)) {
			String ruta="Archivos/imagenes/banderasRec/espanaRec.png";
			String seleccion="ESPAÑA";
			Equipo espana=null;
			
		}
		
		if((e.getX()>=750 && e.getX()<=820)&&(e.getY()>=380 && e.getY()<=450)) {
			String ruta="Archivos/imagenes/banderasRec/franciaRec.png";
			String seleccion="FRANCIA";
			Equipo francia=null;
	
		}
		
		if((e.getX()>=850 && e.getX()<=920)&&(e.getY()>=380 && e.getY()<=450)) {
			String ruta="Archivos/imagenes/banderasRec/inglaterraRec.png";
			String seleccion="INGLATERRA";
			Equipo inglaterra=null;
			
		}
		
		if((e.getX()>=950 && e.getX()<=1020)&&(e.getY()>=380 && e.getY()<=450)) {
			String ruta="Archivos/imagenes/banderasRec/iranRec.png";
			String seleccion="IRAN";
			Equipo iran=null;
			
		}
		
		if((e.getX()>=250 && e.getX()<=320)&&(e.getY()>=480 && e.getY()<=550)) {
			String ruta="Archivos/imagenes/banderasRec/irlandaRec.png";
			String seleccion="IRLANDA";
			Equipo irlanda=null;
			
		}
		
		if((e.getX()>=350 && e.getX()<=420)&&(e.getY()>=480 && e.getY()<=550)) {
			String ruta="Archivos/imagenes/banderasRec/japonRec.png";
			String seleccion="JAPON";
			Equipo japon=null;
			
		}
		
		if((e.getX()>=450 && e.getX()<=520)&&(e.getY()>=480 && e.getY()<=550)) {
			String ruta="Archivos/imagenes/banderasRec/marruecosRec.png";
			String seleccion="MARRUECOS";
			Equipo marruecos=null;
			
		}
		
		if((e.getX()>=550 && e.getX()<=620)&&(e.getY()>=480 && e.getY()<=550)) {
			String ruta="Archivos/imagenes/banderasRec/mexicoRec.png";
			String seleccion="MEXICO";
			Equipo mexico=null;
			
		}
		
		if((e.getX()>=650 && e.getX()<=720)&&(e.getY()>=480 && e.getY()<=550)) {
			String ruta="Archivos/imagenes/banderasRec/nigeriaRec.png";
			String seleccion="NIGERIA";
			Equipo nigeria=null;
			
		}
		
		if((e.getX()>=750 && e.getX()<=820)&&(e.getY()>=480 && e.getY()<=550)) {
			String ruta="Archivos/imagenes/banderasRec/panamaRec.png";
			String seleccion="PANAMA";
			Equipo panama=null;
			
		}
		
		if((e.getX()>=850 && e.getX()<=920)&&(e.getY()>=480 && e.getY()<=550)) {
			String ruta="Archivos/imagenes/banderasRec/peruRec.png";
			String seleccion="PERU";
			Equipo peru=null;
			
		}
		
		if((e.getX()>=950 && e.getX()<=1020)&&(e.getY()>=480 && e.getY()<=550)) {
			String ruta="Archivos/imagenes/banderasRec/poloniaRec.png";
			String seleccion="POLONIA";
			Equipo polonia=null;
			
		}
		
		if((e.getX()>=250 && e.getX()<=320)&&(e.getY()>=580 && e.getY()<=650)) {
			String ruta="Archivos/imagenes/banderasRec/portugalRec.png";
			String seleccion="PORTUGAL";
			Equipo portugal=null;
			
		}
		
		if((e.getX()>=350 && e.getX()<=420)&&(e.getY()>=580 && e.getY()<=650)) {
			String ruta="Archivos/imagenes/banderasRec/rusiaRec.png";
			String seleccion="RUSIA";
			Equipo rusia=null;
			
		}
		
		if((e.getX()>=450 && e.getX()<=520)&&(e.getY()>=580 && e.getY()<=650)) {
			String ruta="Archivos/imagenes/banderasRec/senegalRec.png";
			String seleccion="SENEGAL";
			Equipo senegal=null;
			
		}
		
		if((e.getX()>=550 && e.getX()<=620)&&(e.getY()>=580 && e.getY()<=650)) {
			String ruta="Archivos/imagenes/banderasRec/serbiaRec.png";
			String seleccion="SERBIA";
			Equipo serbia=null;
			
		}
		
		if((e.getX()>=650 && e.getX()<=720)&&(e.getY()>=580 && e.getY()<=650)) {
			String ruta="Archivos/imagenes/banderasRec/sueciaRec.png";
			String seleccion="SUECIA";
			Equipo suecia=null;
			
		}
		
		if((e.getX()>=750 && e.getX()<=820)&&(e.getY()>=580 && e.getY()<=650)) {
			String ruta="Archivos/imagenes/banderasRec/suizaRec.png";
			String seleccion="SUIZA";
			Equipo suiza=null;
			
		}
		
		if((e.getX()>=850 && e.getX()<=920)&&(e.getY()>=580 && e.getY()<=650)) {
			String ruta="Archivos/imagenes/banderasRec/turquiaRec.png";
			String seleccion="TURQUIA";
			Equipo turquia=null;
			
		}
		
		if((e.getX()>=950 && e.getX()<=1020)&&(e.getY()>=580 && e.getY()<=650)) {
			String ruta="Archivos/imagenes/banderasRec/uruguayRec.png";
			String seleccion="URUGUAY";
			Equipo uruguay=null;
			System.out.println("URUGUAY");
		}
		
		
		
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
