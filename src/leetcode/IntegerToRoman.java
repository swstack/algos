package leetcode;

import java.util.HashMap;

public class IntegerToRoman {

	int[] divisors = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
	HashMap<Integer, String> map;

	public String intToRoman(int num) {
		this.map = new HashMap<>();
		this.map.put(1, "I");
		this.map.put(4, "IV");
		this.map.put(5, "V");
		this.map.put(9, "IX");
		this.map.put(10, "X");
		this.map.put(40, "XL");
		this.map.put(50, "L");
		this.map.put(90, "XC");
		this.map.put(100, "C");
		this.map.put(400, "CD");
		this.map.put(500, "D");
		this.map.put(900, "CM");
		this.map.put(1000, "M");

		StringBuilder roman = new StringBuilder();
		while (num > 0) {
			for (int i = divisors.length - 1; i >= 0; i--) {
				int divisor = divisors[i];
				if ((num / divisor) >= 1) {
					roman.append(this.map.get(divisor));
					num -= divisor;
					break;
				}
			}
		}
		return roman.toString();
	}

	public static void main(String[] args) {
		System.out.println(new IntegerToRoman().intToRoman(4));
		System.out.println(new IntegerToRoman().intToRoman(525));
	}
}
