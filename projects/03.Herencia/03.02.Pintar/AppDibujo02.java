import java.awt.Color;

public class AppDibujo02 {
	public static void main(String args[]) {
		Dibujo dibujo = new Dibujo();
		for (int i = 0; i < 10; i++) {
			boolean relleno = false;
			if (i % 3 == 0) {
				relleno = true;
				// Fill every third square
			}
			int x = 20 * i;
			int y = 20 * i;
			Cuadrado cuadrado = new Cuadrado(x, y, 100, relleno, Color.PINK);
			dibujo.pintar(cuadrado);
			Util.wait(1);
		}
	}
}
