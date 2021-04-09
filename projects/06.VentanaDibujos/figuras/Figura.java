package figuras;

import java.awt.*; // Import everything inside java.awt
import javax.swing.JFrame;

public abstract class Figura {
	private int x;
	private int y;
	private boolean fill;
	private boolean visibility;
	private Color color;

	public static final boolean DEFAULT_FILL = false;
	public static final Color DEFAULT_COLOR = Color.BLUE;

	// Most comprehensive constructor
	public Figura(int x, int y, boolean fill, Color color) {
		this.setX(x);
		this.setY(y);
		this.setFill(fill);
		this.setColor(color);


		// By default show drawing
		this.setVisibility(true);
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}

	public boolean getVisibility() {
		return this.visibility;
	}

	// Wrapper around getVisibility
	public boolean isVisible() {
		return this.getVisibility();
	}

	public void setX(int x) {
		// Possible upgrades, pair with Lienzo to avoid
		// setting a Figura outside canvas
		if (x >= 0) {
			this.x = x;
		}
	}

	public void setY(int y) {
		if (y >= 0) {
			this.y = y;
		}
	}

	public void moveTo(int x, int y) {
		this.setX(x);
		this.setY(y);
	}

	public void setFill(boolean fill) {
		this.fill = fill;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public boolean getFill() {
		return this.fill;
	}

	// Method for sintatic bliss
	public boolean isFill() {
		return this.getFill();
	}

	public Color getColor() {
		return this.color;
	}

	@Override
	public String toString() {
		return "\tPosición: (" + this.getX() + ", " + this.getY() + ")\n\tRelleno: " + this.getFill() + "\n\tColor: " + this.getColor().toString();
	}

	public abstract void paint(Graphics graphics);
}

