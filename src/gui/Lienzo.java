package gui;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import gui.images.Dibujo;
import gui.images.Forma;
import gui.images.Linea;
import gui.images.Lunar;

public class Lienzo extends JPanel {
	
	private ArrayList<Dibujo> figuras = new ArrayList<>();
	
	public Lienzo() {
		super();
	}
	
	public void agregarFigura(Dibujo figura) {
		figuras.add(figura);
		repaint();
	}
	
	public void paint(Graphics g) {
        super.paint(g);

        for (Dibujo figura : figuras) {
            g.setColor(figura.getColor());
            
            if (figura instanceof Lunar)
            	g.fillOval(figura.getX(), figura.getY(), figura.getAncho(), figura.getAlto());
            
            if (figura instanceof Linea) {
            	Linea linea = (Linea) figura;
            	Graphics2D g2d = (Graphics2D) g;
            	
            	g2d.setStroke(new BasicStroke(linea.getGrosor()));
                g2d.drawLine(figura.getX(), figura.getY(), figura.getAncho(), figura.getAlto());
            }
            
            if (figura instanceof Forma) {
            	g.fillRect(figura.getX(), figura.getY(), figura.getAncho(), figura.getAlto());
            }
        }
    }

}
