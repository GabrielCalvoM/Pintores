package pintores.formas;

import gui.VentanaController;
import gui.images.Forma;
import pintores.Const;
import pintores.Pintor;

public class FormaPintor extends Pintor implements Const {
	
	public FormaPintor(int color, int[] tam, int[] pos) {
		super(color, tam, pos);
		calcularDatos();
	}
	
	@Override
	protected void calcularDatos() {
		iColor = ((iColor * 83) + 825) % 8;
		size[0] = ((size[0] * 37) + 273) % 100;
		size[1] = ((size[1] * 233) + 725) % 80;
		posicion[0] = ((posicion[0] * 343) + 463) % 600;
		posicion[1] = ((posicion[1] * 521) + 123) % 500;
	}

	@Override
	public void pintar() {
		VentanaController.getInstance().getVentana().agregarFigura(new Forma(posicion[0], posicion[1], size[0], size[1], color[iColor]));
	}

}
