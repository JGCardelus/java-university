import java.awt.*;
import javax.swing.JFrame;

public class Lienzo extends Canvas {
	private Figura figuras[];
	private boolean guardarFiguras;

	public void setGuardarFiguras(boolean guardarFiguras) {
		this.guardarFiguras = guardarFiguras;
	}

	public boolean getGuardarFiguras() {
		return this.guardarFiguras;
	}

	/**
	 * Draws one square.
	 * @param figura
	 */
	public void pintar(Figura figura)
	{	
		Figura figuras[] = new Figura[]{figura};
		// Call more generic method
		this.pintar(figuras);
	}

	/**
	 * Paints multiple squares at once
	 * @param figuras
	*/
	public void pintar(Figura figuras[]) {
		if (this.getGuardarFiguras()) {
			// If flag guardarCuadrados is activated, add figura to buffer
			this.addFiguras(figuras);
		} else {
			this.figuras = figuras;
		}
	}

	/**
	 * Adds figuras to the figuras buffer
	 * @param figuras
	 * @return
	 */
	private Figura[] addFiguras(Figura figuras[]) {
		// Copy old buffer and clear
		Figura oldBuffer[] = this.clearFiguras();
		// Create new buffer with extra spaces
		this.figuras = new Figura[oldBuffer.length + figuras.length];
		// New buffer is the sum of old buffer plus new items
		this.concatenateToFiguras(oldBuffer);
		this.concatenateToFiguras(figuras);

		// Return just in case user wants to use them
		return this.figuras;
	}

	/**
	 * Concatenate an array of figuras to the figuras buffer.
	 * @param figuras
	 */
	private void concatenateToFiguras(Figura figuras[]) {
		int position = 0;
		for (int i = 0; i < this.figuras.length; i++) {
			if (this.figuras[i] == null && position < figuras.length) {
				this.figuras[i] = figuras[position];
				position++;
			}
		}
	}

	/**
	 * Return figuras array and clear
	 * @return
	 */
	public Figura[] clearFiguras() {
		Figura oldBuffer[];
		if (this.figuras == null) {
			oldBuffer = new Figura[0];
		} else {
			oldBuffer = this.figuras;
		}

		this.figuras = new Figura[0];
		return oldBuffer;
	}

	public void removeFigura(int pos) {
		if (pos >= 0 && pos < this.figuras.length) {
			// Very lazy!! Change so that position is eliminated not nulled
			this.figuras[pos] = null;
		}
	}

	/**
	 * Paints figuras in figuras buffer
	 * @param graphics
	 */
	public void paint(Graphics graphics)
	{
		for (Figura figura:this.figuras) {
			
			if (figura != null) {
				figura.pintar(graphics);
			}
		}
	}
}
