package leetcode;

import java.util.HashMap;
import java.util.Stack;

public class HappyNumbers {
	int[] intToArray(int n) {
		Stack<Integer> stack = new Stack<>();
		int tmp = n;
		while (tmp > 0) {
			stack.push(tmp % 10);
			tmp = tmp / 10;
		}

		int[] a = new int[stack.size()];
		for (int i = 0; i < a.length; i++) {
			a[i] = stack.pop();
		}

		return a;
	}

	public boolean isHappyRec(int n, HashMap<Integer, Boolean> pastNums) {
		if (pastNums.getOrDefault(n, false))
			return false;

		if (n < 0)
			return false;

		pastNums.put(n, true);

		int[] intArray = intToArray(n);
		int next = 0;
		for (int i = 0; i < intArray.length; i++) {
			next += Math.pow(intArray[i], 2);
		}

		if (next == 1) {
			return true;
		} else {
			return isHappyRec(next, pastNums);
		}
	}

	public boolean isHappy(int n) {
		HashMap<Integer, Boolean> nums = new HashMap<>();
		return isHappyRec(n, nums);
	}

	public static void main(String[] args) {
//		System.out.println(new HappyNumbers().isHappy(19));
		System.out.println(new HappyNumbers().isHappy(3));
	}
}
