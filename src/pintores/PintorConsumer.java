package pintores;

import java.util.Queue;

public class PintorConsumer extends Thread implements Const {
	
	private Queue<Pintor> pintores;
	private int figuras;
	
	public PintorConsumer(Queue<Pintor> cola) {
		if (pintores == null) {
			this.pintores = cola;
		}
		
		this.figuras = 0; 
	}
	
	public void parar() {
		this.figuras = 0;
		interrupt();
	}
	
	public void setFiguras(int i) {
		this.figuras = i;
	}
	
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (Exception ex) {
			
		}

		while (pintores.size() > 0) {
				Pintor pintor = pintores.poll();
				if (pintor != null) {
					pintor.pintar();
					PaintProcess.setInfo(new int[][] {{pintor.iColor}, pintor.posicion, pintor.size});
				}
			try {
				Thread.sleep(ESPERA_CONSUMER);
			} catch (Exception ex) {
				
			}
		}

		System.out.println("Pintura terminada");
		PaintProcess.getInstance().detener();
	}

}
