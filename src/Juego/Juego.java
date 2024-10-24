package Juego;

import java.util.List;

import Entidades.Entidad;
import Fabricas.FabricaEntidades;
import Fabricas.FabricaSprite;
import Fabricas.FabricaSpriteOriginal;
import Hilos.*;
import Mario.Mario;
import Parser.GeneradorNivel;
import Sonido.Sonido;
import Vistas.ControladorVistas;
import Vistas.Observer;

public class Juego {
	protected ControladorVistas controladorVistas;
	protected FabricaEntidades fabricaEntidades;
	protected FabricaSprite fabricaSprite;
	protected GeneradorNivel generadorNivel;
	protected Nivel nivel;
	protected DetectorColisiones detectorColisiones;
	protected Sonido sonido;
	protected HiloMario hiloMario;
	protected HiloEntidades hiloEntidades;


	public Juego() {
		fabricaSprite= new FabricaSpriteOriginal();
		fabricaEntidades= new FabricaEntidades(fabricaSprite);
		generadorNivel= new GeneradorNivel(fabricaEntidades);
		sonido = Sonido.obtenerInstancia();
		detectorColisiones = new DetectorColisiones();
	}

	public void establecerControladorVistas(ControladorVistas controladorVistas){
		this.controladorVistas=controladorVistas;
	}
	
	public ControladorVistas obtenerControladorVistas() {//necesario para la clase hilo
		return controladorVistas;
	}

	public void iniciar() {
		nivel= generadorNivel.cargarNivel("./src/Parser/Formateo_de_niveles.txt");
		registrarObservers();
		controladorVistas.mostrarPantallaJuego();
		hiloMario= new HiloMario(this);
		hiloEntidades= new HiloEntidades(this);
		hiloMario.iniciarHilo();
		hiloEntidades.iniciarHilo();
	}

	private void registrarObservers() {
		registrarObserverMario(nivel.obtenerMario());
		registrarObserverEntidad(nivel.obtenerEntidades());
	}

	private void registrarObserverMario(Mario mario) {
		Observer observerMario= controladorVistas.registrarEntidadMario(mario);
		mario.registrarObserver(observerMario);
	}

	private void registrarObserverEntidad(List<Entidad> entidades) {
		for(Entidad entidad:entidades) {
			Observer observer= controladorVistas.registrarEntidad(entidad);
			entidad.registrarObserver(observer);
		}
	}

	public void moverMario() {
		nivel.obtenerMario().mover(nivel.obtenerEntidades());
	}

	public void establecerDireccionMario(char direccion) {
		nivel.obtenerMario().establecerDireccion(direccion);
		detectorColisiones.detectarColisionesMarioPlataformas(nivel);
	}
	
	public void detectarColisionesMario() {
		detectorColisiones.detectarColisionesMarioPlataformas(nivel);
		detectorColisiones.detectarColisionesMarioEnemigos(nivel);
		detectorColisiones.detectarColisionesMarioPowerUps(nivel);
	}
	
	public void actualizarEntidades() {
		for(Entidad entidad : nivel.obtenerEntidades()) {
			if (entidad.estaEliminada()) {
	            nivel.obtenerEntidades().remove(entidad);
	        } else {
	            //mover
	        }
		}
	}
}
