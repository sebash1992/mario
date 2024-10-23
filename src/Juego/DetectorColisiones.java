package Juego;

import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.Mario;

public class DetectorColisiones {

	public DetectorColisiones() {

	}

	public void detectarColisionesMarioPlataformas(Nivel nivel) {
		Mario mario = nivel.obtenerMario();
		Sprite spriteMario = nivel.obtenerMario().obtenerSprite();
		boolean colisionDerecha = false;
		boolean colisionIzquierda = false;
		boolean colisionAbajo = false;
		boolean colisionArriba = false;

		for (Entidad entidad : nivel.obtenerPlataformas()) {

			if (!entidad.estaEliminada()) {
				Sprite spriteEntidad = entidad.obtenerSprite();

				if (spriteMario.intersects(spriteEntidad)) {

					if (spriteMario.obtenerRectanguloDerecho().intersects(spriteEntidad.obtenerRectanguloIzquierdo())) {

						mario.serAfectado(entidad);
						colisionDerecha = true;
						System.out.println("Mario por derecha, colisiona entidad por izquierda");
					} else {
						colisionDerecha = false;
					}

					if (spriteMario.obtenerRectanguloIzquierdo().intersects(spriteEntidad.obtenerRectanguloDerecho())) {

						mario.serAfectado(entidad);
						colisionIzquierda = true;
						System.out.println("Mario por izquierda, colisiona entidad por derecha");
					} else {
						colisionIzquierda = false;
					}

					if (spriteMario.obtenerRectanguloAbajo().intersects(spriteEntidad.obtenerRectanguloArriba())) {

						mario.serAfectado(entidad);
						colisionAbajo = true;
						System.out.println("Mario por abajo, colisiona entidad por arriba");

					} else {

						colisionAbajo = false;
					}

					if (spriteMario.obtenerRectanguloArriba().intersects(spriteEntidad.obtenerRectanguloAbajo())) {

						mario.serAfectado(entidad);
						colisionArriba = true;
						System.out.println("Mario por arriba, colisiona entidad por abajo");
					} else {
						colisionArriba = false;

					}

				}

			}
		}
		if (!colisionDerecha) {
			mario.habilitarMovimientoDerecha();
		} else {
			mario.deshabilitarMovimientoDerecha();
		}
		if (!colisionIzquierda) {
			mario.habilitarMovimientoIzquierda();
		} else {
			mario.deshabilitarMovimientoIzquierda();
		}
		if (!colisionAbajo) {
			mario.habilitarCaida();
			mario.desabilitarSueloFirme();

		}
		if (colisionAbajo) {
			boolean suelofimer = mario.enSueloFirme();
			System.out.println("suelo firme = " + suelofimer);
			if (!mario.enSueloFirme()) {
				mario.habilitarSaltar();
				mario.habilitarSueloFirme();
			}
		}
		if(colisionArriba) {
			mario.habilitarCaida();
			mario.deshabilitarSubir();
		}
		else {
			mario.habilitarSubir();
		}
		

	}

	public void detectarColisionesMarioEnemigos(Nivel nivel) {

		Mario mario = nivel.obtenerMario();
		Sprite spriteMario = nivel.obtenerMario().obtenerSprite();
		for (Entidad entidad : nivel.obtenerEnemigos()) {

			if (!entidad.estaEliminada()) {
				Sprite spriteEntidad = entidad.obtenerSprite();
				if (spriteMario.intersects(spriteEntidad)) {
					if (spriteMario.obtenerRectanguloDerecho().intersects(spriteEntidad.obtenerRectanguloIzquierdo())) {
						mario.serAfectado(entidad);
						System.out.println("mario por derecha, colisiona entidad por izquierda");
					} else if (spriteMario.obtenerRectanguloIzquierdo()
							.intersects(spriteEntidad.obtenerRectanguloDerecho())) {
						mario.serAfectado(entidad);
						System.out.println("mario por izquierda, colisiona entidad por derecha");
					} else if (spriteMario.obtenerRectanguloArriba()
							.intersects(spriteEntidad.obtenerRectanguloIzquierdo())
							|| spriteMario.obtenerRectanguloArriba()
									.intersects(spriteEntidad.obtenerRectanguloDerecho())) {
						mario.serAfectado(entidad);
						System.out.println("mario por arriba, colisiona entidad por abajo");
					} else if (spriteMario.obtenerRectanguloAbajo()
							.intersects(spriteEntidad.obtenerRectanguloArriba())) {
						entidad.serAfectado(mario);
						System.out.println("mario por abajo, colisiona entidad por arriba");
					}
				}
			}
		}
	}

	public void detectarColisionesMarioPowerUps(Nivel nivel) {

		Mario mario = nivel.obtenerMario();
		Sprite spriteMario = nivel.obtenerMario().obtenerSprite();
		for (Entidad entidad : nivel.obtenerPowerUps()) {

			if (!entidad.estaEliminada()) {
				Sprite spriteEntidad = entidad.obtenerSprite();
				if (spriteMario.intersects(spriteEntidad)) {
					if (spriteMario.obtenerRectanguloDerecho().intersects(spriteEntidad.obtenerRectanguloIzquierdo())) {
						mario.serAfectado(entidad);
						System.out.println("mario por derecha, colisiona entidad por izquierda");
					} else if (spriteMario.obtenerRectanguloIzquierdo()
							.intersects(spriteEntidad.obtenerRectanguloDerecho())) {
						mario.serAfectado(entidad);
						System.out.println("mario por izquierda, colisiona entidad por derecha");
					} else if (spriteMario.obtenerRectanguloArriba()
							.intersects(spriteEntidad.obtenerRectanguloIzquierdo())
							|| spriteMario.obtenerRectanguloArriba()
									.intersects(spriteEntidad.obtenerRectanguloDerecho())) {
						mario.serAfectado(entidad);
						System.out.println("mario por arriba, colisiona entidad por abajo");
					} else if (spriteMario.obtenerRectanguloAbajo()
							.intersects(spriteEntidad.obtenerRectanguloArriba())) {
						mario.serAfectado(entidad);
						System.out.println("mario por abajo, colisiona entidad por arriba");
					}
				}
			}
		}
	}
}
