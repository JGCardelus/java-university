package shapes;

import drawing.CanvasMouseEvents;
import io.IOShape;
import utils.ColorTools;

import java.awt.event.MouseEvent;
import java.lang.ProcessBuilder.Redirect;
import java.util.LinkedList;
import java.util.List;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Shape;


public abstract class XShape implements CanvasMouseEvents, IOShape, java.io.Serializable {
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
		this.setDefaults();
	}	

	public void setDefaults() {
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

	public String attributesToCsv() {
		StringBuilder csvData = new StringBuilder();
		csvData.append(this.color.getRed()).append(",");
		csvData.append(this.color.getGreen()).append(",");
		csvData.append(this.color.getBlue()).append(",");
		csvData.append(this.isVisible).append(",");
		csvData.append(this.isFilled);
		return csvData.toString();
	}

	public Point getPointFromCsv(List<String> chunks) {
		Point point = null;
		try {
			int x = Integer.parseInt(chunks.get(1));
			int y = Integer.parseInt(chunks.get(2));

			point = new Point(x,y);
		} catch (Exception e) {
			point = new Point(0,0);
		}
		return point;
	}

	public Size getSizeFromCsv(List<String> chunks) {
		Size size = null;
		try {
			int width = Integer.parseInt(chunks.get(3));
			int height = Integer.parseInt(chunks.get(4));

			size = new Size(width, height);
		} catch (Exception e) {
			size = new Size(0,0);
		}
		return size;
	}

	public void setAttributesFromCsv(List<String> chunks) {
		try {
			int red = Integer.parseInt(chunks.get(5));
			int green = Integer.parseInt(chunks.get(6));
			int blue = Integer.parseInt(chunks.get(7));

			Color color = ColorTools.rbgToColor(red, green, blue);
			this.setColor(color);

			this.setVisible(Boolean.parseBoolean(chunks.get(8)));
			this.setFilled(Boolean.parseBoolean(chunks.get(9)));
		} catch (Exception e) {
			this.setDefaults();
		}
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

	@Override
	public String toString() {
		return "XShape [color=" + color + ", isDefined=" + isDefined + ", isFilled=" + isFilled + ", isVisible="
				+ isVisible + "]";
	}

	public abstract void paint(Graphics graphics);
	public abstract void moveBy(Size size);
	public abstract XShape emptyClone();
}

