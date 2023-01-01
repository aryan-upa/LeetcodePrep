class Solution {
	static int count;
	static int sx, sy;

	public int uniquePathsIII(int[][] grid) {
		count = 0;
		int blockedCount = 0;
		int m = grid.length, n = grid[0].length;

		sx = sy = 0;
		for (int i = 0; i < m; i ++) {
			for (int j = 0; j < n; j ++) {
				switch (grid[i][j]) {
					case 1: sx = i; sy = j; break;
					case -1: blockedCount ++; break;
					default: break;
				}
			}
		}

		countPath(sx, sy, grid, blockedCount);

		return count;
	}

	public void countPath(int row, int col, int[][] grid, int blockCount) {
		if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == -1)
			return;

		if (grid[row][col] == 2) {
			if (blockCount == grid.length*grid[0].length - 1)
				count++;
			return;
		}

		int[][] trav = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		for (int[] dir : trav) {
			grid[row][col] = -1;
			countPath(row + dir[0], col + dir[1], grid, blockCount + 1);
			grid[row][col] = 0;
		}
	}
}