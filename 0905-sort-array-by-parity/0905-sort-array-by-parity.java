class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0, right = -1;
        int n = nums.length;
        
        while (++ right < n) {
            if ((nums[right] & 1) == 1)
                continue;
                        
            int temp = nums[left];

            nums[left] = nums[right];
            nums[right] = temp;
            left += 1;
        }

        return nums;
    }
}