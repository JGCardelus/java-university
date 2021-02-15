public class AppDibujo02 {
	public static void main(String args[]) {
		Dibujo dibujo = new Dibujo();
		Cuadrado cuadrados[] = new Cuadrado[3];

		Cuadrado.setFILL(true);
		for (int i = 0; i < 3; i++) {
			int lado = 100;
			Cuadrado cuadrado = new Cuadrado((dibujo.getSizeX() - 100*i - lado), 100*i, lado);
			dibujo.pintar(cuadrado);
			Util.wait(1);
		}
	}
}
