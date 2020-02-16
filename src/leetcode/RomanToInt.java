package leetcode;

import java.util.HashMap;

public class RomanToInt {
	HashMap<String, Integer> map;

	public int romanToInt(String s) {
		this.map = new HashMap<>();
		this.map.put("I", 1);
		this.map.put("IV", 4);
		this.map.put("V", 5);
		this.map.put("IX", 9);
		this.map.put("X", 10);
		this.map.put("XL", 40);
		this.map.put("L", 50);
		this.map.put("XC", 90);
		this.map.put("C", 100);
		this.map.put("CD", 400);
		this.map.put("D", 500);
		this.map.put("CM", 900);
		this.map.put("M", 1000);

		int total = 0;
		StringBuilder symbol = new StringBuilder();
		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			String symbolCurrent = Character.toString(chars[i]);
			symbol.append(symbolCurrent);
			if (i + 1 < chars.length) {
				String symbolNext = Character.toString(chars[i + 1]);
				if (map.get(symbolCurrent) < map.get(symbolNext)) {
					continue;
				}
			}

			total += map.get(symbol.toString());
			symbol.delete(0, symbol.length());
		}
		return total;
	}

	public static void main(String[] args) {
		System.out.println(new RomanToInt().romanToInt("III"));
		System.out.println(new RomanToInt().romanToInt("X"));
		System.out.println(new RomanToInt().romanToInt("IV"));
	}
}
