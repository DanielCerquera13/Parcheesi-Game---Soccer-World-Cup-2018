package interfaz;

import javax.swing.*;
import java.awt.*;
import modelo.*;

public class PanelParques extends JPanel {

	private PanelInicio inicio;

	// Componentes para pintar el parques
	private JPanel carcelUno;
	private JPanel carcelDos;
	private JPanel carcelTres;
	private JPanel carcelCuatro;

	private JPanel elCentro;

	private JPanel zonaUno;
	private JPanel zonaDos;
	private JPanel zonaTres;
	private JPanel zonaCuatro;

	private JButton[][] zonaUnoBut;
	private JButton[][] zonaDosBut;
	private JButton[][] zonaTresBut;
	private JButton[][] zonaCuatroBut;

	public PanelParques(PanelInicio inicio) {

		this.inicio = inicio;

		setLayout(new GridLayout(3, 3));

		inicializarTablero();
		refresh();
		
		
		add(carcelCuatro);
		add(zonaCuatro);
		add(carcelTres);
		add(zonaUno);
		add(elCentro);
		add(zonaTres);
		add(carcelUno);
		add(zonaDos);
		add(carcelDos);
		
		
	}

	public void inicializarTablero() {

		carcelUno = new JPanel();
		carcelDos = new JPanel();
		carcelTres = new JPanel();
		carcelCuatro = new JPanel();

		zonaUno = new JPanel();
		zonaUno.setLayout(new GridLayout(3, 8));

		zonaDos = new JPanel();
		zonaDos.setLayout(new GridLayout(8, 3));

		zonaTres = new JPanel();
		zonaTres.setLayout(new GridLayout(3, 8));

		zonaCuatro = new JPanel();
		zonaCuatro.setLayout(new GridLayout(8, 3));

		elCentro = new JPanel();

		zonaUnoBut = new JButton[3][8];
		zonaDosBut = new JButton[8][3];
		zonaTresBut = new JButton[3][8];
		zonaCuatroBut = new JButton[8][3];
		
		
		
		rellenarTablero();

	}

	public void rellenarTablero() {

		Casilla[][] zonaUnoC = inicio.getVentana().getZonaUno();
		Casilla[][] zonaDosC = inicio.getVentana().getZonaDos();
		Casilla[][] zonaTresC = inicio.getVentana().getZonaTres();
		Casilla[][] zonaCuatroC = inicio.getVentana().getZonaCuatro();

		// Rellena la zona Uno
		for (int i = 0; i < zonaUnoBut.length; i++) {
			for (int j = 0; j < zonaUnoBut[0].length; j++) {

				zonaUnoBut[i][j] = new JButton(zonaUnoC[i][j].toString());
				zonaUnoBut[i][j].setOpaque(true);
				
				zonaTresBut[i][j] = new JButton(zonaTresC[i][j].toString());
				zonaTresBut[i][j].setOpaque(true);

				zonaUno.add(zonaUnoBut[i][j]);
				zonaTres.add(zonaTresBut[i][j]);
				

			}

		}
		
		
		for(int i=0; i<zonaDosBut.length;i++) {
			
			for(int j=0; j<zonaDosBut[0].length;j++) {
				
			zonaDosBut[i][j] = new JButton(zonaDosC[i][j].toString());
			zonaDosBut[i][j].setOpaque(true);
			
			
			zonaCuatroBut[i][j] = new JButton(zonaCuatroC[i][j].toString());
			zonaCuatroBut[i][j].setOpaque(true);
			
			zonaDos.add(zonaDosBut[i][j]);
			zonaCuatro.add(zonaCuatroBut[i][j]);
			
				
			}
			
			
		}
		

	}

	public void refresh() {

		invalidate();
		revalidate();
		repaint();

	}

}
