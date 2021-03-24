package figuras;

import java.awt.*; // Probably could only import color

public class Circulo extends Figura {
	private int radio;

	public Circulo(int x, int y, int radio, boolean relleno, Color color) {
		super(x, y, relleno, color);
		this.setRadio(radio);
	}

	public void setRadio(int radio) {
		if (radio > 0) {
			this.radio = radio;	
		}
	}

	public int getRadio() {
		return this.radio;
	}

	@Override
	public String getInfo() {
		String info = "Figura: Círculo\n";
		String figureInfo = super.getInfo();
		info += figureInfo; // Join messages
		// Add custom properties
		info += "\n\tRadio: " + this.getRadio();
		return info;
	}

	@Override
	public void pintar(Graphics graphics) {
		graphics.setColor(this.getColor());
		graphics.drawOval(this.getX(), this.getY(), this.getRadio(), this.getRadio());
		if (this.isRelleno()) {
			// radio + 1 to fully fill
			graphics.fillOval(this.getX(), this.getY(), this.getRadio() + 1, this.getRadio() + 1);
		}
	}
}
