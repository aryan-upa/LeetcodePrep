class Solution {
    static int count;
    public int totalNQueens(int n) {
        count = 0;
        
        boolean[][] board = new boolean[n][n];
        solveBoard(0, board);
        
        return count;
    }
    
    public void solveBoard(int row, boolean[][] board) {
        if (row == board.length) {
            count ++;
            return;
        }
        
        for (int i = 0; i < board.length; i ++) {
            if (isSafe(board, row, i)) {
                board[row][i] = true;
                solveBoard(row + 1, board);
                board[row][i] = false;
            }
        }
    }
    
    public boolean isSafe(boolean[][] board, int row, int col) {
        
        for (int i = 0; i < row; i ++)
            if (board[i][col]) return false;
        
        int i, j;
        
        i = row; j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j]) return false;
            i --;
            j --;
        }
        
        i = row; j = col;
        while (i >= 0 && j < board.length) {
            if (board[i][j]) return false;
            i --;
            j ++;
        }
        
        return true;
    }
    
}