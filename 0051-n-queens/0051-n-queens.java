class Solution {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();

		boolean[][] board = new boolean[n][n];
		solveBoard(n, board, 0, res);

		return res;
	}

	public void solveBoard(int n, boolean[][] board, int row, List<List<String>> res) {
		if (n == 0) {
			res.add(convertToStringList(board));
			return;
		}

		for (int i = 0; i < board.length; i ++) {
			if (isSafe(board, row, i)) {
				board[row][i] = true;
				solveBoard(n-1, board, row + 1, res);
				board[row][i] = false;
			}
		}
	}

	public boolean isSafe(boolean[][] board, int row, int col) {

		// checking column above
		for (int i = 0; i <= row; i ++)
			if (board[i][col])
				return false;

		// checking left top diagonal
		int i = row, j = col;
		while (i >= 0 && j >= 0) {
			if (board[i][j]) return false;
			i --;
			j --;
		}

		// checking right top diagonal
		i = row;
		j = col;
		while (i >= 0 && j < board.length) {
			if (board[i][j]) return false;
			i --;
			j ++;
		}

		return true;
	}

	public ArrayList<String> convertToStringList (boolean[][] board) {
		ArrayList<String> res = new ArrayList<>();

		for (boolean[] bools : board) {
			StringBuilder str = new StringBuilder();
			for (boolean bool : bools)
				str.append(bool ? "Q" : ".");
			res.add(str.toString());
		}

		return res;
	}
}