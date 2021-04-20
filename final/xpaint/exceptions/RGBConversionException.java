package exceptions;

public class RGBConversionException extends Exception {
	private int r;
	private int g;
	private int b;
	
	public RGBConversionException(int r, int g, int b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

	private boolean isIncorrect(int a) {
		if (a < 0 || a > 255) {
			return true;
		}
		return false;
	}

	public boolean isRed() {
		return this.isIncorrect(this.r);
	}

	public boolean isBlue() {
		return this.isIncorrect(this.b);
	}

	public boolean isGreen() {
		return this.isIncorrect(this.g);
	}

	public String colorErrorMessage(String name, int c) {
		StringBuilder sb = new StringBuilder("El");
		sb.append(name).append(" tiene un valor de ").append(c).append(" y tiene que estar en el rango [0-255]");
		return sb.toString();
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Error al convertir a RGB. ");
		if (r > 255) {
			sb.append(this.colorErrorMessage("rojo", r));
		}
		if (g > 255) {
			sb.append(this.colorErrorMessage("verde", g));
		}
		if (b > 255) {
			sb.append(this.colorErrorMessage("azul", b));
		}
		return sb.toString();
	}

	
}
