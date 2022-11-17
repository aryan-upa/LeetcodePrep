// Moore's Voting Algorithm

class Solution {
    public int majorityElement(int[] nums) {
        int maj_ind = 0;
        int count = 1;
        
        for (int i = 1; i < nums.length; i ++) {
            count += (nums[i] == nums[maj_ind]) ? 1 : -1;
            if (count == 0) {
                count = 1;
                maj_ind = i;
            }
        }
        
        return nums[maj_ind];
    }
}