class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] isVisited = new boolean[m][n];
        
        // travelling first and last row
        for (int i = 0; i < n; i ++)
            if (grid[0][i] == 1 && !isVisited[0][i])
                dfs (m, n, 0, i, grid, isVisited);
        
        for (int i = 0; i < n; i ++)
            if (grid[m-1][i] == 1 && !isVisited[m-1][i])
                dfs (m, n, m-1, i, grid, isVisited);
        
        // travelling first and last column
        for (int i = 0; i < m; i ++)
            if (grid[i][0] == 1 && !isVisited[i][0])
                dfs (m, n, i, 0, grid, isVisited);
        
        for (int i = 0; i < m; i ++)
            if (grid[i][n-1] == 1 && !isVisited[i][n-1])
                dfs (m, n, i, n - 1, grid, isVisited);
        
        int landCount = 0;
        for (int i = 0; i < m; i ++)
            for (int j = 0; j < n; j ++)
                if (grid[i][j] == 1 && !isVisited[i][j])
                    landCount += 1;
        
        return landCount;
    }
    
    public void dfs (int maxR, int maxC, int i, int j, int[][] grid, boolean[][] isVisited) {
        if (i < 0 || j < 0 || i >= maxR || j >= maxC || grid[i][j] == 0 || isVisited[i][j])
            return;
        
        isVisited[i][j] = true;
        
        int[][] trav = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        
        for (int[] dxn : trav)
            dfs (maxR, maxC, i + dxn[0], j + dxn[1], grid, isVisited);
    }
}