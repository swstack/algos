package sorts;

public class QuickSort {
	int[] sort(int[] unsorted) {
		return unsorted;
	}

	public static void main(String[] args) {
		int[] unsorted = new int[]{6, 6, 7, 1, 3, 5, 4, 2, 10, 8, 9};
		int[] sorted = new QuickSort().sort(unsorted);
		for (int i = 0; i < sorted.length; i++) {
			System.out.print(String.format("%d, ", sorted[i]));
		}
	}
}
