public class List<TYPE> {
	private Object objects[]; // Initialize empty
	
	List() {
		this.objects = new Object[0];
	}

	/**
	 * Adds object to the end of the list
	 * @param object
	 */
	public void push(TYPE object) {
		Object objects[] = {object};
		this.add(objects);
		// Error message??
	}

	/**
	 * Adds objects to the end of the list
	 * @param objects
	 */
	public void push(TYPE objects[]) {
		this.add(objects);
	}

	/**
	 * Insert object at index
	 * @param object
	 * @param index
	 */
	public void push(TYPE object, int index) {
		Object objects[] = {object};
		this.insert(objects, index);
	}

	/**
	 * Insert objects at index
	 * @param objects
	 * @param index
	 */
	public void push(TYPE objects[], int index) {
		this.insert(objects, index);
	}

	private void add(Object objects[]) {
		// Allocate memory in array
		this.malloc(objects.length);
		// Copy new elements
		int start = (this.objects.length - objects.length);
		for (int i = start; i < this.objects.length; i++) {
			this.objects[i] = objects[i - start];
		}

		// NOTE:
		// The logic is different than push(objects, index)
		// and it's not reused for performance
	}

	private void insert(Object objects[], int index) {
		// Allocate memory in array
		Object temp[] = this.objects;
		this.objects = new Object[temp.length + objects.length];

		int insertedNew = 0;
		int insertedOld = 0;

		while ((insertedNew + insertedOld) != this.objects.length) {
			// Insert old elements in array until we arrive index or every new element has been inserted
			if ((insertedNew + insertedOld) != index) {
				this.objects[insertedNew + insertedOld] = temp[insertedOld];
				insertedOld++;
			} else {
				// When we arrive at index insert objects until all have been inserted
				if (insertedNew != objects.length) {
					this.objects[insertedNew + insertedOld] = objects[insertedNew];
					insertedNew++;
				}
			}
		}
	}

	public TYPE get(int i) {
		if (i >= 0 && i < this.objects.length) {
			return (TYPE) this.objects[i];
		}
		// Return error, trying to access index out of bounds
		throw new IndexOutOfBoundsException();
	}

	private void malloc(int size) {
		Object temp[] = this.objects;
		this.objects = new Object[temp.length + size];
		for (int i = 0; i < temp.length; i++) {
			this.objects[i] = temp[i];
		}
	}
}
