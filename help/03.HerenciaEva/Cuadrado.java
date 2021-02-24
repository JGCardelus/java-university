import java.awt.*;

public class Cuadrado extends Figura{
	private int lado;
	public static final int DEFAULT_LADO = 100;
	
	Cuadrado(int x, int y, boolean relleno, Color color, int lado) {
		super(x, y, relleno, color);
		this.setLado(lado);
	}

	public void setLado(int lado) {
		if (lado > 0) {
			this.lado = lado;
		} else {
			this.lado = DEFAULT_LADO;
		}
	}

	public int getLado() {
		return this.lado;
	}

	@Override
	public String getInfo() {
		String infoDeLaFigura = super.getInfo();
		return "Cuadrado: " + infoDeLaFigura + "\n\tLado: " + this.getLado();
	}

	@Override
	public void pintar(Graphics graphics) {
		graphics.setColor(this.getColor());
		graphics.drawRect(this.getX(), this.getY(), this.getLado(), this.getLado());
		if (this.isRelleno())
			graphics.fillRect(this.getX(), this.getY(), this.getLado(), this.getLado());
	}
}
