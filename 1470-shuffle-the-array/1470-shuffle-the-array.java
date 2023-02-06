class Solution {
    public int[] shuffle(int[] nums, int n) {
        for (int i = 0; i < n; i ++) {
            nums[i] <<= 10;
            nums[i] |= nums[i + n];
        }
        
        for (int i = n - 1; i >= 0; i --) {
            int val = nums[i];
            nums[2 * i] = val >> 10;
            nums[2 * i + 1] = val & 0x000003ff;
        }
        
        return nums;
    }
}