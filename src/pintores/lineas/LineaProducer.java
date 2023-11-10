package pintores.lineas;

import java.util.Queue;

import pintores.*;
import pintores.lunares.LunarPintor;

public class LineaProducer extends Thread implements Const {
	
	private Queue<Pintor> pintores;
	private PintorFactory factory;
	private int[][] info;
	private int figuras;
	
	public LineaProducer(Queue<Pintor> cola) {
		this.pintores = cola;
		factory = new PintorFactory(Estilo.lineas);	
		this.figuras = 0; 
	}
	
	public void crearLinea(int[][] info) {
		Pintor pintor = factory.crearPintor(info);
		pintores.add(pintor);
	}
	
	public void parar() {	
		this.figuras = 0; 
		interrupt();
	}
	
	public void setFiguras(int i) {
		this.figuras = i;
	}
	
	public void run() {	
		for (int i = figuras; i > 0; i--) {
			try {
				int[][] info = PaintProcess.getInfo();
				crearLinea(info);
				System.out.println("Pintando Lineas");
				Thread.sleep(ESPERA_PRODUCER);
			} catch (Exception ex) {
				
			}
		}
	}

}
