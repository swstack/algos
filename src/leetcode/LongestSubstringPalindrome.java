package leetcode;

public class LongestSubstringPalindrome {
	boolean isPalidrome(String s) {
		if (s.length() == 1 || s.length() == 0)
			return true;

		int idxEnd = s.length() - 1;
		int idxStart = 0;

		while (idxStart < idxEnd) {
			if (s.charAt(idxStart) != s.charAt(idxEnd)) {
				return false;
			}
			idxStart++;
			idxEnd--;
		}
		return true;
	}

	public String longestPalindrome(String s) {
		// Brute force, generate every single substring checking for longest palindrome

		String longestPalindrome = "";
		for (int i = 0; i < s.length(); i++) {
			for (int y = i + 1; y <= s.length(); y++) {
				String substring = s.substring(i, y);
				if (substring.length() > longestPalindrome.length() && isPalidrome(substring)) {
					longestPalindrome = substring;
				}
			}
		}
		System.out.println(String.format("Longest palindrome is %s of length %d", longestPalindrome, longestPalindrome.length()));
		return longestPalindrome;
	}

	public static void main(String[] args) {
		new LongestSubstringPalindrome().longestPalindrome("abcacyz");
		new LongestSubstringPalindrome().longestPalindrome("123312345412");
		new LongestSubstringPalindrome().longestPalindrome("pwwkew");
	}
}
