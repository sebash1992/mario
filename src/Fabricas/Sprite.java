package Fabricas;

import java.awt.Rectangle;

public class Sprite extends Rectangle{

	private static final long serialVersionUID = 6566536910187505577L;
	
	private Rectangle rectanguloIzquierdo;
	private Rectangle rectanguloDerecho;
	private Rectangle rectanguloArriba;
	private Rectangle rectanguloAbajo;
	private String rutaImagen;

	public Sprite(String rutaImagen) {

		this.rutaImagen = rutaImagen;
		inicializarRectangulos();
	}

	public Rectangle obtenerRectanguloArriba() {
		return rectanguloArriba;
	}

	public Rectangle obtenerRectanguloIzquierdo() {
		return rectanguloIzquierdo;
	}

	public Rectangle obtenerRectanguloDerecho() {
		return rectanguloDerecho;
	}

	public Rectangle obtenerRectanguloAbajo() {
		return rectanguloAbajo;
	}

	public String obtenerRutaImagen() {
		return rutaImagen;
	}

	public void actualizarRectangulos(int x, int y, int ancho, int alto) {

		super.setBounds(x, y, ancho, alto);
		
		rectanguloArriba.setBounds( x-ancho - 48, y+4, ancho - 2, (int)alto/2 );
		
		rectanguloAbajo.setBounds( x-ancho - 48, y+40, ancho - 2, (int)alto/2 -2);
		
		rectanguloIzquierdo.setBounds(x - 106 , y+15, 18, alto-18);
	
		rectanguloDerecho.setBounds( x - ancho - 12, y+15, 18, alto-18);

	}

	private void inicializarRectangulos() {

		rectanguloAbajo = new Rectangle(0,0,0,0);
		rectanguloIzquierdo = new Rectangle(0,0,0,0);
		rectanguloDerecho = new Rectangle(0,0,0,0);
		rectanguloArriba = new Rectangle(0,0,0,0);
	}
}
