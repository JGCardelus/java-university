public class Point {
	
	int x;
	int y;

	Point(int x,int y) {
		this.setX(x);
		this.setY(y);
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void print() {
		System.out.println(this.getX() + ", " + this.getY());
	}
}
