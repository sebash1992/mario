package PowerUps;

import Enemigos.Enemigo;
import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.Mario;

public class Moneda extends PowerUp{

	public Moneda(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}

	public void afectar(Mario mario) {
		mario.efectoMoneda();
		eliminar();
	}
	

	public void afectar(PowerUp powerUp) {
		powerUp.efectoMoneda();
	}

	public void afectar(Enemigo enemigo) {
		enemigo.efectoMoneda();
	}

}
