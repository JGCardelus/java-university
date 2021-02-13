public class Cuadrado {
	private int x;
	private int y;
	private int lado;
	private boolean fill;

	Cuadrado(int x, int y, int lado, boolean fill) {
		this.setX(x);
		this.setY(y);
		this.setLado(lado);
		this.setFill(fill);
	}

	// If lado is not given, generate cuadrado of lado 1
	Cuadrado(int x, int y) {
		this(x, y, 1, true);
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}
	
	public boolean getFill() {
		return this.fill;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setLado(int lado) {
		if (lado > 0) {
			this.lado = lado;
		} else {
			this.lado = 1; // Defualt value
		}
	}

	// Wrapper for easy moving
	public void moveTo(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getLado() {
		return this.lado;
	}

	public void print() {
		System.out.println("Cuadrado: (" + this.getX() + ", " + this.getY() + "); " + this.getLado() + "; " + this.getFill());
	}

}
