package Enemigos;

import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.Mario;

public class Goomba extends Enemigo{

	public Goomba(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}

	public void serAfectado(Entidad entidad) {
		entidad.afectar(this);		
	}
	
	public void afectar(Mario mario) {
		mario.efectoGoomba();
	}
	
	public void efectoMario(Mario mario) {
		mario.modificarPuntos(60);
		eliminar();
		mario.rebotar();
	}

}
