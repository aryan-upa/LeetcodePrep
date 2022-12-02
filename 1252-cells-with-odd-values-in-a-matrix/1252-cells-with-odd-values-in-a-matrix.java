class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        
        /*
            not applying the very clear brute force approach in which we travel an entire row and column 
            each time theres an operation on one of it's cell

            The idea is to store the operation which has to be performed on any row or column beforehand
            then apply all of them in one go.
            
            In last, just calculate the number of odds.
        */
        int[] rowop = new int[m];
        int[] colop = new int[n];
        
        for (int[] index : indices) {
            rowop[index[0]] ++;
            colop[index[1]] ++;
        }
        
        int[][] arr = new int[m][n];
        
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                arr[i][j] = rowop[i];
            }
        }
        
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                arr[j][i] = arr[j][i] + colop[i];
            }
        }
        
        int count = 0;
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++)
                count += arr[i][j] % 2 != 0 ? 1 : 0;
        }

        return count;
    }
}