import java.awt.*;
import javax.swing.JFrame;

/** 
	Facilita la representación gráfica de objetos creados por el alumno mediante una ventana gráfica y un lienzo 
*/
public class Dibujo extends JFrame
{
	private Lienzo lienzo;

	public Dibujo()
	{
		super("Dibujo");

		// Create canvas
		lienzo = new Lienzo();
		lienzo.setSize(600,600);
		this.add(lienzo);
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	/** 
		Pinta el cuadrado recibido por el App y actualiza el lienzo (canvas) 
		@param cuadrado cuadrado a pintar
	*/
	public void pintar(Figura figuras[])
	{
		lienzo.pintar(figuras);
		lienzo.repaint();
	}

}