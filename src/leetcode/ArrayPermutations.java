package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ArrayPermutations {
	public static int[] combineArrays(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		return c;
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> perms = new LinkedList<>();

		if (nums.length == 0) {
			return perms;
		}

		if (nums.length == 1) {
			List<Integer> perm = new LinkedList<>();
			perm.add(nums[0]);
			perms.add(perm);
			return perms;
		}

		for (int i = 0; i < nums.length; i++) {
			int first = nums[i];
			int[] leftSide = Arrays.copyOfRange(nums, 0, i);
			int[] rightSide = Arrays.copyOfRange(nums, i + 1, nums.length);
			int[] combined = combineArrays(leftSide, rightSide);

			for (List<Integer> perm : permute(combined)) {
				perm.add(0, first);
				perms.add(perm);
			}
		}
		return perms;
	}

	public static void main(String[] args) {
		List<List<Integer>> perms = new ArrayPermutations().permute(new int[]{1, 2, 3, 4, 5});
		System.out.println(perms.size());
	}
}
