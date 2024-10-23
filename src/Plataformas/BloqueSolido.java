package Plataformas;

import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.Mario;

public class BloqueSolido extends Plataforma {

	public BloqueSolido(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}

	public void serAfectado(Entidad entidad) {
		entidad.afectar(this);
	}
	
	public void afectar(Mario mario) {
		mario.efectoBloqueSolido();
	}
}
