package leetcode;

public class MedianSortedArrays {
	public double findMedianSortedArrays(int[] left, int[] right) {
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

		if (merged.length % 2 == 0) {
			double leftMedian = merged[(merged.length / 2) - 1];
			double rightMedian = merged[merged.length / 2];
			return (leftMedian + rightMedian) / 2.0;
		} else {
			return merged[(merged.length / 2)];
		}
	}

	public static void main(String[] args) {
		int[] sorted1 = new int[]{1, 2};
		int[] sorted2 = new int[]{3, 4};
		double median = new MedianSortedArrays().findMedianSortedArrays(sorted1, sorted2);
		System.out.println(median);
	}
}
