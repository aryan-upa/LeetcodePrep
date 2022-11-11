class Solution {
    public int removeDuplicates(int[] nums) {
        int pos = 0;

        for (int j = 0; j < nums.length; j++)
            if (nums[j] != nums[pos])
                nums[++pos] = nums[j];
        
        return pos+1;
    }

}