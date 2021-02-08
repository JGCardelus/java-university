import java.awt.*;
import javax.swing.JFrame;

/** 
	Facilita la representación gráfica de objetos creados por el alumno mediante una ventana gráfica y un lienzo 
*/
public class Dibujo extends JFrame
{
	private Lienzo lienzo;

	int sizeX;
	int sizeY;

	public Dibujo(int sizeX, int sizeY)
	{
		super("Dibujo");

		// Set canvas size
		this.setSizeX(sizeX);
		this.setSizeY(sizeY);

		// Create canvas
		lienzo = new Lienzo();
		lienzo.setSize(this.getSizeX(), this.getSizeY());
		this.add(lienzo);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public Dibujo() {
		this(0,0); // Create canvas of default size
	}

	public void setSizeX(int sizeX) {
		if (sizeX > 0 && sizeX < 1920) {
			this.sizeX = sizeX;
		} else {
			this.sizeX = 800;
		}
	}

	public int getSizeX() {
		return this.sizeX;
	}

	public void setSizeY(int sizeY) {
		if (sizeY > 0 && sizeY < 1080) {
			this.sizeY = sizeY;
		} else {
			this.sizeY = 600;
		}
	}

	public int getSizeY() {
		return this.sizeY;
	}
	/** 
		Pinta el cuadrado recibido por el App y actualiza el lienzo (canvas) 
		@param cuadrado cuadrado a pintar
	*/
	public void pintar(Cuadrado cuadrado)
	{
		lienzo.pintar(cuadrado);
		lienzo.repaint();
	}

	/**
	 * Draws the square in the middle of the canvas, regardless
	 * of the size of the square and the size of the square
	 * @param cuadrado
	 */
	public void setInTheMiddle(Cuadrado cuadrado) {
		int sizeX = this.getSizeX();
		int sizeY = this.getSizeY();
		int lado = cuadrado.getLado();

		int x = (sizeX - lado) / 2;
		int y = (sizeY - lado) / 2;

		cuadrado.setX(x);
		cuadrado.setY(y);
	}

	/**
	 * Renders the square and makes it go smoothly through the points passed.
	 * From point a to point b it will generate n steps.
	 * Framerate will determine how fast it will complete each step.
	 * @param cuadrado
	 * @param points
	 * @param steps
	 * @param frameRate
	 */
	public void pintarPath(Cuadrado cuadrado, Point[] points, int steps, int frameRate) {
		// Move to initial position
		cuadrado.moveTo(points[0].getX(), points[0].getY());

		// Waiting times
		int waitTime = steps / frameRate;
		Util util = new Util();

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
				int nextPositionX = this.getNextPos(cuadrado.getX(), nextPoint.getX(), stepX);
				int nextPositionY = this.getNextPos(cuadrado.getY(), nextPoint.getY(), stepY);
				cuadrado.moveTo(nextPositionX, nextPositionY);

				this.pintar(cuadrado);
				util.waitMilli(waitTime);
			}
		}
	}

	/**
	 * Calculates the next position for pintarPath and avoids 
	 * overstepping (since we are using ints, it is possible that)
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