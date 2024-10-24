package Entidades;

import java.awt.Rectangle;
import java.util.List;
import java.util.stream.Collectors;

import Enemigos.Enemigo;
import Fabricas.Sprite;
import Juego.Nivel;
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
	
	
	public boolean detectarColisionesDerecha(List<Entidad> entidades,double velocidad) {
		Sprite spriteMario = this.obtenerSprite();
		boolean colision = false;
		
		Rectangle rectanguloDerechoSprite = spriteMario.obtenerRectanguloDerecho();
		rectanguloDerechoSprite.setBounds((int)(rectanguloDerechoSprite.x+velocidad), rectanguloDerechoSprite.y, rectanguloDerechoSprite.width, rectanguloDerechoSprite.height);

		for (Entidad entidad : entidades.stream().filter(x -> !x.estaEliminada()).collect(Collectors.toList())) {

				Sprite spriteEntidad = entidad.obtenerSprite();
				Rectangle rectanguloIzquierdo = spriteEntidad.obtenerRectanguloIzquierdo();
				//System.out.println("E Rectangulo izquierdo " + rectanguloIzquierdo.x + " " + rectanguloIzquierdo.y+" " + (rectanguloIzquierdo.x+rectanguloIzquierdo.width) + " " + (rectanguloIzquierdo.y+rectanguloIzquierdo.height) +" " );
			
					if (rectanguloDerechoSprite.intersects(rectanguloIzquierdo)) {

						colision = true;
						System.out.println(sprite.obtenerRutaImagen()+ " por derecha, colisiona entidad por izquierda");
					
			}
		}
		return colision;
	}
	
	
	public boolean detectarColisionesIzquierda(List<Entidad> entidades,double velocidad) {
		Sprite spriteMario = this.obtenerSprite();
		boolean colision = false;
		
		Rectangle rectanguloIzquierdoSprite = spriteMario.obtenerRectanguloIzquierdo();
		rectanguloIzquierdoSprite.setBounds((int)(rectanguloIzquierdoSprite.x-velocidad), rectanguloIzquierdoSprite.y, rectanguloIzquierdoSprite.width, rectanguloIzquierdoSprite.height);

		for (Entidad entidad : entidades.stream().filter(x -> !x.estaEliminada()).collect(Collectors.toList())) {
				Sprite spriteEntidad = entidad.obtenerSprite();
				Rectangle rectanguloDerecho = spriteEntidad.obtenerRectanguloDerecho();
				//System.out.println("E Rectangulo izquierdo " + rectanguloIzquierdo.x + " " + rectanguloIzquierdo.y+" " + (rectanguloIzquierdo.x+rectanguloIzquierdo.width) + " " + (rectanguloIzquierdo.y+rectanguloIzquierdo.height) +" " );
			
					if (rectanguloIzquierdoSprite.intersects(rectanguloDerecho)) {

						colision = true;
						System.out.println(sprite.obtenerRutaImagen()+ " por Izquierda, colisiona entidad por derecha");
					
			}
		}
		return colision;
	}
	
	public int detectarColisionesArriba(List<Entidad> entidades,double velocidad) {
		Sprite spriteMario = this.obtenerSprite();
		boolean colision = false;
		int nuevaVelocidad = (int)velocidad;
		
		Rectangle rectanguloArribaSprite = spriteMario.obtenerRectanguloArriba();
		rectanguloArribaSprite.setBounds((int)(rectanguloArribaSprite.x), (int)(rectanguloArribaSprite.y-nuevaVelocidad), rectanguloArribaSprite.width, rectanguloArribaSprite.height);

		for (Entidad entidad : entidades.stream().filter(x -> !x.estaEliminada()).collect(Collectors.toList())) {
				Sprite spriteEntidad = entidad.obtenerSprite();
				Rectangle rectanguloAbajo = spriteEntidad.obtenerRectanguloAbajo();
				//System.out.println("E Rectangulo izquierdo " + rectanguloIzquierdo.x + " " + rectanguloIzquierdo.y+" " + (rectanguloIzquierdo.x+rectanguloIzquierdo.width) + " " + (rectanguloIzquierdo.y+rectanguloIzquierdo.height) +" " );
			
					if (rectanguloArribaSprite.intersects(rectanguloAbajo)) {

						colision = true;
						nuevaVelocidad =  rectanguloArribaSprite.y  - rectanguloArribaSprite.height - rectanguloAbajo.y;
						System.out.println(sprite.obtenerRutaImagen()+ " por Arriba, colisiona entidad por abajo");
					
			}
		}
		return nuevaVelocidad;
	}
	
	public boolean detectarColisionesAbajo(List<Entidad> entidades,double velocidad) {
		Sprite sprite = this.obtenerSprite();
		boolean colision = false;
		
		Rectangle rectanguloAbajoSprite = sprite.obtenerRectanguloAbajo();
		rectanguloAbajoSprite.setBounds((int)(rectanguloAbajoSprite.x), (int)(rectanguloAbajoSprite.y-velocidad), rectanguloAbajoSprite.width, rectanguloAbajoSprite.height);

		for (Entidad entidad : entidades.stream().filter(x -> !x.estaEliminada()).collect(Collectors.toList())) {
				Sprite spriteEntidad = entidad.obtenerSprite();
				Rectangle rectanguloArriba = spriteEntidad.obtenerRectanguloArriba();
				//System.out.println("E Rectangulo izquierdo " + rectanguloIzquierdo.x + " " + rectanguloIzquierdo.y+" " + (rectanguloIzquierdo.x+rectanguloIzquierdo.width) + " " + (rectanguloIzquierdo.y+rectanguloIzquierdo.height) +" " );
			
					if (rectanguloAbajoSprite.intersects(rectanguloArriba)) {

						colision = true;
						System.out.println(sprite.obtenerRutaImagen()+ " por Arriba, colisiona entidad por abajo");
					
			}
		}
		return colision;
	}
}
