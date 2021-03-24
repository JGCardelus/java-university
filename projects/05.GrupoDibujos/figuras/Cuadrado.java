package figuras;

import java.awt.*; // Probably could only import color

public class Cuadrado extends Figura {
	private int lado;

	public Cuadrado(int x, int y, int lado, boolean relleno, Color color) {
		// Set common properties in figura
		super(x, y, relleno, color);
		this.setLado(lado);
	}

	public void setLado(int lado) {
		if (lado > 0) {
			this.lado = lado;
		}
	}

	public int getLado() {
		return this.lado;
	}

	@Override
	public String getInfo() {
		String info = "Figura: Cuadrado\n";
		String figureInfo = super.getInfo();
		info += figureInfo; // Join messages
		// Add custom properties
		info += "\n\tLado: " + this.getLado();
		return info;
	}

	@Override
	public void pintar(Graphics graphics) {
		graphics.setColor(this.getColor());
		graphics.drawRect(this.getX(), this.getY(), this.getLado(), this.getLado());
		if (this.isRelleno()) {
			graphics.fillRect(this.getX(), this.getY(), this.getLado(), this.getLado());
		}
	}
}
