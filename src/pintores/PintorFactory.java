package pintores;

import pintores.formas.FormaPintor;
import pintores.lineas.LineaPintor;
import pintores.lunares.LunarPintor;

public class PintorFactory implements Const {
	
	private Estilo estilo;
	
	public PintorFactory(Estilo style) {
		this.estilo = style;
	}
	
	public Pintor crearPintor(int[][] info) {
		
		if (estilo == Estilo.lunares) {
			return new LunarPintor(info[0][0], info[1], info[2]);
		}
		else if (estilo == Estilo.lineas) {
			return new LineaPintor(info[0][0], info[1], info[2]);
		}
		else if (estilo == Estilo.formas) {
			return new FormaPintor(info[0][0], info[1], info[2]);
		}
		
		return null;
	}
	
}
