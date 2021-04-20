package drawing;

public class Size {
	private int height;
	private int width;

	public Size(int width, int height) {
		this.height = height;
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	@Override
	public String toString() {
		return "Size [height=" + height + ", width=" + width + "]";
	}
	public static Size getSizeFromPoints(Point a, Point b) {
		return new Size(b.getX() - a.getX(), b.getY() - a.getY());
	}
}
