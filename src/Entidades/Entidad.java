package Entidades;

import java.util.List;

import Enemigos.Enemigo;
import Fabricas.Sprite;
import Mario.Mario;
import Plataformas.Plataforma;
import PowerUps.PowerUp;
import Sonido.Sonido;
import Vistas.Observer;

public abstract class Entidad implements EntidadLogica{

	protected final char DERECHA = 'd';
	protected final char IZQUIERDA = 'i';
	protected final char ARRIBA = 'a';
	protected final char INMOVIL = 'z';
	protected final int SPRITE_POR_DEFECTO=0;

	protected int posicionX;
	protected int posicionY;
	protected double velocidadX;
	protected double velocidadY;
	protected char direccionDeMovimiento;
	protected boolean sobreSueloFirme;
	protected boolean eliminar;
	protected Observer observer;
	protected Sprite sprite;
	protected Sprite[] coleccionSprites;
	protected Sonido sonido;


	public Entidad(int posicionX, int posicionY, Sprite[] coleccionSprites) {
		this.posicionX = posicionX;
		this.posicionY = posicionY;
		this.coleccionSprites = coleccionSprites;
		sprite = coleccionSprites[SPRITE_POR_DEFECTO];
		sobreSueloFirme = true;
		eliminar = false;
		velocidadX = 5;
		velocidadY = 50;
	}
	
	public int obtenerPosicionX() {
		return posicionX;
	}

	public int obtenerPosicionY() {
		return posicionY;
	}

	public double obtenerVelocidadX() {
		return velocidadX;
	}
	public double obtenerVelocidadY() {
		return velocidadY;
	}

	public Sprite obtenerSprite() {
		return sprite;
	}

	public Sprite[] obtenerColeccionSprites() {
		return coleccionSprites;
	}
	public Sonido obtenerSonido() {
		return sonido;
	}

	public boolean enSueloFirme() {
		return sobreSueloFirme;
	}
	
	public boolean estaEliminada() {
		return  eliminar;
	}
	public void establecerPosicionX(int posicionX) {
		this.posicionX = posicionX;
	}

	public void establecerPosicionY(int posicionY) {
		this.posicionY = posicionY;
	}

	public void establecerVelocidadX(int velocidadX) {
		this.velocidadX = velocidadX;
	}

	public void establecerVelocidadY(int velocidadY) {
		this.velocidadY = velocidadY;
	}

	public void establecerDireccion(char direccionDeMovimiento) {
			this.direccionDeMovimiento = direccionDeMovimiento;
	}

	public void establecerSobreSueloFirme(boolean sobreSueloFirme) {
		this.sobreSueloFirme = sobreSueloFirme;
	}
	
	public void eliminar() {
		eliminar = true;
		observer.actualizar();
	}

	public void establecerSonido(Sonido sonido) {
		this.sonido = sonido;
	}

	public void registrarObserver(Observer observer) {
		this.observer = observer;
		observer.actualizar();
	}

	public Observer obtenerObserver() {
		return observer;
	}

	abstract public void serAfectado(Entidad entidad);

	public void afectar(Mario mario) {
	}

	public void afectar(Plataforma plataforma) {
	}

	public void afectar(PowerUp powerUp) {
	}

	public void afectar(Enemigo enemigo) {
	}

	public void efectoSuperChampinion() {
	}

	public void efectoEstrella() {
	}

	public void efectoFlorDeFuego() {
	}

	public void efectoChampinionVerde() {
	}

	public void efectoBloqueDePregunta() {
	}

	public void efectoMoneda() {
	}

	public void efectoTuberia() {
	}

	public void efectoBloqueSolido() {
	}

	public void efectoLadrilloSolido() {
	}

	public void efectoVacio() {
	}

	public void efectoBuzzyBeetle() {
	}

	public void efectoSpiny() {
	}

	public void efectoLakitu() {
	}

	public void efectoPiranhPlant() {
	}

	public void efectoGoomba() {
	}

	public void efectoKoopaTroopa() {
	}

	public void efectoMario(Mario mario) {
	}

	public void efectoBolaDeFuego() {
	}
}
