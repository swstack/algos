package sorts;

public class BubbleSort {
	int[] sort(int[] unsorted) {
		for (int i = unsorted.length - 1; i > 0; i--) {
			for (int y = 0; y < i; y++) {
				int left = unsorted[y];
				int right = unsorted[y + 1];
				if (right < left) {
					unsorted[y] = right;
					unsorted[y + 1] = left;
				}
			}
		}
		return unsorted;
	}

	public static void main(String[] args) {
		int[] unsorted = new int[]{6, 6, 7, 1, 3, 5, 4, 2, 10, 8, 9};
		int[] sorted = new BubbleSort().sort(unsorted);
		for (int i = 0; i < sorted.length; i++) {
			System.out.print(String.format("%d, ", sorted[i]));
		}
	}
}
