package drawing.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Ellipse2D;

import drawing.Point;
import drawing.Size;

public class XOval extends TwoAxisShape {
	public static final int OVAL_CORRECTION = 1;

	public void setShape() {
		Point point = this.getPoint();
		Size size = this.getSize();
		this.setShape(new Ellipse2D.Float(
			(float) point.getX(),
			(float) point.getY(),
			(float) size.getWidth(),
			(float) size.getHeight()
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
				graphics.drawOval
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

				graphics.drawOval
								(	
									point.getX(), 
									point.getY(), 
									size.getWidth(), 
									size.getHeight()
								);
								
				if (this.isFilled()) {
					graphics.fillOval
								(	
									point.getX(), 
									point.getY(), 
									size.getWidth() + OVAL_CORRECTION, 
									size.getHeight() + OVAL_CORRECTION
								);
				}
			}
		}
	}

	@Override
	public XShape emptyClone() {
		return new XOval();
	}
}
