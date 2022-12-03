class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int curr = 0;
        
        for (int i = 0; i < nums.length; i ++) {
            curr = nums[i] == 1 ? curr + 1 : 0;
            max = max > curr ? max : curr;
        }
        
        max = max > curr ? max : curr; 
        return max;
    }
}