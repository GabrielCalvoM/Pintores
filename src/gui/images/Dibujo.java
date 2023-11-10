package gui.images;

import java.awt.Color;

public abstract class Dibujo {
	
	private int x, y, ancho, alto;
	private Color color;
	
	public Dibujo(int x, int y, int ancho, int alto, Color color) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.color = color;
    }
	
	public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAncho() {
        return ancho;
    }

    public int getAlto() {
        return alto;
    }

    public Color getColor() {
        return color;
    }
	
}
