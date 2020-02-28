package leetcode;

import java.util.Arrays;

public class MaxSubArray {
	public int maxSubArray(int[] nums) {
		int max = 0;
		int maxIdxStart = 0;
		int maxIdxEnd = 0;

		int curMax = nums[0];
		int idxStart = 0;
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
		System.out.println(max);
		return max;
	}

	public static void main(String[] args) {
//		new MaxSubArray().maxSubArray(new int[]{-1, 1, 2, -1, 5, 2, -1});
		new MaxSubArray().maxSubArray(new int[]{3, -1, 1, 5, 1, 1, -1});
	}
}
