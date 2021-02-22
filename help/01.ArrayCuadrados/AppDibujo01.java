public class AppDibujo01 {

	public static void main(String[] args) {
		// Create frame 600 by 600
		Dibujo dibujo = new Dibujo();
		
		// Create the square
		Cuadrado.setRELLENO(true);
		Cuadrado cuadrados[];

		Cuadrado cuadrado = new Cuadrado(100, 100, 100);
		Cuadrado cuadrado2 = new Cuadrado(200, 200, 100);
		Cuadrado cuadrado3 = new Cuadrado(300, 300, 100);

		cuadrados = new Cuadrado[]{cuadrado, cuadrado2, cuadrado3};

		dibujo.pintar(cuadrados);
		Util.wait(1);
	}
}
