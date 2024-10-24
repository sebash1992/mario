package Mario;

import Fabricas.Sprite;

public class SuperMario extends MarioState{

	protected final int NUEVA_POSICION_Y = 187; 
	protected final int INMOVIL_DERECHA=12;
	protected final int INMOVIL_IZQUIERDA=13;
	protected final int CAMINANDO_DERECHA=14;
	protected final int CAMINANDO_IZQUIERDA=15;
	protected final int SALTANDO_DERECHA=16;
	protected final int SALTANDO_IZQUIERDA=17;

	public SuperMario(Mario mario) {
		super(mario);
	}

	public void aplicarSuperChampinion() {
		mario.modificarPuntos(50);		
	}

	public void aplicarEstrella() {
		Invencible nuevoEstado = new Invencible(mario);
		mario.cambiarEstado(nuevoEstado);
		mario.modificarPuntos(30);
		//falta puntos si esta invencible
	}

	public void aplicarFlorDeFuego() {
		if(puedeTirarBolasDeFuego)
			mario.modificarPuntos(50);
		else mario.modificarPuntos(30);
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
		//mario.desabilitarSueloFirme();
	}

	public void aplicarBuzzyBeetle() {
		MarioSimple nuevoEstado = new MarioSimple(mario);
		mario.cambiarEstado(nuevoEstado);
	}

	public void aplicarSpiny() {
		MarioSimple nuevoEstado = new MarioSimple(mario);
		mario.cambiarEstado(nuevoEstado);
	}

	public void aplicarLakitu() {
		MarioSimple nuevoEstado = new MarioSimple(mario);
		mario.cambiarEstado(nuevoEstado);
	}

	public void aplicarPiranhaPlant() {
		MarioSimple nuevoEstado = new MarioSimple(mario);
		mario.cambiarEstado(nuevoEstado);
	}

	public void aplicarGoomba() {
		MarioSimple nuevoEstado = new MarioSimple(mario);
		mario.cambiarEstado(nuevoEstado);
	}

	public void aplicarKoopaTroopa() {
		MarioSimple nuevoEstado = new MarioSimple(mario);
		mario.cambiarEstado(nuevoEstado);
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
