package pintores.lineas;

import gui.VentanaController;
import gui.images.Linea;
import pintores.Const;
import pintores.Pintor;

public class LineaPintor extends Pintor implements Const {
	
	public LineaPintor(int color, int[] tam, int[] pos) {
		super(color, tam, pos);
		calcularDatos();
	}
	
	@Override
	protected void calcularDatos() {
		iColor = ((iColor * 97) + 523) % 8;
		int size0 = ((size[0] * 62) + 237) % 500;
		int size1 = ((size[1] * 157) + 623) % 450;
		int size2 = ((size[0] * 95) + size[1]) % 10;
		size = new int[] {size0, size1, size2};
		posicion[0] = ((posicion[0] * 37) + 543) % 600;
		posicion[1] = ((posicion[1] * 63) + 565) % 500;
	}

	@Override
	public void pintar() {
		VentanaController.getInstance().getVentana().agregarFigura(new Linea(posicion[0], posicion[1], size[0], size[1], size[2], color[iColor]));
	}
	
}
