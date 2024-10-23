package Enemigos;

import Entidades.Entidad;
import Fabricas.Sprite;
import Mario.Mario;

public class KoopaTroopa extends Enemigo{
	
	protected final int SPRITE_DENTRO_CAPARAZON=2;
	protected boolean saltoRecibido;
	
	public KoopaTroopa(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
		saltoRecibido=false;
	}

	public void serAfectado(Entidad entidad) {
		entidad.afectar(this);		
	}
	
	public void afectar(Mario mario) {
		mario.efectoKoopaTroopa();
	}
	
	public void efectoMario(Mario mario) {
		if(!saltoRecibido) {
			sprite = coleccionSprites[SPRITE_DENTRO_CAPARAZON];
			posicionY-=25;
			saltoRecibido=true;
			mario.rebotar();
			observer.actualizar();
		}
		else {
			mario.modificarPuntos(90);
			eliminar();
		}
	}

}
