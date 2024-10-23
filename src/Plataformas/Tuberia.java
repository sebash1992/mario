package Plataformas;

import Enemigos.PiranhaPlant;
import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.Mario;

public class Tuberia extends Plataforma{

	private PiranhaPlant piranhaPlant;

	public Tuberia(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}

	public Tuberia(int posicionX, int posicionY, Sprite[] coleccionSprites, PiranhaPlant piranhaPlant) {
		super(posicionX, posicionY, coleccionSprites);
		this.piranhaPlant=piranhaPlant;
	}

	public void serAfectado(Entidad entidad) {
		entidad.afectar(this);
	}
	
	public void afectar(Mario mario) {
		mario.efectoTuberia();
	}
	
	
}
