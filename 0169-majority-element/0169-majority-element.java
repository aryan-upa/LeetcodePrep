// Moore's Voting Algorithm

class Solution {
    public int majorityElement(int[] nums) {
        int maj = nums[0];
        int count = 1;
        
        for (int i = 1; i < nums.length; i ++) {
            count += (nums[i] == maj) ? 1 : -1;
            if (count == 0) {
                count = 1;
                maj = nums[i];
            }
        }
        
        return maj;
    }
}