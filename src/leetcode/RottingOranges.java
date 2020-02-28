package leetcode;

import java.util.LinkedList;
import java.util.List;

public class RottingOranges {

	static class GridIndex {
		int i;
		int j;

		GridIndex(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}

	public boolean nextMinute(int[][] grid) {
		// Return false if no moves could be made

		// Iterate the grid saving index of cells that need to be incremented
		List<GridIndex> indexes = new LinkedList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				int cell = grid[i][j];

				// Currently fresh orange
				if (cell == 1) {
					// Check if it borders a rotten orange

					// Left
					if (j - 1 >= 0 && grid[i][j - 1] == 2) {
						indexes.add(new GridIndex(i, j));
					}

					// Right
					if (j + 1 < grid[i].length && grid[i][j + 1] == 2) {
						indexes.add(new GridIndex(i, j));
					}

					// Above
					if (i - 1 >= 0 && grid[i - 1][j] == 2) {
						indexes.add(new GridIndex(i, j));
					}

					// Below
					if (i + 1 < grid.length && grid[i + 1][j] == 2) {
						indexes.add(new GridIndex(i, j));
					}
				}
			}
		}

		for (GridIndex idx : indexes) {
			if (grid[idx.i][idx.j] == 1) {
				grid[idx.i][idx.j]++;
			}
		}

		return indexes.size() > 0;
	}

	public void print(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				int cell = grid[i][j];
				System.out.print(String.format("%d ", cell));
			}
			System.out.println("");
		}
		System.out.println("------------------");

	}

	public int orangesRotting(int[][] grid) {
		print(grid);

		// Run the game board to completion keeping track of minutes
		int minutes = 0;
		while (nextMinute(grid)) {
			// Print grid
			print(grid);
			minutes++;
		}

		// Final sweep of game board checking if all oranges are rotten
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				int cell = grid[i][j];
				if (cell == 1) {
					return -1;
				}
			}
		}

		return minutes;
	}

	public static void main(String[] args) {
		int result = new RottingOranges().orangesRotting(new int[][]{
			new int[]{2, 1, 1},
			new int[]{1, 1, 0},
			new int[]{0, 1, 1},
		});
		System.out.println(result);
	}
}
