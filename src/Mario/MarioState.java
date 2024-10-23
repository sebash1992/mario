package Mario;

import Fabricas.Sprite;

public abstract class MarioState {

	protected boolean puedeTirarBolasDeFuego ;
	protected Mario mario;

	public MarioState(Mario mario) {
		this.mario = mario;
		puedeTirarBolasDeFuego  = false;
	}

	public boolean puedeTirarBolasDeFuego () {
		return puedeTirarBolasDeFuego;
	}

	public void habilitarTirarBolasDeFuego() {
		puedeTirarBolasDeFuego = true;
	}

	public void tirarBolaDeFuego() {
	}
	
	abstract public Sprite obtenerSpriteInmovilDerecha();
	abstract public Sprite obtenerSpriteInmovilIzquierda();
	abstract public Sprite obtenerSpriteCaminandoDerecha();
	abstract public Sprite obtenerSpriteCaminandoIzquierda();
	abstract public Sprite obtenerSpriteSaltandoDerecha();
	abstract public Sprite obtenerSpriteSaltandoIzquierda();
	
	abstract public void aplicarSuperChampinion();
	abstract public void aplicarEstrella();
	abstract public void aplicarFlorDeFuego();
	abstract public void aplicarBloqueDePregunta();
	abstract public void aplicarTuberia();
	abstract public void aplicarBloqueSolido();
	abstract public void aplicarLadrilloSolido();
	abstract public void aplicarVacio();
	abstract public void aplicarBuzzyBeetle();
	abstract public void aplicarSpiny();
	abstract public void aplicarLakitu();
	abstract public void aplicarPiranhaPlant();
	abstract public void aplicarGoomba();
	abstract public void aplicarKoopaTroopa();
	abstract public void romperBloque();
	abstract public int obtenerNuevaPosicionY();
	
}