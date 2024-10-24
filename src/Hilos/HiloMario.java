package Hilos;

import Juego.Juego;
import Vistas.PantallaJuego;

public class HiloMario extends Thread {

	private  Juego juego;
	private boolean HiloEnEjecucion;
	private PantallaJuego pantallaJuego;
	private int fps;

	public HiloMario(Juego juego) {
		this.juego = juego;
		HiloEnEjecucion = false;
		fps = 60;
		pantallaJuego = juego.obtenerControladorVistas().obtenerPantallaJuego();
	}

	public void iniciarHilo() {
		super.start();
		HiloEnEjecucion = true;
	}


	public void run(){
		long duracionIntervalo = 1000/fps;
		long siguienteIntervalo = System.currentTimeMillis() + duracionIntervalo; //el método System.currentTimeMillis() cuenta en milisegundos cuanto tiempo de ejecucion lleva el programa desde que se ejecutó
		while(HiloEnEjecucion) {
			//juego.moverMario();
			//juego.detectarColisionesMario();
			pantallaJuego.repaint();
			pantallaJuego.revalidate();
			try {
				long milisegundosRestantes = siguienteIntervalo - System.currentTimeMillis();
				if(milisegundosRestantes < 0) {
					milisegundosRestantes = 0;
				}
				Thread.sleep(milisegundosRestantes);
				siguienteIntervalo += duracionIntervalo;

			}catch(Exception e) {
				 e.printStackTrace();
			}
		}
	}

	public void detenerHilo() {
		HiloEnEjecucion = false;
	}
}
