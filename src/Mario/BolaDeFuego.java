package Mario;

import Enemigos.Enemigo;
import Entidades.Entidad;
import Fabricas.Sprite;
import Plataformas.Plataforma;
import PowerUps.PowerUp;
import Vistas.Observer;

public class BolaDeFuego extends Entidad{

	public BolaDeFuego(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
	}

	public void serAfectado(Entidad entidad) {
	}

	public void afectar(Mario mario) {
		mario.efectoBolaDeFuego();
	}

	public void afectar(Plataforma plataforma) {
		plataforma.efectoBolaDeFuego();
	}

	public void afectar(PowerUp powerUp) {
		powerUp.efectoBolaDeFuego();
	}

	public void afectar(Enemigo enemigo) {
		enemigo.efectoBolaDeFuego();
	}
}
