class Solution {
    public int maxProduct(int[] nums) {
        int fMax = Integer.MIN_VALUE;
        int sMax = Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] > fMax) {
                sMax = fMax;
                fMax = nums[i];
            }
            else if (nums[i] > sMax) {
                sMax = nums[i];
            }
        }
        // System.out.println(fMax + " " + sMax);
        return (fMax-1)*(sMax-1);
    }
}