package gui;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.*;

import gui.images.*;
import pintores.Const;
import pintores.PaintProcess;

public class Ventana extends JFrame implements Const {
	
	private ArrayList<Dibujo> figuras = new ArrayList<>();
	private Lienzo lienzo;
	
	public Ventana() {
		super("Lienzo de pintura");
		
		this.setBounds(100, 40, 800, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.GRAY);
        this.setVisible(true);
        
        JButton bpintar = new JButton("Pintar");
        bpintar.setLocation(150, 600);
        bpintar.setSize(100, 30);
        bpintar.addActionListener(e -> PaintProcess.getInstance().comenzar(FIGURAS));
        getContentPane().add(bpintar);
        
        lienzo = new Lienzo();
        lienzo.setLocation(20, 20);
        lienzo.setSize(700, 540);
        getContentPane().add(this.lienzo);
        
        this.getContentPane().setLayout(null);
	}
	
	public void agregarFigura(Dibujo figura) {
		lienzo.agregarFigura(figura);
	}
	
}
