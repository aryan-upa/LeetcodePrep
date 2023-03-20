class Solution {
    public boolean canPlaceFlowers(int[] bed, int n) {
        int canPlace = 0;
        for (int i = 0; i < bed.length; i ++) {
            if (bed[i] != 0)
                continue;
            
            boolean isLeftEmpty = (i == 0) || (bed[i - 1] == 0);
            boolean isRightEmpty = (i == bed.length - 1) || (bed[i + 1] == 0);
            
            if (isLeftEmpty && isRightEmpty) {
                canPlace += 1;
                bed[i] = 1;
                
                if (canPlace >= n)
                    return true;
            }
        }
        
        return canPlace >= n;
    }
}