package Enemigos;

import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.Mario;

public class Spiny extends Enemigo{

	public Spiny(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}
	
	public void serAfectado(Entidad entidad) {
		entidad.afectar(this);		
	}
	
	public void afectar(Mario mario) {
		mario.efectoSpiny();
	}
	
	public void efectoBolaDeFuego() {
		
	}

}
