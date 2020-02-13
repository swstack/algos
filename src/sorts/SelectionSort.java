package sorts;

public class SelectionSort {
	int[] sort(int[] unsorted) {

		for (int i = 0; i < unsorted.length; i++) {

			int smallest = unsorted[i];
			int smallestIdx = i;
			for (int y = i; y < unsorted.length; y++) {
				if (unsorted[y] < smallest) {
					smallest = unsorted[y];
					smallestIdx = y;
				}
			}

			// Swap
			int tmp = unsorted[i];
			unsorted[i] = smallest;
			unsorted[smallestIdx] = tmp;
		}

		return unsorted;
	}

	public static void main(String[] args) {
		int[] unsorted = new int[]{7, 1, 3, 5, 4, 2, 10, 8, 9};
		int[] sorted = new SelectionSort().sort(unsorted);
		for (int i = 0; i < sorted.length; i++) {
			System.out.print(String.format("%d, ", sorted[i]));
		}
	}
}
