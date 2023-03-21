class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long total = 0;
        long zCount = 0;
        
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == 0) {
                zCount += 1;
                total += zCount;
                continue;
            }
            
            zCount = 0;
        }
        
        return total;
    }
}