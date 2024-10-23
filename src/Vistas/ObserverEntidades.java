package Vistas;

import Entidades.EntidadLogica;


public class ObserverEntidades extends ObserverGrafico {

	public ObserverEntidades(EntidadLogica entidadObservada) {
		super(entidadObservada);
		actualizar();
	}

	public void actualizar() {
		if (entidadObservada.estaEliminada()) {
			this.setVisible(false);
			this.getParent().remove(this);
		}
		else
			super.actualizar();
	}

}
