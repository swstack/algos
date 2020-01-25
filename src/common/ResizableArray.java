package common;

public class ResizableArray<T> {
	Object[] staticArray;

	public ResizableArray() {
		staticArray = new Object[5];
	}

	@SuppressWarnings("unchecked")
	public T get(int index) {
		return (T)staticArray[index];
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

	public static void main(String[] args) {
		ResizableArray<String> array = new ResizableArray<>();

		// Insert/get
		array.insert(0, "foo");
		assert array.get(0).equals("foo");

		// Resize
		assert array.size() == 5;
		array.insert(4, "foo");
		assert array.size() == 5;
		array.insert(5, "foo");
		assert array.size() == 10;
	}
}
