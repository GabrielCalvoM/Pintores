package pintores;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

import pintores.lineas.LineaProducer;
import pintores.lunares.LunaresProducer;
import pintores.formas.FormaProducer;

public class PaintProcess extends Thread implements Const {

	private static PaintProcess instancia;
	private Queue<Pintor> pintores;
	private static int[][] info;
	private PintorConsumer[] consumers = new PintorConsumer[PINTOR_CONSUMERS];
	private LunaresProducer[] lunares = new LunaresProducer[LUNARES_PRODUCERS];
	private LineaProducer[] lineas = new LineaProducer[LINEAS_PRODUCERS];
	private FormaProducer[] formas = new FormaProducer[FORMAS_PRODUCERS];
	
	private PaintProcess() {
		pintores = new ConcurrentLinkedQueue<Pintor>();
		crearOjetos();
	}
	
	public static PaintProcess getInstance() {
		if (instancia == null) {
			instancia = new PaintProcess();
		}
		
		return instancia;
	}
	
	public void comenzar(int figuras) {
		info = new int[][] {{0}, {35, 35}, {85, 26}};
		
		for (int i = 0; i < LUNARES_PRODUCERS; i++) {
			lunares[i].setFiguras(figuras);
			lunares[i].start();
		}
		
		for (int i = 0; i < LINEAS_PRODUCERS; i++) {
			lineas[i].setFiguras(figuras);
			lineas[i].start();
		}
		
		for (int i = 0; i < FORMAS_PRODUCERS; i++) {
			formas[i].setFiguras(figuras);
			formas[i].start();
		}
		
		for (int i = 0; i < PINTOR_CONSUMERS; i++) {
			consumers[i].start();
		}
		
	}
	
	public void crearOjetos() {
		for (int i = 0; i < PINTOR_CONSUMERS; i++) {
			consumers[i] = new PintorConsumer(pintores);
		}
		
		for (int i = 0; i < LUNARES_PRODUCERS; i++) {
			lunares[i] = new LunaresProducer(pintores);
		}
		
		for (int i = 0; i < LINEAS_PRODUCERS; i++) {
			lineas[i] = new LineaProducer(pintores);
		}
		
		for (int i = 0; i < FORMAS_PRODUCERS; i++) {
			formas[i] = new FormaProducer(pintores);
		}
	}
	
	public void detener() {
		info = new int[][] {{0}, {35, 35}, {85, 26}};
		
		for (int i = 0; i < PINTOR_CONSUMERS; i++) {
			consumers[i].parar();
		}
		
		for (int i = 0; i < LUNARES_PRODUCERS; i++) {
			lunares[i].parar();
		}
		
		for (int i = 0; i < LINEAS_PRODUCERS; i++) {
			lineas[i].parar();
		}
		
		for (int i = 0; i < FORMAS_PRODUCERS; i++) {
			formas[i].parar();
		}
		
		crearOjetos();
	}
	
	public static void setInfo(int[][] pInfo) {
		info = pInfo;
	}
	
	public static int[][] getInfo() {
		return info;
	}
	
}
