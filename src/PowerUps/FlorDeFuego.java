package PowerUps;

import Enemigos.Enemigo;
import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.Mario;

public class FlorDeFuego extends PowerUp {

	public FlorDeFuego(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}

	public void serAfectado(Entidad entidad) {
		entidad.afectar(this);
	}
	
	public void afectar(Mario mario) {
		mario.efectoFlorDeFuego();
		eliminar();
	}
	
	public void afectar(PowerUp powerUp) {
		powerUp.efectoFlorDeFuego();
	}

	public void afectar(Enemigo enemigo) {
		enemigo.efectoFlorDeFuego();
	}
}
