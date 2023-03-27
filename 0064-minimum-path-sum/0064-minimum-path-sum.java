class Solution {
    public int minPathSum(int[][] g) {
        int ini = g[0][0];
        int r = g.length;
        int c = g[0].length;

        for (int i = 1; i < r; i ++) {
            g[i][0] = ini + g[i][0];
            ini = g[i][0];
        }

        ini = g[0][0];
        for (int i = 1; i < c; i ++) {
            g[0][i] = ini + g[0][i];
            ini = g[0][i];
        }

        for (int i = 1; i < r; i ++)
            for (int j = 1; j < c; j ++)
                g[i][j] = g[i][j] + Math.min(g[i-1][j], g[i][j-1]);

        return g[r-1][c-1];
    }
}