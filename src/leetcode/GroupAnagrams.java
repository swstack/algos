package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		// Hash map of sorted strings

		HashMap<String, List<String>> anagrams = new HashMap<>();
		for (int i = 0; i < strs.length; i++) {
			char[] charArray = strs[i].toCharArray();
			Arrays.sort(charArray);
			String str = new String(charArray);

			List<String> list = anagrams.getOrDefault(str, new LinkedList<>());
			list.add(strs[i]);
			anagrams.put(str, list);
		}

		List<List<String>> result = new LinkedList<>(anagrams.values());
		System.out.println(result);
		return result;
	}

	public static void main(String[] args) {
		new GroupAnagrams().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
	}
}
