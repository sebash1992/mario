package Vistas;


import java.awt.Image;
import java.awt.Rectangle;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Entidades.EntidadLogica;
import Fabricas.Sprite;

public class ObserverGrafico extends JLabel implements Observer {
	
	protected EntidadLogica entidadObservada;
	protected String objeto = "";

	public ObserverGrafico(EntidadLogica entidadObservada) {
		super();
		this.entidadObservada = entidadObservada;
		this.objeto = this.entidadObservada.obtenerSprite().obtenerRutaImagen();
	}

	public void actualizar() {
		actualizarImagen();
		actualizarPosicion();
	}

	private void actualizarImagen() {
	    String rutaImagen = entidadObservada.obtenerSprite().obtenerRutaImagen();
	    URL url = getClass().getClassLoader().getResource(rutaImagen);
	
	    ImageIcon iconoOriginal = new ImageIcon(url);

	    int nuevoAncho = iconoOriginal.getIconWidth(); 
	    int nuevoAlto = iconoOriginal.getIconHeight();
	    Image imagenRedimensionada = iconoOriginal.getImage().getScaledInstance(nuevoAncho, nuevoAlto, Image.SCALE_DEFAULT);
	    
		ImageIcon iconoRedimensionado = new ImageIcon(imagenRedimensionada);
		setIcon(iconoRedimensionado);
		int x = AdaptadorPosicion.transformarX(entidadObservada.obtenerPosicionX());
		int y = AdaptadorPosicion.transformarY(entidadObservada.obtenerPosicionY());
		setBounds(x, y, nuevoAncho, nuevoAlto);
		
		
	}

	public void actualizarPosicion() {
		int x = AdaptadorPosicion.transformarX(entidadObservada.obtenerPosicionX());
		int y = AdaptadorPosicion.transformarY(entidadObservada.obtenerPosicionY());
		int ancho = this.getIcon().getIconWidth();  
		int alto = this.getIcon().getIconHeight();
		
		setBounds(x, y, ancho, alto);
		
		
		System.out.println(objeto  + " " + x + " " + y+" " + (x+ancho) + " " + (y+alto) +" " );
		entidadObservada.obtenerSprite().actualizarRectangulos(x, y, ancho, alto);
		/*
		Sprite spriteAux = entidadObservada.obtenerSprite();
		Rectangle rectanguloArriba = spriteAux.obtenerRectanguloArriba();
		System.out.println("Rectangulo arriba " + rectanguloArriba.x + " " + rectanguloArriba.y+" " + (rectanguloArriba.x+rectanguloArriba.width) + " " + (rectanguloArriba.y+rectanguloArriba.height) +" " );
		Rectangle rectanguloAbajo = spriteAux.obtenerRectanguloAbajo();
		System.out.println("Rectangulo abajo " + rectanguloAbajo.x + " " + rectanguloAbajo.y+" " + (rectanguloAbajo.x+rectanguloAbajo.width) + " " + (rectanguloAbajo.y+rectanguloAbajo.height) +" " );
		Rectangle rectanguloDerecho = spriteAux.obtenerRectanguloDerecho();
		System.out.println("Rectangulo dercho " + rectanguloDerecho.x + " " + rectanguloDerecho.y+" " + (rectanguloDerecho.x+rectanguloDerecho.width) + " " + (rectanguloDerecho.y+rectanguloDerecho.height) +" " );
		Rectangle rectanguloIzquierdo = spriteAux.obtenerRectanguloIzquierdo();
		System.out.println("Rectangulo izquierdo " + rectanguloIzquierdo.x + " " + rectanguloIzquierdo.y+" " + (rectanguloIzquierdo.x+rectanguloIzquierdo.width) + " " + (rectanguloIzquierdo.y+rectanguloIzquierdo.height) +" " );
	*/
	
	
	
	}
	
}
