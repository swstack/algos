package recursion;

import java.util.Arrays;

public class PowerSet {
	public static void powerSetIterative(int[] set) {
		for (int i = 0; i <= set.length; i++) {
			for (int y = i; y <= set.length; y++) {
				int[] subset = Arrays.copyOfRange(set, i, y);
				System.out.println(Arrays.toString(subset));
			}
		}
	}

	public static void main(String[] args) {
		new PowerSet().powerSetIterative(new int[]{1, 2, 3});
	}
}
