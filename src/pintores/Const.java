package pintores;

import java.awt.Color;

public interface Const {
	
	static Color[] color = {Color.black, Color.green, Color.blue, Color.red, Color.yellow, Color.magenta, Color.orange,
			Color.white};
	
	public static final int LUNARES_PRODUCERS = 1;
	public static final int LINEAS_PRODUCERS = 1;
	public static final int FORMAS_PRODUCERS = 1;
	public static final int PINTOR_CONSUMERS = 1;
	public static final int FIGURAS = 8;
	public static final int ESPERA_PRODUCER = 800;
	public static final int ESPERA_CONSUMER = 300;

}
