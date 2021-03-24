import figuras.*;
import utils.*;

import java.awt.*;
import javax.swing.JFrame;

public class App {
	public static void main(String args[]) {
		Ventana ventana = new Ventana();
		Dibujo dibujo = new Dibujo();

		String rojo = "Rojo"; // Autoboxing
		String amarillo = "Amarillo";
		String rojo1 = "Rojo1";

		dibujo.pintar(rojo, new Cuadrado(40, 40, 40, true, Color.BLUE));
		dibujo.pintar(rojo, new Cuadrado(80, 80, 40, true, Color.PINK));
		dibujo.pintar(rojo, new Cuadrado(120, 120, 40, true, Color.LIGHT_GRAY));

		dibujo.pintar(amarillo, new Circulo(160, 160, 40, true, Color.BLUE));
		dibujo.pintar(amarillo, new Circulo(200, 200, 40, true, Color.MAGENTA));
		dibujo.pintar(amarillo, new Circulo(240, 240, 40, true, Color.RED));

		dibujo.pintar(rojo1, new Circulo(280, 280, 40, true, Color.GREEN));
		dibujo.pintar(rojo1, new Circulo(320, 320, 40, true, Color.ORANGE));
		dibujo.pintar(rojo1, new Circulo(360, 360, 40, true, Color.BLACK));

		ventana.pintar(dibujo);

		Util.waitMilli(300);

		dibujo.setColorGrupo(rojo, Color.RED);
		dibujo.setColorGrupo(amarillo, Color.YELLOW);
		dibujo.setColorGrupo(rojo1, Color.RED);
		
		ventana.pintar(dibujo);
		
		System.out.println("Hello!");
		Util.waitMilli(500);
		while (true) {
			dibujo.ocultarGrupo(rojo);
			Util.waitMilli(500);
			ventana.pintar(dibujo);
			
			dibujo.ocultarGrupo(amarillo);
			Util.waitMilli(500);
			ventana.pintar(dibujo);

			dibujo.ocultarGrupo(rojo1);
			Util.waitMilli(500);
			ventana.pintar(dibujo);

			dibujo.mostrarGrupo(rojo);
			Util.waitMilli(500);
			ventana.pintar(dibujo);
			
			dibujo.mostrarGrupo(amarillo);
			Util.waitMilli(500);
			ventana.pintar(dibujo);

			dibujo.mostrarGrupo(rojo1);
			Util.waitMilli(500);
			ventana.pintar(dibujo);
		}
		
	}
}
