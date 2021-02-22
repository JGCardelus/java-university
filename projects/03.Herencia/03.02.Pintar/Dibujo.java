import java.awt.*;
import javax.swing.JFrame;

/**
 * Updated Dibujo class
 * Modifications:
 * 	- Updated pintar for Figura (or multiple figura)
 *  - Updated pintarPath for Figura
 */

public class Dibujo extends JFrame {
	// Frame attributes
	private Lienzo lienzo;

	private int sizeX;
	private int sizeY;

	public final int MAX_SIZE_X = 1920;
	public final int MAX_SIZE_Y = 1080;
	public final int DEFAULT_SIZE = 600;

	public Dibujo(int sizeX, int sizeY, boolean guardarFiguras)
	{
		super("Dibujo");

		// Set canvas size
		this.setSizeX(sizeX);
		this.setSizeY(sizeY);

		// Create canvas
		lienzo = new Lienzo();
		// Possible improvement, join in Lienzo constructor
		lienzo.setSize(this.getSizeX(), this.getSizeY());
		lienzo.setGuardarFiguras(guardarFiguras);

		this.add(lienzo);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public Dibujo() {
		this(0,0, true); // Create canvas of default size
	}

	public void removeFigura(int pos) {
		lienzo.removeFigura(pos);
	}

	public void clearFiguras() {
		lienzo.clearFiguras();
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

	// Wrapper for single Figura
	public void pintar(Figura figura) {
		Figura figuras[] = {figura};
		this.pintar(figuras);
	}

	public void pintar(Figura figuras[]) {
		lienzo.pintar(figuras);
		this.repintar();
	}

	public void repintar() {
		lienzo.repaint();
	}

	/**
	 * Renders the square and makes it go smoothly through the points passed.
	 * From point a to point b it will generate n steps.
	 * Framerate will determine how fast it will complete each step.
	 * @param figura
	 * @param points
	 * @param steps
	 * @param frameRate
	 */
	public void pintarPath(Figura figura, Point[] points, int steps, int frameRate) {
		// Move to initial position
		figura.moveTo(points[0].getX(), points[0].getY());

		// Waiting times
		int waitTime = steps / frameRate;

		for (int i = 0; i < points.length; i++) {
			Point currentPoint = points[i];
			Point nextPoint;
			if ((i+1) == points.length) {
				nextPoint = points[i];
			} else {
				nextPoint = points[i+1];
			}

			// Calculate size of step to get from currentPoint to nextPoint
			// To increase smoothness use float/double
			int stepX = (nextPoint.getX() - currentPoint.getX()) / steps;
			int stepY = (nextPoint.getY() - currentPoint.getY()) / steps;

			for (int j = 0; j < steps; j++) {
				int nextPositionX = this.getNextPos(figura.getX(), nextPoint.getX(), stepX);
				int nextPositionY = this.getNextPos(figura.getY(), nextPoint.getY(), stepY);
				figura.moveTo(nextPositionX, nextPositionY);

				this.pintar(figura);
				Util.waitMilli(waitTime);
			}
		}
	}

	/**
	 * Calculates the next position for pintarPath and avoids 
	 * overstepping. Since we are using ints, it is possible that
	 * the step is rounded to a an higher value integer.
	 * @param current
	 * @param next
	 * @param step
	 * @return
	 */
	public int getNextPos(int current, int next, int step) {
		int nextPosition = current + step;
		if (step > 0) {
			if (nextPosition > next) {
				nextPosition = next;
			}
		} else {
			if (nextPosition < next) {
				nextPosition = next;
			}
		}

		return nextPosition;
	}
}
