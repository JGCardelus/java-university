import figuras.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

import java.awt.*;
import javax.swing.JFrame;

public class Ventana extends JFrame {

	private Lienzo lienzo;
	private Dibujo dibujo;

	private int sizeX;
	private int sizeY;

	public final int MAX_SIZE_X = 1920;
	public final int MAX_SIZE_Y = 1080;
	public final int DEFAULT_SIZE = 600;

	public Ventana(int sizeX, int sizeY, Dibujo dibujo) {
		super("Awesome title");

		this.setSizeX(sizeX);
		this.setSizeY(sizeY);

		// Crear lienzo
		lienzo = new Lienzo();
		lienzo.setSize(this.getSizeX(), this.getSizeY());

		// Crar dibujo
		this.setDibujo(dibujo);

		this.add(lienzo);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public Ventana() {
		this(0,0, new Dibujo(new HashMap<String, LinkedList<Figura>>()));
	}

	public void setDibujo(Dibujo dibujo) {
		this.dibujo = dibujo;
	}

	public Dibujo getDibujo() {
		return this.dibujo;
	}

	public void setSizeX(int sizeX) {
		if (sizeX > 0 && sizeX < MAX_SIZE_X) {
			this.sizeX = sizeX;
		} else {
			this.sizeX = DEFAULT_SIZE;
		}
	}

	public int getSizeX() {
		return this.sizeX;
	}

	public void setSizeY(int sizeY) {
		if (sizeY > 0 && sizeY < MAX_SIZE_Y) {
			this.sizeY = sizeY;
		} else {
			this.sizeY = DEFAULT_SIZE;
		}
	}

	public int getSizeY() {
		return this.sizeY;
	}

	public void pintar(Dibujo dibujo) {
		// this.setDibujo(dibujo);
		lienzo.pintar(dibujo);
		this.repintar();
	}

	public void pintar() {
		this.pintar(this.getDibujo());
	}

	public void repintar() {
		lienzo.repaint();
	}
}
