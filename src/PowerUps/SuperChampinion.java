package PowerUps;

import Enemigos.Enemigo;
import Fabricas.Sprite;
import Mario.Mario;

public class SuperChampinion extends PowerUp {

	public SuperChampinion(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}


	public void afectar(Mario mario) {
		mario.efectoSuperChampinion();
		System.out.println("afecte a mario");
		eliminar();

	}

	protected void desaparecer() {
		sprite = coleccionSprites[1];
	}

	public void afectar(PowerUp powerUp) {
		powerUp.efectoSuperChampinion();
	}

	public void afectar(Enemigo enemigo) {
		enemigo.efectoSuperChampinion();
	}

}
