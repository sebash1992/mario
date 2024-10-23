package Vistas;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PantallaInicial extends JPanel {


	private ControladorVistas controladorVistas;
	private JLabel imagenFondo;
	private JButton botonJugar;
	private JButton botonModoOriginal;
	private JButton botonModoSustituto;
	private JButton botonRanking;



	public PantallaInicial(ControladorVistas controlador) {
		this.controladorVistas=controlador;
		this.setPreferredSize(new Dimension(ConstantesVistas.ANCHO_FRAME, ConstantesVistas.ALTO_FRAME));	
		this.setLayout(null);

		agregarImagenFondo();
		agregarBotonIniciar();
		agregarBotonRanking();
		//registrarOyenteBotonRanking
		registrarOyenteBotonJugar();
	}

	private void agregarBotonIniciar() {

		botonJugar = new JButton("Jugar");
		botonJugar.setBounds(300, 355, 130, 50);
		imagenFondo.add(botonJugar);
		botonJugar.revalidate();
		botonJugar.repaint();

		ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/botonJugar.png"));
		botonJugar.setIcon(icono);

	}

	private void agregarBotonRanking() {

		botonRanking = new JButton("Ranking");
		botonRanking.setBounds(300, 420, 130, 50);
		imagenFondo.add(botonRanking);
		botonRanking.revalidate();
		botonRanking.repaint();

		ImageIcon icono = new ImageIcon(getClass().getResource("/imagenes/botonRanking.png"));
		botonRanking.setIcon(icono);

	}

	private void agregarImagenFondo() {

		imagenFondo = new JLabel(new ImageIcon(getClass().getResource("/imagenes/FondoPantallaInicial1.jpg"))); 
		imagenFondo.setLayout(null);  
		imagenFondo.setBounds(0, 0, ConstantesVistas.ANCHO_FRAME, ConstantesVistas.ALTO_FRAME);
		this.add(imagenFondo);

	}

	private void registrarOyenteBotonJugar() {
		botonJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controladorVistas.iniciarJuego();
			}
		});

	}
}
