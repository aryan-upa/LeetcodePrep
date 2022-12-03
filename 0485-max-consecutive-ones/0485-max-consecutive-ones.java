class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int curr = 0;
        
        for (int i : nums) {
            curr = i == 1 ? curr + 1 : 0;
            max = max > curr ? max : curr;
        }
        
        max = max > curr ? max : curr; 
        return max;
    }
}