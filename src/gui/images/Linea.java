package gui.images;

import java.awt.Color;

public class Linea extends Dibujo {
	
	private int ancho;
	
	public Linea(int x, int y, int x2, int y2, int grosor, Color color) {
		super(x, y, x2, y2, color);
		ancho = grosor; 
	}
	
	public int getGrosor() {
		return ancho;
	}

}
