class Solution {
    public boolean isValidSudoku(char[][] b) {
        int rmax = b.length;
        int cmax = b[0].length;
        
        // row check
        for (int i = 0; i < rmax; i ++) {
            int[] occ = new int[10];
            for (int j = 0; j < cmax; j ++)
                if (b[i][j] != '.') occ[b[i][j] - 48] ++;
            
            for (int count : occ)
                if (count > 1)
                    return false;
        }

        // column check
        for (int i = 0; i < cmax; i ++) {
            int[] occ = new int[10];
            for (int j = 0; j < rmax; j ++)
                if (b[j][i] != '.') occ[b[j][i] - 48] ++;
            
            for (int count : occ)
                if (count > 1)
                    return false;
        }        
        
        int[] r = new int[]{0, 3, 6};
        
        for (int i = 0; i < 3; i ++) {
            for (int j = 0; j < 3; j ++) {
                if (!checkBox(r[i], r[j], b))
                    return false;
            }
        }
        
        return true;
    }
    
    public static boolean checkBox(int r, int c, char[][] b) {
        int[] occ = new int[10]; 
        
        for (int i = r; i < r+3; i ++)
            for (int j = c; j < c+3; j++)
                if (b[i][j] != '.') occ[b[i][j] - 48]++;
        
        for (int count : occ)
            if (count > 1)
                return false;
        
        return true;
    }
}