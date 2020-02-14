package leetcode;

public class Atoi {
	public int myAtoiCasting(String str) {
		if (str.equals("")) {
			return 0;
		}
		int result;
		String sanitized = str.trim().replace(" ", "");
		if (Character.isAlphabetic(sanitized.charAt(0))) {
			result = 0;
		} else {
			int idxEnd = sanitized.length() - 1;
			while (Character.isAlphabetic(sanitized.charAt(idxEnd))) {
				sanitized = sanitized.substring(0, idxEnd);
				idxEnd--;
			}

			if (sanitized.contains(".")) {
				return 0;
			}

			try {
				result = Integer.valueOf(sanitized);
			} catch (NumberFormatException e) {
				if (sanitized.startsWith("-")) {
					result = Integer.MIN_VALUE;
				} else {
					result = Integer.MAX_VALUE;
				}
			}
		}

		System.out.println(String.format("Result is %d", result));
		return result;
	}

	public int myAtoi(String str) {
		if (str.equals("")) {
			return 0;
		}

		String sanitized = str.trim().replace(" ", "");
		if (Character.isAlphabetic(sanitized.charAt(0))) {
			return 0;
		}

		boolean negative = false;
		if (sanitized.charAt(0) == '-') {
			negative = true;
			sanitized = sanitized.substring(1);
		}

		if (sanitized.charAt(0) == '+') {
			sanitized = sanitized.substring(1);
		}

		long result = 0;
		for (int i = 0; i < sanitized.length(); i++) {
			char c = sanitized.charAt(i);

			if (Character.isDigit(c)) {
				long tmp = (result * 10) + Character.getNumericValue(c);
				result = (result * 10) + Character.getNumericValue(c);
			} else {
				break;
			}
		}

		if (negative) {
			result = -result;
		}

		if (result < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}

		if (result > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}

		return (int) result;
	}

	public static void main(String[] args) {
		System.out.println(new Atoi().myAtoi("-42"));
		System.out.println(new Atoi().myAtoi("42"));
		System.out.println(new Atoi().myAtoi("   42"));
		System.out.println(new Atoi().myAtoi("   -42"));
		System.out.println(new Atoi().myAtoi("-91283472332"));
		System.out.println(new Atoi().myAtoi("-4193 with words"));
		System.out.println(new Atoi().myAtoi("4193 with words"));
		System.out.println(new Atoi().myAtoi("asdf4193 with words"));
		System.out.println(new Atoi().myAtoi("-91283472332 with words"));
	}
}
