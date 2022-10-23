class Solution {
    public int[] findErrorNums(int[] nums) {
        int[] occurances = new int[nums.length + 1];
        
        int repeated = 0;
        
        for (int i = 0; i < nums.length; i ++) {
            if (occurances[nums[i]] == 1)
                repeated = nums[i];

            occurances[nums[i]]++; 
        }
        
        for (int i = 1; i <= nums.length; i ++) {
            if (occurances[i] == 0)
                return new int[]{repeated, i};
        }
        
        return null;
    }
}