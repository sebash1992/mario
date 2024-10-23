package Mario;

import Fabricas.Sprite;

public class MarioSimple extends MarioState{

	protected final int NUEVA_POSICION_Y = 139; 
	protected final int INMOVIL_DERECHA=0;
	protected final int INMOVIL_IZQUIERDA=1;
	protected final int CAMINANDO_DERECHA=2;
	protected final int CAMINANDO_IZQUIERDA=3;
	protected final int SALTANDO_DERECHA=4;
	protected final int SALTANDO_IZQUIERDA=5;

	public MarioSimple(Mario mario) {
		super(mario);
	}

	public void aplicarSuperChampinion() {
		SuperMario nuevoEstado = new SuperMario(mario);
		mario.cambiarEstado(nuevoEstado);
		if (puedeTirarBolasDeFuego) {
			nuevoEstado.habilitarTirarBolasDeFuego();
		}
	}

	public void aplicarEstrella() {
		Invencible nuevoEstado = new Invencible(mario);
		mario.cambiarEstado(nuevoEstado);
		mario.modificarPuntos(20);
		//falta modificar puntos si mario es invencible
	}

	public void aplicarFlorDeFuego() {
		SuperMario nuevoEstado = new SuperMario(mario);
		mario.cambiarEstado(nuevoEstado);
		nuevoEstado.habilitarTirarBolasDeFuego();
		mario.modificarPuntos(5);
	}

	public void aplicarBloqueDePregunta() {
		mario.deshabilitarMovimientoDerecha();
		mario.deshabilitarMovimientoIzquierda();
		mario.habilitarSaltar();
		mario.habilitarCaida();
	}

	public void aplicarTuberia() {
		mario.deshabilitarMovimientoDerecha();
		mario.deshabilitarMovimientoIzquierda();
		mario.habilitarSaltar();
	}


	public void aplicarBloqueSolido() {
		mario.deshabilitarMovimientoDerecha();
		mario.deshabilitarMovimientoIzquierda();
		mario.habilitarSaltar();
		mario.habilitarCaida();
	}

	public void aplicarLadrilloSolido() {
		mario.deshabilitarMovimientoDerecha();
		mario.deshabilitarMovimientoIzquierda();
		mario.habilitarSaltar();
		mario.habilitarCaida();
	}

	public void aplicarVacio() {
		mario.modificarPuntos(-15);
		mario.restarVida();
		mario.habilitarCaida();
		mario.desabilitarSueloFirme();
	}

	public void aplicarBuzzyBeetle() {
		mario.modificarPuntos(-15);
		mario.restarVida();
	}

	public void aplicarSpiny() {
		mario.modificarPuntos(-30);
		mario.restarVida();
	}

	public void aplicarLakitu() {
		mario.restarVida();
	}

	public void aplicarPiranhaPlant() {
		mario.modificarPuntos(-30);
		mario.restarVida();
	}

	public void aplicarGoomba() {
		mario.modificarPuntos(-30);
		mario.restarVida();
	}

	public void aplicarKoopaTroopa() {
		mario.modificarPuntos(-45);
		mario.restarVida();
	}

	public void romperBloque() {
	}

	public Sprite obtenerSpriteInmovilDerecha() {
		Sprite[] arregloSprites=mario.obtenerColeccionSprites();
		return arregloSprites[INMOVIL_DERECHA];
	}

	public Sprite obtenerSpriteInmovilIzquierda() {
		Sprite[] arregloSprites=mario.obtenerColeccionSprites();
		return arregloSprites[INMOVIL_IZQUIERDA];
	}

	public Sprite obtenerSpriteCaminandoDerecha() {
		Sprite[] arregloSprites=mario.obtenerColeccionSprites();
		return arregloSprites[CAMINANDO_DERECHA];
	}

	public Sprite obtenerSpriteCaminandoIzquierda() {
		Sprite[] arregloSprites=mario.obtenerColeccionSprites();
		return arregloSprites[CAMINANDO_IZQUIERDA];
	}

	public Sprite obtenerSpriteSaltandoDerecha() {
		Sprite[] arregloSprites=mario.obtenerColeccionSprites();
		return arregloSprites[SALTANDO_DERECHA];
	}

	public Sprite obtenerSpriteSaltandoIzquierda() {
		Sprite[] arregloSprites=mario.obtenerColeccionSprites();
		return arregloSprites[SALTANDO_IZQUIERDA];
	}

	public int obtenerNuevaPosicionY() {
		return NUEVA_POSICION_Y;
	}
}
