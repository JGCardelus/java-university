import java.awt.*; // Probably could only import color

public class Circulo extends Figura {
	private int radio;

	Circulo(int x, int y, int radio, boolean relleno, Color color) {
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
}
