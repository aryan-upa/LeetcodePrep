class Solution {
    public int rob(int[] nums) {
        int[] t = new int[nums.length + 1];

        t[0] = 0;
        t[1] = nums[0];

        for (int i = 2; i <= nums.length; i ++) {
            int st = nums[i-1] + t[i - 2];
            int sk = t[i-1];
            t[i] = Math.max(st, sk);
        }

        return t[nums.length];
    }
}