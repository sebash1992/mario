package Enemigos;

import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.Mario;

public class BuzzyBeetle extends Enemigo {

	public BuzzyBeetle(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}

	public void serAfectado(Entidad entidad) {
		entidad.afectar(this);
	}
	
	public void afectar(Mario mario) {
		mario.efectoBuzzyBeetle();
	}

	public void efectoMario(Mario mario) {
		mario.modificarPuntos(30);
		eliminar();
	}
	
	public void efectoBolaDeFuego() {
		
	}
}
