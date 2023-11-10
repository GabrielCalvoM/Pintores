package pintores.formas;

import java.util.Queue;

import pintores.Const;
import pintores.Estilo;
import pintores.PaintProcess;
import pintores.Pintor;
import pintores.PintorFactory;

public class FormaProducer extends Thread implements Const {
	
	private Queue<Pintor> pintores;
	private PintorFactory factory;
	private int[][] info;
	private int figuras;
	
	public FormaProducer(Queue<Pintor> cola) {
		this.pintores = cola;
		factory = new PintorFactory(Estilo.formas);
		this.figuras = 0; 
	}
	
	public void crearForma(int[][] info) {
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
				crearForma(info);
				System.out.println("Pintando Formas");
				Thread.sleep(ESPERA_PRODUCER);
			} catch (Exception ex) {
				
			}
		}
	}

}
