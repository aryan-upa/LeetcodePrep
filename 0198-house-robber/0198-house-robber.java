class Solution {
    public int rob(int[] nums) {
        return robHelperBU(nums);
    }
    
	public static int robHelperBU (int[] homes) {
		if (homes.length == 1)
			return homes[0];

		int[] dp = new int[homes.length];
		dp[0] = homes[0];
		dp[1] = Math.max(homes[0], homes[1]);

		for (int i = 2; i < homes.length; i ++)
			dp[i] = Math.max(dp[i-1], homes[i] + dp[i-2]);

		return dp[homes.length - 1];
	}
}