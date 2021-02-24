import java.awt.*;
import javax.swing.JFrame;

public class Lienzo extends Canvas
{
	private Figura figuras[];
	
	public void pintar(Figura figuras[])
	{
		this.figuras = figuras;
	}

	public void paint(Graphics graphics)
	{
		for (Figura figura:this.figuras)
			if(figura!=null)
				figura.pintar(graphics); // ;)
	}
}