class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int maxR = matrix.length - 1;
        int maxC = matrix[0].length - 1;
        
        while (maxR >= 0) {
            int prevElement = matrix[maxR][0];
            int r = maxR, c = 0;
            while (r < matrix.length && c < matrix[0].length) {
                if (matrix[r][c] != prevElement)
                    return false;
                r ++; 
                c ++;
            }
            maxR --;
        }
        
        while (maxC > 0) {
            int prevElement = matrix[0][maxC];
            int r = 0, c = maxC;
            while (c < matrix[0].length && r < matrix.length) {
                if (matrix[r][c] != prevElement)
                    return false;
                r ++;
                c ++;
            }
            maxC --;
        }
        
        return true;
    }
}