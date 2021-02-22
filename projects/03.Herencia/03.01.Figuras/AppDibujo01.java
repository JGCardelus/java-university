import java.awt.*; // Probably could only import color

public class AppDibujo01 {
	public static void main(String args[]) {
		// Create two squares
		Cuadrado cuadrado1 = new Cuadrado(0,0,10,true,Color.GREEN);
		Cuadrado cuadrado2 = new Cuadrado(100,100,20,false,Color.BLUE);

		// Create two circles
		Circulo circulo1 = new Circulo(200,200,30,true,Color.LIGHT_GRAY);
		Circulo circulo2 = new Circulo(300,300,40,false,Color.PINK);

		Figura[] figuras = {cuadrado1, circulo1, cuadrado2, circulo2};

		// Print their information
		for (Figura figura:figuras) {
			System.out.println(figura.getInfo());
		}
	}
}
