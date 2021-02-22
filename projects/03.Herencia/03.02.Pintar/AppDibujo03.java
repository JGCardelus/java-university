import java.awt.Color;

public class AppDibujo03 {
	public static void main(String args[]) {
		Dibujo dibujo = new Dibujo();
		int squares = 50;
		int waitTime = 40;
		while (true)  {
			for (int i = 0; i < squares; i++) {
				int pos = 5 * i + 80;

				Cuadrado cuadrado = new Cuadrado(pos, pos, 100, false, Color.PINK);
				dibujo.pintar(cuadrado);
				Util.waitMilli(waitTime);
			}

			for (int i = 0; i < squares; i++) {
				dibujo.removeFigura(i);
				dibujo.repintar();
				Util.waitMilli(waitTime);
			}

			dibujo.clearFiguras();
			dibujo.repintar();
			Util.waitMilli(waitTime);

			for (int i = 0; i < squares; i++) {
				int pos = (5 * (squares - 1) + 80) - (5 * i);
				Cuadrado cuadrado = new Cuadrado(pos, pos, 100, false, Color.PINK);
				dibujo.pintar(cuadrado);
				Util.waitMilli(waitTime);
			}

			for (int i = 0; i < squares; i++) {
				dibujo.removeFigura(i);
				dibujo.repintar();
				Util.waitMilli(waitTime);
			}

			dibujo.clearFiguras();
			dibujo.repintar();
			Util.waitMilli(waitTime);
		}
		
	}
}
