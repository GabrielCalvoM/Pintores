package pintores;

public abstract class Pintor {
	
	protected int iColor;
	protected int[] size;
	protected int[] posicion;
	
	protected Pintor(int color, int[] tam, int[] pos){
		this.iColor = color;
		this.size = tam;
		this.posicion = pos;
	}
	
	protected abstract void calcularDatos();
	public abstract void pintar();

}
