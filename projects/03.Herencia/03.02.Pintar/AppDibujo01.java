import java.awt.*; // Probably could only import color

public class AppDibujo01 {
	public static void main(String args[]) {
		Dibujo dibujo = new Dibujo();

		// Create two squares
		Cuadrado cuadrado1 = new Cuadrado(0,0,100,true,Color.GREEN);
		Cuadrado cuadrado2 = new Cuadrado(100,100,100,false,Color.BLUE);

		// Create two circles
		Circulo circulo1 = new Circulo(200,200,100,true,Color.ORANGE);
		Circulo circulo2 = new Circulo(300,300,100,true,Color.PINK);

		Figura[] figuras = {cuadrado1, circulo1, cuadrado2, circulo2};

		dibujo.pintar(figuras);
	}
}
