package leetcode;

import java.util.Arrays;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int y = 1; y < nums.length; y++) {
				if (nums[i] + nums[y] == target && i != y) {
					result[0] = i;
					result[1] = y;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(result));
		return result;
	}

	public int[] twoSumSlidingWindow(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int left = nums[i];
			if (i + 1 < nums.length) {
				int right = nums[i + 1];
				if (left + right == target) {
					result[0] = i;
					result[1] = i + 1;
					break;
				}
			}
		}
		System.out.print(Arrays.toString(result));
		return result;
	}

	public static void main(String[] args) {
		new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9);
		new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 13);
	}
}
