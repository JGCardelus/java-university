import java.awt.*;

public class AppDibujo01 {
	public static void main(String args[]) {
		Cuadrado cuadrado1 = new Cuadrado(100, 100, false, Color.PINK, 200);
		Circulo circulo1 = new Circulo(200, 200, false, Color.PINK, 200);
		Cuadrado cuadrado2 = new Cuadrado(300, 300, true, Color.PINK, 200);
		Circulo circulo2 = new Circulo(400, 400, true, Color.PINK, 200);

		Figura figuras[] = {cuadrado1, circulo1, cuadrado2, circulo2};
		Dibujo dibujo = new Dibujo();
		dibujo.pintar(figuras);
	}
}
