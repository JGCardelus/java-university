package figuras;

public class BasicShapeProperties {
	// Muestro sus propiedades
	public Integer x; // Integer to allow it to be null
	public Integer y;
	public Integer size;
	public String group;

	public static final Integer DEFAULT_INT = null;

	public BasicShapeProperties(String x, String y, String size, String group) {
		this.setX(this.parseInt(x));
		this.setY(this.parseInt(y));
		this.setSize(this.parseInt(size));
		this.setGroup(group);
	}

	public BasicShapeProperties(int x, int y, int size, String group) {
		this.setX(x); // Autoboxing
		this.setY(y);
		this.setSize(size);
		this.setGroup(group);
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public String getGroup() {
		return this.group;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getX() {
		return this.x;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Integer getY() {
		return this.y;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public Integer getSize() {
		return this.size;
	}

	public Integer parseInt(String value) {
		return this.parseInt(value, DEFAULT_INT);
	}
	
	public Integer parseInt(String value, Integer defaultTo) {
		Integer result; 
		try {
			result = Integer.valueOf(value);
		} catch (Exception e) {
			result = defaultTo;
		}
		return result;
	}

	public boolean isShape() {
		boolean isShape = true;
		if (this.x == null || this.y == null || this.size == null) {
			isShape = false;
		}
		return isShape;
	}
}
