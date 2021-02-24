import java.awt.Color;

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
}
