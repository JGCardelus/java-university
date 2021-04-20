package drawing.shapes;

import drawing.CanvasMouseEvents;
import drawing.Point;
import drawing.Size;

import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Shape;


public abstract class XShape implements CanvasMouseEvents {
	// SHAPE ATTRIBUTES
	private boolean isDefined;
	private boolean isSelector;
	private boolean isSelected;

	private Color color;
	private boolean isFilled;
	private boolean isVisible;

	private Shape shape;

	public static final Color DEFAULT_COLOR = Color.BLACK;
	public static final Color UNDEFINED_SHAPE_COLOR = Color.BLACK;
	public static final Color SELECTED_COLOR = Color.BLUE;

	public static final boolean DEFAULT_FILL = false;
	public static final boolean DEFAULT_VISIBILITY = true;
	public static final boolean DEFAULT_DEFINITION = false;
	public static final boolean DEFAULT_IS_SELECTOR = false;

	XShape() {
		this.setColor(DEFAULT_COLOR);
		this.setFilled(DEFAULT_FILL);
		this.setDefined(DEFAULT_DEFINITION);
		this.setSelector(DEFAULT_IS_SELECTOR);
		this.setVisible(DEFAULT_VISIBILITY);
	}

	public boolean isSelected() {
		return isSelected;
	}

	public void setSelected(boolean isSelected) {
		this.isSelected = isSelected;
	}

	public void setShape(Shape shape) {
		this.shape = shape;
	}

	public Shape getShape() {
		return this.shape;
	}
	
	public boolean isVisible() {
		return isVisible;
	}

	public void setVisible(boolean isVisible) {
		this.isVisible = isVisible;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public boolean isFilled() {
		return isFilled;
	}
	public void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}
	public boolean isDefined() {
		return isDefined;
	}
	public void setDefined(boolean isDefined) {
		this.isDefined = isDefined;
	}
	public boolean isSelector() {
		return isSelector;
	}
	public void setSelector(boolean isSelector) {
		this.isSelector = isSelector;
	}

	@Override
	public void canvasMouseClicked(MouseEvent e) {}

	@Override
	public void canvasMousePressed(MouseEvent e) {}

	@Override
	public void canvasMouseReleased(MouseEvent e) {}

	@Override
	public void canvasMouseMoved(MouseEvent e) {}

	@Override
	public void canvasMouseDragged(MouseEvent e) {}

	public abstract void paint(Graphics graphics);
	public abstract void moveBy(Size size);
	public abstract XShape emptyClone();
}

