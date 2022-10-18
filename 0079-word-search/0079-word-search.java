class Solution {
	static boolean isFound = false;

	public boolean exist(char[][] board, String word) {
        if (board.length == 1 && board[0].length == 1)
            return ("" + board[0][0]).equals(word);
        
        boolean[][] isVisited = new boolean[board.length][board[0].length];
        isFound = false;

		for (int i = 0; i < board.length && !isFound; i ++) {
			for (int j = 0; j < board[0].length && !isFound; j ++)
					existHelper(board, word, "", 0, i, j, isVisited);
		}

		return isFound;
	}

	public void existHelper(char[][] board, String word, String res, int let, int x, int y, boolean[][] isVisited) {
		if (res.equals(word)) {
			isFound = true;
			return;
		}

        if (!isVisited[x][y]) {
            isVisited[x][y] = true;
            if (board[x][y] == word.charAt(let)) {
                if (x > 0) existHelper(board, word, res + word.charAt(let), let + 1, x - 1, y, isVisited);
                if (x < board.length - 1) existHelper(board, word, res + word.charAt(let), let + 1, x + 1, y, isVisited);
                if (y > 0) existHelper(board, word, res + word.charAt(let), let + 1, x, y - 1, isVisited);
                if (y < board[0].length - 1) existHelper(board, word, res + word.charAt(let), let + 1, x, y + 1, isVisited);
            }
            isVisited[x][y] = false;
        }
	}
}