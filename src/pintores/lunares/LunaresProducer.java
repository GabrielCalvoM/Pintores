package pintores.lunares;

import java.util.Queue;

import pintores.*;

public class LunaresProducer extends Thread implements Const {
	
	private Queue<Pintor> pintores;
	private PintorFactory factory;
	private int[][] info;
	private int figuras;
	
	public LunaresProducer(Queue<Pintor> cola) {
		this.pintores = cola;
		factory = new PintorFactory(Estilo.lunares);	
		this.figuras = 0; 
	}
	
	public void crearLunares(int[][] info) {
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
				crearLunares(info);
				System.out.println("Pintando Lunares");
				Thread.sleep(ESPERA_PRODUCER);
			} catch (Exception ex) {
				
			}
		}
	}
	
}
