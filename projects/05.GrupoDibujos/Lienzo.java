import figuras.*;
import utils.*;

import java.util.Collection;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

import java.awt.*;
import javax.swing.JFrame;

public class Lienzo extends Canvas {
	private Dibujo dibujo;

	public void setDibujo(Dibujo dibujo) {
		this.dibujo = dibujo;
	}

	public Dibujo getDibujo() {
		return this.dibujo;
	}

	public void addPaint(Dibujo dibujo) {
		this.setDibujo(dibujo);
	}

	// Añadir métodos para pintar figuras
	public void paint(Graphics graphics) {
		for (LinkedList<Figura> grupo : this.dibujo.getGrupos().values()) {
			for (Figura figura : grupo) {
				if (figura.getMostrar()) {
					figura.pintar(graphics);
				}
			}
		}
	}
}
