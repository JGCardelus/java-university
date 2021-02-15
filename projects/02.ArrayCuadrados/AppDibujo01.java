public class AppDibujo01 {
	public static void main(String args[]) {
		Dibujo dibujo = new Dibujo();
		Cuadrado cuadrados[] = new Cuadrado[3];

		Cuadrado.setFILL(true);
		for (int i = 0; i < 3; i++) {
			Cuadrado cuadrado = new Cuadrado(100*i, 100*i, 100);
			cuadrados[i] = cuadrado;
		}

		dibujo.pintar(cuadrados);
	}
}