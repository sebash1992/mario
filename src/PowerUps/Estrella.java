package PowerUps;

import Enemigos.Enemigo;
import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.Mario;

public class Estrella extends PowerUp{

	public Estrella(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}
	
	public void afectar(Mario mario) {
		mario.efectoEstrella();
		eliminar();
	}
	

	public void afectar(PowerUp powerUp) {
		powerUp.efectoEstrella();
	}

	public void afectar(Enemigo enemigo) {
		enemigo.efectoEstrella();
	}

}
