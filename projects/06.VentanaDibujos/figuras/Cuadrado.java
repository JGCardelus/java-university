package figuras;

import java.awt.Graphics;
import java.awt.Color;

public class Cuadrado extends Figura {
	private int height;

	public Cuadrado(BasicShapeProperties properties) {
		this(properties.x, properties.y, properties.size, DEFAULT_FILL, DEFAULT_COLOR);
	}

	public Cuadrado(int x, int y, int height, boolean fill, Color color) {
		// Set common properties in figura
		super(x, y, fill, color);
		this.setHeight(height);
	}

	public void setHeight(int height) {
		if (height > 0) {
			this.height = height;
		}
	}

	public int getHeight() {
		return this.height;
	}

	@Override
	public String toString() {
		String info = "Figura: Cuadrado\n";
		String figureInfo = super.toString();
		info += figureInfo; // Join messages
		// Add custom properties
		info += "\n\tLado: " + this.getHeight();
		return info;
	}

	@Override
	public void paint(Graphics graphics) {
		graphics.setColor(this.getColor());
		graphics.drawRect(this.getX(), this.getY(), this.getHeight(), this.getHeight());
		if (this.isFill()) {
			graphics.fillRect(this.getX(), this.getY(), this.getHeight(), this.getHeight());
		}
	}
}
