package gui;

import java.awt.Graphics;

import javax.swing.JPanel;

import gui.images.Dibujo;

public class VentanaController {
	
	static private VentanaController instancia;
	private Ventana ventana;
	
	private VentanaController() {
		ventana = new Ventana();
	}
	
	static public VentanaController getInstance() {
		if (instancia == null) {
			instancia = new VentanaController();
		}
		
		return instancia;
	}
	
	public Ventana getVentana() {
		return ventana;
	}
	
	public void agregarFigura(Dibujo figura) {
		ventana.agregarFigura(figura);
	}
	
	public void actualizar() {
		this.ventana.repaint();
	}
	
}
