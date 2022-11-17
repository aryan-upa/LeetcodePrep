class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        
        int minR = 0, minC = 0, maxR = n - 1, maxC = n - 1;
        int tot = n * n, pted = 0;
        
        while (pted < tot) {            
            for (int i = minC; i <= maxC; i ++)
                mat[minR][i] = ++pted;
            
            minR ++;
            if (pted >= tot) break;
            
            for (int i = minR; i <= maxR; i ++)
                mat[i][maxC] = ++pted;

            if (pted >= tot) break;
            maxC --;

            for (int i = maxC; i >= minC; i --)
                mat[maxR][i] = ++pted;
                
            if (pted >= tot) break;
            maxR --;

            for (int i = maxR; i >= minR; i --)
                mat[i][minC] = ++pted;
            
            minC++;
        }
        
        return mat;
    }
}