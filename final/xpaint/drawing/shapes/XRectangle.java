package drawing.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import drawing.Point;
import drawing.Size;

public class XRectangle extends TwoAxisShape {
	public void setShape() {
		Point point = this.getPoint();
		Size size = this.getSize();
		this.setShape(new Rectangle(
			point.getX(),
			point.getY(),
			size.getWidth(),
			size.getHeight()
		));
	}

	@Override
	public void setSizeAndPoint(Point startPoint, Point endPoint) {
		super.setSizeAndPoint(startPoint, endPoint);
		this.setShape();
	}

	@Override
	public void moveBy(Size size) {
		super.moveBy(size);
		this.setShape();
	}

	@Override
	public void paint(Graphics graphics) {
		Point point = this.getPoint();
		Size size = this.getSize();

		if (point == null || size == null) return;
		
		if (!this.isDefined()) {
			if (size.getWidth() >= MIN_SIZE.getHeight() && size.getHeight() >= MIN_SIZE.getWidth()) {
				graphics.setColor(UNDEFINED_SHAPE_COLOR);
				graphics.drawRect
								(	
									point.getX(), 
									point.getY(), 
									size.getWidth(), 
									size.getHeight()
								);
			}
		} else {
			if (this.isVisible()) {
				graphics.setColor(this.getColor());
				if (this.isSelected())
					graphics.setColor(SELECTED_COLOR);
				graphics.drawRect
								(	
									point.getX(), 
									point.getY(), 
									size.getWidth(), 
									size.getHeight()
								);
								
				if (this.isFilled()) {
					graphics.fillRect
								(	
									point.getX(), 
									point.getY(), 
									size.getWidth(), 
									size.getHeight()
								);
				}
			}
		}
	}

	@Override
	public XShape emptyClone() {
		return new XRectangle();
	}
}
