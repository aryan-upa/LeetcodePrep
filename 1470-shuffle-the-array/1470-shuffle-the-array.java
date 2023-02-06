class Solution {
    public int[] shuffle(int[] nums, int n) {
        for (int i = 0; i < n; i ++) {
            int store = nums[i];
            store <<= 10;
            store |= nums[i + n];
            nums[i] = store;
        }
        
        for (int i = n - 1; i >= 0; i --) {
            int val = nums[i];
            nums[2 * i] = val >> 10;
            nums[2 * i + 1] = val & 0x000003ff;
        }
        
        return nums;
    }
}