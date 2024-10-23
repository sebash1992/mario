package Enemigos;

import Entidades.Entidad;
import Fabricas.Sprite;
import Vistas.Observer;

public abstract class Enemigo extends Entidad{

	public Enemigo(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}
	
	public void efectoTuberia() {
		if(direccionDeMovimiento==DERECHA)
			establecerDireccion(IZQUIERDA);
		else
			establecerDireccion(DERECHA);
	}

	public void efectoBloqueSolido() {
		if(direccionDeMovimiento==DERECHA)
			establecerDireccion(IZQUIERDA);
		else
			establecerDireccion(DERECHA);
	}

	public void efectoLadrilloSolido() {
		if(direccionDeMovimiento==DERECHA)
			establecerDireccion(IZQUIERDA);
		else
			establecerDireccion(DERECHA);
	}
	
	public void efectoBloqueDePregunta() {
		if(direccionDeMovimiento==DERECHA)
			establecerDireccion(IZQUIERDA);
		else
			establecerDireccion(DERECHA);
	}
	public void efectoBuzzyBeetle() {
		if(direccionDeMovimiento==DERECHA)
			establecerDireccion(IZQUIERDA);
		else
			establecerDireccion(DERECHA);
	}

	public void efectoSpiny() {
		if(direccionDeMovimiento==DERECHA)
			establecerDireccion(IZQUIERDA);
		else
			establecerDireccion(DERECHA);
	}

	public void efectoLakitu() {
		if(direccionDeMovimiento==DERECHA)
			establecerDireccion(IZQUIERDA);
		else
			establecerDireccion(DERECHA);
	}

	public void efectoPiranhPlant() {
		if(direccionDeMovimiento==DERECHA)
			establecerDireccion(IZQUIERDA);
		else
			establecerDireccion(DERECHA);
	}

	public void efectoGoomba() {
		if(direccionDeMovimiento==DERECHA)
			establecerDireccion(IZQUIERDA);
		else
			establecerDireccion(DERECHA);
	}

	public void efectoKoopaTroopa() {
		if(direccionDeMovimiento==DERECHA)
			establecerDireccion(IZQUIERDA);
		else
			establecerDireccion(DERECHA);
	}
}
