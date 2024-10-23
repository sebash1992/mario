package Vistas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import Entidades.EntidadLogica;
import Entidades.EntidadMario;

@SuppressWarnings("serial")
public class PantallaJuego extends JPanel{

	private JLabel imagenFondo;
	private JScrollPane scroll;
	private ControladorVistas controladorVistas;


	public PantallaJuego(ControladorVistas controladorVistas) {
		
		this.controladorVistas = controladorVistas;
		this.setPreferredSize(new Dimension(ConstantesVistas.ANCHO_FRAME, ConstantesVistas.ALTO_FRAME));
		this.setLayout(new BorderLayout());
		registrarOyenteTeclado();
		this.setDoubleBuffered(true); 
		this.setFocusable(true);
		this.requestFocusInWindow();
		agregarImagenFondo();

	}

	private void agregarImagenFondo() {

		imagenFondo = new JLabel(new ImageIcon(getClass().getResource("/imagenes/nuevoFondoJuego.jpg"))); 
		imagenFondo.setLayout(null);  
		imagenFondo.setBounds(0, 0, ConstantesVistas.ANCHO_FRAME, ConstantesVistas.ALTO_FRAME);
		this.add(imagenFondo);
		imagenFondo.revalidate();
		imagenFondo.repaint();

		JPanel panelImagen = new JPanel();
		panelImagen.add(imagenFondo);
		panelImagen.setPreferredSize(imagenFondo.getPreferredSize());

		scroll = new JScrollPane(panelImagen);
		scroll.setPreferredSize(new Dimension(ConstantesVistas.ANCHO_FRAME, ConstantesVistas.ALTO_FRAME));
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

		this.add(scroll);
	}
	
	private MostrandoRectangulo mrEntidad;//para ver los rectangulos
	private MostrandoRectangulo mrMario;//para ver los rectangulos
	JFrame frame1 = new JFrame();//para ver los rectangulos
	JFrame frame2 = new JFrame();//para ver los rectangulos
	
	public Observer agregarEntidad(EntidadLogica entidadLogica) {
		ObserverEntidades observerEntidad = new ObserverEntidades(entidadLogica);
		imagenFondo.add(observerEntidad);	
		
		
		mrEntidad = new MostrandoRectangulo(entidadLogica.obtenerSprite());//para ver los rectangulos
		frame1.add(mrEntidad);//para ver los rectangulos
		frame1.setSize(ConstantesVistas.ANCHO_FRAME, ConstantesVistas.ALTO_FRAME);//para ver los rectangulos
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//para ver los rectangulos
		frame1.setVisible(true);//para ver los rectangulos
		
		return observerEntidad;
	}


	
	public Observer agregarEntidadMario(EntidadMario entidadMario) {
		ObserverMario observerMario = new ObserverMario(this, entidadMario);
		imagenFondo.add(observerMario);
		
		mrMario = new MostrandoRectangulo(entidadMario.obtenerSprite());//para ver los rectangulos
		frame2.add(mrMario);//para ver los rectangulos
		frame2.setSize(ConstantesVistas.ANCHO_FRAME, ConstantesVistas.ALTO_FRAME);//para ver los rectangulos
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//para ver los rectangulos
		frame2.setVisible(true);//para ver los rectangulos
		
		return observerMario;
	}

	protected void actualizarScrollMario(EntidadMario marioObservado) {
		int posicionXdeMario = marioObservado.obtenerPosicionX(); 

		int pantallaAncho = scroll.getViewport().getWidth();
		int posicionDelScroll = scroll.getHorizontalScrollBar().getValue();
		int topeDelScroll = scroll.getHorizontalScrollBar().getMaximum();

	    // Si Mario se está acercando al borde derecho de la ventana visible
	    if (posicionXdeMario > posicionDelScroll + pantallaAncho - 400 && posicionDelScroll < topeDelScroll) {
	        scroll.getHorizontalScrollBar().setValue(posicionXdeMario - pantallaAncho + 400);
	    }
	}


	protected void registrarOyenteTeclado() {
		this.addKeyListener(new KeyListener() {

			public void keyTyped(KeyEvent e) {

			}
			public void keyPressed(KeyEvent e) {
				if(e.getKeyChar() == 'a') {
					controladorVistas.establecerDireccion('i');
				} 

				if(e.getKeyChar() == 'w') {
					controladorVistas.establecerDireccion('a');

				}

				if(e.getKeyChar() == 'd') {
					controladorVistas.establecerDireccion('d');
				}
			}
			public void keyReleased(KeyEvent e) {

				if(e.getKeyChar() == 'a') {
					controladorVistas.establecerDireccion('z');
				} 

				if(e.getKeyChar() == 'w') {
					controladorVistas.establecerDireccion('z');

				}

				if(e.getKeyChar() == 'd') {
					controladorVistas.establecerDireccion('z');
				}
			}
		});

	}

}



