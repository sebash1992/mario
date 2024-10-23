package Vistas;

public class AdaptadorPosicion {



	public static int transformarX(int posicionx) {
		return posicionx;
	}

	// Las coordenadas gráficas se miden de arriba hacia abajo
	public static int transformarY(int posicionY) {
		return ConstantesVistas.ALTO_FRAME - posicionY;
	}

}
