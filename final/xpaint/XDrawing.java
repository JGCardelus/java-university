import java.util.LinkedList;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.Color;

import drawing.CanvasMouseEvents;
import drawing.Point;
import drawing.Size;
import drawing.shapes.XShape;

public class XDrawing implements CanvasMouseEvents {
	private XPaint xpaint;
	private LinkedList<XShape> shapes;
	private LinkedList<XShape> selectedShapes;
	private XShape newShape;

	public XDrawing(XPaint xpaint) {
		shapes = new LinkedList<XShape>();
		this.setXpaint(xpaint);
	}

	public XPaint getXpaint() {
		return xpaint;
	}

	public void clear() {
		this.setShapes(new LinkedList<XShape>());
	}

	public void setXpaint(XPaint xpaint) {
		this.xpaint = xpaint;
	}

	public XShape getNewShape() {
		return newShape;
	}

	public void setNewShape(XShape newShape) {
		this.newShape = newShape;
		if (this.xpaint.getChosenColor() != null) {
			this.newShape.setColor(this.xpaint.getChosenColor());
		}
	}

	public LinkedList<XShape> getShapes() {
		return shapes;
	}

	public void setShapes(LinkedList<XShape> shapes) {
		this.shapes = shapes;
	}

	public void paint(Graphics graphics) {
		if (newShape != null) {
			if (newShape.isDefined()) {
				this.addNewShape();
			} else {
				// If it has been defined, reset
				newShape.paint(graphics);
			}
		}

		for (XShape shape : this.shapes) {
			shape.paint(graphics);
		}
	}

	public void addNewShape() {
		this.newShape.setFilled(true);
		this.shapes.add(newShape);
		this.setNewShape(this.newShape.emptyClone());
	}

	public void selectShapes(Point point) {
		this.selectedShapes = new LinkedList<XShape>();
		for (XShape shape : this.shapes) {
			if (shape.getShape().contains(point.getX(), point.getY())) {
				shape.setSelected(true);
				this.selectedShapes.add(shape);
			} else {
				shape.setSelected(false);
			}
		}
		this.xpaint.paint();
	}

	public void deselectShapes() {
		for (XShape shape : this.shapes) {
			shape.setSelected(false);
		}
		this.selectedShapes = new LinkedList<XShape>();
		this.xpaint.paint();
	}

	private Point lastPosition;
	public void moveSelectedShapes(Point point) {
		if (!this.selectedShapes.isEmpty()) {
			if (this.lastPosition == null) {
				this.lastPosition = point;
			} else {
				Size movement = Size.getSizeFromPoints(lastPosition, point);
				for (XShape shape : this.selectedShapes) {
					shape.moveBy(movement);
				}
				this.xpaint.paint();
				lastPosition = point;
			}
		}
	}

	public void releaseMoveSelectedShapes() {
		this.lastPosition = null;
	}

	private void eraseShape(Point point) {
		LinkedList<XShape> shapesToErase = new LinkedList<XShape>();
		for (XShape shape : this.shapes) {
			if (shape.getShape().contains(point.getX(), point.getY())) {
				shapesToErase.add(shape);
			}
		}
		for (XShape shape : shapesToErase) {
			this.shapes.remove(shape);
		}
		this.xpaint.paint();
	}

	private void colorShape(Point point) {
		for (XShape shape : this.shapes) {
			if (shape.getShape().contains(point.getX(), point.getY())) {
				Color chosenColor = this.xpaint.getChosenColor();
				if (chosenColor != null) {
					shape.setColor(chosenColor);
				}
			}
		}
		this.xpaint.paint();
	}

	@Override
	public void canvasMouseClicked(MouseEvent e) {
		int status = this.xpaint.getStatus();
		Point point = new Point(e.getX(), e.getY());
		if (status == Status.DRAWING_NEW_SHAPE) {
			if (this.newShape != null) {
				this.newShape.canvasMouseClicked(e);
			}
		} else if (status == Status.SELECTING) {
			this.selectShapes(point);
		} else if (status == Status.ERASE) {
			this.eraseShape(point);
		} else if (status == Status.COLOR) {
			this.colorShape(point);
		}
	}

	@Override
	public void canvasMousePressed(MouseEvent e) {
		if (this.xpaint.getStatus() == Status.DRAWING_NEW_SHAPE) {
			if (this.newShape != null) {
				this.newShape.canvasMousePressed(e);
			}
		}
	}

	@Override
	public void canvasMouseReleased(MouseEvent e) {
		int status = this.xpaint.getStatus();
		if (status == Status.DRAWING_NEW_SHAPE) {
			if (this.newShape != null) {
				this.newShape.canvasMouseReleased(e);
				this.xpaint.paint();
			}
		} else if (status == Status.SELECTING) {
			this.releaseMoveSelectedShapes();
		}
	}

	@Override
	public void canvasMouseMoved(MouseEvent e) {
		if (this.xpaint.getStatus() == Status.DRAWING_NEW_SHAPE) {
			if (this.newShape != null) {
				this.newShape.canvasMouseMoved(e);
				this.xpaint.paint();
			}
		}
	}

	@Override
	public void canvasMouseDragged(MouseEvent e) {
		int status = this.xpaint.getStatus();
		if (status == Status.DRAWING_NEW_SHAPE) {
			if (this.newShape != null) {
				this.newShape.canvasMouseDragged(e);
				this.xpaint.paint();
			}
		} else if (status == Status.SELECTING) {
			this.moveSelectedShapes(new Point(e.getX(), e.getY()));
		}
	}
}
