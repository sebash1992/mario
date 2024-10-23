package Plataformas;

import Entidades.Entidad;
import Fabricas.Sprite;
import Vistas.Observer;

public abstract class Plataforma extends Entidad{

	public Plataforma(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}

}
