import java.awt.Color;

import jdk.javadoc.internal.doclets.formats.html.resources.standard;

public class AppDibujo02 {
	public static void main(String args[]) {
		Cuadrado cuadrado1 = new Cuadrado(0,0,true,Color.PINK,100);
		Cuadrado cuadrado2 = new Cuadrado(100,100,false,Color.BLUE,200);

		Circulo circulo1 = new Circulo(200,200,false,Color.ORANGE,100);
		Circulo circulo2 = new Circulo(300,300,false,Color.GREEN,200);

		Figura figuras[] = {cuadrado1, cuadrado2, circulo1, circulo2};

		// Intermedia
		Dibujo dibujo = new Dibujo();
		for (int i = 0; i < figuras.length; i++) {
			// Defino un array de i + 1 posiciones
			Figura figurasAPintar[] = new Figura[i+1];

			for (int j = 0; j < figurasAPintar.length; j++) {
				// En la posición j meto la figura que hay en j
				figurasAPintar[j] = figuras[j]; 
			}

			dibujo.pintar(figurasAPintar);
			Util.wait(1);
		}

		// Fácil
		// Dibujo dibujo = new Dibujo();
		// figuras = new Figura[4];

		// figuras[0] = cuadrado1;
		// dibujo.pintar(figuras);
		// Util.wait(1);

		// figuras[1] = cuadrado2;
		// dibujo.pintar(figuras);
		// Util.wait(1);
	}
}
