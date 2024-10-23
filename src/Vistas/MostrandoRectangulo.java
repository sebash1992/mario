package Vistas;

import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JPanel;

import Fabricas.Sprite;

public class MostrandoRectangulo extends JPanel {

    private Sprite sprite;

    public MostrandoRectangulo(Sprite sprite) {
        this.sprite = sprite;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Dibujar la imagen del sprite aquí si lo deseas
        // g.drawImage(sprite.obtenerImagen(), sprite.x, sprite.y, this);

        // Dibujar los rectángulos de colisión
        g.setColor(Color.RED);
        g.drawRect(sprite.obtenerRectanguloArriba().x, sprite.obtenerRectanguloArriba().y,
                   sprite.obtenerRectanguloArriba().width, sprite.obtenerRectanguloArriba().height);
        
        g.setColor(Color.GREEN);
        g.drawRect(sprite.obtenerRectanguloIzquierdo().x, sprite.obtenerRectanguloIzquierdo().y,
                   sprite.obtenerRectanguloIzquierdo().width, sprite.obtenerRectanguloIzquierdo().height);

        g.setColor(Color.BLUE);
        g.drawRect(sprite.obtenerRectanguloDerecho().x, sprite.obtenerRectanguloDerecho().y,
                   sprite.obtenerRectanguloDerecho().width, sprite.obtenerRectanguloDerecho().height);
        
        g.setColor(Color.BLACK);
        g.drawRect(sprite.obtenerRectanguloAbajo().x, sprite.obtenerRectanguloAbajo().y,
                   sprite.obtenerRectanguloAbajo().width, sprite.obtenerRectanguloAbajo().height);

        // Si tienes un rectángulo abajo, también lo puedes dibujar de manera similar
    }
}

