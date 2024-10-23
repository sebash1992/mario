package Mario;

import Fabricas.Sprite;

public class MarioFlorDeFuego extends SuperMario{
	
	protected final int NUEVA_POSICION_Y = 185; 
	protected final int INMOVIL_DERECHA=6;
	protected final int INMOVIL_IZQUIERDA=7;
	protected final int CAMINANDO_DERECHA=8;
	protected final int CAMINANDO_IZQUIERDA=9;
	protected final int SALTANDO_DERECHA=10;
	protected final int SALTANDO_IZQUIERDA=11;

	public MarioFlorDeFuego(Mario mario) {
		super(mario);
		puedeTirarBolasDeFuego=true;
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
