class Solution {
    public int change(int amount, int[] coins) {
        return coinChangeDP (amount, coins);
    }
    
    public int coinChangeDP (int amount, int[] coins) {
        int[][] dp = new int[coins.length + 1][amount + 1];

		for (int i = 0; i < dp.length; i ++)
			dp[i][0] = 1;

		for (int i = 1; i < dp.length; i ++) {
			for (int am = 1; am < dp[0].length; am ++) {
				int ans = 0;
				if (coins[i-1] <= am)
					ans += dp[i][am - coins[i - 1]];
				ans += dp[i - 1][am];
				dp[i][am] = ans;
			}
		}

		return dp[coins.length][amount];
    }
}