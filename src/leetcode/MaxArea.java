package leetcode;

public class MaxArea {
	public int maxArea(int[] heights) {
		int maxArea = 0;
		for (int i = 0; i < heights.length; i++) {
			for (int y = i + 1; y < heights.length; y++) {
				int left = heights[i];
				int right = heights[y];
				int height = Math.min(left, right);
				int width = y - i;
				int area = height * width;
				if (area > maxArea) {
					maxArea = area;
				}
			}
		}
		return maxArea;
	}

	public static void main(String[] args) {
		System.out.println(new MaxArea().maxArea(new int[]{1, 8, 6, 2}));
	}
}
