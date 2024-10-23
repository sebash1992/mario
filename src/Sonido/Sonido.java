package Sonido;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sonido {

	protected static Sonido instanciaSonido;
	private Clip clip;//objeto de la biblioteca javax.sound.sampled que permite cargar y reproducir sonidos,


	private Sonido() {
	}

	public static Sonido obtenerInstancia() {
		if (instanciaSonido == null) 
			instanciaSonido = new Sonido();
		return instanciaSonido;
	}

	public void cargarSonido(String rutaArchivo) {
		try {
			File archivoSonido = new File(rutaArchivo);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivoSonido);
			clip = AudioSystem.getClip();
			clip.open(audioStream);
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			System.out.println("Error al cargar el sonido: " + e.getMessage());
		}
	}

	public void reproducir() {
		if (clip != null) {
			clip.setFramePosition(0);
			clip.start(); 
			System.out.println("Reproduciendo sonido...");
		} else {
			System.out.println("Clip no está inicializado.");
		}
	}

	public void detener() {
		if (clip != null) {
			clip.stop();
		}
	}
}
