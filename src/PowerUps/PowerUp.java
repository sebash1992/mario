package PowerUps;

import Entidades.Entidad;
import Fabricas.Sprite;

public abstract class PowerUp extends Entidad{

	public PowerUp(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}
	
	public void serAfectado(Entidad entidad) {
		entidad.afectar(this);
	}
	private void cambiarDireccion() {
		if (direccionDeMovimiento == DERECHA)
			direccionDeMovimiento = IZQUIERDA;
		if (direccionDeMovimiento == IZQUIERDA)
			direccionDeMovimiento = DERECHA;
	}

	public void efectoSuperChampinion() {
		cambiarDireccion();
	}

	public void efectoEstrella() {
		cambiarDireccion();
	}

	public void efectoChampinionVerde() {
		cambiarDireccion();
	}

	public void efectoBloqueDePregunta() {
		cambiarDireccion();
	}

	public void efectoTuberia() {
		cambiarDireccion();
	}

	public void efectoBloqueSolido() {
		cambiarDireccion();
	}

	public void efectoLadrilloSolido() {
		cambiarDireccion();
	}

	public void efectoVacio() {
		cambiarDireccion();
	}

	public void efectoBuzzyBeetle() {
		cambiarDireccion();
	}

	public void efectoSpiny() {
		cambiarDireccion();
	}

	public void efectoLakitu() {
		cambiarDireccion();
	}

	public void efectoPiranhPlant() {
		cambiarDireccion();
	}

	public void efectoGoomba() {
		cambiarDireccion();
	}

	public void efectoKoopaTroopa() {
		cambiarDireccion();
	}

	public void efectoBolaDeFuego() {
		cambiarDireccion();
	}
	

	public void efectoFlorDeFuego() {
		cambiarDireccion();
	}


	public void efectoMoneda() {
		cambiarDireccion();
	}
	
	protected void desaparecer() {
		// hacerlo desaparecer de la pantalla
	}
}
