package Enemigos;

import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.Mario;

public class PiranhaPlant extends Enemigo {

	public PiranhaPlant(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}

	public void serAfectado(Entidad entidad) {
		entidad.afectar(this);		
	}

	public void afectar(Mario mario) {
		mario.efectoPiranhPlant();
	}
	
	public void efectoBolaDeFuego() {
		
	}
}
