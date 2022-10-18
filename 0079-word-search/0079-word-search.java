class Solution {
	static boolean isFound = false;

	public boolean exist(char[][] board, String word) {
       isFound = false;

		for (int i = 0; i < board.length && !isFound; i ++) {
			for (int j = 0; j < board[0].length && !isFound; j ++)
					existHelper(board, word, "", 0, i, j);
		}

		return isFound;
	}

	public void existHelper(char[][] board, String word, String res, int let, int x, int y) {
        if (!isFound && board[x][y] == word.charAt(let)) { 
            board[x][y] ^= 256;

            res = res + word.charAt(let);
            let += 1;

            if (res.equals(word)) {
                isFound = true;
                return;
            }
            
            if (x > 0) 
                existHelper(board, word, res, let, x - 1, y);
            
            if (x < board.length - 1)
                existHelper(board, word, res, let, x + 1, y);
            
            if (y > 0)
                existHelper(board, word, res, let, x, y - 1);
            
            if (y < board[0].length - 1)
                existHelper(board, word, res, let, x, y + 1);
            
            board[x][y] ^= 256;
        }
	}
}