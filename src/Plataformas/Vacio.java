package Plataformas;

import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.Mario;

public class Vacio extends Plataforma{

	public Vacio(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}

	public void serAfectado(Entidad entidad) {
		entidad.afectar(this);
	}
	
	public void afectar(Mario mario) {
		mario.efectoVacio();
	}

}
