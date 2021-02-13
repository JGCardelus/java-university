import java.awt.*;
import javax.swing.JFrame;

public class Lienzo extends Canvas
{
	private Cuadrado cuadrados[];
	private boolean guardarCuadrados;

	public void setGuardarCuadrados(boolean guardarCuadrados) {
		this.guardarCuadrados = guardarCuadrados;
	}

	public boolean getGuardarCuadrados() {
		return this.guardarCuadrados;
	}

	/**
	 * Draws one square.
	 * @param cuadrado
	 */
	public void pintar(Cuadrado cuadrado)
	{	
		Cuadrado cuadrados[] = new Cuadrado[]{cuadrado};
		// Call more generic method
		this.pintar(cuadrados);
	}

	/**
	 * Paints multiple squares at once
	 * @param cuadrados
	*/
	public void pintar(Cuadrado cuadrados[]) {
		if (this.getGuardarCuadrados()) {
			// If flag guardarCuadrados is activated, add cuadrado to buffer
			this.addCuadrados(cuadrados);
		} else {
			this.cuadrados = cuadrados;
		}
	}

	/**
	 * Adds cuadrados to the cuadrados buffer
	 * @param cuadrados
	 * @return
	 */
	public Cuadrado[] addCuadrados(Cuadrado cuadrados[]) {
		// Copy old buffer and clear
		Cuadrado oldBuffer[] = this.clearCuadrados();
		// Create new buffer with extra spaces
		this.cuadrados = new Cuadrado[oldBuffer.length + cuadrados.length];
		// New buffer is the sum of old buffer plus new items
		this.concatenateToCuadrados(oldBuffer);
		this.concatenateToCuadrados(cuadrados);

		// Return just in case user wants to use them
		return this.cuadrados;
	}

	/**
	 * Concatenate an array of cuadrados to the cuadrados buffer.
	 * @param cuadrados
	 */
	public void concatenateToCuadrados(Cuadrado cuadrados[]) {
		int position = 0;
		for (int i = 0; i < this.cuadrados.length; i++) {
			if (this.cuadrados[i] == null && position < cuadrados.length) {
				this.cuadrados[i] = cuadrados[position];
				position++;
			}
		}
	}

	/**
	 * Return cuadrados array and clear
	 * @return
	 */
	public Cuadrado[] clearCuadrados() {
		Cuadrado oldBuffer[];
		if (this.cuadrados == null) {
			oldBuffer = new Cuadrado[0];
		} else {
			oldBuffer = this.cuadrados;
		}

		this.cuadrados = new Cuadrado[0];
		return oldBuffer;
	}

	/**
	 * Paints cuadrados in cuadrados buffer
	 * @param graphics
	 */
	public void paint(Graphics graphics)
	{
		for (Cuadrado cuadrado:this.cuadrados) {
			if (cuadrado != null) {
				// Draw cuadrado
				graphics.setColor(Color.BLUE);
				graphics.drawRect(cuadrado.getX(), cuadrado.getY(), cuadrado.getLado(), cuadrado.getLado());
				
				if (cuadrado.getFill()) {
					graphics.fillRect(cuadrado.getX(), cuadrado.getY(), cuadrado.getLado(), cuadrado.getLado());
				}
			}
		}
	}
}