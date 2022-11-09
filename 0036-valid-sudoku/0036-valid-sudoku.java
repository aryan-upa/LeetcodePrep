class Solution {
    public boolean isValidSudoku(char[][] b) {
        int rmax = b.length;
        int cmax = b[0].length;
        
        // row check
        for (int i = 0; i < rmax; i ++) {
            int[] occ = new int[12];
            for (int j = 0; j < cmax; j ++) {
                if (b[i][j] != '.' && occ[b[i][j] - 46] == 1)
                    return false;
                else
                    occ[b[i][j] - 46]++;
            }
        }

        // column check
        for (int i = 0; i < cmax; i ++) {
            int[] occ = new int[12];
            for (int j = 0; j < rmax; j ++) {
                if (b[j][i] != '.' && occ[b[j][i] - 46] == 1)
                    return false;
                else
                    occ[b[j][i] - 46]++;
            }
        }        
        
        int[] r = new int[]{0, 3, 6};
        
        // box check
        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j ++) {
                if (!checkBox(r[i], r[j], b))
                    return false;
            }
        }
        
        return true;
    }
    
    public static boolean checkBox(int r, int c, char[][] b) {
        int[] occ = new int[12]; 
        
        for (int i = r; i < r+3; i ++)
            for (int j = c; j < c+3; j++) {
                if (b[i][j] != '.' && occ[b[i][j] - 46] == 1)
                    return false;
                else
                    occ[b[i][j] - 46]++;
            }
        
        return true;
    }
}