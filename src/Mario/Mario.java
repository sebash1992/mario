package Mario;

import Enemigos.Enemigo;
import Entidades.Entidad;
import Entidades.EntidadMario;
import Fabricas.Sprite;
import Plataformas.Plataforma;
import PowerUps.PowerUp;

public class Mario extends Entidad implements EntidadMario{

	private int vidas;
	private int monedas;
	private int puntos;
	private MarioState estadoDeMario;
	private double gravedad; 
	private double alturaSalto; 
	private char direccionAnterior;
	private boolean moverHaciaDerecha;
	private boolean moverHaciaIzquierda;
	private boolean caer;
	private boolean saltar;
	private boolean subir;

	public Mario(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		super(posicionX, posicionY, coleccionSprites);
		vidas = 3;
		monedas = 0;
		puntos = 0;
		estadoDeMario = new MarioSimple(this);
		direccionDeMovimiento = INMOVIL;
		direccionAnterior = DERECHA;
		gravedad = 0.5;
		alturaSalto = 13;
		velocidadY = 0; //redefino la velocidad heredada de Entidad
		moverHaciaDerecha = true;
		moverHaciaIzquierda = true;
		caer = true;
		saltar = true;
		sobreSueloFirme = true;
		subir = true;
	}

	public int obtenerVidas() {
		return vidas;
	}

	public int obtenerPuntos() {
		return puntos;
	}

	public int obtenerMonedas() {
		return monedas;
	}

	public void sumarVida() {
		vidas++;
	}

	public void restarVida() {
		vidas--;
	}

	public void modificarPuntos(int puntos) {
		this.puntos += puntos;
	}

	public void sumarMoneda() {
		monedas++;
		if (monedas==0) {
			monedas=0;
			vidas++;
		}
	}

	public void establecerDireccion(char direccionDeMovimiento) {
		if(this.direccionDeMovimiento != direccionDeMovimiento) {

			sprite = cambiarSprite(direccionDeMovimiento);
			this.direccionDeMovimiento = direccionDeMovimiento;
			observer.actualizar();
		}
	}

	private Sprite cambiarSprite(char direccion) {
		Sprite spriteReturn = null;
		if(direccion== INMOVIL) {
			spriteReturn = cambiarSpriteInmovil();
		}
		if(direccion== DERECHA) {
			direccionAnterior= DERECHA;
			spriteReturn = cambiarSpriteDerecha();
		}
		if(direccion== IZQUIERDA) {
			direccionAnterior =IZQUIERDA;
			spriteReturn = cambiarSpriteIzquierda();
		}
		if(direccion== ARRIBA) {
			spriteReturn = cambiarSpriteArriba();
		}
		return spriteReturn;
	}

	private Sprite cambiarSpriteInmovil() {
		Sprite spriteReturn = null;
		switch(direccionDeMovimiento) {
		case INMOVIL:
			if(direccionAnterior == DERECHA)
				spriteReturn = estadoDeMario.obtenerSpriteInmovilDerecha();
			else 
				spriteReturn = estadoDeMario.obtenerSpriteInmovilIzquierda();
			break;
		case DERECHA:
			spriteReturn = estadoDeMario.obtenerSpriteInmovilDerecha();
			break;
		case IZQUIERDA:
			spriteReturn = estadoDeMario.obtenerSpriteInmovilIzquierda();
			break;
		case ARRIBA:
			if(direccionAnterior == DERECHA)
				spriteReturn = estadoDeMario.obtenerSpriteInmovilDerecha();
			else 
				spriteReturn = estadoDeMario.obtenerSpriteInmovilIzquierda();
			break;
		}
		return spriteReturn;
	}

	private Sprite cambiarSpriteDerecha() {
		Sprite spriteReturn = null;
		switch(direccionDeMovimiento) {
		case INMOVIL:
			spriteReturn = estadoDeMario.obtenerSpriteCaminandoDerecha();
			break;
		case IZQUIERDA:
			spriteReturn = estadoDeMario.obtenerSpriteCaminandoDerecha();
			break;
		case ARRIBA:
			spriteReturn = estadoDeMario.obtenerSpriteSaltandoDerecha(); 
			break;
		case DERECHA:
			spriteReturn = estadoDeMario.obtenerSpriteCaminandoDerecha(); 
			break;
		}
		return spriteReturn;
	}

	private Sprite cambiarSpriteIzquierda() {
		Sprite spriteReturn = null;
		switch(direccionDeMovimiento) {
		case INMOVIL:
			spriteReturn = estadoDeMario.obtenerSpriteCaminandoIzquierda();
			break;
		case DERECHA:
			spriteReturn = estadoDeMario.obtenerSpriteCaminandoIzquierda();
			break;
		case ARRIBA:
			spriteReturn = estadoDeMario.obtenerSpriteSaltandoIzquierda();
			break;
		case IZQUIERDA:
			spriteReturn = estadoDeMario.obtenerSpriteCaminandoIzquierda();
			break;
		}
		return spriteReturn;
	}

