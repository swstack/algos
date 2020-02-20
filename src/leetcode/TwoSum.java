package leetcode;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int y = 1; y < nums.length; y++) {
				if (nums[i] + nums[y] == target && i != y) {
					result[0] = i;
					result[1] = y;
					return result;
				}
			}
		}
		return result;
	}

	public int[] twoSumSlidingWindow(int[] nums, int target) {
		// Sliding window O(n) (only works for indexs next to eachother, wont pass
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			int left = nums[i];
			if (i + 1 < nums.length) {
				int right = nums[i + 1];
				if (left + right == target) {
					result[0] = i;
					result[1] = i + 1;
					return result;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9);
	}
}
