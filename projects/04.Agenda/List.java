/**
 * Variable length list
 * v.1
 * 
 * Features of v.1:
 * 		-> Can push, pop, clear, set, get and slice objects
 * 		-> You can only add objects of class TYPE
 * 		-> all() returns all objects in the list (as Object), slice too
 * 
 * Possible improvements for v.2:
 * 		-> Return arrays of class TYPE (Array.copy??)
 * 		-> Add iterators to be able to do foreachs like the cool kids
 * 		-> Improve malloc, add, insert and remove so they are more
 * 			efficient, (use Arrays??)
 */

public class List<TYPE> {
	private Object objects[]; // Initialize empty
	
	/**
	 * Start with two elements in the list
	 * @param objects
	 */
	List(TYPE objects[])  {
		this.push(objects);
	}

	/**
	 * Start with one element in the list
	 * @param object
	 */
	List(TYPE object) {
		this.push(object);
	}

	/**
	 * Start with an empty list
	 */
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

	/**
	 * Remove the last element in the list and return it
	 * @return
	 */
	public TYPE pop() {
		return this.remove(this.objects.length - 1);
	}

	/**
	 * Remove the specified index from the list and return it
	 * @param index
	 * @return
	 */
	public TYPE pop(int index) {
		return this.remove(index);
	}

	public TYPE pop(TYPE object) {
		int index = this.indexOf(object);
		return this.pop(index);
	}

	/**
	 * Clears the list
	 */
	public void clear() {
		this.objects = new Object[0];
	}

	/**
	 * Return the length of the list
	 * @return
	 */
	public int length() {
		return this.objects.length;
	}

	/**
	 * Private method that handles the logic of removing an {@link Object}
	 * @param index
	 * @return
	 */
	private TYPE remove(int index) {
		if (index >= 0 && index < this.objects.length) {
			Object temp[] = this.objects;
			this.objects = new Object[temp.length - 1];

			// Will never return null
			TYPE removed = null;

			boolean found = false;
			for (int i = 0; i < temp.length; i++) {
				int a = i;
				if (i == index) {
					found = true;
					removed = (TYPE) temp[i];
				} else {
					if (found) a--;
					this.objects[a] = temp[i]; 
				}
			}

			return removed;
		}
		return null;
		
	}

	public void set(int index, TYPE object) {
		if (index >= 0 && index < this.objects.length) {
			this.objects[index] = object;
		}
	}

	/**
	 * Private method that handles the logic of adding an {@link Object}.
	 * It's privatize because it allows any object to be passed, while push
	 * (the public method) on allows for {@link TYPE} to be passed.
	 * @param objects
	 */
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

	/**
	 * Private method that handles the logic of inserting an {@link Object}.
	 * It's privatize because it allows any object to be passed, while push
	 * (the public method) on allows for {@link TYPE} to be passed.
	 * @param objects
	 * @param index
	 */
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

	/**
	 * Gets the element stored in the index passed
	 * @param index
	 * @return
	 */
	public TYPE get(int index) {
		if (index >= 0 && index < this.objects.length) {
			// No downcasting check because it's impossible for 
			// another Class to be stored (check push method)
			return (TYPE) this.objects[index];
		}
		return null;
	}

	/**
	 * Returns all objects
	 * @return
	 */
	public Object[] all() {
		return this.objects;
	}

	/**
	 * Return objects from start to end - 1
	 * @param object
	 * @return
	 */
	public Object[] slice(int start, int end) {
		if (start < end && end <= this.objects.length) {
			Object[] sliced = new Object[end-start];	
			for (int i = start; i < end; i++) {
				sliced[i - start] = this.objects[i];
			}
			return sliced;
		}
		return new Object[]{};
	}

	/**
	 * Returns if the list contains the object passed
	 * @param object
	 * @return
	 */
	public boolean includes(TYPE object) {
		for (Object challengeObject:this.objects) {
			if (object.equals((TYPE) challengeObject)) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Returns the index at which an object is stored. In case there are
	 * duplicates, it returns the first coincidence.
	 * @param object
	 * @return
	 */
	public int indexOf(TYPE object) {
		for (int i = 0;i < this.objects.length; i++) {
			TYPE challengeObject = (TYPE) this.objects[i];
			if (object.equals(challengeObject)) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * Private method that generates the memory in the array
	 * @param size
	 */
	private void malloc(int size) {
		Object temp[] = this.objects;
		this.objects = new Object[temp.length + size];
		for (int i = 0; i < temp.length; i++) {
			this.objects[i] = temp[i];
		}
	}
}
