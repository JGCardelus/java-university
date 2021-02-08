public class AppDibujo02 {
	public static void main(String[] args) {
		// Create frame 600 by 600
		Dibujo dibujo = new Dibujo(600, 600);
		Util util = new Util();
		// Create the square
		Cuadrado cuadrado = new Cuadrado(100, 100, 200);
		
		for (int i = 0; i < 2; i++) {
			cuadrado.moveTo(200*i,200*i);
			dibujo.pintar(cuadrado);
			util.wait(1);
		}	

		cuadrado.setLado(500);
		dibujo.setInTheMiddle(cuadrado);
		dibujo.pintar(cuadrado);
		util.wait(1);
	}
}
