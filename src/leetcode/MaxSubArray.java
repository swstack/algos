package leetcode;

import java.util.Arrays;

public class MaxSubArray {
	public int maxSubArray(int[] nums) {
		// Sliding window, if the value of the current index is ever greater
		// than the value of the current window, the window resets.
		int max;

		if (nums.length == 0)
			max = 0;
		else {
			max = nums[0];

			int curMax = nums[0];
			for (int idxEnd = 1; idxEnd < nums.length; idxEnd++) {
				int curr = nums[idxEnd];
				curMax = curMax + curr;
				if (curr > curMax) {
					curMax = curr;
				}

				if (curMax > max) {
					max = curMax;
				}
			}
		}

		System.out.println(max);
		return max;
	}

	public static void main(String[] args) {
		new MaxSubArray().maxSubArray(new int[]{-2, -1});
//		new MaxSubArray().maxSubArray(new int[]{-1, 1, 2, -1, 5, 2, -1});
//		new MaxSubArray().maxSubArray(new int[]{3, -1, 1, 5, 1, 1, -1});
	}
}
