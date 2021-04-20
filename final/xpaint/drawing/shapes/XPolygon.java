package drawing.shapes;

import java.util.LinkedList;
import java.util.List;

import drawing.Point;
import drawing.Size;

import java.awt.event.MouseEvent;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Polygon;

public class XPolygon extends XShape {
	private LinkedList<Point> points;

	private static final Color MAGNET_COLOR = Color.RED;

	public static final int MAGNET_DISTANCE = 30;
	private Point fillerPoint;

	public XPolygon() {
		this.setPoints(new LinkedList<>());
	}

	public LinkedList<Point> getPoints() {
		return points;
	}

	public void setPoints(LinkedList<Point> points) {
		this.points = points;
	}

	public int getDistanceToStart(Point a) {
		if (!this.points.isEmpty()) {
			Point start = this.points.get(0);
			return this.getDistance(start, a);
		} else {
			return -1;
		}
	}

	/**
	 * Euclidian distance between two points
	 * @param a
	 * @param b
	 * @return
	 */
	public int getDistance(Point a, Point b) {
		return (int) Math.sqrt(Math.pow(a.getX() - b.getX(), 2) + Math.pow(a.getY() - b.getY(), 2));
	}

	@Override
	public void canvasMouseClicked(MouseEvent e) {
		if (!this.isDefined()) {
			Point point = new Point(e.getX(), e.getY());
			if (this.points.size() < 3) {
				this.points.add(point);
			} else {
				int distance = this.getDistanceToStart(point);
				if (distance <= MAGNET_DISTANCE) {
					Polygon polygon = XPolygon.createPolygonFromPoints(points);
					this.setShape(polygon);
					this.setDefined(true);

				} else {
					this.points.add(point);
				}
			}
		}
	}	

	@Override
	public void canvasMouseMoved(MouseEvent e) {
		if (!this.isDefined()) {
			this.fillerPoint = new Point(e.getX(), e.getY());
		}
	}

	public static Polygon createPolygonFromPoints(List<Point> points) {
		Polygon polygon = new Polygon();
		for (Point polyPoint : points) {
			polygon.addPoint(polyPoint.getX(), polyPoint.getY());
		}
		return polygon;
	}

	private void paintUndefined(Graphics graphics) {
		if (this.points.size() > 1) {
			graphics.setColor(UNDEFINED_SHAPE_COLOR);
			for (int i = 1; i < this.points.size(); i++) {
				Point last = this.points.get(i-1);
				Point now = this.points.get(i);
				graphics.drawLine(last.getX(), last.getY(), now.getX(), now.getY());
			}
		}

		if (!this.points.isEmpty() && this.fillerPoint != null) {
			Point last = this.points.get(this.points.size() - 1);
			Point now = this.fillerPoint;
			graphics.drawLine(last.getX(), last.getY(), now.getX(), now.getY());
		}

		if (this.points.size() > 1 && this.fillerPoint != null) {
			int distance = this.getDistanceToStart(this.fillerPoint);
			if (distance <= MAGNET_DISTANCE) {
				Point start = this.points.get(0);
				graphics.setColor(MAGNET_COLOR);
				graphics.drawOval(start.getX() - MAGNET_DISTANCE / 2, start.getY() - MAGNET_DISTANCE / 2, MAGNET_DISTANCE, MAGNET_DISTANCE);
			}
		}
	}

	@Override
	public void moveBy(Size size) {
		for (Point point : this.points) {
			point.moveBy(size);
		}
		Polygon polygon = XPolygon.createPolygonFromPoints(points);
		this.setShape(polygon);
	}

	@Override
	public void paint(Graphics graphics) {
		if (!this.isDefined()) {
			this.paintUndefined(graphics);
		} else {
			if (this.isVisible()) {
				Polygon poly = (Polygon) this.getShape();
				graphics.setColor(this.getColor());
				if (this.isSelected())
					graphics.setColor(SELECTED_COLOR);
				graphics.drawPolygon(poly);
				
				if (this.isFilled()) {
					graphics.fillPolygon(poly);
				}
			}
		}
	}

	@Override
	public XShape emptyClone() {
		return new XPolygon();
	}
}
