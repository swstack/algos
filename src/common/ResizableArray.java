package common;

public class ResizableArray<T> {
	Object[] staticArray;

	public ResizableArray() {
		staticArray = new Object[10];
	}

	public T get(int index) {
		if (index >= staticArray.length) {
			return null;
		} else {
			return (T)staticArray[index];
		}
	}

	public void insert(int index, T value) {
		if (index >= staticArray.length) {
			// New array with double the length
			Object[] newArray = new Object[staticArray.length * 2];

			// Copy old array to new array ... every time this happens insert is O(n), normally O(1)
			// ... still amortized as O(1)
			for (int i = 0; i < staticArray.length; i++) {
				newArray[i] = staticArray[i];
			}

			staticArray = newArray;
		} else {
			staticArray[index] = value;
		}
	}

	public int size() {
		return staticArray.length;
	}

	public void print() {
		for (int i = 0; i < staticArray.length; i ++) {
			System.out.println(String.format("%d: %s", i, staticArray[i]));
		}
	}

	public static void main(String[] args) {
		ResizableArray<String> array = new ResizableArray<>();

		// Insert
		array.insert(0, "foo");
		array.print();
		array.insert(4, "foo");
		array.print();

		// Resize
		array.insert(12, "foo");
		array.print();
	}
}
