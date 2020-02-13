package sorts;

import java.util.Arrays;

public class MergeSort {

	int[] merge(int[] left, int[] right) {
		int[] merged = new int[left.length + right.length];
		int idxLeft = 0;
		int idxRight = 0;
		int mergedIdx = 0;
		while (idxLeft < left.length || idxRight < right.length) {
			int leftVal;
			if (idxLeft >= left.length) {
				// Guaranteed to be greater than right
				leftVal = right[idxRight] + 1;
			} else {
				leftVal = left[idxLeft];
			}

			int rightVal;
			if (idxRight >= right.length) {
				// Guaranteed to be greater than left
				rightVal = left[idxLeft] + 1;
			} else {
				rightVal = right[idxRight];
			}

			if (leftVal < rightVal) {
				merged[mergedIdx] = leftVal;
				idxLeft++;
			} else {
				merged[mergedIdx] = rightVal;
				idxRight++;
			}
			mergedIdx++;
		}
		return merged;
	}

	int[] sort(int[] unsorted) {
		if (unsorted.length == 1) {
			return unsorted;
		}

		int[] left = Arrays.copyOfRange(unsorted, 0, unsorted.length / 2);
		int[] right = Arrays.copyOfRange(unsorted, (unsorted.length / 2), unsorted.length);

		int[] leftSorted = sort(left);
		int[] rightSorted = sort(right);

		return merge(leftSorted, rightSorted);
	}

	public static void main(String[] args) {
		int[] unsorted = new int[]{6, 6, 7, 1, 3, 5, 4, 2, 10, 8, 9};
		int[] sorted = new MergeSort().sort(unsorted);
		for (int i = 0; i < sorted.length; i++) {
			System.out.print(String.format("%d, ", sorted[i]));
		}
	}
}