package Vistas;
import Entidades.EntidadMario;

public class ObserverMario extends ObserverGrafico {

	protected EntidadMario marioObservado;
	protected PantallaJuego pantallaJuego;

	public ObserverMario(PantallaJuego pantallaJuego , EntidadMario marioObservado) {
		super(marioObservado);
		this.marioObservado= marioObservado;
		this.pantallaJuego= pantallaJuego;
		//this.setBorder(new Border);
	}


	public void actualizarPosicion(){
		super.actualizarPosicion();
		pantallaJuego.actualizarScrollMario(marioObservado);
	}
	
}

