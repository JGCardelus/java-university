import java.awt.*;

public class Circulo extends Figura {
	private int radio;

	Circulo(int x, int y, boolean relleno, Color color, int radio) {
		super(x, y, relleno, color);
		this.setRadio(radio);
	}

	public void setRadio(int radio) {
		if (radio > 0) {
			this.radio = radio;
		} else {
			this.radio = 100;
		}
	}

	public int getRadio() {
		return this.radio;
	}

	@Override
	public String getInfo() {
		// this. -> clase acutal
		// super. -> clase padre / superclase
		String figuraInfo = super.getInfo();
		return 
			"Circulo: " + figuraInfo +
			"\n\tRadio: " + this.getRadio();
	}

	@Override
	public void pintar(Graphics graphics) {
		graphics.setColor(this.getColor());
		graphics.drawOval(this.getX(), this.getY(), this.getRadio(), this.getRadio());
		if (this.isRelleno()) {
			graphics.fillOval(this.getX(), this.getY(), this.getRadio() + 1, this.getRadio() + 1);
		}
	}
}
