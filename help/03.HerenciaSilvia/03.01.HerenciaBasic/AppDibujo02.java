import java.awt.Color;

public class AppDibujo02 {
	public static void main(String args[]) {
		Cuadrado cuadrado1 = new Cuadrado(0,0,true,Color.PINK,100);
		Cuadrado cuadrado2 = new Cuadrado(100,100,false,Color.BLUE,200);

		Circulo circulo1 = new Circulo(200,200,false,Color.ORANGE,100);
		Circulo circulo2 = new Circulo(300,300,false,Color.GREEN,200);

		Figura figuras[] = {cuadrado1, cuadrado2, circulo1, circulo2};

		for (Figura figura:figuras) {
			String info = figura.getInfo();
			System.out.println(info);
			Util.wait(1);
		}
	}
}
