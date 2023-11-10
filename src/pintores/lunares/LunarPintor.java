package pintores.lunares;

import java.awt.*;
import javax.swing.JPanel;

import gui.VentanaController;
import gui.images.Lunar;
import pintores.Const;
import pintores.Pintor;

public class LunarPintor extends Pintor implements Const {

	public LunarPintor(int color, int[] tam, int[] pos) {
		super(color, tam, pos);
		calcularDatos();
	}
	
	@Override
	protected void calcularDatos() {
		iColor = ((iColor * 97) + 523) % 8;
		size[0] = ((size[0] * 89) + 821) % 100;
		size[1] = ((size[1] * 151) + 623) % 80;
		posicion[0] = ((posicion[0] * 87) + 243) % 600;
		posicion[1] = ((posicion[1] * 63) + 565) % 500;
	}

	@Override
	public void pintar() {
		VentanaController.getInstance().getVentana().agregarFigura(new Lunar(posicion[0], posicion[1], size[0], size[0], color[iColor]));
	}

}
