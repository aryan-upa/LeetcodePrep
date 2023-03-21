class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long total = 0;
        long zCount = 0;
        
        for (int i : nums) {
            zCount = i == 0 ? zCount + 1 : 0;
            total += zCount;
        }
        
        return total;
    }
}