	public Sprite cambiarSpriteArriba() {
		Sprite spriteReturn = null;
		switch(direccionDeMovimiento) {
		case INMOVIL:
			if(direccionAnterior == DERECHA)
				spriteReturn = estadoDeMario.obtenerSpriteSaltandoDerecha();
			else 
				spriteReturn = estadoDeMario.obtenerSpriteSaltandoIzquierda();
			break;
		case IZQUIERDA:
			spriteReturn = estadoDeMario.obtenerSpriteSaltandoIzquierda();
			break;
		case DERECHA:
			spriteReturn = estadoDeMario.obtenerSpriteSaltandoDerecha();
			break;
		case ARRIBA:
			if(direccionAnterior == DERECHA)
				spriteReturn = estadoDeMario.obtenerSpriteSaltandoDerecha();
			else 
				spriteReturn = estadoDeMario.obtenerSpriteSaltandoIzquierda();
			break;
		}
		return spriteReturn;
	}

	public void mover() {

		if (direccionDeMovimiento == DERECHA && moverHaciaDerecha) {
			posicionX += velocidadX;
			observer.actualizarPosicion();
		}

		if (direccionDeMovimiento == IZQUIERDA && moverHaciaIzquierda) {
			posicionX -= velocidadX;
			observer.actualizarPosicion();
		}

		if (direccionDeMovimiento == ARRIBA && saltar) {
			if (sobreSueloFirme) {
				velocidadY = alturaSalto; 
				sobreSueloFirme = false;
			}
		}

		if (!sobreSueloFirme && caer) {
			velocidadY -= gravedad; 
			posicionY += velocidadY; 
			observer.actualizarPosicion();
		}
		
		if(!subir) {
			velocidadY = -5;
		}

		if (posicionY <= estadoDeMario.obtenerNuevaPosicionY()) { //"posicionY <= 139" significa que mario está por encima del suelo
			posicionY = estadoDeMario.obtenerNuevaPosicionY();
			velocidadY = 0;
			sobreSueloFirme = true; 
			observer.actualizarPosicion();
		}  

		if (direccionDeMovimiento == INMOVIL && sobreSueloFirme) {
			observer.actualizarPosicion();
		}
	}

	public void cambiarEstado(MarioState estadoDeMario) {
		this.estadoDeMario = estadoDeMario;
		posicionY = estadoDeMario.obtenerNuevaPosicionY();
		sprite = cambiarSprite(direccionDeMovimiento);
		observer.actualizar();
	}

	public void serAfectado(Entidad entidad) {
		entidad.afectar(this);
	}

	public void afectar(Plataforma plataforma) {
		plataforma.efectoMario(this);
	}

	public void afectar(PowerUp powerUp) {
		powerUp.efectoMario(this);
	}

	public void afectar(Enemigo enemigo) {
		enemigo.efectoMario(this);
	}

	public void efectoChampinionVerde() {
		vidas++;
	}

	public void efectoMoneda() {
		monedas++;
	}

	public void efectoEstrella(){
		estadoDeMario.aplicarEstrella();
	}

	public void efectoFlorDeFuego() {
		estadoDeMario.aplicarFlorDeFuego();
	}

	public void efectoSuperChampinion() {
		estadoDeMario.aplicarSuperChampinion();
	}

	public void efectoBloqueDePregunta() {
		estadoDeMario.aplicarBloqueDePregunta();
	}

	public void efectoTuberia(){
		estadoDeMario.aplicarTuberia();
	}

	public void efectoBloqueSolido() {
		estadoDeMario.aplicarBloqueSolido();
	}

	public void efectoLadrilloSolido() {
		estadoDeMario.aplicarLadrilloSolido();;
	}

	public void efectoVacio() {
		estadoDeMario.aplicarVacio();
	}

	public void efectoBuzzyBeetle() {
		estadoDeMario.aplicarBuzzyBeetle();
	}

	public void efectoSpiny() {
		estadoDeMario.aplicarSpiny();
	}

	public void efectoLakitu() {
		estadoDeMario.aplicarLakitu();
	}

	public void efectoPiranhPlant() {
		estadoDeMario.aplicarPiranhaPlant();
	}

	public void efectoGoomba() {
		estadoDeMario.aplicarGoomba();
	}

	public void efectoKoopaTroopa() {
		estadoDeMario.aplicarKoopaTroopa();
	}
	
	public void rebotar() {
		velocidadY = alturaSalto-10; 
	}

	public void deshabilitarMovimientoDerecha() {
		moverHaciaDerecha = false;
	}

	public void habilitarMovimientoDerecha() {
		moverHaciaDerecha = true;
	}

	public void deshabilitarMovimientoIzquierda() {
		moverHaciaIzquierda = false;
	}

	public void habilitarMovimientoIzquierda() {
		moverHaciaIzquierda = true;
	}

	public void habilitarCaida() {
		caer = true;
	}

	public void deshabilitarCaida() {
		caer = false;
	}

	public void habilitarSaltar() {
		saltar = true;
	}

	public void deshabilitarSaltar() {
		saltar = false;
	}

	public void habilitarSueloFirme() {
		sobreSueloFirme = true;
	}

	public void desabilitarSueloFirme() {
		if(this.posicionY != estadoDeMario.obtenerNuevaPosicionY())
			sobreSueloFirme = false;
	}
	
	public void habilitarSubir() {
		subir = true;
	}

	public void deshabilitarSubir() {
		subir = false;
		
	}

}