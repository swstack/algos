package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class ValidParens {
	public boolean isValidParens(String s) {
		// Keep track of a weight, adding and subtracting given ( or ), weight must equal 0 at end
		// Note: Only works for a single type of paren symbol

		char[] validChars = new char[] {'(', ')'};
		char[] chars = s.toCharArray();
		int weight = 0;
		for (char c : chars) {
			if (!Arrays.asList(validChars).contains(c)) {
				weight = -1;
				break;
			}

			if (c == '(')
				weight++;

			if (c == ')')
				weight--;

			if (weight < 0)
				break;
		}

		return weight == 0;
	}

	public boolean isValid(String s) {
		// Keep track of a weight, adding and subtracting given ( or ), weight must equal 0 at end
		// Note: Only works for a single type of paren symbol

		List<Character> validChars = Arrays.asList('(', ')', '[', ']', '{', '}');
		HashMap<Character, Character> matches = new HashMap<>();
		matches.put('(', ')');
		matches.put(')', '(');
		matches.put('[', ']');
		matches.put(']', '[');
		matches.put('{', '}');
		matches.put('}', '{');
		char[] chars = s.toCharArray();
		boolean result = true;
		Stack<Character> stack = new Stack<>();
		for (char c : chars) {
			if (!validChars.contains(c)) {
				result = false;
				break;
			}

			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
				continue;
			}

			if (stack.isEmpty()) {
				result = false;
				break;
			}

			char val = stack.pop();
			if (matches.get(val) != c) {
				result = false;
				break;
			}
		}

		if (!stack.isEmpty()) {
			result = false;
		}

		return result;
	}

	public static void main(String[] args) {
//		System.out.println(new ValidParens().isValid("()"));
//		System.out.println(new ValidParens().isValid("())"));
//		System.out.println(new ValidParens().isValid("()()"));
//		System.out.println(new ValidParens().isValid("(())"));
		System.out.println(new ValidParens().isValid("()(()"));
		System.out.println(new ValidParens().isValid("([{}])"));
		System.out.println(new ValidParens().isValid("({})[]"));
		System.out.println(new ValidParens().isValid("([{)}]"));
	}
}
