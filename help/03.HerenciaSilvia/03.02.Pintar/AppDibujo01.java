import java.awt.Color;

public class AppDibujo01 {
	public static void main(String args[]) {
		Cuadrado cuadrado1 = new Cuadrado(0,0,true,Color.PINK,100);
		Cuadrado cuadrado2 = new Cuadrado(100,100,false,Color.BLUE,100);

		Circulo circulo1 = new Circulo(200,200,false,Color.ORANGE,100);
		Circulo circulo2 = new Circulo(300,300,true,Color.GREEN,100);

		Figura figuras[] = {cuadrado1, cuadrado2, circulo1, circulo2};
		
		Dibujo dibujo = new Dibujo();
		dibujo.pintar(figuras);
	}
}
