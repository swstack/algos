package recursion;

public class Fibonacci {
	public static int fib(int n, int[] memo) {
		if (n == 0 || n == 1)
			return n;

		if (memo[n] == 0) {
			return fib(n - 1, memo) + fib(n - 2, memo);
		}

		return memo[n];
	}

	public static void main(String[] args) {
		System.out.println(fib(1, new int[1 + 1]));
		System.out.println(fib(2, new int[2 + 1]));
		System.out.println(fib(3, new int[3 + 1]));
		System.out.println(fib(4, new int[4 + 1]));
		System.out.println(fib(9, new int[10 + 1]));
	}
}
