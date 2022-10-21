class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        
        double difY = coordinates[1][1] - coordinates[0][1];
        double difX = coordinates[1][0] - coordinates[0][0];
        
        double slope = 0;

        slope = difX == 0 ? Double.POSITIVE_INFINITY : difY / difX;

        for (int i = 2; i < coordinates.length; i ++) {
            difY = coordinates[i][1] - coordinates[i-1][1];
            difX = coordinates[i][0] - coordinates[i-1][0];
            
            double currSlope = difX == 0 ? Double.POSITIVE_INFINITY : difY / difX;
            
            if (currSlope != slope)
                return false;
        }
        return true;
    }
}