package leetcode;

import java.util.Arrays;

public class MergeIntervals {

	public int[][] sort(int[][] intervals) {
		// Bubble sort

		for (int i = 0; i < intervals.length; i++) {
			for (int y = 0; y < intervals.length - 1; y++) {
				int[] left = intervals[y];
				int[] right = intervals[y + 1];
				if (left[0] > right[0]) {
					intervals[y] = right;
					intervals[y + 1] = left;
				} else {
					intervals[y] = left;
					intervals[y + 1] = right;
				}
			}
		}
		return intervals;
	}

	public int[][] merge(int[][] intervals) {
		// Sort the intervals based on their start value, iterate each interval comparing
		// the start value with the previous interval end value

		if (intervals.length == 0)
			return intervals;

		int[][] sorted = sort(intervals);

		int[][] mergedInts = new int[intervals.length][2];

		int merged = 0;
		int[] currentMerged = sorted[0];
		for (int i = 1; i < sorted.length; i++) {
			int[] current = sorted[i];
			if (current[0] <= currentMerged[1]) {
				if (current[1] >= currentMerged[1]) {
					currentMerged[1] = current[1];
				}
			} else {
				mergedInts[merged] = currentMerged;
				merged++;
				currentMerged = current;
			}
		}
		mergedInts[merged] = currentMerged;
		merged++;

		int[][] result = new int[merged][2];
		System.arraycopy(mergedInts, 0, result, 0, result.length);
		for (int[] m : result) {
			System.out.println(Arrays.toString(m));
		}
		return result;
	}

	public static void main(String[] args) {
		new MergeIntervals().merge(new int[][]{
			new int[]{1, 3},
			new int[]{2, 6},
			new int[]{8, 10},
			new int[]{15, 18}
		});

		new MergeIntervals().merge(new int[][]{
			new int[]{1, 4},
			new int[]{0, 4},
		});

		new MergeIntervals().merge(new int[][]{
			new int[]{1, 3},
		});

		new MergeIntervals().merge(new int[][]{
			new int[]{1, 4},
			new int[]{1, 4},
		});

		new MergeIntervals().merge(new int[][]{
			new int[]{1, 4},
			new int[]{2, 3},
		});
	}
}
