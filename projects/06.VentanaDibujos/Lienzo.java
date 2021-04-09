import java.util.Collection;

import java.awt.Canvas;
import java.awt.Graphics;

// Project imports
import figuras.*;

public class Lienzo extends Canvas {
	private JVentanaDibujo jVentanaDibujo;

	Lienzo(JVentanaDibujo jVentanaDibujo) {
		this.setJVentanaDibujo(jVentanaDibujo);
	}

	public void setJVentanaDibujo(JVentanaDibujo jVentanaDibujo) {
		this.jVentanaDibujo = jVentanaDibujo;
	}

	public JVentanaDibujo getJVentanaDibujo() {
		return this.jVentanaDibujo;
	}

	public void paint(Graphics graphics) {
		Dibujo dibujo = this.jVentanaDibujo.getDibujo();
		if (dibujo == null) {
			return; // JIT
		}
		for(Collection<Figura> figuras : dibujo.getGroups().values())	{
			for (Figura figura : figuras)
				if (figura.isVisible())
					figura.paint(graphics);
		}
	}

}
