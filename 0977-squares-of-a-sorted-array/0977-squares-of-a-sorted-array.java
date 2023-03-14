class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int r = nums.length - 1;
        int l = 0;
        int idx = nums.length - 1;
        
        while (l <= r) {
            int lSq = nums[l] * nums[l];
            int rSq = nums[r] * nums[r];
            
            if (lSq < rSq) {
                res[idx] = rSq;
                r -= 1;
            } else {
                res[idx] = lSq;
                l += 1;
            }
            idx -= 1;
        }
        
        return res;
    }
}