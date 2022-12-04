class Solution {
    public int minimumAverageDifference(int[] nums) {
        long[] left = new long[nums.length];
        long[] right = new long[nums.length];
        
        left[0] = nums[0];
        long sum = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            sum += nums[i];
            left[i] = sum/(i+1);
        }

        right[right.length - 1] = 0;
        sum = nums[nums.length - 1];
        int count = 1;
        for (int i = nums.length - 2; i >= 0; i --) {
            right[i] = sum/count ++;
            sum += nums[i];
        }
        
        long minDiff = Long.MAX_VALUE;
        int idx = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (Math.abs(left[i] - right[i]) < minDiff) {
                idx = i;
                minDiff = Math.abs(left[i] - right[i]);
            }
        }
        
        return idx;
    }
}