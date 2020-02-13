//Given a string, find the length of the longest substring without repeating characters.
//
//	Example 1:
//
//	Input: "abcabcbb"
//	Output: 3
//	Explanation: The answer is "abc", with the length of 3.
//	Example 2:
//
//	Input: "bbbbb"
//	Output: 1
//	Explanation: The answer is "b", with the length of 1.
//	Example 3:
//
//	Input: "pwwkew"
//	Output: 3
//	Explanation: The answer is "wke", with the length of 3.
//	Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

package leetcode;

import java.util.HashMap;

public class LongestSubstringNoRepeats {
	public int lengthOfLongestSubstringBruteForce(String s) {
		int longest = 0;
		String longestSubstring = "";
		for (int i = 0; i < s.length(); i++) {
			for (int y = i + 1; y <= s.length(); y++) {
				String substring = s.substring(i, y);
				HashMap<Character, Boolean> map = new HashMap<>();
				boolean hasDupe = false;
				for (char c : substring.toCharArray()) {
					if (map.containsKey(c)) {
						hasDupe = true;
						break;
					} else {
						map.put(c, true);
					}
				}
				if (substring.length() > longest && !hasDupe) {
					longest = substring.length();
					longestSubstring = substring;
				}
			}
		}
		System.out.println(String.format("Longest substring '%s' of length %d", longestSubstring, longest));
		return longest;
	}

	public int lengthOfLongestSubstring(String s) {
		// Map of chars and their index
		HashMap<Character, Integer> chars = new HashMap<>();
		int idxCurrentStart = 0;
		int idxCurrentEnd = 0;
		String longestSub = "";
		for (int i = 0; i < s.length(); i++) {
			idxCurrentEnd++;
			Character c = s.charAt(i);
			if (chars.containsKey(c)) {
				int newCurStart = chars.get(c) + 1;
				idxCurrentStart = Math.max(newCurStart, idxCurrentStart);
			}
			chars.put(c, i);

			String curSub = s.substring(idxCurrentStart, idxCurrentEnd);
			if (curSub.length() > longestSub.length()) {
				longestSub = curSub;
			}

		}
		System.out.println(String.format("Longest substring '%s' of length %d", longestSub, longestSub.length()));
		return longestSub.length();
	}

	public static void main(String[] args) {
		new LongestSubstringNoRepeats().lengthOfLongestSubstring("abcad");
		new LongestSubstringNoRepeats().lengthOfLongestSubstring("123312345412");
		new LongestSubstringNoRepeats().lengthOfLongestSubstring("pwwkew");
	}
}
