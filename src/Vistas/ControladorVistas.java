package Vistas;

import javax.swing.JFrame;

import Entidades.EntidadLogica;
import Entidades.EntidadMario;
import Juego.Juego;

public class ControladorVistas {

	protected JFrame frame;
	private Juego juego;
	private PantallaInicial pantallaInicial;
	private PantallaJuego pantallaJuego;

	public ControladorVistas(Juego juego) {
		this.juego=juego;
		pantallaInicial= new PantallaInicial(this);
		pantallaJuego= new PantallaJuego(this);
		crearFrame();

	}

	private void crearFrame() {

		frame= new JFrame("Mario Bros");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(ConstantesVistas.ANCHO_FRAME, ConstantesVistas.ALTO_FRAME);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);	
	}


	public void mostrarPantallaInicial (){
		frame.setContentPane(pantallaInicial);
		actualizarPanel();
	}

	public void mostrarPantallaJuego() {
		frame.setContentPane(pantallaJuego);
		pantallaJuego.requestFocus();
		actualizarPanel();
	} 

	private void actualizarPanel() {
		frame.revalidate();
		frame.repaint();
	}

	public void mostrarPantallaGameOver () {

	}

	public void mostrarPantallaRanking() {

	}

	public void iniciarJuego() {
		juego.iniciar();
	}
	public void establecerDireccion(char direccion) {
		juego.establecerDireccionMario(direccion);
	}


	public Observer registrarEntidad(EntidadLogica entidadLogica) {
		Observer observerEntidad = pantallaJuego.agregarEntidad(entidadLogica);
		actualizarPanel();
		return observerEntidad;
	}

	public Observer registrarEntidadMario(EntidadMario entidadMario) {
		Observer observerMario = pantallaJuego.agregarEntidadMario(entidadMario);
		actualizarPanel();
		return observerMario;
	}
	
	public PantallaJuego obtenerPantallaJuego() { //necesario para la clase hilo
		return pantallaJuego;
	}

}
