package Plataformas;

import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.Mario;
import PowerUps.PowerUp;

public class BloqueDePregunta extends Plataforma {

	private PowerUp contenido;

	public BloqueDePregunta(int posicionX, int posicionY, Sprite[] coleccionSprites, PowerUp powerUp) {
		super(posicionX, posicionY, coleccionSprites);
		contenido = powerUp;
	}

	public void serAfectado(Entidad entidad) {
		entidad.afectar(this);
	}
	
	public void afectar(Mario mario) {
		mario.efectoBloqueDePregunta();
	}
}
