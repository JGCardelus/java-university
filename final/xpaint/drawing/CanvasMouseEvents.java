package drawing;

import java.awt.event.MouseEvent;

public interface CanvasMouseEvents {
	public void canvasMouseClicked(MouseEvent e);
	public void canvasMousePressed(MouseEvent e);
	public void canvasMouseReleased(MouseEvent e);
	public void canvasMouseMoved(MouseEvent e);
	public void canvasMouseDragged(MouseEvent e);
}
