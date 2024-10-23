package Mario;

import Fabricas.FabricaSprite;
import Fabricas.Sprite;

public class Invencible extends MarioState{

	private static final int NUEVA_POSICION_Y = 187;
	protected final int INMOVIL_DERECHA=18;
	protected final int INMOVIL_IZQUIERDA=19;
	//faltan conseguir gif
	protected final int CAMINANDO_DERECHA=18;
	protected final int CAMINANDO_IZQUIERDA=18;
	protected final int SALTANDO_DERECHA=18;
	protected final int SALTANDO_IZQUIERDA=18;
	
	public Invencible(Mario mario) {
		super(mario);
	}

	public void aplicarSuperChampinion() {
		mario.modificarPuntos(10);
	}


	public void aplicarEstrella() {
		mario.modificarPuntos(20);
	}

	public void aplicarFlorDeFuego() {
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
		mario.modificarPuntos(30); 
	}

	public void aplicarSpiny() {
		mario.modificarPuntos(60);
	}

	public void aplicarLakitu() {
		mario.modificarPuntos(60);
	}

	public void aplicarPiranhaPlant() {
		mario.modificarPuntos(30);
	}

	public void aplicarGoomba() {
		mario.modificarPuntos(60);
	}

	public void aplicarKoopaTroopa() {
		mario.modificarPuntos(90);
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

