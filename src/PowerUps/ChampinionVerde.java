package PowerUps;

import Enemigos.Enemigo;
import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.Mario;

public class ChampinionVerde extends PowerUp {

	public ChampinionVerde(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}

	public void afectar(Mario mario) {
		mario.efectoChampinionVerde();
		eliminar();
	}

	public void afectar(PowerUp powerUp) {
		powerUp.efectoChampinionVerde();
	}

	public void afectar(Enemigo enemigo) {
		enemigo.efectoChampinionVerde();
	}
	
}
