import java.awt.*;

public class Cuadrado extends Figura {
	private int lado;

	Cuadrado(int x, int y, boolean relleno, Color color, int lado) {
		super(x, y, relleno, color);
		this.setLado(lado);
	}

	public void setLado(int lado) {
		if (lado > 0) {
			this.lado = lado;
		} else {
			this.lado = 100;
		}
	}

	public int getLado() {
		return this.lado;
	}

	@Override
	public String getInfo() {
		// this. -> clase acutal
		// super. -> clase padre / superclase
		String figuraInfo = super.getInfo();
		return 
			"Cuadrado: " + figuraInfo +
			"\n\tLado: " + this.getLado();
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
