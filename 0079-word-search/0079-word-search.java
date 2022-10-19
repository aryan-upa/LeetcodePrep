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
        
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(let))
            return;
        
        board[x][y] ^= 256;

        let += 1;
        
        if (let == wordLen) {
            isFound = true;
            return;
        }
        
        int[] r = {-1, 1, 0, 0};
        int[] c = {0, 0, -1, 1};

        for (int i = 0; i < c.length; i ++)
            existHelper(board, word, let, x + r[i], y + c[i]);
        
        board[x][y] ^= 256;
    }
}