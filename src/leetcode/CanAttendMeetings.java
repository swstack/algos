package leetcode;

public class CanAttendMeetings {

	public int[][] sort(int[][] intervals) {
		// Bubble sort
		int[][] sorted = intervals;
		for (int i = 0; i < intervals.length; i++) {
			for (int y = 0; y < intervals.length - 1; y++) {
				int[] left = intervals[y];
				int[] right = intervals[y + 1];
				if (left[0] > right[0]) {
					sorted[y] = right;
					sorted[y + 1] = left;
				} else {
					sorted[y] = left;
					sorted[y + 1] = right;
				}
			}
		}
		return sorted;
	}

	public boolean canAttendMeetings(int[][] intervals) {
		if (intervals.length == 0 || intervals.length == 1)
			return true;

		int[][] sorted = sort(intervals);
		int[] currentMerged = sorted[0];
		boolean result = true;
		for (int i = 1; i < sorted.length; i++) {
			int[] current = sorted[i];
			if (current[0] < currentMerged[1] || current[1] <= currentMerged[1]) {
				result = false;
				break;
			} else {
				currentMerged = current;
			}
		}
		System.out.println(result);
		return result;
	}

	public static void main(String[] args) {
//		new CanAttendMeetings().canAttendMeetings(new int[][]{
//			new int[]{13, 15},
//			new int[]{1, 13},
//		});

		new CanAttendMeetings().canAttendMeetings(new int[][]{
			new int[]{6, 10},
			new int[]{13, 14},
			new int[]{12, 14},
		});
	}
}
