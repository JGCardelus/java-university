public class AppDibujo01 {

	public static void main(String[] args) {
		// Create frame 600 by 600
		Dibujo dibujo = new Dibujo(600, 600);
		Util util = new Util();
		// Create the square
		Cuadrado cuadrado = new Cuadrado(100, 100, 200);
		dibujo.pintar(cuadrado);
		util.wait(1);

		Cuadrado cuadrado2 = new Cuadrado(400, 400, 100);
		dibujo.pintar(cuadrado2);
		util.wait(1);

		Cuadrado cuadrado3 = new Cuadrado(100, 400, 50);
		dibujo.pintar(cuadrado3);
		util.wait(1);
	}
}
