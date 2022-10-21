class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0, max = nums.length;

        for (int i = 0; i < max; i ++) {
            xor ^= i;
            xor ^= nums[i];
        }
        
        return xor ^= max;
        
//         for (int i = 0; i <= max; i ++)
//             xor ^= i;
        
//         System.out.println(xor);
        
//         for (int i = 0; i <= max - 1; i ++)
//             xor ^= nums[i];
        
//         return xor;
    }
}