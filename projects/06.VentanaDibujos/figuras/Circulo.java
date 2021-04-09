package figuras;

import java.awt.Graphics;
import java.awt.Color;

public class Circulo extends Figura {
	private int radius;

	public Circulo(BasicShapeProperties properties) {
		this(properties.x, properties.y, properties.size, DEFAULT_FILL, DEFAULT_COLOR);
	}

	public Circulo(int x, int y, int radius, boolean fill, Color color) {
		super(x, y, fill, color);
		this.setRadius(radius);
	}

	public void setRadius(int radius) {
		if (radius > 0) {
			this.radius = radius;	
		}
	}

	public int getRadius() {
		return this.radius;
	}

	@Override
	public String toString() {
		String info = "Figura: Círculo\n";
		String figureInfo = super.toString();
		info += figureInfo; // Join messages
		// Add custom properties
		info += "\n\tRadio: " + this.getRadius();
		return info;
	}

	@Override
	public void paint(Graphics graphics) {
		graphics.setColor(this.getColor());
		graphics.drawOval(this.getX(), this.getY(), this.getRadius(), this.getRadius());
		if (this.isFill()) {
			// radius + 1 to fully fill
			graphics.fillOval(this.getX(), this.getY(), this.getRadius() + 1, this.getRadius() + 1);
		}
	}
}
