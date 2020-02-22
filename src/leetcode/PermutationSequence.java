package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationSequence {
	public static int[] combineArrays(int[] a, int[] b) {
		int[] c = new int[a.length + b.length];
		System.arraycopy(a, 0, c, 0, a.length);
		System.arraycopy(b, 0, c, a.length, b.length);
		return c;
	}

	public static int factorial(int x) {
		int total = 1;
		for (int i = 1; i <= x; i++) {
			total = i * total;
		}
		return total;
	}

	public List<List<Integer>> permute(int[] nums, int targetFirstValue) {
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
			if (targetFirstValue < 0 || first == targetFirstValue) {
				int[] leftSide = Arrays.copyOfRange(nums, 0, i);
				int[] rightSide = Arrays.copyOfRange(nums, i + 1, nums.length);
				int[] combined = combineArrays(leftSide, rightSide);

				for (List<Integer> perm : permute(combined, -1)) {
					perm.add(0, first);
					perms.add(perm);
				}
			}

		}
		return perms;
	}

	public String getPermutationBruteForce(int n, int k) {
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}
		List<List<Integer>> perms = permute(nums, 0);
		List<Integer> targetPerm = perms.get(k - 1);

		StringBuilder out = new StringBuilder();
		for (int i : targetPerm) {
			out.append(String.format("%d", i));
		}

		return out.toString();
	}

	public String getPermutation(int n, int k) {
		// Given the target k, and an understanding of the order of permutations, we can calculate
		// which digit will be first in that iteration of permutations.

		int totalPossiblePermutations = factorial(n);
		if (n < 1 || n > totalPossiblePermutations) {
			return "";
		}

		int permutationsPerIteration = totalPossiblePermutations / n;
		int targetFirstValue = (int) Math.ceil(k / (double) permutationsPerIteration);

		int idxWithinIteration;
		int rem = k % permutationsPerIteration;
		if (rem > 0) {
			idxWithinIteration = rem - 1;
		} else {
			idxWithinIteration = permutationsPerIteration - 1;
		}

		// Build nums array
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = i + 1;
		}

		List<List<Integer>> perms = permute(nums, targetFirstValue);
		System.out.println(perms);
		List<Integer> targetPerm = perms.get(idxWithinIteration);

		StringBuilder out = new StringBuilder();
		for (int i : targetPerm) {
			out.append(String.format("%d", i));
		}

		String result = out.toString();
		System.out.println(result);
		return result;
	}

	public static void main(String[] args) {
		new PermutationSequence().getPermutation(5, 3);
	}
}
