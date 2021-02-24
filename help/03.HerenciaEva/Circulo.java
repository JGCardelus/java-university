import java.awt.*;

public class Circulo extends Figura {
	private int radio;
	public static final int DEFAULT_RADIO = 100;
	
	Circulo(int x, int y, boolean relleno, Color color, int radio) {
		super(x, y, relleno, color);
		this.setRadio(radio);
	}

	public void setRadio(int radio) {
		if (radio > 0) {
			this.radio = radio;
		} else {
			this.radio = DEFAULT_RADIO;
		}
	}

	public int getRadio() {
		return this.radio;
	}

	@Override
	public String getInfo() {
		String infoDeLaFigura = super.getInfo();
		return "Circulo: " + infoDeLaFigura + "\n\tRadio: " + this.getRadio();
	}

	@Override
	public void pintar(Graphics graphics) {
		graphics.setColor(this.getColor());
		graphics.drawOval(this.getX(), this.getY(), this.getRadio(), this.getRadio());
		if (this.isRelleno())
			graphics.fillOval(this.getX(), this.getY(), this.getRadio() + 1, this.getRadio() + 1);
	}
}
