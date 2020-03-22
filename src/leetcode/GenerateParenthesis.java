package leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
	public List<String> generateParenthesis(int n) {
		List<String> combinations = new ArrayList<>();
		generateAll(new char[2 * n], 0, combinations);
		System.out.println(combinations);
		return combinations;
	}

	public void generateAll(char[] current, int pos, List<String> result) {
		// Brute force, generate all combinations, only adding valid ones to result

		if (pos == current.length) {
			if (valid(current))
				result.add(new String(current));
		} else {
			current[pos] = '(';
			generateAll(current, pos + 1, result);
			current[pos] = ')';
			generateAll(current, pos + 1, result);
		}
	}

	public boolean valid(char[] current) {
		// Validate by making sure the string is balanced,
		// i.e. For every left paren there must be a right paren

		int balance = 0;
		for (char c : current) {
			if (c == '(') balance++;
			else balance--;
			if (balance < 0) return false;
		}
		return (balance == 0);
	}

	public static void main(String[] args) {
		new GenerateParenthesis().generateParenthesis(3);
	}
}
