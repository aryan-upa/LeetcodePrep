class Solution {
	static boolean isFound = false;
	static int wordLen;
    
	public boolean exist(char[][] board, String word) {
		isFound = false;

		wordLen = word.length();
		for (int i = 0; i < board.length && !isFound; i ++) {
			for (int j = 0; j < board[0].length && !isFound; j ++)
				existHelper(board, word, 0, i, j);
		}

		return isFound;
	}

	public void existHelper(char[][] board, String word, int let, int x, int y) {
		if (board[x][y] == word.charAt(let)) {
			board[x][y] ^= 256;

			let += 1;

			if (let == wordLen) {
				isFound = true;
				return;
			}

			if (x > 0 && !isFound)
				existHelper(board, word, let, x - 1, y);

			if (x < board.length - 1 && !isFound)
				existHelper(board, word, let, x + 1, y);

			if (y > 0 && !isFound)
				existHelper(board, word, let, x, y - 1);

			if (y < board[0].length - 1 && !isFound)
				existHelper(board, word, let, x, y + 1);

			board[x][y] ^= 256;
		}
	}
}