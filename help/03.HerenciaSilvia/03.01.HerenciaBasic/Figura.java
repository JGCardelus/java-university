import java.awt.Color;

public abstract class Figura {
	private int x;
	private int y;
	private boolean relleno;
	private Color color;

	Figura(int x, int y, boolean relleno, Color color) {
		this.setX(x);
		this.setY(y);
		this.setRelleno(relleno);
		this.setColor(color);
	}

	public void setX(int x) {
		if (x >= 0) {
			this.x = x;
		}
	}

	public int getX() {
		return this.x;
	}

	public void setY(int y) {
		if (y >= 0) {
			this.y = y;
		}
	}

	public int getY() {
		return this.y;
	}

	public void setRelleno(boolean relleno) {
		this.relleno = relleno;
	}

	public boolean getRelleno() {
		return this.relleno;
	}

	// Wrapper for getRelleno
	public boolean isRelleno() {
		return this.getRelleno();
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return this.color;
	}

	public String getInfo() {
		return
			"\n\tX: " + this.getX() + ", Y: " + this.getY() +
			"\n\tRelleno: " + this.getRelleno() +
			"\n\tColor: " + this.getColor();
	}
}	
